package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;

final class al$4
  implements n.d
{
  al$4(bi parambi, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31013);
    paramMenuItem = paramMenuItem.getTitle();
    if (bo.isNullOrNil(this.fkH.field_imgPath))
    {
      ab.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
      AppMethodBeat.o(31013);
      return;
    }
    Object localObject = s.vT(this.fkH.field_imgPath);
    String str = this.fkH.field_imgPath;
    if (localObject == null) {}
    for (paramInt = 0;; paramInt = ((r)localObject).gaD)
    {
      localObject = s.i(paramMenuItem, str, paramInt);
      ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[] { paramMenuItem, localObject });
      localObject = new f((String)localObject, 1);
      aw.Rc().a((m)localObject, 0);
      com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(34), Integer.valueOf(2), paramMenuItem });
      com.tencent.mm.ui.base.h.bO(this.val$context, this.val$context.getString(2131297064));
      AppMethodBeat.o(31013);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.4
 * JD-Core Version:    0.7.0.1
 */