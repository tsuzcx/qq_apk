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
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;

public final class i
  extends a
{
  int[] tAc;
  private AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  ViewGroup zaY;
  FrameLayout.LayoutParams zbf;
  e zbo;
  LinearLayout.LayoutParams zbp;
  
  public i(final MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99941);
    this.tAc = new int[2];
    this.activity = paramMMActivity;
    this.zbo = ((e)parama);
    this.zaW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99937);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          i.this.zbo.contentView.setScaleX(f);
          i.this.zbo.contentView.setScaleY(f);
          i.this.zbo.contentView.setAlpha(f);
        }
        AppMethodBeat.o(99937);
      }
    });
    this.zaW.setDuration(400L);
    this.zaX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99938);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        i.this.zbo.zcO.setAlpha(f);
        i.this.zbo.zcN.setAlpha(f);
        AppMethodBeat.o(99938);
      }
    });
    this.zaX.setDuration(100L);
    this.zaX.setStartDelay(300L);
    this.zbp = ((LinearLayout.LayoutParams)this.zbo.contentView.getLayoutParams());
    this.zaY = ((FrameLayout)this.activity.getBodyView().getParent());
    this.xhG = new AnimatorSet();
    this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
    this.xhG.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99940);
        ac.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)i.this.activity.getBodyView().getParent()).removeView(i.this.zbo.contentView);
        ((ViewGroup)i.this.zbo.yJk).addView(i.this.zbo.contentView, i.this.zbp);
        i.this.zbo.contentView.setScaleX(1.0F);
        i.this.zbo.contentView.setScaleY(1.0F);
        i.this.zbo.contentView.setAlpha(1.0F);
        i.this.zbo.zcN.setAlpha(1.0F);
        i.this.zbo.zcO.setAlpha(1.0F);
        if (i.this.zaU != null) {
          i.this.zaU.onAnimationEnd();
        }
        AppMethodBeat.o(99940);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99939);
        ac.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
        i.this.zbo.zcO.setAlpha(0.0F);
        i.this.zbo.zcN.setAlpha(0.0F);
        i.this.zbo.contentView.getLocationInWindow(i.this.tAc);
        ac.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", new Object[] { Integer.valueOf(i.this.tAc[0]), Integer.valueOf(i.this.tAc[1]) });
        ((ViewGroup)i.this.zbo.yJk).removeView(i.this.zbo.contentView);
        paramAnonymousAnimator = i.this.zbo.yJk.getLayoutParams();
        paramAnonymousAnimator.width = i.this.zbo.contentView.getWidth();
        paramAnonymousAnimator.height = (i.this.zbo.contentView.getHeight() + i.this.zbp.topMargin + i.this.zbp.bottomMargin);
        i.this.zbo.yJk.setLayoutParams(paramAnonymousAnimator);
        i.this.zbf = new FrameLayout.LayoutParams(-2, -2);
        i.this.zbf.leftMargin = i.this.tAc[0];
        i.this.zbf.rightMargin = (i.this.zaY.getWidth() - i.this.zbf.leftMargin - i.this.zbo.contentView.getWidth());
        i.this.zbf.topMargin = (i.this.tAc[1] - aj.ji(paramMMActivity));
        i.this.zbf.bottomMargin = (i.this.zaY.getHeight() - i.this.zbf.topMargin - i.this.zbo.contentView.getHeight());
        i.this.zaY.addView(i.this.zbo.contentView, i.this.zbf);
        AppMethodBeat.o(99939);
      }
    });
    AppMethodBeat.o(99941);
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99942);
    if (!this.xhG.isStarted())
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.i
 * JD-Core Version:    0.7.0.1
 */