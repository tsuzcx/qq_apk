package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.c.a;

final class e$1
  implements ValueAnimator.AnimatorUpdateListener
{
  e$1(e parame) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40060);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.sfy.sfx.rMB.setScaleX(f);
      this.sfy.sfx.rMB.setScaleY(f);
      this.sfy.sfx.rMB.setAlpha(f);
    }
    AppMethodBeat.o(40060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e.1
 * JD-Core Version:    0.7.0.1
 */