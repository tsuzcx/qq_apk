package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.j.b;

final class j$3
  implements ValueAnimator.AnimatorUpdateListener
{
  j$3(j paramj) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40083);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfF.sfD.sfT.setAlpha(f);
    this.sfF.sfD.sfU.setAlpha(f);
    AppMethodBeat.o(40083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j.3
 * JD-Core Version:    0.7.0.1
 */