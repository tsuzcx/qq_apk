package com.tencent.mm.plugin.sns.ui.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.a.b.b.a;
import com.tencent.mm.plugin.sns.ui.b.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;

public final class d
  extends b
{
  com.tencent.mm.plugin.sns.ui.b.a.b plj;
  private ValueAnimator plk;
  private ValueAnimator pll;
  private AnimatorSet plm;
  ViewGroup pln;
  LinearLayout.LayoutParams plo;
  LinearLayout.LayoutParams plp;
  LinearLayout.LayoutParams plq;
  int[] pls = new int[2];
  FrameLayout.LayoutParams plv;
  
  public d(final MMActivity paramMMActivity, final a parama)
  {
    this.gfb = paramMMActivity;
    this.plj = ((com.tencent.mm.plugin.sns.ui.b.a.b)parama);
    this.plk = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.plk.addUpdateListener(new d.1(this));
    this.plk.setDuration(400L);
    this.pll = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.pll.addUpdateListener(new d.2(this));
    this.pll.setDuration(100L);
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
        y.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.mController.uMz.getParent()).removeView(d.this.plj.contentView);
        ((ViewGroup)paramMMActivity.mController.uMz.getParent()).removeView(d.this.plj.pma);
        ((ViewGroup)paramMMActivity.mController.uMz.getParent()).removeView(d.this.plj.pmb);
        d.this.plj.pma.setScaleX(1.0F);
        d.this.plj.pma.setScaleY(1.0F);
        d.this.plj.pma.setAlpha(1.0F);
        ((ViewGroup)d.this.plj.oVY).addView(d.this.plj.contentView, d.this.plo);
        ((ViewGroup)d.this.plj.contentView).addView(d.this.plj.pma, d.this.plp);
        ((ViewGroup)d.this.plj.contentView).addView(d.this.plj.pmb, d.this.plq);
        d.this.plj.pmb.setAlpha(1.0F);
        if (d.this.pli != null) {
          d.this.pli.onAnimationEnd();
        }
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        y.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
        d.this.plj.contentView.getLocationInWindow(d.this.pls);
        y.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(d.this.pls[0]), Integer.valueOf(d.this.pls[1]) });
        d.this.plv = new FrameLayout.LayoutParams(-2, -2);
        d.this.plv.leftMargin = d.this.pls[0];
        d.this.plv.rightMargin = (d.this.pln.getWidth() - d.this.plv.leftMargin - d.this.plj.contentView.getWidth());
        d.this.plv.topMargin = (d.this.pls[1] - ak.gy(paramMMActivity));
        d.this.plv.bottomMargin = (d.this.pln.getHeight() - d.this.plv.topMargin - d.this.plj.contentView.getHeight());
        y.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", new Object[] { Integer.valueOf(d.this.plv.leftMargin), Integer.valueOf(d.this.plv.topMargin), Integer.valueOf(d.this.plv.rightMargin), Integer.valueOf(d.this.plv.bottomMargin) });
        Object localObject1 = new int[2];
        d.this.plj.pma.getLocationInWindow((int[])localObject1);
        y.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (d.this.pln.getWidth() - paramAnonymousAnimator.leftMargin - d.this.plj.pma.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - ak.gy(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (d.this.pln.getHeight() - paramAnonymousAnimator.topMargin - d.this.plj.pma.getHeight());
        Object localObject2 = new int[2];
        d.this.plj.pmb.getLocationInWindow((int[])localObject2);
        y.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (d.this.pln.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((com.tencent.mm.plugin.sns.ui.b.a.b)parama).pmb.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - ak.gy(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (d.this.pln.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((com.tencent.mm.plugin.sns.ui.b.a.b)parama).pmb.getHeight());
        localObject2 = d.this.plj.oVY.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = d.this.plj.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (d.this.plj.contentView.getHeight() + d.this.plo.topMargin + d.this.plo.bottomMargin);
        d.this.plj.oVY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.plj.oVY).removeView(d.this.plj.contentView);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = d.this.plv.leftMargin;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = d.this.plv.rightMargin;
        ((FrameLayout.LayoutParams)localObject2).topMargin = d.this.plv.topMargin;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.this.plv.bottomMargin;
        d.this.pln.addView(d.this.plj.contentView, (ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.plj.contentView).removeView(d.this.plj.pma);
        d.this.pln.addView(d.this.plj.pma, paramAnonymousAnimator);
        ((ViewGroup)d.this.plj.contentView).removeView(d.this.plj.pmb);
        d.this.pln.addView(d.this.plj.pmb, (ViewGroup.LayoutParams)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.d
 * JD-Core Version:    0.7.0.1
 */