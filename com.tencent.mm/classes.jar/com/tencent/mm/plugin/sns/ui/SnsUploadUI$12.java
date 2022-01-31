package com.tencent.mm.plugin.sns.ui;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUploadUI$12
  implements Runnable
{
  SnsUploadUI$12(SnsUploadUI paramSnsUploadUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39749);
    SnsUploadUI.12.1 local1 = new SnsUploadUI.12.1(this);
    if (SnsUploadUI.e(this.sbR) != null) {
      SnsUploadUI.e(this.sbR).setOnDragListener(local1);
    }
    AppMethodBeat.o(39749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.12
 * JD-Core Version:    0.7.0.1
 */