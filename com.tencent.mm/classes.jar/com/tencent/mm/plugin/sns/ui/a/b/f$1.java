package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.c.d.a;

final class f$1
  implements ValueAnimator.AnimatorUpdateListener
{
  f$1(f paramf) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0F)
    {
      this.plL.plJ.oUF.setScaleX(f);
      this.plL.plJ.oUF.setScaleY(f);
      this.plL.plJ.oUF.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.f.1
 * JD-Core Version:    0.7.0.1
 */