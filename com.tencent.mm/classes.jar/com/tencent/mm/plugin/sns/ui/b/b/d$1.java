package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.a.a;

final class d$1
  implements ValueAnimator.AnimatorUpdateListener
{
  d$1(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40053);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 1.0F)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.sfw.sfu.shV.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.sfw.sfg.leftMargin * f));
      paramValueAnimator.rightMargin = ((int)(this.sfw.sfg.rightMargin * f));
      paramValueAnimator.topMargin = ((int)(this.sfw.sfg.topMargin * f));
      paramValueAnimator.bottomMargin = ((int)(this.sfw.sfg.bottomMargin * f));
      this.sfw.sfu.shV.setLayoutParams(paramValueAnimator);
      this.sfw.sfu.shW.setScaleX(f);
      this.sfw.sfu.shW.setScaleY(f);
      this.sfw.sfu.shW.setAlpha(f);
    }
    AppMethodBeat.o(40053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d.1
 * JD-Core Version:    0.7.0.1
 */