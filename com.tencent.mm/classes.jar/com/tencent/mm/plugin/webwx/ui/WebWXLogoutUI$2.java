package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class WebWXLogoutUI$2
  implements MenuItem.OnMenuItemClickListener
{
  WebWXLogoutUI$2(WebWXLogoutUI paramWebWXLogoutUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30214);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", o.jjL + "&lang=" + LocaleUtil.getApplicationLanguage());
    paramMenuItem.putExtra("showShare", false);
    paramMenuItem.putExtra("neverGetA8Key", false);
    c.b(this.JFH, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    AppMethodBeat.o(30214);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.2
 * JD-Core Version:    0.7.0.1
 */