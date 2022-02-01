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
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  d AKq;
  private AnimatorSet yLH;
  
  public h(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99935);
    try
    {
      this.activity = paramMMActivity;
      this.AKq = ((d)parama);
      this.AKb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99931);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.AKq.Apn.setScaleX(f);
            h.this.AKq.Apn.setScaleY(f);
            h.this.AKq.Apn.setAlpha(f);
          }
          AppMethodBeat.o(99931);
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
          AppMethodBeat.i(99932);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.AKq.ALE.setAlpha(f);
          h.this.AKq.ALF.setAlpha(f);
          AppMethodBeat.o(99932);
        }
      });
      this.AKc.setDuration(100L);
      this.yLH = new AnimatorSet();
      this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
      this.yLH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99934);
          ae.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation end");
          h.this.AKq.Apn.setScaleX(1.0F);
          h.this.AKq.Apn.setScaleY(1.0F);
          h.this.AKq.Apn.setAlpha(1.0F);
          h.this.AKq.ALE.setAlpha(1.0F);
          h.this.AKq.ALF.setAlpha(1.0F);
          if (h.this.AJZ != null) {
            h.this.AJZ.onAnimationEnd();
          }
          h.this.AKq.zYm.ebD();
          h.this.AKq.zYm.AaM.requestRender();
          AppMethodBeat.o(99934);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99933);
          ae.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(99933);
        }
      });
      AppMethodBeat.o(99935);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ae.e("MicroMsg.SphereCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99935);
    }
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99936);
    if ((this.yLH != null) && (!this.yLH.isStarted()))
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h
 * JD-Core Version:    0.7.0.1
 */