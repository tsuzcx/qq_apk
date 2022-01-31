package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.e;

final class i$2
  implements ValueAnimator.AnimatorUpdateListener
{
  i$2(i parami) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40035);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.sfs.sfr.sgx.setAlpha(f);
    this.sfs.sfr.sgw.setAlpha(f);
    AppMethodBeat.o(40035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i.2
 * JD-Core Version:    0.7.0.1
 */