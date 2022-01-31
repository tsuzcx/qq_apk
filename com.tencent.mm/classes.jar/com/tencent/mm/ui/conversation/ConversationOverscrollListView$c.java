package com.tencent.mm.ui.conversation;

import android.view.animation.Interpolator;

final class ConversationOverscrollListView$c
  implements Interpolator
{
  private float nmx = 1.3F;
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    paramFloat = (paramFloat * (this.nmx + 1.0F) + this.nmx) * (paramFloat * paramFloat) + 1.0F;
    if (paramFloat > 1.0F) {
      return 1.0F;
    }
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationOverscrollListView.c
 * JD-Core Version:    0.7.0.1
 */