package com.tencent.mm.plugin.sns.ui.a.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.c.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public final class c
  extends a
{
  b.a plG;
  private ValueAnimator plk;
  private ValueAnimator pll;
  AnimatorSet plm;
  ViewGroup pln;
  LinearLayout.LayoutParams plo;
  LinearLayout.LayoutParams plp;
  LinearLayout.LayoutParams plq;
  FrameLayout.LayoutParams plr;
  int[] pls = new int[2];
  
  public c(MMActivity paramMMActivity, a.c paramc)
  {
    this.gfb = paramMMActivity;
    this.plG = ((b.a)paramc);
    this.plk = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.plk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.plG.pnL.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.plr.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.plr.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.plr.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.plr.bottomMargin * f));
          c.this.plG.pnL.setLayoutParams(paramAnonymousValueAnimator);
          c.this.plG.pnM.setScaleX(f);
          c.this.plG.pnM.setScaleY(f);
          c.this.plG.pnM.setAlpha(f);
        }
      }
    });
    this.plk.setDuration(400L);
    this.pll = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.pll.addUpdateListener(new c.2(this));
    this.pll.setDuration(100L);
    this.pll.setStartDelay(300L);
    this.plo = ((LinearLayout.LayoutParams)this.plG.pnL.getLayoutParams());
    this.plp = ((LinearLayout.LayoutParams)this.plG.pnM.getLayoutParams());
    this.plq = ((LinearLayout.LayoutParams)this.plG.pnN.getLayoutParams());
    this.plm = new AnimatorSet();
    this.plm.playTogether(new Animator[] { this.plk, this.pll });
    this.pln = ((FrameLayout)paramMMActivity.mController.uMz.getParent());
    this.plm.addListener(new c.3(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.c
 * JD-Core Version:    0.7.0.1
 */