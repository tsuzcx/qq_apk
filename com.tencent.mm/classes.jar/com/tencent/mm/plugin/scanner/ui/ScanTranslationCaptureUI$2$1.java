package com.tencent.mm.plugin.scanner.ui;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.y;

final class ScanTranslationCaptureUI$2$1
  implements Camera.AutoFocusCallback
{
  ScanTranslationCaptureUI$2$1(ScanTranslationCaptureUI.2 param2) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    y.i("MicroMsg.ScanTranslationCaptureUI", "camera auto focus call back");
    ScanTranslationCaptureUI.f(this.nNn.nNm).cancelAutoFocus();
    ScanTranslationCaptureUI.f(this.nNn.nNm).byu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.2.1
 * JD-Core Version:    0.7.0.1
 */