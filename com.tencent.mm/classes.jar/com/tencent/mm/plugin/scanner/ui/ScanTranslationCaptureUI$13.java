package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScanTranslationCaptureUI$13
  implements DialogInterface.OnClickListener
{
  ScanTranslationCaptureUI$13(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(120879);
    ScanTranslationCaptureUI.z(this.ISv);
    this.ISv.finish();
    this.ISv.overridePendingTransition(0, 0);
    AppMethodBeat.o(120879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.13
 * JD-Core Version:    0.7.0.1
 */