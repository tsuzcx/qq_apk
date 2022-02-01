package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class e$1
  implements Animator.AnimatorListener
{
  e$1(e parame, View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(143081);
    this.Lfa.setLayerType(0, null);
    ae.i("MicroMsg.ImagePreviewAnimation", "pennqin, bg animation result, alpha %s.", new Object[] { Float.valueOf(this.Lfa.getAlpha()) });
    AppMethodBeat.o(143081);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(143080);
    this.Lfa.setLayerType(2, null);
    AppMethodBeat.o(143080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e.1
 * JD-Core Version:    0.7.0.1
 */