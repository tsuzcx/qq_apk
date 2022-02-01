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
  private AnimatorSet vWT;
  private ValueAnimator xOg;
  private ValueAnimator xOh;
  d xOv;
  
  public h(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99935);
    try
    {
      this.activity = paramMMActivity;
      this.xOv = ((d)parama);
      this.xOg = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.xOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99931);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.xOv.xtU.setScaleX(f);
            h.this.xOv.xtU.setScaleY(f);
            h.this.xOv.xtU.setAlpha(f);
          }
          AppMethodBeat.o(99931);
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
          AppMethodBeat.i(99932);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.xOv.xPJ.setAlpha(f);
          h.this.xOv.xPK.setAlpha(f);
          AppMethodBeat.o(99932);
        }
      });
      this.xOh.setDuration(100L);
      this.vWT = new AnimatorSet();
      this.vWT.playTogether(new Animator[] { this.xOg, this.xOh });
      this.vWT.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99934);
          ad.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation end");
          h.this.xOv.xtU.setScaleX(1.0F);
          h.this.xOv.xtU.setScaleY(1.0F);
          h.this.xOv.xtU.setAlpha(1.0F);
          h.this.xOv.xPJ.setAlpha(1.0F);
          h.this.xOv.xPK.setAlpha(1.0F);
          if (h.this.xOe != null) {
            h.this.xOe.onAnimationEnd();
          }
          h.this.xOv.xdi.dxk();
          h.this.xOv.xdi.xfJ.requestRender();
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
  
  public final void ts(long paramLong)
  {
    AppMethodBeat.i(99936);
    if ((this.vWT != null) && (!this.vWT.isStarted()))
    {
      this.vWT.setStartDelay(paramLong);
      this.vWT.start();
    }
    AppMethodBeat.o(99936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h
 * JD-Core Version:    0.7.0.1
 */