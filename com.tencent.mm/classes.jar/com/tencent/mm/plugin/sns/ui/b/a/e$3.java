package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;

final class e$3
  extends AnimatorListenerAdapter
{
  e$3(e parame, MMActivity paramMMActivity) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40025);
    ab.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
    ((ViewGroup)this.sfl.hwZ.getBodyView().getParent()).removeView(this.sfl.sfj.contentView);
    ((ViewGroup)this.sfl.sfj.rOw).addView(this.sfl.sfj.contentView, this.sfl.sfk);
    this.sfl.sfj.contentView.setScaleX(1.0F);
    this.sfl.sfj.contentView.setScaleY(1.0F);
    this.sfl.sfj.contentView.setAlpha(1.0F);
    this.sfl.sfj.sfT.setAlpha(1.0F);
    this.sfl.sfj.sfU.setAlpha(1.0F);
    if (this.sfl.seT != null) {
      this.sfl.seT.onAnimationEnd();
    }
    AppMethodBeat.o(40025);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40024);
    ab.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
    this.sfl.sfj.sfT.setAlpha(0.0F);
    this.sfl.sfj.sfU.setAlpha(0.0F);
    this.sfl.sfj.contentView.getLocationInWindow(this.sfl.sfd);
    ab.i("MicroMsg.FullCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.sfl.sfd[0]), Integer.valueOf(this.sfl.sfd[1]) });
    ((ViewGroup)this.sfl.sfj.rOw).removeView(this.sfl.sfj.contentView);
    paramAnimator = this.sfl.sfj.rOw.getLayoutParams();
    paramAnimator.width = this.sfl.sfj.contentView.getWidth();
    paramAnimator.height = (this.sfl.sfj.contentView.getHeight() + this.sfl.sfk.topMargin + this.sfl.sfk.bottomMargin);
    this.sfl.sfj.rOw.setLayoutParams(paramAnimator);
    this.sfl.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sfl.sfg.leftMargin = this.sfl.sfd[0];
    this.sfl.sfg.rightMargin = (this.sfl.seY.getWidth() - this.sfl.sfg.leftMargin - this.sfl.sfj.contentView.getWidth());
    this.sfl.sfg.topMargin = (this.sfl.sfd[1] - af.getStatusBarHeight(this.sfi));
    this.sfl.sfg.bottomMargin = (this.sfl.seY.getHeight() - this.sfl.sfg.topMargin - this.sfl.sfj.contentView.getHeight());
    this.sfl.seY.addView(this.sfl.sfj.contentView, this.sfl.sfg);
    AppMethodBeat.o(40024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e.3
 * JD-Core Version:    0.7.0.1
 */