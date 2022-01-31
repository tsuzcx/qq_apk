package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class ScanTranslationCaptureUI$13
  implements DialogInterface.OnClickListener
{
  ScanTranslationCaptureUI$13(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.nNm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    ScanTranslationCaptureUI.A(this.nNm);
    this.nNm.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.13
 * JD-Core Version:    0.7.0.1
 */