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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends a
{
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  d AKq;
  private AnimatorSet yLH;
  
  public g(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99929);
    try
    {
      this.activity = paramMMActivity;
      this.AKq = ((d)parama);
      this.AKb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99924);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.AKq.Apn.setScaleX(f);
            g.this.AKq.Apn.setScaleY(f);
            g.this.AKq.Apn.setAlpha(f);
          }
          AppMethodBeat.o(99924);
        }
      });
      this.AKb.setDuration(400L);
      this.AKb.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99925);
          g.this.AKq.ALE.setAlpha(0.0F);
          g.this.AKq.ALF.setAlpha(0.0F);
          AppMethodBeat.o(99925);
        }
      });
      this.AKc = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99926);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.AKq.ALE.setAlpha(f);
          g.this.AKq.ALF.setAlpha(f);
          AppMethodBeat.o(99926);
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
          AppMethodBeat.i(99928);
          ae.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation end");
          g.this.AKq.Apn.setScaleX(1.0F);
          g.this.AKq.Apn.setScaleY(1.0F);
          g.this.AKq.Apn.setAlpha(1.0F);
          g.this.AKq.ALE.setAlpha(1.0F);
          g.this.AKq.ALF.setAlpha(1.0F);
          if (g.this.AJZ != null) {
            g.this.AJZ.onAnimationEnd();
          }
          AppMethodBeat.o(99928);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99927);
          ae.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(99927);
        }
      });
      AppMethodBeat.o(99929);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ae.e("MicroMsg.SphereCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99929);
    }
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99930);
    if ((this.yLH != null) && (!this.yLH.isStarted()))
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g
 * JD-Core Version:    0.7.0.1
 */