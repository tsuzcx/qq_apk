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

final class d$3
  extends AnimatorListenerAdapter
{
  d$3(d paramd) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
    ((ViewGroup)this.plI.plG.pnL.getParent()).removeView(this.plI.plG.pnL);
    ((ViewGroup)this.plI.plG.pnM.getParent()).removeView(this.plI.plG.pnM);
    ((ViewGroup)this.plI.plG.pnN.getParent()).removeView(this.plI.plG.pnN);
    this.plI.plG.pmH.addView(this.plI.plG.pnL, this.plI.plo);
    this.plI.plG.pnL.addView(this.plI.plG.pnM, this.plI.plp);
    this.plI.plG.pnL.addView(this.plI.plG.pnN, this.plI.plq);
    this.plI.plG.pnM.setScaleX(1.0F);
    this.plI.plG.pnM.setScaleY(1.0F);
    this.plI.plG.pnM.setAlpha(1.0F);
    this.plI.plG.pnN.setAlpha(1.0F);
    if (this.plI.pli != null) {
      this.plI.pli.onAnimationEnd();
    }
    this.plI.plG.dCs = false;
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
    if (this.plI.plG.dCs)
    {
      y.i("MicroMsg.CardAdClickAnimation", "holder is busy");
      this.plI.plm.end();
      return;
    }
    this.plI.plG.dCs = true;
    this.plI.plG.pnL.getLocationInWindow(this.plI.pls);
    y.i("MicroMsg.CardAdClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(this.plI.pls[0]), Integer.valueOf(this.plI.pls[1]) });
    this.plI.plv = new FrameLayout.LayoutParams(-2, -2);
    this.plI.plv.leftMargin = this.plI.pls[0];
    this.plI.plv.rightMargin = (this.plI.pln.getWidth() - this.plI.plv.leftMargin - this.plI.plG.pnL.getWidth());
    this.plI.plv.topMargin = this.plI.pls[1];
    this.plI.plv.bottomMargin = (this.plI.pln.getHeight() - this.plI.plv.topMargin - this.plI.plG.pnL.getHeight());
    Object localObject1 = new int[2];
    this.plI.plG.pnM.getLocationInWindow((int[])localObject1);
    y.i("MicroMsg.CardAdClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
    paramAnimator = new FrameLayout.LayoutParams(-2, -2);
    paramAnimator.leftMargin = localObject1[0];
    paramAnimator.rightMargin = (this.plI.pln.getWidth() - paramAnimator.leftMargin - this.plI.plG.pnM.getWidth());
    paramAnimator.topMargin = localObject1[1];
    paramAnimator.bottomMargin = (this.plI.pln.getHeight() - paramAnimator.topMargin - this.plI.plG.pnM.getHeight());
    Object localObject2 = new int[2];
    this.plI.plG.pnN.getLocationInWindow((int[])localObject2);
    y.i("MicroMsg.CardAdClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
    localObject1 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
    ((FrameLayout.LayoutParams)localObject1).rightMargin = (this.plI.pln.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - this.plI.plG.pnN.getWidth());
    ((FrameLayout.LayoutParams)localObject1).topMargin = localObject2[1];
    ((FrameLayout.LayoutParams)localObject1).bottomMargin = (this.plI.pln.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - this.plI.plG.pnN.getHeight());
    localObject2 = this.plI.plG.pmH.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = this.plI.plG.pnL.getWidth();
    ((ViewGroup.LayoutParams)localObject2).height = (this.plI.plG.pnL.getHeight() + this.plI.plo.topMargin + this.plI.plo.bottomMargin);
    this.plI.plG.pmH.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject2).leftMargin = this.plI.plv.leftMargin;
    ((FrameLayout.LayoutParams)localObject2).rightMargin = this.plI.plv.rightMargin;
    ((FrameLayout.LayoutParams)localObject2).topMargin = this.plI.plv.topMargin;
    ((FrameLayout.LayoutParams)localObject2).bottomMargin = this.plI.plv.bottomMargin;
    this.plI.plG.pmH.removeView(this.plI.plG.pnL);
    this.plI.pln.addView(this.plI.plG.pnL, (ViewGroup.LayoutParams)localObject2);
    this.plI.plG.pnL.removeView(this.plI.plG.pnM);
    this.plI.pln.addView(this.plI.plG.pnM, paramAnimator);
    this.plI.plG.pnL.removeView(this.plI.plG.pnN);
    this.plI.pln.addView(this.plI.plG.pnN, (ViewGroup.LayoutParams)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d.3
 * JD-Core Version:    0.7.0.1
 */