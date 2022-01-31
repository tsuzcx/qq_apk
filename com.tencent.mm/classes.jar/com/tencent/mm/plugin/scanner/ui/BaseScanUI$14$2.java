package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI;
import com.tencent.mm.ui.base.n.d;

final class BaseScanUI$14$2
  implements n.d
{
  BaseScanUI$14$2(BaseScanUI.14 param14) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return;
        paramMenuItem = this.nJl.nJg;
        Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramMenuItem.getString(R.l.find_friends_by_qrcode));
        localIntent1.putExtra("duplicate", false);
        Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        localIntent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
        localIntent2.addFlags(67108864);
        localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
        localIntent1.putExtra("shortcut_is_adaptive_icon", true);
        localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramMenuItem, R.g.scan_shortcut_icon));
        localIntent1.putExtra("shortcut_icon_resource_id", R.g.scan_shortcut_icon);
        b.m(paramMenuItem, localIntent1);
        h.nFQ.f(11410, new Object[0]);
        return;
      } while (this.nJl.nJk == null);
      this.nJl.nJk.onClick(null);
      return;
    }
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.nJl.nJg, ScannerHistoryUI.class);
    this.nJl.nJg.startActivity(paramMenuItem);
    h.nFQ.f(12684, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.14.2
 * JD-Core Version:    0.7.0.1
 */