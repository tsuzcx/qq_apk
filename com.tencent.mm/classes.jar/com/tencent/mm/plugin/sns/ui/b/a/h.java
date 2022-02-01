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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  private AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  d zbl;
  
  public h(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99935);
    try
    {
      this.activity = paramMMActivity;
      this.zbl = ((d)parama);
      this.zaW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99931);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.zbl.yGK.setScaleX(f);
            h.this.zbl.yGK.setScaleY(f);
            h.this.zbl.yGK.setAlpha(f);
          }
          AppMethodBeat.o(99931);
        }
      });
      this.zaW.setDuration(400L);
      this.zaW.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.zaX = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99932);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.zbl.zcz.setAlpha(f);
          h.this.zbl.zcA.setAlpha(f);
          AppMethodBeat.o(99932);
        }
      });
      this.zaX.setDuration(100L);
      this.xhG = new AnimatorSet();
      this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
      this.xhG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99934);
          ac.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation end");
          h.this.zbl.yGK.setScaleX(1.0F);
          h.this.zbl.yGK.setScaleY(1.0F);
          h.this.zbl.yGK.setAlpha(1.0F);
          h.this.zbl.zcz.setAlpha(1.0F);
          h.this.zbl.zcA.setAlpha(1.0F);
          if (h.this.zaU != null) {
            h.this.zaU.onAnimationEnd();
          }
          h.this.zbl.ypX.dLJ();
          h.this.zbl.ypX.ysx.requestRender();
          AppMethodBeat.o(99934);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99933);
          ac.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(99933);
        }
      });
      AppMethodBeat.o(99935);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ac.e("MicroMsg.SphereCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99935);
    }
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99936);
    if ((this.xhG != null) && (!this.xhG.isStarted()))
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h
 * JD-Core Version:    0.7.0.1
 */