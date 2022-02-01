package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  extends a
{
  AnimatorSet CPA;
  f.a EUA;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  
  public e(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99968);
    try
    {
      this.activity = paramMMActivity;
      this.EUA = ((f.a)paramBaseViewHolder);
      this.EUa = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99963);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.EUA.ExX.setScaleX(f);
            e.this.EUA.ExX.setScaleY(f);
            e.this.EUA.ExX.setAlpha(f);
          }
          AppMethodBeat.o(99963);
        }
      });
      this.EUa.setDuration(400L);
      this.EUa.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99964);
          if (e.this.EUA.hho)
          {
            Log.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = e.this.CPA.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99964);
            return;
          }
          e.this.EUA.hho = true;
          e.this.EUA.wnX.setAlpha(0.0F);
          e.this.EUA.EVh.setAlpha(0.0F);
          AppMethodBeat.o(99964);
        }
      });
      this.EUb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99965);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.EUA.wnX.setAlpha(f);
          e.this.EUA.EVh.setAlpha(f);
          AppMethodBeat.o(99965);
        }
      });
      this.EUb.setDuration(100L);
      this.EUb.setStartDelay(300L);
      this.CPA = new AnimatorSet();
      this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
      this.CPA.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99967);
          Log.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
          e.this.EUA.ExX.setScaleX(1.0F);
          e.this.EUA.ExX.setScaleY(1.0F);
          e.this.EUA.ExX.setAlpha(1.0F);
          e.this.EUA.wnX.setAlpha(1.0F);
          e.this.EUA.EVh.setAlpha(1.0F);
          if (e.this.ETY != null) {
            e.this.ETY.onAnimationEnd();
          }
          e.this.EUA.hho = false;
          AppMethodBeat.o(99967);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99966);
          Log.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99966);
        }
      });
      AppMethodBeat.o(99968);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99968);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99969);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e
 * JD-Core Version:    0.7.0.1
 */