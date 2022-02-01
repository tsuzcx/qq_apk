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
    AppMethodBeat.i(100292);
    this.RTk.RTe.setVisibility(4);
    this.RTk.RTe.setTranslationY(0.0F);
    AppMethodBeat.o(100292);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(100291);
    this.RTk.RTe.setVisibility(4);
    this.RTk.RTe.setTranslationY(0.0F);
    AppMethodBeat.o(100291);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(100290);
    e.b(this.RTk);
    AppMethodBeat.o(100290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.8
 * JD-Core Version:    0.7.0.1
 */