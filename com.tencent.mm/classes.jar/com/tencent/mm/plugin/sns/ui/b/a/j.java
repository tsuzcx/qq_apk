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
import com.tencent.mm.plugin.sns.ui.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public final class j
  extends a
{
  private AnimatorSet CPA;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  ViewGroup EUc;
  FrameLayout.LayoutParams EUj;
  f EUt;
  LinearLayout.LayoutParams EUu;
  int[] wrA;
  
  public j(final MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99941);
    this.wrA = new int[2];
    this.activity = paramMMActivity;
    this.EUt = ((f)parama);
    this.EUa = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99937);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          j.this.EUt.contentView.setScaleX(f);
          j.this.EUt.contentView.setScaleY(f);
          j.this.EUt.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99937);
      }
    });
    this.EUa.setDuration(400L);
    this.EUb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99938);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.EUt.EWg.setAlpha(f);
        j.this.EUt.EWf.setAlpha(f);
        AppMethodBeat.o(99938);
      }
    });
    this.EUb.setDuration(100L);
    this.EUb.setStartDelay(300L);
    this.EUu = ((LinearLayout.LayoutParams)this.EUt.contentView.getLayoutParams());
    this.EUc = ((FrameLayout)this.activity.getBodyView().getParent());
    this.CPA = new AnimatorSet();
    this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
    this.CPA.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99940);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)j.this.activity.getBodyView().getParent()).removeView(j.this.EUt.contentView);
        ((ViewGroup)j.this.EUt.EAV).addView(j.this.EUt.contentView, j.this.EUu);
        j.this.EUt.contentView.setScaleX(1.0F);
        j.this.EUt.contentView.setScaleY(1.0F);
        j.this.EUt.contentView.setAlpha(1.0F);
        j.this.EUt.EWf.setAlpha(1.0F);
        j.this.EUt.EWg.setAlpha(1.0F);
        if (j.this.ETY != null) {
          j.this.ETY.onAnimationEnd();
        }
        AppMethodBeat.o(99940);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99939);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
        j.this.EUt.EWg.setAlpha(0.0F);
        j.this.EUt.EWf.setAlpha(0.0F);
        j.this.EUt.contentView.getLocationInWindow(j.this.wrA);
        Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(j.this.wrA[0]), Integer.valueOf(j.this.wrA[1]) });
        ((ViewGroup)j.this.EUt.EAV).removeView(j.this.EUt.contentView);
        paramAnonymousAnimator = j.this.EUt.EAV.getLayoutParams();
        paramAnonymousAnimator.width = j.this.EUt.contentView.getWidth();
        paramAnonymousAnimator.height = (j.this.EUt.contentView.getHeight() + j.this.EUu.topMargin + j.this.EUu.bottomMargin);
        j.this.EUt.EAV.setLayoutParams(paramAnonymousAnimator);
        j.this.EUj = new FrameLayout.LayoutParams(-2, -2);
        j.this.EUj.leftMargin = j.this.wrA[0];
        j.this.EUj.rightMargin = (j.this.EUc.getWidth() - j.this.EUj.leftMargin - j.this.EUt.contentView.getWidth());
        j.this.EUj.topMargin = (j.this.wrA[1] - ao.getStatusBarHeight(paramMMActivity));
        j.this.EUj.bottomMargin = (j.this.EUc.getHeight() - j.this.EUj.topMargin - j.this.EUt.contentView.getHeight());
        j.this.EUc.addView(j.this.EUt.contentView, j.this.EUj);
        AppMethodBeat.o(99939);
      }
    });
    AppMethodBeat.o(99941);
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99942);
    if (!this.CPA.isStarted())
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j
 * JD-Core Version:    0.7.0.1
 */