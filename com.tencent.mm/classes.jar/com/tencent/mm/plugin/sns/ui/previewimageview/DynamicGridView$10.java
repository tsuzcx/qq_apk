package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$10
  extends AnimatorListenerAdapter
{
  DynamicGridView$10(DynamicGridView paramDynamicGridView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40356);
    DynamicGridView.b(this.slD, false);
    DynamicGridView.b(this.slD);
    AppMethodBeat.o(40356);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40355);
    DynamicGridView.b(this.slD, true);
    DynamicGridView.b(this.slD);
    AppMethodBeat.o(40355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.10
 * JD-Core Version:    0.7.0.1
 */