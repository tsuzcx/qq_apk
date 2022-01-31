package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.ui.base.n.d;

final class BizChatConversationUI$BizChatConversationFmUI$15
  implements n.d
{
  BizChatConversationUI$BizChatConversationFmUI$15(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(30072);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30072);
      return;
      BizChatConversationUI.BizChatConversationFmUI.a(this.ztv, BizChatConversationUI.BizChatConversationFmUI.e(this.ztv));
      AppMethodBeat.o(30072);
      return;
      paramMenuItem = z.afl().gF(BizChatConversationUI.BizChatConversationFmUI.e(this.ztv));
      paramMenuItem.field_unReadCount = 1;
      paramMenuItem.field_atCount = 0;
      z.afl().b(paramMenuItem);
      com.tencent.mm.modelstat.b.fRu.R(paramMenuItem.field_brandUserName, true);
      AppMethodBeat.o(30072);
      return;
      z.afl().gH(BizChatConversationUI.BizChatConversationFmUI.e(this.ztv));
      paramMenuItem = z.afl().gF(BizChatConversationUI.BizChatConversationFmUI.e(this.ztv));
      com.tencent.mm.modelstat.b.fRu.R(paramMenuItem.field_brandUserName, false);
      AppMethodBeat.o(30072);
      return;
      paramMenuItem = z.afl().gF(BizChatConversationUI.BizChatConversationFmUI.e(this.ztv));
      if (z.afl().gI(BizChatConversationUI.BizChatConversationFmUI.e(this.ztv)))
      {
        z.afl().gK(BizChatConversationUI.BizChatConversationFmUI.e(this.ztv));
        com.tencent.mm.modelstat.b.fRu.c(true, paramMenuItem.field_brandUserName, false);
        AppMethodBeat.o(30072);
        return;
      }
      z.afl().gJ(BizChatConversationUI.BizChatConversationFmUI.e(this.ztv));
      com.tencent.mm.modelstat.b.fRu.c(true, paramMenuItem.field_brandUserName, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.15
 * JD-Core Version:    0.7.0.1
 */