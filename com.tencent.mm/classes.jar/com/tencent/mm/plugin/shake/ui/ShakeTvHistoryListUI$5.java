package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;

final class ShakeTvHistoryListUI$5
  implements n.d
{
  ShakeTvHistoryListUI$5(ShakeTvHistoryListUI paramShakeTvHistoryListUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24897);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(24897);
      return;
    }
    h.qsU.e(12662, new Object[] { Integer.valueOf(1), bo.nullAsNil(ShakeTvHistoryListUI.d(this.qRG)) });
    paramMenuItem = m.clp();
    String str = ShakeTvHistoryListUI.d(this.qRG);
    if (bo.isNullOrNil(str))
    {
      paramInt = -1;
      label93:
      if (paramInt >= 0) {
        break label185;
      }
      ab.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      ShakeTvHistoryListUI.a(this.qRG).a(null, null);
      break;
      str = "username = '" + str + "'";
      paramInt = paramMenuItem.db.delete(paramMenuItem.getTableName(), str, null);
      ab.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = ".concat(String.valueOf(paramInt)));
      break label93;
      label185:
      paramMenuItem = new c(1, ShakeTvHistoryListUI.d(this.qRG));
      aw.Rc().a(paramMenuItem, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.5
 * JD-Core Version:    0.7.0.1
 */