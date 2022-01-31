package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class n$a
{
  public static Bundle X(Bundle paramBundle)
  {
    boolean bool = true;
    int i = paramBundle.getInt("key_action", -1);
    Bundle localBundle = new Bundle();
    if (!g.DN().Dc())
    {
      y.w("MicroMsg.WebViewUIBagHelper", "MM doBagLogic not ready");
      return localBundle;
    }
    y.i("MicroMsg.WebViewUIBagHelper", "MM doBagLogic action:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      ai.d(new n.a.1(i, paramBundle));
    }
    for (;;)
    {
      return localBundle;
      paramBundle = paramBundle.getString("key_bag_id");
      l locall = l.rss;
      y.i("MicroMsg.WebViewBagMgr", "hasBagOfThePage targetId:%s currentId:%s", new Object[] { paramBundle, locall.rsw.id });
      if ((!bk.bl(locall.rsw.url)) && (bk.pm(paramBundle).equals(locall.rsw.id))) {}
      for (;;)
      {
        localBundle.putBoolean("key_has_bag", bool);
        break;
        bool = false;
      }
      locall = l.rss;
      bool = paramBundle.getBoolean("key_in_webviewui_from_bag", false);
      y.i("MicroMsg.WebViewBagMgr", "markInWebViewUIFromBag inWebViewUIFromBag:%b", new Object[] { Boolean.valueOf(bool) });
      locall.rsv = bool;
      continue;
      paramBundle = l.rss;
      localBundle.putParcelable("key_current_bag_pos", new Point(paramBundle.rsw.rsC, paramBundle.rsw.rsB));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n.a
 * JD-Core Version:    0.7.0.1
 */