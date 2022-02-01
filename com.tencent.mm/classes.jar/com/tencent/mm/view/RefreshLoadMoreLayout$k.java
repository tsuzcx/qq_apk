package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/view/RefreshLoadMoreLayout$animToShowLoadMore$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RefreshLoadMoreLayout$k
  implements Animator.AnimatorListener
{
  public RefreshLoadMoreLayout$k(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(234716);
    RefreshLoadMoreLayout.b(this.agJM, false);
    AppMethodBeat.o(234716);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(234723);
    RefreshLoadMoreLayout.b(this.agJM, true);
    AppMethodBeat.o(234723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.RefreshLoadMoreLayout.k
 * JD-Core Version:    0.7.0.1
 */