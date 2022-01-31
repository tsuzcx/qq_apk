package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.ui.MMActivity;

public final class j
  extends b
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  AnimatorSet seX;
  ViewGroup seY;
  j.b sfD;
  int[] sfd;
  FrameLayout.LayoutParams sfg;
  LinearLayout.LayoutParams sfk;
  
  public j(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40086);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.sfD = ((j.b)paramBaseViewHolder);
    this.seV = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seV.addUpdateListener(new j.1(this));
    this.seV.setDuration(400L);
    this.seV.addListener(new j.2(this));
    this.seW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seW.addUpdateListener(new j.3(this));
    this.seW.setDuration(100L);
    this.sfk = ((LinearLayout.LayoutParams)this.sfD.siM.getLayoutParams());
    this.seY = ((FrameLayout)this.hwZ.getBodyView().getParent());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seX.addListener(new j.4(this));
    AppMethodBeat.o(40086);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40087);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j
 * JD-Core Version:    0.7.0.1
 */