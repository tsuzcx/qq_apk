package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.c;

final class e$1
  implements ValueAnimator.AnimatorUpdateListener
{
  e$1(e parame) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40022);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.sfl.sfj.contentView.setScaleX(f);
      this.sfl.sfj.contentView.setScaleY(f);
      this.sfl.sfj.contentView.setAlpha(f);
    }
    AppMethodBeat.o(40022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e.1
 * JD-Core Version:    0.7.0.1
 */