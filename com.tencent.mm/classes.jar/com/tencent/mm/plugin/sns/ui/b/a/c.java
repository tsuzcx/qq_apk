package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;

public final class c
  extends a
{
  int[] tAc;
  private AnimatorSet xhG;
  b zaV;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  ViewGroup zaY;
  LinearLayout.LayoutParams zaZ;
  LinearLayout.LayoutParams zba;
  LinearLayout.LayoutParams zbb;
  FrameLayout.LayoutParams zbc;
  
  public c(final MMActivity paramMMActivity, final com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    AppMethodBeat.i(99904);
    this.tAc = new int[2];
    this.activity = paramMMActivity;
    this.zaV = ((b)parama);
    this.zaW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99900);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 0.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.zaV.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.zbc.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(c.this.zbc.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.zbc.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(c.this.zbc.bottomMargin * f));
          paramAnonymousValueAnimator.width = (c.this.zaY.getWidth() - paramAnonymousValueAnimator.leftMargin - paramAnonymousValueAnimator.rightMargin);
          paramAnonymousValueAnimator.height = (c.this.zaY.getHeight() - paramAnonymousValueAnimator.topMargin - paramAnonymousValueAnimator.bottomMargin);
          c.this.zaV.contentView.setLayoutParams(paramAnonymousValueAnimator);
          c.this.zaV.contentView.setAlpha(f);
          c.this.zaV.zbO.setScaleX(f);
          c.this.zaV.zbO.setScaleY(f);
          c.this.zaV.zbO.setAlpha(f);
        }
        AppMethodBeat.o(99900);
      }
    });
    this.zaW.setDuration(400L);
    this.zaX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99901);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.zaV.zbP.setAlpha(f);
        AppMethodBeat.o(99901);
      }
    });
    this.zaX.setDuration(100L);
    this.zaX.setStartDelay(300L);
    this.zaZ = ((LinearLayout.LayoutParams)this.zaV.contentView.getLayoutParams());
    this.zba = ((LinearLayout.LayoutParams)this.zaV.zbO.getLayoutParams());
    this.zbb = ((LinearLayout.LayoutParams)this.zaV.zbP.getLayoutParams());
    this.xhG = new AnimatorSet();
    this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
    this.zaY = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.xhG.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99903);
        ac.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.zaV.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.zaV.zbO);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(c.this.zaV.zbP);
        c.this.zaV.zbO.setScaleX(1.0F);
        c.this.zaV.zbO.setScaleY(1.0F);
        c.this.zaV.zbO.setAlpha(1.0F);
        ((ViewGroup)c.this.zaV.yJk).addView(c.this.zaV.contentView, c.this.zaZ);
        ((ViewGroup)c.this.zaV.contentView).addView(c.this.zaV.zbO, c.this.zba);
        ((ViewGroup)c.this.zaV.contentView).addView(c.this.zaV.zbP, c.this.zbb);
        c.this.zaV.contentView.setAlpha(1.0F);
        c.this.zaV.zbP.setAlpha(1.0F);
        if (c.this.zaU != null) {
          c.this.zaU.onAnimationEnd();
        }
        AppMethodBeat.o(99903);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99902);
        ac.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
        c.this.zaV.contentView.getLocationInWindow(c.this.tAc);
        ac.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(c.this.tAc[0]), Integer.valueOf(c.this.tAc[1]) });
        c.this.zbc = new FrameLayout.LayoutParams(-2, -2);
        c.this.zbc.leftMargin = c.this.tAc[0];
        c.this.zbc.rightMargin = (c.this.zaY.getWidth() - c.this.zbc.leftMargin - c.this.zaV.contentView.getWidth());
        c.this.zbc.topMargin = (c.this.tAc[1] - aj.ji(paramMMActivity));
        c.this.zbc.bottomMargin = (c.this.zaY.getHeight() - c.this.zbc.topMargin - c.this.zaV.contentView.getHeight());
        Object localObject1 = new int[2];
        c.this.zaV.zbO.getLocationInWindow((int[])localObject1);
        ac.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (c.this.zaY.getWidth() - paramAnonymousAnimator.leftMargin - c.this.zaV.zbO.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - aj.ji(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (c.this.zaY.getHeight() - paramAnonymousAnimator.topMargin - c.this.zaV.zbO.getHeight());
        Object localObject2 = new int[2];
        c.this.zaV.zbP.getLocationInWindow((int[])localObject2);
        ac.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (c.this.zaY.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((b)parama).zbP.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - aj.ji(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (c.this.zaY.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((b)parama).zbP.getHeight());
        localObject2 = c.this.zaV.yJk.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = c.this.zaV.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (c.this.zaV.contentView.getHeight() + c.this.zaZ.topMargin + c.this.zaZ.bottomMargin);
        c.this.zaV.yJk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        c.this.zaV.zbP.setAlpha(0.0F);
        ((ViewGroup)c.this.zaV.yJk).removeView(c.this.zaV.contentView);
        c.this.zaY.addView(c.this.zaV.contentView, new FrameLayout.LayoutParams(-1, -1));
        ((ViewGroup)c.this.zaV.contentView).removeView(c.this.zaV.zbO);
        c.this.zaY.addView(c.this.zaV.zbO, paramAnonymousAnimator);
        ((ViewGroup)c.this.zaV.contentView).removeView(c.this.zaV.zbP);
        c.this.zaY.addView(c.this.zaV.zbP, (ViewGroup.LayoutParams)localObject1);
        c.this.zaV.zbO.setScaleX(0.0F);
        c.this.zaV.zbO.setScaleY(0.0F);
        c.this.zaV.zbO.setAlpha(0.0F);
        AppMethodBeat.o(99902);
      }
    });
    AppMethodBeat.o(99904);
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99905);
    if (!this.xhG.isStarted())
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */