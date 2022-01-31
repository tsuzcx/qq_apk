package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.b;

final class d$2
  implements ValueAnimator.AnimatorUpdateListener
{
  d$2(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40017);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfh.seU.sfR.setAlpha(f);
    AppMethodBeat.o(40017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d.2
 * JD-Core Version:    0.7.0.1
 */