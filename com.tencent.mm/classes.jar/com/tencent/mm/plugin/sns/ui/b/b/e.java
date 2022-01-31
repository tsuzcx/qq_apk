package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  AnimatorSet seX;
  ViewGroup seY;
  int[] sfd;
  FrameLayout.LayoutParams sfg;
  LinearLayout.LayoutParams sfk;
  c.a sfx;
  
  public e(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40065);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.sfx = ((c.a)paramBaseViewHolder);
    this.seV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seV.addUpdateListener(new e.1(this));
    this.seV.setDuration(400L);
    this.seV.addListener(new e.2(this));
    this.seW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seW.addUpdateListener(new e.3(this));
    this.seW.setDuration(100L);
    this.seW.setStartDelay(300L);
    this.sfk = ((LinearLayout.LayoutParams)this.sfx.rMB.getLayoutParams());
    this.seY = ((FrameLayout)this.hwZ.getBodyView().getParent());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seX.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40064);
        ab.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
        ((ViewGroup)e.this.sfx.rMB.getParent()).removeView(e.this.sfx.rMB);
        e.this.sfx.sgS.addView(e.this.sfx.rMB, e.this.sfk);
        e.this.sfx.rMB.setScaleX(1.0F);
        e.this.sfx.rMB.setScaleY(1.0F);
        e.this.sfx.rMB.setAlpha(1.0F);
        e.this.sfx.sfT.setAlpha(1.0F);
        e.this.sfx.sfU.setAlpha(1.0F);
        if (e.this.seT != null) {
          e.this.seT.onAnimationEnd();
        }
        e.this.sfx.ezJ = false;
        AppMethodBeat.o(40064);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40063);
        ab.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
        AppMethodBeat.o(40063);
      }
    });
    AppMethodBeat.o(40065);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40066);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.e
 * JD-Core Version:    0.7.0.1
 */