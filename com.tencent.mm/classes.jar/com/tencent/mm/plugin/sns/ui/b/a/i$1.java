package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.e;

final class i$1
  implements ValueAnimator.AnimatorUpdateListener
{
  i$1(i parami) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40034);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != 0.0F)
    {
      this.sfs.sfr.contentView.setScaleX(f);
      this.sfs.sfr.contentView.setScaleY(f);
      this.sfs.sfr.contentView.setAlpha(f);
    }
    AppMethodBeat.o(40034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i.1
 * JD-Core Version:    0.7.0.1
 */