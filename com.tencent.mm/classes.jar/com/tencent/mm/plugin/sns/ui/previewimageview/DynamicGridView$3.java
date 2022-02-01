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
    AppMethodBeat.i(100308);
    this.val$v.setLayerType(0, null);
    AppMethodBeat.o(100308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.3
 * JD-Core Version:    0.7.0.1
 */