package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.ui.MMActivity;

public final class i
  extends a
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  private AnimatorSet seX;
  ViewGroup seY;
  int[] sfd;
  FrameLayout.LayoutParams sfg;
  LinearLayout.LayoutParams sfk;
  e sfr;
  
  public i(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(40038);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.sfr = ((e)parama);
    this.seV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seV.addUpdateListener(new i.1(this));
    this.seV.setDuration(400L);
    this.seW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seW.addUpdateListener(new i.2(this));
    this.seW.setDuration(100L);
    this.seW.setStartDelay(300L);
    this.sfk = ((LinearLayout.LayoutParams)this.sfr.contentView.getLayoutParams());
    this.seY = ((FrameLayout)this.hwZ.getBodyView().getParent());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seX.addListener(new i.3(this, paramMMActivity));
    AppMethodBeat.o(40038);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40039);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i
 * JD-Core Version:    0.7.0.1
 */