package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.plugin.d.a.c;

final class AppChooserUI$b
{
  ImageView leS;
  TextView leT;
  TextView leV;
  TextView sll;
  RadioButton slm;
  
  public AppChooserUI$b(AppChooserUI paramAppChooserUI, View paramView)
  {
    this.leS = ((ImageView)paramView.findViewById(a.c.app_icon));
    this.leT = ((TextView)paramView.findViewById(a.c.app_name));
    this.leV = ((TextView)paramView.findViewById(a.c.app_desc));
    this.sll = ((TextView)paramView.findViewById(a.c.app_status));
    this.slm = ((RadioButton)paramView.findViewById(a.c.app_radio));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.b
 * JD-Core Version:    0.7.0.1
 */