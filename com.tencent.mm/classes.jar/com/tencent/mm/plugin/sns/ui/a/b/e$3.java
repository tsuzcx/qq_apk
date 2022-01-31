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
import java.util.ArrayList;
import java.util.Iterator;

final class e$3
  extends AnimatorListenerAdapter
{
  e$3(e parame) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
    ((ViewGroup)this.plK.plJ.oUF.getParent()).removeView(this.plK.plJ.oUF);
    this.plK.plJ.pmH.addView(this.plK.plJ.oUF, this.plK.plz);
    this.plK.plJ.oUF.setScaleX(1.0F);
    this.plK.plJ.oUF.setScaleY(1.0F);
    this.plK.plJ.oUF.setAlpha(1.0F);
    this.plK.plJ.pmd.setAlpha(1.0F);
    this.plK.plJ.pme.setAlpha(1.0F);
    if (this.plK.pli != null) {
      this.plK.pli.onAnimationEnd();
    }
    this.plK.plJ.dCs = false;
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
    if (this.plK.plJ.dCs)
    {
      y.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
      paramAnimator = this.plK.plm.getChildAnimations().iterator();
      while (paramAnimator.hasNext()) {
        ((Animator)paramAnimator.next()).cancel();
      }
    }
    this.plK.plJ.dCs = true;
    this.plK.plJ.oUF.getLocationInWindow(this.plK.pls);
    y.i("MicroMsg.FullCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.plK.pls[0]), Integer.valueOf(this.plK.pls[1]) });
    this.plK.plJ.pmH.removeView(this.plK.plJ.oUF);
    paramAnimator = this.plK.plJ.pmH.getLayoutParams();
    paramAnimator.width = this.plK.plJ.oUF.getWidth();
    paramAnimator.height = (this.plK.plJ.oUF.getHeight() + this.plK.plz.topMargin + this.plK.plz.bottomMargin);
    this.plK.plJ.pmH.setLayoutParams(paramAnimator);
    this.plK.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plK.plv.leftMargin = this.plK.pls[0];
    this.plK.plv.rightMargin = (this.plK.pln.getWidth() - this.plK.plv.leftMargin - this.plK.plJ.oUF.getWidth());
    this.plK.plv.topMargin = this.plK.pls[1];
    this.plK.plv.bottomMargin = (this.plK.pln.getHeight() - this.plK.plv.topMargin - this.plK.plJ.oUF.getHeight());
    this.plK.pln.addView(this.plK.plJ.oUF, this.plK.plv);
    this.plK.plJ.pmd.setAlpha(0.0F);
    this.plK.plJ.pme.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.e.3
 * JD-Core Version:    0.7.0.1
 */