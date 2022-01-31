package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;

final class ConversationWithAppBrandListView$15
  implements ValueAnimator.AnimatorUpdateListener
{
  ConversationWithAppBrandListView$15(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    ConversationWithAppBrandListView.m(this.vRV).setAlpha(i);
    this.vRV.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.15
 * JD-Core Version:    0.7.0.1
 */