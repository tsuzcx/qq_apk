package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class m
  extends a
{
  AnimatorSet IVc;
  p.a LiP;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  
  public m(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99982);
    try
    {
      this.activity = paramMMActivity;
      this.LiP = ((p.a)paramBaseViewHolder);
      this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99977);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            m.this.LiP.xYJ.setScaleX(f);
            m.this.LiP.xYJ.setScaleY(f);
            m.this.LiP.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(99977);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99978);
          if (m.this.LiP.jTm)
          {
            Log.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = m.this.IVc.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99978);
            return;
          }
          m.this.LiP.jTm = true;
          m.this.LiP.AZc.setAlpha(0.0F);
          m.this.LiP.JKr.setAlpha(0.0F);
          AppMethodBeat.o(99978);
        }
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99979);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          m.this.LiP.AZc.setAlpha(f);
          m.this.LiP.JKr.setAlpha(f);
          AppMethodBeat.o(99979);
        }
      });
      this.Lig.setDuration(100L);
      this.Lig.setStartDelay(300L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99981);
          Log.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
          m.this.LiP.xYJ.setScaleX(1.0F);
          m.this.LiP.xYJ.setScaleY(1.0F);
          m.this.LiP.xYJ.setAlpha(1.0F);
          m.this.LiP.AZc.setAlpha(1.0F);
          m.this.LiP.JKr.setAlpha(1.0F);
          if (m.this.Lia != null) {
            m.this.Lia.onAnimationEnd();
          }
          m.this.LiP.jTm = false;
          AppMethodBeat.o(99981);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99980);
          Log.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99980);
        }
      });
      AppMethodBeat.o(99982);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99982);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99983);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.m
 * JD-Core Version:    0.7.0.1
 */