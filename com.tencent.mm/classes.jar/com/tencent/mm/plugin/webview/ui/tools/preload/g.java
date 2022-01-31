package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.plugin.webview.ui.tools.f.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.n;
import com.tencent.xweb.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class g
  extends MMWebView
{
  private p gIG = new p()
  {
    private m Uc(String paramAnonymousString)
    {
      y.i("MicroMsg.TmplWxJsWebView", "getResourceResponse, requrl:%s, url:%s", new Object[] { paramAnonymousString, g.this.rfY });
      if (paramAnonymousString.equals(g.this.rfY))
      {
        paramAnonymousString = qY(g.this.rBQ);
        if (paramAnonymousString != null)
        {
          y.i("MicroMsg.TmplWxJsWebView", "return intercepted success");
          return paramAnonymousString;
        }
        y.e("MicroMsg.TmplWxJsWebView", "return intercepted null");
        a.aa(g.this.riT.rjC, 126, 1);
        return null;
      }
      y.e("MicroMsg.TmplWxJsWebView", "return null");
      return null;
    }
    
    private static m qY(String paramAnonymousString)
    {
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(paramAnonymousString);
        if (localFileInputStream == null)
        {
          y.e("MicroMsg.TmplWxJsWebView", "stream is null, err");
          return null;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        InputStream localInputStream;
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TmplWxJsWebView", localFileNotFoundException, "", new Object[0]);
          localInputStream = null;
        }
        return new m(s.wK(paramAnonymousString), "UTF-8", localInputStream);
      }
    }
    
    public final m a(WebView paramAnonymousWebView, l paramAnonymousl)
    {
      if ((paramAnonymousl == null) || (paramAnonymousl.getUrl() == null) || (bk.bl(paramAnonymousl.getUrl().toString())))
      {
        y.e("MicroMsg.TmplWxJsWebView", "shouldInterceptRequest, url is null");
        return null;
      }
      y.v("MicroMsg.TmplWxJsWebView", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paramAnonymousl.getUrl(), paramAnonymousl.getMethod(), Boolean.valueOf(paramAnonymousl.isForMainFrame()) });
      return Uc(paramAnonymousl.getUrl().toString());
    }
    
    public final m a(WebView paramAnonymousWebView, l paramAnonymousl, Bundle paramAnonymousBundle)
    {
      if ((paramAnonymousl == null) || (paramAnonymousl.getUrl() == null) || (bk.bl(paramAnonymousl.getUrl().toString())))
      {
        y.e("MicroMsg.TmplWxJsWebView", "shouldInterceptRequest, webResourceRequest is null");
        return null;
      }
      y.v("MicroMsg.TmplWxJsWebView", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paramAnonymousl.getUrl(), paramAnonymousl.getMethod(), Boolean.valueOf(paramAnonymousl.isForMainFrame()) });
      paramAnonymousWebView = paramAnonymousl.getUrl().toString();
      y.v("MicroMsg.TmplWxJsWebView", "shouldInterceptRequest, url = %s", new Object[] { paramAnonymousWebView });
      return Uc(paramAnonymousWebView);
    }
    
    public final void a(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      y.i("MicroMsg.TmplWxJsWebView", "[onPageFinished] url:%s", new Object[] { paramAnonymousString });
      super.a(paramAnonymousWebView, paramAnonymousString);
      g.a(g.this);
      g.a(g.this, System.currentTimeMillis());
      g.this.riW = (g.b(g.this) - g.c(g.this));
      g.a(g.this, true);
      g.this.anb();
    }
    
    public final void b(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      y.i("MicroMsg.TmplWxJsWebView", "[onPageStarted] url:%s", new Object[] { paramAnonymousString });
      super.b(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      g.a(g.this, false);
    }
    
    public final m c(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if (bk.bl(paramAnonymousString))
      {
        y.i("MicroMsg.TmplWxJsWebView", "shouldInterceptRequest, url is null");
        return null;
      }
      y.v("MicroMsg.TmplWxJsWebView", "shouldInterceptRequest, url = %s", new Object[] { paramAnonymousString });
      return Uc(paramAnonymousString);
    }
  };
  boolean lgV;
  public int rBP;
  public String rBQ;
  private LinkedList<Pair<String, ValueCallback<String>>> rBR = new LinkedList();
  private long rBS;
  private long rBT;
  protected d rBU;
  public String rfY;
  public TmplParams riT;
  public long riW;
  
  public g(Context paramContext, TmplParams paramTmplParams)
  {
    super(paramContext);
    this.dyX = true;
    this.isX5Kernel = getIsX5Kernel();
    this.rfY = paramTmplParams.rfY;
    this.rBQ = paramTmplParams.rjA;
    this.rBP = paramTmplParams.version;
    this.riT = paramTmplParams;
    y.i("MicroMsg.TmplWxJsWebView", "[initParams]tmplParams:%s", new Object[] { this.riT });
    if (ae.cqV())
    {
      y.i("MicroMsg.TmplWxJsWebView", "[initWebviewCore] current process is mm");
      WebView.initWebviewCore(paramContext, wkp, "mm", null);
    }
    for (;;)
    {
      hi(paramContext);
      y.i("MicroMsg.TmplWxJsWebView", "[initWebViewSetting]");
      getSettings().setJavaScriptEnabled(true);
      getSettings().setPluginsEnabled(true);
      getSettings().cSs();
      getSettings().setBuiltInZoomControls(false);
      getSettings().setUseWideViewPort(true);
      getSettings().setLoadWithOverviewMode(true);
      getSettings().cSn();
      getSettings().cSm();
      getSettings().setGeolocationEnabled(true);
      getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
      getSettings().cSu();
      getSettings().cSq();
      getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
      getSettings().cSp();
      getSettings().cSr();
      getSettings().setDatabasePath(e.dOO + "databases/");
      b.cSe().cSf();
      b.cSe().c(this);
      paramContext = s.aX(getContext(), getSettings().getUserAgentString());
      getSettings().setUserAgentString(paramContext);
      y.i("MicroMsg.TmplWxJsWebView", "[initJsApiHandler]");
      paramContext = new com.tencent.mm.plugin.webview.ui.tools.f(JsapiPermissionWrapper.spm, GeneralControlWrapper.spk, new f.b()
      {
        public final String cdK()
        {
          return g.this.rfY;
        }
      });
      paramTmplParams = new HashMap();
      paramTmplParams.put("webview_type", "1");
      paramTmplParams.put("init_url", getUrl());
      paramTmplParams.put("init_font_size", "1");
      this.rBU = new d(this, paramContext, paramTmplParams);
      addJavascriptInterface(this.rBU, "__wx");
      boolean bool = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true);
      y.i("MicroMsg.TmplWxJsWebView", "[initJsApiHandler]enableWvSHA1:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.rBU.cfX();
        setRandomStr(this.rBU.rxJ);
      }
      setWebViewClient(this.gIG);
      return;
      if (ae.cqX())
      {
        y.i("MicroMsg.TmplWxJsWebView", "[initWebviewCore] current process is tool");
        WebView.initWebviewCore(paramContext, wkp, "tools", null);
      }
      else if (ae.cqY())
      {
        y.i("MicroMsg.TmplWxJsWebView", "[initWebviewCore] current process is toolmp");
        WebView.initWebviewCore(paramContext, wkp, "toolsmp", null);
      }
    }
  }
  
  private void cgK()
  {
    try
    {
      Iterator localIterator = this.rBR.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        super.evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
        y.v("MicroMsg.TmplWxJsWebView", "[evaluateJavascript]%s", new Object[] { localPair.first });
      }
      this.rBR.clear();
    }
    finally {}
  }
  
  protected void anb()
  {
    y.i("MicroMsg.TmplWxJsWebView", "[onPageReady]");
  }
  
  public void cgI()
  {
    y.i("MicroMsg.TmplWxJsWebView", "[loadUrlAndData] url:%s", new Object[] { this.rfY });
    this.rBS = System.currentTimeMillis();
    loadUrl(this.rfY);
  }
  
  protected void cgJ()
  {
    y.i("MicroMsg.TmplWxJsWebView", "[initJsEnvironment]");
    new com.tencent.mm.plugin.webview.ui.tools.jsapi.f(this, this.rBU, new f.a()
    {
      public final void ceI()
      {
        y.i("MicroMsg.TmplWxJsWebView", "[initJsEnvironment] onLoadedSucc");
      }
    }).cgg();
  }
  
  public void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    if (!this.lgV)
    {
      this.rBR.add(new Pair(paramString, paramValueCallback));
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        g.a(g.this, paramString, paramValueCallback);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      return;
    }
    ai.d(paramString);
  }
  
  public d getJsApiHandler()
  {
    return this.rBU;
  }
  
  public p getWebViewClient()
  {
    return this.gIG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.g
 * JD-Core Version:    0.7.0.1
 */