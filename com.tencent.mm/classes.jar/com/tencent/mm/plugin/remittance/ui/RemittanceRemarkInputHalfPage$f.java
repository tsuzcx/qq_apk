package com.tencent.mm.plugin.remittance.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$animShowKeyboard$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-wxpay_release"})
public final class RemittanceRemarkInputHalfPage$f
  implements Animator.AnimatorListener
{
  RemittanceRemarkInputHalfPage$f(g paramg) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(276090);
    paramAnimator = this.IuU;
    View localView = this.IuU.oFW;
    p.j(localView, "it.rootView");
    int i = localView.getHeight();
    localView = this.IuU.oFW;
    p.j(localView, "it.rootView");
    paramAnimator.D(i + localView.getPaddingBottom());
    AppMethodBeat.o(276090);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceRemarkInputHalfPage.f
 * JD-Core Version:    0.7.0.1
 */