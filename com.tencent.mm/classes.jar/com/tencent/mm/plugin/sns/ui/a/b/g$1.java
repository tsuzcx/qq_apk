package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.c.j.b;

final class g$1
  implements ValueAnimator.AnimatorUpdateListener
{
  g$1(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.plN.plM.pok.setScaleX(f);
      this.plN.plM.pok.setScaleY(f);
      this.plN.plM.pok.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.g.1
 * JD-Core Version:    0.7.0.1
 */