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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends a
{
  private AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  d zbl;
  
  public g(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99929);
    try
    {
      this.activity = paramMMActivity;
      this.zbl = ((d)parama);
      this.zaW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99924);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.zbl.yGK.setScaleX(f);
            g.this.zbl.yGK.setScaleY(f);
            g.this.zbl.yGK.setAlpha(f);
          }
          AppMethodBeat.o(99924);
        }
      });
      this.zaW.setDuration(400L);
      this.zaW.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99925);
          g.this.zbl.zcz.setAlpha(0.0F);
          g.this.zbl.zcA.setAlpha(0.0F);
          AppMethodBeat.o(99925);
        }
      });
      this.zaX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99926);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.zbl.zcz.setAlpha(f);
          g.this.zbl.zcA.setAlpha(f);
          AppMethodBeat.o(99926);
        }
      });
      this.zaX.setDuration(100L);
      this.zaX.setStartDelay(300L);
      this.xhG = new AnimatorSet();
      this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
      this.xhG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99928);
          ac.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation end");
          g.this.zbl.yGK.setScaleX(1.0F);
          g.this.zbl.yGK.setScaleY(1.0F);
          g.this.zbl.yGK.setAlpha(1.0F);
          g.this.zbl.zcz.setAlpha(1.0F);
          g.this.zbl.zcA.setAlpha(1.0F);
          if (g.this.zaU != null) {
            g.this.zaU.onAnimationEnd();
          }
          AppMethodBeat.o(99928);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99927);
          ac.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(99927);
        }
      });
      AppMethodBeat.o(99929);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ac.e("MicroMsg.SphereCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99929);
    }
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99930);
    if ((this.xhG != null) && (!this.xhG.isStarted()))
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g
 * JD-Core Version:    0.7.0.1
 */