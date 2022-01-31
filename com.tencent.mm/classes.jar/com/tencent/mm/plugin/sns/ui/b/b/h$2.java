package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.sdk.platformtools.ab;

final class h$2
  extends AnimatorListenerAdapter
{
  h$2(h paramh) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(145709);
    if (this.sfC.sfA.ezJ)
    {
      ab.i("MicroMsg.SphereCardAdClickAnimation", "holder is busy");
      paramAnimator = this.sfC;
      if (paramAnimator.seX != null) {
        paramAnimator.seX.end();
      }
      AppMethodBeat.o(145709);
      return;
    }
    this.sfC.sfA.ezJ = true;
    AppMethodBeat.o(145709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h.2
 * JD-Core Version:    0.7.0.1
 */