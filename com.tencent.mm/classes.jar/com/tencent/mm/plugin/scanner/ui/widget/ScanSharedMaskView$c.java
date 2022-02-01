package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateShowScanTips$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-scan_release"})
public final class ScanSharedMaskView$c
  extends AnimatorListenerAdapter
{
  ScanSharedMaskView$c(boolean paramBoolean) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(170076);
    super.onAnimationCancel(paramAnimator);
    ScanSharedMaskView.b(this.CST, this.rti);
    AppMethodBeat.o(170076);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(170075);
    super.onAnimationEnd(paramAnimator);
    ScanSharedMaskView.b(this.CST, this.rti);
    AppMethodBeat.o(170075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.c
 * JD-Core Version:    0.7.0.1
 */