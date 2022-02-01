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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends b
{
  int[] tAc;
  AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  ViewGroup zaY;
  LinearLayout.LayoutParams zaZ;
  LinearLayout.LayoutParams zba;
  LinearLayout.LayoutParams zbb;
  FrameLayout.LayoutParams zbf;
  a.a zbs;
  
  public d(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99961);
    this.tAc = new int[2];
    this.activity = paramMMActivity;
    this.zbs = ((a.a)paramBaseViewHolder);
    this.zaW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99956);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)d.this.zbs.isM.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(d.this.zbf.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(d.this.zbf.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(d.this.zbf.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.zbf.bottomMargin * f));
          d.this.zbs.isM.setLayoutParams(paramAnonymousValueAnimator);
          d.this.zbs.zeE.setScaleX(f);
          d.this.zbs.zeE.setScaleY(f);
          d.this.zbs.zeE.setAlpha(f);
        }
        AppMethodBeat.o(99956);
      }
    });
    this.zaW.setDuration(400L);
    this.zaW.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99957);
        if (d.this.zbs.fYC)
        {
          ac.i("MicroMsg.CardAdClickAnimation", "holder is busy");
          d.this.xhG.end();
          AppMethodBeat.o(99957);
          return;
        }
        d.this.zbs.fYC = true;
        d.this.zbs.isM.getLocationInWindow(d.this.tAc);
        ac.i("MicroMsg.CardAdClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(d.this.tAc[0]), Integer.valueOf(d.this.tAc[1]) });
        d.this.zbf = new FrameLayout.LayoutParams(-2, -2);
        d.this.zbf.leftMargin = d.this.tAc[0];
        d.this.zbf.rightMargin = (d.this.zaY.getWidth() - d.this.zbf.leftMargin - d.this.zbs.isM.getWidth());
        d.this.zbf.topMargin = d.this.tAc[1];
        d.this.zbf.bottomMargin = (d.this.zaY.getHeight() - d.this.zbf.topMargin - d.this.zbs.isM.getHeight());
        Object localObject1 = new int[2];
        d.this.zbs.zeE.getLocationInWindow((int[])localObject1);
        ac.i("MicroMsg.CardAdClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (d.this.zaY.getWidth() - paramAnonymousAnimator.leftMargin - d.this.zbs.zeE.getWidth());
        paramAnonymousAnimator.topMargin = localObject1[1];
        paramAnonymousAnimator.bottomMargin = (d.this.zaY.getHeight() - paramAnonymousAnimator.topMargin - d.this.zbs.zeE.getHeight());
        Object localObject2 = new int[2];
        d.this.zbs.zeF.getLocationInWindow((int[])localObject2);
        ac.i("MicroMsg.CardAdClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (d.this.zaY.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - d.this.zbs.zeF.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = localObject2[1];
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (d.this.zaY.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - d.this.zbs.zeF.getHeight());
        localObject2 = d.this.zbs.zdl.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = d.this.zbs.isM.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (d.this.zbs.isM.getHeight() + d.this.zaZ.topMargin + d.this.zaZ.bottomMargin);
        d.this.zbs.zdl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = d.this.zbf.leftMargin;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = d.this.zbf.rightMargin;
        ((FrameLayout.LayoutParams)localObject2).topMargin = d.this.zbf.topMargin;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.this.zbf.bottomMargin;
        d.this.zbs.zdl.removeView(d.this.zbs.isM);
        d.this.zaY.addView(d.this.zbs.isM, (ViewGroup.LayoutParams)localObject2);
        d.this.zbs.isM.removeView(d.this.zbs.zeE);
        d.this.zaY.addView(d.this.zbs.zeE, paramAnonymousAnimator);
        d.this.zbs.isM.removeView(d.this.zbs.zeF);
        d.this.zaY.addView(d.this.zbs.zeF, (ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(99957);
      }
    });
    this.zaX = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99958);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.zbs.zeF.setAlpha(f);
        AppMethodBeat.o(99958);
      }
    });
    this.zaX.setDuration(100L);
    this.zaZ = ((LinearLayout.LayoutParams)this.zbs.isM.getLayoutParams());
    this.zba = ((LinearLayout.LayoutParams)this.zbs.zeE.getLayoutParams());
    this.zbb = ((LinearLayout.LayoutParams)this.zbs.zeF.getLayoutParams());
    this.xhG = new AnimatorSet();
    this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
    this.zaY = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.xhG.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99960);
        ac.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
        ((ViewGroup)d.this.zbs.isM.getParent()).removeView(d.this.zbs.isM);
        ((ViewGroup)d.this.zbs.zeE.getParent()).removeView(d.this.zbs.zeE);
        ((ViewGroup)d.this.zbs.zeF.getParent()).removeView(d.this.zbs.zeF);
        d.this.zbs.zdl.addView(d.this.zbs.isM, d.this.zaZ);
        d.this.zbs.isM.addView(d.this.zbs.zeE, d.this.zba);
        d.this.zbs.isM.addView(d.this.zbs.zeF, d.this.zbb);
        d.this.zbs.zeE.setScaleX(1.0F);
        d.this.zbs.zeE.setScaleY(1.0F);
        d.this.zbs.zeE.setAlpha(1.0F);
        d.this.zbs.zeF.setAlpha(1.0F);
        if (d.this.zaU != null) {
          d.this.zaU.onAnimationEnd();
        }
        d.this.zbs.fYC = false;
        AppMethodBeat.o(99960);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99959);
        ac.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(99959);
      }
    });
    AppMethodBeat.o(99961);
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99962);
    if (!this.xhG.isStarted())
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d
 * JD-Core Version:    0.7.0.1
 */