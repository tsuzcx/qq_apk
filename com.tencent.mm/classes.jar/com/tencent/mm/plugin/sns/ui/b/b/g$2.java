package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

final class g$2
  extends AnimatorListenerAdapter
{
  g$2(g paramg) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(145702);
    if (this.sfB.sfA.ezJ)
    {
      ab.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
      paramAnimator = this.sfB.seX.getChildAnimations().iterator();
      while (paramAnimator.hasNext()) {
        ((Animator)paramAnimator.next()).cancel();
      }
      AppMethodBeat.o(145702);
      return;
    }
    this.sfB.sfA.ezJ = true;
    this.sfB.sfA.sfT.setAlpha(0.0F);
    this.sfB.sfA.sfU.setAlpha(0.0F);
    AppMethodBeat.o(145702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g.2
 * JD-Core Version:    0.7.0.1
 */