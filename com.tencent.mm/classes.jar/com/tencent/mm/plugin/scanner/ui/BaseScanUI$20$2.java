package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.base.model.c.6;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI;
import com.tencent.mm.ui.base.n.d;

final class BaseScanUI$20$2
  implements n.d
{
  BaseScanUI$20$2(BaseScanUI.20 param20) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(138477);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138477);
      return;
      paramMenuItem = this.qwN.qwI;
      c.a(paramMenuItem, new c.6(paramMenuItem, this.qwN.qwI.getString(2131299908), "LauncherUI.From.Scaner.Shortcut"));
      h.qsU.e(11410, new Object[0]);
      AppMethodBeat.o(138477);
      return;
      if (this.qwN.qwM != null)
      {
        this.qwN.qwM.onClick(null);
        AppMethodBeat.o(138477);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.setClass(this.qwN.qwI, ScannerHistoryUI.class);
        this.qwN.qwI.startActivity(paramMenuItem);
        h.qsU.e(12684, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.20.2
 * JD-Core Version:    0.7.0.1
 */