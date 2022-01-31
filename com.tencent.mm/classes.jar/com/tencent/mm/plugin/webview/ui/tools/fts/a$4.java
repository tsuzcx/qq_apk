package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

final class a$4
  implements ValueAnimator.AnimatorUpdateListener
{
  a$4(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.rvA.rvk.setAlpha(f);
    this.rvA.rvk.setX(this.rvA.rvs[1][1]);
    this.rvA.rvk.setY(this.rvA.rvs[0][1]);
    this.rvA.rvk.setPadding(this.rvA.rvj, 0, 0, 0);
    paramValueAnimator = (RelativeLayout.LayoutParams)this.rvA.rvk.getLayoutParams();
    if (paramValueAnimator.leftMargin != 0)
    {
      paramValueAnimator.leftMargin = 0;
      paramValueAnimator.rightMargin = 0;
      paramValueAnimator.width = ((int)this.rvA.rvs[2][0] + this.rvA.rvg * 2);
      this.rvA.rvk.setLayoutParams(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.4
 * JD-Core Version:    0.7.0.1
 */