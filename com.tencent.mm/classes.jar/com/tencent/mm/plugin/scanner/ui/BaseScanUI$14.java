package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.ui.base.u.i;

final class BaseScanUI$14
  implements u.i
{
  BaseScanUI$14(BaseScanUI paramBaseScanUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(314579);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(314579);
      return;
      paramMenuItem = this.OYm;
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramMenuItem.getString(l.i.find_friends_by_qrcode));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("com.tencent.mm.ui.ShortCutDispatchAction");
      localIntent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("shortcut_is_adaptive_icon", true);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramMenuItem, l.e.scan_shortcut_icon));
      localIntent1.putExtra("shortcut_icon_resource_id", l.e.scan_shortcut_icon);
      b.d(paramMenuItem, localIntent1, true);
      h.OAn.b(11410, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.14
 * JD-Core Version:    0.7.0.1
 */