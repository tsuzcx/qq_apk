package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
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
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.i;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.h;
import com.tencent.xweb.sys.c.b;
import com.tencent.xweb.t;
import com.tencent.xweb.u;
import com.tencent.xweb.w;
import com.tencent.xweb.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkGetImageBitmapToFileFinishedCallback;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkHitTestResult.type;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkLogMessageListener;
import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkNavigationItem;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkProxyWebViewClientExtension;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkUIClient.InitiateBy;
import org.xwalk.core.XWalkUIClient.JavascriptMessageType;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkView.OverScrolledListener;
import org.xwalk.core.XWalkView.ScrollChangedListener;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class j
  implements IWebView, com.tencent.xweb.internal.g
{
  static int IUc = 0;
  private final int AKo;
  private final int AKp;
  private final int AKq;
  WebView IRh;
  long IRn;
  private b IRo;
  l ITK;
  n ITL;
  XWalkView ITM;
  k ITS;
  AbsoluteLayout ITT;
  g ITU;
  boolean ITV;
  private String ITW;
  private XWalkProxyWebViewClientExtension ITX;
  private com.tencent.xweb.x5.export.external.extension.proxy.a ITY;
  private ac ITZ;
  private boolean IUa;
  private boolean IUb;
  private boolean IUd;
  aa kwV;
  ab lef;
  w leg;
  int mApkVersion;
  private int type;
  
  public j(WebView paramWebView)
  {
    AppMethodBeat.i(154358);
    this.lef = new ab();
    this.leg = new w();
    this.IRn = 0L;
    this.type = 0;
    this.ITV = false;
    this.ITW = null;
    this.ITX = new XWalkProxyWebViewClientExtension()
    {
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(154296);
        if (j.a(j.this) != null)
        {
          paramAnonymousString = j.a(j.this).onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(154296);
          return paramAnonymousString;
        }
        AppMethodBeat.o(154296);
        return null;
      }
    };
    this.ITY = new com.tencent.xweb.x5.export.external.extension.proxy.a();
    this.ITZ = null;
    this.AKo = 0;
    this.AKp = 1;
    this.AKq = 2;
    this.IUa = false;
    this.IUb = false;
    this.IUd = false;
    this.mApkVersion = XWalkEnvironment.getAvailableVersion();
    XWalkContextWrapper localXWalkContextWrapper = new XWalkContextWrapper(paramWebView.getContext(), this.mApkVersion);
    XWalkLibraryLoader.prepareToInit(localXWalkContextWrapper);
    try
    {
      XWalkPreferences.setValue("xweb-version", String.valueOf(this.mApkVersion));
      XWalkPreferences.setValue("xwebsdk-version", "200502");
      this.ITM = new a(localXWalkContextWrapper);
      this.ITT = new AbsoluteLayout(localXWalkContextWrapper);
      this.ITM.getXWalkContentView().addView(this.ITT);
      this.ITM.setCustomOnScrollChangedListener(new XWalkView.ScrollChangedListener()
      {
        public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(154345);
          j.this.ITT.scrollTo(paramAnonymousInt1, paramAnonymousInt2);
          if (j.this.kwV != null) {
            j.this.kwV.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, j.this.ITM);
          }
          AppMethodBeat.o(154345);
        }
      });
      this.ITM.setCustomOnOverScrolledListener(new XWalkView.OverScrolledListener()
      {
        public final void onOverScrolled(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154346);
          if (paramAnonymousBoolean)
          {
            j.a(j.this, true);
            AppMethodBeat.o(154346);
            return;
          }
          j.a(j.this, false);
          AppMethodBeat.o(154346);
        }
      });
      this.ITU = new g(this.ITM);
      this.IRh = paramWebView;
      this.ITS = new k(this.ITM);
      this.ITM.getSettings().SetLogCallBack(new XWalkLogMessageListener()
      {
        public final void onLogMessage(int paramAnonymousInt1, String paramAnonymousString1, int paramAnonymousInt2, String paramAnonymousString2)
        {
          AppMethodBeat.i(154350);
          Log.i("XWWebView", "[WCWebview] :".concat(String.valueOf(paramAnonymousString2)));
          AppMethodBeat.o(154350);
        }
      });
      paramWebView = this.ITM.getContext();
      Log.i("XWWebView", "initFullscreenVideo:" + getFullscreenVideoKind());
      this.IRo = com.tencent.xweb.extension.video.e.a(paramWebView, this.IRh, this.ITM, com.tencent.xweb.extension.video.d.frv());
      if (getFullscreenVideoKind() == WebView.a.INz) {
        this.IRo.ev(this.ITM);
      }
      AppMethodBeat.o(154358);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWWebView", localException.getMessage());
      }
    }
  }
  
  private void eiS()
  {
    AppMethodBeat.i(154412);
    this.ITY.onMiscCallBack("onTranslateFinish", new Bundle());
    AppMethodBeat.o(154412);
  }
  
  private void fsY()
  {
    AppMethodBeat.i(154357);
    if (this.ITK != null)
    {
      AppMethodBeat.o(154357);
      return;
    }
    this.ITK = new l(this.ITM)
    {
      private boolean IPh = false;
      String IUf = null;
      private boolean IUg = false;
      private boolean IUh = false;
      
      public final boolean OnGetSampleString(XWalkView paramAnonymousXWalkView, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(154329);
        paramAnonymousXWalkView = new Bundle();
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(paramAnonymousMap);
        Log.d("XWWebView", "translate: OnGetSampleString orghashmap size = " + paramAnonymousMap.size() + " resultHashMap size = " + localHashMap.size());
        paramAnonymousXWalkView.putSerializable("sample_hashmap", localHashMap);
        paramAnonymousXWalkView = j.a(j.this).onMiscCallBack("onGetSampleString", paramAnonymousXWalkView);
        if ((paramAnonymousXWalkView instanceof Boolean))
        {
          boolean bool = ((Boolean)paramAnonymousXWalkView).booleanValue();
          AppMethodBeat.o(154329);
          return bool;
        }
        AppMethodBeat.o(154329);
        return false;
      }
      
      public final View getVideoLoadingProgressView()
      {
        AppMethodBeat.i(154304);
        Log.i("XWWebView", "getVideoLoadingProgressView");
        View localView = LayoutInflater.from(j.this.IRh.getContext()).inflate(2131495836, null);
        AppMethodBeat.o(154304);
        return localView;
      }
      
      public final boolean isSearchable()
      {
        AppMethodBeat.i(154307);
        Object localObject = j.a(j.this).onMiscCallBack("supportSmartPickWord", new Bundle());
        if ((localObject instanceof Boolean))
        {
          boolean bool = ((Boolean)localObject).booleanValue();
          AppMethodBeat.o(154307);
          return bool;
        }
        AppMethodBeat.o(154307);
        return false;
      }
      
      public final void onClearCurrentPage()
      {
        AppMethodBeat.i(154327);
        if (j.a(j.this) != null) {
          j.a(j.this).hasDiscardCurrentPage(true);
        }
        AppMethodBeat.o(154327);
      }
      
      public final boolean onConsoleMessage(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, XWalkUIClient.ConsoleMessageType paramAnonymousConsoleMessageType)
      {
        AppMethodBeat.i(154313);
        if ((XWalkUIClient.ConsoleMessageType.ERROR == paramAnonymousConsoleMessageType) && (j.g(j.this) != null) && (paramAnonymousString1.split(":").length == 2))
        {
          j.g(j.this);
          com.tencent.xweb.util.g.fss();
        }
        w localw = j.this.leg;
        paramAnonymousXWalkView = ConsoleMessage.MessageLevel.DEBUG;
        switch (f.1.ITE[paramAnonymousConsoleMessageType.ordinal()])
        {
        }
        for (;;)
        {
          boolean bool = localw.onConsoleMessage(new ConsoleMessage(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousXWalkView));
          AppMethodBeat.o(154313);
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
        AppMethodBeat.i(154315);
        boolean bool = super.onCreateWindowRequested(paramAnonymousXWalkView, paramAnonymousInitiateBy, paramAnonymousValueCallback);
        AppMethodBeat.o(154315);
        return bool;
      }
      
      public final void onDidChangeThemeColor(XWalkView paramAnonymousXWalkView, int paramAnonymousInt)
      {
        AppMethodBeat.i(194692);
        j.this.leg.b(j.this.IRh, paramAnonymousInt);
        AppMethodBeat.o(194692);
      }
      
      public final void onExitFullscreenVideo(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(154303);
        Log.i("XWWebView", "onExitFullscreenVideo");
        j.this.leg.onExitFullscreenVideo(paramAnonymousBitmap);
        AppMethodBeat.o(154303);
      }
      
      public final void onFullscreenToggled(XWalkView paramAnonymousXWalkView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(154321);
        super.onFullscreenToggled(paramAnonymousXWalkView, paramAnonymousBoolean);
        AppMethodBeat.o(154321);
      }
      
      public final void onGeolocationPermissionsHidePrompt()
      {
        AppMethodBeat.i(194690);
        j.this.leg.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(194690);
      }
      
      public final void onGeolocationPermissionsShowPrompt(String paramAnonymousString, XWalkGeolocationPermissionsCallback paramAnonymousXWalkGeolocationPermissionsCallback)
      {
        AppMethodBeat.i(154312);
        j.this.leg.onGeolocationPermissionsShowPrompt(paramAnonymousString, new f.b(paramAnonymousXWalkGeolocationPermissionsCallback));
        AppMethodBeat.o(154312);
      }
      
      public final boolean onGetTranslateString(XWalkView paramAnonymousXWalkView, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(154328);
        paramAnonymousXWalkView = new Bundle();
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(paramAnonymousMap);
        Log.d("XWWebView", "translate: onGetTranslateString orghashmap size = " + paramAnonymousMap.size() + " resultHashMap size = " + localHashMap.size());
        if ((localHashMap.size() == 0) && (j.e(j.this)))
        {
          Log.d("XWWebView", "translate: onTranslateFinish ");
          j.h(j.this);
        }
        paramAnonymousXWalkView.putSerializable("translate_hashmap", localHashMap);
        paramAnonymousXWalkView = j.a(j.this).onMiscCallBack("onGetTranslateString", paramAnonymousXWalkView);
        if ((paramAnonymousXWalkView instanceof Boolean))
        {
          boolean bool = ((Boolean)paramAnonymousXWalkView).booleanValue();
          AppMethodBeat.o(154328);
          return bool;
        }
        AppMethodBeat.o(154328);
        return false;
      }
      
      public final void onHideCustomView()
      {
        AppMethodBeat.i(154302);
        Log.i("XWWebView", "onHideCustomView");
        if (this.IPh)
        {
          this.IPh = false;
          Log.i("XWWebView", "onHideCustomView: mIsMediaPlaybackRequiresUserGesture" + this.IUg + ", mIsVideoPlaybackRequiresUserGesture:" + this.IUh);
          j.this.ITM.getSettings().setMediaPlaybackRequiresUserGesture(this.IUg);
          j.this.ITM.getSettings().setVideoPlaybackRequiresUserGesture(this.IUh);
        }
        if (j.this.leg.beF())
        {
          Log.i("XWWebView", "onHideCustomView isHandled:true");
          AppMethodBeat.o(154302);
          return;
        }
        j.this.ITT.setVisibility(0);
        if (j.d(j.this) != null) {
          j.d(j.this).onHideCustomView();
        }
        AppMethodBeat.o(154302);
      }
      
      public final void onIconAvailable(XWalkView paramAnonymousXWalkView, String paramAnonymousString, Message paramAnonymousMessage)
      {
        AppMethodBeat.i(154316);
        super.onIconAvailable(paramAnonymousXWalkView, paramAnonymousString, paramAnonymousMessage);
        AppMethodBeat.o(154316);
      }
      
      public final void onJavascriptCloseWindow(XWalkView paramAnonymousXWalkView)
      {
        AppMethodBeat.i(154319);
        Object localObject = j.a(j.this).onMiscCallBack("onJavascriptCloseWindow", new Bundle());
        if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
        {
          AppMethodBeat.o(154319);
          return;
        }
        super.onJavascriptCloseWindow(paramAnonymousXWalkView);
        AppMethodBeat.o(154319);
      }
      
      public final boolean onJavascriptModalDialog(XWalkView paramAnonymousXWalkView, XWalkUIClient.JavascriptMessageType paramAnonymousJavascriptMessageType, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(154320);
        boolean bool = super.onJavascriptModalDialog(paramAnonymousXWalkView, paramAnonymousJavascriptMessageType, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousXWalkJavascriptResult);
        AppMethodBeat.o(154320);
        return bool;
      }
      
      public final boolean onJsAlert(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(154309);
        Log.i("XWWebView", "onJsAlert");
        boolean bool = j.this.leg.a(j.this.IRh, paramAnonymousString1, paramAnonymousString2, new f.c(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(154309);
        return bool;
      }
      
      public final boolean onJsConfirm(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(154310);
        Log.i("XWWebView", "onJsConfirm");
        boolean bool = j.this.leg.b(j.this.IRh, paramAnonymousString1, paramAnonymousString2, new f.c(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(154310);
        return bool;
      }
      
      public final boolean onJsPrompt(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(154311);
        Log.i("XWWebView", "onJsPrompt");
        boolean bool = j.this.leg.a(j.this.IRh, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, new f.e(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(154311);
        return bool;
      }
      
      public final void onPageCommitVisible(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(154298);
        j.this.lef.e(j.this.IRh, paramAnonymousString);
        AppMethodBeat.o(154298);
      }
      
      public final void onPageLoadStarted(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(154297);
        Log.i("XWWebView", "onPageLoadStarted: url = ".concat(String.valueOf(paramAnonymousString)));
        j.this.lef.b(j.this.IRh, paramAnonymousString, j.this.ITM.getFavicon());
        h.frN().frI();
        this.IUf = null;
        if ((j.b(j.this) != null) && (paramAnonymousString != null) && (!paramAnonymousString.equals(j.b(j.this))) && (com.tencent.xweb.util.g.aPx(paramAnonymousString) != com.tencent.xweb.util.g.aPx(j.b(j.this))))
        {
          if ((com.tencent.xweb.util.g.aPx(j.b(j.this)) == 1) && (com.tencent.xweb.util.g.aPx(paramAnonymousString) == 2)) {
            j.a(j.this, 1);
          }
        }
        else
        {
          j.a(j.this, paramAnonymousString);
          j.this.IRn = System.currentTimeMillis();
          paramAnonymousXWalkView = paramAnonymousString;
          if (paramAnonymousString == null) {
            paramAnonymousXWalkView = "";
          }
          com.tencent.xweb.util.g.gF(paramAnonymousXWalkView, j.c(j.this));
          c.a(j.this.IRh);
          if (j.d(j.this) != null)
          {
            paramAnonymousXWalkView = j.d(j.this);
            if (j.this.IRh.getFullscreenVideoKind() != WebView.a.INz) {
              break label307;
            }
          }
        }
        label307:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.aP(true, bool);
          if (j.e(j.this))
          {
            Log.d("XWWebView", "onTranslateStart setTranslateMode true ");
            j.f(j.this);
            j.this.ITM.setTranslateMode(true);
          }
          AppMethodBeat.o(154297);
          return;
          if ((com.tencent.xweb.util.g.aPx(j.b(j.this)) != 2) || (com.tencent.xweb.util.g.aPx(paramAnonymousString) != 1)) {
            break;
          }
          j.a(j.this, 2);
          break;
        }
      }
      
      public final void onPageLoadStopped(XWalkView paramAnonymousXWalkView, String paramAnonymousString, XWalkUIClient.LoadStatus paramAnonymousLoadStatus)
      {
        AppMethodBeat.i(154299);
        if ((this.IUf != null) && (this.IUf.equals(paramAnonymousString)))
        {
          Log.i("XWWebView", "abandoned onPageFinished: url = " + paramAnonymousString + " status = " + paramAnonymousLoadStatus);
          AppMethodBeat.o(154299);
          return;
        }
        if (j.d(j.this) != null)
        {
          paramAnonymousXWalkView = j.d(j.this);
          if (j.this.IRh.getFullscreenVideoKind() != WebView.a.INz) {
            break label216;
          }
        }
        label216:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.aP(false, bool);
          this.IUf = paramAnonymousString;
          Log.i("XWWebView", "onPageFinished: url = " + paramAnonymousString + " status = " + paramAnonymousLoadStatus);
          j.this.lef.b(j.this.IRh, paramAnonymousString);
          if (paramAnonymousLoadStatus != XWalkUIClient.LoadStatus.FAILED) {
            h.frN().frJ();
          }
          com.tencent.xweb.util.g.q(paramAnonymousString, System.currentTimeMillis() - j.this.IRn, j.c(j.this));
          j.this.IRn = System.currentTimeMillis();
          AppMethodBeat.o(154299);
          return;
        }
      }
      
      public final void onReceivedIcon(XWalkView paramAnonymousXWalkView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(154317);
        super.onReceivedIcon(paramAnonymousXWalkView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(154317);
      }
      
      public final void onReceivedTitle(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(154300);
        Log.i("XWWebView", "onReceivedTitle: ".concat(String.valueOf(paramAnonymousString)));
        super.onReceivedTitle(paramAnonymousXWalkView, paramAnonymousString);
        j.this.leg.d(null, paramAnonymousString);
        if (j.d(j.this) != null)
        {
          paramAnonymousXWalkView = j.d(j.this);
          if (j.this.IRh.getFullscreenVideoKind() != WebView.a.INz) {
            break label90;
          }
        }
        label90:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.aP(true, bool);
          AppMethodBeat.o(154300);
          return;
        }
      }
      
      public final void onRequestFocus(XWalkView paramAnonymousXWalkView)
      {
        AppMethodBeat.i(154318);
        super.onRequestFocus(paramAnonymousXWalkView);
        AppMethodBeat.o(154318);
      }
      
      public final void onScaleChanged(XWalkView paramAnonymousXWalkView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(154322);
        j.this.lef.a(j.this.IRh, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(154322);
      }
      
      public final boolean onSearchWord(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(154308);
        if (isSearchable())
        {
          paramAnonymousXWalkView = new Bundle();
          paramAnonymousXWalkView.putString("query", paramAnonymousString1);
          j.a(j.this).onMiscCallBack("jumpToSos", paramAnonymousXWalkView);
          boolean bool = j.this.leg.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, j.this.ITM.getUrl(), j.this.ITM.getRefererUrl(), j.this.ITM.getTitle());
          AppMethodBeat.o(154308);
          return bool;
        }
        AppMethodBeat.o(154308);
        return false;
      }
      
      public final boolean onSelectInfoChanged(XWalkView paramAnonymousXWalkView, long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(154305);
        if (!isSearchable())
        {
          AppMethodBeat.o(154305);
          return false;
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("PickedWord", paramAnonymousString1);
        ((Bundle)localObject).putString("PrefixText", paramAnonymousString2);
        ((Bundle)localObject).putString("SuffixText", paramAnonymousString3);
        localObject = j.a(j.this).onMiscCallBack("smartPickWord", (Bundle)localObject);
        if ((localObject instanceof Bundle))
        {
          localObject = (Bundle)localObject;
          if ((localObject != null) && (((Bundle)localObject).getString("PickedWord") != null))
          {
            int i = ((Bundle)localObject).getInt("PrefixOffset");
            int j = ((Bundle)localObject).getInt("SuffixOffset");
            j.b localb = j.b.d(paramAnonymousString1, ((Bundle)localObject).getString("PickedWord"), i, j, paramAnonymousString2, paramAnonymousString3);
            Log.d("XWWebView", "onSelectInfoChanged " + localb.toString());
            paramAnonymousXWalkView.adjustSelectPosition(paramAnonymousLong, ((Bundle)localObject).getString("PickedWord"), -localb.IUn, localb.IUp);
          }
          boolean bool = j.this.leg.a(paramAnonymousLong, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
          AppMethodBeat.o(154305);
          return bool;
        }
        AppMethodBeat.o(154305);
        return false;
      }
      
      public final void onShowCustomView(View paramAnonymousView, int paramAnonymousInt, CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(154325);
        super.onShowCustomView(paramAnonymousView, paramAnonymousInt, paramAnonymousCustomViewCallback);
        AppMethodBeat.o(154325);
      }
      
      public final void onShowCustomView(View paramAnonymousView, CustomViewCallback paramAnonymousCustomViewCallback)
      {
        AppMethodBeat.i(154301);
        Log.i("XWWebView", "onShowCustomView:".concat(String.valueOf(paramAnonymousView)));
        if (!this.IPh)
        {
          this.IPh = true;
          this.IUg = j.this.ITM.getSettings().getMediaPlaybackRequiresUserGesture();
          this.IUh = j.this.ITM.getSettings().getVideoPlaybackRequiresUserGesture();
          Log.i("XWWebView", "onShowCustomView: mIsMediaPlaybackRequiresUserGesture" + this.IUg + ", mIsVideoPlaybackRequiresUserGesture:" + this.IUh);
          j.this.ITM.getSettings().setMediaPlaybackRequiresUserGesture(false);
          j.this.ITM.getSettings().setVideoPlaybackRequiresUserGesture(false);
        }
        boolean bool = j.this.leg.a(paramAnonymousView, new f.a(paramAnonymousCustomViewCallback));
        com.tencent.xweb.util.g.fsk();
        if (bool)
        {
          Log.i("XWWebView", "onShowCustomView isHandled:true");
          AppMethodBeat.o(154301);
          return;
        }
        j.this.ITT.setVisibility(4);
        if (j.d(j.this) != null) {
          j.d(j.this).onShowCustomView(paramAnonymousView, new f.a(paramAnonymousCustomViewCallback));
        }
        AppMethodBeat.o(154301);
      }
      
      public final boolean onShowFileChooser(XWalkView paramAnonymousXWalkView, ValueCallback<Uri[]> paramAnonymousValueCallback, WebChromeClient.FileChooserParams paramAnonymousFileChooserParams)
      {
        AppMethodBeat.i(194691);
        boolean bool = j.this.leg.a(j.this.IRh, paramAnonymousValueCallback, new c.b(paramAnonymousFileChooserParams));
        AppMethodBeat.o(194691);
        return bool;
      }
      
      public final void onShowSos()
      {
        AppMethodBeat.i(154306);
        j.a(j.this).onMiscCallBack("onShowSos", new Bundle());
        AppMethodBeat.o(154306);
      }
      
      public final void onUnhandledKeyEvent(XWalkView paramAnonymousXWalkView, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(154324);
        super.onUnhandledKeyEvent(paramAnonymousXWalkView, paramAnonymousKeyEvent);
        AppMethodBeat.o(154324);
      }
      
      public final void openFileChooser(XWalkView paramAnonymousXWalkView, ValueCallback<Uri> paramAnonymousValueCallback, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(154314);
        Log.i("XWWebView", "openFileChooser with three param");
        j.this.leg.openFileChooser(paramAnonymousValueCallback, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(154314);
      }
      
      public final boolean shouldDiscardCurrentPage()
      {
        AppMethodBeat.i(154326);
        if (j.a(j.this) != null)
        {
          bool = j.a(j.this).shouldDiscardCurrentPage();
          AppMethodBeat.o(154326);
          return bool;
        }
        boolean bool = super.shouldDiscardCurrentPage();
        AppMethodBeat.o(154326);
        return bool;
      }
      
      public final boolean shouldOverrideKeyEvent(XWalkView paramAnonymousXWalkView, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(154323);
        boolean bool = super.shouldOverrideKeyEvent(paramAnonymousXWalkView, paramAnonymousKeyEvent);
        AppMethodBeat.o(154323);
        return bool;
      }
    };
    this.ITU.ITK = this.ITK;
    this.ITM.setUIClient(this.ITK);
    this.ITL = new n(this.ITM)
    {
      int IUi = 0;
      
      public final void doUpdateVisitedHistory(XWalkView paramAnonymousXWalkView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(154343);
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("data:text/html;charset=utf-8")))
        {
          AppMethodBeat.o(154343);
          return;
        }
        j.this.lef.a(j.this.IRh, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(154343);
      }
      
      public final void onDocumentLoadedInFrame(XWalkView paramAnonymousXWalkView, long paramAnonymousLong)
      {
        AppMethodBeat.i(154339);
        super.onDocumentLoadedInFrame(paramAnonymousXWalkView, paramAnonymousLong);
        AppMethodBeat.o(154339);
      }
      
      public final void onLoadFinished(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(154340);
        super.onLoadFinished(paramAnonymousXWalkView, paramAnonymousString);
        AppMethodBeat.o(154340);
      }
      
      public final void onLoadStarted(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(154334);
        j.this.lef.h(j.this.IRh, paramAnonymousString);
        AppMethodBeat.o(154334);
      }
      
      public final void onProgressChanged(XWalkView paramAnonymousXWalkView, int paramAnonymousInt)
      {
        AppMethodBeat.i(154338);
        if ((Math.abs(paramAnonymousInt - this.IUi) > 5) || (paramAnonymousInt == 100))
        {
          this.IUi = paramAnonymousInt;
          Log.i("XWWebView", "onProgressChanged, progress = ".concat(String.valueOf(paramAnonymousInt)));
        }
        j.this.leg.a(j.this.IRh, paramAnonymousInt);
        AppMethodBeat.o(154338);
      }
      
      public final void onReceivedClientCertRequest(XWalkView paramAnonymousXWalkView, ClientCertRequest paramAnonymousClientCertRequest)
      {
        AppMethodBeat.i(154341);
        super.onReceivedClientCertRequest(paramAnonymousXWalkView, paramAnonymousClientCertRequest);
        AppMethodBeat.o(154341);
      }
      
      public final void onReceivedHttpAuthRequest(XWalkView paramAnonymousXWalkView, XWalkHttpAuthHandler paramAnonymousXWalkHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(154344);
        super.onReceivedHttpAuthRequest(paramAnonymousXWalkView, paramAnonymousXWalkHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(154344);
      }
      
      public final void onReceivedHttpError(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest, XWalkWebResourceResponse paramAnonymousXWalkWebResourceResponse)
      {
        AppMethodBeat.i(154331);
        Log.i("XWWebView", "onReceivedHttpError code:" + paramAnonymousXWalkWebResourceResponse.getStatusCode());
        j.this.lef.a(j.this.IRh, new f.i(paramAnonymousXWalkWebResourceRequest), f.a(paramAnonymousXWalkWebResourceResponse));
        if (paramAnonymousXWalkWebResourceRequest.isForMainFrame()) {
          if (paramAnonymousXWalkWebResourceRequest.getUrl() == null) {
            break label117;
          }
        }
        label117:
        for (paramAnonymousXWalkWebResourceRequest = paramAnonymousXWalkWebResourceRequest.getUrl().toString();; paramAnonymousXWalkWebResourceRequest = "")
        {
          if (j.this.ITK != null) {
            j.this.ITK.onPageLoadStopped(paramAnonymousXWalkView, paramAnonymousXWalkWebResourceRequest, XWalkUIClient.LoadStatus.FAILED);
          }
          AppMethodBeat.o(154331);
          return;
        }
      }
      
      public final void onReceivedLoadError(XWalkView paramAnonymousXWalkView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(154336);
        Log.i("XWWebView", "onReceivedError ".concat(String.valueOf(paramAnonymousString2)));
        super.onReceivedLoadError(paramAnonymousXWalkView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        j.this.ITV = true;
        j.this.lef.a(j.this.IRh, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        h.frN().frO();
        com.tencent.xweb.util.g.b(paramAnonymousString2, paramAnonymousInt, System.currentTimeMillis() - j.this.IRn, j.c(j.this));
        if (j.this.lef.b(j.this.IRh, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2))
        {
          AppMethodBeat.o(154336);
          return;
        }
        paramAnonymousXWalkView = new StringBuilder(2000);
        paramAnonymousXWalkView.append("<html>\n");
        paramAnonymousXWalkView.append("<head>\n");
        paramAnonymousXWalkView.append("<script type=\"text/javascript\">\n");
        paramAnonymousXWalkView.append("function jumurl(){\n");
        paramAnonymousXWalkView.append("　　window.location.href = '");
        paramAnonymousXWalkView.append(paramAnonymousString2);
        paramAnonymousXWalkView.append("';\n");
        paramAnonymousXWalkView.append("}\n");
        paramAnonymousXWalkView.append("</script>\n");
        paramAnonymousXWalkView.append("<title>无法打开页面</title>\n");
        paramAnonymousXWalkView.append("<script >\n");
        paramAnonymousXWalkView.append("var html = document.documentElement,");
        paramAnonymousXWalkView.append("resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';");
        paramAnonymousXWalkView.append("function setHtmlFontSize() {");
        paramAnonymousXWalkView.append("var cliWidth = html.clientWidth;");
        paramAnonymousXWalkView.append("html.style.fontSize = 100 * (cliWidth / 720) + 'px';}");
        paramAnonymousXWalkView.append("window.addEventListener(resizeEvt, setHtmlFontSize, false);");
        paramAnonymousXWalkView.append("</script>\n");
        paramAnonymousXWalkView.append("<style>.exp{ text-align:center; margin-top:15rem; height=\"10rem\" width=\"10rem\"}</style>\n");
        paramAnonymousXWalkView.append("<style>.fcolorfortitle{ color: rgba(0, 0, 0, 0.3); font-size:44px;}</style>\n");
        paramAnonymousXWalkView.append("<style>.fcolorforsubtitle{ color: rgba(0, 0, 0, 0.3); font-size:34px;}</style>\n");
        paramAnonymousXWalkView.append("</head>\n");
        paramAnonymousXWalkView.append("<body bgcolor=\"#F2F2F2\" onclick=\"jumurl()\"'\">\n");
        paramAnonymousXWalkView.append("<br></br>");
        paramAnonymousXWalkView.append("<p></p>");
        paramAnonymousXWalkView.append("<div class=\"exp\" ><img src=\"html/img/webview_404_refresh_icon.svg\" text-align:center /><div>");
        paramAnonymousXWalkView.append("<br></br>");
        paramAnonymousXWalkView.append("<font size=\"44px\" class=\"fcolorfortitle\">无法打开页面</font>");
        paramAnonymousXWalkView.append("<br></br>");
        paramAnonymousXWalkView.append("<font size=\"44px\" class=\"fcolorforsubtitle\">轻触屏幕重新加载</font>");
        paramAnonymousXWalkView.append("</body>\n");
        paramAnonymousXWalkView.append("</html>");
        paramAnonymousXWalkView = paramAnonymousXWalkView.toString();
        j.this.ITM.loadDataWithBaseURL("file:///android_asset/", paramAnonymousXWalkView, "text/html", "utf-8", null);
        AppMethodBeat.o(154336);
      }
      
      public final void onReceivedResponseHeaders(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest, XWalkWebResourceResponse paramAnonymousXWalkWebResourceResponse)
      {
        AppMethodBeat.i(154342);
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
            j.this.lef.b(j.this.IRh, str1, null);
            j.this.ITM.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(154330);
                j.this.lef.b(j.this.IRh, str1, null);
                AppMethodBeat.o(154330);
              }
            }, 300L);
          }
        }
        while ((paramAnonymousXWalkWebResourceResponse.getStatusCode() < 400) || (j.this.supportFeature(3)))
        {
          String str2;
          super.onReceivedResponseHeaders(paramAnonymousXWalkView, paramAnonymousXWalkWebResourceRequest, paramAnonymousXWalkWebResourceResponse);
          AppMethodBeat.o(154342);
          return;
        }
        Log.i("XWWebView", "onReceivedHttpError code:" + paramAnonymousXWalkWebResourceResponse.getStatusCode());
        j.this.lef.a(j.this.IRh, new f.i(paramAnonymousXWalkWebResourceRequest), f.a(paramAnonymousXWalkWebResourceResponse));
        if (paramAnonymousXWalkWebResourceRequest.getUrl() != null) {}
        for (final String str1 = paramAnonymousXWalkWebResourceRequest.getUrl().toString();; str1 = "")
        {
          j.this.lef.a(j.this.IRh, paramAnonymousXWalkWebResourceResponse.getStatusCode(), "", str1);
          break;
        }
      }
      
      public final void onReceivedSslError(XWalkView paramAnonymousXWalkView, ValueCallback<Boolean> paramAnonymousValueCallback, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(154337);
        Log.i("XWWebView", "onReceivedSslError " + paramAnonymousSslError.getPrimaryError());
        j.this.lef.a(j.this.IRh, new f.h(paramAnonymousValueCallback), paramAnonymousSslError);
        AppMethodBeat.o(154337);
      }
      
      public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest)
      {
        AppMethodBeat.i(154335);
        f.i locali = new f.i(paramAnonymousXWalkWebResourceRequest);
        if (locali.IQZ == null)
        {
          paramAnonymousXWalkView = null;
          if (paramAnonymousXWalkView == null) {
            break label174;
          }
        }
        label174:
        for (paramAnonymousXWalkView = j.this.lef.a(j.this.IRh, locali, paramAnonymousXWalkView);; paramAnonymousXWalkView = null)
        {
          Object localObject = paramAnonymousXWalkView;
          if (paramAnonymousXWalkView == null) {
            localObject = j.this.lef.a(j.this.IRh, locali);
          }
          if (localObject == null) {}
          for (paramAnonymousXWalkView = j.this.lef.c(j.this.IRh, paramAnonymousXWalkWebResourceRequest.getUrl().toString());; paramAnonymousXWalkView = (XWalkView)localObject)
          {
            if (paramAnonymousXWalkView != null)
            {
              paramAnonymousXWalkView = createXWalkWebResourceResponse(paramAnonymousXWalkView.mMimeType, paramAnonymousXWalkView.mEncoding, paramAnonymousXWalkView.mInputStream, paramAnonymousXWalkView.mStatusCode, paramAnonymousXWalkView.mReasonPhrase, paramAnonymousXWalkView.mResponseHeaders);
              AppMethodBeat.o(154335);
              return paramAnonymousXWalkView;
              paramAnonymousXWalkView = locali.IQZ.getBundle();
              break;
            }
            AppMethodBeat.o(154335);
            return null;
          }
        }
      }
      
      public final boolean shouldOverrideUrlLoading(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(154332);
        if (c.aPC(paramAnonymousString))
        {
          AppMethodBeat.o(154332);
          return true;
        }
        boolean bool = j.this.lef.a(j.this.IRh, paramAnonymousString);
        Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + bool + " url = " + paramAnonymousString);
        AppMethodBeat.o(154332);
        return bool;
      }
      
      public final boolean shouldOverrideUrlLoading(XWalkView paramAnonymousXWalkView, String paramAnonymousString, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3)
      {
        AppMethodBeat.i(154333);
        if (c.aPC(paramAnonymousString))
        {
          AppMethodBeat.o(154333);
          return true;
        }
        paramAnonymousXWalkView = new f.i(paramAnonymousString, "GET", paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean3);
        paramAnonymousBoolean1 = j.this.lef.d(j.this.IRh, paramAnonymousXWalkView);
        AppMethodBeat.o(154333);
        return paramAnonymousBoolean1;
      }
    };
    this.ITU.ITL = this.ITL;
    this.ITM.setResourceClient(this.ITL);
    AppMethodBeat.o(154357);
  }
  
  public static boolean gX(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(154356);
      com.tencent.xweb.xwalk.updater.d.lf(paramContext);
      boolean bool = com.tencent.xweb.xwalk.updater.d.isXWalkReady();
      AppMethodBeat.o(154356);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void a(View paramView, boolean paramBoolean, com.tencent.xweb.p paramp)
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
        new ReflectMethod(localClass, "startLongScreenShot", new Class[] { View.class, Boolean.TYPE, Object.class }).invoke(new Object[] { paramView, Boolean.valueOf(paramBoolean), XWalkCoreWrapper.getInstance().getBridgeObject(new f.d(paramp)) });
        AppMethodBeat.o(154410);
        return;
      }
      catch (Exception paramView)
      {
        Log.e("XWWebView", "startLongScreenShot reflect failed");
      }
    }
    AppMethodBeat.o(154410);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(154382);
    this.ITM.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(154382);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(154364);
    if (this.ITV)
    {
      AppMethodBeat.o(154364);
      return false;
    }
    XWalkNavigationHistory localXWalkNavigationHistory = this.ITM.getNavigationHistory();
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
    if (this.ITM.getNavigationHistory() != null)
    {
      boolean bool = this.ITM.getNavigationHistory().canGoForward();
      AppMethodBeat.o(154405);
      return bool;
    }
    AppMethodBeat.o(154405);
    return false;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(154402);
    final View localView = ((ViewGroup)((ViewGroup)this.ITM.getChildAt(0)).getChildAt(0)).getChildAt(0);
    if ((localView instanceof TextureView)) {
      new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(154351);
          Log.d("XWWebView", "onFinishGetBitmap with ".concat(String.valueOf(((TextureView)localView).getBitmap())));
          AppMethodBeat.o(154351);
        }
      }).start();
    }
    AppMethodBeat.o(154402);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(154404);
    if (this.ITM.getNavigationHistory() != null) {
      this.ITM.getNavigationHistory().clear();
    }
    AppMethodBeat.o(154404);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(154388);
    this.ITM.clearMatches();
    AppMethodBeat.o(154388);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(154373);
    this.ITM.clearSslPreferences();
    AppMethodBeat.o(154373);
  }
  
  public final void clearView() {}
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(194694);
    p localp = new p(this.ITM.getNavigationHistory());
    AppMethodBeat.o(194694);
    return localp;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(154368);
    this.ITM.onDestroy();
    AppMethodBeat.o(154368);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(154369);
    if (this.IRo != null) {
      this.IRo.xF(paramBoolean);
    }
    AppMethodBeat.o(154369);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(154371);
    this.ITM.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(154371);
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(154390);
    this.ITM.findAllAsync(paramString);
    AppMethodBeat.o(154390);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(154389);
    this.ITM.findNext(paramBoolean);
    AppMethodBeat.o(154389);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(154392);
    String str = "webviewtype = xwalk, sdkver = 200502\n apkver = " + XWalkEnvironment.getAvailableVersion();
    AppMethodBeat.o(154392);
    return str;
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(154375);
    int i = this.ITM.getContentHeight();
    AppMethodBeat.o(154375);
    return i;
  }
  
  public final w getCurWebChromeClient()
  {
    return this.leg;
  }
  
  public final ab getCurWebviewClient()
  {
    return this.lef;
  }
  
  public final com.tencent.xweb.internal.e getDefalutOpProvider()
  {
    return this.ITU;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(154400);
    WebView.a locala = com.tencent.xweb.a.aOJ(WebView.getCurStrModule());
    AppMethodBeat.o(154400);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(154386);
    WebView.b localb = new WebView.b();
    XWalkHitTestResult localXWalkHitTestResult = this.ITM.getHitTestResult();
    localb.mType = localXWalkHitTestResult.getType().ordinal();
    localb.mExtra = localXWalkHitTestResult.getExtra();
    AppMethodBeat.o(154386);
    return localb;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, final i parami)
  {
    AppMethodBeat.i(154413);
    boolean bool = this.ITM.getImageBitmapToFile(paramString1, paramString2, paramString3, new XWalkGetImageBitmapToFileFinishedCallback()
    {
      public final void onFinishImageBitmapToFile(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString3)
      {
        AppMethodBeat.i(154352);
        parami.ct(paramAnonymousInt1, paramAnonymousString2);
        AppMethodBeat.o(154352);
      }
    });
    AppMethodBeat.o(154413);
    return bool;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(154376);
    float f = this.ITM.getScale();
    AppMethodBeat.o(154376);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(154418);
    int i = this.ITM.computeVerticalScrollRange();
    AppMethodBeat.o(154418);
    return i;
  }
  
  public final y getSettings()
  {
    return this.ITS;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(154387);
    String str = this.ITM.getTitle();
    AppMethodBeat.o(154387);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.ITT;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(154383);
    String str = this.ITM.getUrl();
    AppMethodBeat.o(154383);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(154391);
    String str = "webviewType = WV_KIND_CW,V8 type=" + JsRuntime.fqG() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 200502";
    AppMethodBeat.o(154391);
    return str;
  }
  
  public final View getView()
  {
    return this.ITM;
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
    int i = this.ITM.computeVerticalScrollOffset();
    AppMethodBeat.o(154394);
    return i;
  }
  
  public final View getWebViewUI()
  {
    return this.ITM;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(154365);
    if (this.ITM.getNavigationHistory() == null)
    {
      AppMethodBeat.o(154365);
      return;
    }
    if (this.ITM.getNavigationHistory().canGoBack())
    {
      this.ITM.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
      if ((this.ITM.getNavigationHistory() != null) && (this.ITM.getNavigationHistory().getCurrentItem() != null)) {
        this.leg.d(this.IRh, this.ITM.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
    AppMethodBeat.o(154365);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(154406);
    if (this.ITM.getNavigationHistory().canGoForward())
    {
      this.ITM.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.FORWARD, 1);
      if ((this.ITM.getNavigationHistory() != null) && (this.ITM.getNavigationHistory().getCurrentItem() != null)) {
        this.leg.d(this.IRh, this.ITM.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
    AppMethodBeat.o(154406);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(154366);
    boolean bool = this.ITM.hasEnteredFullscreen();
    AppMethodBeat.o(154366);
    return bool;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(154411);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.d("XWWebView", " method string is null or empty");
      AppMethodBeat.o(154411);
      return null;
    }
    Log.d("XWWebView", " method string is ".concat(String.valueOf(paramString)));
    boolean bool;
    if (paramString.equals("supportTranslateWebSite"))
    {
      bool = XWalkCoreWrapper.getInstance().isSupportTranslateWebSite();
      paramString = new Bundle();
      paramString.putBoolean("result", bool);
      Log.i("XWWebView", "translate: xweb is supportTranslateWebSite = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(154411);
      return paramString;
    }
    if (paramString.equals("getTranslateSampleString"))
    {
      Log.i("XWWebView", "translate: xweb is detectTranslateWebSiteIsNeeded ,getTranslateSampleString");
      this.ITM.getTranslateSampleString(0);
      AppMethodBeat.o(154411);
      return null;
    }
    if (paramString.equals("translateWebSite"))
    {
      Log.i("XWWebView", "translate: do translateWebSite");
      paramBundle.getString("url");
      this.IUa = true;
      AppMethodBeat.o(154411);
      return null;
    }
    if (paramString.equals("replaceTranslatedString"))
    {
      Log.i("XWWebView", "translate: replaceTranslatedString mIsTranslateMode =" + this.IUa);
      if (!this.IUa)
      {
        AppMethodBeat.o(154411);
        return null;
      }
      Object localObject = (HashMap)paramBundle.getSerializable("translate_hashmap");
      bool = paramBundle.getBoolean("is_mp_url");
      paramString = paramBundle.getString("translate_tips");
      paramBundle = new HashMap();
      Iterator localIterator = ((HashMap)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)((HashMap)localObject).get(str1);
        if ((str1 == null) || (str1.isEmpty()) || (str2 == null) || (str2.isEmpty())) {
          Log.d("XWWebView", "translate: string is err !!!  key = " + str1 + " value = " + str2);
        } else if ((str2.trim().length() == 0) || (str2.trim().equals("\n")) || (str2.trim().equals("\r"))) {
          Log.d("XWWebView", "translate: string is space  or change line  value = ".concat(String.valueOf(str2)));
        } else {
          paramBundle.put(str1, str2);
        }
      }
      Log.d("XWWebView", "translate: replaceTranslatedString orghashmap size = " + ((HashMap)localObject).size() + " resultHashMap size = " + paramBundle.size());
      this.ITM.replaceTranslatedString(paramBundle);
      bool = Boolean.valueOf(bool).booleanValue();
      if ((this.IUa) && (!this.IUb))
      {
        this.IUb = true;
        Log.i("XWWebView", "getTranslateTipsView");
        paramBundle = new FrameLayout.LayoutParams(-1, 144);
        paramBundle.gravity = 51;
        localObject = new TextView(this.IRh.getContext());
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setText(paramString);
        ((TextView)localObject).setTextColor(Color.argb(127, 0, 0, 0));
        ((TextView)localObject).setTextSize(0, 42.0F);
        if (!bool) {
          break label664;
        }
        ((TextView)localObject).setBackgroundColor(-328966);
      }
      for (;;)
      {
        ((ViewGroup)this.IRh.getParent()).addView((View)localObject, paramBundle);
        ((FrameLayout.LayoutParams)this.IRh.getLayoutParams()).topMargin = 144;
        this.IRh.requestLayout();
        Log.d("XWWebView", "translate: onTranslateFinish ");
        eiS();
        AppMethodBeat.o(154411);
        return null;
        label664:
        ((TextView)localObject).setBackgroundColor(-855310);
      }
    }
    AppMethodBeat.o(154411);
    return null;
  }
  
  public final boolean isOverScrollStart()
  {
    AppMethodBeat.i(154396);
    boolean bool = this.IUd;
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
  
  public final boolean isSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(154393);
    boolean bool = this.ITM.isSupportExtendPluginForAppbrand();
    AppMethodBeat.o(154393);
    return bool;
  }
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(154367);
    this.ITM.leaveFullscreen();
    AppMethodBeat.o(154367);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(154374);
    this.ITM.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(154374);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(154378);
    this.ITM.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(154378);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(154363);
    if ((paramString != null) && (paramString.trim().startsWith("javascript:")))
    {
      this.ITM.evaluateJavascript(paramString, null);
      AppMethodBeat.o(154363);
      return;
    }
    this.ITV = false;
    this.ITM.loadUrl(paramString);
    AppMethodBeat.o(154363);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(154381);
    this.ITM.loadUrl(paramString, paramMap);
    AppMethodBeat.o(154381);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(154417);
    this.ITM.onHide();
    AppMethodBeat.o(154417);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(154399);
    this.ITM.onPause();
    AppMethodBeat.o(154399);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(154398);
    this.ITM.onResume();
    AppMethodBeat.o(154398);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(154416);
    this.ITM.onShow();
    AppMethodBeat.o(154416);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(154377);
    int i = this.ITM.getScrollBarStyle();
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
    this.ITM.reload(0);
    AppMethodBeat.o(154372);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(154384);
    this.ITM.removeJavascriptInterface(paramString);
    AppMethodBeat.o(154384);
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
    Log.e("XWWebView", "setBottomHeight not implement");
    this.ITM.setBottomHeight(paramInt);
    AppMethodBeat.o(154415);
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(154361);
    this.ITM.setDownloadListener(new f.f(this.IRh.getContext(), paramDownloadListener));
    AppMethodBeat.o(154361);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(154362);
    this.ITM.setFindListener(new f.g(paramFindListener));
    AppMethodBeat.o(154362);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154409);
    this.ITM.setHorizontalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(154409);
  }
  
  public final void setJSExceptionListener(ac paramac)
  {
    this.ITZ = paramac;
  }
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154408);
    this.ITM.setVerticalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(154408);
  }
  
  public final t setVideoJsCallback(u paramu)
  {
    AppMethodBeat.i(154370);
    if ((this.IRo != null) && (this.IRo.ew(paramu)))
    {
      paramu = new t()
      {
        public final void G(double paramAnonymousDouble)
        {
          AppMethodBeat.i(154349);
          if (j.d(j.this) != null) {
            j.d(j.this).G(paramAnonymousDouble);
          }
          AppMethodBeat.o(154349);
        }
        
        public final void fqL()
        {
          AppMethodBeat.i(154347);
          if (j.d(j.this) != null) {
            j.d(j.this).fqL();
          }
          AppMethodBeat.o(154347);
        }
        
        public final void fqM()
        {
          AppMethodBeat.i(154348);
          if (j.d(j.this) != null) {
            j.d(j.this).fqM();
          }
          AppMethodBeat.o(154348);
        }
        
        public final boolean fqN()
        {
          AppMethodBeat.i(194693);
          if (j.d(j.this) != null)
          {
            boolean bool = j.d(j.this).fqN();
            AppMethodBeat.o(194693);
            return bool;
          }
          AppMethodBeat.o(194693);
          return false;
        }
      };
      AppMethodBeat.o(154370);
      return paramu;
    }
    Log.i("XWWebView", "setVideoJsCallback not support");
    AppMethodBeat.o(154370);
    return null;
  }
  
  public final void setWebChromeClient(w paramw)
  {
    AppMethodBeat.i(154360);
    if (paramw == null)
    {
      this.leg = new w();
      AppMethodBeat.o(154360);
      return;
    }
    fsY();
    this.leg = paramw;
    AppMethodBeat.o(154360);
  }
  
  public final void setWebViewCallbackClient(aa paramaa)
  {
    this.kwV = paramaa;
  }
  
  public final void setWebViewClient(ab paramab)
  {
    AppMethodBeat.i(154359);
    if (paramab == null)
    {
      this.lef = new ab();
      this.lef.IMW = this.ITU;
      AppMethodBeat.o(154359);
      return;
    }
    fsY();
    this.lef = paramab;
    AppMethodBeat.o(154359);
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(154397);
    this.ITY = parama;
    this.ITM.setProxyWebViewClientExtension(this.ITX);
    AppMethodBeat.o(154397);
  }
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(154403);
    this.ITM.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(154403);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(154385);
    this.ITM.stopLoading();
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
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(154380);
    boolean bool = this.ITM.zoomIn();
    AppMethodBeat.o(154380);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(154379);
    boolean bool = this.ITM.zoomOut();
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
    
    public final void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(154353);
      super.onScrollChangedDelegate(paramInt1, paramInt2, paramInt3, paramInt4);
      if (j.this.IRh != null) {
        j.this.IRh.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(154353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j
 * JD-Core Version:    0.7.0.1
 */