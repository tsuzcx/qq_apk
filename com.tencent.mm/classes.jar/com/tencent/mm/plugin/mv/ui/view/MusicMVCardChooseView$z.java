package com.tencent.mm.plugin.mv.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$updateViewHeight$1$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "plugin-mv_release"})
public final class MusicMVCardChooseView$z
  extends AnimatorListenerAdapter
{
  MusicMVCardChooseView$z(boolean paramBoolean, int paramInt1, b paramb, a parama, int paramInt2) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(243909);
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationCancel");
    AppMethodBeat.o(243909);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(243907);
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationEnd");
    paramAnimator = this.Goj;
    if (paramAnimator != null)
    {
      paramAnimator.invoke();
      AppMethodBeat.o(243907);
      return;
    }
    AppMethodBeat.o(243907);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(243908);
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationPause");
    AppMethodBeat.o(243908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.z
 * JD-Core Version:    0.7.0.1
 */