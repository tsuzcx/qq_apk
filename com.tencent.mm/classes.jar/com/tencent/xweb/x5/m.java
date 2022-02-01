package com.tencent.xweb.x5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.ae;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.internal.h;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper;
import com.tencent.xweb.xwalk.d;
import com.tencent.xweb.z;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author=20001, fComment="checked", lastDate="20171020", reviewer=20001, vComment={com.jg.EType.JSEXECUTECHECK})
public final class m
  implements IWebView
{
  com.tencent.xweb.WebView KDD;
  ac KDF;
  x KDG;
  long KDJ;
  com.tencent.smtt.sdk.WebView KEH;
  j KEO;
  o KEP;
  String KEQ;
  private b KER;
  private c KES;
  
  public m(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153927);
    this.KDJ = 0L;
    this.KEQ = "";
    this.KER = new b()
    {
      public final View getVideoLoadingProgressView()
      {
        AppMethodBeat.i(153910);
        if (m.this.KDG != null)
        {
          localView = m.this.KDG.getVideoLoadingProgressView();
          AppMethodBeat.o(153910);
          return localView;
        }
        View localView = super.getVideoLoadingProgressView();
        AppMethodBeat.o(153910);
        return localView;
      }
      
      public final boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(153907);
        Log.i("X5WebView", "onConsoleMessage " + paramAnonymousConsoleMessage.message());
        if (m.this.KDG != null)
        {
          x localx = m.this.KDG;
          if (paramAnonymousConsoleMessage == null)
          {
            paramAnonymousConsoleMessage = null;
            bool = localx.onConsoleMessage(paramAnonymousConsoleMessage);
            AppMethodBeat.o(153907);
            return bool;
          }
          ConsoleMessage.MessageLevel localMessageLevel = ConsoleMessage.MessageLevel.DEBUG;
          switch (g.1.KEr[paramAnonymousConsoleMessage.messageLevel().ordinal()])
          {
          }
          for (;;)
          {
            paramAnonymousConsoleMessage = new android.webkit.ConsoleMessage(paramAnonymousConsoleMessage.message(), paramAnonymousConsoleMessage.sourceId(), paramAnonymousConsoleMessage.lineNumber(), localMessageLevel);
            break;
            localMessageLevel = ConsoleMessage.MessageLevel.DEBUG;
            continue;
            localMessageLevel = ConsoleMessage.MessageLevel.ERROR;
            continue;
            localMessageLevel = ConsoleMessage.MessageLevel.LOG;
            continue;
            localMessageLevel = ConsoleMessage.MessageLevel.TIP;
            continue;
            localMessageLevel = ConsoleMessage.MessageLevel.WARNING;
          }
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(153907);
        return bool;
      }
      
      public final void onGeolocationPermissionsHidePrompt()
      {
        AppMethodBeat.i(153906);
        Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
        if (m.this.KDG != null)
        {
          m.this.KDG.onGeolocationPermissionsHidePrompt();
          AppMethodBeat.o(153906);
          return;
        }
        super.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(153906);
      }
      
      public final void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissionsCallback paramAnonymousGeolocationPermissionsCallback)
      {
        AppMethodBeat.i(153905);
        Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
        if (m.this.KDG != null)
        {
          m.this.KDG.onGeolocationPermissionsShowPrompt(paramAnonymousString, new g.e(paramAnonymousGeolocationPermissionsCallback));
          AppMethodBeat.o(153905);
          return;
        }
        super.onGeolocationPermissionsShowPrompt(paramAnonymousString, paramAnonymousGeolocationPermissionsCallback);
        AppMethodBeat.o(153905);
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(153901);
        Log.i("X5WebView", "onHideCustomView");
        if (m.this.KDG != null)
        {
          m.this.KDG.onHideCustomView();
          AppMethodBeat.o(153901);
          return;
        }
        super.onHideCustomView();
        AppMethodBeat.o(153901);
      }
      
      public final boolean onJsAlert(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(153902);
        Log.i("X5WebView", "onJsAlert");
        if (m.this.KDG != null)
        {
          bool = m.this.KDG.a(m.this.KDD, paramAnonymousString1, paramAnonymousString2, new g.g(paramAnonymousJsResult));
          AppMethodBeat.o(153902);
          return bool;
        }
        boolean bool = super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        AppMethodBeat.o(153902);
        return bool;
      }
      
      public final boolean onJsConfirm(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(153903);
        Log.i("X5WebView", "onJsConfirm");
        if (m.this.KDG != null)
        {
          bool = m.this.KDG.b(m.this.KDD, paramAnonymousString1, paramAnonymousString2, new g.g(paramAnonymousJsResult));
          AppMethodBeat.o(153903);
          return bool;
        }
        boolean bool = super.onJsConfirm(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        AppMethodBeat.o(153903);
        return bool;
      }
      
      public final boolean onJsPrompt(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(153904);
        Log.i("X5WebView", "onJsPrompt");
        if (m.this.KDG != null)
        {
          bool = m.this.KDG.a(m.this.KDD, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, new g.h(paramAnonymousJsPromptResult));
          AppMethodBeat.o(153904);
          return bool;
        }
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(153904);
        return bool;
      }
      
      public final void onProgressChanged(com.tencent.smtt.sdk.WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(153898);
        if (m.this.KDG != null)
        {
          m.this.KDG.a(m.this.KDD, paramAnonymousInt);
          AppMethodBeat.o(153898);
          return;
        }
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(153898);
      }
      
      public final void onReceivedTitle(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153899);
        Log.i("X5WebView", "onReceivedTitle: ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.KDG != null)
        {
          m.this.KDG.d(m.this.KDD, paramAnonymousString);
          AppMethodBeat.o(153899);
          return;
        }
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153899);
      }
      
      public final void onShowCustomView(View paramAnonymousView, IX5WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(153900);
        Log.i("X5WebView", "onShowCustomView");
        if (m.this.KDG != null)
        {
          m.this.KDG.onShowCustomView(paramAnonymousView, new g.c(paramAnonymousCustomViewCallback));
          AppMethodBeat.o(153900);
          return;
        }
        super.onShowCustomView(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(153900);
      }
      
      public final boolean onShowFileChooser(com.tencent.smtt.sdk.WebView paramAnonymousWebView, com.tencent.smtt.sdk.ValueCallback<Uri[]> paramAnonymousValueCallback, WebChromeClient.FileChooserParams paramAnonymousFileChooserParams)
      {
        AppMethodBeat.i(153909);
        Log.i("X5WebView", "onShowFileChooser last method");
        if (m.this.KDG != null)
        {
          bool = m.this.KDG.a(m.this.KDD, paramAnonymousValueCallback, new g.d(paramAnonymousFileChooserParams));
          AppMethodBeat.o(153909);
          return bool;
        }
        boolean bool = super.onShowFileChooser(paramAnonymousWebView, new a.d(paramAnonymousValueCallback), paramAnonymousFileChooserParams);
        AppMethodBeat.o(153909);
        return bool;
      }
      
      public final void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> paramAnonymousValueCallback, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(153908);
        Log.i("X5WebView", "openFileChooser with three param");
        if (m.this.KDG != null)
        {
          m.this.KDG.openFileChooser(paramAnonymousValueCallback, paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(153908);
          return;
        }
        paramAnonymousValueCallback.onReceiveValue(null);
        AppMethodBeat.o(153908);
      }
    };
    this.KES = new c()
    {
      public final void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(153920);
        if (m.this.KDF != null)
        {
          m.this.KDF.a(m.this.KDD, paramAnonymousString, paramAnonymousBoolean);
          AppMethodBeat.o(153920);
          return;
        }
        super.doUpdateVisitedHistory(paramAnonymousWebView, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(153920);
      }
      
      public final void onLoadResource(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153915);
        if (m.this.KDF != null)
        {
          m.this.KDF.h(m.this.KDD, paramAnonymousString);
          AppMethodBeat.o(153915);
          return;
        }
        super.onLoadResource(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153915);
      }
      
      public final void onPageCommitVisible(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153924);
        Log.i("X5WebView", "onPageCommitVisible s = ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.KDF != null) {
          m.this.KDF.e(m.this.KDD, paramAnonymousString);
        }
        AppMethodBeat.o(153924);
      }
      
      public final void onPageFinished(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153914);
        Log.i("X5WebView", "onPageFinished ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.KDF != null) {
          m.this.KDF.b(m.this.KDD, paramAnonymousString);
        }
        for (;;)
        {
          if ((m.this.KEQ == null) || (!m.this.KEQ.equals(paramAnonymousString))) {
            h.fKq().fKm();
          }
          com.tencent.xweb.util.g.Cg(System.currentTimeMillis() - m.this.KDJ);
          d.a(m.this.KDD);
          com.tencent.xweb.util.g.Ci(System.currentTimeMillis() - m.this.KDJ);
          AppMethodBeat.o(153914);
          return;
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        }
      }
      
      public final void onPageStarted(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(153913);
        Log.i("X5WebView", "onPageStarted ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.KDF != null) {
          m.this.KDF.b(m.this.KDD, paramAnonymousString, paramAnonymousBitmap);
        }
        for (;;)
        {
          m.this.KEQ = "";
          m.this.KDJ = System.currentTimeMillis();
          com.tencent.xweb.util.g.aVp(paramAnonymousString);
          com.tencent.xweb.util.g.fKL();
          h.fKq().fKl();
          AppMethodBeat.o(153913);
          return;
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        }
      }
      
      public final void onReceivedError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(153921);
        if (m.this.KDF != null) {
          m.this.KDF.a(m.this.KDD, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        for (;;)
        {
          m.this.KEQ = paramAnonymousString2;
          com.tencent.xweb.util.g.fKI();
          h.fKq().fKr();
          com.tencent.xweb.util.g.fKM();
          AppMethodBeat.o(153921);
          return;
          super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void onReceivedHttpAuthRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(208898);
        Log.i("X5WebView", "onReceivedHttpAuthRequest host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (m.this.KDF != null)
        {
          m.this.KDF.a(m.this.KDD, new g.f(paramAnonymousHttpAuthHandler), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(208898);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousWebView, paramAnonymousHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(208898);
      }
      
      public final void onReceivedHttpError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(153923);
        Log.i("X5WebView", "onReceivedHttpError code:" + paramAnonymousWebResourceResponse.getStatusCode());
        if (m.this.KDF != null)
        {
          m.this.KDF.a(m.this.KDD, new g.b(paramAnonymousWebResourceRequest), g.a(paramAnonymousWebResourceResponse));
          AppMethodBeat.o(153923);
          return;
        }
        super.onReceivedHttpError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceResponse);
        AppMethodBeat.o(153923);
      }
      
      public final void onReceivedSslError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(153922);
        Log.i("X5WebView", "onReceivedSslError " + paramAnonymousSslError.getPrimaryError());
        if (m.this.KDF != null)
        {
          ac localac = m.this.KDF;
          com.tencent.xweb.WebView localWebView = m.this.KDD;
          paramAnonymousSslErrorHandler = new g.a(paramAnonymousSslErrorHandler);
          if (paramAnonymousSslError != null) {}
          for (paramAnonymousWebView = new android.net.http.SslError(paramAnonymousSslError.getPrimaryError(), paramAnonymousSslError.getCertificate());; paramAnonymousWebView = null)
          {
            localac.a(localWebView, paramAnonymousSslErrorHandler, paramAnonymousWebView);
            AppMethodBeat.o(153922);
            return;
          }
        }
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(153922);
      }
      
      public final void onScaleChanged(com.tencent.smtt.sdk.WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(153919);
        if (m.this.KDF != null)
        {
          m.this.KDF.a(m.this.KDD, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(153919);
          return;
        }
        super.onScaleChanged(paramAnonymousWebView, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(153919);
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(153917);
        if (m.this.KDF != null)
        {
          paramAnonymousWebView = new g.b(paramAnonymousWebResourceRequest);
          paramAnonymousWebView = a.b(m.this.KDF.a(m.this.KDD, paramAnonymousWebView));
          AppMethodBeat.o(153917);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(153917);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(153918);
        if (m.this.KDF != null)
        {
          paramAnonymousWebView = new g.b(paramAnonymousWebResourceRequest);
          paramAnonymousWebView = a.b(m.this.KDF.a(m.this.KDD, paramAnonymousWebView, paramAnonymousBundle));
          AppMethodBeat.o(153918);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousBundle);
        AppMethodBeat.o(153918);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153916);
        if (m.this.KDF != null)
        {
          paramAnonymousWebView = a.b(m.this.KDF.c(m.this.KDD, paramAnonymousString));
          AppMethodBeat.o(153916);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153916);
        return paramAnonymousWebView;
      }
      
      public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(153911);
        Log.i("X5WebView", "shouldOverrideUrlLoading " + paramAnonymousWebResourceRequest.getUrl().toString());
        if (m.this.KDF != null)
        {
          paramAnonymousWebView = new g.b(paramAnonymousWebResourceRequest);
          bool = m.this.KDF.d(m.this.KDD, paramAnonymousWebView);
          AppMethodBeat.o(153911);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(153911);
        return bool;
      }
      
      public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(153912);
        if (d.aVv(paramAnonymousString))
        {
          AppMethodBeat.o(153912);
          return true;
        }
        Log.i("X5WebView", "shouldOverrideUrlLoading ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.KDF != null)
        {
          bool = m.this.KDF.a(m.this.KDD, paramAnonymousString);
          AppMethodBeat.o(153912);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(153912);
        return bool;
      }
    };
    this.KDD = paramWebView;
    this.KEH = new a(paramWebView.getContext());
    this.KEH.setBackgroundColor(0);
    this.KEO = new j(this.KEH);
    this.KEH.setWebChromeClient(this.KER);
    this.KEH.setWebViewClient(this.KES);
    this.KEO.KEF = this.KES;
    this.KEO.KEG = this.KER;
    AppMethodBeat.o(153927);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(153962);
    this.KEH.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(153962);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(153945);
    boolean bool = this.KEH.canGoBack();
    AppMethodBeat.o(153945);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(153978);
    boolean bool = this.KEH.canGoForward();
    AppMethodBeat.o(153978);
    return bool;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(153984);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153925);
        int i = m.this.KEH.getHeight();
        Canvas localCanvas = new Canvas(Bitmap.createBitmap(m.this.KEH.getWidth(), i, Bitmap.Config.ARGB_8888));
        m.this.KEH.draw(localCanvas);
        Log.d("X5WebView", "bitmapCaptureFinished");
        AppMethodBeat.o(153925);
      }
    }).start();
    AppMethodBeat.o(153984);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(153977);
    this.KEH.clearHistory();
    AppMethodBeat.o(153977);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(153969);
    this.KEH.clearMatches();
    AppMethodBeat.o(153969);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(153952);
    this.KEH.clearSslPreferences();
    AppMethodBeat.o(153952);
  }
  
  public final void clearView()
  {
    AppMethodBeat.i(153947);
    this.KEH.clearView();
    AppMethodBeat.o(153947);
  }
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(208899);
    i locali = new i(this.KEH.copyBackForwardList());
    AppMethodBeat.o(208899);
    return locali;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(153948);
    this.KEH.destroy();
    AppMethodBeat.o(153948);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean) {}
  
  public final void evaluateJavascript(String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(153950);
    this.KEH.evaluateJavascript(paramString, new a.d(paramValueCallback));
    AppMethodBeat.o(153950);
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(153971);
    this.KEH.findAllAsync(paramString);
    AppMethodBeat.o(153971);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(153970);
    this.KEH.findNext(paramBoolean);
    AppMethodBeat.o(153970);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(153973);
    Object localObject = new StringBuilder("webviewtype = x5, is using x5 core = ");
    if (this.KEH.getX5WebViewExtension() != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + "\n core version = " + QbSdk.getTbsVersion(this.KDD.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.KDD.getContext()) + "\n canUseX5JsCore = " + X5JsCore.canUseX5JsCore(this.KDD.getContext()) + "\n canUseNativeBuffer = " + X5JsCore.canX5JsCoreUseNativeBuffer(this.KDD.getContext());
      AppMethodBeat.o(153973);
      return localObject;
    }
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(153954);
    int i = this.KEH.getContentHeight();
    AppMethodBeat.o(153954);
    return i;
  }
  
  public final x getCurWebChromeClient()
  {
    return this.KDG;
  }
  
  public final ac getCurWebviewClient()
  {
    return this.KDF;
  }
  
  public final e getDefalutOpProvider()
  {
    return this.KEO;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    return WebView.a.KzU;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(153967);
    WebView.HitTestResult localHitTestResult = this.KEH.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.mType = localHitTestResult.getType();
    localb.mExtra = localHitTestResult.getExtra();
    AppMethodBeat.o(153967);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208901);
    paramString1 = this.KEH.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(208901);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, com.tencent.xweb.i parami)
  {
    return false;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(153955);
    float f = this.KEH.getScale();
    AppMethodBeat.o(153955);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(153988);
    int i = this.KEH.computeVerticalScrollRange();
    AppMethodBeat.o(153988);
    return i;
  }
  
  public final z getSettings()
  {
    AppMethodBeat.i(153939);
    if (this.KEP != null)
    {
      localo = this.KEP;
      AppMethodBeat.o(153939);
      return localo;
    }
    if (this.KEH == null)
    {
      AppMethodBeat.o(153939);
      return null;
    }
    this.KEP = new o(this.KEH);
    o localo = this.KEP;
    AppMethodBeat.o(153939);
    return localo;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(153968);
    String str = this.KEH.getTitle();
    AppMethodBeat.o(153968);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    AppMethodBeat.i(153941);
    ViewGroup localViewGroup = (ViewGroup)this.KEH.getView();
    AppMethodBeat.o(153941);
    return localViewGroup;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(153963);
    String str = this.KEH.getUrl();
    AppMethodBeat.o(153963);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(153972);
    if (this.KEH.getX5WebViewExtension() != null) {}
    for (int i = 1; i != 0; i = 0)
    {
      str = "use x5 and x5 kernel, sdk ver = " + com.tencent.xweb.WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + com.tencent.xweb.WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + JsRuntime.fJg();
      AppMethodBeat.o(153972);
      return str;
    }
    String str = "use x5 wrapped sys kernel, sdk ver = " + com.tencent.xweb.WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + com.tencent.xweb.WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + JsRuntime.fJg();
    AppMethodBeat.o(153972);
    return str;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(153940);
    View localView = this.KEH.getView();
    AppMethodBeat.o(153940);
    return localView;
  }
  
  public final int getVisibleTitleHeight()
  {
    AppMethodBeat.i(153956);
    int i = this.KEH.getVisibleTitleHeight();
    AppMethodBeat.o(153956);
    return i;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(153975);
    int i = getWebViewUI().getScrollX();
    AppMethodBeat.o(153975);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(153974);
    int i = this.KEH.getWebScrollY();
    AppMethodBeat.o(153974);
    return i;
  }
  
  public final View getWebViewUI()
  {
    return this.KEH;
  }
  
  public final Object getX5WebViewExtension()
  {
    AppMethodBeat.i(153928);
    IX5WebViewExtension localIX5WebViewExtension = this.KEH.getX5WebViewExtension();
    AppMethodBeat.o(153928);
    return localIX5WebViewExtension;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(153946);
    this.KEH.goBack();
    AppMethodBeat.o(153946);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(153979);
    this.KEH.goForward();
    AppMethodBeat.o(153979);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return false;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(153983);
    if (this.KEH.getX5WebViewExtension() == null)
    {
      Log.d("X5WebView", "invokeMiscMethod  extension is null");
      AppMethodBeat.o(153983);
      return null;
    }
    Log.d("X5WebView", "invokeMiscMethod x5  extension");
    paramString = this.KEH.getX5WebViewExtension().invokeMiscMethod(paramString, paramBundle);
    if ((paramString instanceof Bundle))
    {
      paramString = (Bundle)paramString;
      AppMethodBeat.o(153983);
      return paramString;
    }
    Log.d("X5WebView", "invokeMiscMethod  extension is null");
    AppMethodBeat.o(153983);
    return null;
  }
  
  public final boolean isOverScrollStart()
  {
    AppMethodBeat.i(153976);
    if (getView().getScrollY() == 0)
    {
      AppMethodBeat.o(153976);
      return true;
    }
    AppMethodBeat.o(153976);
    return false;
  }
  
  public final boolean isSupportExtendPluginForAppbrand()
  {
    return false;
  }
  
  public final void leaveFullscreen() {}
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(153953);
    this.KEH.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(153953);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(153958);
    this.KEH.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(153958);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(153944);
    this.KEH.loadUrl(paramString);
    AppMethodBeat.o(153944);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(153961);
    this.KEH.loadUrl(paramString, paramMap);
    AppMethodBeat.o(153961);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(153987);
    this.KEH.onPause();
    AppMethodBeat.o(153987);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(153938);
    this.KEH.onPause();
    AppMethodBeat.o(153938);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(153937);
    this.KEH.onResume();
    AppMethodBeat.o(153937);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(153986);
    this.KEH.onResume();
    AppMethodBeat.o(153986);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(153957);
    boolean bool = this.KEH.overlayHorizontalScrollbar();
    AppMethodBeat.o(153957);
    return bool;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(153951);
    this.KEH.reload();
    AppMethodBeat.o(153951);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(153964);
    this.KEH.removeJavascriptInterface(paramString);
    AppMethodBeat.o(153964);
  }
  
  public final boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public final void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(153985);
    Log.e("X5WebView", "setBottomHeight not implement");
    AppMethodBeat.o(153985);
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(153942);
    this.KEH.setDownloadListener(new a.a(paramDownloadListener));
    AppMethodBeat.o(153942);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(153943);
    this.KEH.setFindListener(new a.b(paramFindListener));
    AppMethodBeat.o(153943);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153982);
    this.KEH.getView().setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153982);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(208900);
    this.KEH.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(208900);
  }
  
  public final void setJSExceptionListener(ae paramae) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153981);
    this.KEH.getView().setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153981);
  }
  
  public final u setVideoJsCallback(v paramv)
  {
    AppMethodBeat.i(153949);
    Log.i("X5WebView", "setVideoJsCallback not support");
    AppMethodBeat.o(153949);
    return null;
  }
  
  public final void setWebChromeClient(x paramx)
  {
    this.KDG = paramx;
  }
  
  public final void setWebViewCallbackClient(ab paramab)
  {
    AppMethodBeat.i(153966);
    this.KEH.setWebViewCallbackClient(new a.f(paramab));
    AppMethodBeat.o(153966);
  }
  
  public final void setWebViewClient(ac paramac)
  {
    this.KDF = paramac;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(153929);
    if (parama == null)
    {
      this.KEH.setWebViewClientExtension(null);
      AppMethodBeat.o(153929);
      return;
    }
    this.KEH.setWebViewClientExtension(new ProxyWebViewSuperWrapper(parama));
    AppMethodBeat.o(153929);
  }
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong) {}
  
  public final void stopLoading()
  {
    AppMethodBeat.i(153965);
    this.KEH.stopLoading();
    AppMethodBeat.o(153965);
  }
  
  public final void super_computeScroll()
  {
    AppMethodBeat.i(153934);
    this.KEH.super_computeScroll();
    AppMethodBeat.o(153934);
  }
  
  public final boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153933);
    boolean bool = this.KEH.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153933);
    return bool;
  }
  
  public final boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153931);
    boolean bool = this.KEH.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153931);
    return bool;
  }
  
  public final void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(153932);
    this.KEH.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(153932);
  }
  
  public final void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(153935);
    this.KEH.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(153935);
  }
  
  public final boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153930);
    boolean bool = this.KEH.super_onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153930);
    return bool;
  }
  
  public final boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(153936);
    paramBoolean = this.KEH.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(153936);
    return paramBoolean;
  }
  
  public final boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(153980);
    if (paramInt == 2006)
    {
      paramInt = QbSdk.getTbsVersion(this.KEH.getContext());
      if (paramInt >= 44900)
      {
        AppMethodBeat.o(153980);
        return true;
      }
      if (paramInt <= 0)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          AppMethodBeat.o(153980);
          return true;
        }
        AppMethodBeat.o(153980);
        return false;
      }
    }
    AppMethodBeat.o(153980);
    return false;
  }
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(153960);
    boolean bool = this.KEH.zoomIn();
    AppMethodBeat.o(153960);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(153959);
    boolean bool = this.KEH.zoomOut();
    AppMethodBeat.o(153959);
    return bool;
  }
  
  final class a
    extends com.tencent.smtt.sdk.WebView
  {
    public a(Context paramContext)
    {
      super();
    }
    
    protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(153926);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (m.this.KDD != null) {
        m.this.KDD.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(153926);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.m
 * JD-Core Version:    0.7.0.1
 */