package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.f.a.aq;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.q.g;

final class NewBizConversationUI$10
  implements q.g
{
  NewBizConversationUI$10(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(38671);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38671);
      return;
      bh.beI();
      paramMenuItem = com.tencent.mm.model.c.bbL().RG(NewBizConversationUI.q(this.XDT));
      if (paramMenuItem == null)
      {
        Log.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.q(this.XDT));
        AppMethodBeat.o(38671);
        return;
      }
      if (paramMenuItem.ayn())
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
        ab.H(NewBizConversationUI.q(this.XDT), true);
      }
      for (;;)
      {
        aq localaq = new aq();
        localaq.fwb.userName = paramMenuItem.field_username;
        EventCenter.instance.publish(localaq);
        AppMethodBeat.o(38671);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        ab.G(NewBizConversationUI.q(this.XDT), true);
      }
      bh.beI();
      paramMenuItem = com.tencent.mm.model.c.bbL().RG(NewBizConversationUI.q(this.XDT));
      com.tencent.mm.ui.tools.c.a(af.bjv().Uo(NewBizConversationUI.q(this.XDT)), this.XDT, paramMenuItem, 2);
      AppMethodBeat.o(38671);
      return;
      NewBizConversationUI.b(this.XDT, NewBizConversationUI.q(this.XDT));
      AppMethodBeat.o(38671);
      return;
      com.tencent.mm.ui.h.c(this.XDT, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(291219);
          bh.beI();
          com.tencent.mm.model.c.bbR().bwv(NewBizConversationUI.q(NewBizConversationUI.10.this.XDT));
          AppMethodBeat.o(291219);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.10
 * JD-Core Version:    0.7.0.1
 */