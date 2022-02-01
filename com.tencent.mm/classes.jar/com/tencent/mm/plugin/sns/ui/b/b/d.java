package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.f.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.f;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends b
{
  a.a AKx;
  AnimatorSet yLH;
  
  public d(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99961);
    this.activity = paramMMActivity;
    this.AKx = ((a.a)paramBaseViewHolder);
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramMMActivity.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99956);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          d.this.AKx.ANL.setScaleX(f);
          d.this.AKx.ANL.setScaleY(f);
          d.this.AKx.ANL.setAlpha(f);
        }
        AppMethodBeat.o(99956);
      }
    });
    paramMMActivity.setDuration(400L);
    paramMMActivity.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99957);
        if (d.this.AKx.guz)
        {
          ae.i("MicroMsg.CardAdClickAnimation", "holder is busy");
          d.this.yLH.end();
          AppMethodBeat.o(99957);
          return;
        }
        d.this.AKx.guz = true;
        AppMethodBeat.o(99957);
      }
    });
    paramBaseViewHolder = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramBaseViewHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99958);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.AKx.ANM.setAlpha(f);
        AppMethodBeat.o(99958);
      }
    });
    paramBaseViewHolder.setDuration(100L);
    this.yLH = new AnimatorSet();
    this.yLH.playTogether(new Animator[] { paramMMActivity, paramBaseViewHolder });
    this.yLH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99960);
        ae.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
        d.this.AKx.ANL.setScaleX(1.0F);
        d.this.AKx.ANL.setScaleY(1.0F);
        d.this.AKx.ANL.setAlpha(1.0F);
        d.this.AKx.ANM.setAlpha(1.0F);
        if (d.this.AKx.ANY) {
          if (j.x(d.this.AKx.ANX))
          {
            paramAnonymousAnimator = d.this.AKx.ANX.getChildAt(0);
            if ((paramAnonymousAnimator instanceof OnlineVideoView)) {
              ((OnlineVideoView)paramAnonymousAnimator).aE(0, false);
            }
          }
        }
        label248:
        for (;;)
        {
          if (d.this.AJZ != null) {
            d.this.AJZ.onAnimationEnd();
          }
          d.this.AKx.guz = false;
          AppMethodBeat.o(99960);
          return;
          paramAnonymousAnimator = f.b(d.this.AKx);
          int i;
          if ((paramAnonymousAnimator != null) && (paramAnonymousAnimator.HUG != null)) {
            if ((paramAnonymousAnimator.HUG.Gtw == 15) || (paramAnonymousAnimator.HUG.Gtw == 5)) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label248;
            }
            d.this.AKx.AKJ.AnH.ziA.clear();
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99959);
        ae.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(99959);
      }
    });
    AppMethodBeat.o(99961);
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99962);
    if (!this.yLH.isStarted())
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d
 * JD-Core Version:    0.7.0.1
 */