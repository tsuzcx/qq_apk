package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;

public final class b
  implements x
{
  private static final HashSet<String> DXB;
  
  static
  {
    AppMethodBeat.i(197982);
    HashSet localHashSet = new HashSet();
    DXB = localHashSet;
    localHashSet.add("preVerifyJSAPI");
    DXB.add("openUrlWithExtraWebview");
    DXB.add("getInstallState");
    DXB.add("launchApplication");
    DXB.add("getBrandWCPayRequest");
    DXB.add("geoLocation");
    DXB.add("profile");
    DXB.add("installDownloadTask");
    DXB.add("pauseDownloadTask");
    DXB.add("addDownloadTask");
    DXB.add("addDownloadTaskStraight");
    DXB.add("resumeDownloadTask");
    DXB.add("queryDownloadTask");
    DXB.add("addContact");
    DXB.add("quicklyAddBrandContact");
    AppMethodBeat.o(197982);
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(197978);
    paramMMWebView = new h(paramMMWebView, new ay(), new BaseWebViewController.c((byte)0), DXB);
    AppMethodBeat.o(197978);
    return paramMMWebView;
  }
  
  public final boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(197981);
    boolean bool = new a().d(paramActivity, paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(197981);
    return bool;
  }
  
  public final f b(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(197979);
    try
    {
      if ((paramMMWebView instanceof MMWebViewWithJsApi))
      {
        paramMMWebView = ((MMWebViewWithJsApi)paramMMWebView).getJsapi();
        AppMethodBeat.o(197979);
        return paramMMWebView;
      }
    }
    catch (Throwable paramMMWebView)
    {
      AppMethodBeat.o(197979);
    }
    return null;
  }
  
  public final void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(197980);
    new a().c(paramActivity, paramString);
    AppMethodBeat.o(197980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b
 * JD-Core Version:    0.7.0.1
 */