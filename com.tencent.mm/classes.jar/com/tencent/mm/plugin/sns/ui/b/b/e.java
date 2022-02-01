package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  extends a
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  e.a Atm;
  AnimatorSet yvH;
  
  public e(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99968);
    try
    {
      this.activity = paramMMActivity;
      this.Atm = ((e.a)paramBaseViewHolder);
      this.AsN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99963);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.Atm.zYc.setScaleX(f);
            e.this.Atm.zYc.setScaleY(f);
            e.this.Atm.zYc.setAlpha(f);
          }
          AppMethodBeat.o(99963);
        }
      });
      this.AsN.setDuration(400L);
      this.AsN.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99964);
          if (e.this.Atm.grY)
          {
            ad.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = e.this.yvH.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99964);
            return;
          }
          e.this.Atm.grY = true;
          e.this.Atm.sUS.setAlpha(0.0F);
          e.this.Atm.AtN.setAlpha(0.0F);
          AppMethodBeat.o(99964);
        }
      });
      this.AsO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99965);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.Atm.sUS.setAlpha(f);
          e.this.Atm.AtN.setAlpha(f);
          AppMethodBeat.o(99965);
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
          AppMethodBeat.i(99967);
          ad.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
          e.this.Atm.zYc.setScaleX(1.0F);
          e.this.Atm.zYc.setScaleY(1.0F);
          e.this.Atm.zYc.setAlpha(1.0F);
          e.this.Atm.sUS.setAlpha(1.0F);
          e.this.Atm.AtN.setAlpha(1.0F);
          if (e.this.AsL != null) {
            e.this.AsL.onAnimationEnd();
          }
          e.this.Atm.grY = false;
          AppMethodBeat.o(99967);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99966);
          ad.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99966);
        }
      });
      AppMethodBeat.o(99968);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.FullCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99968);
    }
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99969);
    if ((this.yvH != null) && (!this.yvH.isStarted()))
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e
 * JD-Core Version:    0.7.0.1
 */