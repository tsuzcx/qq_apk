package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
  extends a
{
  AnimatorSet CPA;
  n.a EUE;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  
  public h(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99982);
    try
    {
      this.activity = paramMMActivity;
      this.EUE = ((n.a)paramBaseViewHolder);
      this.EUa = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99977);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            h.this.EUE.ExX.setScaleX(f);
            h.this.EUE.ExX.setScaleY(f);
            h.this.EUE.ExX.setAlpha(f);
          }
          AppMethodBeat.o(99977);
        }
      });
      this.EUa.setDuration(400L);
      this.EUa.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99978);
          if (h.this.EUE.hho)
          {
            Log.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = h.this.CPA.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99978);
            return;
          }
          h.this.EUE.hho = true;
          h.this.EUE.wnX.setAlpha(0.0F);
          h.this.EUE.EVh.setAlpha(0.0F);
          AppMethodBeat.o(99978);
        }
      });
      this.EUb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99979);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.EUE.wnX.setAlpha(f);
          h.this.EUE.EVh.setAlpha(f);
          AppMethodBeat.o(99979);
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
          AppMethodBeat.i(99981);
          Log.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
          h.this.EUE.ExX.setScaleX(1.0F);
          h.this.EUE.ExX.setScaleY(1.0F);
          h.this.EUE.ExX.setAlpha(1.0F);
          h.this.EUE.wnX.setAlpha(1.0F);
          h.this.EUE.EVh.setAlpha(1.0F);
          if (h.this.ETY != null) {
            h.this.ETY.onAnimationEnd();
          }
          h.this.EUE.hho = false;
          AppMethodBeat.o(99981);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99980);
          Log.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99980);
        }
      });
      AppMethodBeat.o(99982);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99982);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99983);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h
 * JD-Core Version:    0.7.0.1
 */