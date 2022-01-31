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
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

final class e$2
  extends AnimatorListenerAdapter
{
  e$2(e parame) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40061);
    if (this.sfy.sfx.ezJ)
    {
      ab.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
      paramAnimator = this.sfy.seX.getChildAnimations().iterator();
      while (paramAnimator.hasNext()) {
        ((Animator)paramAnimator.next()).cancel();
      }
      AppMethodBeat.o(40061);
      return;
    }
    this.sfy.sfx.ezJ = true;
    this.sfy.sfx.rMB.getLocationInWindow(this.sfy.sfd);
    ab.i("MicroMsg.FullCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.sfy.sfd[0]), Integer.valueOf(this.sfy.sfd[1]) });
    this.sfy.sfx.sgS.removeView(this.sfy.sfx.rMB);
    paramAnimator = this.sfy.sfx.sgS.getLayoutParams();
    paramAnimator.width = this.sfy.sfx.rMB.getWidth();
    paramAnimator.height = (this.sfy.sfx.rMB.getHeight() + this.sfy.sfk.topMargin + this.sfy.sfk.bottomMargin);
    this.sfy.sfx.sgS.setLayoutParams(paramAnimator);
    this.sfy.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sfy.sfg.leftMargin = this.sfy.sfd[0];
    this.sfy.sfg.rightMargin = (this.sfy.seY.getWidth() - this.sfy.sfg.leftMargin - this.sfy.sfx.rMB.getWidth());
    this.sfy.sfg.topMargin = this.sfy.sfd[1];
    this.sfy.sfg.bottomMargin = (this.sfy.seY.getHeight() - this.sfy.sfg.topMargin - this.sfy.sfx.rMB.getHeight());
    this.sfy.seY.addView(this.sfy.sfx.rMB, this.sfy.sfg);
    this.sfy.sfx.sfT.setAlpha(0.0F);
    this.sfy.sfx.sfU.setAlpha(0.0F);
    AppMethodBeat.o(40061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e.2
 * JD-Core Version:    0.7.0.1
 */