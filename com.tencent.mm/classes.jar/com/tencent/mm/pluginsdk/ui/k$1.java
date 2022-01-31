package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$1
  implements ValueAnimator.AnimatorUpdateListener
{
  k$1(k paramk) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(27542);
    k.a(this.vSc, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.vSc.invalidateSelf();
    AppMethodBeat.o(27542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.k.1
 * JD-Core Version:    0.7.0.1
 */