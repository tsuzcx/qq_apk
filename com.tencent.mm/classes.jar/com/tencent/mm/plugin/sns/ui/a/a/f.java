package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.b.a.a;
import com.tencent.mm.plugin.sns.ui.b.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public final class f
  extends b
{
  c plB;
  private ValueAnimator plk;
  private ValueAnimator pll;
  private AnimatorSet plm;
  ViewGroup pln;
  int[] pls = new int[2];
  FrameLayout.LayoutParams plv;
  LinearLayout.LayoutParams plz;
  
  public f(MMActivity paramMMActivity, a parama)
  {
    this.gfb = paramMMActivity;
    this.plB = ((c)parama);
    this.plk = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.plk.addUpdateListener(new f.1(this));
    this.plk.setDuration(400L);
    this.pll = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.pll.addUpdateListener(new f.2(this));
    this.pll.setDuration(100L);
    this.plz = ((LinearLayout.LayoutParams)this.plB.contentView.getLayoutParams());
    this.pln = ((FrameLayout)this.gfb.mController.uMz.getParent());
    this.plm = new AnimatorSet();
    this.plm.playTogether(new Animator[] { this.plk, this.pll });
    this.plm.addListener(new f.3(this, paramMMActivity));
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.f
 * JD-Core Version:    0.7.0.1
 */