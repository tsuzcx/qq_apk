package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  private AnimatorSet IVc;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  e Lii;
  
  public f(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(254193);
    try
    {
      this.activity = paramMMActivity;
      this.Lii = ((e)paramb);
      this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(243509);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            f.this.Lii.LjM.xYJ.setScaleX(f);
            f.this.Lii.LjM.xYJ.setScaleY(f);
            f.this.Lii.LjM.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(243509);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(263540);
          f.this.Lii.LjM.AZc.setAlpha(0.0F);
          f.this.Lii.LjM.JKr.setAlpha(0.0F);
          AppMethodBeat.o(263540);
        }
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(200418);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.Lii.LjM.AZc.setAlpha(f);
          f.this.Lii.LjM.JKr.setAlpha(f);
          AppMethodBeat.o(200418);
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
          AppMethodBeat.i(201705);
          Log.i("MicroMsg.FullCardAdDetailBackAnimationNew", "onAnimation end");
          f.this.Lii.LjM.xYJ.setScaleX(1.0F);
          f.this.Lii.LjM.xYJ.setScaleY(1.0F);
          f.this.Lii.LjM.xYJ.setAlpha(1.0F);
          f.this.Lii.LjM.AZc.setAlpha(1.0F);
          f.this.Lii.LjM.JKr.setAlpha(1.0F);
          if (f.this.Lia != null) {
            f.this.Lia.onAnimationEnd();
          }
          AppMethodBeat.o(201705);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(201697);
          Log.i("MicroMsg.FullCardAdDetailBackAnimationNew", "onAnimation start");
          AppMethodBeat.o(201697);
        }
      });
      AppMethodBeat.o(254193);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdDetailBackAnimationNew", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(254193);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(254195);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(254195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f
 * JD-Core Version:    0.7.0.1
 */