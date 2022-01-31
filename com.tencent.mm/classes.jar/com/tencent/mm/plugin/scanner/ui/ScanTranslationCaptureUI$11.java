package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ScanTranslationCaptureUI$11
  implements DialogInterface.OnClickListener
{
  ScanTranslationCaptureUI$11(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ScanTranslationCaptureUI.y(this.nNm);
    this.nNm.finish();
    this.nNm.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.11
 * JD-Core Version:    0.7.0.1
 */