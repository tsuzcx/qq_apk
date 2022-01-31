package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.b;

final class BizConversationUI$a$8
  implements n.d
{
  BizConversationUI$a$8(BizConversationUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      au.Hx();
      paramMenuItem = c.Fw().abl(BizConversationUI.a.n(this.vPu));
      if (paramMenuItem == null)
      {
        y.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationUI.a.n(this.vPu));
        return;
      }
      if (paramMenuItem.Bl())
      {
        h.nFQ.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
        s.u(BizConversationUI.a.n(this.vPu), true);
        return;
      }
      h.nFQ.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
      s.t(BizConversationUI.a.n(this.vPu), true);
      return;
    case 2: 
      au.Hx();
      paramMenuItem = c.Fw().abl(BizConversationUI.a.n(this.vPu));
      b.a(z.My().kQ(BizConversationUI.a.n(this.vPu)), this.vPu.thisActivity(), paramMenuItem, 2);
      return;
    }
    BizConversationUI.a.b(this.vPu, BizConversationUI.a.n(this.vPu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.a.8
 * JD-Core Version:    0.7.0.1
 */