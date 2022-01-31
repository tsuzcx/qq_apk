package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

final class e$8
  implements Animator.AnimatorListener
{
  e$8(e parame) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.ppV.ppO.setVisibility(4);
    this.ppV.ppO.setTranslationY(0.0F);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.ppV.ppO.setVisibility(4);
    this.ppV.ppO.setTranslationY(0.0F);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    e.b(this.ppV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.8
 * JD-Core Version:    0.7.0.1
 */