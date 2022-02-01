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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  k.a Atp;
  AnimatorSet yvH;
  
  public h(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99989);
    try
    {
      this.activity = paramMMActivity;
      this.Atp = ((k.a)paramBaseViewHolder);
      this.AsN = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99984);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.Atp.zYc.setScaleX(f);
            h.this.Atp.zYc.setScaleY(f);
            h.this.Atp.zYc.setAlpha(f);
          }
          AppMethodBeat.o(99984);
        }
      });
      this.AsN.setDuration(400L);
      this.AsN.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99985);
          if (h.this.Atp.grY)
          {
            ad.i("MicroMsg.SphereCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = h.this;
            if (paramAnonymousAnimator.yvH != null) {
              paramAnonymousAnimator.yvH.end();
            }
            AppMethodBeat.o(99985);
            return;
          }
          h.this.Atp.grY = true;
          AppMethodBeat.o(99985);
        }
      });
      this.AsO = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99986);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.Atp.sUS.setAlpha(f);
          h.this.Atp.AtN.setAlpha(f);
          AppMethodBeat.o(99986);
        }
      });
      this.AsO.setDuration(100L);
      this.yvH = new AnimatorSet();
      this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
      this.yvH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99988);
          ad.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation end");
          h.this.Atp.zYc.setScaleX(1.0F);
          h.this.Atp.zYc.setScaleY(1.0F);
          h.this.Atp.zYc.setAlpha(1.0F);
          h.this.Atp.sUS.setAlpha(1.0F);
          h.this.Atp.AtN.setAlpha(1.0F);
          if (h.this.AsL != null) {
            h.this.AsL.onAnimationEnd();
          }
          h.this.Atp.Axr.dXZ();
          h.this.Atp.Axr.zJF.requestRender();
          h.this.Atp.grY = false;
          AppMethodBeat.o(99988);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99987);
          ad.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99987);
        }
      });
      AppMethodBeat.o(99989);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.SphereCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99989);
    }
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99990);
    if ((this.yvH != null) && (!this.yvH.isStarted()))
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h
 * JD-Core Version:    0.7.0.1
 */