package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;

final class al$9
  implements n.d
{
  al$9(bi parambi, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31018);
    String str = paramMenuItem.getTitle();
    paramMenuItem = ap.arZ(this.fkH.field_content).cqq;
    if ((paramMenuItem == null) || (paramMenuItem.endsWith("-1"))) {
      paramMenuItem = this.fkH.field_imgPath;
    }
    for (;;)
    {
      if (paramMenuItem == null)
      {
        ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
        AppMethodBeat.o(31018);
        return;
      }
      ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", new Object[] { str, paramMenuItem });
      if (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(this.val$context, str, paramMenuItem))
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
        com.tencent.mm.ui.base.h.bO(this.val$context, "");
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(47), Integer.valueOf(64), str });
      com.tencent.mm.ui.base.h.bO(this.val$context, this.val$context.getString(2131297064));
      AppMethodBeat.o(31018);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.9
 * JD-Core Version:    0.7.0.1
 */