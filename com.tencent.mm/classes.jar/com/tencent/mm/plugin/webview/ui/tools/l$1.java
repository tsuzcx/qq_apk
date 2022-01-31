package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$1
  extends AnimatorListenerAdapter
{
  l$1(l paraml) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(7696);
    super.onAnimationCancel(paramAnimator);
    l.a(this.vdl);
    AppMethodBeat.o(7696);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(7697);
    super.onAnimationEnd(paramAnimator);
    l.a(this.vdl);
    AppMethodBeat.o(7697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.l.1
 * JD-Core Version:    0.7.0.1
 */