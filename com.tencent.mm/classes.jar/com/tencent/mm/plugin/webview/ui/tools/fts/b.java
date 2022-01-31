package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
{
  public b(Context paramContext, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, final View paramView6, View paramView7, View paramView8, View paramView9)
  {
    super(paramContext, paramView1, paramView2, paramView3, paramView4, paramView5, paramView6, paramView7, paramView8, paramView9);
    AppMethodBeat.i(8581);
    paramView2.getViewTreeObserver().addOnPreDrawListener(new b.1(this, paramView2));
    paramView6.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(8574);
        paramView6.getViewTreeObserver().removeOnPreDrawListener(this);
        b.this.vlx = ((int)paramView6.getX());
        AppMethodBeat.o(8574);
        return true;
      }
    });
    AppMethodBeat.o(8581);
  }
  
  private void dfV()
  {
    AppMethodBeat.i(8585);
    this.vlA.setAlpha(0.0F);
    this.vlz.setPadding(this.vly, 0, 0, 0);
    int i = this.vlv;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.vlz.getLayoutParams();
    localLayoutParams.leftMargin = (this.vlv - i);
    localLayoutParams.rightMargin = (this.vlv - i);
    localLayoutParams.width = (i * 2 + (int)this.vlI[2][0]);
    this.vlz.setLayoutParams(localLayoutParams);
    this.vlz.post(new b.4(this));
    AppMethodBeat.o(8585);
  }
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(8583);
    if (paramb == this.vlJ)
    {
      AppMethodBeat.o(8583);
      return;
    }
    switch (b.6.vlS[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(8583);
      return;
      dfT();
      AppMethodBeat.o(8583);
      return;
      if (paramBoolean)
      {
        dfU();
        AppMethodBeat.o(8583);
        return;
      }
      dfV();
    }
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(8582);
    a(paramb, true);
    AppMethodBeat.o(8582);
  }
  
  protected final void dfT()
  {
    AppMethodBeat.i(8584);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.vlI[0][0] - this.vlw >= 0.0F) {
      localValueAnimator.addUpdateListener(this.vlN);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.vlH, "alpha", new float[] { 0.0F, 1.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.vlA, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          b.this.isAnimating = false;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(8576);
          b.this.isAnimating = false;
          if (b.this.vlK != null) {
            b.this.vlK.onAnimationEnd();
          }
          AppMethodBeat.o(8576);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(8575);
          b.this.isAnimating = true;
          if (b.this.vlK != null) {
            b.this.vlK.onAnimationStart();
          }
          b.this.vlA.setVisibility(0);
          AppMethodBeat.o(8575);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(8584);
      return;
      localValueAnimator.addUpdateListener(this.vlO);
    }
  }
  
  protected final void dfU()
  {
    AppMethodBeat.i(8586);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.vlI[0][0] - this.vlw >= 0.0F) {
      localValueAnimator.addUpdateListener(this.vlL);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.vlH, "alpha", new float[] { 1.0F, 0.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.vlA, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new b.5(this));
      localAnimatorSet.start();
      AppMethodBeat.o(8586);
      return;
      localValueAnimator.addUpdateListener(this.vlM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.b
 * JD-Core Version:    0.7.0.1
 */