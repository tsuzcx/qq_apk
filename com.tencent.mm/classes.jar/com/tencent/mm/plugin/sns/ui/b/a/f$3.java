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

final class f$3
  extends AnimatorListenerAdapter
{
  f$3(f paramf, MMActivity paramMMActivity) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40031);
    ab.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
    ((ViewGroup)this.sfn.hwZ.getBodyView().getParent()).removeView(this.sfn.sfm.contentView);
    ((ViewGroup)this.sfn.sfm.rOw).addView(this.sfn.sfm.contentView, this.sfn.sfk);
    this.sfn.sfm.contentView.setScaleX(1.0F);
    this.sfn.sfm.contentView.setScaleY(1.0F);
    this.sfn.sfm.contentView.setAlpha(1.0F);
    this.sfn.sfm.sfT.setAlpha(1.0F);
    this.sfn.sfm.sfU.setAlpha(1.0F);
    if (this.sfn.seT != null) {
      this.sfn.seT.onAnimationEnd();
    }
    AppMethodBeat.o(40031);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40030);
    ab.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
    this.sfn.sfm.contentView.getLocationInWindow(this.sfn.sfd);
    ab.i("MicroMsg.FullCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.sfn.sfd[0]), Integer.valueOf(this.sfn.sfd[1]) });
    ((ViewGroup)this.sfn.sfm.rOw).removeView(this.sfn.sfm.contentView);
    paramAnimator = this.sfn.sfm.rOw.getLayoutParams();
    paramAnimator.width = this.sfn.sfm.contentView.getWidth();
    paramAnimator.height = (this.sfn.sfm.contentView.getHeight() + this.sfn.sfk.topMargin + this.sfn.sfk.bottomMargin);
    this.sfn.sfm.rOw.setLayoutParams(paramAnimator);
    this.sfn.sfg = new FrameLayout.LayoutParams(-2, -2);
    this.sfn.sfg.leftMargin = this.sfn.sfd[0];
    this.sfn.sfg.rightMargin = (this.sfn.seY.getWidth() - this.sfn.sfg.leftMargin - this.sfn.sfm.contentView.getWidth());
    this.sfn.sfg.topMargin = (this.sfn.sfd[1] - af.getStatusBarHeight(this.sfi));
    this.sfn.sfg.bottomMargin = (this.sfn.seY.getHeight() - this.sfn.sfg.topMargin - this.sfn.sfm.contentView.getHeight());
    this.sfn.seY.addView(this.sfn.sfm.contentView, this.sfn.sfg);
    AppMethodBeat.o(40030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f.3
 * JD-Core Version:    0.7.0.1
 */