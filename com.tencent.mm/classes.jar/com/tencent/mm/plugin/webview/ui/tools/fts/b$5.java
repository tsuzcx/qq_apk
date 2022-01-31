package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$5
  implements Animator.AnimatorListener
{
  b$5(b paramb) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.vlX.isAnimating = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(8579);
    this.vlX.isAnimating = false;
    if (this.vlX.vlK != null) {
      this.vlX.vlK.onAnimationEnd();
    }
    AppMethodBeat.o(8579);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(8578);
    this.vlX.isAnimating = true;
    if (this.vlX.vlK != null) {
      this.vlX.vlK.onAnimationStart();
    }
    AppMethodBeat.o(8578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.b.5
 * JD-Core Version:    0.7.0.1
 */