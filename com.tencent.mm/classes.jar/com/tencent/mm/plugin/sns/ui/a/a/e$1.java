package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.b.a.c;

final class e$1
  implements ValueAnimator.AnimatorUpdateListener
{
  e$1(e parame) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.plA.ply.contentView.setScaleX(f);
      this.plA.ply.contentView.setScaleY(f);
      this.plA.ply.contentView.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.e.1
 * JD-Core Version:    0.7.0.1
 */