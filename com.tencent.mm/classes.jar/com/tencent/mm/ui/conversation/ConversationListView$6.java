package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.c;

final class ConversationListView$6
  implements Runnable
{
  ConversationListView$6(ConversationListView paramConversationListView) {}
  
  public final void run()
  {
    AppMethodBeat.i(34216);
    ConversationListView localConversationListView = this.AiQ;
    int i = this.bHS;
    if (localConversationListView.Ail != null) {
      localConversationListView.Ail.pW(i);
    }
    AppMethodBeat.o(34216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView.6
 * JD-Core Version:    0.7.0.1
 */