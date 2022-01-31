package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class ScanMaskView$2
  extends AnimatorListenerAdapter
{
  ScanMaskView$2(ScanMaskView paramScanMaskView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (ScanMaskView.g(this.nLs) != null) {
      ScanMaskView.g(this.nLs).onAnimationEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView.2
 * JD-Core Version:    0.7.0.1
 */