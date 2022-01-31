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

final class d$2
  extends AnimatorListenerAdapter
{
  d$2(d paramd) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40054);
    if (this.sfw.sfu.ezJ)
    {
      ab.i("MicroMsg.CardAdClickAnimation", "holder is busy");
      this.sfw.seX.end();
      AppMethodBeat.o(40054);
      return;
    }
    this.sfw.sfu.ezJ = true;
    this.sfw.sfu.shV.getLocationInWindow(this.sfw.sfd);
    ab.i("MicroMsg.CardAdClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(this.sfw.sfd[0]), Integer.valueOf(this.sfw.sfd[1]) });
    this.sfw.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sfw.sfg.leftMargin = this.sfw.sfd[0];
    this.sfw.sfg.rightMargin = (this.sfw.seY.getWidth() - this.sfw.sfg.leftMargin - this.sfw.sfu.shV.getWidth());
    this.sfw.sfg.topMargin = this.sfw.sfd[1];
    this.sfw.sfg.bottomMargin = (this.sfw.seY.getHeight() - this.sfw.sfg.topMargin - this.sfw.sfu.shV.getHeight());
    Object localObject1 = new int[2];
    this.sfw.sfu.shW.getLocationInWindow((int[])localObject1);
    ab.i("MicroMsg.CardAdClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
    paramAnimator = new FrameLayout.LayoutParams(-2, -2);
    paramAnimator.leftMargin = localObject1[0];
    paramAnimator.rightMargin = (this.sfw.seY.getWidth() - paramAnimator.leftMargin - this.sfw.sfu.shW.getWidth());
    paramAnimator.topMargin = localObject1[1];
    paramAnimator.bottomMargin = (this.sfw.seY.getHeight() - paramAnimator.topMargin - this.sfw.sfu.shW.getHeight());
    Object localObject2 = new int[2];
    this.sfw.sfu.shX.getLocationInWindow((int[])localObject2);
    ab.i("MicroMsg.CardAdClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
    localObject1 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
    ((FrameLayout.LayoutParams)localObject1).rightMargin = (this.sfw.seY.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - this.sfw.sfu.shX.getWidth());
    ((FrameLayout.LayoutParams)localObject1).topMargin = localObject2[1];
    ((FrameLayout.LayoutParams)localObject1).bottomMargin = (this.sfw.seY.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - this.sfw.sfu.shX.getHeight());
    localObject2 = this.sfw.sfu.sgS.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = this.sfw.sfu.shV.getWidth();
    ((ViewGroup.LayoutParams)localObject2).height = (this.sfw.sfu.shV.getHeight() + this.sfw.seZ.topMargin + this.sfw.seZ.bottomMargin);
    this.sfw.sfu.sgS.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject2).leftMargin = this.sfw.sfg.leftMargin;
    ((FrameLayout.LayoutParams)localObject2).rightMargin = this.sfw.sfg.rightMargin;
    ((FrameLayout.LayoutParams)localObject2).topMargin = this.sfw.sfg.topMargin;
    ((FrameLayout.LayoutParams)localObject2).bottomMargin = this.sfw.sfg.bottomMargin;
    this.sfw.sfu.sgS.removeView(this.sfw.sfu.shV);
    this.sfw.seY.addView(this.sfw.sfu.shV, (ViewGroup.LayoutParams)localObject2);
    this.sfw.sfu.shV.removeView(this.sfw.sfu.shW);
    this.sfw.seY.addView(this.sfw.sfu.shW, paramAnimator);
    this.sfw.sfu.shV.removeView(this.sfw.sfu.shX);
    this.sfw.seY.addView(this.sfw.sfu.shX, (ViewGroup.LayoutParams)localObject1);
    AppMethodBeat.o(40054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d.2
 * JD-Core Version:    0.7.0.1
 */