package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.h.a;

final class g$3
  implements ValueAnimator.AnimatorUpdateListener
{
  g$3(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(145703);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfB.sfA.sfT.setAlpha(f);
    this.sfB.sfA.sfU.setAlpha(f);
    AppMethodBeat.o(145703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g.3
 * JD-Core Version:    0.7.0.1
 */