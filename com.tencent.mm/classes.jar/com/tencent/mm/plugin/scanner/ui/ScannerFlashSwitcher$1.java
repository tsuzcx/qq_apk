package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;

final class ScannerFlashSwitcher$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ScannerFlashSwitcher$1(ScannerFlashSwitcher paramScannerFlashSwitcher) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ScannerFlashSwitcher.a(this.nNt).setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.1
 * JD-Core Version:    0.7.0.1
 */