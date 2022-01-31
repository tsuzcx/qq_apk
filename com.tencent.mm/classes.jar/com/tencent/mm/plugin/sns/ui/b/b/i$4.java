package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.sdk.platformtools.ab;

final class i$4
  extends AnimatorListenerAdapter
{
  i$4(i parami) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40078);
    ab.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
    ((ViewGroup)this.sfE.sfD.siM.getParent()).removeView(this.sfE.sfD.siM);
    this.sfE.sfD.sgS.addView(this.sfE.sfD.siM, this.sfE.sfk);
    this.sfE.sfD.siM.setScaleX(1.0F);
    this.sfE.sfD.siM.setScaleY(1.0F);
    this.sfE.sfD.siM.setAlpha(1.0F);
    this.sfE.sfD.sfT.setAlpha(1.0F);
    this.sfE.sfD.sfU.setAlpha(1.0F);
    if (this.sfE.seT != null) {
      this.sfE.seT.onAnimationEnd();
    }
    this.sfE.sfD.ezJ = false;
    AppMethodBeat.o(40078);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40077);
    ab.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
    AppMethodBeat.o(40077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i.4
 * JD-Core Version:    0.7.0.1
 */