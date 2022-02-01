package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$13
  implements ValueAnimator.AnimatorUpdateListener
{
  y$13(y paramy) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(249138);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.adEy.aAn(i);
    AppMethodBeat.o(249138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.y.13
 * JD-Core Version:    0.7.0.1
 */