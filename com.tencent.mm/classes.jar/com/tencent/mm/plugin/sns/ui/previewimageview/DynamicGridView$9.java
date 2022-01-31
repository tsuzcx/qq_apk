package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class DynamicGridView$9
  extends AnimatorListenerAdapter
{
  DynamicGridView$9(DynamicGridView paramDynamicGridView, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.a(this.pqL, false);
    DynamicGridView.b(this.pqL);
    if ((DynamicGridView.c(this.pqL) != null) && (DynamicGridView.d(this.pqL) != null)) {
      DynamicGridView.d(this.pqL).bKq();
    }
    DynamicGridView.a(this.pqL, this.pqQ);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.a(this.pqL, true);
    DynamicGridView.b(this.pqL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.9
 * JD-Core Version:    0.7.0.1
 */