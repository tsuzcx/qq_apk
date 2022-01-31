package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.b;

final class BizConversationUI$BizConversationFmUI$9
  implements n.d
{
  BizConversationUI$BizConversationFmUI$9(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(34125);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34125);
      return;
      aw.aaz();
      paramMenuItem = c.YA().arw(BizConversationUI.BizConversationFmUI.n(this.Ahf));
      if (paramMenuItem == null)
      {
        ab.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationUI.BizConversationFmUI.n(this.Ahf));
        AppMethodBeat.o(34125);
        return;
      }
      if (paramMenuItem.Oa())
      {
        h.qsU.e(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
        t.y(BizConversationUI.BizConversationFmUI.n(this.Ahf), true);
        AppMethodBeat.o(34125);
        return;
      }
      h.qsU.e(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
      t.x(BizConversationUI.BizConversationFmUI.n(this.Ahf), true);
      AppMethodBeat.o(34125);
      return;
      aw.aaz();
      paramMenuItem = c.YA().arw(BizConversationUI.BizConversationFmUI.n(this.Ahf));
      b.a(z.afi().rK(BizConversationUI.BizConversationFmUI.n(this.Ahf)), this.Ahf.thisActivity(), paramMenuItem, 2);
      AppMethodBeat.o(34125);
      return;
      BizConversationUI.BizConversationFmUI.b(this.Ahf, BizConversationUI.BizConversationFmUI.n(this.Ahf));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.9
 * JD-Core Version:    0.7.0.1
 */