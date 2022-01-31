package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

final class ScanTranslationCaptureUI$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanTranslationCaptureUI$3(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = ScanTranslationCaptureUI.s(this.nNm).getHeight();
    i = ((RelativeLayout.LayoutParams)ScanTranslationCaptureUI.s(this.nNm).getLayoutParams()).bottomMargin + i;
    ScanTranslationCaptureUI.s(this.nNm).setTranslationY(i * f);
    int j = ScanTranslationCaptureUI.t(this.nNm).getHeight();
    int k = ((RelativeLayout.LayoutParams)ScanTranslationCaptureUI.t(this.nNm).getLayoutParams()).bottomMargin;
    ScanTranslationCaptureUI.t(this.nNm).setTranslationY((k + (j + i)) * f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.3
 * JD-Core Version:    0.7.0.1
 */