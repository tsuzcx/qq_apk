package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScanMaskView$2
  extends AnimatorListenerAdapter
{
  ScanMaskView$2(ScanMaskView paramScanMaskView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(81148);
    super.onAnimationEnd(paramAnimator);
    if (ScanMaskView.g(this.qyX) != null) {
      ScanMaskView.g(this.qyX).onAnimationEnd();
    }
    AppMethodBeat.o(81148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView.2
 * JD-Core Version:    0.7.0.1
 */