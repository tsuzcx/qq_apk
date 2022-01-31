package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.a.a;

final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  c$1(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40046);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.sfv.sfu.shV.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.sfv.sfc.leftMargin * f));
      paramValueAnimator.rightMargin = ((int)(this.sfv.sfc.rightMargin * f));
      paramValueAnimator.topMargin = ((int)(this.sfv.sfc.topMargin * f));
      paramValueAnimator.bottomMargin = ((int)(this.sfv.sfc.bottomMargin * f));
      this.sfv.sfu.shV.setLayoutParams(paramValueAnimator);
      this.sfv.sfu.shW.setScaleX(f);
      this.sfv.sfu.shW.setScaleY(f);
      this.sfv.sfu.shW.setAlpha(f);
    }
    AppMethodBeat.o(40046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.c.1
 * JD-Core Version:    0.7.0.1
 */