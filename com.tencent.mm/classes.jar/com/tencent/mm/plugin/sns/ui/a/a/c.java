package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.a.b.b.a;
import com.tencent.mm.plugin.sns.ui.b.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;

public final class c
  extends a
{
  b plj;
  private ValueAnimator plk;
  private ValueAnimator pll;
  private AnimatorSet plm;
  ViewGroup pln;
  LinearLayout.LayoutParams plo;
  LinearLayout.LayoutParams plp;
  LinearLayout.LayoutParams plq;
  FrameLayout.LayoutParams plr;
  int[] pls = new int[2];
  
  public c(final MMActivity paramMMActivity, final com.tencent.mm.plugin.sns.ui.b.a.a parama)
  {
    this.gfb = paramMMActivity;
    this.plj = ((b)parama);
    this.plk = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.plk.addUpdateListener(new c.1(this));
    this.plk.setDuration(400L);
    this.pll = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.pll.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.plj.pmb.setAlpha(f);
      }
    });
    this.pll.setDuration(100L);
    this.pll.setStartDelay(300L);
    this.plo = ((LinearLayout.LayoutParams)this.plj.contentView.getLayoutParams());
    this.plp = ((LinearLayout.LayoutParams)this.plj.pma.getLayoutParams());
    this.plq = ((LinearLayout.LayoutParams)this.plj.pmb.getLayoutParams());
    this.plm = new AnimatorSet();
    this.plm.playTogether(new Animator[] { this.plk, this.pll });
    this.pln = ((FrameLayout)paramMMActivity.mController.uMz.getParent());
    this.plm.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        y.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.mController.uMz.getParent()).removeView(c.this.plj.contentView);
        ((ViewGroup)paramMMActivity.mController.uMz.getParent()).removeView(c.this.plj.pma);
        ((ViewGroup)paramMMActivity.mController.uMz.getParent()).removeView(c.this.plj.pmb);
        c.this.plj.pma.setScaleX(1.0F);
        c.this.plj.pma.setScaleY(1.0F);
        c.this.plj.pma.setAlpha(1.0F);
        ((ViewGroup)c.this.plj.oVY).addView(c.this.plj.contentView, c.this.plo);
        ((ViewGroup)c.this.plj.contentView).addView(c.this.plj.pma, c.this.plp);
        ((ViewGroup)c.this.plj.contentView).addView(c.this.plj.pmb, c.this.plq);
        c.this.plj.contentView.setAlpha(1.0F);
        c.this.plj.pmb.setAlpha(1.0F);
        if (c.this.pli != null) {
          c.this.pli.onAnimationEnd();
        }
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        y.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
        c.this.plj.contentView.getLocationInWindow(c.this.pls);
        y.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(c.this.pls[0]), Integer.valueOf(c.this.pls[1]) });
        c.this.plr = new FrameLayout.LayoutParams(-2, -2);
        c.this.plr.leftMargin = c.this.pls[0];
        c.this.plr.rightMargin = (c.this.pln.getWidth() - c.this.plr.leftMargin - c.this.plj.contentView.getWidth());
        c.this.plr.topMargin = (c.this.pls[1] - ak.gy(paramMMActivity));
        c.this.plr.bottomMargin = (c.this.pln.getHeight() - c.this.plr.topMargin - c.this.plj.contentView.getHeight());
        Object localObject1 = new int[2];
        c.this.plj.pma.getLocationInWindow((int[])localObject1);
        y.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (c.this.pln.getWidth() - paramAnonymousAnimator.leftMargin - c.this.plj.pma.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - ak.gy(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (c.this.pln.getHeight() - paramAnonymousAnimator.topMargin - c.this.plj.pma.getHeight());
        Object localObject2 = new int[2];
        c.this.plj.pmb.getLocationInWindow((int[])localObject2);
        y.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (c.this.pln.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((b)parama).pmb.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - ak.gy(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (c.this.pln.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((b)parama).pmb.getHeight());
        localObject2 = c.this.plj.oVY.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = c.this.plj.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (c.this.plj.contentView.getHeight() + c.this.plo.topMargin + c.this.plo.bottomMargin);
        c.this.plj.oVY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        c.this.plj.pmb.setAlpha(0.0F);
        ((ViewGroup)c.this.plj.oVY).removeView(c.this.plj.contentView);
        c.this.pln.addView(c.this.plj.contentView, new FrameLayout.LayoutParams(-1, -1));
        ((ViewGroup)c.this.plj.contentView).removeView(c.this.plj.pma);
        c.this.pln.addView(c.this.plj.pma, paramAnonymousAnimator);
        ((ViewGroup)c.this.plj.contentView).removeView(c.this.plj.pmb);
        c.this.pln.addView(c.this.plj.pmb, (ViewGroup.LayoutParams)localObject1);
        c.this.plj.pma.setScaleX(0.0F);
        c.this.plj.pma.setScaleY(0.0F);
        c.this.plj.pma.setAlpha(0.0F);
      }
    });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.c
 * JD-Core Version:    0.7.0.1
 */