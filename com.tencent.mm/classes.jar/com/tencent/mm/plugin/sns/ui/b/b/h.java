package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  AnimatorSet seX;
  h.a sfA;
  
  public h(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(145713);
    try
    {
      this.hwZ = paramMMActivity;
      this.sfA = ((h.a)paramBaseViewHolder);
      this.seV = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.seV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(145708);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            h.this.sfA.rMB.setScaleX(f);
            h.this.sfA.rMB.setScaleY(f);
            h.this.sfA.rMB.setAlpha(f);
          }
          AppMethodBeat.o(145708);
        }
      });
      this.seV.setDuration(400L);
      this.seV.addListener(new h.2(this));
      this.seW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.seW.addUpdateListener(new h.3(this));
      this.seW.setDuration(100L);
      this.seX = new AnimatorSet();
      this.seX.playTogether(new Animator[] { this.seV, this.seW });
      this.seX.addListener(new h.4(this));
      AppMethodBeat.o(145713);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ab.e("MicroMsg.SphereCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(145713);
    }
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(145714);
    if ((this.seX != null) && (!this.seX.isStarted()))
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(145714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h
 * JD-Core Version:    0.7.0.1
 */