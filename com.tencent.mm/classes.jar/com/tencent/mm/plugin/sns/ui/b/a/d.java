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
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;

public final class d
  extends b
{
  int[] tAc;
  private AnimatorSet xhG;
  com.tencent.mm.plugin.sns.ui.c.a.b zaV;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  ViewGroup zaY;
  LinearLayout.LayoutParams zaZ;
  LinearLayout.LayoutParams zba;
  LinearLayout.LayoutParams zbb;
  FrameLayout.LayoutParams zbf;
  
  public d(final MMActivity paramMMActivity, final a parama)
  {
    AppMethodBeat.i(99910);
    this.tAc = new int[2];
    this.activity = paramMMActivity;
    this.zaV = ((com.tencent.mm.plugin.sns.ui.c.a.b)parama);
    this.zaW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99906);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)d.this.zaV.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(d.this.zbf.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(d.this.zbf.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(d.this.zbf.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.zbf.bottomMargin * f));
          d.this.zaV.contentView.setLayoutParams(paramAnonymousValueAnimator);
          d.this.zaV.zbO.setScaleX(f);
          d.this.zaV.zbO.setScaleY(f);
          d.this.zaV.zbO.setAlpha(f);
        }
        AppMethodBeat.o(99906);
      }
    });
    this.zaW.setDuration(400L);
    this.zaX = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99907);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.zaV.zbP.setAlpha(f);
        AppMethodBeat.o(99907);
      }
    });
    this.zaX.setDuration(100L);
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
        AppMethodBeat.i(99909);
        ac.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.zaV.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.zaV.zbO);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.zaV.zbP);
        d.this.zaV.zbO.setScaleX(1.0F);
        d.this.zaV.zbO.setScaleY(1.0F);
        d.this.zaV.zbO.setAlpha(1.0F);
        ((ViewGroup)d.this.zaV.yJk).addView(d.this.zaV.contentView, d.this.zaZ);
        ((ViewGroup)d.this.zaV.contentView).addView(d.this.zaV.zbO, d.this.zba);
        ((ViewGroup)d.this.zaV.contentView).addView(d.this.zaV.zbP, d.this.zbb);
        d.this.zaV.zbP.setAlpha(1.0F);
        if (d.this.zaU != null) {
          d.this.zaU.onAnimationEnd();
        }
        AppMethodBeat.o(99909);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99908);
        ac.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
        d.this.zaV.contentView.getLocationInWindow(d.this.tAc);
        ac.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(d.this.tAc[0]), Integer.valueOf(d.this.tAc[1]) });
        d.this.zbf = new FrameLayout.LayoutParams(-2, -2);
        d.this.zbf.leftMargin = d.this.tAc[0];
        d.this.zbf.rightMargin = (d.this.zaY.getWidth() - d.this.zbf.leftMargin - d.this.zaV.contentView.getWidth());
        d.this.zbf.topMargin = (d.this.tAc[1] - aj.ji(paramMMActivity));
        d.this.zbf.bottomMargin = (d.this.zaY.getHeight() - d.this.zbf.topMargin - d.this.zaV.contentView.getHeight());
        ac.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", new Object[] { Integer.valueOf(d.this.zbf.leftMargin), Integer.valueOf(d.this.zbf.topMargin), Integer.valueOf(d.this.zbf.rightMargin), Integer.valueOf(d.this.zbf.bottomMargin) });
        Object localObject1 = new int[2];
        d.this.zaV.zbO.getLocationInWindow((int[])localObject1);
        ac.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (d.this.zaY.getWidth() - paramAnonymousAnimator.leftMargin - d.this.zaV.zbO.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - aj.ji(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (d.this.zaY.getHeight() - paramAnonymousAnimator.topMargin - d.this.zaV.zbO.getHeight());
        Object localObject2 = new int[2];
        d.this.zaV.zbP.getLocationInWindow((int[])localObject2);
        ac.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (d.this.zaY.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).zbP.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - aj.ji(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (d.this.zaY.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).zbP.getHeight());
        localObject2 = d.this.zaV.yJk.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = d.this.zaV.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (d.this.zaV.contentView.getHeight() + d.this.zaZ.topMargin + d.this.zaZ.bottomMargin);
        d.this.zaV.yJk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.zaV.yJk).removeView(d.this.zaV.contentView);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = d.this.zbf.leftMargin;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = d.this.zbf.rightMargin;
        ((FrameLayout.LayoutParams)localObject2).topMargin = d.this.zbf.topMargin;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.this.zbf.bottomMargin;
        d.this.zaY.addView(d.this.zaV.contentView, (ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.zaV.contentView).removeView(d.this.zaV.zbO);
        d.this.zaY.addView(d.this.zaV.zbO, paramAnonymousAnimator);
        ((ViewGroup)d.this.zaV.contentView).removeView(d.this.zaV.zbP);
        d.this.zaY.addView(d.this.zaV.zbP, (ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(99908);
      }
    });
    AppMethodBeat.o(99910);
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99911);
    if (!this.xhG.isStarted())
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */