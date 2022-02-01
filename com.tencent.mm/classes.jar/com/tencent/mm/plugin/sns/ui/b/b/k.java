package com.tencent.mm.plugin.sns.ui.b.b;

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
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class k
  extends b
{
  AnimatorSet Div;
  n.a RIR;
  private ValueAnimator RIs;
  private ValueAnimator RIw;
  
  public k(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99989);
    try
    {
      this.activity = paramMMActivity;
      this.RIR = ((n.a)paramBaseViewHolder);
      this.RIs = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99984);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            k.this.RIR.Cxb.setScaleX(f);
            k.this.RIR.Cxb.setScaleY(f);
            k.this.RIR.Cxb.setAlpha(f);
          }
          AppMethodBeat.o(99984);
        }
      });
      this.RIs.setDuration(400L);
      this.RIs.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99985);
          if (k.this.RIR.mtE)
          {
            Log.i("MicroMsg.SphereCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = k.this;
            if (paramAnonymousAnimator.Div != null) {
              paramAnonymousAnimator.Div.end();
            }
            AppMethodBeat.o(99985);
            return;
          }
          k.this.RIR.mtE = true;
          AppMethodBeat.o(99985);
        }
      });
      this.RIw = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.RIw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99986);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          k.this.RIR.GBf.setAlpha(f);
          k.this.RIR.QbY.setAlpha(f);
          AppMethodBeat.o(99986);
        }
      });
      this.RIw.setDuration(100L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs, this.RIw });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99988);
          Log.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation end");
          k.this.RIR.Cxb.setScaleX(1.0F);
          k.this.RIR.Cxb.setScaleY(1.0F);
          k.this.RIR.Cxb.setAlpha(1.0F);
          k.this.RIR.GBf.setAlpha(1.0F);
          k.this.RIR.QbY.setAlpha(1.0F);
          if (k.this.RIn != null) {
            k.this.RIn.onAnimationEnd();
          }
          k.this.RIR.RNm.hkt();
          k.this.RIR.RNm.QUV.requestRender();
          k.this.RIR.mtE = false;
          AppMethodBeat.o(99988);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99987);
          Log.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99987);
        }
      });
      AppMethodBeat.o(99989);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SphereCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99989);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99990);
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.k
 * JD-Core Version:    0.7.0.1
 */