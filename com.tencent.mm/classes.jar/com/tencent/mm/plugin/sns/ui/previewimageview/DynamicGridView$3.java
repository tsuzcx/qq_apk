package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$3
  extends AnimatorListenerAdapter
{
  DynamicGridView$3(DynamicGridView paramDynamicGridView, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40346);
    this.bTJ.setLayerType(0, null);
    AppMethodBeat.o(40346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.3
 * JD-Core Version:    0.7.0.1
 */