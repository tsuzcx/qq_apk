package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.RectF;

final class j$1
  implements ValueAnimator.AnimatorUpdateListener
{
  j$1(j paramj) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    j.a(this.rsc, ((Integer)paramValueAnimator.getAnimatedValue("canvasTranslationX")).intValue());
    j.a(this.rsc).left = ((Integer)paramValueAnimator.getAnimatedValue("translationX")).intValue();
    j.a(this.rsc).top = ((Integer)paramValueAnimator.getAnimatedValue("translationY")).intValue();
    RectF localRectF = j.a(this.rsc);
    float f1 = j.a(this.rsc).left;
    float f2 = j.b(this.rsc);
    localRectF.right = (((Float)paramValueAnimator.getAnimatedValue("scaleX")).floatValue() * f2 + f1);
    localRectF = j.a(this.rsc);
    f1 = j.a(this.rsc).top;
    f2 = j.c(this.rsc);
    localRectF.bottom = (((Float)paramValueAnimator.getAnimatedValue("scaleY")).floatValue() * f2 + f1);
    this.rsc.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.j.1
 * JD-Core Version:    0.7.0.1
 */