package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.b.a.d;

final class g$2
  implements ValueAnimator.AnimatorUpdateListener
{
  g$2(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.plE.plD.pmo.setAlpha(f);
    this.plE.plD.pmn.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.g.2
 * JD-Core Version:    0.7.0.1
 */