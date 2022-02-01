package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.base.o.g;

final class BaseScanUI$4
  implements o.g
{
  BaseScanUI$4(BaseScanUI paramBaseScanUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(240719);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(240719);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("preview_ui_title", 2131764988);
      s.c(this.CJV, 4660, paramMenuItem);
      AppMethodBeat.o(240719);
      return;
      paramMenuItem = this.CJV;
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramMenuItem.getString(2131759428));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
      localIntent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
      localIntent2.addFlags(67108864);
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("shortcut_is_adaptive_icon", true);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramMenuItem, 2131234728));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131234728);
      b.o(paramMenuItem, localIntent1);
      h.CyF.a(11410, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.4
 * JD-Core Version:    0.7.0.1
 */