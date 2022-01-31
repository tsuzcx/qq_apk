package com.tencent.mm.ui.chatting.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;

final class MMChattingListView$3
  extends AnimatorListenerAdapter
{
  MMChattingListView$3(MMChattingListView paramMMChattingListView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MMChattingListView.a(this.vAx).setEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView.3
 * JD-Core Version:    0.7.0.1
 */