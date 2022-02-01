package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  AnimatorSet Div;
  private ValueAnimator RIs;
  private ValueAnimator RIw;
  
  public f(MMActivity paramMMActivity, final a.b paramb)
  {
    AppMethodBeat.i(309324);
    try
    {
      Log.d("MicroMsg.FullCardAnim.click", "new FullCardAdClickAnimationNew, source=" + paramb.Qcx.source + ", hash=" + hashCode());
      this.activity = paramMMActivity;
      this.RIs = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309345);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            paramb.Cxb.setScaleX(f);
            paramb.Cxb.setScaleY(f);
            paramb.Cxb.setAlpha(f);
          }
          AppMethodBeat.o(309345);
        }
      });
      this.RIs.setDuration(400L);
      this.RIs.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309343);
          if (paramb.Qcx.mtE)
          {
            Log.i("MicroMsg.FullCardAnim.click", "holder is busy");
            paramAnonymousAnimator = f.this;
            Log.d("MicroMsg.FullCardAnim.click", "endAnimation, hash=" + paramAnonymousAnimator.hashCode());
            if (paramAnonymousAnimator.Div != null) {
              paramAnonymousAnimator.Div.end();
            }
            AppMethodBeat.o(309343);
            return;
          }
          paramb.Qcx.mtE = true;
          AppMethodBeat.o(309343);
        }
      });
      this.RIw = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309341);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramb.GBf.setAlpha(f);
          paramb.QbY.setAlpha(f);
          AppMethodBeat.o(309341);
        }
      });
      this.RIw.setDuration(100L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309350);
          Log.i("MicroMsg.FullCardAnim.click", "onAnimation end");
          paramb.Cxb.setScaleX(1.0F);
          paramb.Cxb.setScaleY(1.0F);
          paramb.Cxb.setAlpha(1.0F);
          paramb.GBf.setAlpha(1.0F);
          paramb.QbY.setAlpha(1.0F);
          if (f.this.RIn != null) {
            f.this.RIn.onAnimationEnd();
          }
          paramb.Qcx.mtE = false;
          if (paramb.Qcx.QbW)
          {
            if (paramb.Qcr != null)
            {
              paramb.Qcr.bJ(0, false);
              AppMethodBeat.o(309350);
            }
          }
          else if (paramb.Qcj.RjN.getVisibility() == 0)
          {
            paramAnonymousAnimator = paramb.Qcj.RjN;
            if (paramAnonymousAnimator.RWJ != null) {
              paramAnonymousAnimator.RWJ.accept(Boolean.TRUE);
            }
            paramAnonymousAnimator.bJ(0, false);
            Log.i("MicroMsg.FullCardAnim.click", "seek newVideoView to 0");
          }
          AppMethodBeat.o(309350);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309346);
          Log.i("MicroMsg.FullCardAnim.click", "onAnimation start");
          AppMethodBeat.o(309346);
        }
      });
      AppMethodBeat.o(309324);
      return;
    }
    finally
    {
      Log.e("MicroMsg.FullCardAnim.click", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(309324);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(309328);
    Log.d("MicroMsg.FullCardAnim.click", "startAnimation, hash=" + hashCode());
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(309328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f
 * JD-Core Version:    0.7.0.1
 */