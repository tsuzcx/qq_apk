package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  private AnimatorSet CPA;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  c EUm;
  
  public f(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99922);
    try
    {
      this.activity = paramMMActivity;
      this.EUm = ((c)parama);
      this.EUa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99918);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.EUm.ExX.setScaleX(f);
            f.this.EUm.ExX.setScaleY(f);
            f.this.EUm.ExX.setAlpha(f);
          }
          AppMethodBeat.o(99918);
        }
      });
      this.EUa.setDuration(400L);
      this.EUa.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.EUb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179331);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.EUm.wnX.setAlpha(f);
          f.this.EUm.EVh.setAlpha(f);
          AppMethodBeat.o(179331);
        }
      });
      this.EUb.setDuration(100L);
      this.CPA = new AnimatorSet();
      this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
      this.CPA.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179333);
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
          f.this.EUm.ExX.setScaleX(1.0F);
          f.this.EUm.ExX.setScaleY(1.0F);
          f.this.EUm.ExX.setAlpha(1.0F);
          f.this.EUm.wnX.setAlpha(1.0F);
          f.this.EUm.EVh.setAlpha(1.0F);
          if (f.this.ETY != null) {
            f.this.ETY.onAnimationEnd();
          }
          if (f.this.EUm.EUK.EwA)
          {
            if (f.this.EUm.EUK.Ewt.getVisibility() == 0)
            {
              f.this.EUm.EUK.Ewt.aT(0, false);
              Log.i("MicroMsg.FullCardAdDetailClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(179333);
            }
          }
          else if (f.this.EUm.EUK.Ews.getVisibility() == 0)
          {
            f.this.EUm.EUK.Ews.Dnr.clear();
            Log.i("MicroMsg.FullCardAdDetailClickAnimation", "seek sightView to 0");
          }
          AppMethodBeat.o(179333);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179332);
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(179332);
        }
      });
      AppMethodBeat.o(99922);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99922);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99923);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f
 * JD-Core Version:    0.7.0.1
 */