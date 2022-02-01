package com.tencent.xweb.sys;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ab;
import com.tencent.xweb.ad;
import com.tencent.xweb.af;
import com.tencent.xweb.ag;
import com.tencent.xweb.ah;
import com.tencent.xweb.ai;
import com.tencent.xweb.al;
import com.tencent.xweb.extension.video.e;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.i;
import com.tencent.xweb.util.l;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class f
  implements IWebView
{
  private com.tencent.xweb.WebView aigp;
  private boolean aihJ;
  private ag aikH;
  private z aikI;
  private long aikJ;
  private com.tencent.xweb.extension.video.a aikP;
  private WebChromeClient.CustomViewCallback aikS;
  private a aiml;
  private d aimm;
  private h aimn;
  private b aimo;
  private final String aimp;
  private WebChromeClient eiQ;
  private WebViewClient mWebViewClient;
  private int oG;
  private af sLl;
  
  public f(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153725);
    this.aikJ = 0L;
    this.oG = -1;
    this.aikS = null;
    this.aihJ = false;
    this.eiQ = new SysWebView.2(this);
    this.mWebViewClient = new WebViewClient()
    {
      public final void doUpdateVisitedHistory(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(153715);
        if (f.f(f.this) != null)
        {
          f.f(f.this).b(f.a(f.this), paramAnonymousString, paramAnonymousBoolean);
          AppMethodBeat.o(153715);
          return;
        }
        super.doUpdateVisitedHistory(paramAnonymousWebView, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(153715);
      }
      
      public final void onLoadResource(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153711);
        if (f.f(f.this) != null)
        {
          f.f(f.this).i(f.a(f.this), paramAnonymousString);
          AppMethodBeat.o(153711);
          return;
        }
        super.onLoadResource(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153711);
      }
      
      public final void onPageCommitVisible(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153707);
        Log.i("SysWebView", "onPageCommitVisible s = ".concat(String.valueOf(paramAnonymousString)));
        if (f.f(f.this) != null) {
          f.f(f.this).e(f.a(f.this), paramAnonymousString);
        }
        AppMethodBeat.o(153707);
      }
      
      public final void onPageFinished(android.webkit.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153710);
        Log.i("SysWebView", "onPageFinished ".concat(String.valueOf(paramAnonymousString)));
        boolean bool;
        if (f.d(f.this) != null)
        {
          com.tencent.xweb.extension.video.a locala = f.d(f.this);
          if (f.a(f.this).getFullscreenVideoKind() == WebView.a.aifF)
          {
            bool = true;
            locala.bV(false, bool);
          }
        }
        else
        {
          if (f.f(f.this) == null) {
            break label148;
          }
          f.f(f.this).b(f.a(f.this), paramAnonymousString);
        }
        for (;;)
        {
          l.Bs(System.currentTimeMillis() - f.g(f.this));
          com.tencent.xweb.xwalk.d.a(f.a(f.this));
          l.Bt(System.currentTimeMillis() - f.g(f.this));
          i.khf().khl();
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
        if (f.f(f.this) != null)
        {
          f.f(f.this).b(f.a(f.this), paramAnonymousString, paramAnonymousBitmap);
          f.a(f.this, System.currentTimeMillis());
          l.bIf(paramAnonymousString);
          l.khK();
          if (f.d(f.this) != null)
          {
            paramAnonymousWebView = f.d(f.this);
            if (f.a(f.this).getFullscreenVideoKind() != WebView.a.aifF) {
              break label128;
            }
          }
        }
        label128:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bV(true, bool);
          AppMethodBeat.o(153709);
          return;
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          break;
        }
      }
      
      public final void onReceivedError(android.webkit.WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(153716);
        if (f.f(f.this) != null) {
          f.f(f.this).a(f.a(f.this), paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        for (;;)
        {
          l.khJ();
          l.khL();
          i.khf().khm();
          AppMethodBeat.o(153716);
          return;
          super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void onReceivedError(android.webkit.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
      {
        Object localObject = null;
        AppMethodBeat.i(212660);
        Log.i("SysWebView", "onReceivedError2");
        ag localag;
        com.tencent.xweb.WebView localWebView;
        if (f.f(f.this) != null)
        {
          if ((paramAnonymousWebResourceRequest.isForMainFrame()) && (paramAnonymousWebResourceRequest != null) && (paramAnonymousWebResourceError != null))
          {
            localag = f.f(f.this);
            localWebView = f.a(f.this);
            int i = paramAnonymousWebResourceError.getErrorCode();
            String str = paramAnonymousWebResourceError.getDescription().toString();
            if (paramAnonymousWebResourceRequest.getUrl() == null) {
              break label157;
            }
            paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
            localag.a(localWebView, i, str, paramAnonymousWebView);
          }
          paramAnonymousWebResourceRequest = new c.f(paramAnonymousWebResourceRequest);
          localag = f.f(f.this);
          localWebView = f.a(f.this);
          if (paramAnonymousWebResourceError != null) {
            break label162;
          }
        }
        label157:
        label162:
        for (paramAnonymousWebView = localObject;; paramAnonymousWebView = new c.1(paramAnonymousWebResourceError))
        {
          localag.a(localWebView, paramAnonymousWebResourceRequest, paramAnonymousWebView);
          AppMethodBeat.o(212660);
          return;
          paramAnonymousWebView = null;
          break;
        }
      }
      
      public final void onReceivedHttpAuthRequest(android.webkit.WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(212699);
        Log.i("SysWebView", "onReceivedHttpAuthRequest host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (f.f(f.this) != null)
        {
          f.f(f.this).a(f.a(f.this), new c.b(paramAnonymousHttpAuthHandler), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(212699);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousWebView, paramAnonymousHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(212699);
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
          if (f.f(f.this) == null) {
            break label170;
          }
          localObject = f.f(f.this);
          localWebView = f.a(f.this);
          paramAnonymousWebResourceRequest = new c.f(paramAnonymousWebResourceRequest);
          if (paramAnonymousWebResourceResponse != null) {
            break label104;
          }
          paramAnonymousWebView = null;
        }
        for (;;)
        {
          ((ag)localObject).a(localWebView, paramAnonymousWebResourceRequest, paramAnonymousWebView);
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
        if (f.f(f.this) != null)
        {
          f.f(f.this).a(f.a(f.this), new c.a(paramAnonymousSslErrorHandler), paramAnonymousSslError);
          AppMethodBeat.o(153717);
          return;
        }
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(153717);
      }
      
      public final void onScaleChanged(android.webkit.WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(153714);
        if (f.f(f.this) != null)
        {
          f.f(f.this).a(f.a(f.this), paramAnonymousFloat1, paramAnonymousFloat2);
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
        if (f.f(f.this) != null)
        {
          c.f localf = new c.f(paramAnonymousWebResourceRequest);
          if (localf.aikC == null) {}
          for (paramAnonymousWebResourceRequest = null;; paramAnonymousWebResourceRequest = localf.aikC.getBundle())
          {
            paramAnonymousWebView = localObject;
            if (paramAnonymousWebResourceRequest != null) {
              paramAnonymousWebView = f.f(f.this).a(f.a(f.this), localf, paramAnonymousWebResourceRequest);
            }
            paramAnonymousWebResourceRequest = paramAnonymousWebView;
            if (paramAnonymousWebView == null) {
              paramAnonymousWebResourceRequest = f.f(f.this).a(f.a(f.this), localf);
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
        if (f.f(f.this) != null)
        {
          paramAnonymousWebView = c.a(f.f(f.this).c(f.a(f.this), paramAnonymousString));
          AppMethodBeat.o(153712);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153712);
        return paramAnonymousWebView;
      }
      
      public final boolean shouldOverrideUrlLoading(android.webkit.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(153706);
        Log.i("SysWebView", "shouldOverrideUrlLoading " + paramAnonymousWebResourceRequest.getUrl().toString());
        if (f.f(f.this) != null)
        {
          paramAnonymousWebView = new c.f(paramAnonymousWebResourceRequest);
          bool = f.f(f.this).e(f.a(f.this), paramAnonymousWebView);
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
        if (com.tencent.xweb.xwalk.d.bIm(paramAnonymousString))
        {
          AppMethodBeat.o(153708);
          return true;
        }
        Log.i("SysWebView", "shouldOverrideUrlLoading ".concat(String.valueOf(paramAnonymousString)));
        if (f.f(f.this) != null)
        {
          bool = f.f(f.this).a(f.a(f.this), paramAnonymousString);
          AppMethodBeat.o(153708);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153708);
        return bool;
      }
    };
    this.aimp = "xwalkTempCallBack";
    this.aigp = paramWebView;
    this.aiml = new a(paramWebView.getContext());
    this.aiml.setBackgroundColor(0);
    getSettings();
    this.aimm = new d(this.aiml);
    this.aiml.setWebChromeClient(this.eiQ);
    this.aiml.setWebViewClient(this.mWebViewClient);
    if (Build.VERSION.SDK_INT < 19)
    {
      this.aimo = new b();
      this.aiml.addJavascriptInterface(this.aimo, "xwalkTempCallBack");
    }
    if ((paramWebView.getContext() instanceof Activity))
    {
      cq((Activity)paramWebView.getContext());
      AppMethodBeat.o(153725);
      return;
    }
    cq(null);
    AppMethodBeat.o(153725);
  }
  
  private void cq(Activity paramActivity)
  {
    AppMethodBeat.i(153726);
    Log.i("SysWebView", "initFullscreenVideo, kind:" + getFullscreenVideoKind() + ", activity:" + paramActivity);
    if (getFullscreenVideoKind() == WebView.a.aifD)
    {
      AppMethodBeat.o(153726);
      return;
    }
    this.aikP = e.a(this.aigp.getWebCoreType(), paramActivity, this.aigp, this.aiml, com.tencent.xweb.extension.video.c.kgA());
    if (getFullscreenVideoKind() == WebView.a.aifF) {
      this.aikP.hm(this.aiml);
    }
    AppMethodBeat.o(153726);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(153750);
    this.aiml.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(153750);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(153731);
    boolean bool = this.aiml.canGoBack();
    AppMethodBeat.o(153731);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(153768);
    boolean bool = this.aiml.canGoForward();
    AppMethodBeat.o(153768);
    return bool;
  }
  
  public final Bitmap captureBitmap()
  {
    AppMethodBeat.i(212907);
    int i = this.aiml.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(this.aiml.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.aiml.draw(localCanvas);
    AppMethodBeat.o(212907);
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
        int i = f.h(f.this).getHeight();
        Canvas localCanvas = new Canvas(Bitmap.createBitmap(f.h(f.this).getWidth(), i, Bitmap.Config.ARGB_8888));
        f.h(f.this).draw(localCanvas);
        Log.d("SysWebView", "bitmapCaptureFinished");
        AppMethodBeat.o(153719);
      }
    }).start();
    AppMethodBeat.o(153773);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(153767);
    this.aiml.clearHistory();
    AppMethodBeat.o(153767);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(153756);
    this.aiml.clearMatches();
    AppMethodBeat.o(153756);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(153740);
    this.aiml.clearSslPreferences();
    AppMethodBeat.o(153740);
  }
  
  public final void clearView()
  {
    AppMethodBeat.i(153734);
    this.aiml.clearView();
    AppMethodBeat.o(153734);
  }
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(212924);
    WebBackForwardList localWebBackForwardList = this.aiml.copyBackForwardList();
    AppMethodBeat.o(212924);
    return localWebBackForwardList;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(153735);
    this.aiml.destroy();
    AppMethodBeat.o(153735);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(153736);
    if (this.aikP != null) {
      this.aikP.OV(paramBoolean);
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
      this.aiml.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(153738);
      return;
    }
    if (paramValueCallback == null)
    {
      this.aiml.loadUrl(paramString);
      AppMethodBeat.o(153738);
      return;
    }
    String str = paramString;
    if (paramString.trim().startsWith("javascript:")) {
      str = paramString.replaceFirst("javascript:", "");
    }
    if (this.aimo == null)
    {
      this.aimo = new b();
      this.aiml.addJavascriptInterface(this.aimo, "xwalkTempCallBack");
    }
    b localb = this.aimo;
    if (paramValueCallback != null)
    {
      paramString = new StringBuilder();
      int i = localb.aims;
      localb.aims = (i + 1);
      paramString = i;
      localb.aimr.put(paramString, paramValueCallback);
    }
    for (;;)
    {
      paramString = "javascript:xwalkTempCallBack.notifyJava(" + paramString + ", " + str + ")";
      this.aiml.loadUrl(paramString);
      AppMethodBeat.o(153738);
      return;
      paramString = "";
    }
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(153758);
    this.aiml.findAllAsync(paramString);
    AppMethodBeat.o(153758);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(153757);
    this.aiml.findNext(paramBoolean);
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
    int i = this.aiml.getContentHeight();
    AppMethodBeat.o(153742);
    return i;
  }
  
  public final z getCurWebChromeClient()
  {
    return this.aikI;
  }
  
  public final ag getCurWebviewClient()
  {
    return this.aikH;
  }
  
  public final com.tencent.xweb.internal.f getDefalutOpProvider()
  {
    return this.aimm;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(153766);
    WebView.a locala = com.tencent.xweb.a.keX().bHi(com.tencent.xweb.WebView.getCurStrModule());
    AppMethodBeat.o(153766);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(153754);
    WebView.HitTestResult localHitTestResult = this.aiml.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.mType = localHitTestResult.getType();
    localb.mExtra = localHitTestResult.getExtra();
    AppMethodBeat.o(153754);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212928);
    paramString1 = ah.kfZ().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(212928);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, com.tencent.xweb.k paramk)
  {
    return false;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(153743);
    float f = this.aiml.getScale();
    AppMethodBeat.o(153743);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(153777);
    int i = this.aiml.getScrollHeight();
    AppMethodBeat.o(153777);
    return i;
  }
  
  public final ad getSettings()
  {
    AppMethodBeat.i(153727);
    if (this.aimn != null)
    {
      localh = this.aimn;
      AppMethodBeat.o(153727);
      return localh;
    }
    if (this.aiml == null)
    {
      AppMethodBeat.o(153727);
      return null;
    }
    this.aimn = new h(this.aiml);
    h localh = this.aimn;
    AppMethodBeat.o(153727);
    return localh;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(153755);
    String str = this.aiml.getTitle();
    AppMethodBeat.o(153755);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.aiml;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(153751);
    String str = this.aiml.getUrl();
    AppMethodBeat.o(153751);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(153759);
    String str = "sys, version = " + com.tencent.xweb.util.d.khy();
    AppMethodBeat.o(153759);
    return str;
  }
  
  public final View getView()
  {
    return this.aiml;
  }
  
  public final int getVisibleTitleHeight()
  {
    AppMethodBeat.i(153744);
    Object localObject = com.tencent.xweb.util.k.q(this.aiml, "getVisibleTitleHeight");
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
    int i = this.aiml.getScrollY();
    AppMethodBeat.o(153761);
    return i;
  }
  
  public final af getWebViewCallbackClient()
  {
    return this.sLl;
  }
  
  public final View getWebViewUI()
  {
    return this.aiml;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(153732);
    this.aiml.goBack();
    AppMethodBeat.o(153732);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(153769);
    this.aiml.goForward();
    AppMethodBeat.o(153769);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.aihJ;
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
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(153733);
    if (this.aikS != null) {
      this.aikS.onCustomViewHidden();
    }
    AppMethodBeat.o(153733);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(153741);
    this.aiml.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(153741);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(153746);
    this.aiml.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(153746);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(153730);
    this.aiml.loadUrl(paramString);
    AppMethodBeat.o(153730);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(153749);
    this.aiml.loadUrl(paramString, paramMap);
    AppMethodBeat.o(153749);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(153776);
    this.aiml.onPause();
    AppMethodBeat.o(153776);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(153765);
    this.aiml.onPause();
    AppMethodBeat.o(153765);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(153764);
    this.aiml.onResume();
    AppMethodBeat.o(153764);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(153775);
    this.aiml.onPause();
    AppMethodBeat.o(153775);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(153745);
    boolean bool = this.aiml.overlayHorizontalScrollbar();
    AppMethodBeat.o(153745);
    return bool;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(153739);
    this.aiml.reload();
    AppMethodBeat.o(153739);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(153752);
    this.aiml.removeJavascriptInterface(paramString);
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
    this.aiml.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(153728);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(153729);
    this.aiml.setFindListener(paramFindListener);
    AppMethodBeat.o(153729);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153771);
    this.aiml.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153771);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(212925);
    ah.kfZ().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(212925);
  }
  
  public final void setJSExceptionListener(ai paramai) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153770);
    this.aiml.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153770);
  }
  
  public final w setVideoJsCallback(x paramx)
  {
    AppMethodBeat.i(153737);
    if ((this.aikP != null) && (this.aikP.hn(paramx)))
    {
      paramx = new w()
      {
        public final void Z(double paramAnonymousDouble)
        {
          AppMethodBeat.i(153690);
          if (f.d(f.this) != null) {
            f.d(f.this).Z(paramAnonymousDouble);
          }
          AppMethodBeat.o(153690);
        }
        
        public final void hSS()
        {
          AppMethodBeat.i(153689);
          if (f.d(f.this) != null) {
            f.d(f.this).hSS();
          }
          AppMethodBeat.o(153689);
        }
        
        public final void kfv()
        {
          AppMethodBeat.i(153688);
          if (f.d(f.this) != null) {
            f.d(f.this).kfv();
          }
          AppMethodBeat.o(153688);
        }
        
        public final boolean kfw()
        {
          AppMethodBeat.i(212666);
          if (f.d(f.this) != null)
          {
            boolean bool = f.d(f.this).kfw();
            AppMethodBeat.o(212666);
            return bool;
          }
          AppMethodBeat.o(212666);
          return false;
        }
      };
      AppMethodBeat.o(153737);
      return paramx;
    }
    Log.i("SysWebView", "setVideoJsCallback not support");
    AppMethodBeat.o(153737);
    return null;
  }
  
  public final void setWebChromeClient(z paramz)
  {
    this.aikI = paramz;
  }
  
  public final void setWebContentsSize(int paramInt1, int paramInt2) {}
  
  public final void setWebViewCallbackClient(af paramaf)
  {
    this.sLl = paramaf;
  }
  
  public final void setWebViewClient(ag paramag)
  {
    this.aikH = paramag;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama) {}
  
  public final void setXWebKeyEventHandler(al paramal) {}
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong) {}
  
  public final void stopLoading()
  {
    AppMethodBeat.i(153753);
    this.aiml.stopLoading();
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
    boolean bool = this.aiml.zoomIn();
    AppMethodBeat.o(153748);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(153747);
    boolean bool = this.aiml.zoomOut();
    AppMethodBeat.o(153747);
    return bool;
  }
  
  final class a
    extends android.webkit.WebView
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(153721);
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4) && (f.this.hasEnteredFullscreen()))
      {
        f.this.leaveFullscreen();
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
    
    public final void invalidate()
    {
      AppMethodBeat.i(212693);
      super.invalidate();
      if (f.b(f.this) != null) {
        f.b(f.this);
      }
      int i = getContentHeight();
      if (i != f.c(f.this))
      {
        f.a(f.this, i);
        if (f.b(f.this) != null)
        {
          Log.i("SysWebView", "onContentHeightChanged, height:".concat(String.valueOf(i)));
          f.b(f.this).Bv(i);
        }
      }
      AppMethodBeat.o(212693);
    }
    
    protected final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(212683);
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      if (f.b(f.this) != null) {
        f.b(f.this).onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
      }
      AppMethodBeat.o(212683);
    }
    
    protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(153720);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (f.a(f.this) != null) {
        f.a(f.this).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      if (f.b(f.this) != null) {
        f.b(f.this).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
      }
      AppMethodBeat.o(153720);
    }
    
    protected final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      AppMethodBeat.i(212686);
      if (f.b(f.this) != null) {
        f.b(f.this).overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
      }
      paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      AppMethodBeat.o(212686);
      return paramBoolean;
    }
  }
  
  public static final class b
  {
    HashMap<String, ValueCallback<String>> aimr;
    int aims;
    
    public b()
    {
      AppMethodBeat.i(153723);
      this.aimr = new HashMap();
      this.aims = 0;
      AppMethodBeat.o(153723);
    }
    
    @JavascriptInterface
    public final void notifyJava(String paramString1, String paramString2)
    {
      AppMethodBeat.i(153724);
      ValueCallback localValueCallback = (ValueCallback)this.aimr.get(paramString1);
      if (localValueCallback != null)
      {
        localValueCallback.onReceiveValue(paramString2);
        this.aimr.remove(paramString1);
      }
      AppMethodBeat.o(153724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.f
 * JD-Core Version:    0.7.0.1
 */