package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.i.a;

final class MainUI$1
  implements a
{
  MainUI$1(MainUI paramMainUI)
  {
    AppMethodBeat.i(154000);
    AppMethodBeat.o(154000);
  }
  
  public final void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(154686);
    if (MainUI.a(this.Alw) != null)
    {
      ConversationListView localConversationListView = MainUI.a(this.Alw);
      if (localConversationListView.czT)
      {
        ab.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        localConversationListView.dMv();
      }
    }
    AppMethodBeat.o(154686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.1
 * JD-Core Version:    0.7.0.1
 */