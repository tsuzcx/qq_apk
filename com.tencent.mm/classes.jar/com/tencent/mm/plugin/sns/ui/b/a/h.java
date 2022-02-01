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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  d Atc;
  private AnimatorSet yvH;
  
  public h(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99935);
    try
    {
      this.activity = paramMMActivity;
      this.Atc = ((d)parama);
      this.AsN = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99931);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.Atc.zYc.setScaleX(f);
            h.this.Atc.zYc.setScaleY(f);
            h.this.Atc.zYc.setAlpha(f);
          }
          AppMethodBeat.o(99931);
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
          AppMethodBeat.i(99932);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.Atc.Aup.setAlpha(f);
          h.this.Atc.Auq.setAlpha(f);
          AppMethodBeat.o(99932);
        }
      });
      this.AsO.setDuration(100L);
      this.yvH = new AnimatorSet();
      this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
      this.yvH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99934);
          ad.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation end");
          h.this.Atc.zYc.setScaleX(1.0F);
          h.this.Atc.zYc.setScaleY(1.0F);
          h.this.Atc.zYc.setAlpha(1.0F);
          h.this.Atc.Aup.setAlpha(1.0F);
          h.this.Atc.Auq.setAlpha(1.0F);
          if (h.this.AsL != null) {
            h.this.AsL.onAnimationEnd();
          }
          h.this.Atc.zHf.dXZ();
          h.this.Atc.zHf.zJF.requestRender();
          AppMethodBeat.o(99934);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99933);
          ad.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(99933);
        }
      });
      AppMethodBeat.o(99935);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.SphereCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99935);
    }
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99936);
    if ((this.yvH != null) && (!this.yvH.isStarted()))
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h
 * JD-Core Version:    0.7.0.1
 */