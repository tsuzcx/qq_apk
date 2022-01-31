package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.base.n.d;

final class al$8
  implements n.d
{
  al$8(String paramString, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    int i = 66;
    AppMethodBeat.i(31017);
    paramMenuItem = paramMenuItem.getTitle();
    ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[] { paramMenuItem, this.zCt });
    bi.a locala = bi.a.asj(this.zCt);
    Object localObject = this.zCt;
    if (ad.arf(locala.tac))
    {
      paramInt = 66;
      localObject = new com.tencent.mm.modelmulti.h(paramMenuItem, (String)localObject, paramInt);
      aw.Rc().a((m)localObject, 0);
      localObject = com.tencent.mm.plugin.report.service.h.qsU;
      if (!ad.arf(locala.tac)) {
        break label182;
      }
    }
    label182:
    for (paramInt = i;; paramInt = 42)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).e(10424, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(32), paramMenuItem });
      com.tencent.mm.ui.base.h.bO(this.val$context, this.val$context.getString(2131297064));
      AppMethodBeat.o(31017);
      return;
      paramInt = 42;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.8
 * JD-Core Version:    0.7.0.1
 */