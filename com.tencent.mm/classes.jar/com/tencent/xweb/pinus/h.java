package com.tencent.xweb.pinus;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ab;
import com.tencent.xweb.ad;
import com.tencent.xweb.af;
import com.tencent.xweb.ag;
import com.tencent.xweb.ag.a;
import com.tencent.xweb.ah;
import com.tencent.xweb.ai;
import com.tencent.xweb.al;
import com.tencent.xweb.ao;
import com.tencent.xweb.aq;
import com.tencent.xweb.aq.a;
import com.tencent.xweb.extension.video.e;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.k;
import com.tencent.xweb.pinus.sdk.HitTestResultInterface;
import com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterface;
import com.tencent.xweb.pinus.sdk.JsResultInterface;
import com.tencent.xweb.pinus.sdk.JsResultInterfaceImpl;
import com.tencent.xweb.pinus.sdk.PSCoreWrapper;
import com.tencent.xweb.pinus.sdk.PSInitializerWrapper;
import com.tencent.xweb.pinus.sdk.WebChromeClient;
import com.tencent.xweb.pinus.sdk.WebResourceErrorInterface;
import com.tencent.xweb.pinus.sdk.WebSettingsInterface;
import com.tencent.xweb.pinus.sdk.WebView.OverScrolledListener;
import com.tencent.xweb.pinus.sdk.WebView.ScrollChangedListener;
import com.tencent.xweb.pinus.sdk.WebViewClient;
import com.tencent.xweb.pinus.sdk.WebViewClient.RenderProcessGoneDetail;
import com.tencent.xweb.util.l;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import com.tencent.xweb.xwalk.s;
import com.tencent.xweb.xwalk.s.a;
import com.tencent.xweb.z;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.R.layout;
import org.xwalk.core.XWalkEnvironment;

public final class h
  implements aq.a, IWebView
{
  private com.tencent.xweb.WebView aigp;
  private boolean aihJ;
  private i aikE;
  private a aikF;
  private AbsoluteLayout aikG;
  private ag aikH;
  private z aikI;
  private long aikJ;
  private boolean aikK;
  private boolean aikL;
  private int aikM;
  private com.tencent.xweb.x5.export.external.extension.proxy.a aikN;
  private s aikO;
  private com.tencent.xweb.extension.video.a aikP;
  private ai aikQ;
  private aq aikR;
  private WebChromeClient.CustomViewCallback aikS;
  private boolean aikT;
  private boolean aikU;
  private WebChromeClient aikV;
  private WebViewClient aikW;
  private final com.tencent.xweb.x5.export.external.extension.proxy.a aikX;
  private int mApkVersion;
  private af sLl;
  
  public h(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(213375);
    this.aikJ = 0L;
    this.aikK = false;
    this.aikL = false;
    this.aikM = 0;
    this.aikN = new com.tencent.xweb.x5.export.external.extension.proxy.a();
    this.aikQ = null;
    this.aikS = null;
    this.aihJ = false;
    this.aikT = false;
    this.aikU = false;
    this.aikV = new WebChromeClient()
    {
      public final View getVideoLoadingProgressView()
      {
        AppMethodBeat.i(213400);
        if (h.f(h.this) != null)
        {
          localView = h.f(h.this).getVideoLoadingProgressView();
          AppMethodBeat.o(213400);
          return localView;
        }
        View localView = LayoutInflater.from(h.a(h.this).getContext()).inflate(R.layout.xweb_video_progress, null);
        AppMethodBeat.o(213400);
        return localView;
      }
      
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(213360);
        if ((ConsoleMessage.MessageLevel.ERROR == paramAnonymousConsoleMessage.messageLevel()) && (h.j(h.this) != null) && (paramAnonymousConsoleMessage.message().split(":").length == 2))
        {
          h.j(h.this);
          paramAnonymousConsoleMessage.sourceId();
          l.kim();
        }
        if (h.f(h.this) != null)
        {
          bool = h.f(h.this).onConsoleMessage(paramAnonymousConsoleMessage);
          AppMethodBeat.o(213360);
          return bool;
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(213360);
        return bool;
      }
      
      public final void onExitFullscreenVideo(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(213297);
        Log.i("PinusWebView", "onExitFullscreenVideo");
        if (h.f(h.this) != null) {
          h.f(h.this).onExitFullscreenVideo(paramAnonymousBitmap);
        }
        AppMethodBeat.o(213297);
      }
      
      public final void onGeolocationPermissionsHidePrompt()
      {
        AppMethodBeat.i(213351);
        Log.i("PinusWebView", "onGeolocationPermissionsHidePrompt");
        if (h.f(h.this) != null)
        {
          h.f(h.this).onGeolocationPermissionsHidePrompt();
          AppMethodBeat.o(213351);
          return;
        }
        super.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(213351);
      }
      
      public final void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        AppMethodBeat.i(213344);
        Log.i("PinusWebView", "onGeolocationPermissionsShowPrompt");
        if (h.f(h.this) != null)
        {
          h.f(h.this).onGeolocationPermissionsShowPrompt(paramAnonymousString, paramAnonymousCallback);
          AppMethodBeat.o(213344);
          return;
        }
        super.onGeolocationPermissionsShowPrompt(paramAnonymousString, paramAnonymousCallback);
        AppMethodBeat.o(213344);
      }
      
      public final void onGetSampleString(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(213408);
        h.k(h.this).dt(paramAnonymousMap);
        AppMethodBeat.o(213408);
      }
      
      public final void onGetTranslateString(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(213413);
        h.k(h.this).ds(paramAnonymousMap);
        AppMethodBeat.o(213413);
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(213290);
        Log.i("PinusWebView", "onHideCustomView");
        h.a(h.this, null);
        if (h.g(h.this))
        {
          h.b(h.this, false);
          Log.i("PinusWebView", "onHideCustomView, mIsMediaPlaybackRequiresUserGesture:" + h.h(h.this) + ", mIsVideoPlaybackRequiresUserGesture:" + h.i(h.this));
          h.d(h.this).getSettings().setMediaPlaybackRequiresUserGesture(h.h(h.this));
          h.d(h.this).getSettings().setVideoPlaybackRequiresUserGesture(h.i(h.this));
        }
        if (h.f(h.this) != null) {}
        for (boolean bool = h.f(h.this).cxL();; bool = false)
        {
          if (bool)
          {
            Log.i("PinusWebView", "onHideCustomView isHandled:true");
            AppMethodBeat.o(213290);
            return;
          }
          h.c(h.this).setVisibility(0);
          if (h.e(h.this) != null)
          {
            h.e(h.this).onHideCustomView();
            AppMethodBeat.o(213290);
            return;
          }
          if (h.f(h.this) != null)
          {
            h.f(h.this).onHideCustomView();
            AppMethodBeat.o(213290);
            return;
          }
          super.onHideCustomView();
          AppMethodBeat.o(213290);
          return;
        }
      }
      
      public final boolean onJsAlert(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResultInterface paramAnonymousJsResultInterface)
      {
        AppMethodBeat.i(213309);
        Log.i("PinusWebView", "onJsAlert, message:".concat(String.valueOf(paramAnonymousString2)));
        if (h.f(h.this) != null)
        {
          bool = h.f(h.this).a(h.a(h.this), paramAnonymousString1, paramAnonymousString2, new g.d(paramAnonymousJsResultInterface));
          AppMethodBeat.o(213309);
          return bool;
        }
        boolean bool = super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResultInterface);
        AppMethodBeat.o(213309);
        return bool;
      }
      
      public final boolean onJsAlertInner(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(213301);
        boolean bool = onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, new JsResultInterfaceImpl(paramAnonymousObject));
        AppMethodBeat.o(213301);
        return bool;
      }
      
      public final boolean onJsConfirm(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResultInterface paramAnonymousJsResultInterface)
      {
        AppMethodBeat.i(213323);
        Log.i("PinusWebView", "onJsConfirm, message:".concat(String.valueOf(paramAnonymousString2)));
        if (h.f(h.this) != null)
        {
          bool = h.f(h.this).b(h.a(h.this), paramAnonymousString1, paramAnonymousString2, new g.d(paramAnonymousJsResultInterface));
          AppMethodBeat.o(213323);
          return bool;
        }
        boolean bool = super.onJsConfirm(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResultInterface);
        AppMethodBeat.o(213323);
        return bool;
      }
      
      public final boolean onJsConfirmInner(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(213317);
        boolean bool = onJsConfirm(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, new JsResultInterfaceImpl(paramAnonymousObject));
        AppMethodBeat.o(213317);
        return bool;
      }
      
      public final boolean onJsPrompt(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsResultInterface paramAnonymousJsResultInterface)
      {
        AppMethodBeat.i(213337);
        Log.i("PinusWebView", "onJsPrompt, message:".concat(String.valueOf(paramAnonymousString2)));
        if (h.f(h.this) != null)
        {
          bool = h.f(h.this).a(h.a(h.this), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, new g.c(paramAnonymousJsResultInterface));
          AppMethodBeat.o(213337);
          return bool;
        }
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsResultInterface);
        AppMethodBeat.o(213337);
        return bool;
      }
      
      public final boolean onJsPromptInner(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject)
      {
        AppMethodBeat.i(213329);
        boolean bool = onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, new JsResultInterfaceImpl(paramAnonymousObject));
        AppMethodBeat.o(213329);
        return bool;
      }
      
      public final void onPermissionRequest(PermissionRequest paramAnonymousPermissionRequest)
      {
        AppMethodBeat.i(213371);
        if (h.f(h.this) != null)
        {
          h.f(h.this).onPermissionRequest(paramAnonymousPermissionRequest);
          AppMethodBeat.o(213371);
          return;
        }
        super.onPermissionRequest(paramAnonymousPermissionRequest);
        AppMethodBeat.o(213371);
      }
      
      public final void onPermissionRequestCanceled(PermissionRequest paramAnonymousPermissionRequest)
      {
        AppMethodBeat.i(213382);
        if (h.f(h.this) != null)
        {
          h.f(h.this).onPermissionRequestCanceled(paramAnonymousPermissionRequest);
          AppMethodBeat.o(213382);
          return;
        }
        super.onPermissionRequestCanceled(paramAnonymousPermissionRequest);
        AppMethodBeat.o(213382);
      }
      
      public final void onProgressChanged(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(213260);
        if (h.f(h.this) != null)
        {
          h.f(h.this).a(h.a(h.this), paramAnonymousInt);
          AppMethodBeat.o(213260);
          return;
        }
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(213260);
      }
      
      public final void onReceivedTitle(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213269);
        Log.i("PinusWebView", "onReceivedTitle: ".concat(String.valueOf(paramAnonymousString)));
        if (h.f(h.this) != null)
        {
          h.f(h.this).d(h.a(h.this), paramAnonymousString);
          if (h.e(h.this) != null)
          {
            paramAnonymousWebView = h.e(h.this);
            if (h.a(h.this).getFullscreenVideoKind() != WebView.a.aifF) {
              break label109;
            }
          }
        }
        label109:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bV(true, bool);
          AppMethodBeat.o(213269);
          return;
          super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
          break;
        }
      }
      
      public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        boolean bool = false;
        AppMethodBeat.i(213281);
        Log.i("PinusWebView", "onShowCustomView");
        h.a(h.this, paramAnonymousCustomViewCallback);
        if (!h.g(h.this))
        {
          h.b(h.this, true);
          h.c(h.this, h.d(h.this).getSettings().getMediaPlaybackRequiresUserGesture());
          h.d(h.this, h.d(h.this).getSettings().getVideoPlaybackRequiresUserGesture());
          Log.i("PinusWebView", "onShowCustomView, mIsMediaPlaybackRequiresUserGesture:" + h.h(h.this) + ", mIsVideoPlaybackRequiresUserGesture:" + h.i(h.this));
          h.d(h.this).getSettings().setMediaPlaybackRequiresUserGesture(false);
          h.d(h.this).getSettings().setVideoPlaybackRequiresUserGesture(false);
        }
        if (h.f(h.this) != null) {
          bool = h.f(h.this).a(paramAnonymousView, paramAnonymousCustomViewCallback);
        }
        l.khS();
        if (bool)
        {
          Log.i("PinusWebView", "onShowCustomView isHandled:true");
          AppMethodBeat.o(213281);
          return;
        }
        h.c(h.this).setVisibility(4);
        if (h.e(h.this) != null)
        {
          l.a(WebView.WebViewKind.aifL, h.e(h.this) instanceof com.tencent.xweb.extension.video.d, h.this.getUrl());
          h.e(h.this).onShowCustomView(paramAnonymousView, paramAnonymousCustomViewCallback);
          AppMethodBeat.o(213281);
          return;
        }
        if (h.f(h.this) != null)
        {
          h.f(h.this).onShowCustomView(paramAnonymousView, paramAnonymousCustomViewCallback);
          AppMethodBeat.o(213281);
          return;
        }
        super.onShowCustomView(paramAnonymousView, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(213281);
      }
      
      public final boolean onShowFileChooser(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, ValueCallback<Uri[]> paramAnonymousValueCallback, WebChromeClient.FileChooserParams paramAnonymousFileChooserParams)
      {
        AppMethodBeat.i(213392);
        Log.i("PinusWebView", "onShowFileChooser last method");
        if (h.f(h.this) != null)
        {
          bool = h.f(h.this).a(h.a(h.this), paramAnonymousValueCallback, new g.a(paramAnonymousFileChooserParams));
          AppMethodBeat.o(213392);
          return bool;
        }
        boolean bool = super.onShowFileChooser(paramAnonymousWebView, paramAnonymousValueCallback, paramAnonymousFileChooserParams);
        AppMethodBeat.o(213392);
        return bool;
      }
    };
    this.aikW = new WebViewClient()
    {
      private String aikZ = null;
      private String aila = null;
      
      public final void doUpdateVisitedHistory(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(213348);
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("data:text/html;charset=utf-8")))
        {
          Log.w("PinusWebView", "doUpdateVisitedHistory, ignore");
          AppMethodBeat.o(213348);
          return;
        }
        if (h.l(h.this) != null)
        {
          h.l(h.this).b(h.a(h.this), paramAnonymousString, paramAnonymousBoolean);
          AppMethodBeat.o(213348);
          return;
        }
        super.doUpdateVisitedHistory(paramAnonymousWebView, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(213348);
      }
      
      public final void onLoadResource(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213310);
        if (h.l(h.this) != null)
        {
          h.l(h.this).i(h.a(h.this), paramAnonymousString);
          AppMethodBeat.o(213310);
          return;
        }
        super.onLoadResource(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(213310);
      }
      
      public final void onPageCommitVisible(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213286);
        Log.i("PinusWebView", "onPageCommitVisible, url:".concat(String.valueOf(paramAnonymousString)));
        if (h.l(h.this) != null) {
          h.l(h.this).e(h.a(h.this), paramAnonymousString);
        }
        AppMethodBeat.o(213286);
      }
      
      public final void onPageFinished(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213303);
        if ((this.aila != null) && (this.aila.equals(paramAnonymousString)))
        {
          Log.i("PinusWebView", "onPageFinished abandoned, url:".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(213303);
          return;
        }
        Log.i("PinusWebView", "onPageFinished, url:".concat(String.valueOf(paramAnonymousString)));
        boolean bool;
        if (h.e(h.this) != null)
        {
          com.tencent.xweb.extension.video.a locala = h.e(h.this);
          if (h.a(h.this).getFullscreenVideoKind() == WebView.a.aifF)
          {
            bool = true;
            locala.bV(false, bool);
          }
        }
        else
        {
          this.aila = paramAnonymousString;
          if (h.l(h.this) == null) {
            break label196;
          }
          h.l(h.this).b(h.a(h.this), paramAnonymousString);
        }
        for (;;)
        {
          com.tencent.xweb.internal.i.khf().kha();
          l.A(paramAnonymousString, System.currentTimeMillis() - h.n(h.this), h.m(h.this));
          h.a(h.this, System.currentTimeMillis());
          com.tencent.xweb.xwalk.d.a(h.a(h.this));
          AppMethodBeat.o(213303);
          return;
          bool = false;
          break;
          label196:
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        }
      }
      
      public final void onPageStarted(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(213296);
        Log.i("PinusWebView", "onPageStarted, url:".concat(String.valueOf(paramAnonymousString)));
        if (h.l(h.this) != null)
        {
          h.l(h.this).b(h.a(h.this), paramAnonymousString, paramAnonymousBitmap);
          com.tencent.xweb.internal.i.khf().kgZ();
          this.aila = null;
          if ((this.aikZ != null) && (paramAnonymousString != null) && (!paramAnonymousString.equals(this.aikZ)) && (l.bIg(paramAnonymousString) != l.bIg(this.aikZ)))
          {
            if ((l.bIg(this.aikZ) != 1) || (l.bIg(paramAnonymousString) != 2)) {
              break label231;
            }
            h.a(h.this, 1);
          }
          label123:
          this.aikZ = paramAnonymousString;
          h.a(h.this, System.currentTimeMillis());
          paramAnonymousWebView = paramAnonymousString;
          if (paramAnonymousString == null) {
            paramAnonymousWebView = "";
          }
          l.jK(paramAnonymousWebView, h.m(h.this));
          if (h.e(h.this) != null)
          {
            paramAnonymousWebView = h.e(h.this);
            if (h.a(h.this).getFullscreenVideoKind() != WebView.a.aifF) {
              break label262;
            }
          }
        }
        label262:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousWebView.bV(true, bool);
          h.k(h.this).kgy();
          AppMethodBeat.o(213296);
          return;
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          break;
          label231:
          if ((l.bIg(this.aikZ) != 2) || (l.bIg(paramAnonymousString) != 1)) {
            break label123;
          }
          h.a(h.this, 2);
          break label123;
        }
      }
      
      public final void onReceivedError(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(213359);
        Log.i("PinusWebView", "onReceivedError, errorCode:" + paramAnonymousInt + ", desc:" + paramAnonymousString1 + ", url:" + paramAnonymousString2);
        h.o(h.this);
        if (h.l(h.this) != null) {
          h.l(h.this).a(h.a(h.this), paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        for (;;)
        {
          com.tencent.xweb.internal.i.khf().khg();
          l.d(paramAnonymousString2, paramAnonymousInt, System.currentTimeMillis() - h.n(h.this), h.m(h.this));
          if (!h.l(h.this).b(h.a(h.this), paramAnonymousInt, paramAnonymousString1, paramAnonymousString2)) {
            break;
          }
          AppMethodBeat.o(213359);
          return;
          super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        paramAnonymousWebView = com.tencent.xweb.util.f.bHY(paramAnonymousString2);
        h.d(h.this).loadDataWithBaseURL("file:///android_asset/", paramAnonymousWebView, "text/html", "utf-8", null);
        AppMethodBeat.o(213359);
      }
      
      public final void onReceivedError(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceErrorInterface paramAnonymousWebResourceErrorInterface)
      {
        AppMethodBeat.i(213370);
        Log.i("PinusWebView", "onReceivedSslError, error:".concat(String.valueOf(paramAnonymousWebResourceErrorInterface)));
        if (h.l(h.this) != null)
        {
          ag localag = h.l(h.this);
          com.tencent.xweb.WebView localWebView = h.a(h.this);
          paramAnonymousWebResourceRequest = new g.f(paramAnonymousWebResourceRequest);
          if (paramAnonymousWebResourceErrorInterface == null) {}
          for (paramAnonymousWebView = null;; paramAnonymousWebView = new g.1(paramAnonymousWebResourceErrorInterface))
          {
            localag.a(localWebView, paramAnonymousWebResourceRequest, paramAnonymousWebView);
            AppMethodBeat.o(213370);
            return;
          }
        }
        super.onReceivedError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceErrorInterface);
        AppMethodBeat.o(213370);
      }
      
      public final void onReceivedHttpAuthRequest(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, HttpAuthHandlerInterface paramAnonymousHttpAuthHandlerInterface, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(213404);
        Log.i("PinusWebView", "onReceivedHttpAuthRequest, host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (h.l(h.this) != null)
        {
          h.l(h.this).a(h.a(h.this), new g.b(paramAnonymousHttpAuthHandlerInterface), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(213404);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousWebView, paramAnonymousHttpAuthHandlerInterface, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(213404);
      }
      
      public final void onReceivedHttpError(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, android.webkit.WebResourceResponse paramAnonymousWebResourceResponse)
      {
        AppMethodBeat.i(213394);
        Object localObject;
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject = String.valueOf(paramAnonymousWebResourceResponse.getStatusCode());
          Log.i("PinusWebView", "onReceivedHttpError, code:".concat(String.valueOf(localObject)));
          if (h.l(h.this) == null) {
            break label208;
          }
          localObject = h.l(h.this);
          com.tencent.xweb.WebView localWebView = h.a(h.this);
          g.f localf = new g.f(paramAnonymousWebResourceRequest);
          if (paramAnonymousWebResourceResponse != null) {
            break label142;
          }
          paramAnonymousWebResourceResponse = null;
          label83:
          ((ag)localObject).a(localWebView, localf, paramAnonymousWebResourceResponse);
          label93:
          if (paramAnonymousWebResourceRequest.isForMainFrame()) {
            if (paramAnonymousWebResourceRequest.getUrl() == null) {
              break label218;
            }
          }
        }
        label142:
        label208:
        label218:
        for (paramAnonymousWebResourceRequest = paramAnonymousWebResourceRequest.getUrl().toString();; paramAnonymousWebResourceRequest = "")
        {
          onPageFinished(paramAnonymousWebView, paramAnonymousWebResourceRequest);
          AppMethodBeat.o(213394);
          return;
          localObject = "Invalid";
          break;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramAnonymousWebResourceResponse = new com.tencent.xweb.WebResourceResponse(paramAnonymousWebResourceResponse.getMimeType(), paramAnonymousWebResourceResponse.getEncoding(), paramAnonymousWebResourceResponse.getStatusCode(), paramAnonymousWebResourceResponse.getReasonPhrase(), paramAnonymousWebResourceResponse.getResponseHeaders(), paramAnonymousWebResourceResponse.getData());
            break label83;
          }
          paramAnonymousWebResourceResponse = new com.tencent.xweb.WebResourceResponse(paramAnonymousWebResourceResponse.getMimeType(), paramAnonymousWebResourceResponse.getEncoding(), paramAnonymousWebResourceResponse.getData());
          break label83;
          super.onReceivedHttpError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceResponse);
          break label93;
        }
      }
      
      public final void onReceivedSslError(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(213385);
        Log.i("PinusWebView", "onReceivedSslError, error:" + paramAnonymousSslError.getPrimaryError());
        if (h.l(h.this) != null)
        {
          h.l(h.this).a(h.a(h.this), new g.e(paramAnonymousSslErrorHandler), paramAnonymousSslError);
          AppMethodBeat.o(213385);
          return;
        }
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(213385);
      }
      
      public final boolean onRenderProcessGone(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, WebViewClient.RenderProcessGoneDetail paramAnonymousRenderProcessGoneDetail)
      {
        AppMethodBeat.i(213412);
        Log.i("PinusWebView", "onRenderProcessGone, didCrash:" + paramAnonymousRenderProcessGoneDetail.didCrash() + ", rendererPriorityAtExit:" + paramAnonymousRenderProcessGoneDetail.rendererPriorityAtExit());
        if (h.l(h.this) != null)
        {
          h.l(h.this);
          h.a(h.this);
          new ag.a(paramAnonymousRenderProcessGoneDetail.didCrash(), paramAnonymousRenderProcessGoneDetail.rendererPriorityAtExit());
          bool = ag.kfY();
          AppMethodBeat.o(213412);
          return bool;
        }
        boolean bool = super.onRenderProcessGone(paramAnonymousWebView, paramAnonymousRenderProcessGoneDetail);
        AppMethodBeat.o(213412);
        return bool;
      }
      
      public final void onScaleChanged(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(213339);
        if (h.l(h.this) != null)
        {
          h.l(h.this).a(h.a(h.this), paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(213339);
          return;
        }
        super.onScaleChanged(paramAnonymousWebView, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(213339);
      }
      
      public final android.webkit.WebResourceResponse shouldInterceptRequest(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        Object localObject2 = null;
        AppMethodBeat.i(213330);
        if (h.l(h.this) != null)
        {
          g.f localf = new g.f(paramAnonymousWebResourceRequest);
          if (localf.aikC == null) {}
          for (Object localObject1 = null;; localObject1 = localf.aikC.getBundle())
          {
            paramAnonymousWebView = localObject2;
            if (localObject1 != null) {
              paramAnonymousWebView = h.l(h.this).a(h.a(h.this), localf, (Bundle)localObject1);
            }
            localObject1 = paramAnonymousWebView;
            if (paramAnonymousWebView == null) {
              localObject1 = h.l(h.this).a(h.a(h.this), localf);
            }
            paramAnonymousWebView = (com.tencent.xweb.pinus.sdk.WebView)localObject1;
            if (localObject1 == null) {
              paramAnonymousWebView = h.l(h.this).c(h.a(h.this), paramAnonymousWebResourceRequest.getUrl().toString());
            }
            paramAnonymousWebView = g.a(paramAnonymousWebView);
            AppMethodBeat.o(213330);
            return paramAnonymousWebView;
          }
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(213330);
        return paramAnonymousWebView;
      }
      
      public final android.webkit.WebResourceResponse shouldInterceptRequest(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213320);
        if (h.l(h.this) != null)
        {
          paramAnonymousWebView = g.a(h.l(h.this).c(h.a(h.this), paramAnonymousString));
          AppMethodBeat.o(213320);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(213320);
        return paramAnonymousWebView;
      }
      
      public final boolean shouldOverrideUrlLoading(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        AppMethodBeat.i(213275);
        if (com.tencent.xweb.xwalk.d.bIm(paramAnonymousWebResourceRequest.getUrl().toString()))
        {
          AppMethodBeat.o(213275);
          return true;
        }
        if (h.l(h.this) != null)
        {
          paramAnonymousWebView = new g.f(paramAnonymousWebResourceRequest);
          bool = h.l(h.this).e(h.a(h.this), paramAnonymousWebView);
          Log.i("PinusWebView", "shouldOverrideUrlLoading, ret:" + bool + ", url:" + paramAnonymousWebResourceRequest.getUrl().toString());
          AppMethodBeat.o(213275);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
        AppMethodBeat.o(213275);
        return bool;
      }
      
      public final boolean shouldOverrideUrlLoading(com.tencent.xweb.pinus.sdk.WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(213265);
        if (com.tencent.xweb.xwalk.d.bIm(paramAnonymousString))
        {
          AppMethodBeat.o(213265);
          return true;
        }
        if (h.l(h.this) != null)
        {
          bool = h.l(h.this).a(h.a(h.this), paramAnonymousString);
          Log.i("PinusWebView", "shouldOverrideUrlLoading, ret:" + bool + ", url:" + paramAnonymousString);
          AppMethodBeat.o(213265);
          return bool;
        }
        boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(213265);
        return bool;
      }
    };
    this.aikX = new com.tencent.xweb.x5.export.external.extension.proxy.a()
    {
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(213244);
        if (h.p(h.this) != null)
        {
          s.a locala = h.p(h.this).C(paramAnonymousString, paramAnonymousBundle);
          if (locala.aipG)
          {
            Log.i("PinusWebView", "onMiscCallBack, method(" + paramAnonymousString + ") intercepted, result:" + locala.result);
            paramAnonymousString = locala.result;
            AppMethodBeat.o(213244);
            return paramAnonymousString;
          }
        }
        if (h.q(h.this) != null)
        {
          paramAnonymousString = h.q(h.this).onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(213244);
          return paramAnonymousString;
        }
        AppMethodBeat.o(213244);
        return null;
      }
    };
    this.mApkVersion = XWalkEnvironment.getAvailableVersion();
    a locala = new a(paramWebView.getContext(), this.mApkVersion);
    this.aikF = new a(locala);
    this.aikG = new AbsoluteLayout(locala);
    this.aikF.getContentView().addView(this.aikG);
    this.aikF.setCustomOnScrollChangedListener(new WebView.ScrollChangedListener()
    {
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(213263);
        h.c(h.this).scrollTo(paramAnonymousInt1, paramAnonymousInt2);
        if (h.b(h.this) != null) {
          h.b(h.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, h.d(h.this));
        }
        AppMethodBeat.o(213263);
      }
    });
    this.aikF.setCustomOnOverScrolledListener(new WebView.OverScrolledListener()
    {
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(213257);
        if (h.b(h.this) != null) {
          h.b(h.this).onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousView);
        }
        AppMethodBeat.o(213257);
      }
      
      public final void onOverScrolled(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(213246);
        if (paramAnonymousBoolean)
        {
          h.a(h.this, true);
          AppMethodBeat.o(213246);
          return;
        }
        h.a(h.this, false);
        AppMethodBeat.o(213246);
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(213251);
        if (h.b(h.this) != null)
        {
          paramAnonymousBoolean = h.b(h.this).overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean, paramAnonymousView);
          AppMethodBeat.o(213251);
          return paramAnonymousBoolean;
        }
        AppMethodBeat.o(213251);
        return false;
      }
    });
    this.aikF.setBackgroundColor(0);
    this.aigp = paramWebView;
    this.aikE = new i(this.aikF);
    this.aikF.setWebChromeClient(this.aikV);
    this.aikF.setWebViewClient(this.aikW);
    this.aikO = new s(this);
    this.aikF.setProxyWebViewClientExtension(this.aikX);
    this.aikR = new aq(this.aigp, this);
    paramWebView = this.aikF.getContext();
    Log.i("PinusWebView", "initFullscreenVideo, kind:" + getFullscreenVideoKind() + ", activity:" + paramWebView);
    this.aikP = e.a(this.aigp.getWebCoreType(), paramWebView, this.aigp, this.aikF, com.tencent.xweb.extension.video.c.kgA());
    if (getFullscreenVideoKind() == WebView.a.aifF) {
      this.aikP.hm(this.aikF);
    }
    AppMethodBeat.o(213375);
  }
  
  public static boolean oX(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(213356);
      PSInitializerWrapper.getInstance().initPinus(paramContext);
      boolean bool = PSInitializerWrapper.getInstance().isCoreReady();
      AppMethodBeat.o(213356);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void A(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(214214);
    if (this.aikN != null) {
      this.aikN.onMiscCallBack(paramString, paramBundle);
    }
    AppMethodBeat.o(214214);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(213759);
    this.aikF.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(213759);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(213575);
    if (this.aikK)
    {
      AppMethodBeat.o(213575);
      return false;
    }
    boolean bool = this.aikF.canGoBack();
    AppMethodBeat.o(213575);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(214041);
    boolean bool = this.aikF.canGoForward();
    AppMethodBeat.o(214041);
    return bool;
  }
  
  public final Bitmap captureBitmap()
  {
    AppMethodBeat.i(214018);
    Log.i("PinusWebView", "captureBitmap, start");
    Object localObject = ((ViewGroup)((ViewGroup)this.aikF.getChildAt(0)).getChildAt(0)).getChildAt(0);
    if ((localObject instanceof TextureView))
    {
      localObject = ((TextureView)localObject).getBitmap();
      Log.i("PinusWebView", "captureBitmap, bitmap:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(214018);
      return localObject;
    }
    AppMethodBeat.o(214018);
    return null;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(214014);
    final View localView = ((ViewGroup)((ViewGroup)this.aikF.getChildAt(0)).getChildAt(0)).getChildAt(0);
    if ((localView instanceof TextureView)) {
      com.tencent.threadpool.k.c.bq(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213238);
          Log.i("PinusWebView", "captureBitmap, onFinishGetBitmap:".concat(String.valueOf(((TextureView)localView).getBitmap())));
          AppMethodBeat.o(213238);
        }
      });
    }
    AppMethodBeat.o(214014);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(214034);
    this.aikF.clearHistory();
    AppMethodBeat.o(214034);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(213855);
    this.aikF.clearMatches();
    AppMethodBeat.o(213855);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(213671);
    this.aikF.clearSslPreferences();
    AppMethodBeat.o(213671);
  }
  
  public final void clearView()
  {
    AppMethodBeat.i(213607);
    this.aikF.clearView();
    AppMethodBeat.o(213607);
  }
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(214154);
    WebBackForwardList localWebBackForwardList = this.aikF.copyBackForwardList();
    AppMethodBeat.o(214154);
    return localWebBackForwardList;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(213616);
    this.aikF.destroy();
    AppMethodBeat.o(213616);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(213626);
    if (this.aikP != null) {
      this.aikP.OV(paramBoolean);
    }
    AppMethodBeat.o(213626);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(213648);
    this.aikF.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(213648);
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(213871);
    this.aikF.findAllAsync(paramString);
    AppMethodBeat.o(213871);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(213862);
    this.aikF.findNext(paramBoolean);
    AppMethodBeat.o(213862);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(213882);
    String str = "pinus, sdk ver = " + ao.kge() + "\n apk ver = " + XWalkEnvironment.getAvailableVersion() + "\n detail = " + XWalkEnvironment.getAvailableVersionDetail();
    AppMethodBeat.o(213882);
    return str;
  }
  
  public final Object getBridge()
  {
    AppMethodBeat.i(213773);
    if (this.aikF == null)
    {
      Log.e("PinusWebView", "getPinusBridge, mWebview is null");
      AppMethodBeat.o(213773);
      return null;
    }
    Object localObject = this.aikF.getBridge();
    AppMethodBeat.o(213773);
    return localObject;
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(213687);
    int i = this.aikF.getContentHeight();
    AppMethodBeat.o(213687);
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
    return null;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(213990);
    WebView.a locala = com.tencent.xweb.a.keX().bHi(com.tencent.xweb.WebView.getCurStrModule());
    AppMethodBeat.o(213990);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(213824);
    WebView.b localb = new WebView.b();
    HitTestResultInterface localHitTestResultInterface = this.aikF.getHitTestResult();
    localb.mType = localHitTestResultInterface.getType();
    localb.mExtra = localHitTestResultInterface.getExtra();
    AppMethodBeat.o(213824);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214178);
    paramString1 = ah.kfZ().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(214178);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, k paramk)
  {
    AppMethodBeat.i(214106);
    boolean bool = this.aikF.getImageBitmapToFile(paramString1, paramString2, paramString3, paramk);
    AppMethodBeat.o(214106);
    return bool;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(213695);
    float f = this.aikF.getScale();
    AppMethodBeat.o(213695);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(214146);
    int i = this.aikF.computeVerticalScrollRange();
    AppMethodBeat.o(214146);
    return i;
  }
  
  public final ad getSettings()
  {
    return this.aikE;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(213831);
    String str = this.aikF.getTitle();
    AppMethodBeat.o(213831);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.aikG;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(213781);
    String str = this.aikF.getUrl();
    AppMethodBeat.o(213781);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(213877);
    String str = "pinus, sdkver = " + ao.kge() + ", apkver = " + this.mApkVersion + ", detail = " + XWalkEnvironment.getAvailableVersionDetail();
    AppMethodBeat.o(213877);
    return str;
  }
  
  public final View getView()
  {
    return this.aikF;
  }
  
  public final int getVisibleTitleHeight()
  {
    return 0;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(213901);
    View localView = getWebViewUI();
    if ((localView instanceof com.tencent.xweb.pinus.sdk.WebView))
    {
      i = ((com.tencent.xweb.pinus.sdk.WebView)localView).computeHorizontalScrollOffset();
      AppMethodBeat.o(213901);
      return i;
    }
    int i = localView.getScrollX();
    AppMethodBeat.o(213901);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(213895);
    int i = this.aikF.computeVerticalScrollOffset();
    AppMethodBeat.o(213895);
    return i;
  }
  
  public final af getWebViewCallbackClient()
  {
    return this.sLl;
  }
  
  public final View getWebViewUI()
  {
    return this.aikF;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(213586);
    this.aikF.goBack();
    AppMethodBeat.o(213586);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(214049);
    this.aikF.goForward();
    AppMethodBeat.o(214049);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.aihJ;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(214097);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.d("PinusWebView", "invokeMiscMethod, method string is null or empty");
      AppMethodBeat.o(214097);
      return null;
    }
    Log.d("PinusWebView", "invokeMiscMethod, method:".concat(String.valueOf(paramString)));
    if (paramString.equals("supportTranslateWebSite"))
    {
      bool1 = PSCoreWrapper.getInstance().isSupportTranslateWebSite();
      paramString = new Bundle();
      paramString.putBoolean("result", bool1);
      Log.i("PinusWebView", "translate: xweb is supportTranslateWebSite = ".concat(String.valueOf(bool1)));
      AppMethodBeat.o(214097);
      return paramString;
    }
    if (paramString.equals("getTranslateSampleString"))
    {
      Log.i("PinusWebView", "translate: xweb is detectTranslateWebSiteIsNeeded, getTranslateSampleString");
      this.aikF.getTranslateSampleString(0);
      AppMethodBeat.o(214097);
      return null;
    }
    if (paramString.equals("translateWebSite"))
    {
      this.aikR.aign = true;
      AppMethodBeat.o(214097);
      return null;
    }
    if (paramString.equals("replaceTranslatedString"))
    {
      this.aikR.ci(paramBundle);
      AppMethodBeat.o(214097);
      return null;
    }
    if (paramString.equals("getJavaScriptAccessClipboardBlocked"))
    {
      paramString = new Bundle(1);
      if (this.aikF != null) {
        if (!this.aikF.getSettings().getJavascriptCanAccessClipboard())
        {
          bool1 = bool2;
          paramString.putBoolean("blocked", bool1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(214097);
        return paramString;
        bool1 = false;
        break;
        paramString.putBoolean("blocked", false);
      }
    }
    if (paramString.equals("setJavaScriptAccessClipboardBlocked"))
    {
      if ((this.aikF != null) && (paramBundle != null))
      {
        bool2 = paramBundle.getBoolean("blocked", false);
        paramString = this.aikF.getSettings();
        if (bool2) {
          break label338;
        }
      }
      for (;;)
      {
        paramString.setJavascriptCanAccessClipboard(bool1);
        paramString = new Bundle();
        AppMethodBeat.o(214097);
        return paramString;
        label338:
        bool1 = false;
      }
    }
    AppMethodBeat.o(214097);
    return null;
  }
  
  public final void irA()
  {
    AppMethodBeat.i(214201);
    if (this.aikN != null) {
      this.aikN.onMiscCallBack("onTranslateFinish", new Bundle());
    }
    AppMethodBeat.o(214201);
  }
  
  public final boolean isOverScrollStart()
  {
    AppMethodBeat.i(213907);
    boolean bool = this.aikL;
    View localView = getWebViewUI();
    if ((localView instanceof com.tencent.xweb.pinus.sdk.WebView)) {}
    for (int i = ((com.tencent.xweb.pinus.sdk.WebView)localView).computeVerticalScrollOffset(); (i == 0) && (bool); i = localView.getScrollY())
    {
      AppMethodBeat.o(213907);
      return true;
    }
    AppMethodBeat.o(213907);
    return false;
  }
  
  public final void kgz()
  {
    AppMethodBeat.i(214188);
    if (this.aikN != null) {
      this.aikN.onMiscCallBack("onTranslateStart", new Bundle());
    }
    this.aikF.setTranslateMode(true);
    AppMethodBeat.o(214188);
  }
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(213600);
    if (this.aikS != null) {
      this.aikS.onCustomViewHidden();
    }
    AppMethodBeat.o(213600);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213680);
    this.aikF.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(213680);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(213721);
    this.aikF.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(213721);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(213569);
    if ((paramString != null) && (paramString.trim().startsWith("javascript:")))
    {
      this.aikF.evaluateJavascript(paramString, null);
      AppMethodBeat.o(213569);
      return;
    }
    this.aikK = false;
    this.aikF.loadUrl(paramString);
    AppMethodBeat.o(213569);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(213751);
    this.aikF.loadUrl(paramString, paramMap);
    AppMethodBeat.o(213751);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(214135);
    this.aikF.onHide();
    AppMethodBeat.o(214135);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(213981);
    this.aikF.onPause();
    AppMethodBeat.o(213981);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(213974);
    this.aikF.onResume();
    AppMethodBeat.o(213974);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(214125);
    this.aikF.onShow();
    AppMethodBeat.o(214125);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(213711);
    int i = this.aikF.getScrollBarStyle();
    if ((i == 0) || (i == 33554432))
    {
      AppMethodBeat.o(213711);
      return true;
    }
    AppMethodBeat.o(213711);
    return false;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(213662);
    this.aikF.reload();
    AppMethodBeat.o(213662);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(213790);
    this.aikF.removeJavascriptInterface(paramString);
    AppMethodBeat.o(213790);
  }
  
  public final void replaceTranslatedString(Map<String, String> paramMap)
  {
    AppMethodBeat.i(214225);
    this.aikF.replaceTranslatedString(paramMap);
    AppMethodBeat.o(214225);
  }
  
  public final boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(214005);
    boolean bool = this.aikF.savePage(paramString1, paramString2, paramInt);
    AppMethodBeat.o(214005);
    return bool;
  }
  
  public final void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(214116);
    this.aikF.setBottomHeight(paramInt);
    AppMethodBeat.o(214116);
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(213552);
    this.aikF.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(213552);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(213560);
    this.aikF.setFindListener(paramFindListener);
    AppMethodBeat.o(213560);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(214079);
    this.aikF.setHorizontalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(214079);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(214166);
    ah.kfZ().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(214166);
  }
  
  public final void setJSExceptionListener(ai paramai)
  {
    this.aikQ = paramai;
  }
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(214069);
    this.aikF.setVerticalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(214069);
  }
  
  public final w setVideoJsCallback(x paramx)
  {
    AppMethodBeat.i(213635);
    if ((this.aikP != null) && (this.aikP.hn(paramx)))
    {
      paramx = new w()
      {
        public final void Z(double paramAnonymousDouble)
        {
          AppMethodBeat.i(213270);
          if (h.e(h.this) != null) {
            h.e(h.this).Z(paramAnonymousDouble);
          }
          AppMethodBeat.o(213270);
        }
        
        public final void hSS()
        {
          AppMethodBeat.i(213261);
          if (h.e(h.this) != null) {
            h.e(h.this).hSS();
          }
          AppMethodBeat.o(213261);
        }
        
        public final void kfv()
        {
          AppMethodBeat.i(213252);
          if (h.e(h.this) != null) {
            h.e(h.this).kfv();
          }
          AppMethodBeat.o(213252);
        }
        
        public final boolean kfw()
        {
          AppMethodBeat.i(213282);
          if (h.e(h.this) != null)
          {
            boolean bool = h.e(h.this).kfw();
            AppMethodBeat.o(213282);
            return bool;
          }
          AppMethodBeat.o(213282);
          return false;
        }
      };
      AppMethodBeat.o(213635);
      return paramx;
    }
    Log.i("PinusWebView", "setVideoJsCallback not support");
    AppMethodBeat.o(213635);
    return null;
  }
  
  public final void setWebChromeClient(z paramz)
  {
    this.aikI = paramz;
  }
  
  public final void setWebContentsSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214246);
    this.aikF.setWebContentsSize(paramInt1, paramInt2);
    AppMethodBeat.o(214246);
  }
  
  public final void setWebViewCallbackClient(af paramaf)
  {
    this.sLl = paramaf;
  }
  
  public final void setWebViewClient(ag paramag)
  {
    this.aikH = paramag;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(213916);
    this.aikN = parama;
    this.aikF.setProxyWebViewClientExtension(this.aikX);
    AppMethodBeat.o(213916);
  }
  
  public final void setXWebKeyEventHandler(al paramal)
  {
    AppMethodBeat.i(214236);
    PSCoreWrapper.invokeRuntimeChannel(80015, new Object[] { getBridge(), paramal });
    AppMethodBeat.o(214236);
  }
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(214026);
    this.aikF.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(214026);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(213799);
    this.aikF.stopLoading();
    AppMethodBeat.o(213799);
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
    AppMethodBeat.i(214058);
    boolean bool = PSCoreWrapper.getInstance().hasFeature(paramInt);
    AppMethodBeat.o(214058);
    return bool;
  }
  
  public final boolean supportSetWebContentsSize()
  {
    AppMethodBeat.i(214253);
    boolean bool = supportFeature(1042);
    AppMethodBeat.o(214253);
    return bool;
  }
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(213739);
    boolean bool = this.aikF.zoomIn();
    AppMethodBeat.o(213739);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(213732);
    boolean bool = this.aikF.zoomOut();
    AppMethodBeat.o(213732);
    return bool;
  }
  
  final class a
    extends com.tencent.xweb.pinus.sdk.WebView
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(213234);
      super.invalidate();
      if (h.b(h.this) != null) {
        h.b(h.this);
      }
      AppMethodBeat.o(213234);
    }
    
    protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(213229);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (h.a(h.this) != null) {
        h.a(h.this).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(213229);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.h
 * JD-Core Version:    0.7.0.1
 */