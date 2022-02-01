package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.ad.timeline.helper.j;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends b
{
  AnimatorSet Div;
  a.a RIG;
  
  public d(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99961);
    this.activity = paramMMActivity;
    this.RIG = ((a.a)paramBaseViewHolder);
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramMMActivity.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99956);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0F)
        {
          d.this.RIG.xFi.setScaleX(f);
          d.this.RIG.xFi.setScaleY(f);
          d.this.RIG.xFi.setAlpha(f);
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
        if (d.this.RIG.mtE)
        {
          Log.i("MicroMsg.CardAdClickAnimation", "holder is busy");
          d.this.Div.end();
          AppMethodBeat.o(99957);
          return;
        }
        d.this.RIG.mtE = true;
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
        d.this.RIG.RMb.setAlpha(f);
        AppMethodBeat.o(99958);
      }
    });
    paramBaseViewHolder.setDuration(100L);
    this.Div = new AnimatorSet();
    this.Div.playTogether(new Animator[] { paramMMActivity, paramBaseViewHolder });
    this.Div.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99960);
        Log.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
        d.this.RIG.xFi.setScaleX(1.0F);
        d.this.RIG.xFi.setScaleY(1.0F);
        d.this.RIG.xFi.setAlpha(1.0F);
        d.this.RIG.RMb.setAlpha(1.0F);
        if (d.this.RIG.QbW) {
          if (l.X(d.this.RIG.Qcq))
          {
            paramAnonymousAnimator = d.this.RIG.Qcq.getChildAt(0);
            if ((paramAnonymousAnimator instanceof OnlineVideoView)) {
              ((OnlineVideoView)paramAnonymousAnimator).bJ(0, false);
            }
          }
        }
        label248:
        for (;;)
        {
          if (d.this.RIn != null) {
            d.this.RIn.onAnimationEnd();
          }
          d.this.RIG.mtE = false;
          AppMethodBeat.o(99960);
          return;
          paramAnonymousAnimator = j.b(d.this.RIG);
          int i;
          if ((paramAnonymousAnimator != null) && (paramAnonymousAnimator.ContentObj != null)) {
            if ((paramAnonymousAnimator.ContentObj.Zpq == 15) || (paramAnonymousAnimator.ContentObj.Zpq == 5)) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label248;
            }
            d.this.RIG.Qcj.RjM.PGy.clear();
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
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99962);
    if (!this.Div.isStarted())
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d
 * JD-Core Version:    0.7.0.1
 */