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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
{
  private static Pattern EMb = null;
  private static String EMc = null;
  private static Boolean EMd = null;
  
  public static boolean aKZ(String paramString)
  {
    AppMethodBeat.i(213838);
    if ((WebView.isX5()) && (aLa(paramString)) && (!"true".equals(a.nb("disable_apk_hook", "tools"))))
    {
      AppMethodBeat.o(213838);
      return true;
    }
    AppMethodBeat.o(213838);
    return false;
  }
  
  private static boolean aLa(String paramString)
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
  
  public static boolean aLb(String paramString)
  {
    AppMethodBeat.i(82386);
    boolean bool;
    if ((EMd != null) && (bu.lX(paramString, EMc)))
    {
      bool = EMd.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
    }
    EMc = paramString;
    if (Pattern.compile("^(http|https)://mp.weixin.qq.com/(s|mp/author|mp/appmsg/show)", 2).matcher(paramString).find()) {
      bool = true;
    }
    for (;;)
    {
      paramString = Boolean.valueOf(bool);
      EMd = paramString;
      bool = paramString.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
      if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?open.weixin.qq.com/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(paramString).find())
      {
        bool = true;
      }
      else
      {
        if (EMb == null)
        {
          String str = ((b)g.ab(b.class)).a(b.a.qAB, "^(http|https)://mp.weixin.qq.com/mp/(readtemplate\\?t=scanlogin/index_tmpl|scanlogin\\?action=index|relatedarticle\\?action=page|aboutbiz|infringement|qa)");
          ae.i("MicroMsg.WebViewUIUtil", "mpHosts=:%s", new Object[] { str });
          EMb = Pattern.compile(str);
        }
        if ((EMb != null) && (EMb.matcher(paramString).find())) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static void g(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(213837);
    if (paramMMWebView == null)
    {
      AppMethodBeat.o(213837);
      return;
    }
    if (paramMMWebView.getIsX5Kernel())
    {
      AppMethodBeat.o(213837);
      return;
    }
    if (d.lA(19))
    {
      AppMethodBeat.o(213837);
      return;
    }
    try
    {
      paramMMWebView = new c(paramMMWebView, "mSysWebView", null).get();
      ae.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mProvider", null).get();
      ae.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mWebViewCore", null).get();
      ae.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "sWebCoreHandler", null).get();
      ae.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mLooper", null).get();
      ae.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mThread", null).get();
      ae.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramMMWebView });
      if ((paramMMWebView instanceof Thread))
      {
        paramMMWebView = (Thread)paramMMWebView;
        ae.i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramMMWebView.getState() });
        if (paramMMWebView.getState() == Thread.State.WAITING) {
          paramMMWebView.interrupt();
        }
      }
      AppMethodBeat.o(213837);
      return;
    }
    catch (Exception paramMMWebView)
    {
      ae.e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(213837);
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
  
  public static String hk(Context paramContext)
  {
    AppMethodBeat.i(213835);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).getString("url", null);
    AppMethodBeat.o(213835);
    return paramContext;
  }
  
  public static void hl(Context paramContext)
  {
    AppMethodBeat.i(213836);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.remove("url");
    paramContext.apply();
    AppMethodBeat.o(213836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.j
 * JD-Core Version:    0.7.0.1
 */