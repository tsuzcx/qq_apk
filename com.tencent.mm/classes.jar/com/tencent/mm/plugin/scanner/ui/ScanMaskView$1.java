package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScanMaskView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ScanMaskView$1(ScanMaskView paramScanMaskView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(81147);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ScanMaskView.b(this.qyX).left += (int)(ScanMaskView.c(this.qyX) * f);
    ScanMaskView.b(this.qyX).right += (int)(ScanMaskView.d(this.qyX) * f);
    ScanMaskView.b(this.qyX).top += (int)(ScanMaskView.e(this.qyX) * f);
    paramValueAnimator = ScanMaskView.a(this.qyX);
    int i = ScanMaskView.b(this.qyX).bottom;
    paramValueAnimator.bottom = ((int)(f * ScanMaskView.f(this.qyX)) + i);
    this.qyX.invalidate();
    AppMethodBeat.o(81147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView.1
 * JD-Core Version:    0.7.0.1
 */