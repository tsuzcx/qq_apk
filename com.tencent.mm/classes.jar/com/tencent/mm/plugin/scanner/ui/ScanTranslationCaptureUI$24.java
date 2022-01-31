package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;

final class ScanTranslationCaptureUI$24
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanTranslationCaptureUI$24(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f <= 0.1F) {
      ScanTranslationCaptureUI.q(this.nNm).setAlpha(f * 10.0F);
    }
    for (;;)
    {
      ScanTranslationCaptureUI.q(this.nNm).setTranslationY(f * (ScanTranslationCaptureUI.r(this.nNm) - ScanTranslationCaptureUI.q(this.nNm).getHeight()));
      return;
      if (f >= 0.9F) {
        ScanTranslationCaptureUI.q(this.nNm).setAlpha((1.0F - f) * 10.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.24
 * JD-Core Version:    0.7.0.1
 */