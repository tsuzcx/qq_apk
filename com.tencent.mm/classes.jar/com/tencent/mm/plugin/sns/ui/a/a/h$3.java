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

final class h$3
  extends AnimatorListenerAdapter
{
  h$3(h paramh, MMActivity paramMMActivity) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
    ((ViewGroup)this.plF.gfb.mController.uMz.getParent()).removeView(this.plF.plD.contentView);
    ((ViewGroup)this.plF.plD.oVY).addView(this.plF.plD.contentView, this.plF.plz);
    this.plF.plD.contentView.setScaleX(1.0F);
    this.plF.plD.contentView.setScaleY(1.0F);
    this.plF.plD.contentView.setAlpha(1.0F);
    this.plF.plD.pmo.setAlpha(1.0F);
    this.plF.plD.pmn.setAlpha(1.0F);
    if (this.plF.pli != null) {
      this.plF.pli.onAnimationEnd();
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
    this.plF.plD.contentView.getLocationInWindow(this.plF.pls);
    y.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.plF.pls[0]), Integer.valueOf(this.plF.pls[1]) });
    ((ViewGroup)this.plF.plD.oVY).removeView(this.plF.plD.contentView);
    paramAnimator = this.plF.plD.oVY.getLayoutParams();
    paramAnimator.width = this.plF.plD.contentView.getWidth();
    paramAnimator.height = (this.plF.plD.contentView.getHeight() + this.plF.plz.topMargin + this.plF.plz.bottomMargin);
    this.plF.plD.oVY.setLayoutParams(paramAnimator);
    this.plF.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plF.plv.leftMargin = this.plF.pls[0];
    this.plF.plv.rightMargin = (this.plF.pln.getWidth() - this.plF.plv.leftMargin - this.plF.plD.contentView.getWidth());
    this.plF.plv.topMargin = (this.plF.pls[1] - ak.gy(this.plx));
    this.plF.plv.bottomMargin = (this.plF.pln.getHeight() - this.plF.plv.topMargin - this.plF.plD.contentView.getHeight());
    this.plF.pln.addView(this.plF.plD.contentView, this.plF.plv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.h.3
 * JD-Core Version:    0.7.0.1
 */