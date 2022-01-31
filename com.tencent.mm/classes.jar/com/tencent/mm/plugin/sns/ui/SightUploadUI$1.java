package com.tencent.mm.plugin.sns.ui;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightUploadUI$1
  implements Runnable
{
  SightUploadUI$1(SightUploadUI paramSightUploadUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(38583);
    SightUploadUI.a(this.rLy).setWidth((int)(this.rLx * 0.7D));
    SightUploadUI.b(this.rLy).setLayoutParams(new LinearLayout.LayoutParams((int)(this.rLx * 0.3D), SightUploadUI.b(this.rLy).getHeight()));
    AppMethodBeat.o(38583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.1
 * JD-Core Version:    0.7.0.1
 */