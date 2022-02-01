package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.d;

final class al$1
  implements n.d
{
  al$1(String paramString, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(34896);
    paramMenuItem = paramMenuItem.getTitle();
    ad.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", new Object[] { paramMenuItem, this.hrB });
    i locali = new i(paramMenuItem, this.hrB, w.tq(paramMenuItem), 0);
    az.aeS().a(locali, 0);
    com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(1), Integer.valueOf(1), paramMenuItem });
    com.tencent.mm.ui.base.h.cf(this.val$context, this.val$context.getString(2131755881));
    AppMethodBeat.o(34896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.1
 * JD-Core Version:    0.7.0.1
 */