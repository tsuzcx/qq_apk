package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.jsapi.g;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.k.m;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;

public final class p
  implements ab
{
  private static final HashSet<String> Wvz;
  
  static
  {
    AppMethodBeat.i(294791);
    HashSet localHashSet = new HashSet();
    Wvz = localHashSet;
    localHashSet.add("preVerifyJSAPI");
    Wvz.add("openUrlWithExtraWebview");
    Wvz.add("getInstallState");
    Wvz.add("launchApplication");
    Wvz.add("getBrandWCPayRequest");
    Wvz.add("geoLocation");
    Wvz.add("profile");
    Wvz.add("installDownloadTask");
    Wvz.add("pauseDownloadTask");
    Wvz.add("addDownloadTask");
    Wvz.add("addDownloadTaskStraight");
    Wvz.add("resumeDownloadTask");
    Wvz.add("queryDownloadTask");
    Wvz.add("addContact");
    Wvz.add("quicklyAddBrandContact");
    Wvz.add("requestBindPhoneNumber");
    Wvz.add("openWeApp");
    Wvz.add("checkJsApi");
    Wvz.add("getNetworkType");
    AppMethodBeat.o(294791);
  }
  
  public final int a(Context paramContext, e parame, String paramString)
  {
    AppMethodBeat.i(294823);
    int i = m.a(paramContext, parame, paramString);
    AppMethodBeat.o(294823);
    return i;
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(294796);
    BaseWebViewController.d locald = new BaseWebViewController.d();
    locald.WxF = 69;
    paramMMWebView = new k(paramMMWebView, new ba(), locald, Wvz, null);
    AppMethodBeat.o(294796);
    return paramMMWebView;
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView, BaseWebViewController.d paramd, g paramg)
  {
    AppMethodBeat.i(294797);
    paramMMWebView = new k(paramMMWebView, new ba(), paramd, null, paramg);
    AppMethodBeat.o(294797);
    return paramMMWebView;
  }
  
  public final boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(294818);
    boolean bool = new a().d(paramActivity, paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(294818);
    return bool;
  }
  
  public final j b(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(294807);
    try
    {
      if ((paramMMWebView instanceof MMWebViewWithJsApi))
      {
        paramMMWebView = ((MMWebViewWithJsApi)paramMMWebView).getJsapi();
        return paramMMWebView;
      }
    }
    finally
    {
      AppMethodBeat.o(294807);
    }
    return null;
  }
  
  public final void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(294814);
    new a().c(paramActivity, paramString);
    AppMethodBeat.o(294814);
  }
  
  public final String hW(String paramString)
  {
    AppMethodBeat.i(294833);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(294833);
      return null;
    }
    String str1 = WeChatHosts.domainString(c.i.host_mp_weixin_qq_com);
    paramString = Uri.parse(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(294833);
      return null;
    }
    if (!Util.isEqual(paramString.getHost(), str1))
    {
      AppMethodBeat.o(294833);
      return null;
    }
    str1 = Util.nullAs(paramString.getQueryParameter("__biz"), "");
    String str2 = Util.nullAs(paramString.getQueryParameter("mid"), "");
    paramString = Util.nullAs(paramString.getQueryParameter("idx"), "");
    if ((str1.length() > 0) && (str2.length() > 0) && (paramString.length() > 0))
    {
      paramString = Util.safeFormatString("id://local/i.html?__biz=%s&mid=%s&idx=%s", new Object[] { str1, str2, paramString });
      AppMethodBeat.o(294833);
      return paramString;
    }
    AppMethodBeat.o(294833);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.p
 * JD-Core Version:    0.7.0.1
 */