package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;

public final class b
  implements x
{
  private static final HashSet<String> DFE;
  
  static
  {
    AppMethodBeat.i(207806);
    HashSet localHashSet = new HashSet();
    DFE = localHashSet;
    localHashSet.add("preVerifyJSAPI");
    DFE.add("openUrlWithExtraWebview");
    DFE.add("getInstallState");
    DFE.add("launchApplication");
    DFE.add("getBrandWCPayRequest");
    DFE.add("geoLocation");
    DFE.add("profile");
    DFE.add("installDownloadTask");
    DFE.add("pauseDownloadTask");
    DFE.add("addDownloadTask");
    DFE.add("addDownloadTaskStraight");
    DFE.add("resumeDownloadTask");
    DFE.add("queryDownloadTask");
    DFE.add("addContact");
    DFE.add("quicklyAddBrandContact");
    AppMethodBeat.o(207806);
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(207804);
    paramMMWebView = new h(paramMMWebView, new ay(), new BaseWebViewController.c((byte)0), DFE);
    AppMethodBeat.o(207804);
    return paramMMWebView;
  }
  
  public final f b(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(207805);
    try
    {
      if ((paramMMWebView instanceof MMWebViewWithJsApi))
      {
        paramMMWebView = ((MMWebViewWithJsApi)paramMMWebView).getJsapi();
        AppMethodBeat.o(207805);
        return paramMMWebView;
      }
    }
    catch (Throwable paramMMWebView)
    {
      AppMethodBeat.o(207805);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b
 * JD-Core Version:    0.7.0.1
 */