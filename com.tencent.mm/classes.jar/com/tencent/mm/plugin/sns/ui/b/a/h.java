package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends b
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  private AnimatorSet seX;
  d sfo;
  
  public h(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(145699);
    try
    {
      this.hwZ = paramMMActivity;
      this.sfo = ((d)parama);
      this.seV = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.seV.addUpdateListener(new h.1(this));
      this.seV.setDuration(400L);
      this.seV.addListener(new h.2(this));
      this.seW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.seW.addUpdateListener(new h.3(this));
      this.seW.setDuration(100L);
      this.seX = new AnimatorSet();
      this.seX.playTogether(new Animator[] { this.seV, this.seW });
      this.seX.addListener(new h.4(this));
      AppMethodBeat.o(145699);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ab.e("MicroMsg.SphereCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(145699);
    }
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(145700);
    if ((this.seX != null) && (!this.seX.isStarted()))
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(145700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.h
 * JD-Core Version:    0.7.0.1
 */