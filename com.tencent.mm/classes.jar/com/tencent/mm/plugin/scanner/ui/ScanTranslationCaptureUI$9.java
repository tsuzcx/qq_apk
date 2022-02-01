package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;

final class ScanTranslationCaptureUI$9
  implements DialogInterface.OnClickListener
{
  ScanTranslationCaptureUI$9(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(120875);
    b.cs(this.ISv);
    this.ISv.finish();
    AppMethodBeat.o(120875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.9
 * JD-Core Version:    0.7.0.1
 */