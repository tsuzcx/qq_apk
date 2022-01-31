package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class g$4
  extends AnimatorListenerAdapter
{
  g$4(g paramg) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(145692);
    ab.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation end");
    this.sfp.sfo.rMB.setScaleX(1.0F);
    this.sfp.sfo.rMB.setScaleY(1.0F);
    this.sfp.sfo.rMB.setAlpha(1.0F);
    this.sfp.sfo.sgi.setAlpha(1.0F);
    this.sfp.sfo.sgj.setAlpha(1.0F);
    if (this.sfp.seT != null) {
      this.sfp.seT.onAnimationEnd();
    }
    AppMethodBeat.o(145692);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(145691);
    ab.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation start");
    AppMethodBeat.o(145691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g.4
 * JD-Core Version:    0.7.0.1
 */