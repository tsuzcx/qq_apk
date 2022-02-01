package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends b
{
  a.a Atj;
  AnimatorSet yvH;
  
  public d(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99961);
    this.activity = paramMMActivity;
    this.Atj = ((a.a)paramBaseViewHolder);
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramMMActivity.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99956);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          d.this.Atj.Awu.setScaleX(f);
          d.this.Atj.Awu.setScaleY(f);
          d.this.Atj.Awu.setAlpha(f);
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
        if (d.this.Atj.grY)
        {
          ad.i("MicroMsg.CardAdClickAnimation", "holder is busy");
          d.this.yvH.end();
          AppMethodBeat.o(99957);
          return;
        }
        d.this.Atj.grY = true;
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
        d.this.Atj.Awv.setAlpha(f);
        AppMethodBeat.o(99958);
      }
    });
    paramBaseViewHolder.setDuration(100L);
    this.yvH = new AnimatorSet();
    this.yvH.playTogether(new Animator[] { paramMMActivity, paramBaseViewHolder });
    this.yvH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99960);
        ad.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
        d.this.Atj.Awu.setScaleX(1.0F);
        d.this.Atj.Awu.setScaleY(1.0F);
        d.this.Atj.Awu.setAlpha(1.0F);
        d.this.Atj.Awv.setAlpha(1.0F);
        if (d.this.Atj.AwG) {
          if (j.x(d.this.Atj.AwF))
          {
            paramAnonymousAnimator = d.this.Atj.AwF.getChildAt(0);
            if ((paramAnonymousAnimator instanceof OnlineVideoView)) {
              ((OnlineVideoView)paramAnonymousAnimator).aB(0, false);
            }
          }
        }
        label248:
        for (;;)
        {
          if (d.this.AsL != null) {
            d.this.AsL.onAnimationEnd();
          }
          d.this.Atj.grY = false;
          AppMethodBeat.o(99960);
          return;
          paramAnonymousAnimator = com.tencent.mm.plugin.sns.ad.timeline.a.d.b(d.this.Atj);
          int i;
          if ((paramAnonymousAnimator != null) && (paramAnonymousAnimator.HAT != null)) {
            if ((paramAnonymousAnimator.HAT.GaP == 15) || (paramAnonymousAnimator.HAT.GaP == 5)) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label248;
            }
            d.this.Atj.Atv.zWy.ySq.clear();
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
        ad.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(99959);
      }
    });
    AppMethodBeat.o(99961);
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99962);
    if (!this.yvH.isStarted())
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d
 * JD-Core Version:    0.7.0.1
 */