package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.sdk.platformtools.ab;

final class g$4
  extends AnimatorListenerAdapter
{
  g$4(g paramg) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(145705);
    ab.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
    this.sfB.sfA.rMB.setScaleX(1.0F);
    this.sfB.sfA.rMB.setScaleY(1.0F);
    this.sfB.sfA.rMB.setAlpha(1.0F);
    this.sfB.sfA.sfT.setAlpha(1.0F);
    this.sfB.sfA.sfU.setAlpha(1.0F);
    if (this.sfB.seT != null) {
      this.sfB.seT.onAnimationEnd();
    }
    this.sfB.sfA.ezJ = false;
    AppMethodBeat.o(145705);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(145704);
    ab.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
    AppMethodBeat.o(145704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g.4
 * JD-Core Version:    0.7.0.1
 */