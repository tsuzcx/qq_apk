package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.c.d.a;
import com.tencent.mm.sdk.platformtools.y;

final class f$3
  extends AnimatorListenerAdapter
{
  f$3(f paramf) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
    ((ViewGroup)this.plL.plJ.oUF.getParent()).removeView(this.plL.plJ.oUF);
    this.plL.plJ.pmH.addView(this.plL.plJ.oUF, this.plL.plz);
    this.plL.plJ.oUF.setScaleX(1.0F);
    this.plL.plJ.oUF.setScaleY(1.0F);
    this.plL.plJ.oUF.setAlpha(1.0F);
    this.plL.plJ.pmd.setAlpha(1.0F);
    this.plL.plJ.pme.setAlpha(1.0F);
    if (this.plL.pli != null) {
      this.plL.pli.onAnimationEnd();
    }
    this.plL.plJ.dCs = false;
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
    if (this.plL.plJ.dCs)
    {
      y.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
      this.plL.plm.end();
      return;
    }
    this.plL.plJ.dCs = true;
    this.plL.plJ.oUF.getLocationInWindow(this.plL.pls);
    y.i("MicroMsg.FullCardAdClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.plL.pls[0]), Integer.valueOf(this.plL.pls[1]) });
    this.plL.plJ.pmH.removeView(this.plL.plJ.oUF);
    paramAnimator = this.plL.plJ.pmH.getLayoutParams();
    paramAnimator.width = this.plL.plJ.oUF.getWidth();
    paramAnimator.height = (this.plL.plJ.oUF.getHeight() + this.plL.plz.topMargin + this.plL.plz.bottomMargin);
    this.plL.plJ.pmH.setLayoutParams(paramAnimator);
    this.plL.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plL.plv.leftMargin = this.plL.pls[0];
    this.plL.plv.rightMargin = (this.plL.pln.getWidth() - this.plL.plv.leftMargin - this.plL.plJ.oUF.getWidth());
    this.plL.plv.topMargin = this.plL.pls[1];
    this.plL.plv.bottomMargin = (this.plL.pln.getHeight() - this.plL.plv.topMargin - this.plL.plJ.oUF.getHeight());
    this.plL.pln.addView(this.plL.plJ.oUF, this.plL.plv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.f.3
 * JD-Core Version:    0.7.0.1
 */