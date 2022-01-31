package com.tencent.mm.plugin.sns.ui.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  extends AnimatorListenerAdapter
{
  c$2(c paramc) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40008);
    if (this.seS.seQ != null) {
      this.seS.seQ.onAnimationEnd();
    }
    this.seS.view.setVisibility(8);
    AppMethodBeat.o(40008);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40007);
    if (this.seS.seQ != null) {
      this.seS.seQ.onAnimationStart();
    }
    this.seS.view.setVisibility(0);
    AppMethodBeat.o(40007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.c.2
 * JD-Core Version:    0.7.0.1
 */