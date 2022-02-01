package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;

final class ConversationListView$12
  implements com.tencent.mm.kernel.api.g
{
  ConversationListView$12(ConversationListView paramConversationListView) {}
  
  public final void WY()
  {
    AppMethodBeat.i(258298);
    com.tencent.mm.kernel.g.aAi().b(this);
    if ((bg.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
    {
      Log.i("MicroMsg.ConversationListView", "onStartupDone account initialized, initHeaderContainer");
      this.Qdd.kq(this.Qdd.getContext());
      AppMethodBeat.o(258298);
      return;
    }
    Log.w("MicroMsg.ConversationListView", "onStartupDone but account not initialized");
    AppMethodBeat.o(258298);
  }
  
  public final void cQ(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView.12
 * JD-Core Version:    0.7.0.1
 */