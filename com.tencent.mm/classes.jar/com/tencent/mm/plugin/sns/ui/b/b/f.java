package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  AnimatorSet vWT;
  d.a xOF;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  
  public f(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99975);
    try
    {
      this.activity = paramMMActivity;
      this.xOF = ((d.a)paramBaseViewHolder);
      this.xOg = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99970);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.xOF.xtU.setScaleX(f);
            f.this.xOF.xtU.setScaleY(f);
            f.this.xOF.xtU.setAlpha(f);
          }
          AppMethodBeat.o(99970);
        }
      });
      this.xOg.setDuration(400L);
      this.xOg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99971);
          if (f.this.xOF.fUH)
          {
            ad.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = f.this;
            if (paramAnonymousAnimator.vWT != null) {
              paramAnonymousAnimator.vWT.end();
            }
            AppMethodBeat.o(99971);
            return;
          }
          f.this.xOF.fUH = true;
          AppMethodBeat.o(99971);
        }
      });
      this.xOh = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99972);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.xOF.qXs.setAlpha(f);
          f.this.xOF.xPg.setAlpha(f);
          AppMethodBeat.o(99972);
        }
      });
      this.xOh.setDuration(100L);
      this.vWT = new AnimatorSet();
      this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
      this.vWT.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99974);
          ad.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
          f.this.xOF.xtU.setScaleX(1.0F);
          f.this.xOF.xtU.setScaleY(1.0F);
          f.this.xOF.xtU.setAlpha(1.0F);
          f.this.xOF.qXs.setAlpha(1.0F);
          f.this.xOF.xPg.setAlpha(1.0F);
          if (f.this.xOe != null) {
            f.this.xOe.onAnimationEnd();
          }
          f.this.xOF.fUH = false;
          if (f.this.xOF.xOO.xsv)
          {
            if (f.this.xOF.xOO.xso.getVisibility() == 0)
            {
              f.this.xOF.xOO.xso.at(0, false);
              ad.i("MicroMsg.FullCardAdClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(99974);
            }
          }
          else if (f.this.xOF.xOO.xsn.getVisibility() == 0)
          {
            f.this.xOF.xOO.xsn.wsq.clear();
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
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99976);
    if ((this.vWT != null) && (!this.vWT.isStarted()))
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f
 * JD-Core Version:    0.7.0.1
 */