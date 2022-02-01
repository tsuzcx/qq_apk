package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$4
  implements Animator.AnimatorListener
{
  f$4(f paramf, View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(143086);
    this.afIB.setLayerType(0, null);
    AppMethodBeat.o(143086);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(143085);
    this.afIB.setLayerType(2, null);
    AppMethodBeat.o(143085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.f.4
 * JD-Core Version:    0.7.0.1
 */