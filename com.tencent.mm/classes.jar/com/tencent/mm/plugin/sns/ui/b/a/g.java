package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends b
{
  private AnimatorSet IVc;
  d Lie;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  
  public g(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(99922);
    try
    {
      this.activity = paramMMActivity;
      this.Lie = ((d)paramb);
      this.Lif = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99918);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            g.this.Lie.xYJ.setScaleX(f);
            g.this.Lie.xYJ.setScaleY(f);
            g.this.Lie.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(99918);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179331);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.Lie.AZc.setAlpha(f);
          g.this.Lie.JKr.setAlpha(f);
          AppMethodBeat.o(179331);
        }
      });
      this.Lig.setDuration(100L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179333);
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
          g.this.Lie.xYJ.setScaleX(1.0F);
          g.this.Lie.xYJ.setScaleY(1.0F);
          g.this.Lie.xYJ.setAlpha(1.0F);
          g.this.Lie.AZc.setAlpha(1.0F);
          g.this.Lie.JKr.setAlpha(1.0F);
          if (g.this.Lia != null) {
            g.this.Lia.onAnimationEnd();
          }
          if (g.this.Lie.JKG.KKl.getVisibility() == 0)
          {
            g.this.Lie.JKG.KKl.bc(0, false);
            Log.i("MicroMsg.FullCardAdDetailClickAnimation", "seek newVideoView to 0");
          }
          AppMethodBeat.o(179333);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179332);
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(179332);
        }
      });
      AppMethodBeat.o(99922);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99922);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99923);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g
 * JD-Core Version:    0.7.0.1
 */