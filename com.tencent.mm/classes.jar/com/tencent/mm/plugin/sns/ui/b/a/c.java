package com.tencent.mm.plugin.sns.ui.b.a;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;

public final class c
  extends a
{
  int[] ssm;
  private AnimatorSet vWT;
  b xOf;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  ViewGroup xOi;
  LinearLayout.LayoutParams xOj;
  LinearLayout.LayoutParams xOk;
  LinearLayout.LayoutParams xOl;
  FrameLayout.LayoutParams xOm;
  
  public c(final MMActivity paramMMActivity, final com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99904);
    this.ssm = new int[2];
    this.activity = paramMMActivity;
    this.xOf = ((b)parama);
    this.xOg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99900);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.xOf.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.xOm.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.xOm.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.xOm.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.xOm.bottomMargin * f));
          paramAnonymousValueAnimator.width = (c.this.xOi.getWidth() - paramAnonymousValueAnimator.leftMargin - paramAnonymousValueAnimator.rightMargin);
          paramAnonymousValueAnimator.height = (c.this.xOi.getHeight() - paramAnonymousValueAnimator.topMargin - paramAnonymousValueAnimator.bottomMargin);
          c.this.xOf.contentView.setLayoutParams(paramAnonymousValueAnimator);
          c.this.xOf.contentView.setAlpha(f);
          c.this.xOf.xOY.setScaleX(f);
          c.this.xOf.xOY.setScaleY(f);
          c.this.xOf.xOY.setAlpha(f);
        }
        AppMethodBeat.o(99900);
      }
    });
    this.xOg.setDuration(400L);
    this.xOh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99901);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.xOf.xOZ.setAlpha(f);
        AppMethodBeat.o(99901);
      }
    });
    this.xOh.setDuration(100L);
    this.xOh.setStartDelay(300L);
    this.xOj = ((LinearLayout.LayoutParams)this.xOf.contentView.getLayoutParams());
    this.xOk = ((LinearLayout.LayoutParams)this.xOf.xOY.getLayoutParams());
    this.xOl = ((LinearLayout.LayoutParams)this.xOf.xOZ.getLayoutParams());
    this.vWT = new AnimatorSet();
    this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
    this.xOi = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.vWT.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99903);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.xOf.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.xOf.xOY);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.xOf.xOZ);
        c.this.xOf.xOY.setScaleX(1.0F);
        c.this.xOf.xOY.setScaleY(1.0F);
        c.this.xOf.xOY.setAlpha(1.0F);
        ((ViewGroup)c.this.xOf.xwu).addView(c.this.xOf.contentView, c.this.xOj);
        ((ViewGroup)c.this.xOf.contentView).addView(c.this.xOf.xOY, c.this.xOk);
        ((ViewGroup)c.this.xOf.contentView).addView(c.this.xOf.xOZ, c.this.xOl);
        c.this.xOf.contentView.setAlpha(1.0F);
        c.this.xOf.xOZ.setAlpha(1.0F);
        if (c.this.xOe != null) {
          c.this.xOe.onAnimationEnd();
        }
        AppMethodBeat.o(99903);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99902);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
        c.this.xOf.contentView.getLocationInWindow(c.this.ssm);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(c.this.ssm[0]), Integer.valueOf(c.this.ssm[1]) });
        c.this.xOm = new FrameLayout.LayoutParams(-2, -2);
        c.this.xOm.leftMargin = c.this.ssm[0];
        c.this.xOm.rightMargin = (c.this.xOi.getWidth() - c.this.xOm.leftMargin - c.this.xOf.contentView.getWidth());
        c.this.xOm.topMargin = (c.this.ssm[1] - ai.iX(paramMMActivity));
        c.this.xOm.bottomMargin = (c.this.xOi.getHeight() - c.this.xOm.topMargin - c.this.xOf.contentView.getHeight());
        Object localObject1 = new int[2];
        c.this.xOf.xOY.getLocationInWindow((int[])localObject1);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (c.this.xOi.getWidth() - paramAnonymousAnimator.leftMargin - c.this.xOf.xOY.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - ai.iX(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (c.this.xOi.getHeight() - paramAnonymousAnimator.topMargin - c.this.xOf.xOY.getHeight());
        Object localObject2 = new int[2];
        c.this.xOf.xOZ.getLocationInWindow((int[])localObject2);
        ad.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (c.this.xOi.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((b)parama).xOZ.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - ai.iX(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (c.this.xOi.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((b)parama).xOZ.getHeight());
        localObject2 = c.this.xOf.xwu.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = c.this.xOf.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (c.this.xOf.contentView.getHeight() + c.this.xOj.topMargin + c.this.xOj.bottomMargin);
        c.this.xOf.xwu.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        c.this.xOf.xOZ.setAlpha(0.0F);
        ((ViewGroup)c.this.xOf.xwu).removeView(c.this.xOf.contentView);
        c.this.xOi.addView(c.this.xOf.contentView, new FrameLayout.LayoutParams(-1, -1));
        ((ViewGroup)c.this.xOf.contentView).removeView(c.this.xOf.xOY);
        c.this.xOi.addView(c.this.xOf.xOY, paramAnonymousAnimator);
        ((ViewGroup)c.this.xOf.contentView).removeView(c.this.xOf.xOZ);
        c.this.xOi.addView(c.this.xOf.xOZ, (ViewGroup.LayoutParams)localObject1);
        c.this.xOf.xOY.setScaleX(0.0F);
        c.this.xOf.xOY.setScaleY(0.0F);
        c.this.xOf.xOY.setAlpha(0.0F);
        AppMethodBeat.o(99902);
      }
    });
    AppMethodBeat.o(99904);
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99905);
    if (!this.vWT.isStarted())
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */