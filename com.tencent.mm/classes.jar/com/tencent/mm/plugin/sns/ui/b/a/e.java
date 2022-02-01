package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  c AKn;
  private AnimatorSet yLH;
  
  public e(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99916);
    try
    {
      this.activity = paramMMActivity;
      this.AKn = ((c)parama);
      this.AKb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99912);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.AKn.Apn.setScaleX(f);
            e.this.AKn.Apn.setScaleY(f);
            e.this.AKn.Apn.setAlpha(f);
          }
          AppMethodBeat.o(99912);
        }
      });
      this.AKb.setDuration(400L);
      this.AKb.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179327);
          e.this.AKn.tgh.setAlpha(0.0F);
          e.this.AKn.ALc.setAlpha(0.0F);
          AppMethodBeat.o(179327);
        }
      });
      this.AKc = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179328);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.AKn.tgh.setAlpha(f);
          e.this.AKn.ALc.setAlpha(f);
          AppMethodBeat.o(179328);
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
          AppMethodBeat.i(179330);
          ae.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
          e.this.AKn.Apn.setScaleX(1.0F);
          e.this.AKn.Apn.setScaleY(1.0F);
          e.this.AKn.Apn.setAlpha(1.0F);
          e.this.AKn.tgh.setAlpha(1.0F);
          e.this.AKn.ALc.setAlpha(1.0F);
          if (e.this.AJZ != null) {
            e.this.AJZ.onAnimationEnd();
          }
          AppMethodBeat.o(179330);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179329);
          ae.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(179329);
        }
      });
      AppMethodBeat.o(99916);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ae.e("MicroMsg.FullCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99916);
    }
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99917);
    if ((this.yLH != null) && (!this.yLH.isStarted()))
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e
 * JD-Core Version:    0.7.0.1
 */