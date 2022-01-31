package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.b.a.d;

final class g$1
  implements ValueAnimator.AnimatorUpdateListener
{
  g$1(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.plE.plD.contentView.setScaleX(f);
      this.plE.plD.contentView.setScaleY(f);
      this.plE.plD.contentView.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.g.1
 * JD-Core Version:    0.7.0.1
 */