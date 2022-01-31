package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.sdk.platformtools.y;

final class ChatFooter$21
  implements Runnable
{
  ChatFooter$21(ChatFooter paramChatFooter) {}
  
  public final void run()
  {
    if (!this.sgd.cnC())
    {
      ChatFooter.a(this.sgd, 1);
      return;
    }
    y.i("changelcai", "isScrolling!! pass this event!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.21
 * JD-Core Version:    0.7.0.1
 */