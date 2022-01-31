package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  extends AnimatorListenerAdapter
{
  b$2(b paramb) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(55342);
    this.oRv.oRh = true;
    if (this.oRv.oRi != null) {
      this.oRv.oRi.a(this.oRv.oRg);
    }
    AppMethodBeat.o(55342);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.oRv.oRh = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b.2
 * JD-Core Version:    0.7.0.1
 */