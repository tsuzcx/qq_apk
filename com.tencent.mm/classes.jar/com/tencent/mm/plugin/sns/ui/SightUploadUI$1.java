package com.tencent.mm.plugin.sns.ui;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

final class SightUploadUI$1
  implements Runnable
{
  SightUploadUI$1(SightUploadUI paramSightUploadUI, int paramInt) {}
  
  public final void run()
  {
    SightUploadUI.a(this.oTB).setWidth((int)(this.oTA * 0.7D));
    SightUploadUI.b(this.oTB).setLayoutParams(new LinearLayout.LayoutParams((int)(this.oTA * 0.3D), SightUploadUI.b(this.oTB).getHeight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.1
 * JD-Core Version:    0.7.0.1
 */