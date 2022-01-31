package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.b;

final class ReadMailUI$14
  implements MenuItem.OnMenuItemClickListener
{
  ReadMailUI$14(ReadMailUI paramReadMailUI, WebView.b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68438);
    String str = this.pPe.mExtra;
    paramMenuItem = str;
    if (str.contains("qqmail.weixin.qq.com"))
    {
      paramMenuItem = str;
      if (!str.contains("qqmail.weixin.qq.com:443")) {
        paramMenuItem = str.replace("qqmail.weixin.qq.com", "qqmail.weixin.qq.com:443");
      }
    }
    paramMenuItem = paramMenuItem.replaceFirst("%p2p0", "%25p2p0");
    try
    {
      bool = ((Boolean)new ReadMailProxy(ReadMailUI.l(this.pOX), null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
      u.a(this.pOX, paramMenuItem, b.dYg().getCookie(v.cdK()), bool);
      AppMethodBeat.o(68438);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[] { localException.getMessage() });
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.14
 * JD-Core Version:    0.7.0.1
 */