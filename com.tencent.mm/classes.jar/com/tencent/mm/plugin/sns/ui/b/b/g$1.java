package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.h.a;

final class g$1
  implements ValueAnimator.AnimatorUpdateListener
{
  g$1(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(145701);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.sfB.sfA.rMB.setScaleX(f);
      this.sfB.sfA.rMB.setScaleY(f);
      this.sfB.sfA.rMB.setAlpha(f);
    }
    AppMethodBeat.o(145701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g.1
 * JD-Core Version:    0.7.0.1
 */