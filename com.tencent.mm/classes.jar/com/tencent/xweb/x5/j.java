package com.tencent.xweb.x5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebChromeClientExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ad;
import com.tencent.xweb.af;
import com.tencent.xweb.ag;
import com.tencent.xweb.ai;
import com.tencent.xweb.al;
import com.tencent.xweb.extension.video.c;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.i;
import com.tencent.xweb.util.l;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class j
  implements IWebView
{
  private com.tencent.xweb.WebView aigp;
  private boolean aihJ;
  private ag aikH;
  private z aikI;
  private long aikJ;
  private com.tencent.xweb.extension.video.a aikP;
  private com.tencent.smtt.sdk.WebView aimV;
  private g aino;
  private m ainp;
  private String ainq;
  private IX5WebChromeClient.CustomViewCallback ainr;
  private f ains;
  private k aint;
  private int oG;
  private af sLl;
  
  public j(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153927);
    this.aikJ = 0L;
    this.ainq = "";
    this.oG = -1;
    this.ainr = null;
    this.aihJ = false;
    this.ains = new f()
    {
      public final View getVideoLoadingProgressView()
      {
        AppMethodBeat.i(213293);
        if (j.b(j.this) != null)
        {
          localView = j.b(j.this).getVideoLoadingProgressView();
          AppMethodBeat.o(213293);
          return localView;
        }
        View localView = super.getVideoLoadingProgressView();
        AppMethodBeat.o(213293);
        return localView;
      }
      
      public final boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(213267);
        if (j.b(j.this) != null)
        {
          z localz = j.b(j.this);
          if (paramAnonymousConsoleMessage == null)
          {
            paramAnonymousConsoleMessage = null;
            bool = localz.onConsoleMessage(paramAnonymousConsoleMessage);
            AppMethodBeat.o(213267);
            return bool;
          }
          ConsoleMessage.MessageLevel localMessageLevel = ConsoleMessage.MessageLevel.DEBUG;
          switch (d.2.aimZ[paramAnonymousConsoleMessage.messageLevel().ordinal()])
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
        AppMethodBeat.o(213267);
        return bool;
      }
      
      public final void onGeolocationPermissionsHidePrompt()
      {
        AppMethodBeat.i(213258);
        Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
        if (j.b(j.this) != null)
        {
          j.b(j.this).onGeolocationPermissionsHidePrompt();
          AppMethodBeat.o(213258);
          return;
        }
        super.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(213258);
      }
      
      public final void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissionsCallback paramAnonymousGeolocationPermissionsCallback)
      {
        AppMethodBeat.i(213254);
        Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
        if (j.b(j.this) != null)
        {
          j.b(j.this).onGeolocationPermissionsShowPrompt(paramAnonymousString, new d.e(paramAnonymousGeolocationPermissionsCallback));
          AppMethodBeat.o(213254);
          return;
        }
        super.onGeolocationPermissionsShowPrompt(paramAnonymousString, paramAnonymousGeolocationPermissionsCallback);
        AppMethodBeat.o(213254);
      }
      
      public final void onHideCustomView()
      {
        boolean bool = false;
        AppMethodBeat.i(213233);
        Log.i("X5WebView", "onHideCustomView");
        j.a(j.this, null);
        j.a(j.this, false);
        if (j.b(j.this) != null) {
          bool = j.b(j.this).cxL();
        }
        if (bool)
        {
          Log.i("X5WebView", "onHideCustomView, isHandled:true");
          AppMethodBeat.o(213233);
          return;
        }
        if (j.d(j.this) != null)
        {
          j.d(j.this).onHideCustomView();
          AppMethodBeat.o(213233);
          return;
        }
        if (j.b(j.this) != null)
        {
          j.b(j.this).onHideCustomView();
          AppMethodBeat.o(213233);
          return;
        }
        super.onHideCustomView();
        AppMethodBeat.o(213233);
      }
      
      public final boolean onJsAlert(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(213239);
        Log.i("X5WebView", "onJsAlert");
        if (j.b(j.this) != null)
        {
          bool = j.b(j.this).a(j.a(j.this), paramAnonymousString1, paramAnonymousString2, new d.g(paramAnonymousJsResult));
          AppMethodBeat.o(213239);
          return bool;
        }
        boolean bool = super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        AppMethodBeat.o(213239);
        return bool;
      }
      
      public final boolean onJsConfirm(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(213243);
        Log.i("X5WebView", "onJsConfirm");
        if (j.b(j.this) != null)
        {
          bool = j.b(j.this).b(j.a(j.this), paramAnonymousString1, paramAnonymousString2, new d.g(paramAnonymousJsResult));
          AppMethodBeat.o(213243);
          return bool;
        }
        boolean bool = super.onJsConfirm(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        AppMethodBeat.o(213243);
        return bool;
      }
      
      public final boolean onJsPrompt(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(213248);
        Log.i("X5WebView", "onJsPrompt");
        if (j.b(j.this) != null)
        {
          bool = j.b(j.this).a(j.a(j.this), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, new d.h(paramAnonymousJsPromptResult));
          AppMethodBeat.o(213248);
          return bool;
        }
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(213248);
        return bool;
      }
      
      public final void onProgressChanged(com.tencent.smtt.sdk.WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(213220);
        if (j.b(j.this) != null)
        {
          j.b(j.this).a(j.a(j.this), paramAnonymousInt);
          AppMethodBeat.o(213220);
          return;
        }
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(213220);
      }
      
      public final void onReceivedTitle(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213223);
        Log.i("X5WebView", "onReceivedTitle: ".concat(String.valueOf(paramAnonymousString)));
        if (j.b(j.this) != null)
        {
          j.b(j.this).d(j.a(j.this), paramAnonymousString);
          if (j.d(j.this) != null)
          {
            paramAnonymousWebView = j.d(j.this);
            if (j.a(j.this).getFullscreenVideoKind() != WebView.a.aifF) {
              break label106;
            }
          }
        }
        label106:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bV(true, bool);
          AppMethodBeat.o(213223);
          return;
          super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
          break;
        }
      }
      
      public final void onShowCustomView(View paramAnonymousView, final IX5WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(213228);
        Log.i("X5WebView", "onShowCustomView");
        j.a(j.this, paramAnonymousCustomViewCallback);
        j.a(j.this, true);
        boolean bool = false;
        if (j.b(j.this) != null) {
          bool = j.b(j.this).a(paramAnonymousView, new d.c(paramAnonymousCustomViewCallback));
        }
        l.kia();
        if (bool)
        {
          Log.i("X5WebView", "onShowCustomView, isHandled:true");
          AppMethodBeat.o(213228);
          return;
        }
        if (j.d(j.this) != null)
        {
          l.a(WebView.WebViewKind.aifJ, j.d(j.this) instanceof com.tencent.xweb.extension.video.d, j.this.getUrl());
          j.d(j.this).onShowCustomView(paramAnonymousView, new WebChromeClient.CustomViewCallback()
          {
            public final void onCustomViewHidden()
            {
              AppMethodBeat.i(213210);
              paramAnonymousCustomViewCallback.onCustomViewHidden();
              AppMethodBeat.o(213210);
            }
          });
          AppMethodBeat.o(213228);
          return;
        }
        if (j.b(j.this) != null)
        {
          j.b(j.this).onShowCustomView(paramAnonymousView, new d.c(paramAnonymousCustomViewCallback));
          AppMethodBeat.o(213228);
          return;
        }
        super.onShowCustomView(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(213228);
      }
      
      public final boolean onShowFileChooser(com.tencent.smtt.sdk.WebView paramAnonymousWebView, com.tencent.smtt.sdk.ValueCallback<Uri[]> paramAnonymousValueCallback, WebChromeClient.FileChooserParams paramAnonymousFileChooserParams)
      {
        AppMethodBeat.i(213288);
        Log.i("X5WebView", "onShowFileChooser last method");
        if (j.b(j.this) != null)
        {
          bool = j.b(j.this).a(j.a(j.this), paramAnonymousValueCallback, new d.d(paramAnonymousFileChooserParams));
          AppMethodBeat.o(213288);
          return bool;
        }
        boolean bool = super.onShowFileChooser(paramAnonymousWebView, new a.d(paramAnonymousValueCallback), paramAnonymousFileChooserParams);
        AppMethodBeat.o(213288);
        return bool;
      }
      
      public final void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> paramAnonymousValueCallback, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(213277);
        Log.i("X5WebView", "openFileChooser with three param");
        if (j.b(j.this) != null)
        {
          j.b(j.this).openFileChooser(paramAnonymousValueCallback, paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(213277);
          return;
        }
        paramAnonymousValueCallback.onReceiveValue(null);
        AppMethodBeat.o(213277);
      }
    };
    this.aint = new k()
    {
      public final void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(213308);
        if (j.e(j.this) != null)
        {
          j.e(j.this).b(j.a(j.this), paramAnonymousString, paramAnonymousBoolean);
          AppMethodBeat.o(213308);
          return;
        }
        super.doUpdateVisitedHistory(paramAnonymousWebView, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(213308);
      }
      
      public final void onLoadResource(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213255);
        if (j.e(j.this) != null)
        {
          j.e(j.this).i(j.a(j.this), paramAnonymousString);
          AppMethodBeat.o(213255);
          return;
        }
        super.onLoadResource(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(213255);
      }
      
      public final void onPageCommitVisible(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213390);
        Log.i("X5WebView", "onPageCommitVisible s = ".concat(String.valueOf(paramAnonymousString)));
        if (j.e(j.this) != null) {
          j.e(j.this).e(j.a(j.this), paramAnonymousString);
        }
        AppMethodBeat.o(213390);
      }
      
      public final void onPageFinished(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213247);
        Log.i("X5WebView", "onPageFinished, url:".concat(String.valueOf(paramAnonymousString)));
        if (j.e(j.this) != null)
        {
          j.e(j.this).b(j.a(j.this), paramAnonymousString);
          if (j.d(j.this) != null)
          {
            paramAnonymousWebView = j.d(j.this);
            if (j.a(j.this).getFullscreenVideoKind() != WebView.a.aifF) {
              break label174;
            }
          }
        }
        label174:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bV(false, bool);
          if ((j.f(j.this) == null) || (!j.f(j.this).equals(paramAnonymousString))) {
            i.khf().kha();
          }
          l.Bs(System.currentTimeMillis() - j.g(j.this));
          com.tencent.xweb.xwalk.d.a(j.a(j.this));
          l.Bu(System.currentTimeMillis() - j.g(j.this));
          AppMethodBeat.o(213247);
          return;
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          break;
        }
      }
      
      public final void onPageStarted(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(213241);
        Log.i("X5WebView", "onPageStarted, url:".concat(String.valueOf(paramAnonymousString)));
        if (j.e(j.this) != null)
        {
          j.e(j.this).b(j.a(j.this), paramAnonymousString, paramAnonymousBitmap);
          if (j.d(j.this) != null)
          {
            paramAnonymousWebView = j.d(j.this);
            if (j.a(j.this).getFullscreenVideoKind() != WebView.a.aifF) {
              break label144;
            }
          }
        }
        label144:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bV(true, bool);
          j.a(j.this, "");
          j.a(j.this, System.currentTimeMillis());
          l.bIf(paramAnonymousString);
          l.khM();
          i.khf().kgZ();
          AppMethodBeat.o(213241);
          return;
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          break;
        }
      }
      
      public final void onReceivedError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(213322);
        if (j.e(j.this) != null) {
          j.e(j.this).a(j.a(j.this), paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        for (;;)
        {
          j.a(j.this, paramAnonymousString2);
          l.khJ();
          i.khf().khg();
          l.khN();
          AppMethodBeat.o(213322);
          return;
          super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void onReceivedError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
      {
        Object localObject = null;
        AppMethodBeat.i(213335);
        if (j.e(j.this) != null)
        {
          ag localag;
          com.tencent.xweb.WebView localWebView;
          if ((paramAnonymousWebResourceRequest.isForMainFrame()) && (paramAnonymousWebResourceRequest != null) && (paramAnonymousWebResourceError != null))
          {
            localag = j.e(j.this);
            localWebView = j.a(j.this);
            int i = paramAnonymousWebResourceError.getErrorCode();
            String str = paramAnonymousWebResourceError.getDescription().toString();
            if (paramAnonymousWebResourceRequest.getUrl() != null)
            {
              paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
              localag.a(localWebView, i, str, paramAnonymousWebView);
            }
          }
          else
          {
            localag = j.e(j.this);
            localWebView = j.a(j.this);
            paramAnonymousWebResourceRequest = new d.b(paramAnonymousWebResourceRequest);
            if (paramAnonymousWebResourceError != null) {
              break label155;
            }
          }
          label155:
          for (paramAnonymousWebView = localObject;; paramAnonymousWebView = new d.1(paramAnonymousWebResourceError))
          {
            localag.a(localWebView, paramAnonymousWebResourceRequest, paramAnonymousWebView);
            AppMethodBeat.o(213335);
            return;
            paramAnonymousWebView = null;
            break;
          }
        }
        super.onReceivedError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceError);
        AppMethodBeat.o(213335);
      }
      
      public final void onReceivedHttpAuthRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(213347);
        Log.i("X5WebView", "onReceivedHttpAuthRequest host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (j.e(j.this) != null)
        {
          j.e(j.this).a(j.a(j.this), new d.f(paramAnonymousHttpAuthHandler), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(213347);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousWebView, paramAnonymousHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(213347);
      }
      
      public final void onReceivedHttpError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(213378);
        Log.i("X5WebView", "onReceivedHttpError code:" + paramAnonymousWebResourceResponse.getStatusCode());
        if (j.e(j.this) != null)
        {
          j.e(j.this).a(j.a(j.this), new d.b(paramAnonymousWebResourceRequest), d.a(paramAnonymousWebResourceResponse));
          AppMethodBeat.o(213378);
          return;
        }
        super.onReceivedHttpError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceResponse);
        AppMethodBeat.o(213378);
      }
      
      public final void onReceivedSslError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(213363);
        Log.i("X5WebView", "onReceivedSslError, error:" + paramAnonymousSslError.getPrimaryError());
        if (j.e(j.this) != null)
        {
          ag localag = j.e(j.this);
          com.tencent.xweb.WebView localWebView = j.a(j.this);
          paramAnonymousSslErrorHandler = new d.a(paramAnonymousSslErrorHandler);
          if (paramAnonymousSslError != null) {}
          for (paramAnonymousWebView = new android.net.http.SslError(paramAnonymousSslError.getPrimaryError(), paramAnonymousSslError.getCertificate());; paramAnonymousWebView = null)
          {
            localag.a(localWebView, paramAnonymousSslErrorHandler, paramAnonymousWebView);
            AppMethodBeat.o(213363);
            return;
          }
        }
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(213363);
      }
      
      public final void onScaleChanged(com.tencent.smtt.sdk.WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(213299);
        if (j.e(j.this) != null)
        {
          j.e(j.this).a(j.a(j.this), paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(213299);
          return;
        }
        super.onScaleChanged(paramAnonymousWebView, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(213299);
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(213278);
        if (j.e(j.this) != null)
        {
          paramAnonymousWebView = new d.b(paramAnonymousWebResourceRequest);
          paramAnonymousWebView = a.b(j.e(j.this).a(j.a(j.this), paramAnonymousWebView));
          AppMethodBeat.o(213278);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(213278);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(213291);
        if (j.e(j.this) != null)
        {
          paramAnonymousWebView = new d.b(paramAnonymousWebResourceRequest);
          paramAnonymousWebView = a.b(j.e(j.this).a(j.a(j.this), paramAnonymousWebView, paramAnonymousBundle));
          AppMethodBeat.o(213291);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousBundle);
        AppMethodBeat.o(213291);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213266);
        if (j.e(j.this) != null)
        {
          paramAnonymousWebView = a.b(j.e(j.this).c(j.a(j.this), paramAnonymousString));
          AppMethodBeat.o(213266);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(213266);
        return paramAnonymousWebView;
      }
      
      public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(213225);
        Log.i("X5WebView", "shouldOverrideUrlLoading, url:" + paramAnonymousWebResourceRequest.getUrl().toString());
        if (j.e(j.this) != null)
        {
          paramAnonymousWebView = new d.b(paramAnonymousWebResourceRequest);
          bool = j.e(j.this).e(j.a(j.this), paramAnonymousWebView);
          AppMethodBeat.o(213225);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(213225);
        return bool;
      }
      
      public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213231);
        if (com.tencent.xweb.xwalk.d.bIm(paramAnonymousString))
        {
          AppMethodBeat.o(213231);
          return true;
        }
        Log.i("X5WebView", "shouldOverrideUrlLoading, url:".concat(String.valueOf(paramAnonymousString)));
        if (j.e(j.this) != null)
        {
          bool = j.e(j.this).a(j.a(j.this), paramAnonymousString);
          AppMethodBeat.o(213231);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(213231);
        return bool;
      }
    };
    this.aigp = paramWebView;
    this.aimV = new a(paramWebView.getContext());
    this.aimV.setBackgroundColor(0);
    this.aino = new g(this.aimV);
    this.aimV.setWebChromeClient(this.ains);
    this.aimV.setWebViewClient(this.aint);
    this.aimV.setWebChromeClientExtension(new ProxyWebChromeClientExtension()
    {
      public final boolean onPermissionRequest(String paramAnonymousString, long paramAnonymousLong, MediaAccessPermissionsCallback paramAnonymousMediaAccessPermissionsCallback)
      {
        AppMethodBeat.i(213205);
        if (j.b(j.this) != null)
        {
          j.b(j.this).onPermissionRequest(new j.b(paramAnonymousString, paramAnonymousLong, paramAnonymousMediaAccessPermissionsCallback));
          AppMethodBeat.o(213205);
          return true;
        }
        AppMethodBeat.o(213205);
        return false;
      }
    });
    this.aino.aini = this.aint;
    this.aino.ainj = this.ains;
    setWebViewClientExtension(null);
    paramWebView = this.aigp.getContext();
    Log.i("X5WebView", "initFullscreenVideo, kind:" + getFullscreenVideoKind() + ", activity:" + paramWebView);
    if (getFullscreenVideoKind() != WebView.a.aifD)
    {
      this.aikP = com.tencent.xweb.extension.video.e.a(this.aigp.getWebCoreType(), paramWebView, this.aigp, this.aimV, c.kgA());
      if (getFullscreenVideoKind() == WebView.a.aifF) {
        this.aikP.hm(this.aimV);
      }
    }
    try
    {
      if (this.aimV.getSettingsExtension() != null) {
        this.aimV.getSettingsExtension().setDisplayCutoutEnable(false);
      }
      AppMethodBeat.o(153927);
      return;
    }
    finally
    {
      Log.e("X5WebView", "setDisplayCutoutEnable error:".concat(String.valueOf(paramWebView)));
      AppMethodBeat.o(153927);
    }
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(153962);
    this.aimV.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(153962);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(153945);
    boolean bool = this.aimV.canGoBack();
    AppMethodBeat.o(153945);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(153978);
    boolean bool = this.aimV.canGoForward();
    AppMethodBeat.o(153978);
    return bool;
  }
  
  public final Bitmap captureBitmap()
  {
    AppMethodBeat.i(213735);
    if (((getX5WebViewExtension() instanceof IX5WebViewExtension)) && (!this.aigp.isSysKernel()))
    {
      i = this.aimV.getHeight();
      localBitmap = Bitmap.createBitmap(this.aimV.getWidth(), i, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      ((IX5WebViewExtension)getX5WebViewExtension()).snapshotVisible(localCanvas, false, false, false, false);
      AppMethodBeat.o(213735);
      return localBitmap;
    }
    int i = this.aimV.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(this.aimV.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.aimV.draw(localCanvas);
    AppMethodBeat.o(213735);
    return localBitmap;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(153984);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213215);
        int i = j.h(j.this).getHeight();
        Canvas localCanvas = new Canvas(Bitmap.createBitmap(j.h(j.this).getWidth(), i, Bitmap.Config.ARGB_8888));
        j.h(j.this).draw(localCanvas);
        Log.d("X5WebView", "bitmapCaptureFinished");
        AppMethodBeat.o(213215);
      }
    }).start();
    AppMethodBeat.o(153984);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(153977);
    this.aimV.clearHistory();
    AppMethodBeat.o(153977);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(153969);
    this.aimV.clearMatches();
    AppMethodBeat.o(153969);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(153952);
    this.aimV.clearSslPreferences();
    AppMethodBeat.o(153952);
  }
  
  public final void clearView()
  {
    AppMethodBeat.i(153947);
    this.aimV.clearView();
    AppMethodBeat.o(153947);
  }
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(213792);
    e locale = new e(this.aimV.copyBackForwardList());
    AppMethodBeat.o(213792);
    return locale;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(153948);
    this.aimV.destroy();
    AppMethodBeat.o(153948);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(213405);
    if (this.aikP != null) {
      this.aikP.OV(paramBoolean);
    }
    AppMethodBeat.o(213405);
  }
  
  public final void evaluateJavascript(String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(153950);
    this.aimV.evaluateJavascript(paramString, new a.d(paramValueCallback));
    AppMethodBeat.o(153950);
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(153971);
    this.aimV.findAllAsync(paramString);
    AppMethodBeat.o(153971);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(153970);
    this.aimV.findNext(paramBoolean);
    AppMethodBeat.o(153970);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(153973);
    Object localObject = new StringBuilder("x5, using x5 core = ");
    if (this.aimV.getX5WebViewExtension() != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + "\n core version = " + QbSdk.getTbsVersion(this.aigp.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.aigp.getContext()) + "\n canUseX5JsCore = " + X5JsCore.canUseX5JsCore(this.aigp.getContext()) + "\n canUseNativeBuffer = " + X5JsCore.canX5JsCoreUseNativeBuffer(this.aigp.getContext());
      AppMethodBeat.o(153973);
      return localObject;
    }
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(153954);
    int i = this.aimV.getContentHeight();
    AppMethodBeat.o(153954);
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
    return this.aino;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(213643);
    Object localObject = com.tencent.xweb.a.keX();
    localObject = ((com.tencent.xweb.a)localObject).bHk(((com.tencent.xweb.a)localObject).qM("setx5fullscreenvideo", com.tencent.xweb.WebView.getCurStrModule()));
    AppMethodBeat.o(213643);
    return localObject;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(153967);
    WebView.HitTestResult localHitTestResult = this.aimV.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.mType = localHitTestResult.getType();
    localb.mExtra = localHitTestResult.getExtra();
    AppMethodBeat.o(153967);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213813);
    paramString1 = this.aimV.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(213813);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, com.tencent.xweb.k paramk)
  {
    return false;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(153955);
    float f = this.aimV.getScale();
    AppMethodBeat.o(153955);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(153988);
    int i = this.aimV.computeVerticalScrollRange();
    AppMethodBeat.o(153988);
    return i;
  }
  
  public final ad getSettings()
  {
    AppMethodBeat.i(153939);
    if (this.ainp != null)
    {
      localm = this.ainp;
      AppMethodBeat.o(153939);
      return localm;
    }
    if (this.aimV == null)
    {
      AppMethodBeat.o(153939);
      return null;
    }
    this.ainp = new m(this.aimV);
    m localm = this.ainp;
    AppMethodBeat.o(153939);
    return localm;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(153968);
    String str = this.aimV.getTitle();
    AppMethodBeat.o(153968);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    AppMethodBeat.i(153941);
    ViewGroup localViewGroup = (ViewGroup)this.aimV.getView();
    AppMethodBeat.o(153941);
    return localViewGroup;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(153963);
    String str = this.aimV.getUrl();
    AppMethodBeat.o(153963);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(153972);
    int i;
    if (this.aimV.getX5WebViewExtension() != null)
    {
      i = 1;
      if (i == 0) {
        break label78;
      }
    }
    label78:
    for (String str = "x5";; str = "sys")
    {
      str = String.format("x5 wrapped %s kernel, sdk ver:%s, core ver:%s", new Object[] { str, Integer.valueOf(com.tencent.xweb.WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext())), Integer.valueOf(com.tencent.xweb.WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext())) });
      AppMethodBeat.o(153972);
      return str;
      i = 0;
      break;
    }
  }
  
  public final View getView()
  {
    AppMethodBeat.i(153940);
    View localView = this.aimV.getView();
    AppMethodBeat.o(153940);
    return localView;
  }
  
  public final int getVisibleTitleHeight()
  {
    AppMethodBeat.i(153956);
    int i = this.aimV.getVisibleTitleHeight();
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
    int i = this.aimV.getWebScrollY();
    AppMethodBeat.o(153974);
    return i;
  }
  
  public final af getWebViewCallbackClient()
  {
    return this.sLl;
  }
  
  public final View getWebViewUI()
  {
    return this.aimV;
  }
  
  public final Object getX5WebViewExtension()
  {
    AppMethodBeat.i(153928);
    IX5WebViewExtension localIX5WebViewExtension = this.aimV.getX5WebViewExtension();
    AppMethodBeat.o(153928);
    return localIX5WebViewExtension;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(153946);
    this.aimV.goBack();
    AppMethodBeat.o(153946);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(153979);
    this.aimV.goForward();
    AppMethodBeat.o(153979);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.aihJ;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(153983);
    if (this.aimV.getX5WebViewExtension() == null)
    {
      Log.d("X5WebView", "invokeMiscMethod, extension is null");
      AppMethodBeat.o(153983);
      return null;
    }
    Log.d("X5WebView", "invokeMiscMethod x5 extension");
    paramString = this.aimV.getX5WebViewExtension().invokeMiscMethod(paramString, paramBundle);
    if ((paramString instanceof Bundle))
    {
      paramString = (Bundle)paramString;
      AppMethodBeat.o(153983);
      return paramString;
    }
    Log.d("X5WebView", "invokeMiscMethod, extension is null");
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
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(213379);
    if (this.ainr != null) {
      this.ainr.onCustomViewHidden();
    }
    AppMethodBeat.o(213379);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(153953);
    this.aimV.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(153953);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(153958);
    this.aimV.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(153958);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(153944);
    this.aimV.loadUrl(paramString);
    AppMethodBeat.o(153944);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(153961);
    this.aimV.loadUrl(paramString, paramMap);
    AppMethodBeat.o(153961);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(153987);
    this.aimV.onPause();
    AppMethodBeat.o(153987);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(153938);
    this.aimV.onPause();
    AppMethodBeat.o(153938);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(153937);
    this.aimV.onResume();
    AppMethodBeat.o(153937);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(153986);
    this.aimV.onResume();
    AppMethodBeat.o(153986);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(153957);
    boolean bool = this.aimV.overlayHorizontalScrollbar();
    AppMethodBeat.o(153957);
    return bool;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(153951);
    this.aimV.reload();
    AppMethodBeat.o(153951);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(153964);
    this.aimV.removeJavascriptInterface(paramString);
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
    this.aimV.setDownloadListener(new a.a(paramDownloadListener));
    AppMethodBeat.o(153942);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(153943);
    this.aimV.setFindListener(new a.b(paramFindListener));
    AppMethodBeat.o(153943);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153982);
    this.aimV.getView().setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153982);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(213802);
    this.aimV.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(213802);
  }
  
  public final void setJSExceptionListener(ai paramai) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153981);
    this.aimV.getView().setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153981);
  }
  
  public final w setVideoJsCallback(x paramx)
  {
    AppMethodBeat.i(153949);
    if ((this.aikP != null) && (this.aikP.hn(paramx)))
    {
      paramx = new w()
      {
        public final void Z(double paramAnonymousDouble)
        {
          AppMethodBeat.i(213211);
          if (j.d(j.this) != null) {
            j.d(j.this).Z(paramAnonymousDouble);
          }
          AppMethodBeat.o(213211);
        }
        
        public final void hSS()
        {
          AppMethodBeat.i(213201);
          if (j.d(j.this) != null) {
            j.d(j.this).hSS();
          }
          AppMethodBeat.o(213201);
        }
        
        public final void kfv()
        {
          AppMethodBeat.i(213196);
          if (j.d(j.this) != null) {
            j.d(j.this).kfv();
          }
          AppMethodBeat.o(213196);
        }
        
        public final boolean kfw()
        {
          AppMethodBeat.i(213216);
          if (j.d(j.this) != null)
          {
            boolean bool = j.d(j.this).kfw();
            AppMethodBeat.o(213216);
            return bool;
          }
          AppMethodBeat.o(213216);
          return false;
        }
      };
      AppMethodBeat.o(153949);
      return paramx;
    }
    Log.i("X5WebView", "setVideoJsCallback not support");
    AppMethodBeat.o(153949);
    return null;
  }
  
  public final void setWebChromeClient(z paramz)
  {
    this.aikI = paramz;
  }
  
  public final void setWebContentsSize(int paramInt1, int paramInt2) {}
  
  public final void setWebViewCallbackClient(af paramaf)
  {
    AppMethodBeat.i(153966);
    this.sLl = paramaf;
    this.aimV.setWebViewCallbackClient(new a.f(this.aimV, paramaf));
    AppMethodBeat.o(153966);
  }
  
  public final void setWebViewClient(ag paramag)
  {
    this.aikH = paramag;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(153929);
    if (parama == null)
    {
      this.aimV.setWebViewClientExtension(new ProxyWebViewClientExtension()
      {
        public final int getHostByName(String paramAnonymousString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(213204);
          if (X5WebFactory.getInstance().getExtensionCallback() != null)
          {
            i = X5WebFactory.getInstance().getExtensionCallback().getHostByName(paramAnonymousString, paramAnonymousList);
            AppMethodBeat.o(213204);
            return i;
          }
          int i = super.getHostByName(paramAnonymousString, paramAnonymousList);
          AppMethodBeat.o(213204);
          return i;
        }
        
        public final void invalidate()
        {
          AppMethodBeat.i(213209);
          super.invalidate();
          j.c(j.this);
          AppMethodBeat.o(213209);
        }
      });
      AppMethodBeat.o(153929);
      return;
    }
    this.aimV.setWebViewClientExtension(new com.tencent.xweb.x5.a.d(parama)
    {
      public final void invalidate()
      {
        AppMethodBeat.i(213183);
        super.invalidate();
        j.c(j.this);
        AppMethodBeat.o(213183);
      }
    });
    AppMethodBeat.o(153929);
  }
  
  public final void setXWebKeyEventHandler(al paramal) {}
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong) {}
  
  public final void stopLoading()
  {
    AppMethodBeat.i(153965);
    this.aimV.stopLoading();
    AppMethodBeat.o(153965);
  }
  
  public final void super_computeScroll()
  {
    AppMethodBeat.i(153934);
    this.aimV.super_computeScroll();
    AppMethodBeat.o(153934);
  }
  
  public final boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153933);
    boolean bool = this.aimV.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153933);
    return bool;
  }
  
  public final boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153931);
    boolean bool = this.aimV.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153931);
    return bool;
  }
  
  public final void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(153932);
    this.aimV.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(153932);
  }
  
  public final void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(153935);
    this.aimV.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(153935);
  }
  
  public final boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153930);
    boolean bool = this.aimV.super_onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153930);
    return bool;
  }
  
  public final boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(153936);
    paramBoolean = this.aimV.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(153936);
    return paramBoolean;
  }
  
  public final boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(153980);
    if (paramInt == 2006)
    {
      paramInt = QbSdk.getTbsVersion(this.aimV.getContext());
      if (paramInt >= 44900)
      {
        AppMethodBeat.o(153980);
        return true;
      }
      if ((paramInt <= 0) || (getX5WebViewExtension() == null))
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
  
  public final boolean supportSetWebContentsSize()
  {
    return false;
  }
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(153960);
    boolean bool = this.aimV.zoomIn();
    AppMethodBeat.o(153960);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(153959);
    boolean bool = this.aimV.zoomOut();
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
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(213133);
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4) && (j.this.hasEnteredFullscreen()))
      {
        j.this.leaveFullscreen();
        AppMethodBeat.o(213133);
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(213133);
      return bool;
    }
    
    protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(153926);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (j.a(j.this) != null) {
        j.a(j.this).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(153926);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.j
 * JD-Core Version:    0.7.0.1
 */