package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScanLineAnimator$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
public final class ScanCodeMaskView$d
  extends AnimatorListenerAdapter
{
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(52379);
    ScanCodeMaskView.a(this.yNL).setVisibility(8);
    AppMethodBeat.o(52379);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.d
 * JD-Core Version:    0.7.0.1
 */