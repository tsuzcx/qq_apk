package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.b.a.d;

final class h$1
  implements ValueAnimator.AnimatorUpdateListener
{
  h$1(h paramh) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0D)
    {
      this.plF.plD.contentView.setScaleX(f);
      this.plF.plD.contentView.setScaleY(f);
      this.plF.plD.contentView.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.h.1
 * JD-Core Version:    0.7.0.1
 */