package com.tencent.mm.plugin.remittance.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$animShowKeyboard$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RemittanceRemarkInputHalfPage$e
  implements Animator.AnimatorListener
{
  RemittanceRemarkInputHalfPage$e(j paramj) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(288923);
    this.OsC.rootView.getHeight();
    this.OsC.rootView.getPaddingBottom();
    AppMethodBeat.o(288923);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceRemarkInputHalfPage.e
 * JD-Core Version:    0.7.0.1
 */