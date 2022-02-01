package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  extends a
{
  e.a AKA;
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  AnimatorSet yLH;
  
  public e(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99968);
    try
    {
      this.activity = paramMMActivity;
      this.AKA = ((e.a)paramBaseViewHolder);
      this.AKb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99963);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.AKA.Apn.setScaleX(f);
            e.this.AKA.Apn.setScaleY(f);
            e.this.AKA.Apn.setAlpha(f);
          }
          AppMethodBeat.o(99963);
        }
      });
      this.AKb.setDuration(400L);
      this.AKb.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99964);
          if (e.this.AKA.guz)
          {
            ae.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = e.this.yLH.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99964);
            return;
          }
          e.this.AKA.guz = true;
          e.this.AKA.tgh.setAlpha(0.0F);
          e.this.AKA.ALc.setAlpha(0.0F);
          AppMethodBeat.o(99964);
        }
      });
      this.AKc = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99965);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.AKA.tgh.setAlpha(f);
          e.this.AKA.ALc.setAlpha(f);
          AppMethodBeat.o(99965);
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
          AppMethodBeat.i(99967);
          ae.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
          e.this.AKA.Apn.setScaleX(1.0F);
          e.this.AKA.Apn.setScaleY(1.0F);
          e.this.AKA.Apn.setAlpha(1.0F);
          e.this.AKA.tgh.setAlpha(1.0F);
          e.this.AKA.ALc.setAlpha(1.0F);
          if (e.this.AJZ != null) {
            e.this.AJZ.onAnimationEnd();
          }
          e.this.AKA.guz = false;
          AppMethodBeat.o(99967);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99966);
          ae.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99966);
        }
      });
      AppMethodBeat.o(99968);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ae.e("MicroMsg.FullCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99968);
    }
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99969);
    if ((this.yLH != null) && (!this.yLH.isStarted()))
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e
 * JD-Core Version:    0.7.0.1
 */