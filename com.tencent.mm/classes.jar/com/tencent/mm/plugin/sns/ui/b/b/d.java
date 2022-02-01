package com.tencent.mm.plugin.sns.ui.b.b;

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
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends b
{
  int[] ssm;
  AnimatorSet vWT;
  a.a xOC;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  ViewGroup xOi;
  LinearLayout.LayoutParams xOj;
  LinearLayout.LayoutParams xOk;
  LinearLayout.LayoutParams xOl;
  FrameLayout.LayoutParams xOp;
  
  public d(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99961);
    this.ssm = new int[2];
    this.activity = paramMMActivity;
    this.xOC = ((a.a)paramBaseViewHolder);
    this.xOg = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99956);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)d.this.xOC.hSH.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(d.this.xOp.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(d.this.xOp.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(d.this.xOp.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.xOp.bottomMargin * f));
          d.this.xOC.hSH.setLayoutParams(paramAnonymousValueAnimator);
          d.this.xOC.xRJ.setScaleX(f);
          d.this.xOC.xRJ.setScaleY(f);
          d.this.xOC.xRJ.setAlpha(f);
        }
        AppMethodBeat.o(99956);
      }
    });
    this.xOg.setDuration(400L);
    this.xOg.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99957);
        if (d.this.xOC.fUH)
        {
          ad.i("MicroMsg.CardAdClickAnimation", "holder is busy");
          d.this.vWT.end();
          AppMethodBeat.o(99957);
          return;
        }
        d.this.xOC.fUH = true;
        d.this.xOC.hSH.getLocationInWindow(d.this.ssm);
        ad.i("MicroMsg.CardAdClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(d.this.ssm[0]), Integer.valueOf(d.this.ssm[1]) });
        d.this.xOp = new FrameLayout.LayoutParams(-2, -2);
        d.this.xOp.leftMargin = d.this.ssm[0];
        d.this.xOp.rightMargin = (d.this.xOi.getWidth() - d.this.xOp.leftMargin - d.this.xOC.hSH.getWidth());
        d.this.xOp.topMargin = d.this.ssm[1];
        d.this.xOp.bottomMargin = (d.this.xOi.getHeight() - d.this.xOp.topMargin - d.this.xOC.hSH.getHeight());
        Object localObject1 = new int[2];
        d.this.xOC.xRJ.getLocationInWindow((int[])localObject1);
        ad.i("MicroMsg.CardAdClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (d.this.xOi.getWidth() - paramAnonymousAnimator.leftMargin - d.this.xOC.xRJ.getWidth());
        paramAnonymousAnimator.topMargin = localObject1[1];
        paramAnonymousAnimator.bottomMargin = (d.this.xOi.getHeight() - paramAnonymousAnimator.topMargin - d.this.xOC.xRJ.getHeight());
        Object localObject2 = new int[2];
        d.this.xOC.xRK.getLocationInWindow((int[])localObject2);
        ad.i("MicroMsg.CardAdClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (d.this.xOi.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - d.this.xOC.xRK.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = localObject2[1];
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (d.this.xOi.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - d.this.xOC.xRK.getHeight());
        localObject2 = d.this.xOC.xQv.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = d.this.xOC.hSH.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (d.this.xOC.hSH.getHeight() + d.this.xOj.topMargin + d.this.xOj.bottomMargin);
        d.this.xOC.xQv.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = d.this.xOp.leftMargin;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = d.this.xOp.rightMargin;
        ((FrameLayout.LayoutParams)localObject2).topMargin = d.this.xOp.topMargin;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.this.xOp.bottomMargin;
        d.this.xOC.xQv.removeView(d.this.xOC.hSH);
        d.this.xOi.addView(d.this.xOC.hSH, (ViewGroup.LayoutParams)localObject2);
        d.this.xOC.hSH.removeView(d.this.xOC.xRJ);
        d.this.xOi.addView(d.this.xOC.xRJ, paramAnonymousAnimator);
        d.this.xOC.hSH.removeView(d.this.xOC.xRK);
        d.this.xOi.addView(d.this.xOC.xRK, (ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(99957);
      }
    });
    this.xOh = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99958);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.xOC.xRK.setAlpha(f);
        AppMethodBeat.o(99958);
      }
    });
    this.xOh.setDuration(100L);
    this.xOj = ((LinearLayout.LayoutParams)this.xOC.hSH.getLayoutParams());
    this.xOk = ((LinearLayout.LayoutParams)this.xOC.xRJ.getLayoutParams());
    this.xOl = ((LinearLayout.LayoutParams)this.xOC.xRK.getLayoutParams());
    this.vWT = new AnimatorSet();
    this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
    this.xOi = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.vWT.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99960);
        ad.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
        ((ViewGroup)d.this.xOC.hSH.getParent()).removeView(d.this.xOC.hSH);
        ((ViewGroup)d.this.xOC.xRJ.getParent()).removeView(d.this.xOC.xRJ);
        ((ViewGroup)d.this.xOC.xRK.getParent()).removeView(d.this.xOC.xRK);
        d.this.xOC.xQv.addView(d.this.xOC.hSH, d.this.xOj);
        d.this.xOC.hSH.addView(d.this.xOC.xRJ, d.this.xOk);
        d.this.xOC.hSH.addView(d.this.xOC.xRK, d.this.xOl);
        d.this.xOC.xRJ.setScaleX(1.0F);
        d.this.xOC.xRJ.setScaleY(1.0F);
        d.this.xOC.xRJ.setAlpha(1.0F);
        d.this.xOC.xRK.setAlpha(1.0F);
        if (d.this.xOe != null) {
          d.this.xOe.onAnimationEnd();
        }
        d.this.xOC.fUH = false;
        AppMethodBeat.o(99960);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99959);
        ad.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(99959);
      }
    });
    AppMethodBeat.o(99961);
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99962);
    if (!this.vWT.isStarted())
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d
 * JD-Core Version:    0.7.0.1
 */