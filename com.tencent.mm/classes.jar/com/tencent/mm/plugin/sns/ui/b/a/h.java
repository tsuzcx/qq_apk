package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  private AnimatorSet Div;
  private ValueAnimator RIs;
  f RIv;
  private ValueAnimator RIw;
  
  public h(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(99935);
    try
    {
      this.activity = paramMMActivity;
      this.RIv = ((f)paramb);
      this.RIs = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99931);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.RIv.Cxb.setScaleX(f);
            h.this.RIv.Cxb.setScaleY(f);
            h.this.RIv.Cxb.setAlpha(f);
          }
          AppMethodBeat.o(99931);
        }
      });
      this.RIs.setDuration(400L);
      this.RIs.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.RIw = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99932);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.RIv.RJK.setAlpha(f);
          h.this.RIv.RJL.setAlpha(f);
          AppMethodBeat.o(99932);
        }
      });
      this.RIw.setDuration(100L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99934);
          Log.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation end");
          h.this.RIv.Cxb.setScaleX(1.0F);
          h.this.RIv.Cxb.setScaleY(1.0F);
          h.this.RIv.Cxb.setAlpha(1.0F);
          h.this.RIv.RJK.setAlpha(1.0F);
          h.this.RIv.RJL.setAlpha(1.0F);
          if (h.this.RIn != null) {
            h.this.RIn.onAnimationEnd();
          }
          h.this.RIv.QSc.hkt();
          h.this.RIv.QSc.QUV.requestRender();
          AppMethodBeat.o(99934);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99933);
          Log.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(99933);
        }
      });
      AppMethodBeat.o(99935);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SphereCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99935);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99936);
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h
 * JD-Core Version:    0.7.0.1
 */