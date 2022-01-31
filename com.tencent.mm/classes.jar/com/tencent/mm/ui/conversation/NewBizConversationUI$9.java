package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.ah;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.b;

final class NewBizConversationUI$9
  implements n.d
{
  NewBizConversationUI$9(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      au.Hx();
      paramMenuItem = c.Fw().abl(NewBizConversationUI.n(this.vTG));
      if (paramMenuItem == null)
      {
        y.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.n(this.vTG));
        return;
      }
      if (paramMenuItem.Bl())
      {
        h.nFQ.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
        s.u(NewBizConversationUI.n(this.vTG), true);
      }
      for (;;)
      {
        ah localah = new ah();
        localah.bGj.userName = paramMenuItem.field_username;
        a.udP.m(localah);
        return;
        h.nFQ.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        s.t(NewBizConversationUI.n(this.vTG), true);
      }
    case 2: 
      au.Hx();
      paramMenuItem = c.Fw().abl(NewBizConversationUI.n(this.vTG));
      b.a(z.My().kQ(NewBizConversationUI.n(this.vTG)), this.vTG, paramMenuItem, 2);
      return;
    }
    NewBizConversationUI.b(this.vTG, NewBizConversationUI.n(this.vTG));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.9
 * JD-Core Version:    0.7.0.1
 */