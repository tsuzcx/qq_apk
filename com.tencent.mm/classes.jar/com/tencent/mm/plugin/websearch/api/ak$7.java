package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.t;
import java.io.File;
import java.util.List;

final class ak$7
  implements Runnable
{
  ak$7(ak paramak, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(124197);
    localak = this.uJV;
    Object localObject2 = this.val$url;
    for (;;)
    {
      try
      {
        ab.i(localak.TAG, "preLoadWebView cached webview size %d", new Object[] { Integer.valueOf(localak.uJT.size()) });
        if (localak.uJT.size() <= 0)
        {
          localak.uJU = System.currentTimeMillis();
          localObject1 = localak.aYh();
          if (localObject1 != null) {
            continue;
          }
          ab.w(localak.TAG, "create webview fail");
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        ab.printErrStackTrace(localak.TAG, localException, "", new Object[0]);
        continue;
      }
      this.uJV.done();
      AppMethodBeat.o(124197);
      return;
      localak.uJS = false;
      ab.i(localak.TAG, "preload %s", new Object[] { ((MMWebView)localObject1).toString() });
      ((MMWebView)localObject1).setPreload(true);
      ((MMWebView)localObject1).setRandomStr(bo.Ng(16));
      ((MMWebView)localObject1).getSettings().setJavaScriptEnabled(true);
      ((MMWebView)localObject1).getSettings().setPluginsEnabled(true);
      ((MMWebView)localObject1).getSettings().dYx();
      ((MMWebView)localObject1).getSettings().setBuiltInZoomControls(false);
      ((MMWebView)localObject1).getSettings().setUseWideViewPort(true);
      ((MMWebView)localObject1).getSettings().setLoadWithOverviewMode(true);
      ((MMWebView)localObject1).getSettings().dYs();
      ((MMWebView)localObject1).getSettings().dYr();
      ((MMWebView)localObject1).getSettings().setGeolocationEnabled(true);
      ((MMWebView)localObject1).getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
      ((MMWebView)localObject1).getSettings().dYz();
      ((MMWebView)localObject1).getSettings().dYv();
      ((MMWebView)localObject1).getSettings().setAppCachePath(((MMWebView)localObject1).getContext().getDir("webviewcache", 0).getAbsolutePath());
      ((MMWebView)localObject1).getSettings().dYu();
      ((MMWebView)localObject1).getSettings().dYw();
      ((MMWebView)localObject1).getSettings().setDatabasePath(e.eQu + "databases/");
      b.dYg().dYh();
      b.dYg().f((WebView)localObject1);
      localObject3 = u.bD(((MMWebView)localObject1).getContext(), ((MMWebView)localObject1).getSettings().getUserAgentString());
      ((MMWebView)localObject1).getSettings().setUserAgentString((String)localObject3);
      localObject3 = new ah();
      ((MMWebView)localObject1).addJavascriptInterface(localObject3, "__wx");
      ((MMWebView)localObject1).loadUrl((String)localObject2);
      ((MMWebView)localObject1).setWebViewClient(new ak.2(localak, (MMWebView)localObject1));
      localObject2 = Uri.parse((String)localObject2);
      localObject1 = new al(localObject1, ((Uri)localObject2).getQueryParameter("sessionId"), ((Uri)localObject2).getQueryParameter("subSessionId"), (ah)localObject3);
      localak.uJT.add(localObject1);
      h.qsU.e(15005, new Object[] { Integer.valueOf(localak.uJR), Integer.valueOf(1), Integer.valueOf(0) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak.7
 * JD-Core Version:    0.7.0.1
 */