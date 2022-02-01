package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  AnimatorSet IVc;
  h.a LiG;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  
  public h(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(197691);
    try
    {
      this.activity = paramMMActivity;
      this.LiG = ((h.a)paramBaseViewHolder);
      this.Lif = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(246368);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.LiG.Lnh.xYJ.setScaleX(f);
            h.this.LiG.Lnh.xYJ.setScaleY(f);
            h.this.LiG.Lnh.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(246368);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(268967);
          if (h.this.LiG.jTm)
          {
            Log.i("MicroMsg.FullCardAdClickAnimationNew", "holder is busy");
            paramAnonymousAnimator = h.this;
            if (paramAnonymousAnimator.IVc != null) {
              paramAnonymousAnimator.IVc.end();
            }
            AppMethodBeat.o(268967);
            return;
          }
          h.this.LiG.jTm = true;
          AppMethodBeat.o(268967);
        }
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(198151);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.LiG.Lnh.AZc.setAlpha(f);
          h.this.LiG.Lnh.JKr.setAlpha(f);
          AppMethodBeat.o(198151);
        }
      });
      this.Lig.setDuration(100L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(268460);
          Log.i("MicroMsg.FullCardAdClickAnimationNew", "onAnimation end");
          h.this.LiG.Lnh.xYJ.setScaleX(1.0F);
          h.this.LiG.Lnh.xYJ.setScaleY(1.0F);
          h.this.LiG.Lnh.xYJ.setAlpha(1.0F);
          h.this.LiG.Lnh.AZc.setAlpha(1.0F);
          h.this.LiG.Lnh.JKr.setAlpha(1.0F);
          if (h.this.Lia != null) {
            h.this.Lia.onAnimationEnd();
          }
          h.this.LiG.jTm = false;
          if (h.this.LiG.Ljs)
          {
            if (h.this.LiG.Lnh.JKM != null)
            {
              h.this.LiG.Lnh.JKM.bc(0, false);
              AppMethodBeat.o(268460);
            }
          }
          else if (h.this.LiG.Lnh.JKG.KKl.getVisibility() == 0)
          {
            h.this.LiG.Lnh.JKG.KKl.bc(0, false);
            Log.i("MicroMsg.FullCardAdClickAnimationNew", "seek newVideoView to 0");
          }
          AppMethodBeat.o(268460);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(268459);
          Log.i("MicroMsg.FullCardAdClickAnimationNew", "onAnimation start");
          AppMethodBeat.o(268459);
        }
      });
      AppMethodBeat.o(197691);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdClickAnimationNew", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(197691);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(197692);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(197692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h
 * JD-Core Version:    0.7.0.1
 */