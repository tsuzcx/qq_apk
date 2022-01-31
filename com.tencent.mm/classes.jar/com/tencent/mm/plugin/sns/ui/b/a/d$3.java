package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;

final class d$3
  extends AnimatorListenerAdapter
{
  d$3(d paramd, MMActivity paramMMActivity, a parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40019);
    ab.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
    ((ViewGroup)this.sfi.getBodyView().getParent()).removeView(this.sfh.seU.contentView);
    ((ViewGroup)this.sfi.getBodyView().getParent()).removeView(this.sfh.seU.sfQ);
    ((ViewGroup)this.sfi.getBodyView().getParent()).removeView(this.sfh.seU.sfR);
    this.sfh.seU.sfQ.setScaleX(1.0F);
    this.sfh.seU.sfQ.setScaleY(1.0F);
    this.sfh.seU.sfQ.setAlpha(1.0F);
    ((ViewGroup)this.sfh.seU.rOw).addView(this.sfh.seU.contentView, this.sfh.seZ);
    ((ViewGroup)this.sfh.seU.contentView).addView(this.sfh.seU.sfQ, this.sfh.sfa);
    ((ViewGroup)this.sfh.seU.contentView).addView(this.sfh.seU.sfR, this.sfh.sfb);
    this.sfh.seU.sfR.setAlpha(1.0F);
    if (this.sfh.seT != null) {
      this.sfh.seT.onAnimationEnd();
    }
    AppMethodBeat.o(40019);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40018);
    ab.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
    this.sfh.seU.contentView.getLocationInWindow(this.sfh.sfd);
    ab.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(this.sfh.sfd[0]), Integer.valueOf(this.sfh.sfd[1]) });
    this.sfh.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sfh.sfg.leftMargin = this.sfh.sfd[0];
    this.sfh.sfg.rightMargin = (this.sfh.seY.getWidth() - this.sfh.sfg.leftMargin - this.sfh.seU.contentView.getWidth());
    this.sfh.sfg.topMargin = (this.sfh.sfd[1] - af.getStatusBarHeight(this.sfi));
    this.sfh.sfg.bottomMargin = (this.sfh.seY.getHeight() - this.sfh.sfg.topMargin - this.sfh.seU.contentView.getHeight());
    ab.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", new Object[] { Integer.valueOf(this.sfh.sfg.leftMargin), Integer.valueOf(this.sfh.sfg.topMargin), Integer.valueOf(this.sfh.sfg.rightMargin), Integer.valueOf(this.sfh.sfg.bottomMargin) });
    Object localObject1 = new int[2];
    this.sfh.seU.sfQ.getLocationInWindow((int[])localObject1);
    ab.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
    paramAnimator = new FrameLayout.LayoutParams(-2, -2);
    paramAnimator.leftMargin = localObject1[0];
    paramAnimator.rightMargin = (this.sfh.seY.getWidth() - paramAnimator.leftMargin - this.sfh.seU.sfQ.getWidth());
    paramAnimator.topMargin = (localObject1[1] - af.getStatusBarHeight(this.sfi));
    paramAnimator.bottomMargin = (this.sfh.seY.getHeight() - paramAnimator.topMargin - this.sfh.seU.sfQ.getHeight());
    Object localObject2 = new int[2];
    this.sfh.seU.sfR.getLocationInWindow((int[])localObject2);
    ab.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
    localObject1 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
    ((FrameLayout.LayoutParams)localObject1).rightMargin = (this.sfh.seY.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((b)this.sff).sfR.getWidth());
    ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - af.getStatusBarHeight(this.sfi));
    ((FrameLayout.LayoutParams)localObject1).bottomMargin = (this.sfh.seY.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((b)this.sff).sfR.getHeight());
    localObject2 = this.sfh.seU.rOw.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = this.sfh.seU.contentView.getWidth();
    ((ViewGroup.LayoutParams)localObject2).height = (this.sfh.seU.contentView.getHeight() + this.sfh.seZ.topMargin + this.sfh.seZ.bottomMargin);
    this.sfh.seU.rOw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ViewGroup)this.sfh.seU.rOw).removeView(this.sfh.seU.contentView);
    localObject2 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject2).leftMargin = this.sfh.sfg.leftMargin;
    ((FrameLayout.LayoutParams)localObject2).rightMargin = this.sfh.sfg.rightMargin;
    ((FrameLayout.LayoutParams)localObject2).topMargin = this.sfh.sfg.topMargin;
    ((FrameLayout.LayoutParams)localObject2).bottomMargin = this.sfh.sfg.bottomMargin;
    this.sfh.seY.addView(this.sfh.seU.contentView, (ViewGroup.LayoutParams)localObject2);
    ((ViewGroup)this.sfh.seU.contentView).removeView(this.sfh.seU.sfQ);
    this.sfh.seY.addView(this.sfh.seU.sfQ, paramAnimator);
    ((ViewGroup)this.sfh.seU.contentView).removeView(this.sfh.seU.sfR);
    this.sfh.seY.addView(this.sfh.seU.sfR, (ViewGroup.LayoutParams)localObject1);
    AppMethodBeat.o(40018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d.3
 * JD-Core Version:    0.7.0.1
 */