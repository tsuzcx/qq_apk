package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateBackgroundView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-scan_release"})
public final class ScanSharedMaskView$b
  extends AnimatorListenerAdapter
{
  ScanSharedMaskView$b(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(240675);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.CSh;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
      AppMethodBeat.o(240675);
      return;
    }
    AppMethodBeat.o(240675);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(240674);
    if (!this.rti)
    {
      ScanSharedMaskView.c(this.CST);
      ScanSharedMaskView.d(this.CST).setVisibility(8);
    }
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.CSh;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationEnd(paramAnimator);
      AppMethodBeat.o(240674);
      return;
    }
    AppMethodBeat.o(240674);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(240678);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.CSh;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
      AppMethodBeat.o(240678);
      return;
    }
    AppMethodBeat.o(240678);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(240676);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.CSh;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
      AppMethodBeat.o(240676);
      return;
    }
    AppMethodBeat.o(240676);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    AppMethodBeat.i(240679);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.CSh;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
      AppMethodBeat.o(240679);
      return;
    }
    AppMethodBeat.o(240679);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(240677);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.CSh;
    if (localAnimatorListenerAdapter != null)
    {
      localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
      AppMethodBeat.o(240677);
      return;
    }
    AppMethodBeat.o(240677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.b
 * JD-Core Version:    0.7.0.1
 */