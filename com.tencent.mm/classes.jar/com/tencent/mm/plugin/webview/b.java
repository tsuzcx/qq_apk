package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;

public final class b
  implements x
{
  private static final HashSet<String> CcE;
  
  static
  {
    AppMethodBeat.i(188272);
    HashSet localHashSet = new HashSet();
    CcE = localHashSet;
    localHashSet.add("preVerifyJSAPI");
    CcE.add("openUrlWithExtraWebview");
    CcE.add("getInstallState");
    CcE.add("launchApplication");
    CcE.add("getBrandWCPayRequest");
    CcE.add("geoLocation");
    CcE.add("profile");
    CcE.add("installDownloadTask");
    CcE.add("pauseDownloadTask");
    CcE.add("addDownloadTask");
    CcE.add("addDownloadTaskStraight");
    CcE.add("resumeDownloadTask");
    CcE.add("queryDownloadTask");
    CcE.add("addContact");
    CcE.add("quicklyAddBrandContact");
    AppMethodBeat.o(188272);
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(188271);
    paramMMWebView = new h(paramMMWebView, new ax(), new BaseWebViewController.c((byte)0), CcE);
    AppMethodBeat.o(188271);
    return paramMMWebView;
  }
  
  public final f j(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(210022);
    try
    {
      if ((paramMMWebView instanceof MMWebViewWithJsApi))
      {
        paramMMWebView = ((MMWebViewWithJsApi)paramMMWebView).getJsapi();
        AppMethodBeat.o(210022);
        return paramMMWebView;
      }
    }
    catch (Throwable paramMMWebView)
    {
      AppMethodBeat.o(210022);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b
 * JD-Core Version:    0.7.0.1
 */