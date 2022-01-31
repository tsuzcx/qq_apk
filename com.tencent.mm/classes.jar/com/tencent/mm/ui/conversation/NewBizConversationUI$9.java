package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(34541);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34541);
      return;
      aw.aaz();
      paramMenuItem = c.YA().arw(NewBizConversationUI.n(this.AlC));
      if (paramMenuItem == null)
      {
        ab.e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.n(this.AlC));
        AppMethodBeat.o(34541);
        return;
      }
      if (paramMenuItem.Oa())
      {
        h.qsU.e(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
        t.y(NewBizConversationUI.n(this.AlC), true);
      }
      for (;;)
      {
        ai localai = new ai();
        localai.cns.userName = paramMenuItem.field_username;
        a.ymk.l(localai);
        AppMethodBeat.o(34541);
        return;
        h.qsU.e(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        t.x(NewBizConversationUI.n(this.AlC), true);
      }
      aw.aaz();
      paramMenuItem = c.YA().arw(NewBizConversationUI.n(this.AlC));
      b.a(z.afi().rK(NewBizConversationUI.n(this.AlC)), this.AlC, paramMenuItem, 2);
      AppMethodBeat.o(34541);
      return;
      NewBizConversationUI.b(this.AlC, NewBizConversationUI.n(this.AlC));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.9
 * JD-Core Version:    0.7.0.1
 */