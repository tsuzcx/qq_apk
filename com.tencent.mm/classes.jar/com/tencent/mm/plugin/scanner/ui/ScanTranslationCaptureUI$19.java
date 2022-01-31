package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.j;

final class ScanTranslationCaptureUI$19
  implements View.OnClickListener
{
  ScanTranslationCaptureUI$19(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81276);
    ScanTranslationCaptureUI.h(this.qAW).a(this.qAW);
    ScanTranslationCaptureUI.j(this.qAW).cSL = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.i(this.qAW)[0]));
    ScanTranslationCaptureUI.j(this.qAW).cSK = 1L;
    AppMethodBeat.o(81276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.19
 * JD-Core Version:    0.7.0.1
 */