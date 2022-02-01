package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.f.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  AnimatorSet CPA;
  f.a EUA;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  
  public f(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99975);
    try
    {
      this.activity = paramMMActivity;
      this.EUA = ((f.a)paramBaseViewHolder);
      this.EUa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99970);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.EUA.ExX.setScaleX(f);
            f.this.EUA.ExX.setScaleY(f);
            f.this.EUA.ExX.setAlpha(f);
          }
          AppMethodBeat.o(99970);
        }
      });
      this.EUa.setDuration(400L);
      this.EUa.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99971);
          if (f.this.EUA.hho)
          {
            Log.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = f.this;
            if (paramAnonymousAnimator.CPA != null) {
              paramAnonymousAnimator.CPA.end();
            }
            AppMethodBeat.o(99971);
            return;
          }
          f.this.EUA.hho = true;
          AppMethodBeat.o(99971);
        }
      });
      this.EUb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99972);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.EUA.wnX.setAlpha(f);
          f.this.EUA.EVh.setAlpha(f);
          AppMethodBeat.o(99972);
        }
      });
      this.EUb.setDuration(100L);
      this.CPA = new AnimatorSet();
      this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
      this.CPA.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99974);
          Log.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
          f.this.EUA.ExX.setScaleX(1.0F);
          f.this.EUA.ExX.setScaleY(1.0F);
          f.this.EUA.ExX.setAlpha(1.0F);
          f.this.EUA.wnX.setAlpha(1.0F);
          f.this.EUA.EVh.setAlpha(1.0F);
          if (f.this.ETY != null) {
            f.this.ETY.onAnimationEnd();
          }
          f.this.EUA.hho = false;
          if (f.this.EUA.EUK.EwA)
          {
            if (f.this.EUA.EUK.Ewt.getVisibility() == 0)
            {
              f.this.EUA.EUK.Ewt.aT(0, false);
              Log.i("MicroMsg.FullCardAdClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(99974);
            }
          }
          else if (f.this.EUA.EUK.Ews.getVisibility() == 0)
          {
            f.this.EUA.EUK.Ews.Dnr.clear();
            Log.i("MicroMsg.FullCardAdClickAnimation", "seek sightView to 0");
          }
          AppMethodBeat.o(99974);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99973);
          Log.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99973);
        }
      });
      AppMethodBeat.o(99975);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99975);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99976);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f
 * JD-Core Version:    0.7.0.1
 */