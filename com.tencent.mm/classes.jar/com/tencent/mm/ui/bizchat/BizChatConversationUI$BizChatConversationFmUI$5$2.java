package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.g;

final class BizChatConversationUI$BizChatConversationFmUI$5$2
  implements n.d
{
  BizChatConversationUI$BizChatConversationFmUI$5$2(BizChatConversationUI.BizChatConversationFmUI.5 param5) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(30060);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30060);
      return;
      BizChatConversationUI.BizChatConversationFmUI.m(this.ztw.ztv);
      AppMethodBeat.o(30060);
      return;
      g.t(this.ztw.ztv.getContext(), BizChatConversationUI.BizChatConversationFmUI.a(this.ztw.ztv), 6);
      AppMethodBeat.o(30060);
      return;
      if (bo.isNullOrNil(BizChatConversationUI.BizChatConversationFmUI.c(this.ztw.ztv)))
      {
        paramMenuItem = z.afi().rK(BizChatConversationUI.BizChatConversationFmUI.a(this.ztw.ztv));
        BizChatConversationUI.BizChatConversationFmUI.a(this.ztw.ztv, paramMenuItem.aeo());
      }
      if ((!bo.isNullOrNil(BizChatConversationUI.BizChatConversationFmUI.c(this.ztw.ztv))) && (z.afu().rw(BizChatConversationUI.BizChatConversationFmUI.c(this.ztw.ztv))))
      {
        z.afr();
        c.a(BizChatConversationUI.BizChatConversationFmUI.c(this.ztw.ztv), null);
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", BizChatConversationUI.BizChatConversationFmUI.a(this.ztw.ztv));
      com.tencent.mm.bq.d.b(this.ztw.ztv.thisActivity(), "profile", ".ui.ContactInfoUI", paramMenuItem);
      AppMethodBeat.o(30060);
      return;
      if (!bo.isNullOrNil(BizChatConversationUI.BizChatConversationFmUI.a(this.ztw.ztv)))
      {
        paramMenuItem = new Intent(this.ztw.ztv.getContext(), BizChatFavUI.class);
        paramMenuItem.putExtra("Contact_User", BizChatConversationUI.BizChatConversationFmUI.a(this.ztw.ztv));
        paramMenuItem.addFlags(67108864);
        this.ztw.ztv.startActivity(paramMenuItem);
        AppMethodBeat.o(30060);
        return;
      }
      ab.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.5.2
 * JD-Core Version:    0.7.0.1
 */