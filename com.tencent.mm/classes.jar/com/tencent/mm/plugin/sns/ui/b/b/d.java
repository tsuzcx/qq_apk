package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.timeline.b.g;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends b
{
  AnimatorSet CPA;
  a.a EUx;
  
  public d(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99961);
    this.activity = paramMMActivity;
    this.EUx = ((a.a)paramBaseViewHolder);
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramMMActivity.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99956);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          d.this.EUx.qVR.setScaleX(f);
          d.this.EUx.qVR.setScaleY(f);
          d.this.EUx.qVR.setAlpha(f);
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
        if (d.this.EUx.hho)
        {
          Log.i("MicroMsg.CardAdClickAnimation", "holder is busy");
          d.this.CPA.end();
          AppMethodBeat.o(99957);
          return;
        }
        d.this.EUx.hho = true;
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
        d.this.EUx.EXY.setAlpha(f);
        AppMethodBeat.o(99958);
      }
    });
    paramBaseViewHolder.setDuration(100L);
    this.CPA = new AnimatorSet();
    this.CPA.playTogether(new Animator[] { paramMMActivity, paramBaseViewHolder });
    this.CPA.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99960);
        Log.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
        d.this.EUx.qVR.setScaleX(1.0F);
        d.this.EUx.qVR.setScaleY(1.0F);
        d.this.EUx.qVR.setAlpha(1.0F);
        d.this.EUx.EXY.setAlpha(1.0F);
        if (d.this.EUx.EYk) {
          if (m.G(d.this.EUx.EYj))
          {
            paramAnonymousAnimator = d.this.EUx.EYj.getChildAt(0);
            if ((paramAnonymousAnimator instanceof OnlineVideoView)) {
              ((OnlineVideoView)paramAnonymousAnimator).aT(0, false);
            }
          }
        }
        label248:
        for (;;)
        {
          if (d.this.ETY != null) {
            d.this.ETY.onAnimationEnd();
          }
          d.this.EUx.hho = false;
          AppMethodBeat.o(99960);
          return;
          paramAnonymousAnimator = g.b(d.this.EUx);
          int i;
          if ((paramAnonymousAnimator != null) && (paramAnonymousAnimator.ContentObj != null)) {
            if ((paramAnonymousAnimator.ContentObj.LoU == 15) || (paramAnonymousAnimator.ContentObj.LoU == 5)) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label248;
            }
            d.this.EUx.EUK.Ews.Dnr.clear();
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
        Log.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(99959);
      }
    });
    AppMethodBeat.o(99961);
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99962);
    if (!this.CPA.isStarted())
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d
 * JD-Core Version:    0.7.0.1
 */