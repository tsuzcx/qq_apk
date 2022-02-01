package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends b
{
  private AnimatorSet IVc;
  c Lib;
  
  public d(com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(246813);
    this.activity = this.activity;
    this.Lib = ((c)paramb);
    paramb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99906);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          d.this.Lib.Lji.setScaleX(f);
          d.this.Lib.Lji.setScaleY(f);
          d.this.Lib.Lji.setAlpha(f);
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
        d.this.Lib.Ljj.setAlpha(f);
        AppMethodBeat.o(99907);
      }
    });
    localValueAnimator.setDuration(100L);
    this.IVc = new AnimatorSet();
    this.IVc.playTogether(new Animator[] { paramb, localValueAnimator });
    this.IVc.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99909);
        Log.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
        d.this.Lib.Lji.setScaleX(1.0F);
        d.this.Lib.Lji.setScaleY(1.0F);
        d.this.Lib.Lji.setAlpha(1.0F);
        d.this.Lib.Ljj.setAlpha(1.0F);
        if (d.this.Lib.Ljs) {
          if (l.N(d.this.Lib.JKL))
          {
            paramAnonymousAnimator = d.this.Lib.JKL.getChildAt(0);
            if ((paramAnonymousAnimator instanceof OnlineVideoView)) {
              ((OnlineVideoView)paramAnonymousAnimator).bc(0, false);
            }
          }
        }
        for (;;)
        {
          if (d.this.Lia != null) {
            d.this.Lia.onAnimationEnd();
          }
          AppMethodBeat.o(99909);
          return;
          if (d.this.Lib.fYu()) {
            d.this.Lib.JKG.KKk.JsW.clear();
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
    AppMethodBeat.o(246813);
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99911);
    if (!this.IVc.isStarted())
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */