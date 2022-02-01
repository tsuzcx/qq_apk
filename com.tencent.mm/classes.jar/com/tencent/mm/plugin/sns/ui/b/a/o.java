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
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.plugin.sns.ui.c.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;

public final class o
  extends a
{
  int[] BdE;
  private AnimatorSet IVc;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  i Liu;
  ViewGroup Liv;
  LinearLayout.LayoutParams Liw;
  FrameLayout.LayoutParams Lix;
  
  public o(final MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(99941);
    this.BdE = new int[2];
    this.activity = paramMMActivity;
    this.Liu = ((i)paramb);
    this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99937);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          o.this.Liu.contentView.setScaleX(f);
          o.this.Liu.contentView.setScaleY(f);
          o.this.Liu.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99937);
      }
    });
    this.Lif.setDuration(400L);
    this.Lig = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99938);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        o.this.Liu.Lkr.setAlpha(f);
        o.this.Liu.Lkq.setAlpha(f);
        AppMethodBeat.o(99938);
      }
    });
    this.Lig.setDuration(100L);
    this.Lig.setStartDelay(300L);
    this.Liw = ((LinearLayout.LayoutParams)this.Liu.contentView.getLayoutParams());
    this.Liv = ((FrameLayout)this.activity.getBodyView().getParent());
    this.IVc = new AnimatorSet();
    this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
    this.IVc.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99940);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)o.this.activity.getBodyView().getParent()).removeView(o.this.Liu.contentView);
        ((ViewGroup)o.this.Liu.KON).addView(o.this.Liu.contentView, o.this.Liw);
        o.this.Liu.contentView.setScaleX(1.0F);
        o.this.Liu.contentView.setScaleY(1.0F);
        o.this.Liu.contentView.setAlpha(1.0F);
        o.this.Liu.Lkq.setAlpha(1.0F);
        o.this.Liu.Lkr.setAlpha(1.0F);
        if (o.this.Lia != null) {
          o.this.Lia.onAnimationEnd();
        }
        AppMethodBeat.o(99940);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99939);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
        o.this.Liu.Lkr.setAlpha(0.0F);
        o.this.Liu.Lkq.setAlpha(0.0F);
        o.this.Liu.contentView.getLocationInWindow(o.this.BdE);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(o.this.BdE[0]), Integer.valueOf(o.this.BdE[1]) });
        ((ViewGroup)o.this.Liu.KON).removeView(o.this.Liu.contentView);
        paramAnonymousAnimator = o.this.Liu.KON.getLayoutParams();
        paramAnonymousAnimator.width = o.this.Liu.contentView.getWidth();
        paramAnonymousAnimator.height = (o.this.Liu.contentView.getHeight() + o.this.Liw.topMargin + o.this.Liw.bottomMargin);
        o.this.Liu.KON.setLayoutParams(paramAnonymousAnimator);
        o.this.Lix = new FrameLayout.LayoutParams(-2, -2);
        o.this.Lix.leftMargin = o.this.BdE[0];
        o.this.Lix.rightMargin = (o.this.Liv.getWidth() - o.this.Lix.leftMargin - o.this.Liu.contentView.getWidth());
        o.this.Lix.topMargin = (o.this.BdE[1] - ar.getStatusBarHeight(paramMMActivity));
        o.this.Lix.bottomMargin = (o.this.Liv.getHeight() - o.this.Lix.topMargin - o.this.Liu.contentView.getHeight());
        o.this.Liv.addView(o.this.Liu.contentView, o.this.Lix);
        AppMethodBeat.o(99939);
      }
    });
    AppMethodBeat.o(99941);
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99942);
    if (!this.IVc.isStarted())
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.o
 * JD-Core Version:    0.7.0.1
 */