package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUploadUI$1$2
  implements Runnable
{
  SnsUploadUI$1$2(SnsUploadUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(39736);
    SnsUploadSayFooter localSnsUploadSayFooter = SnsUploadUI.a(this.sbS.sbR);
    if (!localSnsUploadSayFooter.bad()) {
      localSnsUploadSayFooter.setVisibility(8);
    }
    SnsUploadUI.a(this.sbS.sbR).postInvalidate();
    SnsUploadUI.c(this.sbS.sbR).postInvalidate();
    AppMethodBeat.o(39736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.1.2
 * JD-Core Version:    0.7.0.1
 */