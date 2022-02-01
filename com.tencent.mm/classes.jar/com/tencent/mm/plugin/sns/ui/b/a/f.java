package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  c AKn;
  private AnimatorSet yLH;
  
  public f(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99922);
    try
    {
      this.activity = paramMMActivity;
      this.AKn = ((c)parama);
      this.AKb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99918);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.AKn.Apn.setScaleX(f);
            f.this.AKn.Apn.setScaleY(f);
            f.this.AKn.Apn.setAlpha(f);
          }
          AppMethodBeat.o(99918);
        }
      });
      this.AKb.setDuration(400L);
      this.AKb.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.AKc = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179331);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.AKn.tgh.setAlpha(f);
          f.this.AKn.ALc.setAlpha(f);
          AppMethodBeat.o(179331);
        }
      });
      this.AKc.setDuration(100L);
      this.yLH = new AnimatorSet();
      this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
      this.yLH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179333);
          ae.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
          f.this.AKn.Apn.setScaleX(1.0F);
          f.this.AKn.Apn.setScaleY(1.0F);
          f.this.AKn.Apn.setAlpha(1.0F);
          f.this.AKn.tgh.setAlpha(1.0F);
          f.this.AKn.ALc.setAlpha(1.0F);
          if (f.this.AJZ != null) {
            f.this.AJZ.onAnimationEnd();
          }
          if (f.this.AKn.AKJ.AnP)
          {
            if (f.this.AKn.AKJ.AnI.getVisibility() == 0)
            {
              f.this.AKn.AKJ.AnI.aE(0, false);
              ae.i("MicroMsg.FullCardAdDetailClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(179333);
            }
          }
          else if (f.this.AKn.AKJ.AnH.getVisibility() == 0)
          {
            f.this.AKn.AKJ.AnH.ziA.clear();
            ae.i("MicroMsg.FullCardAdDetailClickAnimation", "seek sightView to 0");
          }
          AppMethodBeat.o(179333);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179332);
          ae.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(179332);
        }
      });
      AppMethodBeat.o(99922);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ae.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99922);
    }
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99923);
    if ((this.yLH != null) && (!this.yLH.isStarted()))
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f
 * JD-Core Version:    0.7.0.1
 */