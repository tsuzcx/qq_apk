package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.h.a;

final class h$3
  implements ValueAnimator.AnimatorUpdateListener
{
  h$3(h paramh) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(145710);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfC.sfA.sfT.setAlpha(f);
    this.sfC.sfA.sfU.setAlpha(f);
    AppMethodBeat.o(145710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h.3
 * JD-Core Version:    0.7.0.1
 */