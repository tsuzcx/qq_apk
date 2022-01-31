package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.b.a.c;

final class f$2
  implements ValueAnimator.AnimatorUpdateListener
{
  f$2(f paramf) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.plC.plB.pmd.setAlpha(f);
    this.plC.plB.pme.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.f.2
 * JD-Core Version:    0.7.0.1
 */