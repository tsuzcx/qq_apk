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

final class j$3
  extends AnimatorListenerAdapter
{
  j$3(j paramj, MMActivity paramMMActivity) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40043);
    ab.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
    ((ViewGroup)this.sft.hwZ.getBodyView().getParent()).removeView(this.sft.sfr.contentView);
    ((ViewGroup)this.sft.sfr.rOw).addView(this.sft.sfr.contentView, this.sft.sfk);
    this.sft.sfr.contentView.setScaleX(1.0F);
    this.sft.sfr.contentView.setScaleY(1.0F);
    this.sft.sfr.contentView.setAlpha(1.0F);
    this.sft.sfr.sgx.setAlpha(1.0F);
    this.sft.sfr.sgw.setAlpha(1.0F);
    if (this.sft.seT != null) {
      this.sft.seT.onAnimationEnd();
    }
    AppMethodBeat.o(40043);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40042);
    ab.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
    this.sft.sfr.contentView.getLocationInWindow(this.sft.sfd);
    ab.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.sft.sfd[0]), Integer.valueOf(this.sft.sfd[1]) });
    ((ViewGroup)this.sft.sfr.rOw).removeView(this.sft.sfr.contentView);
    paramAnimator = this.sft.sfr.rOw.getLayoutParams();
    paramAnimator.width = this.sft.sfr.contentView.getWidth();
    paramAnimator.height = (this.sft.sfr.contentView.getHeight() + this.sft.sfk.topMargin + this.sft.sfk.bottomMargin);
    this.sft.sfr.rOw.setLayoutParams(paramAnimator);
    this.sft.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sft.sfg.leftMargin = this.sft.sfd[0];
    this.sft.sfg.rightMargin = (this.sft.seY.getWidth() - this.sft.sfg.leftMargin - this.sft.sfr.contentView.getWidth());
    this.sft.sfg.topMargin = (this.sft.sfd[1] - af.getStatusBarHeight(this.sfi));
    this.sft.sfg.bottomMargin = (this.sft.seY.getHeight() - this.sft.sfg.topMargin - this.sft.sfr.contentView.getHeight());
    this.sft.seY.addView(this.sft.sfr.contentView, this.sft.sfg);
    AppMethodBeat.o(40042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j.3
 * JD-Core Version:    0.7.0.1
 */