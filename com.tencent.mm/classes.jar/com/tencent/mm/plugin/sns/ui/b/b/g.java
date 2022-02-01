package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class g
  extends a
{
  k.a AKD;
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  AnimatorSet yLH;
  
  public g(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99982);
    try
    {
      this.activity = paramMMActivity;
      this.AKD = ((k.a)paramBaseViewHolder);
      this.AKb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99977);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.AKD.Apn.setScaleX(f);
            g.this.AKD.Apn.setScaleY(f);
            g.this.AKD.Apn.setAlpha(f);
          }
          AppMethodBeat.o(99977);
        }
      });
      this.AKb.setDuration(400L);
      this.AKb.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99978);
          if (g.this.AKD.guz)
          {
            ae.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = g.this.yLH.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99978);
            return;
          }
          g.this.AKD.guz = true;
          g.this.AKD.tgh.setAlpha(0.0F);
          g.this.AKD.ALc.setAlpha(0.0F);
          AppMethodBeat.o(99978);
        }
      });
      this.AKc = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99979);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.AKD.tgh.setAlpha(f);
          g.this.AKD.ALc.setAlpha(f);
          AppMethodBeat.o(99979);
        }
      });
      this.AKc.setDuration(100L);
      this.AKc.setStartDelay(300L);
      this.yLH = new AnimatorSet();
      this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
      this.yLH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99981);
          ae.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
          g.this.AKD.Apn.setScaleX(1.0F);
          g.this.AKD.Apn.setScaleY(1.0F);
          g.this.AKD.Apn.setAlpha(1.0F);
          g.this.AKD.tgh.setAlpha(1.0F);
          g.this.AKD.ALc.setAlpha(1.0F);
          if (g.this.AJZ != null) {
            g.this.AJZ.onAnimationEnd();
          }
          g.this.AKD.guz = false;
          AppMethodBeat.o(99981);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99980);
          ae.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99980);
        }
      });
      AppMethodBeat.o(99982);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ae.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99982);
    }
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99983);
    if ((this.yLH != null) && (!this.yLH.isStarted()))
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g
 * JD-Core Version:    0.7.0.1
 */