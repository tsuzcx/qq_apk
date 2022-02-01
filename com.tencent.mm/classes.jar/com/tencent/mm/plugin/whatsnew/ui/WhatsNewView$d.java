package com.tencent.mm.plugin.whatsnew.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$animateToFinish$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"})
public final class WhatsNewView$d
  implements Animator.AnimatorListener
{
  WhatsNewView$d(WhatsNewView paramWhatsNewView, float paramFloat) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(230994);
    Log.w("MicroMsg.WhatsNewView", "animateToFinish: onAnimationCancel");
    AppMethodBeat.o(230994);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(230993);
    Log.w("MicroMsg.WhatsNewView", "animateToFinish: onAnimationEnd");
    WhatsNewView.e(this.JPu).setAlpha(0.0F);
    WhatsNewView.f(this.JPu).setAlpha(0.0F);
    paramAnimator = this.JPu.getOnFinish();
    if (paramAnimator != null)
    {
      paramAnimator.invoke();
      AppMethodBeat.o(230993);
      return;
    }
    AppMethodBeat.o(230993);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(230995);
    Log.w("MicroMsg.WhatsNewView", "animateToFinish: onAnimationRepeat");
    AppMethodBeat.o(230995);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(230992);
    Log.w("MicroMsg.WhatsNewView", "animateToFinish: onAnimationStart");
    AppMethodBeat.o(230992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewView.d
 * JD-Core Version:    0.7.0.1
 */