package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.e;

final class j$2
  implements ValueAnimator.AnimatorUpdateListener
{
  j$2(j paramj) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40041);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sft.sfr.sgx.setAlpha(f);
    this.sft.sfr.sgw.setAlpha(f);
    AppMethodBeat.o(40041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j.2
 * JD-Core Version:    0.7.0.1
 */