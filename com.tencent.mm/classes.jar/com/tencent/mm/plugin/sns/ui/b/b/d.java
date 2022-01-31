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

public final class d
  extends b
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  AnimatorSet seX;
  ViewGroup seY;
  LinearLayout.LayoutParams seZ;
  LinearLayout.LayoutParams sfa;
  LinearLayout.LayoutParams sfb;
  int[] sfd;
  FrameLayout.LayoutParams sfg;
  a.a sfu;
  
  public d(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40058);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.sfu = ((a.a)paramBaseViewHolder);
    this.seV = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seV.addUpdateListener(new d.1(this));
    this.seV.setDuration(400L);
    this.seV.addListener(new d.2(this));
    this.seW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seW.addUpdateListener(new d.3(this));
    this.seW.setDuration(100L);
    this.seZ = ((LinearLayout.LayoutParams)this.sfu.shV.getLayoutParams());
    this.sfa = ((LinearLayout.LayoutParams)this.sfu.shW.getLayoutParams());
    this.sfb = ((LinearLayout.LayoutParams)this.sfu.shX.getLayoutParams());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seY = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.seX.addListener(new d.4(this));
    AppMethodBeat.o(40058);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40059);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d
 * JD-Core Version:    0.7.0.1
 */