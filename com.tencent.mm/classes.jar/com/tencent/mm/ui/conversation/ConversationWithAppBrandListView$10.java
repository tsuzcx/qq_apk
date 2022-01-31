package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConversationWithAppBrandListView$10
  implements ValueAnimator.AnimatorUpdateListener
{
  ConversationWithAppBrandListView$10(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(34276);
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("deltaY")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("headerDeltaY")).floatValue();
    int i = 0;
    if (i < this.AjJ.getChildCount())
    {
      if (i == 0) {
        this.AjJ.getChildAt(i).setTranslationY(f2);
      }
      for (;;)
      {
        ConversationWithAppBrandListView.a(this.AjJ, f1);
        i += 1;
        break;
        this.AjJ.getChildAt(i).setTranslationY(f1);
      }
    }
    this.AjJ.invalidate();
    AppMethodBeat.o(34276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.10
 * JD-Core Version:    0.7.0.1
 */