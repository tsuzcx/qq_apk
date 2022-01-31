package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.b.a.b;

final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  c$1(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.plt.plj.contentView.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.plt.plr.leftMargin * f));
      paramValueAnimator.rightMargin = ((int)(this.plt.plr.rightMargin * f));
      paramValueAnimator.topMargin = ((int)(this.plt.plr.topMargin * f));
      paramValueAnimator.bottomMargin = ((int)(this.plt.plr.bottomMargin * f));
      paramValueAnimator.width = (this.plt.pln.getWidth() - paramValueAnimator.leftMargin - paramValueAnimator.rightMargin);
      paramValueAnimator.height = (this.plt.pln.getHeight() - paramValueAnimator.topMargin - paramValueAnimator.bottomMargin);
      this.plt.plj.contentView.setLayoutParams(paramValueAnimator);
      this.plt.plj.contentView.setAlpha(f);
      this.plt.plj.pma.setScaleX(f);
      this.plt.plj.pma.setScaleY(f);
      this.plt.plj.pma.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.c.1
 * JD-Core Version:    0.7.0.1
 */