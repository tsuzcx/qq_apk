package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;

final class ao$9
  implements n.d
{
  ao$9(bi parambi, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    String str = paramMenuItem.getTitle();
    paramMenuItem = ap.abP(this.dUy.field_content).bIW;
    if ((paramMenuItem == null) || (paramMenuItem.endsWith("-1"))) {
      paramMenuItem = this.dUy.field_imgPath;
    }
    for (;;)
    {
      if (paramMenuItem == null)
      {
        y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
        return;
      }
      y.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", new Object[] { str, paramMenuItem });
      if (((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().m(this.val$context, str, paramMenuItem))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
        com.tencent.mm.ui.base.h.bC(this.val$context, "");
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
      com.tencent.mm.ui.base.h.bC(this.val$context, this.val$context.getString(R.l.app_saved));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao.9
 * JD-Core Version:    0.7.0.1
 */