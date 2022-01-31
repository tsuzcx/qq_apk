package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;

final class SnsTranslateResultView$1
  implements Animator.AnimatorListener
{
  SnsTranslateResultView$1(SnsTranslateResultView paramSnsTranslateResultView, aq.b paramb) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(39622);
    if (this.saC != null) {
      aq.a(this.saC);
    }
    AppMethodBeat.o(39622);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTranslateResultView.1
 * JD-Core Version:    0.7.0.1
 */