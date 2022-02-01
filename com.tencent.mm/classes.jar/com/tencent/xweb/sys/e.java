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
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView.FindListener;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import com.tencent.xweb.ac;
import com.tencent.xweb.ad;
import com.tencent.xweb.ae;
import com.tencent.xweb.af;
import com.tencent.xweb.ah;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.i;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author=20001, fComment="checked", lastDate="20171020", reviewer=20001, vComment={com.jg.EType.JSEXECUTECHECK})
public final class e
  implements IWebView
{
  private boolean aadc;
  g aafA;
  long aafB;
  private b aafC;
  b aafD;
  final String aafE;
  com.tencent.xweb.WebView aafv;
  a aafw;
  ad aafx;
  x aafy;
  d aafz;
  private WebChromeClient.CustomViewCallback abTM;
  private WebChromeClient cqX;
  private WebViewClient mWebViewClient;
  
  public e(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153725);
    this.aafB = 0L;
    this.abTM = null;
    this.aadc = false;
    this.cqX = new SysWebView.2(this);
    this.mWebViewClient = new WebViewClient()
    {
      public final void doUpdateVisitedHistory(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(153715);
        if (e.this.aafx != null)
        {
          e.this.aafx.b(e.this.aafv, paramAnonymousString, paramAnonymousBoolean);
          AppMethodBeat.o(153715);
          return;
        }
        super.doUpdateVisitedHistory(paramAnonymousWebView, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(153715);
      }
      
      public final void onLoadResource(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153711);
        if (e.this.aafx != null)
        {
          e.this.aafx.i(e.this.aafv, paramAnonymousString);
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
        if (e.this.aafx != null) {
          e.this.aafx.e(e.this.aafv, paramAnonymousString);
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
          if (e.this.aafv.getFullscreenVideoKind() == WebView.a.aabj)
          {
            bool = true;
            localb.bu(false, bool);
          }
        }
        else
        {
          if (e.this.aafx == null) {
            break label148;
          }
          e.this.aafx.b(e.this.aafv, paramAnonymousString);
        }
        for (;;)
        {
          com.tencent.xweb.util.h.Xh(System.currentTimeMillis() - e.this.aafB);
          com.tencent.xweb.xwalk.d.a(e.this.aafv);
          com.tencent.xweb.util.h.Xi(System.currentTimeMillis() - e.this.aafB);
          com.tencent.xweb.internal.h.ixo().ixu();
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
        if (e.this.aafx != null)
        {
          e.this.aafx.b(e.this.aafv, paramAnonymousString, paramAnonymousBitmap);
          e.this.aafB = System.currentTimeMillis();
          com.tencent.xweb.util.h.bFG(paramAnonymousString);
          com.tencent.xweb.util.h.ixI();
          if (e.a(e.this) != null)
          {
            paramAnonymousWebView = e.a(e.this);
            if (e.this.aafv.getFullscreenVideoKind() != WebView.a.aabj) {
              break label127;
            }
          }
        }
        label127:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bu(true, bool);
          AppMethodBeat.o(153709);
          return;
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          break;
        }
      }
      
      public final void onReceivedError(android.webkit.WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(153716);
        if (e.this.aafx != null) {
          e.this.aafx.a(e.this.aafv, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        for (;;)
        {
          com.tencent.xweb.util.h.ixH();
          com.tencent.xweb.util.h.ixJ();
          com.tencent.xweb.internal.h.ixo().ixv();
          AppMethodBeat.o(153716);
          return;
          super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void onReceivedError(android.webkit.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
      {
        Object localObject = null;
        AppMethodBeat.i(209419);
        Log.i("SysWebView", "onReceivedError2");
        ad localad;
        com.tencent.xweb.WebView localWebView;
        if (e.this.aafx != null)
        {
          if ((paramAnonymousWebResourceRequest.isForMainFrame()) && (paramAnonymousWebResourceRequest != null) && (paramAnonymousWebResourceError != null))
          {
            localad = e.this.aafx;
            localWebView = e.this.aafv;
            int i = paramAnonymousWebResourceError.getErrorCode();
            String str = paramAnonymousWebResourceError.getDescription().toString();
            if (paramAnonymousWebResourceRequest.getUrl() == null) {
              break label157;
            }
            paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
            localad.a(localWebView, i, str, paramAnonymousWebView);
          }
          paramAnonymousWebResourceRequest = new c.f(paramAnonymousWebResourceRequest);
          localad = e.this.aafx;
          localWebView = e.this.aafv;
          if (paramAnonymousWebResourceError != null) {
            break label162;
          }
        }
        label157:
        label162:
        for (paramAnonymousWebView = localObject;; paramAnonymousWebView = new c.1(paramAnonymousWebResourceError))
        {
          localad.a(localWebView, paramAnonymousWebResourceRequest, paramAnonymousWebView);
          AppMethodBeat.o(209419);
          return;
          paramAnonymousWebView = null;
          break;
        }
      }
      
      public final void onReceivedHttpAuthRequest(android.webkit.WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(209432);
        Log.i("SysWebView", "onReceivedHttpAuthRequest host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (e.this.aafx != null)
        {
          e.this.aafx.a(e.this.aafv, new c.b(paramAnonymousHttpAuthHandler), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(209432);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousWebView, paramAnonymousHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(209432);
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
          if (e.this.aafx == null) {
            break label170;
          }
          localObject = e.this.aafx;
          localWebView = e.this.aafv;
          paramAnonymousWebResourceRequest = new c.f(paramAnonymousWebResourceRequest);
          if (paramAnonymousWebResourceResponse != null) {
            break label104;
          }
          paramAnonymousWebView = null;
        }
        for (;;)
        {
          ((ad)localObject).a(localWebView, paramAnonymousWebResourceRequest, paramAnonymousWebView);
          AppMethodBeat.o(153718);
          return;
          localObject = "Invalid";
          break;
          label104:
          if (Build.VERSION.SDK_INT >= 21) {
            paramAnonymousWebView = new com.tencent.xweb.WebResourceResponse(paramAnonymousWebResourceResponse.getMimeType(), paramAnonymousWebResourceResponse.getEncoding(), paramAnonymousWebResourceResponse.getStatusCode(), paramAnonymousWebResourceResponse.getReasonPhrase(), paramAnonymousWebResourceResponse.getResponseHeaders(), paramAnonymousWebResourceResponse.getData());
          } else {
            paramAnonymousWebView = new com.tencent.xweb.WebResourceResponse(paramAnonymousWebResourceResponse.getMimeType(), paramAnonymousWebResourceResponse.getEncoding(), paramAnonymousWebResourceResponse.getData());
          }
        }
        label170:
        super.onReceivedHttpError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceResponse);
        AppMethodBeat.o(153718);
      }
      
      public final void onReceivedSslError(android.webkit.WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(153717);
        Log.i("SysWebView", "onReceivedSslError " + paramAnonymousSslError.getPrimaryError());
        if (e.this.aafx != null)
        {
          e.this.aafx.a(e.this.aafv, new c.a(paramAnonymousSslErrorHandler), paramAnonymousSslError);
          AppMethodBeat.o(153717);
          return;
        }
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(153717);
      }
      
      public final void onScaleChanged(android.webkit.WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(153714);
        if (e.this.aafx != null)
        {
          e.this.aafx.a(e.this.aafv, paramAnonymousFloat1, paramAnonymousFloat2);
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
        if (e.this.aafx != null)
        {
          c.f localf = new c.f(paramAnonymousWebResourceRequest);
          if (localf.aafo == null) {}
          for (paramAnonymousWebResourceRequest = null;; paramAnonymousWebResourceRequest = localf.aafo.getBundle())
          {
            paramAnonymousWebView = localObject;
            if (paramAnonymousWebResourceRequest != null) {
              paramAnonymousWebView = e.this.aafx.a(e.this.aafv, localf, paramAnonymousWebResourceRequest);
            }
            paramAnonymousWebResourceRequest = paramAnonymousWebView;
            if (paramAnonymousWebView == null) {
              paramAnonymousWebResourceRequest = e.this.aafx.a(e.this.aafv, localf);
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
        if (e.this.aafx != null)
        {
          paramAnonymousWebView = c.a(e.this.aafx.c(e.this.aafv, paramAnonymousString));
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
        if (e.this.aafx != null)
        {
          paramAnonymousWebView = new c.f(paramAnonymousWebResourceRequest);
          bool = e.this.aafx.e(e.this.aafv, paramAnonymousWebView);
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
        if (com.tencent.xweb.xwalk.d.bFM(paramAnonymousString))
        {
          AppMethodBeat.o(153708);
          return true;
        }
        Log.i("SysWebView", "shouldOverrideUrlLoading ".concat(String.valueOf(paramAnonymousString)));
        if (e.this.aafx != null)
        {
          bool = e.this.aafx.a(e.this.aafv, paramAnonymousString);
          AppMethodBeat.o(153708);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153708);
        return bool;
      }
    };
    this.aafE = "xwalkTempCallBack";
    this.aafv = paramWebView;
    this.aafw = new a(paramWebView.getContext());
    this.aafw.setBackgroundColor(0);
    getSettings();
    this.aafz = new d(this.aafw);
    this.aafw.setWebChromeClient(this.cqX);
    this.aafw.setWebViewClient(this.mWebViewClient);
    if (Build.VERSION.SDK_INT < 19)
    {
      this.aafD = new b();
      this.aafw.addJavascriptInterface(this.aafD, "xwalkTempCallBack");
    }
    if ((paramWebView.getContext() instanceof Activity))
    {
      bK((Activity)paramWebView.getContext());
      AppMethodBeat.o(153725);
      return;
    }
    bK(null);
    AppMethodBeat.o(153725);
  }
  
  private void bK(Activity paramActivity)
  {
    AppMethodBeat.i(153726);
    Log.i("SysWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + paramActivity);
    if (getFullscreenVideoKind() == WebView.a.aabh)
    {
      AppMethodBeat.o(153726);
      return;
    }
    this.aafC = com.tencent.xweb.extension.video.e.a(paramActivity, this.aafv, this.aafw, com.tencent.xweb.extension.video.d.iwS());
    if (getFullscreenVideoKind() == WebView.a.aabj) {
      this.aafC.eP(this.aafw);
    }
    AppMethodBeat.o(153726);
  }
  
  @SuppressLint({"JavascriptInterface"})
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(153750);
    this.aafw.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(153750);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(153731);
    boolean bool = this.aafw.canGoBack();
    AppMethodBeat.o(153731);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(153768);
    boolean bool = this.aafw.canGoForward();
    AppMethodBeat.o(153768);
    return bool;
  }
  
  public final Bitmap captureBitmap()
  {
    AppMethodBeat.i(206693);
    int i = this.aafw.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(this.aafw.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.aafw.draw(localCanvas);
    AppMethodBeat.o(206693);
    return localBitmap;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(153773);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153719);
        int i = e.this.aafw.getHeight();
        Canvas localCanvas = new Canvas(Bitmap.createBitmap(e.this.aafw.getWidth(), i, Bitmap.Config.ARGB_8888));
        e.this.aafw.draw(localCanvas);
        Log.d("SysWebView", "bitmapCaptureFinished");
        AppMethodBeat.o(153719);
      }
    }).start();
    AppMethodBeat.o(153773);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(153767);
    this.aafw.clearHistory();
    AppMethodBeat.o(153767);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(153756);
    this.aafw.clearMatches();
    AppMethodBeat.o(153756);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(153740);
    this.aafw.clearSslPreferences();
    AppMethodBeat.o(153740);
  }
  
  public final void clearView()
  {
    AppMethodBeat.i(153734);
    this.aafw.clearView();
    AppMethodBeat.o(153734);
  }
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(206694);
    WebBackForwardList localWebBackForwardList = this.aafw.copyBackForwardList();
    AppMethodBeat.o(206694);
    return localWebBackForwardList;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(153735);
    this.aafw.destroy();
    AppMethodBeat.o(153735);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(153736);
    if (this.aafC != null) {
      this.aafC.IO(paramBoolean);
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
      this.aafw.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(153738);
      return;
    }
    if (paramValueCallback == null)
    {
      this.aafw.loadUrl(paramString);
      AppMethodBeat.o(153738);
      return;
    }
    String str = paramString;
    if (paramString.trim().startsWith("javascript:")) {
      str = paramString.replaceFirst("javascript:", "");
    }
    if (this.aafD == null)
    {
      this.aafD = new b();
      this.aafw.addJavascriptInterface(this.aafD, "xwalkTempCallBack");
    }
    b localb = this.aafD;
    if (paramValueCallback != null)
    {
      paramString = new StringBuilder();
      int i = localb.aafI;
      localb.aafI = (i + 1);
      paramString = i;
      localb.aafH.put(paramString, paramValueCallback);
    }
    for (;;)
    {
      paramString = "javascript:xwalkTempCallBack.notifyJava(" + paramString + ", " + str + ")";
      this.aafw.loadUrl(paramString);
      AppMethodBeat.o(153738);
      return;
      paramString = "";
    }
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(153758);
    this.aafw.findAllAsync(paramString);
    AppMethodBeat.o(153758);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(153757);
    this.aafw.findNext(paramBoolean);
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
    int i = this.aafw.getContentHeight();
    AppMethodBeat.o(153742);
    return i;
  }
  
  public final x getCurWebChromeClient()
  {
    return this.aafy;
  }
  
  public final ad getCurWebviewClient()
  {
    return this.aafx;
  }
  
  public final com.tencent.xweb.internal.e getDefalutOpProvider()
  {
    return this.aafz;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(153766);
    WebView.a locala = com.tencent.xweb.a.bEE(com.tencent.xweb.WebView.getCurStrModule());
    AppMethodBeat.o(153766);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(153754);
    WebView.HitTestResult localHitTestResult = this.aafw.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.mType = localHitTestResult.getType();
    localb.mExtra = localHitTestResult.getExtra();
    AppMethodBeat.o(153754);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206696);
    paramString1 = ae.iwI().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(206696);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, i parami)
  {
    return false;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(153743);
    float f = this.aafw.getScale();
    AppMethodBeat.o(153743);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(153777);
    int i = this.aafw.getScrollHeight();
    AppMethodBeat.o(153777);
    return i;
  }
  
  public final aa getSettings()
  {
    AppMethodBeat.i(153727);
    if (this.aafA != null)
    {
      localg = this.aafA;
      AppMethodBeat.o(153727);
      return localg;
    }
    if (this.aafw == null)
    {
      AppMethodBeat.o(153727);
      return null;
    }
    this.aafA = new g(this.aafw);
    g localg = this.aafA;
    AppMethodBeat.o(153727);
    return localg;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(153755);
    String str = this.aafw.getTitle();
    AppMethodBeat.o(153755);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.aafw;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(153751);
    String str = this.aafw.getUrl();
    AppMethodBeat.o(153751);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(153759);
    String str = "webviewtype = WV_KIND_SYS, version = " + XWalkEnvironment.getChromiunVersion() + ", V8 type=" + JsRuntime.iwd();
    AppMethodBeat.o(153759);
    return str;
  }
  
  public final View getView()
  {
    return this.aafw;
  }
  
  public final int getVisibleTitleHeight()
  {
    AppMethodBeat.i(153744);
    Object localObject = com.tencent.xweb.util.g.i(this.aafw, "getVisibleTitleHeight");
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
    int i = this.aafw.getScrollY();
    AppMethodBeat.o(153761);
    return i;
  }
  
  public final View getWebViewUI()
  {
    return this.aafw;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(153732);
    this.aafw.goBack();
    AppMethodBeat.o(153732);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(153769);
    this.aafw.goForward();
    AppMethodBeat.o(153769);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.aadc;
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
    if (this.abTM != null) {
      this.abTM.onCustomViewHidden();
    }
    AppMethodBeat.o(153733);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(153741);
    this.aafw.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(153741);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(153746);
    this.aafw.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(153746);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(153730);
    this.aafw.loadUrl(paramString);
    AppMethodBeat.o(153730);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(153749);
    this.aafw.loadUrl(paramString, paramMap);
    AppMethodBeat.o(153749);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(153776);
    this.aafw.onPause();
    AppMethodBeat.o(153776);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(153765);
    this.aafw.onPause();
    AppMethodBeat.o(153765);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(153764);
    this.aafw.onResume();
    AppMethodBeat.o(153764);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(153775);
    this.aafw.onPause();
    AppMethodBeat.o(153775);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(153745);
    boolean bool = this.aafw.overlayHorizontalScrollbar();
    AppMethodBeat.o(153745);
    return bool;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(153739);
    this.aafw.reload();
    AppMethodBeat.o(153739);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(153752);
    this.aafw.removeJavascriptInterface(paramString);
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
    this.aafw.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(153728);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(153729);
    this.aafw.setFindListener(paramFindListener);
    AppMethodBeat.o(153729);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153771);
    this.aafw.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153771);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(206695);
    ae.iwI().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(206695);
  }
  
  public final void setJSExceptionListener(af paramaf) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153770);
    this.aafw.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153770);
  }
  
  public final u setVideoJsCallback(v paramv)
  {
    AppMethodBeat.i(153737);
    if (this.aafC.eQ(paramv))
    {
      paramv = new u()
      {
        public final void H(double paramAnonymousDouble)
        {
          AppMethodBeat.i(153690);
          if (e.a(e.this) != null) {
            e.a(e.this).H(paramAnonymousDouble);
          }
          AppMethodBeat.o(153690);
        }
        
        public final void gvc()
        {
          AppMethodBeat.i(153689);
          if (e.a(e.this) != null) {
            e.a(e.this).gvc();
          }
          AppMethodBeat.o(153689);
        }
        
        public final void iwh()
        {
          AppMethodBeat.i(153688);
          if (e.a(e.this) != null) {
            e.a(e.this).iwh();
          }
          AppMethodBeat.o(153688);
        }
        
        public final boolean iwi()
        {
          AppMethodBeat.i(210628);
          if (e.a(e.this) != null)
          {
            boolean bool = e.a(e.this).iwi();
            AppMethodBeat.o(210628);
            return bool;
          }
          AppMethodBeat.o(210628);
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
    this.aafy = paramx;
  }
  
  public final void setWebContentsSize(int paramInt1, int paramInt2) {}
  
  public final void setWebViewCallbackClient(ac paramac)
  {
    if (this.aafw != null) {
      this.aafw.pGc = paramac;
    }
  }
  
  public final void setWebViewClient(ad paramad)
  {
    this.aafx = paramad;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama) {}
  
  public final void setXWebKeyEventHandler(ah paramah) {}
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong) {}
  
  public final void stopLoading()
  {
    AppMethodBeat.i(153753);
    this.aafw.stopLoading();
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
    if (paramInt == 2006) {
      if (Build.VERSION.SDK_INT < 23) {}
    }
    while (paramInt == 2012)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean supportSetWebContentsSize()
  {
    return false;
  }
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(153748);
    boolean bool = this.aafw.zoomIn();
    AppMethodBeat.o(153748);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(153747);
    boolean bool = this.aafw.zoomOut();
    AppMethodBeat.o(153747);
    return bool;
  }
  
  final class a
    extends android.webkit.WebView
  {
    public ac pGc;
    
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
    
    protected final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(204820);
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      if (this.pGc != null) {
        this.pGc.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
      }
      AppMethodBeat.o(204820);
    }
    
    protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(153720);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (e.this.aafv != null) {
        e.this.aafv.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      if (this.pGc != null) {
        this.pGc.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
      }
      AppMethodBeat.o(153720);
    }
    
    protected final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      AppMethodBeat.i(204821);
      if (this.pGc != null) {
        this.pGc.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
      }
      paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      AppMethodBeat.o(204821);
      return paramBoolean;
    }
  }
  
  public static final class b
  {
    HashMap<String, ValueCallback<String>> aafH;
    int aafI;
    
    public b()
    {
      AppMethodBeat.i(153723);
      this.aafH = new HashMap();
      this.aafI = 0;
      AppMethodBeat.o(153723);
    }
    
    @JavascriptInterface
    public final void notifyJava(String paramString1, String paramString2)
    {
      AppMethodBeat.i(153724);
      ValueCallback localValueCallback = (ValueCallback)this.aafH.get(paramString1);
      if (localValueCallback != null)
      {
        localValueCallback.onReceiveValue(paramString2);
        this.aafH.remove(paramString1);
      }
      AppMethodBeat.o(153724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.e
 * JD-Core Version:    0.7.0.1
 */