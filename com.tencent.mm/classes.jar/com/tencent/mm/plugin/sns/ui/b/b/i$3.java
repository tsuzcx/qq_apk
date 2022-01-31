package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.j.b;

final class i$3
  implements ValueAnimator.AnimatorUpdateListener
{
  i$3(i parami) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40076);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfE.sfD.sfT.setAlpha(f);
    this.sfE.sfD.sfU.setAlpha(f);
    AppMethodBeat.o(40076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i.3
 * JD-Core Version:    0.7.0.1
 */