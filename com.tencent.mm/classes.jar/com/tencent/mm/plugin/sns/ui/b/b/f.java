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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  e.a Atm;
  AnimatorSet yvH;
  
  public f(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99975);
    try
    {
      this.activity = paramMMActivity;
      this.Atm = ((e.a)paramBaseViewHolder);
      this.AsN = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99970);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.Atm.zYc.setScaleX(f);
            f.this.Atm.zYc.setScaleY(f);
            f.this.Atm.zYc.setAlpha(f);
          }
          AppMethodBeat.o(99970);
        }
      });
      this.AsN.setDuration(400L);
      this.AsN.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99971);
          if (f.this.Atm.grY)
          {
            ad.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = f.this;
            if (paramAnonymousAnimator.yvH != null) {
              paramAnonymousAnimator.yvH.end();
            }
            AppMethodBeat.o(99971);
            return;
          }
          f.this.Atm.grY = true;
          AppMethodBeat.o(99971);
        }
      });
      this.AsO = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99972);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.Atm.sUS.setAlpha(f);
          f.this.Atm.AtN.setAlpha(f);
          AppMethodBeat.o(99972);
        }
      });
      this.AsO.setDuration(100L);
      this.yvH = new AnimatorSet();
      this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
      this.yvH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99974);
          ad.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
          f.this.Atm.zYc.setScaleX(1.0F);
          f.this.Atm.zYc.setScaleY(1.0F);
          f.this.Atm.zYc.setAlpha(1.0F);
          f.this.Atm.sUS.setAlpha(1.0F);
          f.this.Atm.AtN.setAlpha(1.0F);
          if (f.this.AsL != null) {
            f.this.AsL.onAnimationEnd();
          }
          f.this.Atm.grY = false;
          if (f.this.Atm.Atv.zWG)
          {
            if (f.this.Atm.Atv.zWz.getVisibility() == 0)
            {
              f.this.Atm.Atv.zWz.aB(0, false);
              ad.i("MicroMsg.FullCardAdClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(99974);
            }
          }
          else if (f.this.Atm.Atv.zWy.getVisibility() == 0)
          {
            f.this.Atm.Atv.zWy.ySq.clear();
            ad.i("MicroMsg.FullCardAdClickAnimation", "seek sightView to 0");
          }
          AppMethodBeat.o(99974);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99973);
          ad.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99973);
        }
      });
      AppMethodBeat.o(99975);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.FullCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99975);
    }
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99976);
    if ((this.yvH != null) && (!this.yvH.isStarted()))
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f
 * JD-Core Version:    0.7.0.1
 */