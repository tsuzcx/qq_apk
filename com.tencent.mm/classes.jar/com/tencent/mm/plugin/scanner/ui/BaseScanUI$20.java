package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class BaseScanUI$20
  implements MenuItem.OnMenuItemClickListener
{
  BaseScanUI$20(BaseScanUI paramBaseScanUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(138478);
    paramMenuItem = new d(this.qwI.getContext(), 1, false);
    paramMenuItem.sao = new BaseScanUI.20.1(this);
    paramMenuItem.sap = new BaseScanUI.20.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(138478);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.20
 * JD-Core Version:    0.7.0.1
 */