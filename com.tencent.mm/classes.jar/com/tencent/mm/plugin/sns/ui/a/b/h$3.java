package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.c.j.b;
import com.tencent.mm.sdk.platformtools.y;

final class h$3
  extends AnimatorListenerAdapter
{
  h$3(h paramh) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
    ((ViewGroup)this.plO.plM.pok.getParent()).removeView(this.plO.plM.pok);
    this.plO.plM.pmH.addView(this.plO.plM.pok, this.plO.plz);
    this.plO.plM.pok.setScaleX(1.0F);
    this.plO.plM.pok.setScaleY(1.0F);
    this.plO.plM.pok.setAlpha(1.0F);
    this.plO.plM.pmd.setAlpha(1.0F);
    this.plO.plM.pme.setAlpha(1.0F);
    if (this.plO.pli != null) {
      this.plO.pli.onAnimationEnd();
    }
    this.plO.plM.dCs = false;
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
    if (this.plO.plM.dCs)
    {
      y.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
      this.plO.plm.end();
      return;
    }
    this.plO.plM.dCs = true;
    this.plO.plM.pok.getLocationInWindow(this.plO.pls);
    y.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(this.plO.pls[0]), Integer.valueOf(this.plO.pls[1]), Integer.valueOf(this.plO.plM.pok.getWidth()), Integer.valueOf(this.plO.plM.pok.getHeight()) });
    this.plO.plM.pmH.removeView(this.plO.plM.pok);
    paramAnimator = this.plO.plM.pmH.getLayoutParams();
    paramAnimator.width = this.plO.plM.pok.getWidth();
    paramAnimator.height = (this.plO.plM.pok.getHeight() + this.plO.plz.topMargin + this.plO.plz.bottomMargin);
    this.plO.plM.pmH.setLayoutParams(paramAnimator);
    this.plO.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plO.plv.leftMargin = this.plO.pls[0];
    this.plO.plv.rightMargin = (this.plO.pln.getWidth() - this.plO.plv.leftMargin - this.plO.plM.pok.getWidth());
    this.plO.plv.topMargin = this.plO.pls[1];
    this.plO.plv.bottomMargin = (this.plO.pln.getHeight() - this.plO.plv.topMargin - this.plO.plM.pok.getHeight());
    this.plO.pln.addView(this.plO.plM.pok, this.plO.plv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.h.3
 * JD-Core Version:    0.7.0.1
 */