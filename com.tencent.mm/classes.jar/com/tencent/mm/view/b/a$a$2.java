package com.tencent.mm.view.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a$2
  implements Animator.AnimatorListener
{
  a$a$2(a.a parama) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.ASP.bVC = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(116399);
    if (this.ASP.ASN != null) {
      this.ASP.ASN.CO();
    }
    this.ASP.bVC = true;
    this.ASP.ASJ.ASB.set(this.ASP.ASJ.ccT);
    this.ASP.ASJ.ASH = (this.ASP.ASJ.d(this.ASP.ASJ.ASB) * 1.0F);
    if (this.ASP.ASM)
    {
      this.ASP.ASJ.ASG = (this.ASP.ASJ.d(this.ASP.ASJ.ASB) * 3.0F);
      a.a.a(this.ASP);
    }
    AppMethodBeat.o(116399);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(116398);
    if (this.ASP.ASN != null) {
      this.ASP.ASN.onStart();
    }
    this.ASP.bVC = false;
    AppMethodBeat.o(116398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.b.a.a.2
 * JD-Core Version:    0.7.0.1
 */