package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;

final class i$3
  extends AnimatorListenerAdapter
{
  i$3(i parami, MMActivity paramMMActivity) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40037);
    ab.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
    ((ViewGroup)this.sfs.hwZ.getBodyView().getParent()).removeView(this.sfs.sfr.contentView);
    ((ViewGroup)this.sfs.sfr.rOw).addView(this.sfs.sfr.contentView, this.sfs.sfk);
    this.sfs.sfr.contentView.setScaleX(1.0F);
    this.sfs.sfr.contentView.setScaleY(1.0F);
    this.sfs.sfr.contentView.setAlpha(1.0F);
    this.sfs.sfr.sgw.setAlpha(1.0F);
    this.sfs.sfr.sgx.setAlpha(1.0F);
    if (this.sfs.seT != null) {
      this.sfs.seT.onAnimationEnd();
    }
    AppMethodBeat.o(40037);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40036);
    ab.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
    this.sfs.sfr.sgx.setAlpha(0.0F);
    this.sfs.sfr.sgw.setAlpha(0.0F);
    this.sfs.sfr.contentView.getLocationInWindow(this.sfs.sfd);
    ab.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.sfs.sfd[0]), Integer.valueOf(this.sfs.sfd[1]) });
    ((ViewGroup)this.sfs.sfr.rOw).removeView(this.sfs.sfr.contentView);
    paramAnimator = this.sfs.sfr.rOw.getLayoutParams();
    paramAnimator.width = this.sfs.sfr.contentView.getWidth();
    paramAnimator.height = (this.sfs.sfr.contentView.getHeight() + this.sfs.sfk.topMargin + this.sfs.sfk.bottomMargin);
    this.sfs.sfr.rOw.setLayoutParams(paramAnimator);
    this.sfs.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sfs.sfg.leftMargin = this.sfs.sfd[0];
    this.sfs.sfg.rightMargin = (this.sfs.seY.getWidth() - this.sfs.sfg.leftMargin - this.sfs.sfr.contentView.getWidth());
    this.sfs.sfg.topMargin = (this.sfs.sfd[1] - af.getStatusBarHeight(this.sfi));
    this.sfs.sfg.bottomMargin = (this.sfs.seY.getHeight() - this.sfs.sfg.topMargin - this.sfs.sfr.contentView.getHeight());
    this.sfs.seY.addView(this.sfs.sfr.contentView, this.sfs.sfg);
    AppMethodBeat.o(40036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i.3
 * JD-Core Version:    0.7.0.1
 */