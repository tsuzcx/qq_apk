package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.c.j.b;

final class h$1
  implements ValueAnimator.AnimatorUpdateListener
{
  h$1(h paramh) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0F)
    {
      this.plO.plM.pok.setScaleX(f);
      this.plO.plM.pok.setScaleY(f);
      this.plO.plM.pok.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.h.1
 * JD-Core Version:    0.7.0.1
 */