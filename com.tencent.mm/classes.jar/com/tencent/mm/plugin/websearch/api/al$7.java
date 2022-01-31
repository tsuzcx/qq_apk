package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.n;
import java.io.File;
import java.util.List;

final class al$7
  implements Runnable
{
  al$7(al paramal, String paramString) {}
  
  public final void run()
  {
    localal = this.qUL;
    Object localObject2 = this.val$url;
    for (;;)
    {
      try
      {
        y.i(localal.TAG, "preLoadWebView cached webview size %d", new Object[] { Integer.valueOf(localal.qUJ.size()) });
        if (localal.qUJ.size() <= 0)
        {
          localal.qUK = System.currentTimeMillis();
          localObject1 = localal.bZI();
          if (localObject1 != null) {
            continue;
          }
          y.w(localal.TAG, "create webview fail");
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        y.printErrStackTrace(localal.TAG, localException, "", new Object[0]);
        continue;
      }
      this.qUL.done();
      return;
      localal.qUI = false;
      y.i(localal.TAG, "preload %s", new Object[] { ((MMWebView)localObject1).toString() });
      ((MMWebView)localObject1).setPreload(true);
      ((MMWebView)localObject1).setRandomStr(bk.Fe(16));
      ((MMWebView)localObject1).getSettings().setJavaScriptEnabled(true);
      ((MMWebView)localObject1).getSettings().setPluginsEnabled(true);
      ((MMWebView)localObject1).getSettings().cSs();
      ((MMWebView)localObject1).getSettings().setBuiltInZoomControls(false);
      ((MMWebView)localObject1).getSettings().setUseWideViewPort(true);
      ((MMWebView)localObject1).getSettings().setLoadWithOverviewMode(true);
      ((MMWebView)localObject1).getSettings().cSn();
      ((MMWebView)localObject1).getSettings().cSm();
      ((MMWebView)localObject1).getSettings().setGeolocationEnabled(true);
      ((MMWebView)localObject1).getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
      ((MMWebView)localObject1).getSettings().cSu();
      ((MMWebView)localObject1).getSettings().cSq();
      ((MMWebView)localObject1).getSettings().setAppCachePath(((MMWebView)localObject1).getContext().getDir("webviewcache", 0).getAbsolutePath());
      ((MMWebView)localObject1).getSettings().cSp();
      ((MMWebView)localObject1).getSettings().cSr();
      ((MMWebView)localObject1).getSettings().setDatabasePath(e.dOO + "databases/");
      b.cSe().cSf();
      b.cSe().c((WebView)localObject1);
      localObject3 = aj.aX(((MMWebView)localObject1).getContext(), ((MMWebView)localObject1).getSettings().getUserAgentString());
      ((MMWebView)localObject1).getSettings().setUserAgentString((String)localObject3);
      localObject3 = new ah();
      ((MMWebView)localObject1).addJavascriptInterface(localObject3, "__wx");
      ((MMWebView)localObject1).loadUrl((String)localObject2);
      ((MMWebView)localObject1).setWebViewClient(new al.2(localal, (MMWebView)localObject1));
      localObject2 = Uri.parse((String)localObject2);
      localObject1 = new am(localObject1, ((Uri)localObject2).getQueryParameter("sessionId"), ((Uri)localObject2).getQueryParameter("subSessionId"), (ah)localObject3);
      localal.qUJ.add(localObject1);
      h.nFQ.f(15005, new Object[] { Integer.valueOf(localal.qUH), Integer.valueOf(1), Integer.valueOf(0) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al.7
 * JD-Core Version:    0.7.0.1
 */