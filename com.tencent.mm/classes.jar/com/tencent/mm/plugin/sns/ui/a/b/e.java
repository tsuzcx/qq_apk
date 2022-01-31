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
import com.tencent.mm.plugin.sns.ui.c.d.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public final class e
  extends a
{
  d.a plJ;
  private ValueAnimator plk;
  private ValueAnimator pll;
  AnimatorSet plm;
  ViewGroup pln;
  int[] pls = new int[2];
  FrameLayout.LayoutParams plv;
  LinearLayout.LayoutParams plz;
  
  public e(MMActivity paramMMActivity, a.c paramc)
  {
    this.gfb = paramMMActivity;
    this.plJ = ((d.a)paramc);
    this.plk = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.plk.addUpdateListener(new e.1(this));
    this.plk.setDuration(400L);
    this.pll = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.pll.addUpdateListener(new e.2(this));
    this.pll.setDuration(100L);
    this.pll.setStartDelay(300L);
    this.plz = ((LinearLayout.LayoutParams)this.plJ.oUF.getLayoutParams());
    this.pln = ((FrameLayout)this.gfb.mController.uMz.getParent());
    this.plm = new AnimatorSet();
    this.plm.playTogether(new Animator[] { this.plk, this.pll });
    this.plm.addListener(new e.3(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.e
 * JD-Core Version:    0.7.0.1
 */