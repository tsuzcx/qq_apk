package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.c;

final class e$2
  implements ValueAnimator.AnimatorUpdateListener
{
  e$2(e parame) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40023);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfl.sfj.sfT.setAlpha(f);
    this.sfl.sfj.sfU.setAlpha(f);
    AppMethodBeat.o(40023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e.2
 * JD-Core Version:    0.7.0.1
 */