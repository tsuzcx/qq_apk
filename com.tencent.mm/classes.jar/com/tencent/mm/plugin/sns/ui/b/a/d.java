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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;

public final class d
  extends b
{
  com.tencent.mm.plugin.sns.ui.c.a.b AsM;
  private ValueAnimator AsN;
  private ValueAnimator AsO;
  ViewGroup AsP;
  LinearLayout.LayoutParams AsQ;
  LinearLayout.LayoutParams AsR;
  LinearLayout.LayoutParams AsS;
  FrameLayout.LayoutParams AsW;
  int[] uCL;
  private AnimatorSet yvH;
  
  public d(final MMActivity paramMMActivity, final a parama)
  {
    AppMethodBeat.i(99910);
    this.uCL = new int[2];
    this.activity = paramMMActivity;
    this.AsM = ((com.tencent.mm.plugin.sns.ui.c.a.b)parama);
    this.AsN = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AsN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99906);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f != 1.0D)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)d.this.AsM.contentView.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(d.this.AsW.leftMargin * f));
          paramAnonymousValueAnimator.rightMargin = ((int)(d.this.AsW.rightMargin * f));
          paramAnonymousValueAnimator.topMargin = ((int)(d.this.AsW.topMargin * f));
          paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.AsW.bottomMargin * f));
          d.this.AsM.contentView.setLayoutParams(paramAnonymousValueAnimator);
          d.this.AsM.AtF.setScaleX(f);
          d.this.AsM.AtF.setScaleY(f);
          d.this.AsM.AtF.setAlpha(f);
        }
        AppMethodBeat.o(99906);
      }
    });
    this.AsN.setDuration(400L);
    this.AsO = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.AsO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99907);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.this.AsM.AtG.setAlpha(f);
        AppMethodBeat.o(99907);
      }
    });
    this.AsO.setDuration(100L);
    this.AsQ = ((LinearLayout.LayoutParams)this.AsM.contentView.getLayoutParams());
    this.AsR = ((LinearLayout.LayoutParams)this.AsM.AtF.getLayoutParams());
    this.AsS = ((LinearLayout.LayoutParams)this.AsM.AtG.getLayoutParams());
    this.yvH = new AnimatorSet();
    this.yvH.playTogether(new Animator[] { this.AsN, this.AsO });
    this.AsP = ((FrameLayout)paramMMActivity.getBodyView().getParent());
    this.yvH.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99909);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.AsM.contentView);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.AsM.AtF);
        ((ViewGroup)paramMMActivity.getBodyView().getParent()).removeView(d.this.AsM.AtG);
        d.this.AsM.AtF.setScaleX(1.0F);
        d.this.AsM.AtF.setScaleY(1.0F);
        d.this.AsM.AtF.setAlpha(1.0F);
        ((ViewGroup)d.this.AsM.AaE).addView(d.this.AsM.contentView, d.this.AsQ);
        ((ViewGroup)d.this.AsM.contentView).addView(d.this.AsM.AtF, d.this.AsR);
        ((ViewGroup)d.this.AsM.contentView).addView(d.this.AsM.AtG, d.this.AsS);
        d.this.AsM.AtG.setAlpha(1.0F);
        if (d.this.AsL != null) {
          d.this.AsL.onAnimationEnd();
        }
        AppMethodBeat.o(99909);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99908);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
        d.this.AsM.contentView.getLocationInWindow(d.this.uCL);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", new Object[] { Integer.valueOf(d.this.uCL[0]), Integer.valueOf(d.this.uCL[1]) });
        d.this.AsW = new FrameLayout.LayoutParams(-2, -2);
        d.this.AsW.leftMargin = d.this.uCL[0];
        d.this.AsW.rightMargin = (d.this.AsP.getWidth() - d.this.AsW.leftMargin - d.this.AsM.contentView.getWidth());
        d.this.AsW.topMargin = (d.this.uCL[1] - al.jG(paramMMActivity));
        d.this.AsW.bottomMargin = (d.this.AsP.getHeight() - d.this.AsW.topMargin - d.this.AsM.contentView.getHeight());
        ad.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", new Object[] { Integer.valueOf(d.this.AsW.leftMargin), Integer.valueOf(d.this.AsW.topMargin), Integer.valueOf(d.this.AsW.rightMargin), Integer.valueOf(d.this.AsW.bottomMargin) });
        Object localObject1 = new int[2];
        d.this.AsM.AtF.getLocationInWindow((int[])localObject1);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
        paramAnonymousAnimator = new FrameLayout.LayoutParams(-2, -2);
        paramAnonymousAnimator.leftMargin = localObject1[0];
        paramAnonymousAnimator.rightMargin = (d.this.AsP.getWidth() - paramAnonymousAnimator.leftMargin - d.this.AsM.AtF.getWidth());
        paramAnonymousAnimator.topMargin = (localObject1[1] - al.jG(paramMMActivity));
        paramAnonymousAnimator.bottomMargin = (d.this.AsP.getHeight() - paramAnonymousAnimator.topMargin - d.this.AsM.AtF.getHeight());
        Object localObject2 = new int[2];
        d.this.AsM.AtG.getLocationInWindow((int[])localObject2);
        ad.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", new Object[] { Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
        localObject1 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = (d.this.AsP.getWidth() - ((FrameLayout.LayoutParams)localObject1).leftMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).AtG.getWidth());
        ((FrameLayout.LayoutParams)localObject1).topMargin = (localObject2[1] - al.jG(paramMMActivity));
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (d.this.AsP.getHeight() - ((FrameLayout.LayoutParams)localObject1).topMargin - ((com.tencent.mm.plugin.sns.ui.c.a.b)parama).AtG.getHeight());
        localObject2 = d.this.AsM.AaE.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = d.this.AsM.contentView.getWidth();
        ((ViewGroup.LayoutParams)localObject2).height = (d.this.AsM.contentView.getHeight() + d.this.AsQ.topMargin + d.this.AsQ.bottomMargin);
        d.this.AsM.AaE.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.AsM.AaE).removeView(d.this.AsM.contentView);
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = d.this.AsW.leftMargin;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = d.this.AsW.rightMargin;
        ((FrameLayout.LayoutParams)localObject2).topMargin = d.this.AsW.topMargin;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.this.AsW.bottomMargin;
        d.this.AsP.addView(d.this.AsM.contentView, (ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)d.this.AsM.contentView).removeView(d.this.AsM.AtF);
        d.this.AsP.addView(d.this.AsM.AtF, paramAnonymousAnimator);
        ((ViewGroup)d.this.AsM.contentView).removeView(d.this.AsM.AtG);
        d.this.AsP.addView(d.this.AsM.AtG, (ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(99908);
      }
    });
    AppMethodBeat.o(99910);
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(99911);
    if (!this.yvH.isStarted())
    {
      this.yvH.setStartDelay(paramLong);
      this.yvH.start();
    }
    AppMethodBeat.o(99911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.d
 * JD-Core Version:    0.7.0.1
 */