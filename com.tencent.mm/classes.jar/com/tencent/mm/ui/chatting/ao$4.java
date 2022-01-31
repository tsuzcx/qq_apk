package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;

final class ao$4
  implements n.d
{
  ao$4(bi parambi, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = paramMenuItem.getTitle();
    if (bk.bl(this.dUy.field_imgPath))
    {
      y.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
      return;
    }
    Object localObject = q.oG(this.dUy.field_imgPath);
    String str = this.dUy.field_imgPath;
    if (localObject == null) {}
    for (paramInt = 0;; paramInt = ((com.tencent.mm.modelvoice.p)localObject).eKW)
    {
      localObject = q.g(paramMenuItem, str, paramInt);
      y.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[] { paramMenuItem, localObject });
      localObject = new f((String)localObject, 1);
      au.Dk().a((m)localObject, 0);
      com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(34), Integer.valueOf(2), paramMenuItem });
      com.tencent.mm.ui.base.h.bC(this.val$context, this.val$context.getString(R.l.app_saved));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao.4
 * JD-Core Version:    0.7.0.1
 */