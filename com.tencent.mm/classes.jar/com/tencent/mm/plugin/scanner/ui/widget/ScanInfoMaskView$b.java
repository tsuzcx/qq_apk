package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$animateViewAlpha$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-scan_release"})
public final class ScanInfoMaskView$b
  extends AnimatorListenerAdapter
{
  ScanInfoMaskView$b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(218262);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
      AppMethodBeat.o(218262);
      return;
    }
    AppMethodBeat.o(218262);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(218260);
    Object localObject = this.kqJ;
    if (this.uYN) {}
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      localObject = this.IXz;
      if (localObject == null) {
        break;
      }
      ((AnimatorListenerAdapter)localObject).onAnimationEnd(paramAnimator);
      AppMethodBeat.o(218260);
      return;
    }
    AppMethodBeat.o(218260);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(218270);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
      AppMethodBeat.o(218270);
      return;
    }
    AppMethodBeat.o(218270);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(218265);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
      AppMethodBeat.o(218265);
      return;
    }
    AppMethodBeat.o(218265);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    AppMethodBeat.i(218272);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
      AppMethodBeat.o(218272);
      return;
    }
    AppMethodBeat.o(218272);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(218267);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
      AppMethodBeat.o(218267);
      return;
    }
    AppMethodBeat.o(218267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView.b
 * JD-Core Version:    0.7.0.1
 */