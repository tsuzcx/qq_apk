package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class ScanTranslationCaptureUI$15
  implements DialogInterface.OnClickListener
{
  ScanTranslationCaptureUI$15(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.nNm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.15
 * JD-Core Version:    0.7.0.1
 */