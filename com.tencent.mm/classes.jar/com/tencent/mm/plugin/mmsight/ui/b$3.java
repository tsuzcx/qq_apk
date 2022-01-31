package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  extends AnimatorListenerAdapter
{
  b$3(b paramb) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(55137);
    b.m(this.oOV).setVisibility(8);
    b.m(this.oOV).setAlpha(1.0F);
    AppMethodBeat.o(55137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.3
 * JD-Core Version:    0.7.0.1
 */