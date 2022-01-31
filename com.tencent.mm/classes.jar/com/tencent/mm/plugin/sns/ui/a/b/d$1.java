package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.c.b.a;

final class d$1
  implements ValueAnimator.AnimatorUpdateListener
{
  d$1(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0F)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.plI.plG.pnL.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.plI.plv.leftMargin * f));
      paramValueAnimator.rightMargin = ((int)(this.plI.plv.rightMargin * f));
      paramValueAnimator.topMargin = ((int)(this.plI.plv.topMargin * f));
      paramValueAnimator.bottomMargin = ((int)(this.plI.plv.bottomMargin * f));
      this.plI.plG.pnL.setLayoutParams(paramValueAnimator);
      this.plI.plG.pnM.setScaleX(f);
      this.plI.plG.pnM.setScaleY(f);
      this.plI.plG.pnM.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d.1
 * JD-Core Version:    0.7.0.1
 */