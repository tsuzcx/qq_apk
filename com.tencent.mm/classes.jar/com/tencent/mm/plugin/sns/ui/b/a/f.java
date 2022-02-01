package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  private AnimatorSet vWT;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  c xOs;
  
  public f(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99922);
    try
    {
      this.activity = paramMMActivity;
      this.xOs = ((c)parama);
      this.xOg = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99918);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.xOs.xtU.setScaleX(f);
            f.this.xOs.xtU.setScaleY(f);
            f.this.xOs.xtU.setAlpha(f);
          }
          AppMethodBeat.o(99918);
        }
      });
      this.xOg.setDuration(400L);
      this.xOg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.xOh = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.xOh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179331);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.xOs.qXs.setAlpha(f);
          f.this.xOs.xPg.setAlpha(f);
          AppMethodBeat.o(179331);
        }
      });
      this.xOh.setDuration(100L);
      this.vWT = new AnimatorSet();
      this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
      this.vWT.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179333);
          ad.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
          f.this.xOs.xtU.setScaleX(1.0F);
          f.this.xOs.xtU.setScaleY(1.0F);
          f.this.xOs.xtU.setAlpha(1.0F);
          f.this.xOs.qXs.setAlpha(1.0F);
          f.this.xOs.xPg.setAlpha(1.0F);
          if (f.this.xOe != null) {
            f.this.xOe.onAnimationEnd();
          }
          if (f.this.xOs.xOO.xsv)
          {
            if (f.this.xOs.xOO.xso.getVisibility() == 0)
            {
              f.this.xOs.xOO.xso.at(0, false);
              ad.i("MicroMsg.FullCardAdDetailClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(179333);
            }
          }
          else if (f.this.xOs.xOO.xsn.getVisibility() == 0)
          {
            f.this.xOs.xOO.xsn.wsq.clear();
            ad.i("MicroMsg.FullCardAdDetailClickAnimation", "seek sightView to 0");
          }
          AppMethodBeat.o(179333);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179332);
          ad.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(179332);
        }
      });
      AppMethodBeat.o(99922);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99922);
    }
  }
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99923);
    if ((this.vWT != null) && (!this.vWT.isStarted()))
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f
 * JD-Core Version:    0.7.0.1
 */