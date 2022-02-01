package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.DownloadListener;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ab;
import com.tencent.xweb.ad;
import com.tencent.xweb.af;
import com.tencent.xweb.ag;
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
import com.tencent.xweb.internal.i;
import com.tencent.xweb.sys.c.c;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
import java.util.Map;
import java.util.Objects;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.R.layout;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkGetImageBitmapToFileFinishedCallback;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkHitTestResult.type;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkNavigationItem;
import org.xwalk.core.XWalkProxyWebViewClientExtension;
import org.xwalk.core.XWalkReflectionInitHandler;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkUIClient.InitiateBy;
import org.xwalk.core.XWalkUIClient.JavascriptMessageType;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkView.OverScrolledListener;
import org.xwalk.core.XWalkView.ScrollChangedListener;
import org.xwalk.core.XWalkWebResourceError;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class j
  implements aq.a, IWebView, com.tencent.xweb.internal.h
{
  private WebView aigp;
  private AbsoluteLayout aikG;
  private long aikJ;
  private boolean aikK;
  private boolean aikL;
  private int aikM;
  private com.tencent.xweb.x5.export.external.extension.proxy.a aikN;
  private s aikO;
  private com.tencent.xweb.extension.video.a aikP;
  private ai aikQ;
  private aq aikR;
  private l aioV;
  private n aioW;
  private XWalkView aioX;
  private k aioY;
  private h aioZ;
  private final XWalkProxyWebViewClientExtension aipa;
  private int mApkVersion;
  private Handler mzc;
  private af sLl;
  private ag tyV;
  private z tyW;
  
  public j(WebView paramWebView)
  {
    AppMethodBeat.i(154358);
    this.tyV = new ag();
    this.tyW = new z();
    this.aikJ = 0L;
    this.aikK = false;
    this.aikL = false;
    this.aikM = 0;
    this.aikN = new com.tencent.xweb.x5.export.external.extension.proxy.a();
    this.aikQ = null;
    this.aipa = new XWalkProxyWebViewClientExtension()
    {
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(212869);
        if (j.p(j.this) != null)
        {
          s.a locala = j.p(j.this).C(paramAnonymousString, paramAnonymousBundle);
          if (locala.aipG)
          {
            Log.i("XWWebView", "onMiscCallBack, method(" + paramAnonymousString + ") intercepted, result:" + locala.result);
            paramAnonymousString = locala.result;
            AppMethodBeat.o(212869);
            return paramAnonymousString;
          }
        }
        if (j.k(j.this) != null)
        {
          paramAnonymousString = j.k(j.this).onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(212869);
          return paramAnonymousString;
        }
        AppMethodBeat.o(212869);
        return null;
      }
    };
    this.mApkVersion = XWalkEnvironment.getAvailableVersion();
    XWalkContextWrapper localXWalkContextWrapper = new XWalkContextWrapper(paramWebView.getContext(), this.mApkVersion);
    XWalkReflectionInitHandler.handlePreInit(localXWalkContextWrapper);
    this.aioX = new a(localXWalkContextWrapper);
    this.aikG = new AbsoluteLayout(localXWalkContextWrapper);
    this.aioX.getXWalkContentView().addView(this.aikG);
    this.aioX.setCustomOnScrollChangedListener(new XWalkView.ScrollChangedListener()
    {
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(212842);
        j.j(j.this).scrollTo(paramAnonymousInt1, paramAnonymousInt2);
        if (j.b(j.this) != null) {
          j.b(j.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, j.c(j.this));
        }
        AppMethodBeat.o(212842);
      }
    });
    this.aioX.setCustomOnOverScrolledListener(new XWalkView.OverScrolledListener()
    {
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(212854);
        if (j.b(j.this) != null) {
          j.b(j.this).onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousView);
        }
        AppMethodBeat.o(212854);
      }
      
      public final void onOverScrolled(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(212848);
        if (paramAnonymousBoolean)
        {
          j.a(j.this, true);
          AppMethodBeat.o(212848);
          return;
        }
        j.a(j.this, false);
        AppMethodBeat.o(212848);
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(212851);
        if (j.b(j.this) == null)
        {
          AppMethodBeat.o(212851);
          return false;
        }
        paramAnonymousBoolean = j.b(j.this).overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean, paramAnonymousView);
        AppMethodBeat.o(212851);
        return paramAnonymousBoolean;
      }
    });
    this.aioZ = new h(this.aioX);
    this.aigp = paramWebView;
    this.aioY = new k(this.aioX);
    this.aikO = new s(this);
    this.aioX.setProxyWebViewClientExtension(this.aipa);
    this.aikR = new aq(this.aigp, this);
    paramWebView = this.aioX.getContext();
    Log.i("XWWebView", "initFullscreenVideo, kind:" + getFullscreenVideoKind() + ", activity:" + paramWebView);
    this.aikP = e.a(this.aigp.getWebCoreType(), paramWebView, this.aigp, this.aioX, com.tencent.xweb.extension.video.c.kgA());
    if (getFullscreenVideoKind() == WebView.a.aifF) {
      this.aikP.hm(this.aioX);
    }
    this.mzc = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(212876);
        switch (paramAnonymousMessage.what)
        {
        default: 
          paramAnonymousMessage = new IllegalStateException();
          AppMethodBeat.o(212876);
          throw paramAnonymousMessage;
        }
        paramAnonymousMessage = ((WebView.c)paramAnonymousMessage.obj).getWebView();
        if (paramAnonymousMessage == j.a(j.this))
        {
          paramAnonymousMessage = new IllegalArgumentException("Parent WebView cannot host its own popup window. Please use WebSettings.setSupportMultipleWindows(false)");
          AppMethodBeat.o(212876);
          throw paramAnonymousMessage;
        }
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.copyBackForwardList().getSize() != 0))
        {
          paramAnonymousMessage = new IllegalArgumentException("New WebView for popup window must not have been  previously navigated.");
          AppMethodBeat.o(212876);
          throw paramAnonymousMessage;
        }
        j.a(j.a(j.this), paramAnonymousMessage);
        AppMethodBeat.o(212876);
      }
    };
    AppMethodBeat.o(154358);
  }
  
  static void a(WebView paramWebView1, WebView paramWebView2)
  {
    AppMethodBeat.i(212878);
    paramWebView1 = (XWalkView)paramWebView1.getWebViewUI();
    paramWebView2 = (XWalkView)paramWebView2.getWebViewUI();
    paramWebView1 = paramWebView1.getBridge();
    paramWebView2 = paramWebView2.getBridge();
    try
    {
      Class localClass = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.XWalkViewInternal");
      if (localClass == null)
      {
        AppMethodBeat.o(212878);
        return;
      }
      new ReflectMethod(localClass, "completesWindowCreation", new Class[] { localClass, localClass }).invoke(new Object[] { paramWebView1, paramWebView2 });
      AppMethodBeat.o(212878);
      return;
    }
    finally
    {
      Log.e("XWWebView", "completeWindowCreation reflect failed, error:".concat(String.valueOf(paramWebView1)));
      AppMethodBeat.o(212878);
    }
  }
  
  private void kjj()
  {
    AppMethodBeat.i(212864);
    if (this.aioV != null)
    {
      AppMethodBeat.o(212864);
      return;
    }
    this.aioV = new l(this.aioX)
    {
      private boolean aihJ = false;
      private boolean aikT = false;
      private boolean aikU = false;
      private String aikZ = null;
      private String aila = null;
      
      public final boolean OnGetSampleString(XWalkView paramAnonymousXWalkView, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(212980);
        j.g(j.this).dt(paramAnonymousMap);
        AppMethodBeat.o(212980);
        return true;
      }
      
      public final View getVideoLoadingProgressView()
      {
        AppMethodBeat.i(212890);
        Log.i("XWWebView", "getVideoLoadingProgressView");
        View localView = LayoutInflater.from(j.a(j.this).getContext()).inflate(R.layout.xweb_video_progress, null);
        AppMethodBeat.o(212890);
        return localView;
      }
      
      public final boolean isSearchable()
      {
        AppMethodBeat.i(212904);
        if (j.k(j.this) != null)
        {
          Object localObject = j.k(j.this).onMiscCallBack("supportSmartPickWord", new Bundle());
          if ((localObject instanceof Boolean))
          {
            boolean bool = ((Boolean)localObject).booleanValue();
            AppMethodBeat.o(212904);
            return bool;
          }
        }
        AppMethodBeat.o(212904);
        return false;
      }
      
      public final void onClearCurrentPage()
      {
        AppMethodBeat.i(212971);
        if (j.k(j.this) != null) {
          j.k(j.this).hasDiscardCurrentPage(true);
        }
        AppMethodBeat.o(212971);
      }
      
      public final boolean onConsoleMessage(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, XWalkUIClient.ConsoleMessageType paramAnonymousConsoleMessageType)
      {
        AppMethodBeat.i(212926);
        if ((XWalkUIClient.ConsoleMessageType.ERROR == paramAnonymousConsoleMessageType) && (j.l(j.this) != null) && (paramAnonymousString1.split(":").length == 2))
        {
          j.l(j.this);
          com.tencent.xweb.util.l.kim();
        }
        z localz = j.i(j.this);
        paramAnonymousXWalkView = ConsoleMessage.MessageLevel.DEBUG;
        switch (g.2.aioN[paramAnonymousConsoleMessageType.ordinal()])
        {
        }
        for (;;)
        {
          boolean bool = localz.onConsoleMessage(new ConsoleMessage(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousXWalkView));
          AppMethodBeat.o(212926);
          return bool;
          paramAnonymousXWalkView = ConsoleMessage.MessageLevel.DEBUG;
          continue;
          paramAnonymousXWalkView = ConsoleMessage.MessageLevel.ERROR;
          continue;
          paramAnonymousXWalkView = ConsoleMessage.MessageLevel.LOG;
          continue;
          paramAnonymousXWalkView = ConsoleMessage.MessageLevel.TIP;
          continue;
          paramAnonymousXWalkView = ConsoleMessage.MessageLevel.WARNING;
        }
      }
      
      public final boolean onCreateWindowRequested(XWalkView paramAnonymousXWalkView, XWalkUIClient.InitiateBy paramAnonymousInitiateBy, ValueCallback<XWalkView> paramAnonymousValueCallback)
      {
        AppMethodBeat.i(212935);
        paramAnonymousXWalkView = j.m(j.this);
        paramAnonymousInitiateBy = j.a(j.this);
        Objects.requireNonNull(paramAnonymousInitiateBy);
        paramAnonymousXWalkView.obtainMessage(100, new WebView.c(paramAnonymousInitiateBy));
        if (j.i(j.this) != null)
        {
          j.i(j.this);
          j.a(j.this);
          paramAnonymousXWalkView = XWalkUIClient.InitiateBy.BY_USER_GESTURE;
        }
        for (boolean bool = z.kfD();; bool = false)
        {
          AppMethodBeat.o(212935);
          return bool;
        }
      }
      
      public final void onDidChangeThemeColor(XWalkView paramAnonymousXWalkView, int paramAnonymousInt)
      {
        AppMethodBeat.i(212939);
        j.i(j.this).b(j.a(j.this), paramAnonymousInt);
        AppMethodBeat.o(212939);
      }
      
      public final void onExitFullscreenVideo(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(212887);
        Log.i("XWWebView", "onExitFullscreenVideo");
        j.i(j.this).onExitFullscreenVideo(paramAnonymousBitmap);
        AppMethodBeat.o(212887);
      }
      
      public final void onFullscreenToggled(XWalkView paramAnonymousXWalkView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(212952);
        super.onFullscreenToggled(paramAnonymousXWalkView, paramAnonymousBoolean);
        AppMethodBeat.o(212952);
      }
      
      public final void onGeolocationPermissionsHidePrompt()
      {
        AppMethodBeat.i(212923);
        j.i(j.this).onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(212923);
      }
      
      public final void onGeolocationPermissionsShowPrompt(String paramAnonymousString, XWalkGeolocationPermissionsCallback paramAnonymousXWalkGeolocationPermissionsCallback)
      {
        AppMethodBeat.i(212921);
        j.i(j.this).onGeolocationPermissionsShowPrompt(paramAnonymousString, new g.b(paramAnonymousXWalkGeolocationPermissionsCallback));
        AppMethodBeat.o(212921);
      }
      
      public final boolean onGetTranslateString(XWalkView paramAnonymousXWalkView, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(212975);
        j.g(j.this).ds(paramAnonymousMap);
        AppMethodBeat.o(212975);
        return true;
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(212884);
        Log.i("XWWebView", "onHideCustomView");
        if (this.aihJ)
        {
          this.aihJ = false;
          Log.i("XWWebView", "onHideCustomView, mIsMediaPlaybackRequiresUserGesture:" + this.aikT + ", mIsVideoPlaybackRequiresUserGesture:" + this.aikU);
          j.c(j.this).getSettings().setMediaPlaybackRequiresUserGesture(this.aikT);
          j.c(j.this).getSettings().setVideoPlaybackRequiresUserGesture(this.aikU);
        }
        if (j.i(j.this).cxL())
        {
          Log.i("XWWebView", "onHideCustomView, isHandled:true");
          AppMethodBeat.o(212884);
          return;
        }
        j.j(j.this).setVisibility(0);
        if (j.f(j.this) != null) {
          j.f(j.this).onHideCustomView();
        }
        AppMethodBeat.o(212884);
      }
      
      public final void onIconAvailable(XWalkView paramAnonymousXWalkView, String paramAnonymousString, Message paramAnonymousMessage)
      {
        AppMethodBeat.i(212937);
        super.onIconAvailable(paramAnonymousXWalkView, paramAnonymousString, paramAnonymousMessage);
        AppMethodBeat.o(212937);
      }
      
      public final void onJavascriptCloseWindow(XWalkView paramAnonymousXWalkView)
      {
        AppMethodBeat.i(212946);
        j.i(j.this);
        j.a(j.this);
        AppMethodBeat.o(212946);
      }
      
      public final boolean onJavascriptModalDialog(XWalkView paramAnonymousXWalkView, XWalkUIClient.JavascriptMessageType paramAnonymousJavascriptMessageType, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(212950);
        boolean bool = super.onJavascriptModalDialog(paramAnonymousXWalkView, paramAnonymousJavascriptMessageType, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousXWalkJavascriptResult);
        AppMethodBeat.o(212950);
        return bool;
      }
      
      public final boolean onJsAlert(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(212914);
        Log.i("XWWebView", "onJsAlert");
        boolean bool = j.i(j.this).a(j.a(j.this), paramAnonymousString1, paramAnonymousString2, new g.c(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(212914);
        return bool;
      }
      
      public final boolean onJsConfirm(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(212917);
        Log.i("XWWebView", "onJsConfirm");
        boolean bool = j.i(j.this).b(j.a(j.this), paramAnonymousString1, paramAnonymousString2, new g.c(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(212917);
        return bool;
      }
      
      public final boolean onJsPrompt(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(212920);
        Log.i("XWWebView", "onJsPrompt");
        boolean bool = j.i(j.this).a(j.a(j.this), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, new g.e(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(212920);
        return bool;
      }
      
      public final void onPageCommitVisible(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(212868);
        j.d(j.this).e(j.a(j.this), paramAnonymousString);
        AppMethodBeat.o(212868);
      }
      
      public final void onPageLoadStarted(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(212862);
        Log.i("XWWebView", "onPageLoadStarted, url:".concat(String.valueOf(paramAnonymousString)));
        j.d(j.this).b(j.a(j.this), paramAnonymousString, j.c(j.this).getFavicon());
        i.khf().kgZ();
        this.aila = null;
        if ((this.aikZ != null) && (paramAnonymousString != null) && (!paramAnonymousString.equals(this.aikZ)) && (com.tencent.xweb.util.l.bIg(paramAnonymousString) != com.tencent.xweb.util.l.bIg(this.aikZ)))
        {
          if ((com.tencent.xweb.util.l.bIg(this.aikZ) == 1) && (com.tencent.xweb.util.l.bIg(paramAnonymousString) == 2)) {
            j.a(j.this, 1);
          }
        }
        else
        {
          this.aikZ = paramAnonymousString;
          j.a(j.this, System.currentTimeMillis());
          paramAnonymousXWalkView = paramAnonymousString;
          if (paramAnonymousString == null) {
            paramAnonymousXWalkView = "";
          }
          com.tencent.xweb.util.l.jK(paramAnonymousXWalkView, j.e(j.this));
          if (j.f(j.this) != null)
          {
            paramAnonymousXWalkView = j.f(j.this);
            if (j.a(j.this).getFullscreenVideoKind() != WebView.a.aifF) {
              break label253;
            }
          }
        }
        label253:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.bV(true, bool);
          j.g(j.this).kgy();
          AppMethodBeat.o(212862);
          return;
          if ((com.tencent.xweb.util.l.bIg(this.aikZ) != 2) || (com.tencent.xweb.util.l.bIg(paramAnonymousString) != 1)) {
            break;
          }
          j.a(j.this, 2);
          break;
        }
      }
      
      public final void onPageLoadStopped(XWalkView paramAnonymousXWalkView, String paramAnonymousString, XWalkUIClient.LoadStatus paramAnonymousLoadStatus)
      {
        AppMethodBeat.i(212872);
        if ((this.aila != null) && (this.aila.equals(paramAnonymousString)))
        {
          Log.i("XWWebView", "onPageFinished abandoned, url:" + paramAnonymousString + ", status:" + paramAnonymousLoadStatus);
          AppMethodBeat.o(212872);
          return;
        }
        Log.i("XWWebView", "onPageFinished, url:" + paramAnonymousString + ", status:" + paramAnonymousLoadStatus);
        if (j.f(j.this) != null)
        {
          paramAnonymousXWalkView = j.f(j.this);
          if (j.a(j.this).getFullscreenVideoKind() != WebView.a.aifF) {
            break label227;
          }
        }
        label227:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.bV(false, bool);
          this.aila = paramAnonymousString;
          j.d(j.this).b(j.a(j.this), paramAnonymousString);
          if (paramAnonymousLoadStatus != XWalkUIClient.LoadStatus.FAILED) {
            i.khf().kha();
          }
          com.tencent.xweb.util.l.A(paramAnonymousString, System.currentTimeMillis() - j.h(j.this), j.e(j.this));
          j.a(j.this, System.currentTimeMillis());
          d.a(j.a(j.this));
          AppMethodBeat.o(212872);
          return;
        }
      }
      
      public final void onPermissionRequest(PermissionRequest paramAnonymousPermissionRequest)
      {
        AppMethodBeat.i(212984);
        if (j.i(j.this) != null)
        {
          j.i(j.this).onPermissionRequest(paramAnonymousPermissionRequest);
          AppMethodBeat.o(212984);
          return;
        }
        super.onPermissionRequest(paramAnonymousPermissionRequest);
        AppMethodBeat.o(212984);
      }
      
      public final void onPermissionRequestCanceled(PermissionRequest paramAnonymousPermissionRequest)
      {
        AppMethodBeat.i(212988);
        if (j.i(j.this) != null)
        {
          j.i(j.this).onPermissionRequestCanceled(paramAnonymousPermissionRequest);
          AppMethodBeat.o(212988);
          return;
        }
        super.onPermissionRequestCanceled(paramAnonymousPermissionRequest);
        AppMethodBeat.o(212988);
      }
      
      public final void onReceivedIcon(XWalkView paramAnonymousXWalkView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(212941);
        super.onReceivedIcon(paramAnonymousXWalkView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(212941);
      }
      
      public final void onReceivedTitle(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(212874);
        Log.i("XWWebView", "onReceivedTitle: ".concat(String.valueOf(paramAnonymousString)));
        super.onReceivedTitle(paramAnonymousXWalkView, paramAnonymousString);
        j.i(j.this).d(null, paramAnonymousString);
        if (j.f(j.this) != null)
        {
          paramAnonymousXWalkView = j.f(j.this);
          if (j.a(j.this).getFullscreenVideoKind() != WebView.a.aifF) {
            break label90;
          }
        }
        label90:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.bV(true, bool);
          AppMethodBeat.o(212874);
          return;
        }
      }
      
      public final void onRequestFocus(XWalkView paramAnonymousXWalkView)
      {
        AppMethodBeat.i(212942);
        super.onRequestFocus(paramAnonymousXWalkView);
        AppMethodBeat.o(212942);
      }
      
      public final void onScaleChanged(XWalkView paramAnonymousXWalkView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(212954);
        j.d(j.this).a(j.a(j.this), paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(212954);
      }
      
      public final boolean onSearchWord(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(212911);
        if (isSearchable())
        {
          paramAnonymousXWalkView = new Bundle();
          paramAnonymousXWalkView.putString("query", paramAnonymousString1);
          if (j.k(j.this) != null) {
            j.k(j.this).onMiscCallBack("jumpToSos", paramAnonymousXWalkView);
          }
          boolean bool = j.i(j.this).e(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, j.c(j.this).getUrl(), j.c(j.this).getRefererUrl(), j.c(j.this).getTitle());
          AppMethodBeat.o(212911);
          return bool;
        }
        AppMethodBeat.o(212911);
        return false;
      }
      
      public final boolean onSelectInfoChanged(XWalkView paramAnonymousXWalkView, long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(212895);
        if (!isSearchable())
        {
          AppMethodBeat.o(212895);
          return false;
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("PickedWord", paramAnonymousString1);
        ((Bundle)localObject).putString("PrefixText", paramAnonymousString2);
        ((Bundle)localObject).putString("SuffixText", paramAnonymousString3);
        localObject = j.k(j.this).onMiscCallBack("smartPickWord", (Bundle)localObject);
        if ((localObject instanceof Bundle))
        {
          localObject = (Bundle)localObject;
          if ((localObject != null) && (((Bundle)localObject).getString("PickedWord") != null))
          {
            int i = ((Bundle)localObject).getInt("PrefixOffset");
            int j = ((Bundle)localObject).getInt("SuffixOffset");
            j.b localb = j.b.c(paramAnonymousString1, ((Bundle)localObject).getString("PickedWord"), i, j, paramAnonymousString2, paramAnonymousString3);
            Log.d("XWWebView", "onSelectInfoChanged " + localb.toString());
            paramAnonymousXWalkView.adjustSelectPosition(paramAnonymousLong, ((Bundle)localObject).getString("PickedWord"), -localb.aiph, localb.aipj);
          }
          boolean bool = j.i(j.this).b(paramAnonymousLong, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
          AppMethodBeat.o(212895);
          return bool;
        }
        AppMethodBeat.o(212895);
        return false;
      }
      
      public final void onShowCustomView(View paramAnonymousView, int paramAnonymousInt, CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(212965);
        super.onShowCustomView(paramAnonymousView, paramAnonymousInt, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(212965);
      }
      
      public final void onShowCustomView(View paramAnonymousView, CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(212880);
        Log.i("XWWebView", "onShowCustomView, view:".concat(String.valueOf(paramAnonymousView)));
        if (!this.aihJ)
        {
          this.aihJ = true;
          this.aikT = j.c(j.this).getSettings().getMediaPlaybackRequiresUserGesture();
          this.aikU = j.c(j.this).getSettings().getVideoPlaybackRequiresUserGesture();
          Log.i("XWWebView", "onShowCustomView, mIsMediaPlaybackRequiresUserGesture:" + this.aikT + ", mIsVideoPlaybackRequiresUserGesture:" + this.aikU);
          j.c(j.this).getSettings().setMediaPlaybackRequiresUserGesture(false);
          j.c(j.this).getSettings().setVideoPlaybackRequiresUserGesture(false);
        }
        boolean bool = j.i(j.this).a(paramAnonymousView, new g.a(paramAnonymousCustomViewCallback));
        com.tencent.xweb.util.l.khS();
        if (bool)
        {
          Log.i("XWWebView", "onShowCustomView, isHandled:true");
          AppMethodBeat.o(212880);
          return;
        }
        j.j(j.this).setVisibility(4);
        if (j.f(j.this) != null)
        {
          com.tencent.xweb.util.l.a(WebView.WebViewKind.aifI, j.f(j.this) instanceof com.tencent.xweb.extension.video.d, j.this.getUrl());
          j.f(j.this).onShowCustomView(paramAnonymousView, new g.a(paramAnonymousCustomViewCallback));
        }
        AppMethodBeat.o(212880);
      }
      
      public final boolean onShowFileChooser(XWalkView paramAnonymousXWalkView, ValueCallback<Uri[]> paramAnonymousValueCallback, WebChromeClient.FileChooserParams paramAnonymousFileChooserParams)
      {
        AppMethodBeat.i(212931);
        boolean bool = j.i(j.this).a(j.a(j.this), paramAnonymousValueCallback, new c.c(paramAnonymousFileChooserParams));
        AppMethodBeat.o(212931);
        return bool;
      }
      
      public final void onShowSos()
      {
        AppMethodBeat.i(212900);
        if (j.k(j.this) != null) {
          j.k(j.this).onMiscCallBack("onShowSos", new Bundle());
        }
        AppMethodBeat.o(212900);
      }
      
      public final void onUnhandledKeyEvent(XWalkView paramAnonymousXWalkView, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(212962);
        super.onUnhandledKeyEvent(paramAnonymousXWalkView, paramAnonymousKeyEvent);
        AppMethodBeat.o(212962);
      }
      
      public final void openFileChooser(XWalkView paramAnonymousXWalkView, ValueCallback<Uri> paramAnonymousValueCallback, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(212929);
        Log.i("XWWebView", "openFileChooser with three param");
        j.i(j.this).openFileChooser(paramAnonymousValueCallback, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(212929);
      }
      
      public final boolean shouldDiscardCurrentPage()
      {
        AppMethodBeat.i(212966);
        if (j.k(j.this) != null)
        {
          bool = j.k(j.this).shouldDiscardCurrentPage();
          AppMethodBeat.o(212966);
          return bool;
        }
        boolean bool = super.shouldDiscardCurrentPage();
        AppMethodBeat.o(212966);
        return bool;
      }
      
      public final boolean shouldOverrideKeyEvent(XWalkView paramAnonymousXWalkView, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(212960);
        boolean bool = super.shouldOverrideKeyEvent(paramAnonymousXWalkView, paramAnonymousKeyEvent);
        AppMethodBeat.o(212960);
        return bool;
      }
    };
    this.aioZ.aioV = this.aioV;
    this.aioX.setUIClient(this.aioV);
    this.aioW = new n(this.aioX)
    {
      private int aipc = 0;
      
      public final void doUpdateVisitedHistory(XWalkView paramAnonymousXWalkView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(212913);
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("data:text/html;charset=utf-8")))
        {
          Log.w("XWWebView", "doUpdateVisitedHistory, ignore");
          AppMethodBeat.o(212913);
          return;
        }
        j.d(j.this).b(j.a(j.this), paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(212913);
      }
      
      public final void onDocumentLoadedInFrame(XWalkView paramAnonymousXWalkView, long paramAnonymousLong)
      {
        AppMethodBeat.i(212894);
        super.onDocumentLoadedInFrame(paramAnonymousXWalkView, paramAnonymousLong);
        AppMethodBeat.o(212894);
      }
      
      public final void onLoadFinished(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(212898);
        super.onLoadFinished(paramAnonymousXWalkView, paramAnonymousString);
        AppMethodBeat.o(212898);
      }
      
      public final void onLoadStarted(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(212873);
        j.d(j.this).i(j.a(j.this), paramAnonymousString);
        AppMethodBeat.o(212873);
      }
      
      public final void onProgressChanged(XWalkView paramAnonymousXWalkView, int paramAnonymousInt)
      {
        AppMethodBeat.i(212891);
        if ((Math.abs(paramAnonymousInt - this.aipc) > 5) || (paramAnonymousInt == 100))
        {
          this.aipc = paramAnonymousInt;
          Log.i("XWWebView", "onProgressChanged, progress = ".concat(String.valueOf(paramAnonymousInt)));
        }
        j.i(j.this).a(j.a(j.this), paramAnonymousInt);
        AppMethodBeat.o(212891);
      }
      
      public final void onReceivedClientCertRequest(XWalkView paramAnonymousXWalkView, ClientCertRequest paramAnonymousClientCertRequest)
      {
        AppMethodBeat.i(212901);
        super.onReceivedClientCertRequest(paramAnonymousXWalkView, paramAnonymousClientCertRequest);
        AppMethodBeat.o(212901);
      }
      
      public final void onReceivedHttpAuthRequest(XWalkView paramAnonymousXWalkView, XWalkHttpAuthHandler paramAnonymousXWalkHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(212916);
        Log.i("XWWebView", "onReceivedHttpAuthRequest host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (j.d(j.this) != null)
        {
          j.d(j.this).a(j.a(j.this), new g.j(paramAnonymousXWalkHttpAuthHandler), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(212916);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousXWalkView, paramAnonymousXWalkHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(212916);
      }
      
      public final void onReceivedHttpError(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest, XWalkWebResourceResponse paramAnonymousXWalkWebResourceResponse)
      {
        AppMethodBeat.i(212857);
        Log.i("XWWebView", "onReceivedHttpError code:" + paramAnonymousXWalkWebResourceResponse.getStatusCode());
        j.d(j.this).a(j.a(j.this), new g.i(paramAnonymousXWalkWebResourceRequest), g.a(paramAnonymousXWalkWebResourceResponse));
        if (paramAnonymousXWalkWebResourceRequest.isForMainFrame()) {
          if (paramAnonymousXWalkWebResourceRequest.getUrl() == null) {
            break label117;
          }
        }
        label117:
        for (paramAnonymousXWalkWebResourceRequest = paramAnonymousXWalkWebResourceRequest.getUrl().toString();; paramAnonymousXWalkWebResourceRequest = "")
        {
          if (j.n(j.this) != null) {
            j.n(j.this).onPageLoadStopped(paramAnonymousXWalkView, paramAnonymousXWalkWebResourceRequest, XWalkUIClient.LoadStatus.FAILED);
          }
          AppMethodBeat.o(212857);
          return;
        }
      }
      
      public final void onReceivedLoadError(XWalkView paramAnonymousXWalkView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(212883);
        Log.i("XWWebView", "onReceivedError ".concat(String.valueOf(paramAnonymousString2)));
        super.onReceivedLoadError(paramAnonymousXWalkView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        j.o(j.this);
        j.d(j.this).a(j.a(j.this), paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        i.khf().khg();
        com.tencent.xweb.util.l.d(paramAnonymousString2, paramAnonymousInt, System.currentTimeMillis() - j.h(j.this), j.e(j.this));
        if (j.d(j.this).b(j.a(j.this), paramAnonymousInt, paramAnonymousString1, paramAnonymousString2))
        {
          AppMethodBeat.o(212883);
          return;
        }
        paramAnonymousXWalkView = com.tencent.xweb.util.f.bHY(paramAnonymousString2);
        j.c(j.this).loadDataWithBaseURL("file:///android_asset/", paramAnonymousXWalkView, "text/html", "utf-8", null);
        AppMethodBeat.o(212883);
      }
      
      public final void onReceivedLoadError2(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest, XWalkWebResourceError paramAnonymousXWalkWebResourceError)
      {
        AppMethodBeat.i(212861);
        ag localag = j.d(j.this);
        WebView localWebView = j.a(j.this);
        paramAnonymousXWalkWebResourceRequest = new g.i(paramAnonymousXWalkWebResourceRequest);
        if (paramAnonymousXWalkWebResourceError == null) {}
        for (paramAnonymousXWalkView = null;; paramAnonymousXWalkView = new g.1(paramAnonymousXWalkWebResourceError))
        {
          localag.a(localWebView, paramAnonymousXWalkWebResourceRequest, paramAnonymousXWalkView);
          AppMethodBeat.o(212861);
          return;
        }
      }
      
      public final void onReceivedResponseHeaders(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest, XWalkWebResourceResponse paramAnonymousXWalkWebResourceResponse)
      {
        AppMethodBeat.i(212909);
        if (paramAnonymousXWalkWebResourceResponse.getStatusCode() == 302)
        {
          str2 = (String)paramAnonymousXWalkWebResourceResponse.getResponseHeaders().get("location");
          if (str2 != null)
          {
            str1 = str2;
            if (!str2.isEmpty()) {}
          }
          else
          {
            str1 = (String)paramAnonymousXWalkWebResourceResponse.getResponseHeaders().get("Location");
          }
          if ((str1 != null) && (str1.trim().startsWith("weixin://")))
          {
            j.d(j.this).b(j.a(j.this), str1, null);
            j.c(j.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(212774);
                j.d(j.this).b(j.a(j.this), str1, null);
                AppMethodBeat.o(212774);
              }
            }, 300L);
          }
        }
        while ((paramAnonymousXWalkWebResourceResponse.getStatusCode() < 400) || (j.this.supportFeature(3)))
        {
          String str2;
          super.onReceivedResponseHeaders(paramAnonymousXWalkView, paramAnonymousXWalkWebResourceRequest, paramAnonymousXWalkWebResourceResponse);
          AppMethodBeat.o(212909);
          return;
        }
        Log.i("XWWebView", "onReceivedHttpError code:" + paramAnonymousXWalkWebResourceResponse.getStatusCode());
        j.d(j.this).a(j.a(j.this), new g.i(paramAnonymousXWalkWebResourceRequest), g.a(paramAnonymousXWalkWebResourceResponse));
        if (paramAnonymousXWalkWebResourceRequest.getUrl() != null) {}
        for (final String str1 = paramAnonymousXWalkWebResourceRequest.getUrl().toString();; str1 = "")
        {
          j.d(j.this).a(j.a(j.this), paramAnonymousXWalkWebResourceResponse.getStatusCode(), "", str1);
          break;
        }
      }
      
      public final void onReceivedSslError(XWalkView paramAnonymousXWalkView, ValueCallback<Boolean> paramAnonymousValueCallback, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(212888);
        Log.i("XWWebView", "onReceivedSslError " + paramAnonymousSslError.getPrimaryError());
        j.d(j.this).a(j.a(j.this), new g.h(paramAnonymousValueCallback), paramAnonymousSslError);
        AppMethodBeat.o(212888);
      }
      
      public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest)
      {
        AppMethodBeat.i(212877);
        g.i locali = new g.i(paramAnonymousXWalkWebResourceRequest);
        if (locali.aikC == null)
        {
          paramAnonymousXWalkView = null;
          if (paramAnonymousXWalkView == null) {
            break label174;
          }
        }
        label174:
        for (paramAnonymousXWalkView = j.d(j.this).a(j.a(j.this), locali, paramAnonymousXWalkView);; paramAnonymousXWalkView = null)
        {
          Object localObject = paramAnonymousXWalkView;
          if (paramAnonymousXWalkView == null) {
            localObject = j.d(j.this).a(j.a(j.this), locali);
          }
          if (localObject == null) {}
          for (paramAnonymousXWalkView = j.d(j.this).c(j.a(j.this), paramAnonymousXWalkWebResourceRequest.getUrl().toString());; paramAnonymousXWalkView = (XWalkView)localObject)
          {
            if (paramAnonymousXWalkView != null)
            {
              paramAnonymousXWalkView = createXWalkWebResourceResponse(paramAnonymousXWalkView.mMimeType, paramAnonymousXWalkView.mEncoding, paramAnonymousXWalkView.mInputStream, paramAnonymousXWalkView.mStatusCode, paramAnonymousXWalkView.mReasonPhrase, paramAnonymousXWalkView.mResponseHeaders);
              AppMethodBeat.o(212877);
              return paramAnonymousXWalkView;
              paramAnonymousXWalkView = locali.aikC.getBundle();
              break;
            }
            AppMethodBeat.o(212877);
            return null;
          }
        }
      }
      
      public final boolean shouldOverrideUrlLoading(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(212867);
        if (d.bIm(paramAnonymousString))
        {
          AppMethodBeat.o(212867);
          return true;
        }
        boolean bool = j.d(j.this).a(j.a(j.this), paramAnonymousString);
        Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + bool + " url = " + paramAnonymousString);
        AppMethodBeat.o(212867);
        return bool;
      }
      
      public final boolean shouldOverrideUrlLoading(XWalkView paramAnonymousXWalkView, String paramAnonymousString, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3)
      {
        AppMethodBeat.i(212870);
        if (d.bIm(paramAnonymousString))
        {
          AppMethodBeat.o(212870);
          return true;
        }
        paramAnonymousXWalkView = new g.i(paramAnonymousString, "GET", paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean3);
        paramAnonymousBoolean1 = j.d(j.this).e(j.a(j.this), paramAnonymousXWalkView);
        Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + paramAnonymousBoolean1 + " url = " + paramAnonymousString);
        AppMethodBeat.o(212870);
        return paramAnonymousBoolean1;
      }
    };
    this.aioZ.aioW = this.aioW;
    this.aioX.setResourceClient(this.aioW);
    AppMethodBeat.o(212864);
  }
  
  public static boolean pc(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212856);
        com.tencent.xweb.xwalk.updater.g localg = com.tencent.xweb.xwalk.updater.g.a.kkj();
        if (localg.mHasInited)
        {
          Log.w("XWalkInitializerWrapper", "initXWalk, already inited");
          paramContext = com.tencent.xweb.xwalk.updater.g.a.kkj();
          if (paramContext.mHasInited) {
            break label140;
          }
          Log.w("XWalkInitializerWrapper", "isCoreReady, not inited");
          bool = false;
          AppMethodBeat.o(212856);
          return bool;
        }
        localg.mHasInited = true;
        localg.aiqQ = new XWalkInitializer(paramContext, new com.tencent.xweb.xwalk.updater.g.1(localg));
        XWalkEnvironment.init(paramContext);
        Log.i("XWalkInitializerWrapper", "initXWalk, init start");
        if (localg.aiqQ.init())
        {
          Log.i("XWalkInitializerWrapper", "initXWalk, init success");
          continue;
        }
        Log.w("XWalkInitializerWrapper", "initXWalk, init fail");
      }
      finally {}
      continue;
      label140:
      boolean bool = paramContext.aiqQ.isCoreReady();
      AppMethodBeat.o(212856);
    }
  }
  
  public final void A(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(213566);
    if (this.aikN != null) {
      this.aikN.onMiscCallBack(paramString, paramBundle);
    }
    AppMethodBeat.o(213566);
  }
  
  public final void a(View paramView, boolean paramBoolean, com.tencent.xweb.s params)
  {
    AppMethodBeat.i(154410);
    if (XWalkCoreWrapper.getInstance().hasFeature(2)) {
      try
      {
        Class localClass = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.screenshot.LongScreenShotManager");
        if (localClass == null)
        {
          AppMethodBeat.o(154410);
          return;
        }
        new ReflectMethod(localClass, "startLongScreenShot", new Class[] { View.class, Boolean.TYPE, Object.class }).invoke(new Object[] { paramView, Boolean.valueOf(paramBoolean), XWalkCoreWrapper.getInstance().getBridgeObject(new g.d(params)) });
        AppMethodBeat.o(154410);
        return;
      }
      finally
      {
        Log.e("XWWebView", "startLongScreenShot reflect failed");
      }
    }
    AppMethodBeat.o(154410);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(154382);
    this.aioX.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(154382);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(154364);
    if (this.aikK)
    {
      AppMethodBeat.o(154364);
      return false;
    }
    XWalkNavigationHistory localXWalkNavigationHistory = this.aioX.getNavigationHistory();
    if (localXWalkNavigationHistory == null)
    {
      AppMethodBeat.o(154364);
      return false;
    }
    boolean bool = localXWalkNavigationHistory.canGoBack();
    AppMethodBeat.o(154364);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(154405);
    if (this.aioX.getNavigationHistory() != null)
    {
      boolean bool = this.aioX.getNavigationHistory().canGoForward();
      AppMethodBeat.o(154405);
      return bool;
    }
    AppMethodBeat.o(154405);
    return false;
  }
  
  public final Bitmap captureBitmap()
  {
    AppMethodBeat.i(213325);
    Object localObject = ((ViewGroup)((ViewGroup)this.aioX.getChildAt(0)).getChildAt(0)).getChildAt(0);
    if ((localObject instanceof TextureView))
    {
      localObject = ((TextureView)localObject).getBitmap();
      Log.i("XWWebView", "captureBitmap, bitmap:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(213325);
      return localObject;
    }
    AppMethodBeat.o(213325);
    return null;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(154402);
    final View localView = ((ViewGroup)((ViewGroup)this.aioX.getChildAt(0)).getChildAt(0)).getChildAt(0);
    if ((localView instanceof TextureView)) {
      com.tencent.threadpool.k.c.bq(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(154351);
          Log.i("XWWebView", "captureBitmap, onFinishGetBitmap:".concat(String.valueOf(((TextureView)localView).getBitmap())));
          AppMethodBeat.o(154351);
        }
      });
    }
    AppMethodBeat.o(154402);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(154404);
    if (this.aioX.getNavigationHistory() != null) {
      this.aioX.getNavigationHistory().clear();
    }
    AppMethodBeat.o(154404);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(154388);
    this.aioX.clearMatches();
    AppMethodBeat.o(154388);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(154373);
    this.aioX.clearSslPreferences();
    AppMethodBeat.o(154373);
  }
  
  public final void clearView() {}
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(213506);
    p localp = new p(this.aioX.getNavigationHistory());
    AppMethodBeat.o(213506);
    return localp;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(154368);
    this.aioX.onDestroy();
    AppMethodBeat.o(154368);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(154369);
    if (this.aikP != null) {
      this.aikP.OV(paramBoolean);
    }
    AppMethodBeat.o(154369);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(154371);
    this.aioX.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(154371);
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(154390);
    this.aioX.findAllAsync(paramString);
    AppMethodBeat.o(154390);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(154389);
    this.aioX.findNext(paramBoolean);
    AppMethodBeat.o(154389);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(154392);
    String str = "xwalk, sdk ver = " + ao.kge() + "\n apk ver = " + XWalkEnvironment.getAvailableVersion() + "\n detail = " + XWalkEnvironment.getAvailableVersionDetail();
    AppMethodBeat.o(154392);
    return str;
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(154375);
    int i = this.aioX.getContentHeight();
    AppMethodBeat.o(154375);
    return i;
  }
  
  public final z getCurWebChromeClient()
  {
    return this.tyW;
  }
  
  public final ag getCurWebviewClient()
  {
    return this.tyV;
  }
  
  public final com.tencent.xweb.internal.f getDefalutOpProvider()
  {
    return this.aioZ;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(154400);
    WebView.a locala = com.tencent.xweb.a.keX().bHi(WebView.getCurStrModule());
    AppMethodBeat.o(154400);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(154386);
    WebView.b localb = new WebView.b();
    XWalkHitTestResult localXWalkHitTestResult = this.aioX.getHitTestResult();
    localb.mType = localXWalkHitTestResult.getType().ordinal();
    localb.mExtra = localXWalkHitTestResult.getExtra();
    AppMethodBeat.o(154386);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213528);
    paramString1 = ah.kfZ().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(213528);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, final com.tencent.xweb.k paramk)
  {
    AppMethodBeat.i(154413);
    boolean bool = this.aioX.getImageBitmapToFile(paramString1, paramString2, paramString3, new XWalkGetImageBitmapToFileFinishedCallback()
    {
      public final void onFinishImageBitmapToFile(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString3)
      {
        AppMethodBeat.i(154352);
        paramk.dK(paramAnonymousInt1, paramAnonymousString2);
        AppMethodBeat.o(154352);
      }
    });
    AppMethodBeat.o(154413);
    return bool;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(154376);
    float f = this.aioX.getScale();
    AppMethodBeat.o(154376);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(154418);
    int i = this.aioX.computeVerticalScrollRange();
    AppMethodBeat.o(154418);
    return i;
  }
  
  public final ad getSettings()
  {
    return this.aioY;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(154387);
    String str = this.aioX.getTitle();
    AppMethodBeat.o(154387);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.aikG;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(154383);
    String str = this.aioX.getUrl();
    AppMethodBeat.o(154383);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(154391);
    String str = "xwalk, sdkver = " + ao.kge() + ", apkver = " + this.mApkVersion + ", detail = " + XWalkEnvironment.getAvailableVersionDetail();
    AppMethodBeat.o(154391);
    return str;
  }
  
  public final View getView()
  {
    return this.aioX;
  }
  
  public final int getVisibleTitleHeight()
  {
    return 0;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(154395);
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView))
    {
      i = ((XWalkView)localView).computeHorizontalScrollOffset();
      AppMethodBeat.o(154395);
      return i;
    }
    int i = localView.getScrollX();
    AppMethodBeat.o(154395);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(154394);
    int i = this.aioX.computeVerticalScrollOffset();
    AppMethodBeat.o(154394);
    return i;
  }
  
  public final af getWebViewCallbackClient()
  {
    return this.sLl;
  }
  
  public final View getWebViewUI()
  {
    return this.aioX;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(154365);
    if (this.aioX.getNavigationHistory() == null)
    {
      AppMethodBeat.o(154365);
      return;
    }
    if (this.aioX.getNavigationHistory().canGoBack())
    {
      this.aioX.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
      if ((this.aioX.getNavigationHistory() != null) && (this.aioX.getNavigationHistory().getCurrentItem() != null)) {
        this.tyW.d(this.aigp, this.aioX.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
    AppMethodBeat.o(154365);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(154406);
    if (this.aioX.getNavigationHistory().canGoForward())
    {
      this.aioX.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.FORWARD, 1);
      if ((this.aioX.getNavigationHistory() != null) && (this.aioX.getNavigationHistory().getCurrentItem() != null)) {
        this.tyW.d(this.aigp, this.aioX.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
    AppMethodBeat.o(154406);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(154366);
    boolean bool = this.aioX.hasEnteredFullscreen();
    AppMethodBeat.o(154366);
    return bool;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(154411);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.d("XWWebView", "invokeMiscMethod, method string is null or empty");
      AppMethodBeat.o(154411);
      return null;
    }
    Log.d("XWWebView", "invokeMiscMethod, method:".concat(String.valueOf(paramString)));
    if (paramString.equals("supportTranslateWebSite"))
    {
      bool1 = XWalkCoreWrapper.getInstance().isSupportTranslateWebSite();
      paramString = new Bundle();
      paramString.putBoolean("result", bool1);
      Log.i("XWWebView", "translate: xweb is supportTranslateWebSite = ".concat(String.valueOf(bool1)));
      AppMethodBeat.o(154411);
      return paramString;
    }
    if (paramString.equals("getTranslateSampleString"))
    {
      Log.i("XWWebView", "translate: xweb is detectTranslateWebSiteIsNeeded, getTranslateSampleString");
      this.aioX.getTranslateSampleString(0);
      AppMethodBeat.o(154411);
      return null;
    }
    if (paramString.equals("translateWebSite"))
    {
      Log.i("XWWebView", "translate: do translateWebSite");
      paramBundle.getString("url");
      this.aikR.aign = true;
      AppMethodBeat.o(154411);
      return null;
    }
    if (paramString.equals("replaceTranslatedString"))
    {
      this.aikR.ci(paramBundle);
      AppMethodBeat.o(154411);
      return null;
    }
    if (paramString.equals("getJavaScriptAccessClipboardBlocked"))
    {
      paramString = new Bundle(1);
      if (this.aioX != null) {
        if (!this.aioX.getSettings().getJavaScriptCanAccessClipboard())
        {
          bool1 = bool2;
          paramString.putBoolean("blocked", bool1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(154411);
        return paramString;
        bool1 = false;
        break;
        paramString.putBoolean("blocked", false);
      }
    }
    if (paramString.equals("setJavaScriptAccessClipboardBlocked"))
    {
      if ((this.aioX != null) && (paramBundle != null))
      {
        bool2 = paramBundle.getBoolean("blocked", false);
        paramString = this.aioX.getSettings();
        if (bool2) {
          break label350;
        }
      }
      for (;;)
      {
        paramString.setJavaScriptCanAccessClipboard(bool1);
        paramString = new Bundle();
        AppMethodBeat.o(154411);
        return paramString;
        label350:
        bool1 = false;
      }
    }
    AppMethodBeat.o(154411);
    return null;
  }
  
  public final void irA()
  {
    AppMethodBeat.i(154412);
    if (this.aikN != null) {
      this.aikN.onMiscCallBack("onTranslateFinish", new Bundle());
    }
    AppMethodBeat.o(154412);
  }
  
  public final boolean isOverScrollStart()
  {
    AppMethodBeat.i(154396);
    boolean bool = this.aikL;
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView)) {}
    for (int i = ((XWalkView)localView).computeVerticalScrollOffset(); (i == 0) && (bool); i = localView.getScrollY())
    {
      AppMethodBeat.o(154396);
      return true;
    }
    AppMethodBeat.o(154396);
    return false;
  }
  
  public final void kgz()
  {
    AppMethodBeat.i(213542);
    if (this.aikN != null) {
      this.aikN.onMiscCallBack("onTranslateStart", new Bundle());
    }
    this.aioX.setTranslateMode(true);
    AppMethodBeat.o(213542);
  }
  
  public final Object kjk()
  {
    AppMethodBeat.i(213118);
    if (this.aioX == null)
    {
      Log.e("XWWebView", "getXWalkBridge, mWebview is null");
      AppMethodBeat.o(213118);
      return null;
    }
    Object localObject = this.aioX.getBridge();
    AppMethodBeat.o(213118);
    return localObject;
  }
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(154367);
    this.aioX.leaveFullscreen();
    AppMethodBeat.o(154367);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(154374);
    this.aioX.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(154374);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(154378);
    this.aioX.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(154378);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(154363);
    if ((paramString != null) && (paramString.trim().startsWith("javascript:")))
    {
      this.aioX.evaluateJavascript(paramString, null);
      AppMethodBeat.o(154363);
      return;
    }
    this.aikK = false;
    this.aioX.loadUrl(paramString);
    AppMethodBeat.o(154363);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(154381);
    this.aioX.loadUrl(paramString, paramMap);
    AppMethodBeat.o(154381);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(154417);
    this.aioX.onHide();
    AppMethodBeat.o(154417);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(154399);
    this.aioX.onPause();
    AppMethodBeat.o(154399);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(154398);
    this.aioX.onResume();
    AppMethodBeat.o(154398);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(154416);
    this.aioX.onShow();
    AppMethodBeat.o(154416);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(154377);
    int i = this.aioX.getScrollBarStyle();
    if ((i == 0) || (i == 33554432))
    {
      AppMethodBeat.o(154377);
      return true;
    }
    AppMethodBeat.o(154377);
    return false;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(154372);
    this.aioX.reload(0);
    AppMethodBeat.o(154372);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(154384);
    this.aioX.removeJavascriptInterface(paramString);
    AppMethodBeat.o(154384);
  }
  
  public final void replaceTranslatedString(Map<String, String> paramMap)
  {
    AppMethodBeat.i(213577);
    this.aioX.replaceTranslatedString(paramMap);
    AppMethodBeat.o(213577);
  }
  
  public final boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(154401);
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView))
    {
      boolean bool = ((XWalkView)localView).savePage(paramString1, paramString2, paramInt);
      AppMethodBeat.o(154401);
      return bool;
    }
    AppMethodBeat.o(154401);
    return false;
  }
  
  public final void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(154415);
    this.aioX.setBottomHeight(paramInt);
    AppMethodBeat.o(154415);
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(154361);
    this.aioX.setDownloadListener(new g.f(this.aigp.getContext(), paramDownloadListener));
    AppMethodBeat.o(154361);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(154362);
    this.aioX.setFindListener(new g.g(paramFindListener));
    AppMethodBeat.o(154362);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154409);
    this.aioX.setHorizontalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(154409);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(213517);
    ah.kfZ().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(213517);
  }
  
  public final void setJSExceptionListener(ai paramai)
  {
    this.aikQ = paramai;
  }
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154408);
    this.aioX.setVerticalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(154408);
  }
  
  public final w setVideoJsCallback(x paramx)
  {
    AppMethodBeat.i(154370);
    if ((this.aikP != null) && (this.aikP.hn(paramx)))
    {
      paramx = new w()
      {
        public final void Z(double paramAnonymousDouble)
        {
          AppMethodBeat.i(154349);
          if (j.f(j.this) != null) {
            j.f(j.this).Z(paramAnonymousDouble);
          }
          AppMethodBeat.o(154349);
        }
        
        public final void hSS()
        {
          AppMethodBeat.i(154348);
          if (j.f(j.this) != null) {
            j.f(j.this).hSS();
          }
          AppMethodBeat.o(154348);
        }
        
        public final void kfv()
        {
          AppMethodBeat.i(154347);
          if (j.f(j.this) != null) {
            j.f(j.this).kfv();
          }
          AppMethodBeat.o(154347);
        }
        
        public final boolean kfw()
        {
          AppMethodBeat.i(212897);
          if (j.f(j.this) != null)
          {
            boolean bool = j.f(j.this).kfw();
            AppMethodBeat.o(212897);
            return bool;
          }
          AppMethodBeat.o(212897);
          return false;
        }
      };
      AppMethodBeat.o(154370);
      return paramx;
    }
    Log.i("XWWebView", "setVideoJsCallback not support");
    AppMethodBeat.o(154370);
    return null;
  }
  
  public final void setWebChromeClient(z paramz)
  {
    AppMethodBeat.i(154360);
    if (paramz == null)
    {
      this.tyW = new z();
      AppMethodBeat.o(154360);
      return;
    }
    kjj();
    this.tyW = paramz;
    AppMethodBeat.o(154360);
  }
  
  public final void setWebContentsSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213605);
    this.aioX.setWebContentsSize(paramInt1, paramInt2);
    AppMethodBeat.o(213605);
  }
  
  public final void setWebViewCallbackClient(af paramaf)
  {
    this.sLl = paramaf;
  }
  
  public final void setWebViewClient(ag paramag)
  {
    AppMethodBeat.i(154359);
    if (paramag == null)
    {
      this.tyV = new ag();
      this.tyV.a(this.aioZ);
      AppMethodBeat.o(154359);
      return;
    }
    kjj();
    this.tyV = paramag;
    AppMethodBeat.o(154359);
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(154397);
    this.aikN = parama;
    this.aioX.setProxyWebViewClientExtension(this.aipa);
    AppMethodBeat.o(154397);
  }
  
  public final void setXWebKeyEventHandler(al paramal)
  {
    AppMethodBeat.i(213593);
    XWalkCoreWrapper.invokeRuntimeChannel(80015, new Object[] { kjk(), paramal });
    AppMethodBeat.o(213593);
  }
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(154403);
    this.aioX.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(154403);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(154385);
    this.aioX.stopLoading();
    AppMethodBeat.o(154385);
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
    AppMethodBeat.i(154407);
    boolean bool = XWalkCoreWrapper.getInstance().hasFeature(paramInt);
    AppMethodBeat.o(154407);
    return bool;
  }
  
  public final boolean supportSetWebContentsSize()
  {
    AppMethodBeat.i(213617);
    boolean bool = supportFeature(1042);
    AppMethodBeat.o(213617);
    return bool;
  }
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(154380);
    boolean bool = this.aioX.zoomIn();
    AppMethodBeat.o(154380);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(154379);
    boolean bool = this.aioX.zoomOut();
    AppMethodBeat.o(154379);
    return bool;
  }
  
  final class a
    extends XWalkView
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(212780);
      super.invalidate();
      if (j.b(j.this) != null) {
        j.b(j.this);
      }
      AppMethodBeat.o(212780);
    }
    
    public final void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(154353);
      super.onScrollChangedDelegate(paramInt1, paramInt2, paramInt3, paramInt4);
      if (j.a(j.this) != null) {
        j.a(j.this).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(154353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j
 * JD-Core Version:    0.7.0.1
 */