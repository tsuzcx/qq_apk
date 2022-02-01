package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;

public final class j
  extends b
{
  int[] tAc;
  private AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  ViewGroup zaY;
  FrameLayout.LayoutParams zbf;
  e zbo;
  LinearLayout.LayoutParams zbp;
  
  public j(final MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99947);
    this.tAc = new int[2];
    this.activity = paramMMActivity;
    this.zbo = ((e)parama);
    this.zaW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99943);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          j.this.zbo.contentView.setScaleX(f);
          j.this.zbo.contentView.setScaleY(f);
          j.this.zbo.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99943);
      }
    });
    this.zaW.setDuration(400L);
    this.zaX = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99944);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        j.this.zbo.zcO.setAlpha(f);
        j.this.zbo.zcN.setAlpha(f);
        AppMethodBeat.o(99944);
      }
    });
    this.zaX.setDuration(100L);
    this.zbp = ((LinearLayout.LayoutParams)this.zbo.contentView.getLayoutParams());
    this.zaY = ((FrameLayout)this.activity.getBodyView().getParent());
    this.xhG = new AnimatorSet();
    this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
    this.xhG.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99946);
        ac.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)j.this.activity.getBodyView().getParent()).removeView(j.this.zbo.contentView);
        ((ViewGroup)j.this.zbo.yJk).addView(j.this.zbo.contentView, j.this.zbp);
        j.this.zbo.contentView.setScaleX(1.0F);
        j.this.zbo.contentView.setScaleY(1.0F);
        j.this.zbo.contentView.setAlpha(1.0F);
        j.this.zbo.zcO.setAlpha(1.0F);
        j.this.zbo.zcN.setAlpha(1.0F);
        if (j.this.zaU != null) {
          j.this.zaU.onAnimationEnd();
        }
        AppMethodBeat.o(99946);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99945);
        ac.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
        j.this.zbo.contentView.getLocationInWindow(j.this.tAc);
        ac.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(j.this.tAc[0]), Integer.valueOf(j.this.tAc[1]) });
        ((ViewGroup)j.this.zbo.yJk).removeView(j.this.zbo.contentView);
        paramAnonymousAnimator = j.this.zbo.yJk.getLayoutParams();
        paramAnonymousAnimator.width = j.this.zbo.contentView.getWidth();
        paramAnonymousAnimator.height = (j.this.zbo.contentView.getHeight() + j.this.zbp.topMargin + j.this.zbp.bottomMargin);
        j.this.zbo.yJk.setLayoutParams(paramAnonymousAnimator);
        j.this.zbf = new FrameLayout.LayoutParams(-2, -2);
        j.this.zbf.leftMargin = j.this.tAc[0];
        j.this.zbf.rightMargin = (j.this.zaY.getWidth() - j.this.zbf.leftMargin - j.this.zbo.contentView.getWidth());
        j.this.zbf.topMargin = (j.this.tAc[1] - aj.ji(paramMMActivity));
        j.this.zbf.bottomMargin = (j.this.zaY.getHeight() - j.this.zbf.topMargin - j.this.zbo.contentView.getHeight());
        j.this.zaY.addView(j.this.zbo.contentView, j.this.zbf);
        AppMethodBeat.o(99945);
      }
    });
    AppMethodBeat.o(99947);
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99948);
    if (!this.xhG.isStarted())
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.j
 * JD-Core Version:    0.7.0.1
 */