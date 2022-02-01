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
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;

public final class i
  extends a
{
  int[] ssm;
  private AnimatorSet vWT;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  ViewGroup xOi;
  FrameLayout.LayoutParams xOp;
  e xOy;
  LinearLayout.LayoutParams xOz;
  
  public i(final MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99941);
    this.ssm = new int[2];
    this.activity = paramMMActivity;
    this.xOy = ((e)parama);
    this.xOg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99937);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          i.this.xOy.contentView.setScaleX(f);
          i.this.xOy.contentView.setScaleY(f);
          i.this.xOy.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99937);
      }
    });
    this.xOg.setDuration(400L);
    this.xOh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99938);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.xOy.xPY.setAlpha(f);
        i.this.xOy.xPX.setAlpha(f);
        AppMethodBeat.o(99938);
      }
    });
    this.xOh.setDuration(100L);
    this.xOh.setStartDelay(300L);
    this.xOz = ((LinearLayout.LayoutParams)this.xOy.contentView.getLayoutParams());
    this.xOi = ((FrameLayout)this.activity.getBodyView().getParent());
    this.vWT = new AnimatorSet();
    this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
    this.vWT.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99940);
        ad.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.activity.getBodyView().getParent()).removeView(i.this.xOy.contentView);
        ((ViewGroup)i.this.xOy.xwu).addView(i.this.xOy.contentView, i.this.xOz);
        i.this.xOy.contentView.setScaleX(1.0F);
        i.this.xOy.contentView.setScaleY(1.0F);
        i.this.xOy.contentView.setAlpha(1.0F);
        i.this.xOy.xPX.setAlpha(1.0F);
        i.this.xOy.xPY.setAlpha(1.0F);
        if (i.this.xOe != null) {
          i.this.xOe.onAnimationEnd();
        }
        AppMethodBeat.o(99940);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99939);
        ad.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
        i.this.xOy.xPY.setAlpha(0.0F);
        i.this.xOy.xPX.setAlpha(0.0F);
        i.this.xOy.contentView.getLocationInWindow(i.this.ssm);
        ad.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.ssm[0]), Integer.valueOf(i.this.ssm[1]) });
        ((ViewGroup)i.this.xOy.xwu).removeView(i.this.xOy.contentView);
        paramAnonymousAnimator = i.this.xOy.xwu.getLayoutParams();
        paramAnonymousAnimator.width = i.this.xOy.contentView.getWidth();
        paramAnonymousAnimator.height = (i.this.xOy.contentView.getHeight() + i.this.xOz.topMargin + i.this.xOz.bottomMargin);
        i.this.xOy.xwu.setLayoutParams(paramAnonymousAnimator);
        i.this.xOp = new FrameLayout.LayoutParams(-2, -2);
        i.this.xOp.leftMargin = i.this.ssm[0];
        i.this.xOp.rightMargin = (i.this.xOi.getWidth() - i.this.xOp.leftMargin - i.this.xOy.contentView.getWidth());
        i.this.xOp.topMargin = (i.this.ssm[1] - ai.iX(paramMMActivity));
        i.this.xOp.bottomMargin = (i.this.xOi.getHeight() - i.this.xOp.topMargin - i.this.xOy.contentView.getHeight());
        i.this.xOi.addView(i.this.xOy.contentView, i.this.xOp);
        AppMethodBeat.o(99939);
      }
    });
    AppMethodBeat.o(99941);
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99942);
    if (!this.vWT.isStarted())
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i
 * JD-Core Version:    0.7.0.1
 */