package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.ui.c.b.a;

final class d$2
  implements ValueAnimator.AnimatorUpdateListener
{
  d$2(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.plI.plG.pnN.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d.2
 * JD-Core Version:    0.7.0.1
 */