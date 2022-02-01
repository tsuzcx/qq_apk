package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;

public final class p
  extends b
{
  int[] BdE;
  private AnimatorSet IVc;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  i Liu;
  ViewGroup Liv;
  LinearLayout.LayoutParams Liw;
  FrameLayout.LayoutParams Lix;
  
  public p(final MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(99947);
    this.BdE = new int[2];
    this.activity = paramMMActivity;
    this.Liu = ((i)paramb);
    this.Lif = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99943);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          p.this.Liu.contentView.setScaleX(f);
          p.this.Liu.contentView.setScaleY(f);
          p.this.Liu.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99943);
      }
    });
    this.Lif.setDuration(400L);
    this.Lig = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99944);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        p.this.Liu.Lkr.setAlpha(f);
        p.this.Liu.Lkq.setAlpha(f);
        AppMethodBeat.o(99944);
      }
    });
    this.Lig.setDuration(100L);
    this.Liw = ((LinearLayout.LayoutParams)this.Liu.contentView.getLayoutParams());
    this.Liv = ((FrameLayout)this.activity.getBodyView().getParent());
    this.IVc = new AnimatorSet();
    this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
    this.IVc.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99946);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)p.this.activity.getBodyView().getParent()).removeView(p.this.Liu.contentView);
        ((ViewGroup)p.this.Liu.KON).addView(p.this.Liu.contentView, p.this.Liw);
        p.this.Liu.contentView.setScaleX(1.0F);
        p.this.Liu.contentView.setScaleY(1.0F);
        p.this.Liu.contentView.setAlpha(1.0F);
        p.this.Liu.Lkr.setAlpha(1.0F);
        p.this.Liu.Lkq.setAlpha(1.0F);
        if (p.this.Lia != null) {
          p.this.Lia.onAnimationEnd();
        }
        AppMethodBeat.o(99946);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99945);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
        p.this.Liu.contentView.getLocationInWindow(p.this.BdE);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(p.this.BdE[0]), Integer.valueOf(p.this.BdE[1]) });
        ((ViewGroup)p.this.Liu.KON).removeView(p.this.Liu.contentView);
        paramAnonymousAnimator = p.this.Liu.KON.getLayoutParams();
        paramAnonymousAnimator.width = p.this.Liu.contentView.getWidth();
        paramAnonymousAnimator.height = (p.this.Liu.contentView.getHeight() + p.this.Liw.topMargin + p.this.Liw.bottomMargin);
        p.this.Liu.KON.setLayoutParams(paramAnonymousAnimator);
        p.this.Lix = new FrameLayout.LayoutParams(-2, -2);
        p.this.Lix.leftMargin = p.this.BdE[0];
        p.this.Lix.rightMargin = (p.this.Liv.getWidth() - p.this.Lix.leftMargin - p.this.Liu.contentView.getWidth());
        p.this.Lix.topMargin = (p.this.BdE[1] - ar.getStatusBarHeight(paramMMActivity));
        p.this.Lix.bottomMargin = (p.this.Liv.getHeight() - p.this.Lix.topMargin - p.this.Liu.contentView.getHeight());
        p.this.Liv.addView(p.this.Liu.contentView, p.this.Lix);
        AppMethodBeat.o(99945);
      }
    });
    AppMethodBeat.o(99947);
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99948);
    if (!this.IVc.isStarted())
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.p
 * JD-Core Version:    0.7.0.1
 */