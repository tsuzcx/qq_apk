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

final class j$2
  extends AnimatorListenerAdapter
{
  j$2(j paramj) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40082);
    if (this.sfF.sfD.ezJ)
    {
      ab.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
      paramAnimator = this.sfF.seX.getChildAnimations().iterator();
      while (paramAnimator.hasNext()) {
        ((Animator)paramAnimator.next()).cancel();
      }
      AppMethodBeat.o(40082);
      return;
    }
    this.sfF.sfD.ezJ = true;
    this.sfF.sfD.siM.getLocationInWindow(this.sfF.sfd);
    ab.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(this.sfF.sfd[0]), Integer.valueOf(this.sfF.sfd[1]), Integer.valueOf(this.sfF.sfD.siM.getWidth()), Integer.valueOf(this.sfF.sfD.siM.getHeight()) });
    this.sfF.sfD.sgS.removeView(this.sfF.sfD.siM);
    paramAnimator = this.sfF.sfD.sgS.getLayoutParams();
    paramAnimator.width = this.sfF.sfD.siM.getWidth();
    paramAnimator.height = (this.sfF.sfD.siM.getHeight() + this.sfF.sfk.topMargin + this.sfF.sfk.bottomMargin);
    this.sfF.sfD.sgS.setLayoutParams(paramAnimator);
    this.sfF.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sfF.sfg.leftMargin = this.sfF.sfd[0];
    this.sfF.sfg.rightMargin = (this.sfF.seY.getWidth() - this.sfF.sfg.leftMargin - this.sfF.sfD.siM.getWidth());
    this.sfF.sfg.topMargin = this.sfF.sfd[1];
    this.sfF.sfg.bottomMargin = (this.sfF.seY.getHeight() - this.sfF.sfg.topMargin - this.sfF.sfD.siM.getHeight());
    this.sfF.seY.addView(this.sfF.sfD.siM, this.sfF.sfg);
    AppMethodBeat.o(40082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j.2
 * JD-Core Version:    0.7.0.1
 */