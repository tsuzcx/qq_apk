package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.c.a;

final class f$1
  implements ValueAnimator.AnimatorUpdateListener
{
  f$1(f paramf) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40067);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0F)
    {
      this.sfz.sfx.rMB.setScaleX(f);
      this.sfz.sfx.rMB.setScaleY(f);
      this.sfz.sfx.rMB.setAlpha(f);
    }
    AppMethodBeat.o(40067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f.1
 * JD-Core Version:    0.7.0.1
 */