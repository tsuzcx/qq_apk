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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  c AsZ;
  private AnimatorSet yvH;
  
  public f(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99922);
    try
    {
      this.activity = paramMMActivity;
      this.AsZ = ((c)parama);
      this.AsN = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99918);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.AsZ.zYc.setScaleX(f);
            f.this.AsZ.zYc.setScaleY(f);
            f.this.AsZ.zYc.setAlpha(f);
          }
          AppMethodBeat.o(99918);
        }
      });
      this.AsN.setDuration(400L);
      this.AsN.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.AsO = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179331);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.AsZ.sUS.setAlpha(f);
          f.this.AsZ.AtN.setAlpha(f);
          AppMethodBeat.o(179331);
        }
      });
      this.AsO.setDuration(100L);
      this.yvH = new AnimatorSet();
      this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
      this.yvH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179333);
          ad.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
          f.this.AsZ.zYc.setScaleX(1.0F);
          f.this.AsZ.zYc.setScaleY(1.0F);
          f.this.AsZ.zYc.setAlpha(1.0F);
          f.this.AsZ.sUS.setAlpha(1.0F);
          f.this.AsZ.AtN.setAlpha(1.0F);
          if (f.this.AsL != null) {
            f.this.AsL.onAnimationEnd();
          }
          if (f.this.AsZ.Atv.zWG)
          {
            if (f.this.AsZ.Atv.zWz.getVisibility() == 0)
            {
              f.this.AsZ.Atv.zWz.aB(0, false);
              ad.i("MicroMsg.FullCardAdDetailClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(179333);
            }
          }
          else if (f.this.AsZ.Atv.zWy.getVisibility() == 0)
          {
            f.this.AsZ.Atv.zWy.ySq.clear();
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
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99923);
    if ((this.yvH != null) && (!this.yvH.isStarted()))
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f
 * JD-Core Version:    0.7.0.1
 */