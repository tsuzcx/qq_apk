package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;

final class ScanMaskView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanMaskView$1(ScanMaskView paramScanMaskView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ScanMaskView.b(this.nLs).left += (int)(ScanMaskView.c(this.nLs) * f);
    ScanMaskView.b(this.nLs).right += (int)(ScanMaskView.d(this.nLs) * f);
    ScanMaskView.b(this.nLs).top += (int)(ScanMaskView.e(this.nLs) * f);
    paramValueAnimator = ScanMaskView.a(this.nLs);
    int i = ScanMaskView.b(this.nLs).bottom;
    paramValueAnimator.bottom = ((int)(f * ScanMaskView.f(this.nLs)) + i);
    this.nLs.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView.1
 * JD-Core Version:    0.7.0.1
 */