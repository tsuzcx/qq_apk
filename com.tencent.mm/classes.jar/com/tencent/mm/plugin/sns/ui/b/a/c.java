package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class c
  extends a
{
  private AnimatorSet Div;
  com.tencent.mm.plugin.sns.ui.c.a.c RIo;
  private int[] bfh;
  
  public c(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(99904);
    this.bfh = new int[2];
    this.activity = paramMMActivity;
    this.RIo = ((com.tencent.mm.plugin.sns.ui.c.a.c)paramb);
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramMMActivity.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99900);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          c.this.RIo.RJk.setScaleX(f);
          c.this.RIo.RJk.setScaleY(f);
          c.this.RIo.RJk.setAlpha(f);
        }
        AppMethodBeat.o(99900);
      }
    });
    paramMMActivity.setDuration(400L);
    paramb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99901);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.RIo.RJl.setAlpha(f);
        AppMethodBeat.o(99901);
      }
    });
    paramb.setDuration(100L);
    paramb.setStartDelay(300L);
    this.Div = new AnimatorSet();
    this.Div.playTogether(new Animator[] { paramMMActivity, paramb });
    this.Div.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99903);
        Log.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
        c.this.RIo.RJk.setScaleX(1.0F);
        c.this.RIo.RJk.setScaleY(1.0F);
        c.this.RIo.RJk.setAlpha(1.0F);
        c.this.RIo.RJl.setAlpha(1.0F);
        if (c.this.RIn != null) {
          c.this.RIn.onAnimationEnd();
        }
        AppMethodBeat.o(99903);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99902);
        Log.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
        c.this.RIo.RJl.setAlpha(0.0F);
        AppMethodBeat.o(99902);
      }
    });
    AppMethodBeat.o(99904);
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(99905);
    if (!this.Div.isStarted())
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(99905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */