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
import java.util.ArrayList;
import java.util.Iterator;

final class g$3
  extends AnimatorListenerAdapter
{
  g$3(g paramg) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
    ((ViewGroup)this.plN.plM.pok.getParent()).removeView(this.plN.plM.pok);
    this.plN.plM.pmH.addView(this.plN.plM.pok, this.plN.plz);
    this.plN.plM.pok.setScaleX(1.0F);
    this.plN.plM.pok.setScaleY(1.0F);
    this.plN.plM.pok.setAlpha(1.0F);
    this.plN.plM.pmd.setAlpha(1.0F);
    this.plN.plM.pme.setAlpha(1.0F);
    if (this.plN.pli != null) {
      this.plN.pli.onAnimationEnd();
    }
    this.plN.plM.dCs = false;
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
    if (this.plN.plM.dCs)
    {
      y.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
      paramAnimator = this.plN.plm.getChildAnimations().iterator();
      while (paramAnimator.hasNext()) {
        ((Animator)paramAnimator.next()).cancel();
      }
    }
    this.plN.plM.dCs = true;
    this.plN.plM.pmd.setAlpha(0.0F);
    this.plN.plM.pme.setAlpha(0.0F);
    this.plN.plM.pok.getLocationInWindow(this.plN.pls);
    y.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(this.plN.pls[0]), Integer.valueOf(this.plN.pls[1]) });
    this.plN.plM.pmH.removeView(this.plN.plM.pok);
    paramAnimator = this.plN.plM.pmH.getLayoutParams();
    paramAnimator.width = this.plN.plM.pok.getWidth();
    paramAnimator.height = (this.plN.plM.pok.getHeight() + this.plN.plz.topMargin + this.plN.plz.bottomMargin);
    this.plN.plM.pmH.setLayoutParams(paramAnimator);
    this.plN.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plN.plv.leftMargin = this.plN.pls[0];
    this.plN.plv.rightMargin = (this.plN.pln.getWidth() - this.plN.plv.leftMargin - this.plN.plM.pok.getWidth());
    this.plN.plv.topMargin = this.plN.pls[1];
    this.plN.plv.bottomMargin = (this.plN.pln.getHeight() - this.plN.plv.topMargin - this.plN.plM.pok.getHeight());
    this.plN.pln.addView(this.plN.plM.pok, this.plN.plv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.g.3
 * JD-Core Version:    0.7.0.1
 */