package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.d;

final class h$3
  implements ValueAnimator.AnimatorUpdateListener
{
  h$3(h paramh) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(145696);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfq.sfo.sgi.setAlpha(f);
    this.sfq.sfo.sgj.setAlpha(f);
    AppMethodBeat.o(145696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h.3
 * JD-Core Version:    0.7.0.1
 */