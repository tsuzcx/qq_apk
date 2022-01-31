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
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  private ValueAnimator seV;
  private ValueAnimator seW;
  private AnimatorSet seX;
  ViewGroup seY;
  int[] sfd;
  FrameLayout.LayoutParams sfg;
  LinearLayout.LayoutParams sfk;
  c sfm;
  
  public f(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(40032);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.sfm = ((c)parama);
    this.seV = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seV.addUpdateListener(new f.1(this));
    this.seV.setDuration(400L);
    this.seW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.seW.addUpdateListener(new f.2(this));
    this.seW.setDuration(100L);
    this.sfk = ((LinearLayout.LayoutParams)this.sfm.contentView.getLayoutParams());
    this.seY = ((FrameLayout)this.hwZ.getBodyView().getParent());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seX.addListener(new f.3(this, paramMMActivity));
    AppMethodBeat.o(40032);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40033);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f
 * JD-Core Version:    0.7.0.1
 */