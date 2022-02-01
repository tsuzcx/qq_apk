package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class f
  extends a
{
  AnimatorSet IVc;
  h.a LiG;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  
  public f(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(220272);
    try
    {
      this.activity = paramMMActivity;
      this.LiG = ((h.a)paramBaseViewHolder);
      this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(217130);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            f.this.LiG.Lnh.xYJ.setScaleX(f);
            f.this.LiG.Lnh.xYJ.setScaleY(f);
            f.this.LiG.Lnh.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(217130);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(251373);
          if (f.this.LiG.jTm)
          {
            Log.i("MicroMsg.FullCardAdBackAnimationNew", "holder is busy");
            paramAnonymousAnimator = f.this.IVc.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(251373);
            return;
          }
          f.this.LiG.jTm = true;
          f.this.LiG.Lnh.AZc.setAlpha(0.0F);
          f.this.LiG.Lnh.JKr.setAlpha(0.0F);
          AppMethodBeat.o(251373);
        }
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(208415);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.LiG.Lnh.AZc.setAlpha(f);
          f.this.LiG.Lnh.JKr.setAlpha(f);
          AppMethodBeat.o(208415);
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
          AppMethodBeat.i(196433);
          Log.i("MicroMsg.FullCardAdBackAnimationNew", "onAnimation end");
          f.this.LiG.Lnh.xYJ.setScaleX(1.0F);
          f.this.LiG.Lnh.xYJ.setScaleY(1.0F);
          f.this.LiG.Lnh.xYJ.setAlpha(1.0F);
          f.this.LiG.Lnh.AZc.setAlpha(1.0F);
          f.this.LiG.Lnh.JKr.setAlpha(1.0F);
          if (f.this.Lia != null) {
            f.this.Lia.onAnimationEnd();
          }
          f.this.LiG.jTm = false;
          AppMethodBeat.o(196433);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(196427);
          Log.i("MicroMsg.FullCardAdBackAnimationNew", "onAnimation start");
          AppMethodBeat.o(196427);
        }
      });
      AppMethodBeat.o(220272);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdBackAnimationNew", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(220272);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(220275);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(220275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f
 * JD-Core Version:    0.7.0.1
 */