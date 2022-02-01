package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends a
{
  private AnimatorSet CPA;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  d EUq;
  
  public h(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99929);
    try
    {
      this.activity = paramMMActivity;
      this.EUq = ((d)parama);
      this.EUa = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99924);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            h.this.EUq.ExX.setScaleX(f);
            h.this.EUq.ExX.setScaleY(f);
            h.this.EUq.ExX.setAlpha(f);
          }
          AppMethodBeat.o(99924);
        }
      });
      this.EUa.setDuration(400L);
      this.EUa.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99925);
          h.this.EUq.EVJ.setAlpha(0.0F);
          h.this.EUq.EVK.setAlpha(0.0F);
          AppMethodBeat.o(99925);
        }
      });
      this.EUb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99926);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.EUq.EVJ.setAlpha(f);
          h.this.EUq.EVK.setAlpha(f);
          AppMethodBeat.o(99926);
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
          AppMethodBeat.i(99928);
          Log.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation end");
          h.this.EUq.ExX.setScaleX(1.0F);
          h.this.EUq.ExX.setScaleY(1.0F);
          h.this.EUq.ExX.setAlpha(1.0F);
          h.this.EUq.EVJ.setAlpha(1.0F);
          h.this.EUq.EVK.setAlpha(1.0F);
          if (h.this.ETY != null) {
            h.this.ETY.onAnimationEnd();
          }
          AppMethodBeat.o(99928);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99927);
          Log.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(99927);
        }
      });
      AppMethodBeat.o(99929);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SphereCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99929);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99930);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h
 * JD-Core Version:    0.7.0.1
 */