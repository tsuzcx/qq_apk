package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class DynamicGridView$10
  extends AnimatorListenerAdapter
{
  DynamicGridView$10(DynamicGridView paramDynamicGridView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.b(this.pqL, false);
    DynamicGridView.b(this.pqL);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.b(this.pqL, true);
    DynamicGridView.b(this.pqL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.10
 * JD-Core Version:    0.7.0.1
 */