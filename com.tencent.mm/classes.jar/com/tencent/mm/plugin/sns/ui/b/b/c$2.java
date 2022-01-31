package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

final class c$2
  extends AnimatorListenerAdapter
{
  c$2(c paramc) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40047);
    if (this.sfv.sfu.ezJ)
    {
      ab.i("MicroMsg.CardAdBackAnimation", "holder is busy");
      paramAnimator = this.sfv.seX.getChildAnimations().iterator();
      while (paramAnimator.hasNext()) {
        ((Animator)paramAnimator.next()).cancel();
      }
      AppMethodBeat.o(40047);
      return;
    }
    this.sfv.sfu.ezJ = true;
    this.sfv.sfu.shV.getLocationInWindow(this.sfv.sfd);
    ab.i("MicroMsg.CardAdBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(this.sfv.sfd[0]), Integer.valueOf(this.sfv.sfd[1]) });
    this.sfv.sfc = new FrameLayout.LayoutParams(-2, -2);
    this.sfv.sfc.leftMargin = this.sfv.sfd[0];
    this.sfv.sfc.rightMargin = (this.sfv.seY.getWidth() - this.sfv.sfc.leftMargin - this.sfv.sfu.shV.getWidth());
    this.sfv.sfc.topMargin = this.sfv.sfd[1];
    this.sfv.sfc.bottomMargin = (this.sfv.seY.getHeight() - this.sfv.sfc.topMargin - this.sfv.sfu.shV.getHeight());
    Object localObject = new int[2];
    this.sfv.sfu.shW.getLocationInWindow((int[])localObject);
    ab.i("MicroMsg.CardAdBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
    paramAnimator = new FrameLayout.LayoutParams(-2, -2);
    paramAnimator.leftMargin = localObject[0];
    paramAnimator.rightMargin = (this.sfv.seY.getWidth() - paramAnimator.leftMargin - this.sfv.sfu.shW.getWidth());
    paramAnimator.topMargin = localObject[1];
    paramAnimator.bottomMargin = (this.sfv.seY.getHeight() - paramAnimator.topMargin - this.sfv.sfu.shW.getHeight());
    localObject = this.sfv.sfu.sgS.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.sfv.sfu.shV.getWidth();
    ((ViewGroup.LayoutParams)localObject).height = (this.sfv.sfu.shV.getHeight() + this.sfv.seZ.topMargin + this.sfv.seZ.bottomMargin);
    this.sfv.sfu.sgS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new int[2];
    this.sfv.sfu.shX.getLocationInWindow((int[])localObject);
    ab.i("MicroMsg.CardAdBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = localObject[0];
    localLayoutParams.rightMargin = (this.sfv.seY.getWidth() - localLayoutParams.leftMargin - this.sfv.sfu.shX.getWidth());
    localLayoutParams.topMargin = localObject[1];
    localLayoutParams.bottomMargin = (this.sfv.seY.getHeight() - localLayoutParams.topMargin - this.sfv.sfu.shX.getHeight());
    this.sfv.sfu.shX.setAlpha(0.0F);
    this.sfv.sfu.sgS.removeView(this.sfv.sfu.shV);
    this.sfv.seY.addView(this.sfv.sfu.shV, new FrameLayout.LayoutParams(-1, -1));
    this.sfv.sfu.shV.removeView(this.sfv.sfu.shW);
    this.sfv.seY.addView(this.sfv.sfu.shW, paramAnimator);
    this.sfv.sfu.shV.removeView(this.sfv.sfu.shX);
    this.sfv.seY.addView(this.sfv.sfu.shX, localLayoutParams);
    this.sfv.sfu.shW.setScaleX(0.0F);
    this.sfv.sfu.shW.setScaleY(0.0F);
    this.sfv.sfu.shW.setAlpha(0.0F);
    AppMethodBeat.o(40047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.c.2
 * JD-Core Version:    0.7.0.1
 */