package com.tencent.mm.plugin.websearch.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

final class a$6$1
  implements ValueAnimator.AnimatorUpdateListener
{
  a$6$1(a.6 param6, ViewGroup.LayoutParams paramLayoutParams1, ViewGroup.LayoutParams paramLayoutParams2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.qWZ.height = i;
    this.qXb.qWX.setLayoutParams(this.qWZ);
    this.qXa.height = i;
    this.qXb.qWY.setLayoutParams(this.qXa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.6.1
 * JD-Core Version:    0.7.0.1
 */