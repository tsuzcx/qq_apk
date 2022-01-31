package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R.k;

final class ScanTranslationCaptureUI$20
  implements View.OnClickListener
{
  ScanTranslationCaptureUI$20(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    if (ScanTranslationCaptureUI.i(this.nNm) == 3)
    {
      if (ScanTranslationCaptureUI.j(this.nNm) != null) {
        ScanTranslationCaptureUI.a(this.nNm, ScanTranslationCaptureUI.j(this.nNm), ScanTranslationCaptureUI.k(this.nNm));
      }
      if (ScanTranslationCaptureUI.l(this.nNm).equalsIgnoreCase("zh_CN"))
      {
        ScanTranslationCaptureUI.m(this.nNm).setImageResource(R.k.translation_result_chinese_highlighted);
        ScanTranslationCaptureUI.a(this.nNm, 2);
        paramView = ScanTranslationCaptureUI.g(this.nNm);
        paramView[6] += 1;
      }
    }
    while (ScanTranslationCaptureUI.i(this.nNm) != 2) {
      for (;;)
      {
        return;
        ScanTranslationCaptureUI.m(this.nNm).setImageResource(R.k.translation_result_english_highlighted);
      }
    }
    if (ScanTranslationCaptureUI.n(this.nNm) != null) {
      ScanTranslationCaptureUI.a(this.nNm, ScanTranslationCaptureUI.n(this.nNm), ScanTranslationCaptureUI.k(this.nNm));
    }
    if (ScanTranslationCaptureUI.l(this.nNm).equalsIgnoreCase("zh_CN")) {
      ScanTranslationCaptureUI.m(this.nNm).setImageResource(R.k.translation_result_chinese);
    }
    for (;;)
    {
      ScanTranslationCaptureUI.a(this.nNm, 3);
      return;
      ScanTranslationCaptureUI.m(this.nNm).setImageResource(R.k.translation_result_english);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.20
 * JD-Core Version:    0.7.0.1
 */