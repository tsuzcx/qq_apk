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
import com.tencent.mm.plugin.sns.ui.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends a
{
  private AnimatorSet Div;
  private ValueAnimator RIs;
  f RIv;
  private ValueAnimator RIw;
  
  public g(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(99929);
    try
    {
      this.activity = paramMMActivity;
      this.RIv = ((f)paramb);
      this.RIs = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99924);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.RIv.Cxb.setScaleX(f);
            g.this.RIv.Cxb.setScaleY(f);
            g.this.RIv.Cxb.setAlpha(f);
          }
          AppMethodBeat.o(99924);
        }
      });
      this.RIs.setDuration(400L);
      this.RIs.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99925);
          g.this.RIv.RJK.setAlpha(0.0F);
          g.this.RIv.RJL.setAlpha(0.0F);
          AppMethodBeat.o(99925);
        }
      });
      this.RIw = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99926);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.RIv.RJK.setAlpha(f);
          g.this.RIv.RJL.setAlpha(f);
          AppMethodBeat.o(99926);
        }
      });
      this.RIw.setDuration(100L);
      this.RIw.setStartDelay(300L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99928);
          Log.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation end");
          g.this.RIv.Cxb.setScaleX(1.0F);
          g.this.RIv.Cxb.setScaleY(1.0F);
          g.this.RIv.Cxb.setAlpha(1.0F);
          g.this.RIv.RJK.setAlpha(1.0F);
          g.this.RIv.RJL.setAlpha(1.0F);
          if (g.this.RIn != null) {
            g.this.RIn.onAnimationEnd();
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
    finally
    {
      Log.e("MicroMsg.SphereCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99929);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99930);
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g
 * JD-Core Version:    0.7.0.1
 */