package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.e.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  e.a AKA;
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  AnimatorSet yLH;
  
  public f(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99975);
    try
    {
      this.activity = paramMMActivity;
      this.AKA = ((e.a)paramBaseViewHolder);
      this.AKb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99970);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.AKA.Apn.setScaleX(f);
            f.this.AKA.Apn.setScaleY(f);
            f.this.AKA.Apn.setAlpha(f);
          }
          AppMethodBeat.o(99970);
        }
      });
      this.AKb.setDuration(400L);
      this.AKb.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99971);
          if (f.this.AKA.guz)
          {
            ae.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = f.this;
            if (paramAnonymousAnimator.yLH != null) {
              paramAnonymousAnimator.yLH.end();
            }
            AppMethodBeat.o(99971);
            return;
          }
          f.this.AKA.guz = true;
          AppMethodBeat.o(99971);
        }
      });
      this.AKc = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99972);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.AKA.tgh.setAlpha(f);
          f.this.AKA.ALc.setAlpha(f);
          AppMethodBeat.o(99972);
        }
      });
      this.AKc.setDuration(100L);
      this.yLH = new AnimatorSet();
      this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
      this.yLH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99974);
          ae.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
          f.this.AKA.Apn.setScaleX(1.0F);
          f.this.AKA.Apn.setScaleY(1.0F);
          f.this.AKA.Apn.setAlpha(1.0F);
          f.this.AKA.tgh.setAlpha(1.0F);
          f.this.AKA.ALc.setAlpha(1.0F);
          if (f.this.AJZ != null) {
            f.this.AJZ.onAnimationEnd();
          }
          f.this.AKA.guz = false;
          if (f.this.AKA.AKJ.AnP)
          {
            if (f.this.AKA.AKJ.AnI.getVisibility() == 0)
            {
              f.this.AKA.AKJ.AnI.aE(0, false);
              ae.i("MicroMsg.FullCardAdClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(99974);
            }
          }
          else if (f.this.AKA.AKJ.AnH.getVisibility() == 0)
          {
            f.this.AKA.AKJ.AnH.ziA.clear();
            ae.i("MicroMsg.FullCardAdClickAnimation", "seek sightView to 0");
          }
          AppMethodBeat.o(99974);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99973);
          ae.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99973);
        }
      });
      AppMethodBeat.o(99975);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ae.e("MicroMsg.FullCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99975);
    }
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99976);
    if ((this.yLH != null) && (!this.yLH.isStarted()))
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f
 * JD-Core Version:    0.7.0.1
 */