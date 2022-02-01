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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private AnimatorSet vWT;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  c xOs;
  
  public e(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99916);
    try
    {
      this.activity = paramMMActivity;
      this.xOs = ((c)parama);
      this.xOg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99912);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.xOs.xtU.setScaleX(f);
            e.this.xOs.xtU.setScaleY(f);
            e.this.xOs.xtU.setAlpha(f);
          }
          AppMethodBeat.o(99912);
        }
      });
      this.xOg.setDuration(400L);
      this.xOg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179327);
          e.this.xOs.qXs.setAlpha(0.0F);
          e.this.xOs.xPg.setAlpha(0.0F);
          AppMethodBeat.o(179327);
        }
      });
      this.xOh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179328);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.xOs.qXs.setAlpha(f);
          e.this.xOs.xPg.setAlpha(f);
          AppMethodBeat.o(179328);
        }
      });
      this.xOh.setDuration(100L);
      this.xOh.setStartDelay(300L);
      this.vWT = new AnimatorSet();
      this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
      this.vWT.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179330);
          ad.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
          e.this.xOs.xtU.setScaleX(1.0F);
          e.this.xOs.xtU.setScaleY(1.0F);
          e.this.xOs.xtU.setAlpha(1.0F);
          e.this.xOs.qXs.setAlpha(1.0F);
          e.this.xOs.xPg.setAlpha(1.0F);
          if (e.this.xOe != null) {
            e.this.xOe.onAnimationEnd();
          }
          AppMethodBeat.o(179330);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179329);
          ad.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(179329);
        }
      });
      AppMethodBeat.o(99916);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.FullCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99916);
    }
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99917);
    if ((this.vWT != null) && (!this.vWT.isStarted()))
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e
 * JD-Core Version:    0.7.0.1
 */