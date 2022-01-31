package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.d;

final class h$1
  implements ValueAnimator.AnimatorUpdateListener
{
  h$1(h paramh) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(145695);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0F)
    {
      this.sfq.sfo.rMB.setScaleX(f);
      this.sfq.sfo.rMB.setScaleY(f);
      this.sfq.sfo.rMB.setAlpha(f);
    }
    AppMethodBeat.o(145695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h.1
 * JD-Core Version:    0.7.0.1
 */