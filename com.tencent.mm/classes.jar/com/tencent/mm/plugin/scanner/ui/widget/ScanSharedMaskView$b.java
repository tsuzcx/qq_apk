package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateBackgroundView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanSharedMaskView$b
  extends AnimatorListenerAdapter
{
  ScanSharedMaskView$b(boolean paramBoolean, ScanSharedMaskView paramScanSharedMaskView, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(314789);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
    }
    AppMethodBeat.o(314789);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(314783);
    if (!this.obi)
    {
      ScanSharedMaskView.b(this.PhK);
      ImageView localImageView = ScanSharedMaskView.c(this.PhK);
      localObject = localImageView;
      if (localImageView == null)
      {
        s.bIx("blurMaskView");
        localObject = null;
      }
      ((ImageView)localObject).setVisibility(8);
    }
    Object localObject = this.Pgh;
    if (localObject != null) {
      ((AnimatorListenerAdapter)localObject).onAnimationEnd(paramAnimator);
    }
    AppMethodBeat.o(314783);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(314802);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
    }
    AppMethodBeat.o(314802);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(314794);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
    }
    AppMethodBeat.o(314794);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    AppMethodBeat.i(314807);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
    }
    AppMethodBeat.o(314807);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(314798);
    AnimatorListenerAdapter localAnimatorListenerAdapter = this.Pgh;
    if (localAnimatorListenerAdapter != null) {
      localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
    }
    AppMethodBeat.o(314798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.b
 * JD-Core Version:    0.7.0.1
 */