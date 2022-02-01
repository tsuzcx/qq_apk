package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateBackgroundView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-scan_release"})
public final class ScanSharedMaskView$b
  extends AnimatorListenerAdapter
{
  ScanSharedMaskView$b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(221823);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
      AppMethodBeat.o(221823);
      return;
    }
    AppMethodBeat.o(221823);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(221820);
    if (!this.uYN)
    {
      ScanSharedMaskView.c(this.IYl);
      ScanSharedMaskView.d(this.IYl).setVisibility(8);
    }
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
      AppMethodBeat.o(221820);
      return;
    }
    AppMethodBeat.o(221820);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(221833);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
      AppMethodBeat.o(221833);
      return;
    }
    AppMethodBeat.o(221833);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(221826);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
      AppMethodBeat.o(221826);
      return;
    }
    AppMethodBeat.o(221826);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    AppMethodBeat.i(221835);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
      AppMethodBeat.o(221835);
      return;
    }
    AppMethodBeat.o(221835);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(221829);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.IXz;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
      AppMethodBeat.o(221829);
      return;
    }
    AppMethodBeat.o(221829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.b
 * JD-Core Version:    0.7.0.1
 */