package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.c.j.b;

final class h$2
  implements ValueAnimator.AnimatorUpdateListener
{
  h$2(h paramh) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.plO.plM.pmd.setAlpha(f);
    this.plO.plM.pme.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.h.2
 * JD-Core Version:    0.7.0.1
 */