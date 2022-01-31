package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.base.n.d;

final class ao$8
  implements n.d
{
  ao$8(String paramString, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    int i = 66;
    paramMenuItem = paramMenuItem.getTitle();
    y.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramMenuItem, this.vmX });
    bi.a locala = bi.a.abZ(this.vmX);
    Object localObject = this.vmX;
    if (ad.aaU(locala.pyp))
    {
      paramInt = 66;
      localObject = new com.tencent.mm.modelmulti.h(paramMenuItem, (String)localObject, paramInt);
      au.Dk().a((m)localObject, 0);
      localObject = com.tencent.mm.plugin.report.service.h.nFQ;
      if (!ad.aaU(locala.pyp)) {
        break label171;
      }
    }
    label171:
    for (paramInt = i;; paramInt = 42)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(10424, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(32), paramMenuItem });
      com.tencent.mm.ui.base.h.bC(this.val$context, this.val$context.getString(R.l.app_saved));
      return;
      paramInt = 42;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao.8
 * JD-Core Version:    0.7.0.1
 */