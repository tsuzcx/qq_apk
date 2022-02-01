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
import com.tencent.mm.plugin.sns.ui.item.p.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  extends b
{
  AnimatorSet CPA;
  p.b EUH;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  ViewGroup EUc;
  FrameLayout.LayoutParams EUj;
  LinearLayout.LayoutParams EUu;
  int[] wrA;
  
  public k(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100003);
    this.wrA = new int[2];
    this.activity = paramMMActivity;
    this.EUH = ((p.b)paramBaseViewHolder);
    this.EUa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99998);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        Log.i("MicroMsg.TurnCardAdClickAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 1.0F)
        {
          k.this.EUH.EZD.setScaleX(f);
          k.this.EUH.EZD.setScaleY(f);
          k.this.EUH.EZD.setAlpha(f);
        }
        AppMethodBeat.o(99998);
      }
    });
    this.EUa.setDuration(400L);
    this.EUa.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99999);
        if (k.this.EUH.hho)
        {
          Log.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
          paramAnonymousAnimator = k.this.CPA.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99999);
          return;
        }
        k.this.EUH.hho = true;
        k.this.EUH.EZD.getLocationInWindow(k.this.wrA);
        Log.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", new Object[] { Integer.valueOf(k.this.wrA[0]), Integer.valueOf(k.this.wrA[1]), Integer.valueOf(k.this.EUH.EZD.getWidth()), Integer.valueOf(k.this.EUH.EZD.getHeight()) });
        k.this.EUH.EWC.removeView(k.this.EUH.EZD);
        paramAnonymousAnimator = k.this.EUH.EWC.getLayoutParams();
        paramAnonymousAnimator.width = k.this.EUH.EZD.getWidth();
        paramAnonymousAnimator.height = (k.this.EUH.EZD.getHeight() + k.this.EUu.topMargin + k.this.EUu.bottomMargin);
        k.this.EUH.EWC.setLayoutParams(paramAnonymousAnimator);
        k.this.EUj = new FrameLayout.LayoutParams(-2, -2);
        k.this.EUj.leftMargin = k.this.wrA[0];
        k.this.EUj.rightMargin = (k.this.EUc.getWidth() - k.this.EUj.leftMargin - k.this.EUH.EZD.getWidth());
        k.this.EUj.topMargin = k.this.wrA[1];
        k.this.EUj.bottomMargin = (k.this.EUc.getHeight() - k.this.EUj.topMargin - k.this.EUH.EZD.getHeight());
        k.this.EUc.addView(k.this.EUH.EZD, k.this.EUj);
        AppMethodBeat.o(99999);
      }
    });
    this.EUb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100000);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        k.this.EUH.wnX.setAlpha(f);
        k.this.EUH.EVh.setAlpha(f);
        AppMethodBeat.o(100000);
      }
    });
    this.EUb.setDuration(100L);
    this.EUu = ((LinearLayout.LayoutParams)this.EUH.EZD.getLayoutParams());
    this.EUc = ((FrameLayout)this.activity.getBodyView().getParent());
    this.CPA = new AnimatorSet();
    this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
    this.CPA.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100002);
        Log.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
        ((ViewGroup)k.this.EUH.EZD.getParent()).removeView(k.this.EUH.EZD);
        k.this.EUH.EWC.addView(k.this.EUH.EZD, k.this.EUu);
        k.this.EUH.EZD.setScaleX(1.0F);
        k.this.EUH.EZD.setScaleY(1.0F);
        k.this.EUH.EZD.setAlpha(1.0F);
        k.this.EUH.wnX.setAlpha(1.0F);
        k.this.EUH.EVh.setAlpha(1.0F);
        if (k.this.ETY != null) {
          k.this.ETY.onAnimationEnd();
        }
        k.this.EUH.hho = false;
        AppMethodBeat.o(100002);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100001);
        Log.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(100001);
      }
    });
    AppMethodBeat.o(100003);
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(100004);
    if (!this.CPA.isStarted())
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(100004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.k
 * JD-Core Version:    0.7.0.1
 */