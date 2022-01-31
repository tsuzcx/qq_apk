package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.b.a.c;

final class f$1
  implements ValueAnimator.AnimatorUpdateListener
{
  f$1(f paramf) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.plC.plB.contentView.setScaleX(f);
      this.plC.plB.contentView.setScaleY(f);
      this.plC.plB.contentView.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.f.1
 * JD-Core Version:    0.7.0.1
 */