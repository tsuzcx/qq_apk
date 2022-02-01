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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends a
{
  private AnimatorSet vWT;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  d xOv;
  
  public g(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99929);
    try
    {
      this.activity = paramMMActivity;
      this.xOv = ((d)parama);
      this.xOg = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99924);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.xOv.xtU.setScaleX(f);
            g.this.xOv.xtU.setScaleY(f);
            g.this.xOv.xtU.setAlpha(f);
          }
          AppMethodBeat.o(99924);
        }
      });
      this.xOg.setDuration(400L);
      this.xOg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99925);
          g.this.xOv.xPJ.setAlpha(0.0F);
          g.this.xOv.xPK.setAlpha(0.0F);
          AppMethodBeat.o(99925);
        }
      });
      this.xOh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99926);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.xOv.xPJ.setAlpha(f);
          g.this.xOv.xPK.setAlpha(f);
          AppMethodBeat.o(99926);
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
          AppMethodBeat.i(99928);
          ad.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation end");
          g.this.xOv.xtU.setScaleX(1.0F);
          g.this.xOv.xtU.setScaleY(1.0F);
          g.this.xOv.xtU.setAlpha(1.0F);
          g.this.xOv.xPJ.setAlpha(1.0F);
          g.this.xOv.xPK.setAlpha(1.0F);
          if (g.this.xOe != null) {
            g.this.xOe.onAnimationEnd();
          }
          AppMethodBeat.o(99928);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99927);
          ad.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(99927);
        }
      });
      AppMethodBeat.o(99929);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.SphereCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99929);
    }
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99930);
    if ((this.vWT != null) && (!this.vWT.isStarted()))
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g
 * JD-Core Version:    0.7.0.1
 */