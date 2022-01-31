package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class BaseScanUI$14
  implements MenuItem.OnMenuItemClickListener
{
  BaseScanUI$14(BaseScanUI paramBaseScanUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.nJg.mController.uMN, 1, false);
    paramMenuItem.phH = new BaseScanUI.14.1(this);
    paramMenuItem.phI = new BaseScanUI.14.2(this);
    paramMenuItem.cfU();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.14
 * JD-Core Version:    0.7.0.1
 */