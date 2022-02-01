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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public final class d
  extends b
{
  private AnimatorSet CPA;
  com.tencent.mm.plugin.sns.ui.c.a.b ETZ;
  private ValueAnimator EUa;
  private ValueAnimator EUb;
  ViewGroup EUc;
  LinearLayout.LayoutParams EUd;
  LinearLayout.LayoutParams EUe;
  LinearLayout.LayoutParams EUf;
  FrameLayout.LayoutParams EUj;
  int[] wrA;
  
  public d(final MMActivity paramMMActivity, final a parama)
  {
    AppMethodBeat.i(99910);
    this.wrA = new int[2];
    this.activity = paramMMActivity;
    this.ETZ = ((com.tencent.mm.plugin.sns.ui.c.a.b)parama);
    this.EUa = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99906);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)d.this.ETZ.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(d.this.EUj.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(d.this.EUj.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(d.this.EUj.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.EUj.bottomMargin * f));
          d.this.ETZ.contentView.setLayoutParams(paramAnonymousValueAnimator);
          d.this.ETZ.EUV.setScaleX(f);
          d.this.ETZ.EUV.setScaleY(f);
          d.this.ETZ.EUV.setAlpha(f);
        }
        AppMethodBeat.o(99906);
      }
    });
    this.EUa.setDuration(400L);
    this.EUb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99907);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.ETZ.EUW.setAlpha(f);
        AppMethodBeat.o(99907);
      }
    });
    this.EUb.setDuration(100L);
    this.EUd = ((LinearLayout.LayoutParams)this.ETZ.contentView.getLayoutParams());
    this.EUe = ((LinearLayout.LayoutParams)this.ETZ.EUV.getLayoutParams());
    this.EUf = ((LinearLayout.LayoutParams)this.ETZ.EUW.getLayoutParams());
    this.CPA = new AnimatorSet();
    this.CPA.playTogether(new Animator[] { this.EUa, this.EUb });
    this.EUc = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.CPA.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99909);
        Log.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.ETZ.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.ETZ.EUV);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.ETZ.EUW);
        d.this.ETZ.EUV.setScaleX(1.0F);
        d.this.ETZ.EUV.setScaleY(1.0F);
        d.this.ETZ.EUV.setAlpha(1.0F);
        ((ViewGroup)d.this.ETZ.EAV).addView(d.this.ETZ.contentView, d.this.EUd);
        ((ViewGroup)d.this.ETZ.contentView).addView(d.this.ETZ.EUV, d.this.EUe);
        ((ViewGroup)d.this.ETZ.contentView).addView(d.this.ETZ.EUW, d.this.EUf);
        d.this.ETZ.EUW.setAlpha(1.0F);
        if (d.this.ETY != null) {
          d.this.ETY.onAnimationEnd();
        }
        AppMethodBeat.o(99909);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99908);
        Log.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
        d.this.ETZ.contentView.getLocationInWindow(d.this.wrA);
        Log.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(d.this.wrA[0]), Integer.valueOf(d.this.wrA[1]) });
        d.this.EUj = new FrameLayout.LayoutParams(-2, -2);
        d.this.EUj.leftMargin = d.this.wrA[0];
        d.this.EUj.rightMargin = (d.this.EUc.getWidth() - d.this.EUj.leftMargin - d.this.ETZ.contentView.getWidth());
        d.this.EUj.topMargin = (d.this.wrA[1] - ao.getStatusBarHeight(paramMMActivity));
        d.this.EUj.bottomMargin = (d.this.EUc.getHeight() - d.this.EUj.topMargin - d.this.ETZ.contentView.getHeight());
        Log.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", new Object[] { Integer.valueOf(d.this.EUj.leftMargin), Integer.valueOf(d.this.EUj.topMargin), Integer.valueOf(d.this.EUj.rightMargin), Integer.valueOf(d.this.EUj.bottomMargin) });
        Object localObject1 = new int[2];
        d.this.ETZ.EUV.getLocationInWindow((int[])localObject1);
        Log.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (d.this.EUc.getWidth() - paramAnonymousAnimator.leftMargin - d.this.ETZ.EUV.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - ao.getStatusBarHeight(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (d.this.EUc.getHeight() - paramAnonymousAnimator.topMargin - d.this.ETZ.EUV.getHeight());
        Object localObject2 = new int[2];
        d.this.ETZ.EUW.getLocationInWindow((int[])localObject2);
        Log.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (d.this.EUc.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).EUW.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - ao.getStatusBarHeight(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (d.this.EUc.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).EUW.getHeight());
        localObject2 = d.this.ETZ.EAV.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = d.this.ETZ.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (d.this.ETZ.contentView.getHeight() + d.this.EUd.topMargin + d.this.EUd.bottomMargin);
        d.this.ETZ.EAV.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.ETZ.EAV).removeView(d.this.ETZ.contentView);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = d.this.EUj.leftMargin;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = d.this.EUj.rightMargin;
        ((FrameLayout.LayoutParams)localObject2).topMargin = d.this.EUj.topMargin;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.this.EUj.bottomMargin;
        d.this.EUc.addView(d.this.ETZ.contentView, (ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.ETZ.contentView).removeView(d.this.ETZ.EUV);
        d.this.EUc.addView(d.this.ETZ.EUV, paramAnonymousAnimator);
        ((ViewGroup)d.this.ETZ.contentView).removeView(d.this.ETZ.EUW);
        d.this.EUc.addView(d.this.ETZ.EUW, (ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(99908);
      }
    });
    AppMethodBeat.o(99910);
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(99911);
    if (!this.CPA.isStarted())
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
    }
    AppMethodBeat.o(99911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */