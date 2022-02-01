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
import com.jg.JgClassChecked;
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
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import com.tencent.xweb.ac;
import com.tencent.xweb.ad;
import com.tencent.xweb.af;
import com.tencent.xweb.ah;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author=20001, fComment="checked", lastDate="20171020", reviewer=20001, vComment={com.jg.EType.JSEXECUTECHECK})
public final class m
  implements IWebView
{
  private boolean aadc;
  long aafB;
  private com.tencent.xweb.extension.video.b aafC;
  com.tencent.xweb.WebView aafv;
  ad aafx;
  x aafy;
  com.tencent.smtt.sdk.WebView aagC;
  j aagJ;
  o aagK;
  String aagL;
  private b aagM;
  private c aagN;
  private IX5WebChromeClient.CustomViewCallback abTN;
  
  public m(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153927);
    this.aafB = 0L;
    this.aagL = "";
    this.abTN = null;
    this.aadc = false;
    this.aagM = new b()
    {
      public final View getVideoLoadingProgressView()
      {
        AppMethodBeat.i(204504);
        if (m.this.aafy != null)
        {
          localView = m.this.aafy.getVideoLoadingProgressView();
          AppMethodBeat.o(204504);
          return localView;
        }
        View localView = super.getVideoLoadingProgressView();
        AppMethodBeat.o(204504);
        return localView;
      }
      
      public final boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(204500);
        if (m.this.aafy != null)
        {
          x localx = m.this.aafy;
          if (paramAnonymousConsoleMessage == null)
          {
            paramAnonymousConsoleMessage = null;
            bool = localx.onConsoleMessage(paramAnonymousConsoleMessage);
            AppMethodBeat.o(204500);
            return bool;
          }
          ConsoleMessage.MessageLevel localMessageLevel = ConsoleMessage.MessageLevel.DEBUG;
          switch (g.2.aagm[paramAnonymousConsoleMessage.messageLevel().ordinal()])
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
        AppMethodBeat.o(204500);
        return bool;
      }
      
      public final void onGeolocationPermissionsHidePrompt()
      {
        AppMethodBeat.i(204499);
        Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
        if (m.this.aafy != null)
        {
          m.this.aafy.onGeolocationPermissionsHidePrompt();
          AppMethodBeat.o(204499);
          return;
        }
        super.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(204499);
      }
      
      public final void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissionsCallback paramAnonymousGeolocationPermissionsCallback)
      {
        AppMethodBeat.i(204498);
        Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
        if (m.this.aafy != null)
        {
          m.this.aafy.onGeolocationPermissionsShowPrompt(paramAnonymousString, new g.e(paramAnonymousGeolocationPermissionsCallback));
          AppMethodBeat.o(204498);
          return;
        }
        super.onGeolocationPermissionsShowPrompt(paramAnonymousString, paramAnonymousGeolocationPermissionsCallback);
        AppMethodBeat.o(204498);
      }
      
      public final void onHideCustomView()
      {
        boolean bool = false;
        AppMethodBeat.i(204492);
        Log.i("X5WebView", "onHideCustomView");
        m.a(m.this, null);
        m.a(m.this, false);
        if (m.this.aafy != null) {
          bool = m.this.aafy.bXA();
        }
        if (bool)
        {
          Log.i("X5WebView", "onHideCustomView isHandled:true");
          AppMethodBeat.o(204492);
          return;
        }
        if (m.a(m.this) != null)
        {
          m.a(m.this).onHideCustomView();
          AppMethodBeat.o(204492);
          return;
        }
        if (m.this.aafy != null)
        {
          m.this.aafy.onHideCustomView();
          AppMethodBeat.o(204492);
          return;
        }
        super.onHideCustomView();
        AppMethodBeat.o(204492);
      }
      
      public final boolean onJsAlert(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(204495);
        Log.i("X5WebView", "onJsAlert");
        if (m.this.aafy != null)
        {
          bool = m.this.aafy.a(m.this.aafv, paramAnonymousString1, paramAnonymousString2, new g.g(paramAnonymousJsResult));
          AppMethodBeat.o(204495);
          return bool;
        }
        boolean bool = super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        AppMethodBeat.o(204495);
        return bool;
      }
      
      public final boolean onJsConfirm(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(204496);
        Log.i("X5WebView", "onJsConfirm");
        if (m.this.aafy != null)
        {
          bool = m.this.aafy.b(m.this.aafv, paramAnonymousString1, paramAnonymousString2, new g.g(paramAnonymousJsResult));
          AppMethodBeat.o(204496);
          return bool;
        }
        boolean bool = super.onJsConfirm(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        AppMethodBeat.o(204496);
        return bool;
      }
      
      public final boolean onJsPrompt(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(204497);
        Log.i("X5WebView", "onJsPrompt");
        if (m.this.aafy != null)
        {
          bool = m.this.aafy.a(m.this.aafv, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, new g.h(paramAnonymousJsPromptResult));
          AppMethodBeat.o(204497);
          return bool;
        }
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(204497);
        return bool;
      }
      
      public final void onProgressChanged(com.tencent.smtt.sdk.WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(204487);
        if (m.this.aafy != null)
        {
          m.this.aafy.a(m.this.aafv, paramAnonymousInt);
          AppMethodBeat.o(204487);
          return;
        }
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(204487);
      }
      
      public final void onReceivedTitle(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(204488);
        Log.i("X5WebView", "onReceivedTitle: ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.aafy != null)
        {
          m.this.aafy.d(m.this.aafv, paramAnonymousString);
          if (m.a(m.this) != null)
          {
            paramAnonymousWebView = m.a(m.this);
            if (m.this.aafv.getFullscreenVideoKind() != WebView.a.aabj) {
              break label106;
            }
          }
        }
        label106:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bu(true, bool);
          AppMethodBeat.o(204488);
          return;
          super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
          break;
        }
      }
      
      public final void onShowCustomView(View paramAnonymousView, final IX5WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(204489);
        Log.i("X5WebView", "onShowCustomView");
        m.a(m.this, paramAnonymousCustomViewCallback);
        m.a(m.this, true);
        boolean bool = false;
        if (m.this.aafy != null) {
          bool = m.this.aafy.a(paramAnonymousView, new g.c(paramAnonymousCustomViewCallback));
        }
        com.tencent.xweb.util.h.ixU();
        if (bool)
        {
          Log.i("X5WebView", "onShowCustomView isHandled:true");
          AppMethodBeat.o(204489);
          return;
        }
        if (m.a(m.this) != null)
        {
          m.a(m.this).onShowCustomView(paramAnonymousView, new WebChromeClient.CustomViewCallback()
          {
            public final void onCustomViewHidden()
            {
              AppMethodBeat.i(204969);
              paramAnonymousCustomViewCallback.onCustomViewHidden();
              AppMethodBeat.o(204969);
            }
          });
          AppMethodBeat.o(204489);
          return;
        }
        if (m.this.aafy != null)
        {
          m.this.aafy.onShowCustomView(paramAnonymousView, new g.c(paramAnonymousCustomViewCallback));
          AppMethodBeat.o(204489);
          return;
        }
        super.onShowCustomView(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(204489);
      }
      
      public final boolean onShowFileChooser(com.tencent.smtt.sdk.WebView paramAnonymousWebView, com.tencent.smtt.sdk.ValueCallback<Uri[]> paramAnonymousValueCallback, WebChromeClient.FileChooserParams paramAnonymousFileChooserParams)
      {
        AppMethodBeat.i(204502);
        Log.i("X5WebView", "onShowFileChooser last method");
        if (m.this.aafy != null)
        {
          bool = m.this.aafy.a(m.this.aafv, paramAnonymousValueCallback, new g.d(paramAnonymousFileChooserParams));
          AppMethodBeat.o(204502);
          return bool;
        }
        boolean bool = super.onShowFileChooser(paramAnonymousWebView, new a.d(paramAnonymousValueCallback), paramAnonymousFileChooserParams);
        AppMethodBeat.o(204502);
        return bool;
      }
      
      public final void openFileChooser(com.tencent.smtt.sdk.ValueCallback<Uri> paramAnonymousValueCallback, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(204501);
        Log.i("X5WebView", "openFileChooser with three param");
        if (m.this.aafy != null)
        {
          m.this.aafy.openFileChooser(paramAnonymousValueCallback, paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(204501);
          return;
        }
        paramAnonymousValueCallback.onReceiveValue(null);
        AppMethodBeat.o(204501);
      }
    };
    this.aagN = new c()
    {
      public final void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205750);
        if (m.this.aafx != null)
        {
          m.this.aafx.b(m.this.aafv, paramAnonymousString, paramAnonymousBoolean);
          AppMethodBeat.o(205750);
          return;
        }
        super.doUpdateVisitedHistory(paramAnonymousWebView, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(205750);
      }
      
      public final void onLoadResource(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(205745);
        if (m.this.aafx != null)
        {
          m.this.aafx.i(m.this.aafv, paramAnonymousString);
          AppMethodBeat.o(205745);
          return;
        }
        super.onLoadResource(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(205745);
      }
      
      public final void onPageCommitVisible(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(205757);
        Log.i("X5WebView", "onPageCommitVisible s = ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.aafx != null) {
          m.this.aafx.e(m.this.aafv, paramAnonymousString);
        }
        AppMethodBeat.o(205757);
      }
      
      public final void onPageFinished(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(205744);
        Log.i("X5WebView", "onPageFinished ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.aafx != null)
        {
          m.this.aafx.b(m.this.aafv, paramAnonymousString);
          if (m.a(m.this) != null)
          {
            paramAnonymousWebView = m.a(m.this);
            if (m.this.aafv.getFullscreenVideoKind() != WebView.a.aabj) {
              break label174;
            }
          }
        }
        label174:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bu(false, bool);
          if ((m.this.aagL == null) || (!m.this.aagL.equals(paramAnonymousString))) {
            com.tencent.xweb.internal.h.ixo().ixk();
          }
          com.tencent.xweb.util.h.Xh(System.currentTimeMillis() - m.this.aafB);
          com.tencent.xweb.xwalk.d.a(m.this.aafv);
          com.tencent.xweb.util.h.Xj(System.currentTimeMillis() - m.this.aafB);
          AppMethodBeat.o(205744);
          return;
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          break;
        }
      }
      
      public final void onPageStarted(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(205742);
        Log.i("X5WebView", "onPageStarted ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.aafx != null)
        {
          m.this.aafx.b(m.this.aafv, paramAnonymousString, paramAnonymousBitmap);
          if (m.a(m.this) != null)
          {
            paramAnonymousWebView = m.a(m.this);
            if (m.this.aafv.getFullscreenVideoKind() != WebView.a.aabj) {
              break label142;
            }
          }
        }
        label142:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bu(true, bool);
          m.this.aagL = "";
          m.this.aafB = System.currentTimeMillis();
          com.tencent.xweb.util.h.bFG(paramAnonymousString);
          com.tencent.xweb.util.h.ixK();
          com.tencent.xweb.internal.h.ixo().ixj();
          AppMethodBeat.o(205742);
          return;
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          break;
        }
      }
      
      public final void onReceivedError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(205751);
        if (m.this.aafx != null) {
          m.this.aafx.a(m.this.aafv, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        for (;;)
        {
          m.this.aagL = paramAnonymousString2;
          com.tencent.xweb.util.h.ixH();
          com.tencent.xweb.internal.h.ixo().ixp();
          com.tencent.xweb.util.h.ixL();
          AppMethodBeat.o(205751);
          return;
          super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void onReceivedError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
      {
        Object localObject = null;
        AppMethodBeat.i(205752);
        if (m.this.aafx != null)
        {
          ad localad;
          com.tencent.xweb.WebView localWebView;
          if ((paramAnonymousWebResourceRequest.isForMainFrame()) && (paramAnonymousWebResourceRequest != null) && (paramAnonymousWebResourceError != null))
          {
            localad = m.this.aafx;
            localWebView = m.this.aafv;
            int i = paramAnonymousWebResourceError.getErrorCode();
            String str = paramAnonymousWebResourceError.getDescription().toString();
            if (paramAnonymousWebResourceRequest.getUrl() != null)
            {
              paramAnonymousWebView = paramAnonymousWebResourceRequest.getUrl().toString();
              localad.a(localWebView, i, str, paramAnonymousWebView);
            }
          }
          else
          {
            localad = m.this.aafx;
            localWebView = m.this.aafv;
            paramAnonymousWebResourceRequest = new g.b(paramAnonymousWebResourceRequest);
            if (paramAnonymousWebResourceError != null) {
              break label155;
            }
          }
          label155:
          for (paramAnonymousWebView = localObject;; paramAnonymousWebView = new g.1(paramAnonymousWebResourceError))
          {
            localad.a(localWebView, paramAnonymousWebResourceRequest, paramAnonymousWebView);
            AppMethodBeat.o(205752);
            return;
            paramAnonymousWebView = null;
            break;
          }
        }
        super.onReceivedError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceError);
        AppMethodBeat.o(205752);
      }
      
      public final void onReceivedHttpAuthRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(205753);
        Log.i("X5WebView", "onReceivedHttpAuthRequest host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (m.this.aafx != null)
        {
          m.this.aafx.a(m.this.aafv, new g.f(paramAnonymousHttpAuthHandler), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(205753);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousWebView, paramAnonymousHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(205753);
      }
      
      public final void onReceivedHttpError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(205756);
        Log.i("X5WebView", "onReceivedHttpError code:" + paramAnonymousWebResourceResponse.getStatusCode());
        if (m.this.aafx != null)
        {
          m.this.aafx.a(m.this.aafv, new g.b(paramAnonymousWebResourceRequest), g.a(paramAnonymousWebResourceResponse));
          AppMethodBeat.o(205756);
          return;
        }
        super.onReceivedHttpError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceResponse);
        AppMethodBeat.o(205756);
      }
      
      public final void onReceivedSslError(com.tencent.smtt.sdk.WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(205754);
        Log.i("X5WebView", "onReceivedSslError " + paramAnonymousSslError.getPrimaryError());
        if (m.this.aafx != null)
        {
          ad localad = m.this.aafx;
          com.tencent.xweb.WebView localWebView = m.this.aafv;
          paramAnonymousSslErrorHandler = new g.a(paramAnonymousSslErrorHandler);
          if (paramAnonymousSslError != null) {}
          for (paramAnonymousWebView = new android.net.http.SslError(paramAnonymousSslError.getPrimaryError(), paramAnonymousSslError.getCertificate());; paramAnonymousWebView = null)
          {
            localad.a(localWebView, paramAnonymousSslErrorHandler, paramAnonymousWebView);
            AppMethodBeat.o(205754);
            return;
          }
        }
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(205754);
      }
      
      public final void onScaleChanged(com.tencent.smtt.sdk.WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(205749);
        if (m.this.aafx != null)
        {
          m.this.aafx.a(m.this.aafv, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(205749);
          return;
        }
        super.onScaleChanged(paramAnonymousWebView, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(205749);
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(205747);
        if (m.this.aafx != null)
        {
          paramAnonymousWebView = new g.b(paramAnonymousWebResourceRequest);
          paramAnonymousWebView = a.b(m.this.aafx.a(m.this.aafv, paramAnonymousWebView));
          AppMethodBeat.o(205747);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(205747);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(205748);
        if (m.this.aafx != null)
        {
          paramAnonymousWebView = new g.b(paramAnonymousWebResourceRequest);
          paramAnonymousWebView = a.b(m.this.aafx.a(m.this.aafv, paramAnonymousWebView, paramAnonymousBundle));
          AppMethodBeat.o(205748);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousBundle);
        AppMethodBeat.o(205748);
        return paramAnonymousWebView;
      }
      
      public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(205746);
        if (m.this.aafx != null)
        {
          paramAnonymousWebView = a.b(m.this.aafx.c(m.this.aafv, paramAnonymousString));
          AppMethodBeat.o(205746);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(205746);
        return paramAnonymousWebView;
      }
      
      public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(205736);
        Log.i("X5WebView", "shouldOverrideUrlLoading " + paramAnonymousWebResourceRequest.getUrl().toString());
        if (m.this.aafx != null)
        {
          paramAnonymousWebView = new g.b(paramAnonymousWebResourceRequest);
          bool = m.this.aafx.e(m.this.aafv, paramAnonymousWebView);
          AppMethodBeat.o(205736);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(205736);
        return bool;
      }
      
      public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(205739);
        if (com.tencent.xweb.xwalk.d.bFM(paramAnonymousString))
        {
          AppMethodBeat.o(205739);
          return true;
        }
        Log.i("X5WebView", "shouldOverrideUrlLoading ".concat(String.valueOf(paramAnonymousString)));
        if (m.this.aafx != null)
        {
          bool = m.this.aafx.a(m.this.aafv, paramAnonymousString);
          AppMethodBeat.o(205739);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(205739);
        return bool;
      }
    };
    this.aafv = paramWebView;
    this.aagC = new a(paramWebView.getContext());
    this.aagC.setBackgroundColor(0);
    this.aagJ = new j(this.aagC);
    this.aagC.setWebChromeClient(this.aagM);
    this.aagC.setWebViewClient(this.aagN);
    this.aagC.setWebChromeClientExtension(new ProxyWebChromeClientExtension()
    {
      public final boolean onPermissionRequest(String paramAnonymousString, long paramAnonymousLong, MediaAccessPermissionsCallback paramAnonymousMediaAccessPermissionsCallback)
      {
        AppMethodBeat.i(205798);
        if (m.this.aafy != null)
        {
          m.this.aafy.onPermissionRequest(new m.b(paramAnonymousString, paramAnonymousLong, paramAnonymousMediaAccessPermissionsCallback));
          AppMethodBeat.o(205798);
          return true;
        }
        AppMethodBeat.o(205798);
        return false;
      }
    });
    this.aagJ.aagA = this.aagN;
    this.aagJ.aagB = this.aagM;
    paramWebView = this.aafv.getContext();
    Log.i("X5WebView", "initFullscreenVideo:" + getFullscreenVideoKind());
    if (getFullscreenVideoKind() != WebView.a.aabh)
    {
      this.aafC = new com.tencent.xweb.extension.video.d();
      paramWebView = XWalkEnvironment.activityFromContext(paramWebView);
      this.aafC.a(paramWebView, this.aafv, this.aagC, this.aagC.getContext(), com.tencent.xweb.extension.video.d.iwS());
      if (getFullscreenVideoKind() == WebView.a.aabj) {
        this.aafC.eP(this.aagC);
      }
    }
    try
    {
      if (this.aagC.getSettingsExtension() != null) {
        this.aagC.getSettingsExtension().setDisplayCutoutEnable(false);
      }
      AppMethodBeat.o(153927);
      return;
    }
    catch (Throwable paramWebView)
    {
      Log.e("X5WebView", "setDisplayCutoutEnable Throwable:" + paramWebView.getMessage());
      AppMethodBeat.o(153927);
    }
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(153962);
    this.aagC.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(153962);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(153945);
    boolean bool = this.aagC.canGoBack();
    AppMethodBeat.o(153945);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(153978);
    boolean bool = this.aagC.canGoForward();
    AppMethodBeat.o(153978);
    return bool;
  }
  
  public final Bitmap captureBitmap()
  {
    AppMethodBeat.i(205283);
    if (((getX5WebViewExtension() instanceof IX5WebViewExtension)) && (!this.aafv.isSysKernel()))
    {
      i = this.aagC.getHeight();
      localBitmap = Bitmap.createBitmap(this.aagC.getWidth(), i, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      ((IX5WebViewExtension)getX5WebViewExtension()).snapshotVisible(localCanvas, false, false, false, false);
      AppMethodBeat.o(205283);
      return localBitmap;
    }
    int i = this.aagC.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(this.aagC.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.aagC.draw(localCanvas);
    AppMethodBeat.o(205283);
    return localBitmap;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(153984);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205111);
        int i = m.this.aagC.getHeight();
        Canvas localCanvas = new Canvas(Bitmap.createBitmap(m.this.aagC.getWidth(), i, Bitmap.Config.ARGB_8888));
        m.this.aagC.draw(localCanvas);
        Log.d("X5WebView", "bitmapCaptureFinished");
        AppMethodBeat.o(205111);
      }
    }).start();
    AppMethodBeat.o(153984);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(153977);
    this.aagC.clearHistory();
    AppMethodBeat.o(153977);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(153969);
    this.aagC.clearMatches();
    AppMethodBeat.o(153969);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(153952);
    this.aagC.clearSslPreferences();
    AppMethodBeat.o(153952);
  }
  
  public final void clearView()
  {
    AppMethodBeat.i(153947);
    this.aagC.clearView();
    AppMethodBeat.o(153947);
  }
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(205286);
    i locali = new i(this.aagC.copyBackForwardList());
    AppMethodBeat.o(205286);
    return locali;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(153948);
    this.aagC.destroy();
    AppMethodBeat.o(153948);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(205247);
    if (this.aafC != null) {
      this.aafC.IO(paramBoolean);
    }
    AppMethodBeat.o(205247);
  }
  
  public final void evaluateJavascript(String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(153950);
    this.aagC.evaluateJavascript(paramString, new a.d(paramValueCallback));
    AppMethodBeat.o(153950);
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(153971);
    this.aagC.findAllAsync(paramString);
    AppMethodBeat.o(153971);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(153970);
    this.aagC.findNext(paramBoolean);
    AppMethodBeat.o(153970);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(153973);
    Object localObject = new StringBuilder("webviewtype = x5, is using x5 core = ");
    if (this.aagC.getX5WebViewExtension() != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + "\n core version = " + QbSdk.getTbsVersion(this.aafv.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.aafv.getContext()) + "\n canUseX5JsCore = " + X5JsCore.canUseX5JsCore(this.aafv.getContext()) + "\n canUseNativeBuffer = " + X5JsCore.canX5JsCoreUseNativeBuffer(this.aafv.getContext());
      AppMethodBeat.o(153973);
      return localObject;
    }
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(153954);
    int i = this.aagC.getContentHeight();
    AppMethodBeat.o(153954);
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
  
  public final e getDefalutOpProvider()
  {
    return this.aagJ;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(205269);
    WebView.a locala = com.tencent.xweb.a.bEF(com.tencent.xweb.WebView.getCurStrModule());
    AppMethodBeat.o(205269);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(153967);
    WebView.HitTestResult localHitTestResult = this.aagC.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.mType = localHitTestResult.getType();
    localb.mExtra = localHitTestResult.getExtra();
    AppMethodBeat.o(153967);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205289);
    paramString1 = this.aagC.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(205289);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, com.tencent.xweb.i parami)
  {
    return false;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(153955);
    float f = this.aagC.getScale();
    AppMethodBeat.o(153955);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(153988);
    int i = this.aagC.computeVerticalScrollRange();
    AppMethodBeat.o(153988);
    return i;
  }
  
  public final aa getSettings()
  {
    AppMethodBeat.i(153939);
    if (this.aagK != null)
    {
      localo = this.aagK;
      AppMethodBeat.o(153939);
      return localo;
    }
    if (this.aagC == null)
    {
      AppMethodBeat.o(153939);
      return null;
    }
    this.aagK = new o(this.aagC);
    o localo = this.aagK;
    AppMethodBeat.o(153939);
    return localo;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(153968);
    String str = this.aagC.getTitle();
    AppMethodBeat.o(153968);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    AppMethodBeat.i(153941);
    ViewGroup localViewGroup = (ViewGroup)this.aagC.getView();
    AppMethodBeat.o(153941);
    return localViewGroup;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(153963);
    String str = this.aagC.getUrl();
    AppMethodBeat.o(153963);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(153972);
    if (this.aagC.getX5WebViewExtension() != null) {}
    for (int i = 1; i != 0; i = 0)
    {
      str = "use x5 and x5 kernel, sdk ver = " + com.tencent.xweb.WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + com.tencent.xweb.WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + JsRuntime.iwd();
      AppMethodBeat.o(153972);
      return str;
    }
    String str = "use x5 wrapped sys kernel, sdk ver = " + com.tencent.xweb.WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + com.tencent.xweb.WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + JsRuntime.iwd();
    AppMethodBeat.o(153972);
    return str;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(153940);
    View localView = this.aagC.getView();
    AppMethodBeat.o(153940);
    return localView;
  }
  
  public final int getVisibleTitleHeight()
  {
    AppMethodBeat.i(153956);
    int i = this.aagC.getVisibleTitleHeight();
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
    int i = this.aagC.getWebScrollY();
    AppMethodBeat.o(153974);
    return i;
  }
  
  public final View getWebViewUI()
  {
    return this.aagC;
  }
  
  public final Object getX5WebViewExtension()
  {
    AppMethodBeat.i(153928);
    IX5WebViewExtension localIX5WebViewExtension = this.aagC.getX5WebViewExtension();
    AppMethodBeat.o(153928);
    return localIX5WebViewExtension;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(153946);
    this.aagC.goBack();
    AppMethodBeat.o(153946);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(153979);
    this.aagC.goForward();
    AppMethodBeat.o(153979);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.aadc;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(153983);
    if (this.aagC.getX5WebViewExtension() == null)
    {
      Log.d("X5WebView", "invokeMiscMethod  extension is null");
      AppMethodBeat.o(153983);
      return null;
    }
    Log.d("X5WebView", "invokeMiscMethod x5  extension");
    paramString = this.aagC.getX5WebViewExtension().invokeMiscMethod(paramString, paramBundle);
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
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(205245);
    if (this.abTN != null) {
      this.abTN.onCustomViewHidden();
    }
    AppMethodBeat.o(205245);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(153953);
    this.aagC.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(153953);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(153958);
    this.aagC.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(153958);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(153944);
    this.aagC.loadUrl(paramString);
    AppMethodBeat.o(153944);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(153961);
    this.aagC.loadUrl(paramString, paramMap);
    AppMethodBeat.o(153961);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(153987);
    this.aagC.onPause();
    AppMethodBeat.o(153987);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(153938);
    this.aagC.onPause();
    AppMethodBeat.o(153938);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(153937);
    this.aagC.onResume();
    AppMethodBeat.o(153937);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(153986);
    this.aagC.onResume();
    AppMethodBeat.o(153986);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(153957);
    boolean bool = this.aagC.overlayHorizontalScrollbar();
    AppMethodBeat.o(153957);
    return bool;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(153951);
    this.aagC.reload();
    AppMethodBeat.o(153951);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(153964);
    this.aagC.removeJavascriptInterface(paramString);
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
    this.aagC.setDownloadListener(new a.a(paramDownloadListener));
    AppMethodBeat.o(153942);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(153943);
    this.aagC.setFindListener(new a.b(paramFindListener));
    AppMethodBeat.o(153943);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153982);
    this.aagC.getView().setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153982);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(205287);
    this.aagC.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(205287);
  }
  
  public final void setJSExceptionListener(af paramaf) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153981);
    this.aagC.getView().setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(153981);
  }
  
  public final u setVideoJsCallback(v paramv)
  {
    AppMethodBeat.i(153949);
    if (this.aafC.eQ(paramv))
    {
      paramv = new u()
      {
        public final void H(double paramAnonymousDouble)
        {
          AppMethodBeat.i(206546);
          if (m.a(m.this) != null) {
            m.a(m.this).H(paramAnonymousDouble);
          }
          AppMethodBeat.o(206546);
        }
        
        public final void gvc()
        {
          AppMethodBeat.i(206545);
          if (m.a(m.this) != null) {
            m.a(m.this).gvc();
          }
          AppMethodBeat.o(206545);
        }
        
        public final void iwh()
        {
          AppMethodBeat.i(206544);
          if (m.a(m.this) != null) {
            m.a(m.this).iwh();
          }
          AppMethodBeat.o(206544);
        }
        
        public final boolean iwi()
        {
          AppMethodBeat.i(206548);
          if (m.a(m.this) != null)
          {
            boolean bool = m.a(m.this).iwi();
            AppMethodBeat.o(206548);
            return bool;
          }
          AppMethodBeat.o(206548);
          return false;
        }
      };
      AppMethodBeat.o(153949);
      return paramv;
    }
    Log.i("X5WebView", "setVideoJsCallback not support");
    AppMethodBeat.o(153949);
    return null;
  }
  
  public final void setWebChromeClient(x paramx)
  {
    this.aafy = paramx;
  }
  
  public final void setWebContentsSize(int paramInt1, int paramInt2) {}
  
  public final void setWebViewCallbackClient(ac paramac)
  {
    AppMethodBeat.i(153966);
    this.aagC.setWebViewCallbackClient(new a.f(paramac));
    AppMethodBeat.o(153966);
  }
  
  public final void setWebViewClient(ad paramad)
  {
    this.aafx = paramad;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(153929);
    if (parama == null)
    {
      this.aagC.setWebViewClientExtension(new ProxyWebViewClientExtension()
      {
        public final int getHostByName(String paramAnonymousString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(207345);
          if (X5WebFactory.getInstance().getExtensionCallback() != null)
          {
            i = X5WebFactory.getInstance().getExtensionCallback().getHostByName(paramAnonymousString, paramAnonymousList);
            AppMethodBeat.o(207345);
            return i;
          }
          int i = super.getHostByName(paramAnonymousString, paramAnonymousList);
          AppMethodBeat.o(207345);
          return i;
        }
      });
      AppMethodBeat.o(153929);
      return;
    }
    this.aagC.setWebViewClientExtension(new ProxyWebViewSuperWrapper(parama));
    AppMethodBeat.o(153929);
  }
  
  public final void setXWebKeyEventHandler(ah paramah) {}
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong) {}
  
  public final void stopLoading()
  {
    AppMethodBeat.i(153965);
    this.aagC.stopLoading();
    AppMethodBeat.o(153965);
  }
  
  public final void super_computeScroll()
  {
    AppMethodBeat.i(153934);
    this.aagC.super_computeScroll();
    AppMethodBeat.o(153934);
  }
  
  public final boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153933);
    boolean bool = this.aagC.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153933);
    return bool;
  }
  
  public final boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153931);
    boolean bool = this.aagC.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153931);
    return bool;
  }
  
  public final void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(153932);
    this.aagC.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(153932);
  }
  
  public final void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(153935);
    this.aagC.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(153935);
  }
  
  public final boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153930);
    boolean bool = this.aagC.super_onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(153930);
    return bool;
  }
  
  public final boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(153936);
    paramBoolean = this.aagC.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(153936);
    return paramBoolean;
  }
  
  public final boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(153980);
    if (paramInt == 2006)
    {
      paramInt = QbSdk.getTbsVersion(this.aagC.getContext());
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
    boolean bool = this.aagC.zoomIn();
    AppMethodBeat.o(153960);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(153959);
    boolean bool = this.aagC.zoomOut();
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
      AppMethodBeat.i(205859);
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4) && (m.this.hasEnteredFullscreen()))
      {
        m.this.leaveFullscreen();
        AppMethodBeat.o(205859);
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(205859);
      return bool;
    }
    
    protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(153926);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (m.this.aafv != null) {
        m.this.aafv.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(153926);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.m
 * JD-Core Version:    0.7.0.1
 */