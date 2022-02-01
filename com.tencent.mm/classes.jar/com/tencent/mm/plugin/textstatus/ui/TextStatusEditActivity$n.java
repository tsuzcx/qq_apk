package com.tencent.mm.plugin.textstatus.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$getUpAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"})
public final class TextStatusEditActivity$n
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(232632);
    p.k(paramAnimator, "animation");
    AppMethodBeat.o(232632);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(232630);
    p.k(paramAnimator, "animation");
    AppMethodBeat.o(232630);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(232635);
    p.k(paramAnimator, "animation");
    AppMethodBeat.o(232635);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(232627);
    p.k(paramAnimator, "animation");
    TextStatusEditActivity.g(this.MMz).setVisibility(0);
    AppMethodBeat.o(232627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.n
 * JD-Core Version:    0.7.0.1
 */