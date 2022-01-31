package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.b.a.b;

final class d$1
  implements ValueAnimator.AnimatorUpdateListener
{
  d$1(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0D)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.plw.plj.contentView.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.plw.plv.leftMargin * f));
      paramValueAnimator.rightMargin = ((int)(this.plw.plv.rightMargin * f));
      paramValueAnimator.topMargin = ((int)(this.plw.plv.topMargin * f));
      paramValueAnimator.bottomMargin = ((int)(this.plw.plv.bottomMargin * f));
      this.plw.plj.contentView.setLayoutParams(paramValueAnimator);
      this.plw.plj.pma.setScaleX(f);
      this.plw.plj.pma.setScaleY(f);
      this.plw.plj.pma.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.d.1
 * JD-Core Version:    0.7.0.1
 */