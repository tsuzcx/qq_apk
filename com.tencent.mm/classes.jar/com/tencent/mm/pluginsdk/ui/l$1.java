package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class l$1
  implements ValueAnimator.AnimatorUpdateListener
{
  l$1(l paraml) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    l.a(this.saV, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.saV.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l.1
 * JD-Core Version:    0.7.0.1
 */