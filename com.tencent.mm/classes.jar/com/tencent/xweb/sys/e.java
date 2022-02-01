package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView.FindListener;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.ad;
import com.tencent.xweb.ae;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.i;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.h;
import com.tencent.xweb.u;
import com.tencent.xweb.util.f;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author=20001, fComment="checked", lastDate="20171020", reviewer=20001, vComment={com.jg.EType.JSEXECUTECHECK})
public final class e
  implements IWebView
{
  private boolean MrX;
  com.tencent.xweb.WebView Mud;
  a Mue;
  ac Muf;
  x Mug;
  d Muh;
  g Mui;
  long Muj;
  private b Muk;
  b Mul;
  final String Mum;
  private WebViewClient cgX;
  private WebChromeClient cgY;
  
  public e(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153725);
    this.Muj = 0L;
    this.MrX = false;
    this.cgY = new SysWebView.2(this);
    this.cgX = new WebViewClient()
    {
      public final void doUpdateVisitedHistory(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(153715);
        if (e.this.Muf != null)
        {
          e.this.Muf.b(e.this.Mud, paramAnonymousString, paramAnonymousBoolean);
          AppMethodBeat.o(153715);
          return;
        }
        super.doUpdateVisitedHistory(paramAnonymousWebView, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(153715);
      }
      
      public final void onLoadResource(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153711);
        if (e.this.Muf != null)
        {
          e.this.Muf.h(e.this.Mud, paramAnonymousString);
          AppMethodBeat.o(153711);
          return;
        }
        super.onLoadResource(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153711);
      }
      
      @TargetApi(23)
      public final void onPageCommitVisible(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153707);
        Log.i("SysWebView", "onPageCommitVisible s = ".concat(String.valueOf(paramAnonymousString)));
        if (e.this.Muf != null) {
          e.this.Muf.e(e.this.Mud, paramAnonymousString);
        }
        AppMethodBeat.o(153707);
      }
      
      public final void onPageFinished(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153710);
        Log.i("SysWebView", "onPageFinished ".concat(String.valueOf(paramAnonymousString)));
        boolean bool;
        if (e.a(e.this) != null)
        {
          b localb = e.a(e.this);
          if (e.this.Mud.getFullscreenVideoKind() == WebView.a.Mqr)
          {
            bool = true;
            localb.bb(false, bool);
          }
        }
        else
        {
          if (e.this.Muf == null) {
            break label148;
          }
          e.this.Muf.b(e.this.Mud, paramAnonymousString);
        }
        for (;;)
        {
          com.tencent.xweb.util.g.Fi(System.currentTimeMillis() - e.this.Muj);
          com.tencent.xweb.xwalk.d.a(e.this.Mud);
          com.tencent.xweb.util.g.Fj(System.currentTimeMillis() - e.this.Muj);
          h.gbL().gbR();
          AppMethodBeat.o(153710);
          return;
          bool = false;
          break;
          label148:
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        }
      }
      
      public final void onPageStarted(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(153709);
        Log.i("SysWebView", "onPageStarted ".concat(String.valueOf(paramAnonymousString)));
        if (e.this.Muf != null)
        {
          e.this.Muf.b(e.this.Mud, paramAnonymousString, paramAnonymousBitmap);
          e.this.Muj = System.currentTimeMillis();
          com.tencent.xweb.util.g.bbs(paramAnonymousString);
          com.tencent.xweb.util.g.gce();
          if (e.a(e.this) != null)
          {
            paramAnonymousWebView = e.a(e.this);
            if (e.this.Mud.getFullscreenVideoKind() != WebView.a.Mqr) {
              break label127;
            }
          }
        }
        label127:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bb(true, bool);
          AppMethodBeat.o(153709);
          return;
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          break;
        }
      }
      
      public final void onReceivedError(android.webkit.WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(153716);
        if (e.this.Muf != null) {
          e.this.Muf.a(e.this.Mud, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        for (;;)
        {
          com.tencent.xweb.util.g.gcd();
          com.tencent.xweb.util.g.gcf();
          h.gbL().gbS();
          AppMethodBeat.o(153716);
          return;
          super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void onReceivedHttpAuthRequest(android.webkit.WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(195509);
        Log.i("SysWebView", "onReceivedHttpAuthRequest host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (e.this.Muf != null)
        {
          e.this.Muf.a(e.this.Mud, new c.b(paramAnonymousHttpAuthHandler), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(195509);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousWebView, paramAnonymousHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(195509);
      }
      
      public final void onReceivedHttpError(android.webkit.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, android.webkit.WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(153718);
        Object localObject;
        com.tencent.xweb.WebView localWebView;
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject = String.valueOf(paramAnonymousWebResourceResponse.getStatusCode());
          Log.i("SysWebView", "onReceivedHttpError code:".concat(String.valueOf(localObject)));
          if (e.this.Muf == null) {
            break label168;
          }
          localObject = e.this.Muf;
          localWebView = e.this.Mud;
          paramAnonymousWebResourceRequest = new c.f(paramAnonymousWebResourceRequest);
          if (paramAnonymousWebResourceResponse != null) {
            break label102;
          }
          paramAnonymousWebView = null;
        }
        for (;;)
        {
          ((ac)localObject).a(localWebView, paramAnonymousWebResourceRequest, paramAnonymousWebView);
          AppMethodBeat.o(153718);
          return;
          localObject = "Invalid";
          break;
          label102:
          if (Build.VERSION.SDK_INT >= 21) {
            paramAnonymousWebView = new com.tencent.xweb.WebResourceResponse(paramAnonymousWebResourceResponse.getMimeType(), paramAnonymousWebResourceResponse.getEncoding(), paramAnonymousWebResourceResponse.getStatusCode(), paramAnonymousWebResourceResponse.getReasonPhrase(), paramAnonymousWebResourceResponse.getResponseHeaders(), paramAnonymousWebResourceResponse.getData());
          } else {
            paramAnonymousWebView = new com.tencent.xweb.WebResourceResponse(paramAnonymousWebResourceResponse.getMimeType(), paramAnonymousWebResourceResponse.getEncoding(), paramAnonymousWebResourceResponse.getData());
          }
        }
        label168:
        super.onReceivedHttpError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceResponse);
        AppMethodBeat.o(153718);
      }
      
      public final void onReceivedSslError(android.webkit.WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(153717);
        Log.i("SysWebView", "onReceivedSslError " + paramAnonymousSslError.getPrimaryError());
        if (e.this.Muf != null)
        {
          e.this.Muf.a(e.this.Mud, new c.a(paramAnonymousSslErrorHandler), paramAnonymousSslError);
          AppMethodBeat.o(153717);
          return;
        }
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(153717);
      }
      
      public final void onScaleChanged(android.webkit.WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(153714);
        if (e.this.Muf != null)
        {
          e.this.Muf.a(e.this.Mud, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(153714);
          return;
        }
        super.onScaleChanged(paramAnonymousWebView, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(153714);
      }
      
      public final android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        Object localObject = null;
        AppMethodBeat.i(153713);
        if (e.this.Muf != null)
        {
          c.f localf = new c.f(paramAnonymousWebResourceRequest);
          if (localf.MtV == null) {}
          for (paramAnonymousWebResourceRequest = null;; paramAnonymousWebResourceRequest = localf.MtV.getBundle())
          {
            paramAnonymousWebView = localObject;
            if (paramAnonymousWebResourceRequest != null) {
              paramAnonymousWebView = e.this.Muf.a(e.this.Mud, localf, paramAnonymousWebResourceRequest);
            }
            paramAnonymousWebResourceRequest = paramAnonymousWebView;
            if (paramAnonymousWebView == null) {
              paramAnonymousWebResourceRequest = e.this.Muf.a(e.this.Mud, localf);
            }
            paramAnonymousWebView = c.a(paramAnonymousWebResourceRequest);
            AppMethodBeat.o(153713);
            return paramAnonymousWebView;
          }
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(153713);
        return paramAnonymousWebView;
      }
      
      public final android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153712);
        if (e.this.Muf != null)
        {
          paramAnonymousWebView = c.a(e.this.Muf.c(e.this.Mud, paramAnonymousString));
          AppMethodBeat.o(153712);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153712);
        return paramAnonymousWebView;
      }
      
      @TargetApi(21)
      public final boolean shouldOverrideUrlLoading(android.webkit.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(153706);
        Log.i("SysWebView", "shouldOverrideUrlLoading " + paramAnonymousWebResourceRequest.getUrl().toString());
        if (e.this.Muf != null)
        {
          paramAnonymousWebView = new c.f(paramAnonymousWebResourceRequest);
          bool = e.this.Muf.d(e.this.Mud, paramAnonymousWebView);
          AppMethodBeat.o(153706);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(153706);
        return bool;
      }
      
      public final boolean shouldOverrideUrlLoading(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153708);
        if (com.tencent.xweb.xwalk.d.bby(paramAnonymousString))
        {
          AppMethodBeat.o(153708);
          return true;
        }
        Log.i("SysWebView", "shouldOverrideUrlLoading ".concat(String.valueOf(paramAnonymousString)));
        if (e.this.Muf != null)
        {
          bool = e.this.Muf.a(e.this.Mud, paramAnonymousString);
          AppMethodBeat.o(153708);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153708);
        return bool;
      }
    };
    this.Mum = "xwalkTempCallBack";
    this.Mud = paramWebView;
    this.Mue = new a(paramWebView.getContext());
    this.Mue.setBackgroundColor(0);
    getSettings();
    this.Muh = new d(this.Mue);
    this.Mue.setWebChromeClient(this.cgY);
    this.Mue.setWebViewClient(this.cgX);
    if (Build.VERSION.SDK_INT < 19)
    {
      this.Mul = new b();
      this.Mue.addJavascriptInterface(this.Mul, "xwalkTempCallBack");
    }
    if ((paramWebView.getContext() instanceof Activity))
    {
      bu((Activity)paramWebView.getContext());
      AppMethodBeat.o(153725);
      return;
    }
    bu(null);
    AppMethodBeat.o(153725);
  }
  
  private void bu(Activity paramActivity)
  {
    AppMethodBeat.i(153726);
    Log.i("SysWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + paramActivity);
    if (getFullscreenVideoKind() == WebView.a.Mqp)
    {
      AppMethodBeat.o(153726);
      return;
    }
    this.Muk = com.tencent.xweb.extension.video.e.a(paramActivity, this.Mud, this.Mue, com.tencent.xweb.extension.video.d.gbr());
    if (getFullscreenVideoKind() == WebView.a.Mqr) {
      this.Muk.eA(this.Mue);
    }
    AppMethodBeat.o(153726);
  }
  
  @SuppressLint({"JavascriptInterface"})
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(153750);
    this.Mue.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(153750);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(153731);
    boolean bool = this.Mue.canGoBack();
    AppMethodBeat.o(153731);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(153768);
    boolean bool = this.Mue.canGoForward();
    AppMethodBeat.o(153768);
    return bool;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(153773);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153719);
        int i = e.this.Mue.getHeight();
        Canvas localCanvas = new Canvas(Bitmap.createBitmap(e.this.Mue.getWidth(), i, Bitmap.Config.ARGB_8888));
        e.this.Mue.draw(localCanvas);
        Log.d("SysWebView", "bitmapCaptureFinished");
        AppMethodBeat.o(153719);
      }
    }).start();
    AppMethodBeat.o(153773);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(153767);
    this.Mue.clearHistory();
    AppMethodBeat.o(153767);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(153756);
    this.Mue.clearMatches();
    AppMethodBeat.o(153756);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(153740);
    this.Mue.clearSslPreferences();
    AppMethodBeat.o(153740);
  }
  
  public final void clearView()
  {
    AppMethodBeat.i(153734);
    this.Mue.clearView();
    AppMethodBeat.o(153734);
  }
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(195510);
    WebBackForwardList localWebBackForwardList = this.Mue.copyBackForwardList();
    AppMethodBeat.o(195510);
    return localWebBackForwardList;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(153735);
    this.Mue.destroy();
    AppMethodBeat.o(153735);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(153736);
    if (this.Muk != null) {
      this.Muk.zJ(paramBoolean);
    }
    AppMethodBeat.o(153736);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(153738);
    if (paramString == null)
    {
      AppMethodBeat.o(153738);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.Mue.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(153738);
      return;
    }
    if (paramValueCallback == null)
    {
      this.Mue.loadUrl(paramString);
      AppMethodBeat.o(153738);
      return;
    }
    String str = paramString;
    if (paramString.trim().startsWith("javascript:")) {
      str = paramString.replaceFirst("javascript:", "");
    }
    if (this.Mul == null)
    {
      this.Mul = new b();
      this.Mue.addJavascriptInterface(this.Mul, "xwalkTempCallBack");
    }
    b localb = this.Mul;
    if (paramValueCallback != null)
    {
      paramString = new StringBuilder();
      int i = localb.Muq;
      localb.Muq = (i + 1);
      paramString = i;
      localb.Mup.put(paramString, paramValueCallback);
    }
    for (;;)
    {
      paramString = "javascript:xwalkTempCallBack.notifyJava(" + paramString + ", " + str + ")";
      this.Mue.loadUrl(paramString);
      AppMethodBeat.o(153738);
      return;
      paramString = "";
    }
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(153758);
    this.Mue.findAllAsync(paramString);
    AppMethodBeat.o(153758);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(153757);
    this.Mue.findNext(paramBoolean);
    AppMethodBeat.o(153757);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(153760);
    String str = getVersionInfo();
    AppMethodBeat.o(153760);
    return str;
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(153742);
    int i = this.Mue.getContentHeight();
    AppMethodBeat.o(153742);
    return i;
  }
  
  public final x getCurWebChromeClient()
  {
    return this.Mug;
  }
  
  public final ac getCurWebviewClient()
  {
    return this.Muf;
  }
  
  public final com.tencent.xweb.internal.e getDefalutOpProvider()
  {
    return this.Muh;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(153766);
    WebView.a locala = com.tencent.xweb.a.bay(com.tencent.xweb.WebView.getCurStrModule());
    AppMethodBeat.o(153766);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(153754);
    WebView.HitTestResult localHitTestResult = this.Mue.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.mType = localHitTestResult.getType();
    localb.mExtra = localHitTestResult.getExtra();
    AppMethodBeat.o(153754);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195512);
    paramString1 = ad.gbg().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(195512);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, i parami)
  {
    return false;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(153743);
    float f = this.Mue.getScale();
    AppMethodBeat.o(153743);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(153777);
    int i = this.Mue.getScrollHeight();
    AppMethodBeat.o(153777);
    return i;
  }
  
  public final z getSettings()
  {
    AppMethodBeat.i(153727);
    if (this.Mui != null)
    {
      localg = this.Mui;
      AppMethodBeat.o(153727);
      return localg;
    }
    if (this.Mue == null)
    {
      AppMethodBeat.o(153727);
      return null;
    }
    this.Mui = new g(this.Mue);
    g localg = this.Mui;
    AppMethodBeat.o(153727);
    return localg;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(153755);
    String str = this.Mue.getTitle();
    AppMethodBeat.o(153755);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.Mue;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(153751);
    String str = this.Mue.getUrl();
    AppMethodBeat.o(153751);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(153759);
    String str = "webviewtype = WV_KIND_SYS, version = " + XWalkEnvironment.getChromiunVersion() + ", V8 type=" + JsRuntime.gaC();
    AppMethodBeat.o(153759);
    return str;
  }
  
  public final View getView()
  {
    return this.Mue;
  }
  
  public final int getVisibleTitleHeight()
  {
    AppMethodBeat.i(153744);
    Object localObject = f.f(this.Mue, "getVisibleTitleHeight");
    if (localObject == null)
    {
      AppMethodBeat.o(153744);
      return 0;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(153744);
    return i;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(153762);
    int i = getWebViewUI().getScrollX();
    AppMethodBeat.o(153762);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(153761);
    int i = this.Mue.getScrollY();
    AppMethodBeat.o(153761);
    return i;
  }
  
  public final View getWebViewUI()
  {
    return this.Mue;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(153732);
    this.Mue.goBack();
    AppMethodBeat.o(153732);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(153769);
    this.Mue.goForward();
    AppMethodBeat.o(153769);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.MrX;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(153772);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.d("SysWebView", " method string is null or empty");
      AppMethodBeat.o(153772);
      return null;
    }
    if (paramString.equals("supportTranslateWebSite"))
    {
      paramString = new Bundle();
      paramString.putBoolean("result", false);
      Log.i("SysWebView", "sys web is not supportTranslateWebSite");
      AppMethodBeat.o(153772);
      return paramString;
    }
    AppMethodBeat.o(153772);
    return null;
  }
  
  public final boolean isOverScrollStart()
  {
    AppMethodBeat.i(153763);
    if (getWebViewUI().getScrollY() == 0)
    {
      AppMethodBeat.o(153763);
      return true;
    }
    AppMethodBeat.o(153763);
    return false;
  }
  
  public final boolean isSupportExtendPluginForAppbrand()
  {
    return false;
  }
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(153733);
    if (this.cgY != null) {
      this.cgY.onHideCustomView();
    }
    AppMethodBeat.o(153733);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(153741);
    this.Mue.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(153741);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(153746);
    this.Mue.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(153746);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(153730);
    this.Mue.loadUrl(paramString);
    AppMethodBeat.o(153730);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(153749);
    this.Mue.loadUrl(paramString, paramMap);
    AppMethodBeat.o(153749);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(153776);
    this.Mue.onPause();
    AppMethodBeat.o(153776);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(153765);
    this.Mue.onPause();
    AppMethodBeat.o(153765);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(153764);
    this.Mue.onResume();
    AppMethodBeat.o(153764);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(153775);
    this.Mue.onPause();
    AppMethodBeat.o(153775);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(153745);
    boolean bool = this.Mue.overlayHorizontalScrollbar();
    AppMethodBeat.o(153745);
    return bool;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(153739);
    this.Mue.reload();
    AppMethodBeat.o(153739);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(153752);
    this.Mue.removeJavascriptInterface(paramString);
    AppMethodBeat.o(153752);
  }
  
  public final boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public final void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(153774);
    Log.e("SysWebView", "setBottomHeight not implement");
    AppMethodBeat.o(153774);
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(153728);
    this.Mue.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(153728);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(153729);
    this.Mue.setFindListener(paramFindListener);
    AppMethodBeat.o(153729);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153771);
    this.Mue.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153771);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(195511);
    ad.gbg().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(195511);
  }
  
  public final void setJSExceptionListener(ae paramae) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153770);
    this.Mue.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153770);
  }
  
  public final u setVideoJsCallback(v paramv)
  {
    AppMethodBeat.i(153737);
    if (this.Muk.eB(paramv))
    {
      paramv = new u()
      {
        public final void G(double paramAnonymousDouble)
        {
          AppMethodBeat.i(153690);
          if (e.a(e.this) != null) {
            e.a(e.this).G(paramAnonymousDouble);
          }
          AppMethodBeat.o(153690);
        }
        
        public final void etk()
        {
          AppMethodBeat.i(153689);
          if (e.a(e.this) != null) {
            e.a(e.this).etk();
          }
          AppMethodBeat.o(153689);
        }
        
        public final void gaG()
        {
          AppMethodBeat.i(153688);
          if (e.a(e.this) != null) {
            e.a(e.this).gaG();
          }
          AppMethodBeat.o(153688);
        }
        
        public final boolean gaH()
        {
          AppMethodBeat.i(195508);
          if (e.a(e.this) != null)
          {
            boolean bool = e.a(e.this).gaH();
            AppMethodBeat.o(195508);
            return bool;
          }
          AppMethodBeat.o(195508);
          return false;
        }
      };
      AppMethodBeat.o(153737);
      return paramv;
    }
    Log.i("SysWebView", "setVideoJsCallback not support");
    AppMethodBeat.o(153737);
    return null;
  }
  
  public final void setWebChromeClient(x paramx)
  {
    this.Mug = paramx;
  }
  
  public final void setWebViewCallbackClient(ab paramab)
  {
    if (this.Mue != null) {
      this.Mue.lvl = paramab;
    }
  }
  
  public final void setWebViewClient(ac paramac)
  {
    this.Muf = paramac;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama) {}
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong) {}
  
  public final void stopLoading()
  {
    AppMethodBeat.i(153753);
    this.Mue.stopLoading();
    AppMethodBeat.o(153753);
  }
  
  public final void super_computeScroll() {}
  
  public final boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean supportFeature(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 2006)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(153748);
    boolean bool = this.Mue.zoomIn();
    AppMethodBeat.o(153748);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(153747);
    boolean bool = this.Mue.zoomOut();
    AppMethodBeat.o(153747);
    return bool;
  }
  
  final class a
    extends android.webkit.WebView
  {
    public ab lvl;
    
    public a(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(153721);
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4) && (e.this.hasEnteredFullscreen()))
      {
        e.this.leaveFullscreen();
        AppMethodBeat.o(153721);
        return true;
      }
      AppMethodBeat.o(153721);
      return false;
    }
    
    public final int getScrollHeight()
    {
      AppMethodBeat.i(153722);
      int i = computeVerticalScrollRange();
      AppMethodBeat.o(153722);
      return i;
    }
    
    protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(153720);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (e.this.Mud != null) {
        e.this.Mud.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      if (this.lvl != null) {
        this.lvl.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
      }
      AppMethodBeat.o(153720);
    }
  }
  
  public static final class b
  {
    HashMap<String, ValueCallback<String>> Mup;
    int Muq;
    
    public b()
    {
      AppMethodBeat.i(153723);
      this.Mup = new HashMap();
      this.Muq = 0;
      AppMethodBeat.o(153723);
    }
    
    @JavascriptInterface
    public final void notifyJava(String paramString1, String paramString2)
    {
      AppMethodBeat.i(153724);
      ValueCallback localValueCallback = (ValueCallback)this.Mup.get(paramString1);
      if (localValueCallback != null)
      {
        localValueCallback.onReceiveValue(paramString2);
        this.Mup.remove(paramString1);
      }
      AppMethodBeat.o(153724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.e
 * JD-Core Version:    0.7.0.1
 */