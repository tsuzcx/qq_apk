package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

final class i$2
  extends AnimatorListenerAdapter
{
  i$2(i parami) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40075);
    if (this.sfE.sfD.ezJ)
    {
      ab.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
      paramAnimator = this.sfE.seX.getChildAnimations().iterator();
      while (paramAnimator.hasNext()) {
        ((Animator)paramAnimator.next()).cancel();
      }
      AppMethodBeat.o(40075);
      return;
    }
    this.sfE.sfD.ezJ = true;
    this.sfE.sfD.sfT.setAlpha(0.0F);
    this.sfE.sfD.sfU.setAlpha(0.0F);
    this.sfE.sfD.siM.getLocationInWindow(this.sfE.sfd);
    ab.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.sfE.sfd[0]), Integer.valueOf(this.sfE.sfd[1]) });
    this.sfE.sfD.sgS.removeView(this.sfE.sfD.siM);
    paramAnimator = this.sfE.sfD.sgS.getLayoutParams();
    paramAnimator.width = this.sfE.sfD.siM.getWidth();
    paramAnimator.height = (this.sfE.sfD.siM.getHeight() + this.sfE.sfk.topMargin + this.sfE.sfk.bottomMargin);
    this.sfE.sfD.sgS.setLayoutParams(paramAnimator);
    this.sfE.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sfE.sfg.leftMargin = this.sfE.sfd[0];
    this.sfE.sfg.rightMargin = (this.sfE.seY.getWidth() - this.sfE.sfg.leftMargin - this.sfE.sfD.siM.getWidth());
    this.sfE.sfg.topMargin = this.sfE.sfd[1];
    this.sfE.sfg.bottomMargin = (this.sfE.seY.getHeight() - this.sfE.sfg.topMargin - this.sfE.sfD.siM.getHeight());
    this.sfE.seY.addView(this.sfE.sfD.siM, this.sfE.sfg);
    AppMethodBeat.o(40075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i.2
 * JD-Core Version:    0.7.0.1
 */