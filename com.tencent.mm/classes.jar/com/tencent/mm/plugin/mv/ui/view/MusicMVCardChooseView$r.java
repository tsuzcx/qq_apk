package com.tencent.mm.plugin.mv.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$updateViewHeight$1$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMVCardChooseView$r
  extends AnimatorListenerAdapter
{
  MusicMVCardChooseView$r(a<ah> parama) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(287188);
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationCancel");
    AppMethodBeat.o(287188);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(287182);
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationEnd");
    paramAnimator = this.GUX;
    if (paramAnimator != null) {
      paramAnimator.invoke();
    }
    AppMethodBeat.o(287182);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(287184);
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim onAnimationPause");
    AppMethodBeat.o(287184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.r
 * JD-Core Version:    0.7.0.1
 */