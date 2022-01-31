package com.tencent.mm.plugin.webview.ui.tools;

import android.content.SharedPreferences;
import com.tencent.mm.h.a.pj;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$ac$22
  implements Runnable
{
  WebViewUI$ac$22(WebViewUI.ac paramac) {}
  
  public final void run()
  {
    if (this.rqr.rpH.niQ != null)
    {
      b.mGK.a(this.rqr.rpH.niQ, pj.class);
      if (this.rqr.rpH.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false))
      {
        y.i("MicroMsg.WebViewUI", "on service click, test");
        a.udP.m(new pj());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.22
 * JD-Core Version:    0.7.0.1
 */