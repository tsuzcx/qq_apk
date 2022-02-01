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
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  extends a
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
  FrameLayout.LayoutParams xOm;
  
  public c(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99954);
    this.ssm = new int[2];
    this.activity = paramMMActivity;
    this.xOC = ((a.a)paramBaseViewHolder);
    this.xOg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99949);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.xOC.hSH.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.xOm.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.xOm.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.xOm.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.xOm.bottomMargin * f));
          c.this.xOC.hSH.setLayoutParams(paramAnonymousValueAnimator);
          c.this.xOC.xRJ.setScaleX(f);
          c.this.xOC.xRJ.setScaleY(f);
          c.this.xOC.xRJ.setAlpha(f);
        }
        AppMethodBeat.o(99949);
      }
    });
    this.xOg.setDuration(400L);
    this.xOg.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99950);
        if (c.this.xOC.fUH)
        {
          ad.i("MicroMsg.CardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = c.this.vWT.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99950);
          return;
        }
        c.this.xOC.fUH = true;
        c.this.xOC.hSH.getLocationInWindow(c.this.ssm);
        ad.i("MicroMsg.CardAdBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(c.this.ssm[0]), Integer.valueOf(c.this.ssm[1]) });
        c.this.xOm = new FrameLayout.LayoutParams(-2, -2);
        c.this.xOm.leftMargin = c.this.ssm[0];
        c.this.xOm.rightMargin = (c.this.xOi.getWidth() - c.this.xOm.leftMargin - c.this.xOC.hSH.getWidth());
        c.this.xOm.topMargin = c.this.ssm[1];
        c.this.xOm.bottomMargin = (c.this.xOi.getHeight() - c.this.xOm.topMargin - c.this.xOC.hSH.getHeight());
        Object localObject = new int[2];
        c.this.xOC.xRJ.getLocationInWindow((int[])localObject);
        ad.i("MicroMsg.CardAdBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject[0];
        paramAnonymousAnimator.rightMargin = (c.this.xOi.getWidth() - paramAnonymousAnimator.leftMargin - c.this.xOC.xRJ.getWidth());
        paramAnonymousAnimator.topMargin = localObject[1];
        paramAnonymousAnimator.bottomMargin = (c.this.xOi.getHeight() - paramAnonymousAnimator.topMargin - c.this.xOC.xRJ.getHeight());
        localObject = c.this.xOC.xQv.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = c.this.xOC.hSH.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (c.this.xOC.hSH.getHeight() + c.this.xOj.topMargin + c.this.xOj.bottomMargin);
        c.this.xOC.xQv.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new int[2];
        c.this.xOC.xRK.getLocationInWindow((int[])localObject);
        ad.i("MicroMsg.CardAdBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = localObject[0];
        localLayoutParams.rightMargin = (c.this.xOi.getWidth() - localLayoutParams.leftMargin - c.this.xOC.xRK.getWidth());
        localLayoutParams.topMargin = localObject[1];
        localLayoutParams.bottomMargin = (c.this.xOi.getHeight() - localLayoutParams.topMargin - c.this.xOC.xRK.getHeight());
        c.this.xOC.xRK.setAlpha(0.0F);
        c.this.xOC.xQv.removeView(c.this.xOC.hSH);
        c.this.xOi.addView(c.this.xOC.hSH, new FrameLayout.LayoutParams(-1, -1));
        c.this.xOC.hSH.removeView(c.this.xOC.xRJ);
        c.this.xOi.addView(c.this.xOC.xRJ, paramAnonymousAnimator);
        c.this.xOC.hSH.removeView(c.this.xOC.xRK);
        c.this.xOi.addView(c.this.xOC.xRK, localLayoutParams);
        c.this.xOC.xRJ.setScaleX(0.0F);
        c.this.xOC.xRJ.setScaleY(0.0F);
        c.this.xOC.xRJ.setAlpha(0.0F);
        AppMethodBeat.o(99950);
      }
    });
    this.xOh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99951);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.xOC.xRK.setAlpha(f);
        AppMethodBeat.o(99951);
      }
    });
    this.xOh.setDuration(100L);
    this.xOh.setStartDelay(300L);
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
        AppMethodBeat.i(99953);
        ad.i("MicroMsg.CardAdBackAnimation", "onAnimation end");
        ((ViewGroup)c.this.xOC.hSH.getParent()).removeView(c.this.xOC.hSH);
        ((ViewGroup)c.this.xOC.xRJ.getParent()).removeView(c.this.xOC.xRJ);
        ((ViewGroup)c.this.xOC.xRK.getParent()).removeView(c.this.xOC.xRK);
        c.this.xOC.xQv.addView(c.this.xOC.hSH, c.this.xOj);
        c.this.xOC.hSH.addView(c.this.xOC.xRJ, c.this.xOk);
        c.this.xOC.hSH.addView(c.this.xOC.xRK, c.this.xOl);
        c.this.xOC.xRJ.setScaleX(1.0F);
        c.this.xOC.xRJ.setScaleY(1.0F);
        c.this.xOC.xRJ.setAlpha(1.0F);
        c.this.xOC.xRK.setAlpha(1.0F);
        if (c.this.xOe != null) {
          c.this.xOe.onAnimationEnd();
        }
        c.this.xOC.fUH = false;
        AppMethodBeat.o(99953);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99952);
        ad.i("MicroMsg.CardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(99952);
      }
    });
    AppMethodBeat.o(99954);
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99955);
    if (!this.vWT.isStarted())
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.c
 * JD-Core Version:    0.7.0.1
 */