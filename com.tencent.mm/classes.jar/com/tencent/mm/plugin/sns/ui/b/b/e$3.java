package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.c.a;

final class e$3
  implements ValueAnimator.AnimatorUpdateListener
{
  e$3(e parame) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40062);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfy.sfx.sfT.setAlpha(f);
    this.sfy.sfx.sfU.setAlpha(f);
    AppMethodBeat.o(40062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e.3
 * JD-Core Version:    0.7.0.1
 */