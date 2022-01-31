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

final class c$3
  extends AnimatorListenerAdapter
{
  c$3(c paramc, MMActivity paramMMActivity, a parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40013);
    ab.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
    ((ViewGroup)this.val$activity.getBodyView().getParent()).removeView(this.sfe.seU.contentView);
    ((ViewGroup)this.val$activity.getBodyView().getParent()).removeView(this.sfe.seU.sfQ);
    ((ViewGroup)this.val$activity.getBodyView().getParent()).removeView(this.sfe.seU.sfR);
    this.sfe.seU.sfQ.setScaleX(1.0F);
    this.sfe.seU.sfQ.setScaleY(1.0F);
    this.sfe.seU.sfQ.setAlpha(1.0F);
    ((ViewGroup)this.sfe.seU.rOw).addView(this.sfe.seU.contentView, this.sfe.seZ);
    ((ViewGroup)this.sfe.seU.contentView).addView(this.sfe.seU.sfQ, this.sfe.sfa);
    ((ViewGroup)this.sfe.seU.contentView).addView(this.sfe.seU.sfR, this.sfe.sfb);
    this.sfe.seU.contentView.setAlpha(1.0F);
    this.sfe.seU.sfR.setAlpha(1.0F);
    if (this.sfe.seT != null) {
      this.sfe.seT.onAnimationEnd();
    }
    AppMethodBeat.o(40013);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40012);
    ab.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
    this.sfe.seU.contentView.getLocationInWindow(this.sfe.sfd);
    ab.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(this.sfe.sfd[0]), Integer.valueOf(this.sfe.sfd[1]) });
    this.sfe.sfc = new FrameLayout.LayoutParams(-2, -2);
    this.sfe.sfc.leftMargin = this.sfe.sfd[0];
    this.sfe.sfc.rightMargin = (this.sfe.seY.getWidth() - this.sfe.sfc.leftMargin - this.sfe.seU.contentView.getWidth());
    this.sfe.sfc.topMargin = (this.sfe.sfd[1] - af.getStatusBarHeight(this.val$activity));
    this.sfe.sfc.bottomMargin = (this.sfe.seY.getHeight() - this.sfe.sfc.topMargin - this.sfe.seU.contentView.getHeight());
    Object localObject1 = new int[2];
    this.sfe.seU.sfQ.getLocationInWindow((int[])localObject1);
    ab.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
    paramAnimator = new FrameLayout.LayoutParams(-2, -2);
    paramAnimator.leftMargin = localObject1[0];
    paramAnimator.rightMargin = (this.sfe.seY.getWidth() - paramAnimator.leftMargin - this.sfe.seU.sfQ.getWidth());
    paramAnimator.topMargin = (localObject1[1] - af.getStatusBarHeight(this.val$activity));
    paramAnimator.bottomMargin = (this.sfe.seY.getHeight() - paramAnimator.topMargin - this.sfe.seU.sfQ.getHeight());
    Object localObject2 = new int[2];
    this.sfe.seU.sfR.getLocationInWindow((int[])localObject2);
    ab.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
    localObject1 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
    ((FrameLayout.LayoutParams)localObject1).rightMargin = (this.sfe.seY.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((b)this.sff).sfR.getWidth());
    ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - af.getStatusBarHeight(this.val$activity));
    ((FrameLayout.LayoutParams)localObject1).bottomMargin = (this.sfe.seY.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((b)this.sff).sfR.getHeight());
    localObject2 = this.sfe.seU.rOw.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = this.sfe.seU.contentView.getWidth();
    ((ViewGroup.LayoutParams)localObject2).height = (this.sfe.seU.contentView.getHeight() + this.sfe.seZ.topMargin + this.sfe.seZ.bottomMargin);
    this.sfe.seU.rOw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.sfe.seU.sfR.setAlpha(0.0F);
    ((ViewGroup)this.sfe.seU.rOw).removeView(this.sfe.seU.contentView);
    this.sfe.seY.addView(this.sfe.seU.contentView, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)this.sfe.seU.contentView).removeView(this.sfe.seU.sfQ);
    this.sfe.seY.addView(this.sfe.seU.sfQ, paramAnimator);
    ((ViewGroup)this.sfe.seU.contentView).removeView(this.sfe.seU.sfR);
    this.sfe.seY.addView(this.sfe.seU.sfR, (ViewGroup.LayoutParams)localObject1);
    this.sfe.seU.sfQ.setScaleX(0.0F);
    this.sfe.seU.sfQ.setScaleY(0.0F);
    this.sfe.seU.sfQ.setAlpha(0.0F);
    AppMethodBeat.o(40012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c.3
 * JD-Core Version:    0.7.0.1
 */