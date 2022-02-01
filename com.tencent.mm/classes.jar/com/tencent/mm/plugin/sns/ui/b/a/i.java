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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class i
  extends b
{
  private AnimatorSet CPA;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  d EUq;
  
  public i(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99935);
    try
    {
      this.activity = paramMMActivity;
      this.EUq = ((d)parama);
      this.EUa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99931);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            i.this.EUq.ExX.setScaleX(f);
            i.this.EUq.ExX.setScaleY(f);
            i.this.EUq.ExX.setAlpha(f);
          }
          AppMethodBeat.o(99931);
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
          AppMethodBeat.i(99932);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          i.this.EUq.EVJ.setAlpha(f);
          i.this.EUq.EVK.setAlpha(f);
          AppMethodBeat.o(99932);
        }
      });
      this.EUb.setDuration(100L);
      this.CPA = new AnimatorSet();
      this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
      this.CPA.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99934);
          Log.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation end");
          i.this.EUq.ExX.setScaleX(1.0F);
          i.this.EUq.ExX.setScaleY(1.0F);
          i.this.EUq.ExX.setAlpha(1.0F);
          i.this.EUq.EVJ.setAlpha(1.0F);
          i.this.EUq.EVK.setAlpha(1.0F);
          if (i.this.ETY != null) {
            i.this.ETY.onAnimationEnd();
          }
          i.this.EUq.EgD.feu();
          i.this.EUq.EgD.Ejd.requestRender();
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
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SphereCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99935);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99936);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i
 * JD-Core Version:    0.7.0.1
 */