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

public final class j
  extends a
{
  AnimatorSet CPA;
  p.b EUH;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  ViewGroup EUc;
  FrameLayout.LayoutParams EUj;
  LinearLayout.LayoutParams EUu;
  int[] wrA;
  
  public j(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99996);
    this.wrA = new int[2];
    this.activity = paramMMActivity;
    this.EUH = ((p.b)paramBaseViewHolder);
    this.EUa = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99991);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        Log.i("MicroMsg.TurnCardAdBackAnimation", "value %f", new Object[] { Float.valueOf(f) });
        if (f != 0.0F)
        {
          j.this.EUH.EZD.setScaleX(f);
          j.this.EUH.EZD.setScaleY(f);
          j.this.EUH.EZD.setAlpha(f);
        }
        AppMethodBeat.o(99991);
      }
    });
    this.EUa.setDuration(400L);
    this.EUa.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99992);
        if (j.this.EUH.hho)
        {
          Log.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
          paramAnonymousAnimator = j.this.CPA.getChildAnimations().iterator();
          while (paramAnonymousAnimator.hasNext()) {
            ((Animator)paramAnonymousAnimator.next()).cancel();
          }
          AppMethodBeat.o(99992);
          return;
        }
        j.this.EUH.hho = true;
        j.this.EUH.wnX.setAlpha(0.0F);
        j.this.EUH.EVh.setAlpha(0.0F);
        j.this.EUH.EZD.getLocationInWindow(j.this.wrA);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(j.this.wrA[0]), Integer.valueOf(j.this.wrA[1]) });
        j.this.EUH.EWC.removeView(j.this.EUH.EZD);
        paramAnonymousAnimator = j.this.EUH.EWC.getLayoutParams();
        paramAnonymousAnimator.width = j.this.EUH.EZD.getWidth();
        paramAnonymousAnimator.height = (j.this.EUH.EZD.getHeight() + j.this.EUu.topMargin + j.this.EUu.bottomMargin);
        j.this.EUH.EWC.setLayoutParams(paramAnonymousAnimator);
        j.this.EUj = new FrameLayout.LayoutParams(-2, -2);
        j.this.EUj.leftMargin = j.this.wrA[0];
        j.this.EUj.rightMargin = (j.this.EUc.getWidth() - j.this.EUj.leftMargin - j.this.EUH.EZD.getWidth());
        j.this.EUj.topMargin = j.this.wrA[1];
        j.this.EUj.bottomMargin = (j.this.EUc.getHeight() - j.this.EUj.topMargin - j.this.EUH.EZD.getHeight());
        j.this.EUc.addView(j.this.EUH.EZD, j.this.EUj);
        AppMethodBeat.o(99992);
      }
    });
    this.EUb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99993);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.EUH.wnX.setAlpha(f);
        j.this.EUH.EVh.setAlpha(f);
        AppMethodBeat.o(99993);
      }
    });
    this.EUb.setDuration(100L);
    this.EUb.setStartDelay(300L);
    this.EUu = ((LinearLayout.LayoutParams)this.EUH.EZD.getLayoutParams());
    this.EUc = ((FrameLayout)this.activity.getBodyView().getParent());
    this.CPA = new AnimatorSet();
    this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
    this.CPA.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99995);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
        ((ViewGroup)j.this.EUH.EZD.getParent()).removeView(j.this.EUH.EZD);
        j.this.EUH.EWC.addView(j.this.EUH.EZD, j.this.EUu);
        j.this.EUH.EZD.setScaleX(1.0F);
        j.this.EUH.EZD.setScaleY(1.0F);
        j.this.EUH.EZD.setAlpha(1.0F);
        j.this.EUH.wnX.setAlpha(1.0F);
        j.this.EUH.EVh.setAlpha(1.0F);
        if (j.this.ETY != null) {
          j.this.ETY.onAnimationEnd();
        }
        j.this.EUH.hho = false;
        AppMethodBeat.o(99995);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99994);
        Log.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(99994);
      }
    });
    AppMethodBeat.o(99996);
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99997);
    if (!this.CPA.isStarted())
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j
 * JD-Core Version:    0.7.0.1
 */