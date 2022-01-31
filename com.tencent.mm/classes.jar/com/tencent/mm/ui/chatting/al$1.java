package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class al$1
  implements n.d
{
  al$1(String paramString, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31010);
    paramMenuItem = paramMenuItem.getTitle();
    ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[] { paramMenuItem, this.fOX });
    com.tencent.mm.modelmulti.h localh = new com.tencent.mm.modelmulti.h(paramMenuItem, this.fOX, t.oF(paramMenuItem));
    aw.Rc().a(localh, 0);
    com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(1), Integer.valueOf(1), paramMenuItem });
    com.tencent.mm.ui.base.h.bO(this.val$context, this.val$context.getString(2131297064));
    AppMethodBeat.o(31010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.1
 * JD-Core Version:    0.7.0.1
 */