package com.tencent.mm.plugin.sns.ui.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  c$1(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.plh.view.setAlpha(1.0F - f);
    if (f != 0.0F)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.plh.view.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.plh.plb * f));
      paramValueAnimator.topMargin = ((int)(this.plh.plc * f));
      ViewGroup localViewGroup = (ViewGroup)this.plh.view.getParent();
      paramValueAnimator.rightMargin = ((int)(localViewGroup.getWidth() * f - this.plh.pld * f - paramValueAnimator.leftMargin));
      paramValueAnimator.bottomMargin = ((int)(localViewGroup.getHeight() * f - this.plh.ple * f - paramValueAnimator.topMargin));
      this.plh.view.setLayoutParams(paramValueAnimator);
    }
    if (this.plh.plf != null) {
      this.plh.plf.aE(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c.1
 * JD-Core Version:    0.7.0.1
 */