package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.b;

final class ReadMailUI$14
  implements MenuItem.OnMenuItemClickListener
{
  ReadMailUI$14(ReadMailUI paramReadMailUI, WebView.b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    String str = this.njR.mExtra;
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
      bool = ((Boolean)new ReadMailProxy(ReadMailUI.l(this.njK), null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
      s.a(this.njK, paramMenuItem, b.cSe().getCookie(v.btz()), bool);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[] { localException.getMessage() });
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.14
 * JD-Core Version:    0.7.0.1
 */