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
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends b
{
  com.tencent.mm.plugin.sns.ui.c.a.b seU;
  private ValueAnimator seV;
  private ValueAnimator seW;
  private AnimatorSet seX;
  ViewGroup seY;
  LinearLayout.LayoutParams seZ;
  LinearLayout.LayoutParams sfa;
  LinearLayout.LayoutParams sfb;
  int[] sfd;
  FrameLayout.LayoutParams sfg;
  
  public d(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(40020);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.seU = ((com.tencent.mm.plugin.sns.ui.c.a.b)parama);
    this.seV = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seV.addUpdateListener(new d.1(this));
    this.seV.setDuration(400L);
    this.seW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seW.addUpdateListener(new d.2(this));
    this.seW.setDuration(100L);
    this.seZ = ((LinearLayout.LayoutParams)this.seU.contentView.getLayoutParams());
    this.sfa = ((LinearLayout.LayoutParams)this.seU.sfQ.getLayoutParams());
    this.sfb = ((LinearLayout.LayoutParams)this.seU.sfR.getLayoutParams());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seY = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.seX.addListener(new d.3(this, paramMMActivity, parama));
    AppMethodBeat.o(40020);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40021);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */