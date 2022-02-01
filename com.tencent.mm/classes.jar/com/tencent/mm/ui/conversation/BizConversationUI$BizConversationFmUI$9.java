package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.q.g;

final class BizConversationUI$BizConversationFmUI$9
  implements q.g
{
  BizConversationUI$BizConversationFmUI$9(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(38244);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38244);
      return;
      bh.beI();
      paramMenuItem = com.tencent.mm.model.c.bbL().RG(BizConversationUI.BizConversationFmUI.n(this.XzJ));
      if (paramMenuItem == null)
      {
        Log.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationUI.BizConversationFmUI.n(this.XzJ));
        AppMethodBeat.o(38244);
        return;
      }
      if (paramMenuItem.ayn())
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
        ab.H(BizConversationUI.BizConversationFmUI.n(this.XzJ), true);
        AppMethodBeat.o(38244);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
      ab.G(BizConversationUI.BizConversationFmUI.n(this.XzJ), true);
      AppMethodBeat.o(38244);
      return;
      bh.beI();
      paramMenuItem = com.tencent.mm.model.c.bbL().RG(BizConversationUI.BizConversationFmUI.n(this.XzJ));
      com.tencent.mm.ui.tools.c.a(af.bjv().Uo(BizConversationUI.BizConversationFmUI.n(this.XzJ)), this.XzJ.thisActivity(), paramMenuItem, 2);
      AppMethodBeat.o(38244);
      return;
      BizConversationUI.BizConversationFmUI.b(this.XzJ, BizConversationUI.BizConversationFmUI.n(this.XzJ));
      AppMethodBeat.o(38244);
      return;
      com.tencent.mm.ui.h.c(this.XzJ.thisActivity(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196400);
          bh.beI();
          com.tencent.mm.model.c.bbR().bwx(BizConversationUI.BizConversationFmUI.n(BizConversationUI.BizConversationFmUI.9.this.XzJ));
          AppMethodBeat.o(196400);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.9
 * JD-Core Version:    0.7.0.1
 */