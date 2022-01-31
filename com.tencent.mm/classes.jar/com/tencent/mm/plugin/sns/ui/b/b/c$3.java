package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.a.a;

final class c$3
  implements ValueAnimator.AnimatorUpdateListener
{
  c$3(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40048);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfv.sfu.shX.setAlpha(f);
    AppMethodBeat.o(40048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.c.3
 * JD-Core Version:    0.7.0.1
 */