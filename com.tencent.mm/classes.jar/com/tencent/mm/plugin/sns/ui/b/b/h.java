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
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  k.a AKD;
  private ValueAnimator AKb;
  private ValueAnimator AKc;
  AnimatorSet yLH;
  
  public h(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99989);
    try
    {
      this.activity = paramMMActivity;
      this.AKD = ((k.a)paramBaseViewHolder);
      this.AKb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99984);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.AKD.Apn.setScaleX(f);
            h.this.AKD.Apn.setScaleY(f);
            h.this.AKD.Apn.setAlpha(f);
          }
          AppMethodBeat.o(99984);
        }
      });
      this.AKb.setDuration(400L);
      this.AKb.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99985);
          if (h.this.AKD.guz)
          {
            ae.i("MicroMsg.SphereCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = h.this;
            if (paramAnonymousAnimator.yLH != null) {
              paramAnonymousAnimator.yLH.end();
            }
            AppMethodBeat.o(99985);
            return;
          }
          h.this.AKD.guz = true;
          AppMethodBeat.o(99985);
        }
      });
      this.AKc = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AKc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99986);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.AKD.tgh.setAlpha(f);
          h.this.AKD.ALc.setAlpha(f);
          AppMethodBeat.o(99986);
        }
      });
      this.AKc.setDuration(100L);
      this.yLH = new AnimatorSet();
      this.yLH.playTogether(new Animator[] { this.AKb, this.AKc });
      this.yLH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99988);
          ae.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation end");
          h.this.AKD.Apn.setScaleX(1.0F);
          h.this.AKD.Apn.setScaleY(1.0F);
          h.this.AKD.Apn.setAlpha(1.0F);
          h.this.AKD.tgh.setAlpha(1.0F);
          h.this.AKD.ALc.setAlpha(1.0F);
          if (h.this.AJZ != null) {
            h.this.AJZ.onAnimationEnd();
          }
          h.this.AKD.AOK.ebD();
          h.this.AKD.AOK.AaM.requestRender();
          h.this.AKD.guz = false;
          AppMethodBeat.o(99988);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99987);
          ae.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99987);
        }
      });
      AppMethodBeat.o(99989);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ae.e("MicroMsg.SphereCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99989);
    }
  }
  
  public final void AR(long paramLong)
  {
    AppMethodBeat.i(99990);
    if ((this.yLH != null) && (!this.yLH.isStarted()))
    {
      this.yLH.setStartDelay(paramLong);
      this.yLH.start();
    }
    AppMethodBeat.o(99990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h
 * JD-Core Version:    0.7.0.1
 */