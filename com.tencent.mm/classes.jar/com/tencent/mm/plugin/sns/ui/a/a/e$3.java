package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.a.b.b.a;
import com.tencent.mm.plugin.sns.ui.b.a.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;

final class e$3
  extends AnimatorListenerAdapter
{
  e$3(e parame, MMActivity paramMMActivity) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
    ((ViewGroup)this.plA.gfb.mController.uMz.getParent()).removeView(this.plA.ply.contentView);
    ((ViewGroup)this.plA.ply.oVY).addView(this.plA.ply.contentView, this.plA.plz);
    this.plA.ply.contentView.setScaleX(1.0F);
    this.plA.ply.contentView.setScaleY(1.0F);
    this.plA.ply.contentView.setAlpha(1.0F);
    this.plA.ply.pmd.setAlpha(1.0F);
    this.plA.ply.pme.setAlpha(1.0F);
    if (this.plA.pli != null) {
      this.plA.pli.onAnimationEnd();
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
    this.plA.ply.pmd.setAlpha(0.0F);
    this.plA.ply.pme.setAlpha(0.0F);
    this.plA.ply.contentView.getLocationInWindow(this.plA.pls);
    y.i("MicroMsg.FullCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.plA.pls[0]), Integer.valueOf(this.plA.pls[1]) });
    ((ViewGroup)this.plA.ply.oVY).removeView(this.plA.ply.contentView);
    paramAnimator = this.plA.ply.oVY.getLayoutParams();
    paramAnimator.width = this.plA.ply.contentView.getWidth();
    paramAnimator.height = (this.plA.ply.contentView.getHeight() + this.plA.plz.topMargin + this.plA.plz.bottomMargin);
    this.plA.ply.oVY.setLayoutParams(paramAnimator);
    this.plA.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plA.plv.leftMargin = this.plA.pls[0];
    this.plA.plv.rightMargin = (this.plA.pln.getWidth() - this.plA.plv.leftMargin - this.plA.ply.contentView.getWidth());
    this.plA.plv.topMargin = (this.plA.pls[1] - ak.gy(this.plx));
    this.plA.plv.bottomMargin = (this.plA.pln.getHeight() - this.plA.plv.topMargin - this.plA.ply.contentView.getHeight());
    this.plA.pln.addView(this.plA.ply.contentView, this.plA.plv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.e.3
 * JD-Core Version:    0.7.0.1
 */