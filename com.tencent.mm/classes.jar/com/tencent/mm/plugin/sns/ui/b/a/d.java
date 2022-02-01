package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends b
{
  private AnimatorSet Div;
  c RIo;
  
  public d(com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(309373);
    this.activity = this.activity;
    this.RIo = ((c)paramb);
    paramb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99906);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          d.this.RIo.RJk.setScaleX(f);
          d.this.RIo.RJk.setScaleY(f);
          d.this.RIo.RJk.setAlpha(f);
        }
        AppMethodBeat.o(99906);
      }
    });
    paramb.setDuration(400L);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99907);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.RIo.RJl.setAlpha(f);
        AppMethodBeat.o(99907);
      }
    });
    localValueAnimator.setDuration(100L);
    this.Div = new AnimatorSet();
    this.Div.playTogether(new Animator[] { paramb, localValueAnimator });
    this.Div.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99909);
        Log.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
        d.this.RIo.RJk.setScaleX(1.0F);
        d.this.RIo.RJk.setScaleY(1.0F);
        d.this.RIo.RJk.setAlpha(1.0F);
        d.this.RIo.RJl.setAlpha(1.0F);
        if (d.this.RIo.QbW) {
          if (l.X(d.this.RIo.Qcq))
          {
            paramAnonymousAnimator = d.this.RIo.Qcq.getChildAt(0);
            if ((paramAnonymousAnimator instanceof OnlineVideoView)) {
              ((OnlineVideoView)paramAnonymousAnimator).bJ(0, false);
            }
          }
        }
        for (;;)
        {
          if (d.this.RIn != null) {
            d.this.RIn.onAnimationEnd();
          }
          AppMethodBeat.o(99909);
          return;
          if (d.this.RIo.hqS()) {
            d.this.RIo.Qcj.RjM.PGy.clear();
          }
        }
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99908);
        Log.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
        AppMethodBeat.o(99908);
      }
    });
    AppMethodBeat.o(309373);
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99911);
    if (!this.Div.isStarted())
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */