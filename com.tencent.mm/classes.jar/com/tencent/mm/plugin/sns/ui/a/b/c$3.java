package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

final class c$3
  extends AnimatorListenerAdapter
{
  c$3(c paramc) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.CardAdBackAnimation", "onAnimation end");
    ((ViewGroup)this.plH.plG.pnL.getParent()).removeView(this.plH.plG.pnL);
    ((ViewGroup)this.plH.plG.pnM.getParent()).removeView(this.plH.plG.pnM);
    ((ViewGroup)this.plH.plG.pnN.getParent()).removeView(this.plH.plG.pnN);
    this.plH.plG.pmH.addView(this.plH.plG.pnL, this.plH.plo);
    this.plH.plG.pnL.addView(this.plH.plG.pnM, this.plH.plp);
    this.plH.plG.pnL.addView(this.plH.plG.pnN, this.plH.plq);
    this.plH.plG.pnM.setScaleX(1.0F);
    this.plH.plG.pnM.setScaleY(1.0F);
    this.plH.plG.pnM.setAlpha(1.0F);
    this.plH.plG.pnN.setAlpha(1.0F);
    if (this.plH.pli != null) {
      this.plH.pli.onAnimationEnd();
    }
    this.plH.plG.dCs = false;
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.CardAdBackAnimation", "onAnimation start");
    if (this.plH.plG.dCs)
    {
      y.i("MicroMsg.CardAdBackAnimation", "holder is busy");
      paramAnimator = this.plH.plm.getChildAnimations().iterator();
      while (paramAnimator.hasNext()) {
        ((Animator)paramAnimator.next()).cancel();
      }
    }
    this.plH.plG.dCs = true;
    this.plH.plG.pnL.getLocationInWindow(this.plH.pls);
    y.i("MicroMsg.CardAdBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(this.plH.pls[0]), Integer.valueOf(this.plH.pls[1]) });
    this.plH.plr = new FrameLayout.LayoutParams(-2, -2);
    this.plH.plr.leftMargin = this.plH.pls[0];
    this.plH.plr.rightMargin = (this.plH.pln.getWidth() - this.plH.plr.leftMargin - this.plH.plG.pnL.getWidth());
    this.plH.plr.topMargin = this.plH.pls[1];
    this.plH.plr.bottomMargin = (this.plH.pln.getHeight() - this.plH.plr.topMargin - this.plH.plG.pnL.getHeight());
    Object localObject = new int[2];
    this.plH.plG.pnM.getLocationInWindow((int[])localObject);
    y.i("MicroMsg.CardAdBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
    paramAnimator = new FrameLayout.LayoutParams(-2, -2);
    paramAnimator.leftMargin = localObject[0];
    paramAnimator.rightMargin = (this.plH.pln.getWidth() - paramAnimator.leftMargin - this.plH.plG.pnM.getWidth());
    paramAnimator.topMargin = localObject[1];
    paramAnimator.bottomMargin = (this.plH.pln.getHeight() - paramAnimator.topMargin - this.plH.plG.pnM.getHeight());
    localObject = this.plH.plG.pmH.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.plH.plG.pnL.getWidth();
    ((ViewGroup.LayoutParams)localObject).height = (this.plH.plG.pnL.getHeight() + this.plH.plo.topMargin + this.plH.plo.bottomMargin);
    this.plH.plG.pmH.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new int[2];
    this.plH.plG.pnN.getLocationInWindow((int[])localObject);
    y.i("MicroMsg.CardAdBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = localObject[0];
    localLayoutParams.rightMargin = (this.plH.pln.getWidth() - localLayoutParams.leftMargin - this.plH.plG.pnN.getWidth());
    localLayoutParams.topMargin = localObject[1];
    localLayoutParams.bottomMargin = (this.plH.pln.getHeight() - localLayoutParams.topMargin - this.plH.plG.pnN.getHeight());
    this.plH.plG.pnN.setAlpha(0.0F);
    this.plH.plG.pmH.removeView(this.plH.plG.pnL);
    this.plH.pln.addView(this.plH.plG.pnL, new FrameLayout.LayoutParams(-1, -1));
    this.plH.plG.pnL.removeView(this.plH.plG.pnM);
    this.plH.pln.addView(this.plH.plG.pnM, paramAnimator);
    this.plH.plG.pnL.removeView(this.plH.plG.pnN);
    this.plH.pln.addView(this.plH.plG.pnN, localLayoutParams);
    this.plH.plG.pnM.setScaleX(0.0F);
    this.plH.plG.pnM.setScaleY(0.0F);
    this.plH.plG.pnM.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.c.3
 * JD-Core Version:    0.7.0.1
 */