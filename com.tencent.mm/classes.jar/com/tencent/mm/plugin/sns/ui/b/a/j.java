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
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;

public final class j
  extends b
{
  int[] ssm;
  private AnimatorSet vWT;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  ViewGroup xOi;
  FrameLayout.LayoutParams xOp;
  e xOy;
  LinearLayout.LayoutParams xOz;
  
  public j(final MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99947);
    this.ssm = new int[2];
    this.activity = paramMMActivity;
    this.xOy = ((e)parama);
    this.xOg = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99943);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          j.this.xOy.contentView.setScaleX(f);
          j.this.xOy.contentView.setScaleY(f);
          j.this.xOy.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99943);
      }
    });
    this.xOg.setDuration(400L);
    this.xOh = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99944);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.xOy.xPY.setAlpha(f);
        j.this.xOy.xPX.setAlpha(f);
        AppMethodBeat.o(99944);
      }
    });
    this.xOh.setDuration(100L);
    this.xOz = ((LinearLayout.LayoutParams)this.xOy.contentView.getLayoutParams());
    this.xOi = ((FrameLayout)this.activity.getBodyView().getParent());
    this.vWT = new AnimatorSet();
    this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
    this.vWT.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99946);
        ad.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.activity.getBodyView().getParent()).removeView(j.this.xOy.contentView);
        ((ViewGroup)j.this.xOy.xwu).addView(j.this.xOy.contentView, j.this.xOz);
        j.this.xOy.contentView.setScaleX(1.0F);
        j.this.xOy.contentView.setScaleY(1.0F);
        j.this.xOy.contentView.setAlpha(1.0F);
        j.this.xOy.xPY.setAlpha(1.0F);
        j.this.xOy.xPX.setAlpha(1.0F);
        if (j.this.xOe != null) {
          j.this.xOe.onAnimationEnd();
        }
        AppMethodBeat.o(99946);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99945);
        ad.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
        j.this.xOy.contentView.getLocationInWindow(j.this.ssm);
        ad.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(j.this.ssm[0]), Integer.valueOf(j.this.ssm[1]) });
        ((ViewGroup)j.this.xOy.xwu).removeView(j.this.xOy.contentView);
        paramAnonymousAnimator = j.this.xOy.xwu.getLayoutParams();
        paramAnonymousAnimator.width = j.this.xOy.contentView.getWidth();
        paramAnonymousAnimator.height = (j.this.xOy.contentView.getHeight() + j.this.xOz.topMargin + j.this.xOz.bottomMargin);
        j.this.xOy.xwu.setLayoutParams(paramAnonymousAnimator);
        j.this.xOp = new FrameLayout.LayoutParams(-2, -2);
        j.this.xOp.leftMargin = j.this.ssm[0];
        j.this.xOp.rightMargin = (j.this.xOi.getWidth() - j.this.xOp.leftMargin - j.this.xOy.contentView.getWidth());
        j.this.xOp.topMargin = (j.this.ssm[1] - ai.iX(paramMMActivity));
        j.this.xOp.bottomMargin = (j.this.xOi.getHeight() - j.this.xOp.topMargin - j.this.xOy.contentView.getHeight());
        j.this.xOi.addView(j.this.xOy.contentView, j.this.xOp);
        AppMethodBeat.o(99945);
      }
    });
    AppMethodBeat.o(99947);
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99948);
    if (!this.vWT.isStarted())
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j
 * JD-Core Version:    0.7.0.1
 */