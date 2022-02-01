package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  c AsZ;
  private AnimatorSet yvH;
  
  public e(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99916);
    try
    {
      this.activity = paramMMActivity;
      this.AsZ = ((c)parama);
      this.AsN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99912);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.AsZ.zYc.setScaleX(f);
            e.this.AsZ.zYc.setScaleY(f);
            e.this.AsZ.zYc.setAlpha(f);
          }
          AppMethodBeat.o(99912);
        }
      });
      this.AsN.setDuration(400L);
      this.AsN.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179327);
          e.this.AsZ.sUS.setAlpha(0.0F);
          e.this.AsZ.AtN.setAlpha(0.0F);
          AppMethodBeat.o(179327);
        }
      });
      this.AsO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179328);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.AsZ.sUS.setAlpha(f);
          e.this.AsZ.AtN.setAlpha(f);
          AppMethodBeat.o(179328);
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
          AppMethodBeat.i(179330);
          ad.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
          e.this.AsZ.zYc.setScaleX(1.0F);
          e.this.AsZ.zYc.setScaleY(1.0F);
          e.this.AsZ.zYc.setAlpha(1.0F);
          e.this.AsZ.sUS.setAlpha(1.0F);
          e.this.AsZ.AtN.setAlpha(1.0F);
          if (e.this.AsL != null) {
            e.this.AsL.onAnimationEnd();
          }
          AppMethodBeat.o(179330);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179329);
          ad.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(179329);
        }
      });
      AppMethodBeat.o(99916);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ad.e("MicroMsg.FullCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99916);
    }
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99917);
    if ((this.yvH != null) && (!this.yvH.isStarted()))
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e
 * JD-Core Version:    0.7.0.1
 */