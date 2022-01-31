package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class ao$7
  implements n.d
{
  ao$7(String paramString, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = paramMenuItem.getTitle();
    y.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramMenuItem, this.vmW });
    com.tencent.mm.modelmulti.h localh = new com.tencent.mm.modelmulti.h(paramMenuItem, this.vmW, 48);
    au.Dk().a(localh, 0);
    com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(48), Integer.valueOf(16), paramMenuItem });
    com.tencent.mm.ui.base.h.bC(this.val$context, this.val$context.getString(R.l.app_saved));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao.7
 * JD-Core Version:    0.7.0.1
 */