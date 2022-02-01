package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  extends a
{
  AnimatorSet Div;
  private ValueAnimator RIs;
  private ValueAnimator RIw;
  
  public e(MMActivity paramMMActivity, final a.b paramb)
  {
    AppMethodBeat.i(309326);
    try
    {
      Log.d("MicroMsg.FullCardAnim.back", "new FullCardAdBackAnimationNew, source=" + paramb.Qcx.source + ", hash=" + hashCode());
      this.activity = paramMMActivity;
      this.RIs = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309355);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            paramb.Cxb.setScaleX(f);
            paramb.Cxb.setScaleY(f);
            paramb.Cxb.setAlpha(f);
          }
          AppMethodBeat.o(309355);
        }
      });
      this.RIs.setDuration(400L);
      this.RIs.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309356);
          if (paramb.Qcx.mtE)
          {
            Log.i("MicroMsg.FullCardAnim.back", "holder is busy");
            paramAnonymousAnimator = e.this.Div.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(309356);
            return;
          }
          paramb.Qcx.mtE = true;
          paramb.GBf.setAlpha(0.0F);
          paramb.QbY.setAlpha(0.0F);
          AppMethodBeat.o(309356);
        }
      });
      this.RIw = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309358);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramb.GBf.setAlpha(f);
          paramb.QbY.setAlpha(f);
          AppMethodBeat.o(309358);
        }
      });
      this.RIw.setDuration(100L);
      this.RIw.setStartDelay(300L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309360);
          Log.i("MicroMsg.FullCardAnim.back", "onAnimation end");
          paramb.Cxb.setScaleX(1.0F);
          paramb.Cxb.setScaleY(1.0F);
          paramb.Cxb.setAlpha(1.0F);
          paramb.GBf.setAlpha(1.0F);
          paramb.QbY.setAlpha(1.0F);
          if (e.this.RIn != null) {
            e.this.RIn.onAnimationEnd();
          }
          paramb.Qcx.mtE = false;
          AppMethodBeat.o(309360);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309357);
          Log.i("MicroMsg.FullCardAnim.back", "onAnimation start");
          AppMethodBeat.o(309357);
        }
      });
      AppMethodBeat.o(309326);
      return;
    }
    finally
    {
      Log.e("MicroMsg.FullCardAnim.back", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(309326);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(309330);
    Log.d("MicroMsg.FullCardAnim.back", "startAnimation, hash=" + hashCode());
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(309330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e
 * JD-Core Version:    0.7.0.1
 */