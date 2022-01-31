package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$39
  implements ValueAnimator.AnimatorUpdateListener
{
  ChatFooter$39(ChatFooter paramChatFooter) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(156075);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = ChatFooter.h(this.vXU).getLayoutParams();
    paramValueAnimator.width = i;
    ChatFooter.h(this.vXU).setLayoutParams(paramValueAnimator);
    float f = (i - ChatFooter.av(this.vXU)) / (ChatFooter.aw(this.vXU) - ChatFooter.av(this.vXU));
    ChatFooter.h(this.vXU).setAlpha(f);
    AppMethodBeat.o(156075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.39
 * JD-Core Version:    0.7.0.1
 */