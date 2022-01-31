package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  c$1(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40006);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.seS.view.setAlpha(1.0F - f);
    if (f != 0.0F)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.seS.view.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.seS.seM * f));
      paramValueAnimator.topMargin = ((int)(this.seS.seN * f));
      ViewGroup localViewGroup = (ViewGroup)this.seS.view.getParent();
      paramValueAnimator.rightMargin = ((int)(localViewGroup.getWidth() * f - this.seS.seO * f - paramValueAnimator.leftMargin));
      paramValueAnimator.bottomMargin = ((int)(localViewGroup.getHeight() * f - this.seS.seP * f - paramValueAnimator.topMargin));
      this.seS.view.setLayoutParams(paramValueAnimator);
    }
    if (this.seS.seQ != null) {
      this.seS.seQ.bd(f);
    }
    AppMethodBeat.o(40006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.c.1
 * JD-Core Version:    0.7.0.1
 */