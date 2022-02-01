package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ui.widget.b;

final class BaseScanUI$35
  extends AnimatorListenerAdapter
{
  BaseScanUI$35(BaseScanUI paramBaseScanUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(314488);
    super.onAnimationEnd(paramAnimator);
    BaseScanUI.Z(this.OYm).kU(this.val$mode, 4);
    AppMethodBeat.o(314488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.35
 * JD-Core Version:    0.7.0.1
 */