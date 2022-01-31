package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.scanner.util.h;

final class ScanTranslationCaptureUI$18
  implements View.OnClickListener
{
  ScanTranslationCaptureUI$18(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    ScanTranslationCaptureUI.f(this.nNm).a(this.nNm);
    ScanTranslationCaptureUI.g(this.nNm)[1] = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.h(this.nNm)[0]));
    ScanTranslationCaptureUI.g(this.nNm)[0] = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.18
 * JD-Core Version:    0.7.0.1
 */