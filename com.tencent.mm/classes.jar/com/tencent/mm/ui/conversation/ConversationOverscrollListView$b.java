package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.y;

public final class ConversationOverscrollListView$b
  implements Runnable
{
  public ConversationOverscrollListView$b(ConversationOverscrollListView paramConversationOverscrollListView) {}
  
  public final void run()
  {
    if ((ConversationOverscrollListView.a(this.vRi) != null) && (!ConversationOverscrollListView.a(this.vRi).cHZ()))
    {
      y.d("MicroMsg.ConversationOverscrollListView", "jacks cancel to Show Main");
      ConversationOverscrollListView.a(this.vRi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationOverscrollListView.b
 * JD-Core Version:    0.7.0.1
 */