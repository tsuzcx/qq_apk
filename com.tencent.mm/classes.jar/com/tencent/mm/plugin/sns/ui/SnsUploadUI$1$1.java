package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUploadUI$1$1
  implements Runnable
{
  SnsUploadUI$1$1(SnsUploadUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(39735);
    SnsUploadUI.a(this.sbS.sbR).baa();
    SnsUploadUI.a(this.sbS.sbR).postInvalidate();
    SnsUploadUI.b(this.sbS.sbR).postInvalidate();
    AppMethodBeat.o(39735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.1.1
 * JD-Core Version:    0.7.0.1
 */