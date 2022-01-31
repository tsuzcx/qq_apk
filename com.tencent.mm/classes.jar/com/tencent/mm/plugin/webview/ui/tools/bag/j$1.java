package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$1
  implements ValueAnimator.AnimatorUpdateListener
{
  j$1(j paramj) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(8179);
    j.a(this.vih, ((Integer)paramValueAnimator.getAnimatedValue("canvasTranslationX")).intValue());
    j.a(this.vih).left = ((Integer)paramValueAnimator.getAnimatedValue("translationX")).intValue();
    j.a(this.vih).top = ((Integer)paramValueAnimator.getAnimatedValue("translationY")).intValue();
    RectF localRectF = j.a(this.vih);
    float f1 = j.a(this.vih).left;
    float f2 = j.b(this.vih);
    localRectF.right = (((Float)paramValueAnimator.getAnimatedValue("scaleX")).floatValue() * f2 + f1);
    localRectF = j.a(this.vih);
    f1 = j.a(this.vih).top;
    f2 = j.c(this.vih);
    localRectF.bottom = (((Float)paramValueAnimator.getAnimatedValue("scaleY")).floatValue() * f2 + f1);
    this.vih.postInvalidate();
    AppMethodBeat.o(8179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.j.1
 * JD-Core Version:    0.7.0.1
 */