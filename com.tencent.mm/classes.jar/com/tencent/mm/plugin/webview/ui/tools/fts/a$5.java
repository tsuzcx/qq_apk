package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

final class a$5
  implements ValueAnimator.AnimatorUpdateListener
{
  a$5(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.rvA.rvs[1][0];
    float f3 = this.rvA.rvs[1][1];
    float f4 = this.rvA.rvs[1][1];
    float f5 = this.rvA.rvs[0][0];
    float f6 = this.rvA.rvs[0][1];
    float f7 = this.rvA.rvs[0][1];
    this.rvA.rvk.setX((f2 - f3) * f1 + f4);
    this.rvA.rvk.setY((f5 - f6) * f1 + f7);
    this.rvA.rvk.setPadding((int)((this.rvA.rvi - this.rvA.rvj) * f1 + this.rvA.rvj), 0, 0, 0);
    paramValueAnimator = (RelativeLayout.LayoutParams)this.rvA.rvk.getLayoutParams();
    int i = (int)(f1 * this.rvA.rvg);
    paramValueAnimator.leftMargin = i;
    paramValueAnimator.rightMargin = i;
    int j = (int)this.rvA.rvs[2][0];
    paramValueAnimator.width = ((this.rvA.rvg - i) * 2 + j);
    this.rvA.rvk.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.5
 * JD-Core Version:    0.7.0.1
 */