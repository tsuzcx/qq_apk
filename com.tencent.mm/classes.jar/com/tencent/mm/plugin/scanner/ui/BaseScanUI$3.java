package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.ui.base.n.d;

final class BaseScanUI$3
  implements n.d
{
  BaseScanUI$3(BaseScanUI paramBaseScanUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(169961);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(169961);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("preview_ui_title", 2131762877);
      q.c(this.vRt, 4660, paramMenuItem);
      AppMethodBeat.o(169961);
      return;
      paramMenuItem = this.vRt;
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
      h.vKh.f(11410, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.3
 * JD-Core Version:    0.7.0.1
 */