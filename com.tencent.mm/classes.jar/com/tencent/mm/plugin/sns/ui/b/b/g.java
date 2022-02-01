package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class g
  extends a
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  k.a Atp;
  AnimatorSet yvH;
  
  public g(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99982);
    try
    {
      this.activity = paramMMActivity;
      this.Atp = ((k.a)paramBaseViewHolder);
      this.AsN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99977);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            g.this.Atp.zYc.setScaleX(f);
            g.this.Atp.zYc.setScaleY(f);
            g.this.Atp.zYc.setAlpha(f);
          }
          AppMethodBeat.o(99977);
        }
      });
      this.AsN.setDuration(400L);
      this.AsN.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99978);
          if (g.this.Atp.grY)
          {
            ad.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = g.this.yvH.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99978);
            return;
          }
          g.this.Atp.grY = true;
          g.this.Atp.sUS.setAlpha(0.0F);
          g.this.Atp.AtN.setAlpha(0.0F);
          AppMethodBeat.o(99978);
        }
      });
      this.AsO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99979);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.Atp.sUS.setAlpha(f);
          g.this.Atp.AtN.setAlpha(f);
          AppMethodBeat.o(99979);
        }
      });
      this.AsO.setDuration(100L);
      this.AsO.setStartDelay(300L);
      this.yvH = new AnimatorSet();
      this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
      this.yvH.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99981);
          ad.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
          g.this.Atp.zYc.setScaleX(1.0F);
          g.this.Atp.zYc.setScaleY(1.0F);
          g.this.Atp.zYc.setAlpha(1.0F);
          g.this.Atp.sUS.setAlpha(1.0F);
          g.this.Atp.AtN.setAlpha(1.0F);
          if (g.this.AsL != null) {
            g.this.AsL.onAnimationEnd();
          }
          g.this.Atp.grY = false;
          AppMethodBeat.o(99981);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99980);
          ad.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99980);
        }
      });
      AppMethodBeat.o(99982);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99982);
    }
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99983);
    if ((this.yvH != null) && (!this.yvH.isStarted()))
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g
 * JD-Core Version:    0.7.0.1
 */