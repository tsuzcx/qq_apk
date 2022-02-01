package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  extends b
{
  m.b AKG;
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  ViewGroup AKd;
  FrameLayout.LayoutParams AKk;
  LinearLayout.LayoutParams AKu;
  int[] uOq;
  AnimatorSet yLH;
  
  public j(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100003);
    this.uOq = new int[2];
    this.activity = paramMMActivity;
    this.AKG = ((m.b)paramBaseViewHolder);
    this.AKb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99998);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ae.i("MicroMsg.TurnCardAdClickAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 1.0F)
        {
          j.this.AKG.AOY.setScaleX(f);
          j.this.AKG.AOY.setScaleY(f);
          j.this.AKG.AOY.setAlpha(f);
        }
        AppMethodBeat.o(99998);
      }
    });
    this.AKb.setDuration(400L);
    this.AKb.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99999);
        if (j.this.AKG.guz)
        {
          ae.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
          paramAnonymousAnimator = j.this.yLH.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99999);
          return;
        }
        j.this.AKG.guz = true;
        j.this.AKG.AOY.getLocationInWindow(j.this.uOq);
        ae.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(j.this.uOq[0]), Integer.valueOf(j.this.uOq[1]), Integer.valueOf(j.this.AKG.AOY.getWidth()), Integer.valueOf(j.this.AKG.AOY.getHeight()) });
        j.this.AKG.AMr.removeView(j.this.AKG.AOY);
        paramAnonymousAnimator = j.this.AKG.AMr.getLayoutParams();
        paramAnonymousAnimator.width = j.this.AKG.AOY.getWidth();
        paramAnonymousAnimator.height = (j.this.AKG.AOY.getHeight() + j.this.AKu.topMargin + j.this.AKu.bottomMargin);
        j.this.AKG.AMr.setLayoutParams(paramAnonymousAnimator);
        j.this.AKk = new FrameLayout.LayoutParams(-2, -2);
        j.this.AKk.leftMargin = j.this.uOq[0];
        j.this.AKk.rightMargin = (j.this.AKd.getWidth() - j.this.AKk.leftMargin - j.this.AKG.AOY.getWidth());
        j.this.AKk.topMargin = j.this.uOq[1];
        j.this.AKk.bottomMargin = (j.this.AKd.getHeight() - j.this.AKk.topMargin - j.this.AKG.AOY.getHeight());
        j.this.AKd.addView(j.this.AKG.AOY, j.this.AKk);
        AppMethodBeat.o(99999);
      }
    });
    this.AKc = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100000);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.AKG.tgh.setAlpha(f);
        j.this.AKG.ALc.setAlpha(f);
        AppMethodBeat.o(100000);
      }
    });
    this.AKc.setDuration(100L);
    this.AKu = ((LinearLayout.LayoutParams)this.AKG.AOY.getLayoutParams());
    this.AKd = ((FrameLayout)this.activity.getBodyView().getParent());
    this.yLH = new AnimatorSet();
    this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
    this.yLH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100002);
        ae.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.AKG.AOY.getParent()).removeView(j.this.AKG.AOY);
        j.this.AKG.AMr.addView(j.this.AKG.AOY, j.this.AKu);
        j.this.AKG.AOY.setScaleX(1.0F);
        j.this.AKG.AOY.setScaleY(1.0F);
        j.this.AKG.AOY.setAlpha(1.0F);
        j.this.AKG.tgh.setAlpha(1.0F);
        j.this.AKG.ALc.setAlpha(1.0F);
        if (j.this.AJZ != null) {
          j.this.AJZ.onAnimationEnd();
        }
        j.this.AKG.guz = false;
        AppMethodBeat.o(100002);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100001);
        ae.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(100001);
      }
    });
    AppMethodBeat.o(100003);
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(100004);
    if (!this.yLH.isStarted())
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(100004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j
 * JD-Core Version:    0.7.0.1
 */