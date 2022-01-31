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
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.ui.MMActivity;

public final class c
  extends a
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  AnimatorSet seX;
  ViewGroup seY;
  LinearLayout.LayoutParams seZ;
  LinearLayout.LayoutParams sfa;
  LinearLayout.LayoutParams sfb;
  FrameLayout.LayoutParams sfc;
  int[] sfd;
  a.a sfu;
  
  public c(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40051);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.sfu = ((a.a)paramBaseViewHolder);
    this.seV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seV.addUpdateListener(new c.1(this));
    this.seV.setDuration(400L);
    this.seV.addListener(new c.2(this));
    this.seW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seW.addUpdateListener(new c.3(this));
    this.seW.setDuration(100L);
    this.seW.setStartDelay(300L);
    this.seZ = ((LinearLayout.LayoutParams)this.sfu.shV.getLayoutParams());
    this.sfa = ((LinearLayout.LayoutParams)this.sfu.shW.getLayoutParams());
    this.sfb = ((LinearLayout.LayoutParams)this.sfu.shX.getLayoutParams());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seY = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.seX.addListener(new c.4(this));
    AppMethodBeat.o(40051);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40052);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.c
 * JD-Core Version:    0.7.0.1
 */