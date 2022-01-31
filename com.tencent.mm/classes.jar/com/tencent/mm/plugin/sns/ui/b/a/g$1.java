package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.d;

final class g$1
  implements ValueAnimator.AnimatorUpdateListener
{
  g$1(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(145688);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.sfp.sfo.rMB.setScaleX(f);
      this.sfp.sfo.rMB.setScaleY(f);
      this.sfp.sfo.rMB.setAlpha(f);
    }
    AppMethodBeat.o(145688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g.1
 * JD-Core Version:    0.7.0.1
 */