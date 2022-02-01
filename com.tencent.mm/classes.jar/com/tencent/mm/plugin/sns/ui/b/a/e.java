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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  c zbi;
  
  public e(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99916);
    try
    {
      this.activity = paramMMActivity;
      this.zbi = ((c)parama);
      this.zaW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99912);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.zbi.yGK.setScaleX(f);
            e.this.zbi.yGK.setScaleY(f);
            e.this.zbi.yGK.setAlpha(f);
          }
          AppMethodBeat.o(99912);
        }
      });
      this.zaW.setDuration(400L);
      this.zaW.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179327);
          e.this.zbi.rXY.setAlpha(0.0F);
          e.this.zbi.zbW.setAlpha(0.0F);
          AppMethodBeat.o(179327);
        }
      });
      this.zaX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179328);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          e.this.zbi.rXY.setAlpha(f);
          e.this.zbi.zbW.setAlpha(f);
          AppMethodBeat.o(179328);
        }
      });
      this.zaX.setDuration(100L);
      this.zaX.setStartDelay(300L);
      this.xhG = new AnimatorSet();
      this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
      this.xhG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179330);
          ac.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
          e.this.zbi.yGK.setScaleX(1.0F);
          e.this.zbi.yGK.setScaleY(1.0F);
          e.this.zbi.yGK.setAlpha(1.0F);
          e.this.zbi.rXY.setAlpha(1.0F);
          e.this.zbi.zbW.setAlpha(1.0F);
          if (e.this.zaU != null) {
            e.this.zaU.onAnimationEnd();
          }
          AppMethodBeat.o(179330);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179329);
          ac.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
          AppMethodBeat.o(179329);
        }
      });
      AppMethodBeat.o(99916);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ac.e("MicroMsg.FullCardAdDetailBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99916);
    }
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99917);
    if ((this.xhG != null) && (!this.xhG.isStarted()))
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e
 * JD-Core Version:    0.7.0.1
 */