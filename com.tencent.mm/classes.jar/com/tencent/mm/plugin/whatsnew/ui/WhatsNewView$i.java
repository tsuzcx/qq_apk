package com.tencent.mm.plugin.whatsnew.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$fadeIn$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"})
public final class WhatsNewView$i
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(258309);
    WhatsNewView.f(this.JPu).setAlpha(1.0F);
    AppMethodBeat.o(258309);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewView.i
 * JD-Core Version:    0.7.0.1
 */