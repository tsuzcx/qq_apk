package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.ui.MMActivity;

public final class c
  extends a
{
  b seU;
  private ValueAnimator seV;
  private ValueAnimator seW;
  private AnimatorSet seX;
  ViewGroup seY;
  LinearLayout.LayoutParams seZ;
  LinearLayout.LayoutParams sfa;
  LinearLayout.LayoutParams sfb;
  FrameLayout.LayoutParams sfc;
  int[] sfd;
  
  public c(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(40014);
    this.sfd = new int[2];
    this.hwZ = paramMMActivity;
    this.seU = ((b)parama);
    this.seV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(40010);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.seU.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.sfc.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.sfc.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.sfc.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.sfc.bottomMargin * f));
          paramAnonymousValueAnimator.width = (c.this.seY.getWidth() - paramAnonymousValueAnimator.leftMargin - paramAnonymousValueAnimator.rightMargin);
          paramAnonymousValueAnimator.height = (c.this.seY.getHeight() - paramAnonymousValueAnimator.topMargin - paramAnonymousValueAnimator.bottomMargin);
          c.this.seU.contentView.setLayoutParams(paramAnonymousValueAnimator);
          c.this.seU.contentView.setAlpha(f);
          c.this.seU.sfQ.setScaleX(f);
          c.this.seU.sfQ.setScaleY(f);
          c.this.seU.sfQ.setAlpha(f);
        }
        AppMethodBeat.o(40010);
      }
    });
    this.seV.setDuration(400L);
    this.seW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.seW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(40011);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.seU.sfR.setAlpha(f);
        AppMethodBeat.o(40011);
      }
    });
    this.seW.setDuration(100L);
    this.seW.setStartDelay(300L);
    this.seZ = ((LinearLayout.LayoutParams)this.seU.contentView.getLayoutParams());
    this.sfa = ((LinearLayout.LayoutParams)this.seU.sfQ.getLayoutParams());
    this.sfb = ((LinearLayout.LayoutParams)this.seU.sfR.getLayoutParams());
    this.seX = new AnimatorSet();
    this.seX.playTogether(new Animator[] { this.seV, this.seW });
    this.seY = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.seX.addListener(new c.3(this, paramMMActivity, parama));
    AppMethodBeat.o(40014);
  }
  
  public final void mi(long paramLong)
  {
    AppMethodBeat.i(40015);
    if (!this.seX.isStarted())
    {
      this.seX.setStartDelay(paramLong);
      this.seX.start();
    }
    AppMethodBeat.o(40015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */