package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class d
  extends a
{
  public d(Context paramContext, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8, View paramView9, View paramView10)
  {
    super(paramContext, paramView1, paramView2, paramView3, paramView4, paramView5, paramView6, paramView7, paramView8, paramView9, paramView10);
  }
  
  protected final void iAG()
  {
    AppMethodBeat.i(80764);
    Log.i("MicroMsg.WebSearch.SosAnimatorController", "search to init");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.XeE[0][0] - this.Xes >= 0.0F) {
      localValueAnimator.addUpdateListener(this.XeK);
    }
    for (;;)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          d.this.isAnimating = false;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80761);
          d.this.isAnimating = false;
          if (d.this.XeH != null) {
            d.this.XeH.onAnimationEnd();
          }
          AppMethodBeat.o(80761);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80760);
          d.this.isAnimating = true;
          if (d.this.XeH != null) {
            d.this.XeH.onAnimationStart();
          }
          AppMethodBeat.o(80760);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80764);
      return;
      localValueAnimator.addUpdateListener(this.XeL);
    }
  }
  
  protected final void iAH()
  {
    AppMethodBeat.i(80765);
    Log.i("MicroMsg.WebSearch.SosAnimatorController", "init to search");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.XeE[0][0] - this.Xes >= 0.0F) {
      localValueAnimator.addUpdateListener(this.XeI);
    }
    for (;;)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          d.this.isAnimating = false;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80763);
          d.this.isAnimating = false;
          if (d.this.XeH != null) {
            d.this.XeH.onAnimationEnd();
          }
          AppMethodBeat.o(80763);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(80762);
          d.this.isAnimating = true;
          if (d.this.XeH != null) {
            d.this.XeH.onAnimationStart();
          }
          AppMethodBeat.o(80762);
        }
      });
      localAnimatorSet.start();
      AppMethodBeat.o(80765);
      return;
      localValueAnimator.addUpdateListener(this.XeJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.d
 * JD-Core Version:    0.7.0.1
 */