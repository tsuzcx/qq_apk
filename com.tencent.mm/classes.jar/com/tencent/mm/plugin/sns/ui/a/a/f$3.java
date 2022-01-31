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

final class f$3
  extends AnimatorListenerAdapter
{
  f$3(f paramf, MMActivity paramMMActivity) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
    ((ViewGroup)this.plC.gfb.mController.uMz.getParent()).removeView(this.plC.plB.contentView);
    ((ViewGroup)this.plC.plB.oVY).addView(this.plC.plB.contentView, this.plC.plz);
    this.plC.plB.contentView.setScaleX(1.0F);
    this.plC.plB.contentView.setScaleY(1.0F);
    this.plC.plB.contentView.setAlpha(1.0F);
    this.plC.plB.pmd.setAlpha(1.0F);
    this.plC.plB.pme.setAlpha(1.0F);
    if (this.plC.pli != null) {
      this.plC.pli.onAnimationEnd();
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
    this.plC.plB.contentView.getLocationInWindow(this.plC.pls);
    y.i("MicroMsg.FullCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.plC.pls[0]), Integer.valueOf(this.plC.pls[1]) });
    ((ViewGroup)this.plC.plB.oVY).removeView(this.plC.plB.contentView);
    paramAnimator = this.plC.plB.oVY.getLayoutParams();
    paramAnimator.width = this.plC.plB.contentView.getWidth();
    paramAnimator.height = (this.plC.plB.contentView.getHeight() + this.plC.plz.topMargin + this.plC.plz.bottomMargin);
    this.plC.plB.oVY.setLayoutParams(paramAnimator);
    this.plC.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plC.plv.leftMargin = this.plC.pls[0];
    this.plC.plv.rightMargin = (this.plC.pln.getWidth() - this.plC.plv.leftMargin - this.plC.plB.contentView.getWidth());
    this.plC.plv.topMargin = (this.plC.pls[1] - ak.gy(this.plx));
    this.plC.plv.bottomMargin = (this.plC.pln.getHeight() - this.plC.plv.topMargin - this.plC.plB.contentView.getHeight());
    this.plC.pln.addView(this.plC.plB.contentView, this.plC.plv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.f.3
 * JD-Core Version:    0.7.0.1
 */