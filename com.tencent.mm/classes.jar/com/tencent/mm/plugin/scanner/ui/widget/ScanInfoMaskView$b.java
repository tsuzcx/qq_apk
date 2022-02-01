package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$animateViewAlpha$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanInfoMaskView$b
  extends AnimatorListenerAdapter
{
  ScanInfoMaskView$b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(314712);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(314712);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(314711);
    Object localObject = this.$view;
    if (this.obi) {}
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      localObject = this.Pgh;
      if (localObject != null) {
        ((AnimatorListenerAdapter)localObject).onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(314711);
      return;
    }
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(314721);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
    }
    AppMethodBeat.o(314721);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(314716);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(314716);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    AppMethodBeat.i(314725);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
    }
    AppMethodBeat.o(314725);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(314719);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(314719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView.b
 * JD-Core Version:    0.7.0.1
 */