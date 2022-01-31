package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

final class a$6
  implements ValueAnimator.AnimatorUpdateListener
{
  a$6(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (Math.abs(f - 1.0F) <= 0.001D)
    {
      this.rvA.rvk.setX(this.rvA.rvs[1][0]);
      this.rvA.rvk.setY(this.rvA.rvs[0][0]);
      this.rvA.rvk.setPadding(0, 0, 0, 0);
      paramValueAnimator = (RelativeLayout.LayoutParams)this.rvA.rvk.getLayoutParams();
      paramValueAnimator.leftMargin = this.rvA.rvg;
      paramValueAnimator.rightMargin = this.rvA.rvg;
      paramValueAnimator.width = ((int)this.rvA.rvs[2][0]);
      this.rvA.rvk.setLayoutParams(paramValueAnimator);
      this.rvA.rvk.setAlpha(1.0F);
      return;
    }
    this.rvA.rvk.setAlpha(1.0F - f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.6
 * JD-Core Version:    0.7.0.1
 */