package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Random;

class HydraGUI extends JFrame {
    private JPanel panel;
    private final JButton cut;
    private final ImageIcon icon;
    private final JLabel bild;
    private final JLabel botschaft;
    private Random rand = new Random();
    private GraphicsDevice gd;
    private final Font font;

    HydraGUI() throws HeadlessException {
        //Titel und Größe des Frames
        setTitle("Hydra.exe");
        setSize(500, 150);

        //Hole Auflösungen von Monitor
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        //Setze Position an zufälliger Stelle auf Basis der Bildschirmauflösung
        setLocation(rand.nextInt(gd.getDisplayMode().getWidth()), rand.nextInt(gd.getDisplayMode().getHeight()) );

        //Lade Icon für Taskbar
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/img/hydra128.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Initialisierung und Positionierung der Attribute
        icon = new ImageIcon(Class.class.getResource("/img/hydra.png"));
        font = new Font(Font.SANS_SERIF, Font.BOLD, 12);
        panel = new JPanel();
        bild = new JLabel();
        bild.setBounds(30, 25, icon.getIconWidth(), icon.getIconHeight());
        botschaft = new JLabel("Wenn du Hydra den Kopf abschlägst, wachsen direkt 2 neue nach.");
        botschaft.setFont(font);
        botschaft.setBounds(100,15, 400, 30);
        cut = new JButton("Beschneiden");
        cut.setFont(font);
        cut.setBounds(175, 60, 150, 30);
        bild.setIcon(icon);

        //Füge das Panel dem Frame hinzu
        setContentPane(panel);
        panel.setLayout(null);
        panel.add(bild);
        panel.add(cut);
        panel.add(botschaft);

        //Funktion die ausgeführt wird, wenn das Fenster über das Kreuz (X) geschlossen wird
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                fuckUp();
            }
        });

        //Funktion wenn der Button gedrückt wird
        cut.addActionListener(e -> {
            fuckUp();
            this.dispose();
        });

        setVisible(true);
    }

    //Methode welche zwei neue HydraGUIs startet
    private void fuckUp() {
        HydraGUI frame1 = new HydraGUI();
        HydraGUI frame2 = new HydraGUI();
    }
}
