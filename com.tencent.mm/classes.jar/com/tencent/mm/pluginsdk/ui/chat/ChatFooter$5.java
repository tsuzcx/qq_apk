package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;

final class ChatFooter$5
  implements View.OnClickListener
{
  ChatFooter$5(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    this.sgd.cnd();
    if ((q.GS().booleanValue()) && (this.sgd.sfq != null)) {
      this.sgd.sfq.a(Boolean.valueOf(true), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.5
 * JD-Core Version:    0.7.0.1
 */