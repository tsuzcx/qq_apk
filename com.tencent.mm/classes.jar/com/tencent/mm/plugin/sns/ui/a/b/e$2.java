package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.c.d.a;

final class e$2
  implements ValueAnimator.AnimatorUpdateListener
{
  e$2(e parame) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.plK.plJ.pmd.setAlpha(f);
    this.plK.plJ.pme.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.e.2
 * JD-Core Version:    0.7.0.1
 */