package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$86
  implements ValueAnimator.AnimatorUpdateListener
{
  ChatFooter$86(ChatFooter paramChatFooter) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(245437);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ChatFooter.aI(this.YiY).setTranslationX(f);
    AppMethodBeat.o(245437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.86
 * JD-Core Version:    0.7.0.1
 */