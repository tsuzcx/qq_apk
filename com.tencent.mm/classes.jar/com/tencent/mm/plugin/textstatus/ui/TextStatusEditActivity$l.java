package com.tencent.mm.plugin.textstatus.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$getBelowAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"})
public final class TextStatusEditActivity$l
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(237343);
    p.k(paramAnimator, "animation");
    AppMethodBeat.o(237343);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(237340);
    p.k(paramAnimator, "animation");
    TextStatusEditActivity.g(this.MMz).setVisibility(8);
    AppMethodBeat.o(237340);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(237346);
    p.k(paramAnimator, "animation");
    AppMethodBeat.o(237346);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(237338);
    p.k(paramAnimator, "animation");
    TextStatusEditActivity.g(this.MMz).setVisibility(0);
    AppMethodBeat.o(237338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.l
 * JD-Core Version:    0.7.0.1
 */