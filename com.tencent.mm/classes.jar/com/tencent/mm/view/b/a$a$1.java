package com.tencent.mm.view.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

final class a$a$1
  implements ValueAnimator.AnimatorUpdateListener
{
  int buE = 0;
  float buF = (float)Math.pow(this.wxy.mScale, 0.1000000014901161D);
  float buw = 0.0F;
  float bux = 0.0F;
  float wxx = 0.0F;
  
  a$a$1(a.a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("deltaY")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("deltaX")).floatValue();
    float f3 = ((Float)paramValueAnimator.getAnimatedValue("rotation")).floatValue();
    if (this.buE < 10)
    {
      this.wxy.wxs.bzW.postScale(this.buF, this.buF, this.wxy.wxs.getBoardRect().centerX(), this.wxy.wxs.getBoardRect().centerY());
      this.buE += 1;
    }
    this.wxy.buA += f2 - this.bux;
    this.wxy.buB += f1 - this.buw;
    this.wxy.wxs.bzW.postTranslate(this.wxy.buA - this.wxy.wxs.getCurImageRect().centerX(), this.wxy.buB - this.wxy.wxs.getCurImageRect().centerY());
    if (this.wxy.gb != 0.0F) {
      this.wxy.wxs.bzW.postRotate(f3 - this.wxx, this.wxy.buA, this.wxy.buB);
    }
    this.wxy.wxs.postInvalidate();
    this.buw = f1;
    this.bux = f2;
    this.wxx = f3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */