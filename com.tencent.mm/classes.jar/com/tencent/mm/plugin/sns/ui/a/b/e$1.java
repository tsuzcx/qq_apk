package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.c.d.a;

final class e$1
  implements ValueAnimator.AnimatorUpdateListener
{
  e$1(e parame) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.plK.plJ.oUF.setScaleX(f);
      this.plK.plJ.oUF.setScaleY(f);
      this.plK.plJ.oUF.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.e.1
 * JD-Core Version:    0.7.0.1
 */