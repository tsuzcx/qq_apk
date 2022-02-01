package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "scan-translation_release"})
public final class ScanTranslationResultUI$h
  extends AnimatorListenerAdapter
{
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(162356);
    ScanTranslationResultUI.k(this.vUE).setAlpha(0.0F);
    AppMethodBeat.o(162356);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(162355);
    ScanTranslationResultUI.k(this.vUE).setAlpha(0.0F);
    AppMethodBeat.o(162355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.h
 * JD-Core Version:    0.7.0.1
 */