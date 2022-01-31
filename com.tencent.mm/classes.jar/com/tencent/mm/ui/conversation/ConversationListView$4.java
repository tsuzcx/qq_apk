package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;

final class ConversationListView$4
  implements Runnable
{
  int ePG = 0;
  
  ConversationListView$4(ConversationListView paramConversationListView) {}
  
  public final void run()
  {
    AppMethodBeat.i(34214);
    if (ConversationListView.d(this.AiQ) == null)
    {
      AppMethodBeat.o(34214);
      return;
    }
    if (ConversationListView.d(this.AiQ).getTop() != 0) {
      ConversationListView.a(this.AiQ, ConversationListView.d(this.AiQ).getTop());
    }
    if (ConversationListView.e(this.AiQ) <= 0) {
      if (this.ePG <= 2)
      {
        ab.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", new Object[] { Integer.valueOf(this.ePG) });
        this.AiQ.post(this);
      }
    }
    for (;;)
    {
      this.ePG += 1;
      AppMethodBeat.o(34214);
      return;
      ConversationListView.a(this.AiQ, am.getStatusBarHeight(this.AiQ.getContext()));
      ab.e("MicroMsg.ConversationListView", "alvinluo initActionBarView tryCount: %d, get default status bar height: %d", new Object[] { Integer.valueOf(this.ePG), Integer.valueOf(ConversationListView.e(this.AiQ)) });
      ConversationListView.b(this.AiQ, ConversationListView.e(this.AiQ));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView.4
 * JD-Core Version:    0.7.0.1
 */