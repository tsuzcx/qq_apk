package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$9
  extends AnimatorListenerAdapter
{
  DynamicGridView$9(DynamicGridView paramDynamicGridView, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40354);
    DynamicGridView.a(this.slD, false);
    DynamicGridView.b(this.slD);
    if ((DynamicGridView.c(this.slD) != null) && (DynamicGridView.d(this.slD) != null)) {
      DynamicGridView.d(this.slD).cxd();
    }
    DynamicGridView.a(this.slD, this.slI);
    AppMethodBeat.o(40354);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40353);
    DynamicGridView.a(this.slD, true);
    DynamicGridView.b(this.slD);
    AppMethodBeat.o(40353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.9
 * JD-Core Version:    0.7.0.1
 */