package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements ValueAnimator.AnimatorUpdateListener
{
  a$3(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.rvA.rvs[1][1];
    float f3 = this.rvA.rvs[1][0];
    float f4 = this.rvA.rvs[1][0];
    float f5 = this.rvA.rvs[0][1];
    float f6 = this.rvA.rvs[0][0];
    float f7 = this.rvA.rvs[0][0];
    this.rvA.rvk.setX((f2 - f3) * f1 + f4);
    this.rvA.rvk.setY((f5 - f6) * f1 + f7);
    this.rvA.rvk.setPadding((int)((this.rvA.rvj - this.rvA.rvi) * f1 + this.rvA.rvi), 0, 0, 0);
    y.v("MicroMsg.FTS.SosAnimatorBaseController", "searchBarView.paddingLeft %d", new Object[] { Integer.valueOf(this.rvA.rvk.getPaddingLeft()) });
    paramValueAnimator = (RelativeLayout.LayoutParams)this.rvA.rvk.getLayoutParams();
    int i = (int)((1.0F - f1) * this.rvA.rvg);
    paramValueAnimator.leftMargin = i;
    paramValueAnimator.rightMargin = i;
    int j = (int)this.rvA.rvs[2][0];
    paramValueAnimator.width = ((this.rvA.rvg - i) * 2 + j);
    this.rvA.rvk.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.3
 * JD-Core Version:    0.7.0.1
 */