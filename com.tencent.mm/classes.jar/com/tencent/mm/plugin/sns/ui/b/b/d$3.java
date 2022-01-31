package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.a.a;

final class d$3
  implements ValueAnimator.AnimatorUpdateListener
{
  d$3(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40055);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfw.sfu.shX.setAlpha(f);
    AppMethodBeat.o(40055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d.3
 * JD-Core Version:    0.7.0.1
 */