package com.tencent.mm.plugin.shake.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$9
  implements Animator.AnimatorListener
{
  ShakeReportUI$9(ShakeReportUI paramShakeReportUI) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(273568);
    ShakeReportUI.a(this.PEm, Boolean.FALSE);
    AppMethodBeat.o(273568);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(273566);
    ShakeReportUI.a(this.PEm, Boolean.FALSE);
    AppMethodBeat.o(273566);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(273564);
    ShakeReportUI.a(this.PEm, Boolean.TRUE);
    AppMethodBeat.o(273564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.9
 * JD-Core Version:    0.7.0.1
 */