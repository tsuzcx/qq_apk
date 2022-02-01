package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.ad.timeline.b.g;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends b
{
  AnimatorSet IVc;
  a.a LiB;
  
  public d(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99961);
    this.activity = paramMMActivity;
    this.LiB = ((a.a)paramBaseViewHolder);
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramMMActivity.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99956);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          d.this.LiB.uyC.setScaleX(f);
          d.this.LiB.uyC.setScaleY(f);
          d.this.LiB.uyC.setAlpha(f);
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
        if (d.this.LiB.jTm)
        {
          Log.i("MicroMsg.CardAdClickAnimation", "holder is busy");
          d.this.IVc.end();
          AppMethodBeat.o(99957);
          return;
        }
        d.this.LiB.jTm = true;
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
        d.this.LiB.Lmm.setAlpha(f);
        AppMethodBeat.o(99958);
      }
    });
    paramBaseViewHolder.setDuration(100L);
    this.IVc = new AnimatorSet();
    this.IVc.playTogether(new Animator[] { paramMMActivity, paramBaseViewHolder });
    this.IVc.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99960);
        Log.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
        d.this.LiB.uyC.setScaleX(1.0F);
        d.this.LiB.uyC.setScaleY(1.0F);
        d.this.LiB.uyC.setAlpha(1.0F);
        d.this.LiB.Lmm.setAlpha(1.0F);
        if (d.this.LiB.Ljs) {
          if (l.N(d.this.LiB.JKL))
          {
            paramAnonymousAnimator = d.this.LiB.JKL.getChildAt(0);
            if ((paramAnonymousAnimator instanceof OnlineVideoView)) {
              ((OnlineVideoView)paramAnonymousAnimator).bc(0, false);
            }
          }
        }
        label248:
        for (;;)
        {
          if (d.this.Lia != null) {
            d.this.Lia.onAnimationEnd();
          }
          d.this.LiB.jTm = false;
          AppMethodBeat.o(99960);
          return;
          paramAnonymousAnimator = g.b(d.this.LiB);
          int i;
          if ((paramAnonymousAnimator != null) && (paramAnonymousAnimator.ContentObj != null)) {
            if ((paramAnonymousAnimator.ContentObj.Sqq == 15) || (paramAnonymousAnimator.ContentObj.Sqq == 5)) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label248;
            }
            d.this.LiB.JKG.KKk.JsW.clear();
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
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99962);
    if (!this.IVc.isStarted())
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d
 * JD-Core Version:    0.7.0.1
 */