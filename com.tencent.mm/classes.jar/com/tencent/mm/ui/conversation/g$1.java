package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.n.d;

final class g$1
  implements n.d
{
  g$1(g paramg) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 4;
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      paramInt = -1;
      for (;;)
      {
        if (paramInt > 0)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(11090, new Object[] { Integer.valueOf(paramInt) });
          y.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramInt) });
        }
        return;
        if (s.fn(g.a(this.vQT)))
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), g.a(this.vQT) });
          label147:
          paramMenuItem = g.b(this.vQT).uAh;
          if (paramMenuItem == null) {
            break label306;
          }
          y.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { g.a(this.vQT), g.c(this.vQT), g.b(this.vQT).field_username, Long.valueOf(paramMenuItem.field_msgId), paramMenuItem.field_content, Long.valueOf(paramMenuItem.field_createTime) });
        }
        for (;;)
        {
          c.a(g.a(this.vQT), g.c(this.vQT), g.b(this.vQT), null, true, false);
          paramInt = 1;
          break;
          com.tencent.mm.plugin.report.service.h.nFQ.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), g.a(this.vQT) });
          break label147;
          label306:
          y.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { g.a(this.vQT), g.c(this.vQT), g.b(this.vQT).field_username });
        }
        y.d("MicroMsg.ConversationClickListener", "placed to the top");
        s.t(g.a(this.vQT), true);
        au.Hx();
        paramMenuItem = com.tencent.mm.model.c.Fw().abl(g.a(this.vQT));
        if ((paramMenuItem != null) && (paramMenuItem.cua())) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
        }
        com.tencent.mm.ui.base.h.bC(g.c(this.vQT), g.c(this.vQT).getString(R.l.main_conversation_placedtop_tips));
        com.tencent.mm.modelstat.b.eBD.c(true, g.a(this.vQT), true);
        continue;
        y.d("MicroMsg.ConversationClickListener", "unplaced to the top");
        s.u(g.a(this.vQT), true);
        au.Hx();
        paramMenuItem = com.tencent.mm.model.c.Fw().abl(g.a(this.vQT));
        if ((paramMenuItem != null) && (paramMenuItem.cua())) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
        }
        com.tencent.mm.ui.base.h.bC(g.c(this.vQT), g.c(this.vQT).getString(R.l.main_conversation_unplacedtop_tips));
        com.tencent.mm.modelstat.b.eBD.c(true, g.a(this.vQT), false);
        paramInt = 5;
        continue;
        y.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { g.a(this.vQT) });
        au.Hx();
        com.tencent.mm.model.c.FB().abx(g.a(this.vQT));
        MMAppMgr.cancelNotification(g.a(this.vQT));
        z.T(g.a(this.vQT), 1);
        com.tencent.mm.modelstat.b.eBD.N(g.a(this.vQT), false);
        paramInt = 3;
        continue;
        y.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { g.a(this.vQT) });
        au.Hx();
        com.tencent.mm.model.c.FB().abz(g.a(this.vQT));
        com.tencent.mm.modelstat.b.eBD.N(g.a(this.vQT), true);
        paramInt = 2;
        continue;
        y.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { g.a(this.vQT) });
        s.fn(g.a(this.vQT));
        paramMenuItem = g.a(this.vQT);
        Activity localActivity = g.c(this.vQT);
        PBool localPBool = new PBool();
        localPBool.value = false;
        localActivity.getString(R.l.app_tip);
        com.tencent.mm.model.bd.a(paramMenuItem, new c.6(localPBool, com.tencent.mm.ui.base.h.b(localActivity, localActivity.getString(R.l.app_waiting), true, new c.5(localPBool))));
        paramInt = -1;
      }
      y.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { g.a(this.vQT) });
      au.Hx();
      paramMenuItem = com.tencent.mm.model.c.Fw().abl(g.a(this.vQT));
      com.tencent.mm.ui.tools.b.a(f.kX(g.a(this.vQT)), g.c(this.vQT), paramMenuItem, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g.1
 * JD-Core Version:    0.7.0.1
 */