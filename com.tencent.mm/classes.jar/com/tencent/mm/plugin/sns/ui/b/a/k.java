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
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public final class k
  extends b
{
  private AnimatorSet CPA;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  ViewGroup EUc;
  FrameLayout.LayoutParams EUj;
  f EUt;
  LinearLayout.LayoutParams EUu;
  int[] wrA;
  
  public k(final MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99947);
    this.wrA = new int[2];
    this.activity = paramMMActivity;
    this.EUt = ((f)parama);
    this.EUa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99943);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          k.this.EUt.contentView.setScaleX(f);
          k.this.EUt.contentView.setScaleY(f);
          k.this.EUt.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99943);
      }
    });
    this.EUa.setDuration(400L);
    this.EUb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99944);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        k.this.EUt.EWg.setAlpha(f);
        k.this.EUt.EWf.setAlpha(f);
        AppMethodBeat.o(99944);
      }
    });
    this.EUb.setDuration(100L);
    this.EUu = ((LinearLayout.LayoutParams)this.EUt.contentView.getLayoutParams());
    this.EUc = ((FrameLayout)this.activity.getBodyView().getParent());
    this.CPA = new AnimatorSet();
    this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
    this.CPA.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99946);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)k.this.activity.getBodyView().getParent()).removeView(k.this.EUt.contentView);
        ((ViewGroup)k.this.EUt.EAV).addView(k.this.EUt.contentView, k.this.EUu);
        k.this.EUt.contentView.setScaleX(1.0F);
        k.this.EUt.contentView.setScaleY(1.0F);
        k.this.EUt.contentView.setAlpha(1.0F);
        k.this.EUt.EWg.setAlpha(1.0F);
        k.this.EUt.EWf.setAlpha(1.0F);
        if (k.this.ETY != null) {
          k.this.ETY.onAnimationEnd();
        }
        AppMethodBeat.o(99946);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99945);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
        k.this.EUt.contentView.getLocationInWindow(k.this.wrA);
        Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(k.this.wrA[0]), Integer.valueOf(k.this.wrA[1]) });
        ((ViewGroup)k.this.EUt.EAV).removeView(k.this.EUt.contentView);
        paramAnonymousAnimator = k.this.EUt.EAV.getLayoutParams();
        paramAnonymousAnimator.width = k.this.EUt.contentView.getWidth();
        paramAnonymousAnimator.height = (k.this.EUt.contentView.getHeight() + k.this.EUu.topMargin + k.this.EUu.bottomMargin);
        k.this.EUt.EAV.setLayoutParams(paramAnonymousAnimator);
        k.this.EUj = new FrameLayout.LayoutParams(-2, -2);
        k.this.EUj.leftMargin = k.this.wrA[0];
        k.this.EUj.rightMargin = (k.this.EUc.getWidth() - k.this.EUj.leftMargin - k.this.EUt.contentView.getWidth());
        k.this.EUj.topMargin = (k.this.wrA[1] - ao.getStatusBarHeight(paramMMActivity));
        k.this.EUj.bottomMargin = (k.this.EUc.getHeight() - k.this.EUj.topMargin - k.this.EUt.contentView.getHeight());
        k.this.EUc.addView(k.this.EUt.contentView, k.this.EUj);
        AppMethodBeat.o(99945);
      }
    });
    AppMethodBeat.o(99947);
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99948);
    if (!this.CPA.isStarted())
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.k
 * JD-Core Version:    0.7.0.1
 */