package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.c;

final class f$1
  implements ValueAnimator.AnimatorUpdateListener
{
  f$1(f paramf) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40028);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.sfn.sfm.contentView.setScaleX(f);
      this.sfn.sfm.contentView.setScaleY(f);
      this.sfn.sfm.contentView.setAlpha(f);
    }
    AppMethodBeat.o(40028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f.1
 * JD-Core Version:    0.7.0.1
 */