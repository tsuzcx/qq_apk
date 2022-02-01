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
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  d Atc;
  private AnimatorSet yvH;
  
  public g(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99929);
    try
    {
      this.activity = paramMMActivity;
      this.Atc = ((d)parama);
      this.AsN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99924);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.Atc.zYc.setScaleX(f);
            g.this.Atc.zYc.setScaleY(f);
            g.this.Atc.zYc.setAlpha(f);
          }
          AppMethodBeat.o(99924);
        }
      });
      this.AsN.setDuration(400L);
      this.AsN.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99925);
          g.this.Atc.Aup.setAlpha(0.0F);
          g.this.Atc.Auq.setAlpha(0.0F);
          AppMethodBeat.o(99925);
        }
      });
      this.AsO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99926);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.Atc.Aup.setAlpha(f);
          g.this.Atc.Auq.setAlpha(f);
          AppMethodBeat.o(99926);
        }
      });
      this.AsO.setDuration(100L);
      this.AsO.setStartDelay(300L);
      this.yvH = new AnimatorSet();
      this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
      this.yvH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99928);
          ad.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation end");
          g.this.Atc.zYc.setScaleX(1.0F);
          g.this.Atc.zYc.setScaleY(1.0F);
          g.this.Atc.zYc.setAlpha(1.0F);
          g.this.Atc.Aup.setAlpha(1.0F);
          g.this.Atc.Auq.setAlpha(1.0F);
          if (g.this.AsL != null) {
            g.this.AsL.onAnimationEnd();
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
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99930);
    if ((this.yvH != null) && (!this.yvH.isStarted()))
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g
 * JD-Core Version:    0.7.0.1
 */