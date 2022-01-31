package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements ValueAnimator.AnimatorUpdateListener
{
  b$1(b paramb) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40002);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.seR.view.setAlpha(1.0F - f);
    if (f != 1.0F)
    {
      paramValueAnimator = (FrameLayout.LayoutParams)this.seR.view.getLayoutParams();
      paramValueAnimator.leftMargin = ((int)(this.seR.seM * f));
      paramValueAnimator.topMargin = ((int)(this.seR.seN * f));
      ViewGroup localViewGroup = (ViewGroup)this.seR.view.getParent();
      paramValueAnimator.rightMargin = ((int)(localViewGroup.getWidth() * f - this.seR.seO * f - paramValueAnimator.leftMargin));
      paramValueAnimator.bottomMargin = ((int)(localViewGroup.getHeight() * f - this.seR.seP * f - paramValueAnimator.topMargin));
      this.seR.view.setLayoutParams(paramValueAnimator);
    }
    if (this.seR.seQ != null) {
      this.seR.seQ.bd(f);
    }
    AppMethodBeat.o(40002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.1
 * JD-Core Version:    0.7.0.1
 */