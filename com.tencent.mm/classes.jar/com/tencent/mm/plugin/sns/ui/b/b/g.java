package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends a
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  AnimatorSet seX;
  h.a sfA;
  
  public g(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(145706);
    try
    {
      this.hwZ = paramMMActivity;
      this.sfA = ((h.a)paramBaseViewHolder);
      this.seV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.seV.addUpdateListener(new g.1(this));
      this.seV.setDuration(400L);
      this.seV.addListener(new g.2(this));
      this.seW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.seW.addUpdateListener(new g.3(this));
      this.seW.setDuration(100L);
      this.seW.setStartDelay(300L);
      this.seX = new AnimatorSet();
      this.seX.playTogether(new Animator[] { this.seV, this.seW });
      this.seX.addListener(new g.4(this));
      AppMethodBeat.o(145706);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ab.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(145706);
    }
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(145707);
    if ((this.seX != null) && (!this.seX.isStarted()))
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(145707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g
 * JD-Core Version:    0.7.0.1
 */