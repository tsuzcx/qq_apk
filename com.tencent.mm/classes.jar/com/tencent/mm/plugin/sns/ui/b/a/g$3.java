package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.d;

final class g$3
  implements ValueAnimator.AnimatorUpdateListener
{
  g$3(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(145690);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfp.sfo.sgi.setAlpha(f);
    this.sfp.sfo.sgj.setAlpha(f);
    AppMethodBeat.o(145690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g.3
 * JD-Core Version:    0.7.0.1
 */