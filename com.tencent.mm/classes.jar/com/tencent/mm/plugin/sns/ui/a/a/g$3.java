package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.a.b.b.a;
import com.tencent.mm.plugin.sns.ui.b.a.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;

final class g$3
  extends AnimatorListenerAdapter
{
  g$3(g paramg, MMActivity paramMMActivity) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
    ((ViewGroup)this.plE.gfb.mController.uMz.getParent()).removeView(this.plE.plD.contentView);
    ((ViewGroup)this.plE.plD.oVY).addView(this.plE.plD.contentView, this.plE.plz);
    this.plE.plD.contentView.setScaleX(1.0F);
    this.plE.plD.contentView.setScaleY(1.0F);
    this.plE.plD.contentView.setAlpha(1.0F);
    this.plE.plD.pmn.setAlpha(1.0F);
    this.plE.plD.pmo.setAlpha(1.0F);
    if (this.plE.pli != null) {
      this.plE.pli.onAnimationEnd();
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
    this.plE.plD.pmo.setAlpha(0.0F);
    this.plE.plD.pmn.setAlpha(0.0F);
    this.plE.plD.contentView.getLocationInWindow(this.plE.pls);
    y.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.plE.pls[0]), Integer.valueOf(this.plE.pls[1]) });
    ((ViewGroup)this.plE.plD.oVY).removeView(this.plE.plD.contentView);
    paramAnimator = this.plE.plD.oVY.getLayoutParams();
    paramAnimator.width = this.plE.plD.contentView.getWidth();
    paramAnimator.height = (this.plE.plD.contentView.getHeight() + this.plE.plz.topMargin + this.plE.plz.bottomMargin);
    this.plE.plD.oVY.setLayoutParams(paramAnimator);
    this.plE.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plE.plv.leftMargin = this.plE.pls[0];
    this.plE.plv.rightMargin = (this.plE.pln.getWidth() - this.plE.plv.leftMargin - this.plE.plD.contentView.getWidth());
    this.plE.plv.topMargin = (this.plE.pls[1] - ak.gy(this.plx));
    this.plE.plv.bottomMargin = (this.plE.pln.getHeight() - this.plE.plv.topMargin - this.plE.plD.contentView.getHeight());
    this.plE.pln.addView(this.plE.plD.contentView, this.plE.plv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.g.3
 * JD-Core Version:    0.7.0.1
 */