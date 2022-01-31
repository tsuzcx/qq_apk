package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.sdk.platformtools.ab;

final class j$4
  extends AnimatorListenerAdapter
{
  j$4(j paramj) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40085);
    ab.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
    ((ViewGroup)this.sfF.sfD.siM.getParent()).removeView(this.sfF.sfD.siM);
    this.sfF.sfD.sgS.addView(this.sfF.sfD.siM, this.sfF.sfk);
    this.sfF.sfD.siM.setScaleX(1.0F);
    this.sfF.sfD.siM.setScaleY(1.0F);
    this.sfF.sfD.siM.setAlpha(1.0F);
    this.sfF.sfD.sfT.setAlpha(1.0F);
    this.sfF.sfD.sfU.setAlpha(1.0F);
    if (this.sfF.seT != null) {
      this.sfF.seT.onAnimationEnd();
    }
    this.sfF.sfD.ezJ = false;
    AppMethodBeat.o(40085);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40084);
    ab.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
    AppMethodBeat.o(40084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j.4
 * JD-Core Version:    0.7.0.1
 */