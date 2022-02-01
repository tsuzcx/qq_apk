package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.g;

final class BizChatConversationUI$BizChatConversationFmUI$14
  implements o.g
{
  BizChatConversationUI$BizChatConversationFmUI$14(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(33930);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33930);
      return;
      BizChatConversationUI.BizChatConversationFmUI.a(this.PaS, BizChatConversationUI.BizChatConversationFmUI.e(this.PaS));
      AppMethodBeat.o(33930);
      return;
      g.c(this.PaS.thisActivity(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232784);
          ag.bak().Am(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.14.this.PaS));
          if (ag.bak().Nz(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.14.this.PaS)) <= 0)
          {
            bg.aVF();
            c.aST().bjW(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.14.this.PaS));
          }
          AppMethodBeat.o(232784);
        }
      });
      AppMethodBeat.o(33930);
      return;
      paramMenuItem = ag.bak().Al(BizChatConversationUI.BizChatConversationFmUI.e(this.PaS));
      paramMenuItem.field_unReadCount = 1;
      paramMenuItem.field_atCount = 0;
      paramMenuItem.field_atAll = 0;
      ag.bak().b(paramMenuItem);
      com.tencent.mm.modelstat.b.jmd.V(paramMenuItem.field_brandUserName, true);
      AppMethodBeat.o(33930);
      return;
      ag.bak().An(BizChatConversationUI.BizChatConversationFmUI.e(this.PaS));
      paramMenuItem = ag.bak().Al(BizChatConversationUI.BizChatConversationFmUI.e(this.PaS));
      com.tencent.mm.modelstat.b.jmd.V(paramMenuItem.field_brandUserName, false);
      AppMethodBeat.o(33930);
      return;
      paramMenuItem = ag.bak().Al(BizChatConversationUI.BizChatConversationFmUI.e(this.PaS));
      if (ag.bak().Ao(BizChatConversationUI.BizChatConversationFmUI.e(this.PaS)))
      {
        ag.bak().Aq(BizChatConversationUI.BizChatConversationFmUI.e(this.PaS));
        com.tencent.mm.modelstat.b.jmd.c(true, paramMenuItem.field_brandUserName, false);
        AppMethodBeat.o(33930);
        return;
      }
      ag.bak().Ap(BizChatConversationUI.BizChatConversationFmUI.e(this.PaS));
      com.tencent.mm.modelstat.b.jmd.c(true, paramMenuItem.field_brandUserName, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.14
 * JD-Core Version:    0.7.0.1
 */