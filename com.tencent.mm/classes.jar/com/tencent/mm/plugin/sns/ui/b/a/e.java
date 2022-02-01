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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private AnimatorSet CPA;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  c EUm;
  
  public e(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99916);
    try
    {
      this.activity = paramMMActivity;
      this.EUm = ((c)parama);
      this.EUa = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99912);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.EUm.ExX.setScaleX(f);
            e.this.EUm.ExX.setScaleY(f);
            e.this.EUm.ExX.setAlpha(f);
          }
          AppMethodBeat.o(99912);
        }
      });
      this.EUa.setDuration(400L);
      this.EUa.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179327);
          e.this.EUm.wnX.setAlpha(0.0F);
          e.this.EUm.EVh.setAlpha(0.0F);
          AppMethodBeat.o(179327);
        }
      });
      this.EUb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179328);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.EUm.wnX.setAlpha(f);
          e.this.EUm.EVh.setAlpha(f);
          AppMethodBeat.o(179328);
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
          AppMethodBeat.i(179330);
          Log.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
          e.this.EUm.ExX.setScaleX(1.0F);
          e.this.EUm.ExX.setScaleY(1.0F);
          e.this.EUm.ExX.setAlpha(1.0F);
          e.this.EUm.wnX.setAlpha(1.0F);
          e.this.EUm.EVh.setAlpha(1.0F);
          if (e.this.ETY != null) {
            e.this.ETY.onAnimationEnd();
          }
          AppMethodBeat.o(179330);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179329);
          Log.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(179329);
        }
      });
      AppMethodBeat.o(99916);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99916);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99917);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e
 * JD-Core Version:    0.7.0.1
 */