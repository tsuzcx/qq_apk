package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private AnimatorSet IVc;
  d Lie;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  
  public e(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(99916);
    try
    {
      this.activity = paramMMActivity;
      this.Lie = ((d)paramb);
      this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99912);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.Lie.xYJ.setScaleX(f);
            e.this.Lie.xYJ.setScaleY(f);
            e.this.Lie.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(99912);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179327);
          e.this.Lie.AZc.setAlpha(0.0F);
          e.this.Lie.JKr.setAlpha(0.0F);
          AppMethodBeat.o(179327);
        }
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179328);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.Lie.AZc.setAlpha(f);
          e.this.Lie.JKr.setAlpha(f);
          AppMethodBeat.o(179328);
        }
      });
      this.Lig.setDuration(100L);
      this.Lig.setStartDelay(300L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179330);
          Log.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
          e.this.Lie.xYJ.setScaleX(1.0F);
          e.this.Lie.xYJ.setScaleY(1.0F);
          e.this.Lie.xYJ.setAlpha(1.0F);
          e.this.Lie.AZc.setAlpha(1.0F);
          e.this.Lie.JKr.setAlpha(1.0F);
          if (e.this.Lia != null) {
            e.this.Lia.onAnimationEnd();
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
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99917);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e
 * JD-Core Version:    0.7.0.1
 */