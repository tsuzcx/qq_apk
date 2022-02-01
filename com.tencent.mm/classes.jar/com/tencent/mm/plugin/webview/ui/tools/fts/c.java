package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends a
{
  public c(Context paramContext, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8, View paramView9, View paramView10)
  {
    super(paramContext, paramView1, paramView2, paramView3, paramView4, paramView5, paramView6, paramView7, paramView8, paramView9, paramView10);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(80757);
    if (paramb != this.XeG) {
      switch (c.3.XeQ[paramb.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(80757);
      return;
      iAG();
      AppMethodBeat.o(80757);
      return;
      iAH();
    }
  }
  
  protected final void iAG()
  {
    AppMethodBeat.i(80758);
    Log.i("MicroMsg.WebSearch.SosAnimatorController", "searchToInit");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.XeE[0][0] - this.Xes >= 0.0F) {
      localValueAnimator.addUpdateListener(this.XeK);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.XeB, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator });
      localAnimatorSet.setInterpolator(new DecelerateInterpolator());
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          c.this.isAnimating = false;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80753);
          c.this.isAnimating = false;
          if (c.this.XeH != null) {
            c.this.XeH.onAnimationEnd();
          }
          AppMethodBeat.o(80753);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80752);
          c.this.isAnimating = true;
          if (c.this.XeH != null) {
            c.this.XeH.onAnimationStart();
          }
          AppMethodBeat.o(80752);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80758);
      return;
      localValueAnimator.addUpdateListener(this.XeL);
    }
  }
  
  protected final void iAH()
  {
    AppMethodBeat.i(80759);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.XeE[0][0] - this.Xes >= 0.0F) {
      localValueAnimator.addUpdateListener(this.XeI);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.XeB, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator });
      localAnimatorSet.setInterpolator(new DecelerateInterpolator());
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          c.this.isAnimating = false;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80755);
          c.this.isAnimating = false;
          if (c.this.XeH != null) {
            c.this.XeH.onAnimationEnd();
          }
          AppMethodBeat.o(80755);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80754);
          c.this.isAnimating = true;
          if (c.this.XeH != null) {
            c.this.XeH.onAnimationStart();
          }
          AppMethodBeat.o(80754);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80759);
      return;
      localValueAnimator.addUpdateListener(this.XeJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.c
 * JD-Core Version:    0.7.0.1
 */