package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.b;

final class d$1
  implements ValueAnimator.AnimatorUpdateListener
{
  d$1(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40016);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0D)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.sfh.seU.contentView.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.sfh.sfg.leftMargin * f));
      paramValueAnimator.rightMargin = ((int)(this.sfh.sfg.rightMargin * f));
      paramValueAnimator.topMargin = ((int)(this.sfh.sfg.topMargin * f));
      paramValueAnimator.bottomMargin = ((int)(this.sfh.sfg.bottomMargin * f));
      this.sfh.seU.contentView.setLayoutParams(paramValueAnimator);
      this.sfh.seU.sfQ.setScaleX(f);
      this.sfh.seU.sfQ.setScaleY(f);
      this.sfh.seU.sfQ.setAlpha(f);
    }
    AppMethodBeat.o(40016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d.1
 * JD-Core Version:    0.7.0.1
 */