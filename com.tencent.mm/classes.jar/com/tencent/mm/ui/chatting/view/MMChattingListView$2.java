package com.tencent.mm.ui.chatting.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;
import android.view.View;
import android.widget.ListView;

final class MMChattingListView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  MMChattingListView$2(MMChattingListView paramMMChattingListView, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.vAy.getGlobalVisibleRect(MMChattingListView.a(this.vAx));
    MMChattingListView.a(this.vAx).top = this.vAy.getTop();
    MMChattingListView.a(this.vAx).bottom = this.vAy.getBottom();
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    MMChattingListView.c(this.vAx).setAlpha((int)(f * 255.0F));
    MMChattingListView.b(this.vAx).postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView.2
 * JD-Core Version:    0.7.0.1
 */