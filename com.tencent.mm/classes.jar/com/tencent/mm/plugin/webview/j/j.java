package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
{
  private static Pattern EtH = null;
  private static String EtI = null;
  private static Boolean EtJ = null;
  
  public static boolean aJD(String paramString)
  {
    AppMethodBeat.i(214007);
    if ((WebView.isX5()) && (aJE(paramString)) && (!"true".equals(a.mV("disable_apk_hook", "tools"))))
    {
      AppMethodBeat.o(214007);
      return true;
    }
    AppMethodBeat.o(214007);
    return false;
  }
  
  private static boolean aJE(String paramString)
  {
    AppMethodBeat.i(82385);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(82385);
      return false;
    }
    try
    {
      paramString = Uri.parse(paramString).getPathSegments();
      if (paramString != null)
      {
        int i = paramString.size();
        if (i > 0) {}
      }
      else
      {
        AppMethodBeat.o(82385);
        return false;
      }
      paramString = (String)paramString.get(paramString.size() - 1);
      if (paramString != null)
      {
        boolean bool = paramString.toLowerCase().trim().endsWith(".apk");
        if (bool)
        {
          AppMethodBeat.o(82385);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(82385);
    }
    return false;
  }
  
  public static boolean aJF(String paramString)
  {
    AppMethodBeat.i(82386);
    boolean bool;
    if ((EtJ != null) && (bt.lQ(paramString, EtI)))
    {
      bool = EtJ.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
    }
    EtI = paramString;
    if (Pattern.compile("^(http|https)://mp.weixin.qq.com/(s|mp/author|mp/appmsg/show)", 2).matcher(paramString).find()) {
      bool = true;
    }
    for (;;)
    {
      paramString = Boolean.valueOf(bool);
      EtJ = paramString;
      bool = paramString.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
      if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?open.weixin.qq.com/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(paramString).find())
      {
        bool = true;
      }
      else
      {
        if (EtH == null)
        {
          String str = ((b)g.ab(b.class)).a(b.a.qtN, "^(http|https)://mp.weixin.qq.com/mp/(readtemplate\\?t=scanlogin/index_tmpl|scanlogin\\?action=index|relatedarticle\\?action=page|aboutbiz|infringement|qa)");
          ad.i("MicroMsg.WebViewUIUtil", "mpHosts=:%s", new Object[] { str });
          EtH = Pattern.compile(str);
        }
        if ((EtH != null) && (EtH.matcher(paramString).find())) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static void g(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(214006);
    if (paramMMWebView == null)
    {
      AppMethodBeat.o(214006);
      return;
    }
    if (paramMMWebView.getIsX5Kernel())
    {
      AppMethodBeat.o(214006);
      return;
    }
    if (d.ly(19))
    {
      AppMethodBeat.o(214006);
      return;
    }
    try
    {
      paramMMWebView = new c(paramMMWebView, "mSysWebView", null).get();
      ad.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mProvider", null).get();
      ad.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mWebViewCore", null).get();
      ad.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "sWebCoreHandler", null).get();
      ad.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mLooper", null).get();
      ad.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mThread", null).get();
      ad.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramMMWebView });
      if ((paramMMWebView instanceof Thread))
      {
        paramMMWebView = (Thread)paramMMWebView;
        ad.i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramMMWebView.getState() });
        if (paramMMWebView.getState() == Thread.State.WAITING) {
          paramMMWebView.interrupt();
        }
      }
      AppMethodBeat.o(214006);
      return;
    }
    catch (Exception paramMMWebView)
    {
      ad.e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(214006);
    }
  }
  
  public static void h(String paramString, Context paramContext)
  {
    AppMethodBeat.i(82384);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.putString("url", paramString);
    paramContext.apply();
    AppMethodBeat.o(82384);
  }
  
  public static String he(Context paramContext)
  {
    AppMethodBeat.i(214004);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).getString("url", null);
    AppMethodBeat.o(214004);
    return paramContext;
  }
  
  public static void hf(Context paramContext)
  {
    AppMethodBeat.i(214005);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.remove("url");
    paramContext.apply();
    AppMethodBeat.o(214005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.j
 * JD-Core Version:    0.7.0.1
 */