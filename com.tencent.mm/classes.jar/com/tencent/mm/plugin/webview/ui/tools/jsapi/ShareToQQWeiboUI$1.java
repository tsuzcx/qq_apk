package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareToQQWeiboUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ShareToQQWeiboUI$1(ShareToQQWeiboUI paramShareToQQWeiboUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(9840);
    this.vsf.hideVKB();
    this.vsf.finish();
    AppMethodBeat.o(9840);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI.1
 * JD-Core Version:    0.7.0.1
 */