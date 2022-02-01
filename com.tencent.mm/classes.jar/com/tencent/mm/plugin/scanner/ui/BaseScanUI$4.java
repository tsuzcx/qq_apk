package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.ui.base.n.e;

final class BaseScanUI$4
  implements n.e
{
  BaseScanUI$4(BaseScanUI paramBaseScanUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(189449);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189449);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("preview_ui_title", 2131762877);
      q.c(this.yGg, 4660, paramMenuItem);
      AppMethodBeat.o(189449);
      return;
      paramMenuItem = this.yGg;
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramMenuItem.getString(2131759095));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
      localIntent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
      localIntent2.addFlags(67108864);
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("shortcut_is_adaptive_icon", true);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramMenuItem, 2131233901));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131233901);
      b.o(paramMenuItem, localIntent1);
      g.yxI.f(11410, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.4
 * JD-Core Version:    0.7.0.1
 */