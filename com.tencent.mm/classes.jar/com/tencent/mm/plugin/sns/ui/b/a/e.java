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
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  private AnimatorSet seX;
  ViewGroup seY;
  int[] sfd;
  FrameLayout.LayoutParams sfg;
  c sfj;
  LinearLayout.LayoutParams sfk;
  
  public e(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(40026);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.sfj = ((c)parama);
    this.seV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seV.addUpdateListener(new e.1(this));
    this.seV.setDuration(400L);
    this.seW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seW.addUpdateListener(new e.2(this));
    this.seW.setDuration(100L);
    this.seW.setStartDelay(300L);
    this.sfk = ((LinearLayout.LayoutParams)this.sfj.contentView.getLayoutParams());
    this.seY = ((FrameLayout)this.hwZ.getBodyView().getParent());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seX.addListener(new e.3(this, paramMMActivity));
    AppMethodBeat.o(40026);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40027);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e
 * JD-Core Version:    0.7.0.1
 */