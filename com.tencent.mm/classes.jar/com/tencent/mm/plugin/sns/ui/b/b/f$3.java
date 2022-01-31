package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.c.a;

final class f$3
  implements ValueAnimator.AnimatorUpdateListener
{
  f$3(f paramf) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40069);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfz.sfx.sfT.setAlpha(f);
    this.sfz.sfx.sfU.setAlpha(f);
    AppMethodBeat.o(40069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f.3
 * JD-Core Version:    0.7.0.1
 */