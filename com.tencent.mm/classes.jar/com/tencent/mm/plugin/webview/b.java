package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;

public final class b
  implements x
{
  private static final HashSet<String> AKn;
  
  static
  {
    AppMethodBeat.i(187848);
    HashSet localHashSet = new HashSet();
    AKn = localHashSet;
    localHashSet.add("preVerifyJSAPI");
    AKn.add("openUrlWithExtraWebview");
    AKn.add("getInstallState");
    AKn.add("launchApplication");
    AKn.add("getBrandWCPayRequest");
    AKn.add("geoLocation");
    AKn.add("profile");
    AKn.add("installDownloadTask");
    AKn.add("pauseDownloadTask");
    AKn.add("addDownloadTask");
    AKn.add("addDownloadTaskStraight");
    AKn.add("resumeDownloadTask");
    AKn.add("queryDownloadTask");
    AKn.add("addContact");
    AKn.add("quicklyAddBrandContact");
    AppMethodBeat.o(187848);
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(187847);
    paramMMWebView = new h(paramMMWebView, new ax(), new BaseWebViewController.c((byte)0), AKn);
    AppMethodBeat.o(187847);
    return paramMMWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b
 * JD-Core Version:    0.7.0.1
 */