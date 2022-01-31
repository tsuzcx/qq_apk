package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class n$a$1
  implements Runnable
{
  n$a$1(int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    switch (this.byD)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    case 1: 
      String str1 = this.byv.getString("key_url");
      String str2 = this.byv.getString("key_bag_icon");
      int i = this.byv.getInt("key_scene", 0);
      boolean bool = this.byv.getBoolean("key_from_bag", false);
      Bundle localBundle = this.byv.getBundle("key_extras");
      l locall = l.rss;
      if (!b.bg(ae.getContext()))
      {
        y.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
        Context localContext = ae.getContext();
        RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(R.l.webview_bag_no_float_window_permission_alert), new l.1(locall, str1, i, str2, localBundle, bool));
        return;
      }
      locall.a(str1, i, str2, localBundle, bool);
      locall.lq(false);
      return;
    case 2: 
      l.rss.ccW();
      return;
    case 3: 
      l.rss.lp(false);
      return;
    case 4: 
      l.rss.cfb();
      return;
    }
    float f = this.byv.getFloat("key_alpha", 1.0F);
    l.rss.aK(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n.a.1
 * JD-Core Version:    0.7.0.1
 */