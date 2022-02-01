package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

final class ExtDeviceWXLoginUI$5
  implements MenuItem.OnMenuItemClickListener
{
  ExtDeviceWXLoginUI$5(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(265345);
    Log.d("MicroMsg.ExtDeviceWXLoginUI", "onMenuItemClick click");
    paramMenuItem = new Intent();
    if (ExtDeviceWXLoginUI.e(this.Xxl)) {
      paramMenuItem.putExtra("title", this.Xxl.getString(R.l.gYT));
    }
    paramMenuItem.putExtra("rawUrl", ExtDeviceWXLoginUI.f(this.Xxl) + "&lang=" + LocaleUtil.getApplicationLanguage());
    paramMenuItem.putExtra("showShare", false);
    paramMenuItem.putExtra("neverGetA8Key", false);
    c.b(this.Xxl, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    AppMethodBeat.o(265345);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.5
 * JD-Core Version:    0.7.0.1
 */