package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  private AnimatorSet IVc;
  private ValueAnimator Lif;
  private ValueAnimator Lig;
  e Lii;
  
  public h(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(249420);
    try
    {
      this.activity = paramMMActivity;
      this.Lii = ((e)paramb);
      this.Lif = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(264655);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.Lii.LjM.xYJ.setScaleX(f);
            h.this.Lii.LjM.xYJ.setScaleY(f);
            h.this.Lii.LjM.xYJ.setAlpha(f);
          }
          AppMethodBeat.o(264655);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.Lig = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(204675);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          h.this.Lii.LjM.AZc.setAlpha(f);
          h.this.Lii.LjM.JKr.setAlpha(f);
          AppMethodBeat.o(204675);
        }
      });
      this.Lig.setDuration(100L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif, this.Lig });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(265543);
          Log.i("MicroMsg.FullCardAdDetailClickAnimationNew", "onAnimation end");
          h.this.Lii.LjM.xYJ.setScaleX(1.0F);
          h.this.Lii.LjM.xYJ.setScaleY(1.0F);
          h.this.Lii.LjM.xYJ.setAlpha(1.0F);
          h.this.Lii.LjM.AZc.setAlpha(1.0F);
          h.this.Lii.LjM.JKr.setAlpha(1.0F);
          if (h.this.Lia != null) {
            h.this.Lia.onAnimationEnd();
          }
          if (h.this.Lii.LjO)
          {
            if (h.this.Lii.LjM.JKM != null)
            {
              h.this.Lii.LjM.JKM.bc(0, false);
              AppMethodBeat.o(265543);
            }
          }
          else if (h.this.Lii.LjM.JKG.KKl.getVisibility() == 0)
          {
            h.this.Lii.LjM.JKG.KKl.bc(0, false);
            Log.i("MicroMsg.FullCardAdDetailClickAnimationNew", "seek newVideoView to 0");
          }
          AppMethodBeat.o(265543);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(265542);
          Log.i("MicroMsg.FullCardAdDetailClickAnimationNew", "onAnimation start");
          AppMethodBeat.o(265542);
        }
      });
      AppMethodBeat.o(249420);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdDetailClickAnimationNew", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(249420);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(249421);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(249421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h
 * JD-Core Version:    0.7.0.1
 */