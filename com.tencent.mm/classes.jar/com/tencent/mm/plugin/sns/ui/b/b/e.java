package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  extends a
{
  AnimatorSet IVc;
  g.a LiE;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  
  public e(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99968);
    try
    {
      this.activity = paramMMActivity;
      this.LiE = ((g.a)paramBaseViewHolder);
      this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99963);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.LiE.xYJ.setScaleX(f);
            e.this.LiE.xYJ.setScaleY(f);
            e.this.LiE.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(99963);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99964);
          if (e.this.LiE.jTm)
          {
            Log.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = e.this.IVc.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(99964);
            return;
          }
          e.this.LiE.jTm = true;
          e.this.LiE.AZc.setAlpha(0.0F);
          e.this.LiE.JKr.setAlpha(0.0F);
          AppMethodBeat.o(99964);
        }
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99965);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.LiE.AZc.setAlpha(f);
          e.this.LiE.JKr.setAlpha(f);
          AppMethodBeat.o(99965);
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
          AppMethodBeat.i(99967);
          Log.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
          e.this.LiE.xYJ.setScaleX(1.0F);
          e.this.LiE.xYJ.setScaleY(1.0F);
          e.this.LiE.xYJ.setAlpha(1.0F);
          e.this.LiE.AZc.setAlpha(1.0F);
          e.this.LiE.JKr.setAlpha(1.0F);
          if (e.this.Lia != null) {
            e.this.Lia.onAnimationEnd();
          }
          e.this.LiE.jTm = false;
          AppMethodBeat.o(99967);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99966);
          Log.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(99966);
        }
      });
      AppMethodBeat.o(99968);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99968);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99969);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e
 * JD-Core Version:    0.7.0.1
 */