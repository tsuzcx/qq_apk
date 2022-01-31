package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.c.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public final class d
  extends b
{
  b.a plG;
  private ValueAnimator plk;
  private ValueAnimator pll;
  AnimatorSet plm;
  ViewGroup pln;
  LinearLayout.LayoutParams plo;
  LinearLayout.LayoutParams plp;
  LinearLayout.LayoutParams plq;
  int[] pls = new int[2];
  FrameLayout.LayoutParams plv;
  
  public d(MMActivity paramMMActivity, a.c paramc)
  {
    this.gfb = paramMMActivity;
    this.plG = ((b.a)paramc);
    this.plk = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.plk.addUpdateListener(new d.1(this));
    this.plk.setDuration(400L);
    this.pll = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.pll.addUpdateListener(new d.2(this));
    this.pll.setDuration(100L);
    this.plo = ((LinearLayout.LayoutParams)this.plG.pnL.getLayoutParams());
    this.plp = ((LinearLayout.LayoutParams)this.plG.pnM.getLayoutParams());
    this.plq = ((LinearLayout.LayoutParams)this.plG.pnN.getLayoutParams());
    this.plm = new AnimatorSet();
    this.plm.playTogether(new Animator[] { this.plk, this.pll });
    this.pln = ((FrameLayout)paramMMActivity.mController.uMz.getParent());
    this.plm.addListener(new d.3(this));
  }
  
  public final void gA(long paramLong)
  {
    if (!this.plm.isStarted())
    {
      this.plm.setStartDelay(paramLong);
      this.plm.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */