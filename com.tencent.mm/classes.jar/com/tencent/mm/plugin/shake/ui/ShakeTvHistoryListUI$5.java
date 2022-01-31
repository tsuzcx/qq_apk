package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class ShakeTvHistoryListUI$5
  implements n.d
{
  ShakeTvHistoryListUI$5(ShakeTvHistoryListUI paramShakeTvHistoryListUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    }
    h.nFQ.f(12662, new Object[] { Integer.valueOf(1), bk.pm(ShakeTvHistoryListUI.d(this.odz)) });
    paramMenuItem = m.bzW();
    String str = ShakeTvHistoryListUI.d(this.odz);
    if (bk.bl(str))
    {
      paramInt = -1;
      if (paramInt >= 0) {
        break label176;
      }
      y.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      ShakeTvHistoryListUI.a(this.odz).a(null, null);
      return;
      str = "username = '" + str + "'";
      paramInt = paramMenuItem.dXw.delete(paramMenuItem.getTableName(), str, null);
      y.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = " + paramInt);
      break;
      label176:
      paramMenuItem = new c(1, ShakeTvHistoryListUI.d(this.odz));
      au.Dk().a(paramMenuItem, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.5
 * JD-Core Version:    0.7.0.1
 */