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
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  extends a
{
  int[] tAc;
  AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  ViewGroup zaY;
  LinearLayout.LayoutParams zaZ;
  LinearLayout.LayoutParams zba;
  LinearLayout.LayoutParams zbb;
  FrameLayout.LayoutParams zbc;
  a.a zbs;
  
  public c(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99954);
    this.tAc = new int[2];
    this.activity = paramMMActivity;
    this.zbs = ((a.a)paramBaseViewHolder);
    this.zaW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99949);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.zbs.isM.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.zbc.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.zbc.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.zbc.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.zbc.bottomMargin * f));
          c.this.zbs.isM.setLayoutParams(paramAnonymousValueAnimator);
          c.this.zbs.zeE.setScaleX(f);
          c.this.zbs.zeE.setScaleY(f);
          c.this.zbs.zeE.setAlpha(f);
        }
        AppMethodBeat.o(99949);
      }
    });
    this.zaW.setDuration(400L);
    this.zaW.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99950);
        if (c.this.zbs.fYC)
        {
          ac.i("MicroMsg.CardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = c.this.xhG.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99950);
          return;
        }
        c.this.zbs.fYC = true;
        c.this.zbs.isM.getLocationInWindow(c.this.tAc);
        ac.i("MicroMsg.CardAdBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(c.this.tAc[0]), Integer.valueOf(c.this.tAc[1]) });
        c.this.zbc = new FrameLayout.LayoutParams(-2, -2);
        c.this.zbc.leftMargin = c.this.tAc[0];
        c.this.zbc.rightMargin = (c.this.zaY.getWidth() - c.this.zbc.leftMargin - c.this.zbs.isM.getWidth());
        c.this.zbc.topMargin = c.this.tAc[1];
        c.this.zbc.bottomMargin = (c.this.zaY.getHeight() - c.this.zbc.topMargin - c.this.zbs.isM.getHeight());
        Object localObject = new int[2];
        c.this.zbs.zeE.getLocationInWindow((int[])localObject);
        ac.i("MicroMsg.CardAdBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject[0];
        paramAnonymousAnimator.rightMargin = (c.this.zaY.getWidth() - paramAnonymousAnimator.leftMargin - c.this.zbs.zeE.getWidth());
        paramAnonymousAnimator.topMargin = localObject[1];
        paramAnonymousAnimator.bottomMargin = (c.this.zaY.getHeight() - paramAnonymousAnimator.topMargin - c.this.zbs.zeE.getHeight());
        localObject = c.this.zbs.zdl.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = c.this.zbs.isM.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (c.this.zbs.isM.getHeight() + c.this.zaZ.topMargin + c.this.zaZ.bottomMargin);
        c.this.zbs.zdl.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new int[2];
        c.this.zbs.zeF.getLocationInWindow((int[])localObject);
        ac.i("MicroMsg.CardAdBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = localObject[0];
        localLayoutParams.rightMargin = (c.this.zaY.getWidth() - localLayoutParams.leftMargin - c.this.zbs.zeF.getWidth());
        localLayoutParams.topMargin = localObject[1];
        localLayoutParams.bottomMargin = (c.this.zaY.getHeight() - localLayoutParams.topMargin - c.this.zbs.zeF.getHeight());
        c.this.zbs.zeF.setAlpha(0.0F);
        c.this.zbs.zdl.removeView(c.this.zbs.isM);
        c.this.zaY.addView(c.this.zbs.isM, new FrameLayout.LayoutParams(-1, -1));
        c.this.zbs.isM.removeView(c.this.zbs.zeE);
        c.this.zaY.addView(c.this.zbs.zeE, paramAnonymousAnimator);
        c.this.zbs.isM.removeView(c.this.zbs.zeF);
        c.this.zaY.addView(c.this.zbs.zeF, localLayoutParams);
        c.this.zbs.zeE.setScaleX(0.0F);
        c.this.zbs.zeE.setScaleY(0.0F);
        c.this.zbs.zeE.setAlpha(0.0F);
        AppMethodBeat.o(99950);
      }
    });
    this.zaX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99951);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.zbs.zeF.setAlpha(f);
        AppMethodBeat.o(99951);
      }
    });
    this.zaX.setDuration(100L);
    this.zaX.setStartDelay(300L);
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
        AppMethodBeat.i(99953);
        ac.i("MicroMsg.CardAdBackAnimation", "onAnimation end");
        ((ViewGroup)c.this.zbs.isM.getParent()).removeView(c.this.zbs.isM);
        ((ViewGroup)c.this.zbs.zeE.getParent()).removeView(c.this.zbs.zeE);
        ((ViewGroup)c.this.zbs.zeF.getParent()).removeView(c.this.zbs.zeF);
        c.this.zbs.zdl.addView(c.this.zbs.isM, c.this.zaZ);
        c.this.zbs.isM.addView(c.this.zbs.zeE, c.this.zba);
        c.this.zbs.isM.addView(c.this.zbs.zeF, c.this.zbb);
        c.this.zbs.zeE.setScaleX(1.0F);
        c.this.zbs.zeE.setScaleY(1.0F);
        c.this.zbs.zeE.setAlpha(1.0F);
        c.this.zbs.zeF.setAlpha(1.0F);
        if (c.this.zaU != null) {
          c.this.zaU.onAnimationEnd();
        }
        c.this.zbs.fYC = false;
        AppMethodBeat.o(99953);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99952);
        ac.i("MicroMsg.CardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(99952);
      }
    });
    AppMethodBeat.o(99954);
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99955);
    if (!this.xhG.isStarted())
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.c
 * JD-Core Version:    0.7.0.1
 */