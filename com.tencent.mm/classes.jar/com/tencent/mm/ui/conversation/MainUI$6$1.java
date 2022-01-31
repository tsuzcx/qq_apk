package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;

final class MainUI$6$1
  implements Runnable
{
  MainUI$6$1(MainUI.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(154004);
    MainUI.a(this.Alx.Alw, MainUI.b(this.Alx.Alw).getCount());
    if ((MainUI.b(this.Alx.Alw).getCount() <= 0) && (MainUI.a(this.Alx.Alw) != null))
    {
      ConversationListView localConversationListView = MainUI.a(this.Alx.Alw);
      ab.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", new Object[] { Boolean.valueOf(localConversationListView.jcu) });
      if (!localConversationListView.jcu)
      {
        localConversationListView.rl(false);
        if (localConversationListView.AiN != null) {
          localConversationListView.AiN.setBackgroundColor(localConversationListView.getContext().getResources().getColor(2131690709));
        }
        localConversationListView.hK(localConversationListView.getResources().getColor(2131690316), localConversationListView.getResources().getColor(2131689652));
      }
    }
    MainUI.d(this.Alx.Alw).dMn();
    g.Cy(12);
    AppMethodBeat.o(154004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.6.1
 * JD-Core Version:    0.7.0.1
 */