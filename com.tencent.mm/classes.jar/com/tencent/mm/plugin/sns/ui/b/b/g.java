package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.g.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends b
{
  AnimatorSet IVc;
  g.a LiE;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  
  public g(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99975);
    try
    {
      this.activity = paramMMActivity;
      this.LiE = ((g.a)paramBaseViewHolder);
      this.Lif = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99970);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            g.this.LiE.xYJ.setScaleX(f);
            g.this.LiE.xYJ.setScaleY(f);
            g.this.LiE.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(99970);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99971);
          if (g.this.LiE.jTm)
          {
            Log.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = g.this;
            if (paramAnonymousAnimator.IVc != null) {
              paramAnonymousAnimator.IVc.end();
            }
            AppMethodBeat.o(99971);
            return;
          }
          g.this.LiE.jTm = true;
          AppMethodBeat.o(99971);
        }
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99972);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.LiE.AZc.setAlpha(f);
          g.this.LiE.JKr.setAlpha(f);
          AppMethodBeat.o(99972);
        }
      });
      this.Lig.setDuration(100L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99974);
          Log.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
          g.this.LiE.xYJ.setScaleX(1.0F);
          g.this.LiE.xYJ.setScaleY(1.0F);
          g.this.LiE.xYJ.setAlpha(1.0F);
          g.this.LiE.AZc.setAlpha(1.0F);
          g.this.LiE.JKr.setAlpha(1.0F);
          if (g.this.Lia != null) {
            g.this.Lia.onAnimationEnd();
          }
          g.this.LiE.jTm = false;
          if (g.this.LiE.JKG.KKl.getVisibility() == 0)
          {
            g.this.LiE.JKG.KKl.bc(0, false);
            Log.i("MicroMsg.FullCardAdClickAnimation", "seek newVideoView to 0");
          }
          AppMethodBeat.o(99974);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99973);
          Log.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99973);
        }
      });
      AppMethodBeat.o(99975);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99975);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(99976);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(99976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g
 * JD-Core Version:    0.7.0.1
 */