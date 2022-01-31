package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$8
  implements Animator.AnimatorListener
{
  e$8(e parame) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(40330);
    this.skN.skG.setVisibility(4);
    this.skN.skG.setTranslationY(0.0F);
    AppMethodBeat.o(40330);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40329);
    this.skN.skG.setVisibility(4);
    this.skN.skG.setTranslationY(0.0F);
    AppMethodBeat.o(40329);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40328);
    e.b(this.skN);
    AppMethodBeat.o(40328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.8
 * JD-Core Version:    0.7.0.1
 */