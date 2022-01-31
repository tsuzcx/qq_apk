package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.e;

final class j$1
  implements ValueAnimator.AnimatorUpdateListener
{
  j$1(j paramj) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40040);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0D)
    {
      this.sft.sfr.contentView.setScaleX(f);
      this.sft.sfr.contentView.setScaleY(f);
      this.sft.sfr.contentView.setAlpha(f);
    }
    AppMethodBeat.o(40040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j.1
 * JD-Core Version:    0.7.0.1
 */