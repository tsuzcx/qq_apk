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

public final class f
  extends b
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  AnimatorSet seX;
  ViewGroup seY;
  int[] sfd;
  FrameLayout.LayoutParams sfg;
  LinearLayout.LayoutParams sfk;
  c.a sfx;
  
  public f(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40072);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.sfx = ((c.a)paramBaseViewHolder);
    this.seV = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seV.addUpdateListener(new f.1(this));
    this.seV.setDuration(400L);
    this.seV.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40068);
        if (f.this.sfx.ezJ)
        {
          ab.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
          f.this.seX.end();
          AppMethodBeat.o(40068);
          return;
        }
        f.this.sfx.ezJ = true;
        f.this.sfx.rMB.getLocationInWindow(f.this.sfd);
        ab.i("MicroMsg.FullCardAdClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(f.this.sfd[0]), Integer.valueOf(f.this.sfd[1]) });
        f.this.sfx.sgS.removeView(f.this.sfx.rMB);
        paramAnonymousAnimator = f.this.sfx.sgS.getLayoutParams();
        paramAnonymousAnimator.width = f.this.sfx.rMB.getWidth();
        paramAnonymousAnimator.height = (f.this.sfx.rMB.getHeight() + f.this.sfk.topMargin + f.this.sfk.bottomMargin);
        f.this.sfx.sgS.setLayoutParams(paramAnonymousAnimator);
        f.this.sfg = new FrameLayout.LayoutParams(-2, -2);
        f.this.sfg.leftMargin = f.this.sfd[0];
        f.this.sfg.rightMargin = (f.this.seY.getWidth() - f.this.sfg.leftMargin - f.this.sfx.rMB.getWidth());
        f.this.sfg.topMargin = f.this.sfd[1];
        f.this.sfg.bottomMargin = (f.this.seY.getHeight() - f.this.sfg.topMargin - f.this.sfx.rMB.getHeight());
        f.this.seY.addView(f.this.sfx.rMB, f.this.sfg);
        AppMethodBeat.o(40068);
      }
    });
    this.seW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seW.addUpdateListener(new f.3(this));
    this.seW.setDuration(100L);
    this.sfk = ((LinearLayout.LayoutParams)this.sfx.rMB.getLayoutParams());
    this.seY = ((FrameLayout)this.hwZ.getBodyView().getParent());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seX.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40071);
        ab.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
        ((ViewGroup)f.this.sfx.rMB.getParent()).removeView(f.this.sfx.rMB);
        f.this.sfx.sgS.addView(f.this.sfx.rMB, f.this.sfk);
        f.this.sfx.rMB.setScaleX(1.0F);
        f.this.sfx.rMB.setScaleY(1.0F);
        f.this.sfx.rMB.setAlpha(1.0F);
        f.this.sfx.sfT.setAlpha(1.0F);
        f.this.sfx.sfU.setAlpha(1.0F);
        if (f.this.seT != null) {
          f.this.seT.onAnimationEnd();
        }
        f.this.sfx.ezJ = false;
        AppMethodBeat.o(40071);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40070);
        ab.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
        AppMethodBeat.o(40070);
      }
    });
    AppMethodBeat.o(40072);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40073);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f
 * JD-Core Version:    0.7.0.1
 */