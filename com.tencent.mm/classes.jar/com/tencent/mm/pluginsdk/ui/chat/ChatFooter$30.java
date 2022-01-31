package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class ChatFooter$30
  implements View.OnTouchListener
{
  ChatFooter$30(ChatFooter paramChatFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.sgd.setToSendTextColor(true);
    ChatFooter.a(this.sgd, 3);
    if (ChatFooter.j(this.sgd) != null) {
      ChatFooter.j(this.sgd).D(paramMotionEvent);
    }
    ChatFooter.k(this.sgd);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.30
 * JD-Core Version:    0.7.0.1
 */