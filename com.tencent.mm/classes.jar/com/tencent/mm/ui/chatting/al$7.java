package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class al$7
  implements n.d
{
  al$7(String paramString, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31016);
    paramMenuItem = paramMenuItem.getTitle();
    ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramMenuItem, this.zCs });
    com.tencent.mm.modelmulti.h localh = new com.tencent.mm.modelmulti.h(paramMenuItem, this.zCs, 48);
    aw.Rc().a(localh, 0);
    com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(48), Integer.valueOf(16), paramMenuItem });
    com.tencent.mm.ui.base.h.bO(this.val$context, this.val$context.getString(2131297064));
    AppMethodBeat.o(31016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.7
 * JD-Core Version:    0.7.0.1
 */