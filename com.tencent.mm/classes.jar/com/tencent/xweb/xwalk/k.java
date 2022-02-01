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
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.ad;
import com.tencent.xweb.ae;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.i;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.sys.c.c;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
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

public final class k
  implements IWebView, com.tencent.xweb.internal.g
{
  static int MUi = 0;
  private final int DXC;
  private final int DXD;
  private final int DXE;
  WebView MRh;
  long MRn;
  private b MRo;
  m MTQ;
  o MTR;
  XWalkView MTS;
  l MTY;
  AbsoluteLayout MTZ;
  h MUa;
  boolean MUb;
  private String MUc;
  private XWalkProxyWebViewClientExtension MUd;
  private com.tencent.xweb.x5.export.external.extension.proxy.a MUe;
  private ae MUf;
  private boolean MUg;
  private boolean MUh;
  private boolean MUj;
  ab lzJ;
  int mApkVersion;
  ac mhR;
  x mhS;
  private int type;
  
  public k(WebView paramWebView)
  {
    AppMethodBeat.i(154358);
    this.mhR = new ac();
    this.mhS = new x();
    this.MRn = 0L;
    this.type = 0;
    this.MUb = false;
    this.MUc = null;
    this.MUd = new XWalkProxyWebViewClientExtension()
    {
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(154296);
        if (k.a(k.this) != null)
        {
          paramAnonymousString = k.a(k.this).onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(154296);
          return paramAnonymousString;
        }
        AppMethodBeat.o(154296);
        return null;
      }
    };
    this.MUe = new com.tencent.xweb.x5.export.external.extension.proxy.a();
    this.MUf = null;
    this.DXC = 0;
    this.DXD = 1;
    this.DXE = 2;
    this.MUg = false;
    this.MUh = false;
    this.MUj = false;
    this.mApkVersion = XWalkEnvironment.getAvailableVersion();
    XWalkContextWrapper localXWalkContextWrapper = new XWalkContextWrapper(paramWebView.getContext(), this.mApkVersion);
    XWalkLibraryLoader.prepareToInit(localXWalkContextWrapper);
    try
    {
      XWalkPreferences.setValue("xweb-version", String.valueOf(this.mApkVersion));
      XWalkPreferences.setValue("xwebsdk-version", "200901");
      this.MTS = new a(localXWalkContextWrapper);
      this.MTZ = new AbsoluteLayout(localXWalkContextWrapper);
      this.MTS.getXWalkContentView().addView(this.MTZ);
      this.MTS.setCustomOnScrollChangedListener(new XWalkView.ScrollChangedListener()
      {
        public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(154345);
          k.this.MTZ.scrollTo(paramAnonymousInt1, paramAnonymousInt2);
          if (k.this.lzJ != null) {
            k.this.lzJ.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, k.this.MTS);
          }
          AppMethodBeat.o(154345);
        }
      });
      this.MTS.setCustomOnOverScrolledListener(new XWalkView.OverScrolledListener()
      {
        public final void onOverScrolled(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154346);
          if (paramAnonymousBoolean)
          {
            k.a(k.this, true);
            AppMethodBeat.o(154346);
            return;
          }
          k.a(k.this, false);
          AppMethodBeat.o(154346);
        }
      });
      this.MUa = new h(this.MTS);
      this.MRh = paramWebView;
      this.MTY = new l(this.MTS);
      this.MTS.getSettings().SetLogCallBack(new XWalkLogMessageListener()
      {
        public final void onLogMessage(int paramAnonymousInt1, String paramAnonymousString1, int paramAnonymousInt2, String paramAnonymousString2)
        {
          AppMethodBeat.i(154350);
          Log.i("XWWebView", "[WCWebview] :".concat(String.valueOf(paramAnonymousString2)));
          AppMethodBeat.o(154350);
        }
      });
      paramWebView = this.MTS.getContext();
      Log.i("XWWebView", "initFullscreenVideo:" + getFullscreenVideoKind());
      this.MRo = com.tencent.xweb.extension.video.e.a(paramWebView, this.MRh, this.MTS, com.tencent.xweb.extension.video.d.gfT());
      if (getFullscreenVideoKind() == WebView.a.MNv) {
        this.MRo.eD(this.MTS);
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
  
  private void eQO()
  {
    AppMethodBeat.i(154412);
    this.MUe.onMiscCallBack("onTranslateFinish", new Bundle());
    AppMethodBeat.o(154412);
  }
  
  private void ghA()
  {
    AppMethodBeat.i(154357);
    if (this.MTQ != null)
    {
      AppMethodBeat.o(154357);
      return;
    }
    this.MTQ = new m(this.MTS)
    {
      private boolean MPb = false;
      String MUl = null;
      private boolean MUm = false;
      private boolean MUn = false;
      
      public final boolean OnGetSampleString(XWalkView paramAnonymousXWalkView, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(154329);
        paramAnonymousXWalkView = new Bundle();
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(paramAnonymousMap);
        Log.d("XWWebView", "translate: OnGetSampleString orghashmap size = " + paramAnonymousMap.size() + " resultHashMap size = " + localHashMap.size());
        paramAnonymousXWalkView.putSerializable("sample_hashmap", localHashMap);
        paramAnonymousXWalkView = k.a(k.this).onMiscCallBack("onGetSampleString", paramAnonymousXWalkView);
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
        View localView = LayoutInflater.from(k.this.MRh.getContext()).inflate(2131495836, null);
        AppMethodBeat.o(154304);
        return localView;
      }
      
      public final boolean isSearchable()
      {
        AppMethodBeat.i(154307);
        Object localObject = k.a(k.this).onMiscCallBack("supportSmartPickWord", new Bundle());
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
        if (k.a(k.this) != null) {
          k.a(k.this).hasDiscardCurrentPage(true);
        }
        AppMethodBeat.o(154327);
      }
      
      public final boolean onConsoleMessage(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, XWalkUIClient.ConsoleMessageType paramAnonymousConsoleMessageType)
      {
        AppMethodBeat.i(154313);
        if ((XWalkUIClient.ConsoleMessageType.ERROR == paramAnonymousConsoleMessageType) && (k.g(k.this) != null) && (paramAnonymousString1.split(":").length == 2))
        {
          k.g(k.this);
          com.tencent.xweb.util.g.ggS();
        }
        x localx = k.this.mhS;
        paramAnonymousXWalkView = ConsoleMessage.MessageLevel.DEBUG;
        switch (g.1.MTJ[paramAnonymousConsoleMessageType.ordinal()])
        {
        }
        for (;;)
        {
          boolean bool = localx.onConsoleMessage(new ConsoleMessage(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousXWalkView));
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
        AppMethodBeat.i(207576);
        k.this.mhS.b(k.this.MRh, paramAnonymousInt);
        AppMethodBeat.o(207576);
      }
      
      public final void onExitFullscreenVideo(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(154303);
        Log.i("XWWebView", "onExitFullscreenVideo");
        k.this.mhS.onExitFullscreenVideo(paramAnonymousBitmap);
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
        AppMethodBeat.i(207574);
        k.this.mhS.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(207574);
      }
      
      public final void onGeolocationPermissionsShowPrompt(String paramAnonymousString, XWalkGeolocationPermissionsCallback paramAnonymousXWalkGeolocationPermissionsCallback)
      {
        AppMethodBeat.i(154312);
        k.this.mhS.onGeolocationPermissionsShowPrompt(paramAnonymousString, new g.b(paramAnonymousXWalkGeolocationPermissionsCallback));
        AppMethodBeat.o(154312);
      }
      
      public final boolean onGetTranslateString(XWalkView paramAnonymousXWalkView, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(154328);
        paramAnonymousXWalkView = new Bundle();
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(paramAnonymousMap);
        Log.d("XWWebView", "translate: onGetTranslateString orghashmap size = " + paramAnonymousMap.size() + " resultHashMap size = " + localHashMap.size());
        if ((localHashMap.size() == 0) && (k.e(k.this)))
        {
          Log.d("XWWebView", "translate: onTranslateFinish ");
          k.h(k.this);
        }
        paramAnonymousXWalkView.putSerializable("translate_hashmap", localHashMap);
        paramAnonymousXWalkView = k.a(k.this).onMiscCallBack("onGetTranslateString", paramAnonymousXWalkView);
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
        if (this.MPb)
        {
          this.MPb = false;
          Log.i("XWWebView", "onHideCustomView: mIsMediaPlaybackRequiresUserGesture" + this.MUm + ", mIsVideoPlaybackRequiresUserGesture:" + this.MUn);
          k.this.MTS.getSettings().setMediaPlaybackRequiresUserGesture(this.MUm);
          k.this.MTS.getSettings().setVideoPlaybackRequiresUserGesture(this.MUn);
        }
        if (k.this.mhS.bpU())
        {
          Log.i("XWWebView", "onHideCustomView isHandled:true");
          AppMethodBeat.o(154302);
          return;
        }
        k.this.MTZ.setVisibility(0);
        if (k.d(k.this) != null) {
          k.d(k.this).onHideCustomView();
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
        Object localObject = k.a(k.this).onMiscCallBack("onJavascriptCloseWindow", new Bundle());
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
        boolean bool = k.this.mhS.a(k.this.MRh, paramAnonymousString1, paramAnonymousString2, new g.c(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(154309);
        return bool;
      }
      
      public final boolean onJsConfirm(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(154310);
        Log.i("XWWebView", "onJsConfirm");
        boolean bool = k.this.mhS.b(k.this.MRh, paramAnonymousString1, paramAnonymousString2, new g.c(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(154310);
        return bool;
      }
      
      public final boolean onJsPrompt(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, XWalkJavascriptResult paramAnonymousXWalkJavascriptResult)
      {
        AppMethodBeat.i(154311);
        Log.i("XWWebView", "onJsPrompt");
        boolean bool = k.this.mhS.a(k.this.MRh, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, new g.e(paramAnonymousXWalkJavascriptResult));
        AppMethodBeat.o(154311);
        return bool;
      }
      
      public final void onPageCommitVisible(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(154298);
        k.this.mhR.e(k.this.MRh, paramAnonymousString);
        AppMethodBeat.o(154298);
      }
      
      public final void onPageLoadStarted(XWalkView paramAnonymousXWalkView, String paramAnonymousString)
      {
        AppMethodBeat.i(154297);
        Log.i("XWWebView", "onPageLoadStarted: url = ".concat(String.valueOf(paramAnonymousString)));
        k.this.mhR.b(k.this.MRh, paramAnonymousString, k.this.MTS.getFavicon());
        com.tencent.xweb.internal.h.ggn().ggi();
        this.MUl = null;
        if ((k.b(k.this) != null) && (paramAnonymousString != null) && (!paramAnonymousString.equals(k.b(k.this))) && (com.tencent.xweb.util.g.bcW(paramAnonymousString) != com.tencent.xweb.util.g.bcW(k.b(k.this))))
        {
          if ((com.tencent.xweb.util.g.bcW(k.b(k.this)) == 1) && (com.tencent.xweb.util.g.bcW(paramAnonymousString) == 2)) {
            k.a(k.this, 1);
          }
        }
        else
        {
          k.a(k.this, paramAnonymousString);
          k.this.MRn = System.currentTimeMillis();
          paramAnonymousXWalkView = paramAnonymousString;
          if (paramAnonymousString == null) {
            paramAnonymousXWalkView = "";
          }
          com.tencent.xweb.util.g.ht(paramAnonymousXWalkView, k.c(k.this));
          d.a(k.this.MRh);
          if (k.d(k.this) != null)
          {
            paramAnonymousXWalkView = k.d(k.this);
            if (k.this.MRh.getFullscreenVideoKind() != WebView.a.MNv) {
              break label307;
            }
          }
        }
        label307:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.ba(true, bool);
          if (k.e(k.this))
          {
            Log.d("XWWebView", "onTranslateStart setTranslateMode true ");
            k.f(k.this);
            k.this.MTS.setTranslateMode(true);
          }
          AppMethodBeat.o(154297);
          return;
          if ((com.tencent.xweb.util.g.bcW(k.b(k.this)) != 2) || (com.tencent.xweb.util.g.bcW(paramAnonymousString) != 1)) {
            break;
          }
          k.a(k.this, 2);
          break;
        }
      }
      
      public final void onPageLoadStopped(XWalkView paramAnonymousXWalkView, String paramAnonymousString, XWalkUIClient.LoadStatus paramAnonymousLoadStatus)
      {
        AppMethodBeat.i(154299);
        if ((this.MUl != null) && (this.MUl.equals(paramAnonymousString)))
        {
          Log.i("XWWebView", "abandoned onPageFinished: url = " + paramAnonymousString + " status = " + paramAnonymousLoadStatus);
          AppMethodBeat.o(154299);
          return;
        }
        if (k.d(k.this) != null)
        {
          paramAnonymousXWalkView = k.d(k.this);
          if (k.this.MRh.getFullscreenVideoKind() != WebView.a.MNv) {
            break label216;
          }
        }
        label216:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.ba(false, bool);
          this.MUl = paramAnonymousString;
          Log.i("XWWebView", "onPageFinished: url = " + paramAnonymousString + " status = " + paramAnonymousLoadStatus);
          k.this.mhR.b(k.this.MRh, paramAnonymousString);
          if (paramAnonymousLoadStatus != XWalkUIClient.LoadStatus.FAILED) {
            com.tencent.xweb.internal.h.ggn().ggj();
          }
          com.tencent.xweb.util.g.s(paramAnonymousString, System.currentTimeMillis() - k.this.MRn, k.c(k.this));
          k.this.MRn = System.currentTimeMillis();
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
        k.this.mhS.d(null, paramAnonymousString);
        if (k.d(k.this) != null)
        {
          paramAnonymousXWalkView = k.d(k.this);
          if (k.this.MRh.getFullscreenVideoKind() != WebView.a.MNv) {
            break label90;
          }
        }
        label90:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousXWalkView.ba(true, bool);
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
        k.this.mhR.a(k.this.MRh, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(154322);
      }
      
      public final boolean onSearchWord(XWalkView paramAnonymousXWalkView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(154308);
        if (isSearchable())
        {
          paramAnonymousXWalkView = new Bundle();
          paramAnonymousXWalkView.putString("query", paramAnonymousString1);
          k.a(k.this).onMiscCallBack("jumpToSos", paramAnonymousXWalkView);
          boolean bool = k.this.mhS.c(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, k.this.MTS.getUrl(), k.this.MTS.getRefererUrl(), k.this.MTS.getTitle());
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
        localObject = k.a(k.this).onMiscCallBack("smartPickWord", (Bundle)localObject);
        if ((localObject instanceof Bundle))
        {
          localObject = (Bundle)localObject;
          if ((localObject != null) && (((Bundle)localObject).getString("PickedWord") != null))
          {
            int i = ((Bundle)localObject).getInt("PrefixOffset");
            int j = ((Bundle)localObject).getInt("SuffixOffset");
            k.b localb = k.b.c(paramAnonymousString1, ((Bundle)localObject).getString("PickedWord"), i, j, paramAnonymousString2, paramAnonymousString3);
            Log.d("XWWebView", "onSelectInfoChanged " + localb.toString());
            paramAnonymousXWalkView.adjustSelectPosition(paramAnonymousLong, ((Bundle)localObject).getString("PickedWord"), -localb.MUt, localb.MUv);
          }
          boolean bool = k.this.mhS.a(paramAnonymousLong, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
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
        if (!this.MPb)
        {
          this.MPb = true;
          this.MUm = k.this.MTS.getSettings().getMediaPlaybackRequiresUserGesture();
          this.MUn = k.this.MTS.getSettings().getVideoPlaybackRequiresUserGesture();
          Log.i("XWWebView", "onShowCustomView: mIsMediaPlaybackRequiresUserGesture" + this.MUm + ", mIsVideoPlaybackRequiresUserGesture:" + this.MUn);
          k.this.MTS.getSettings().setMediaPlaybackRequiresUserGesture(false);
          k.this.MTS.getSettings().setVideoPlaybackRequiresUserGesture(false);
        }
        boolean bool = k.this.mhS.a(paramAnonymousView, new g.a(paramAnonymousCustomViewCallback));
        com.tencent.xweb.util.g.ggK();
        if (bool)
        {
          Log.i("XWWebView", "onShowCustomView isHandled:true");
          AppMethodBeat.o(154301);
          return;
        }
        k.this.MTZ.setVisibility(4);
        if (k.d(k.this) != null) {
          k.d(k.this).onShowCustomView(paramAnonymousView, new g.a(paramAnonymousCustomViewCallback));
        }
        AppMethodBeat.o(154301);
      }
      
      public final boolean onShowFileChooser(XWalkView paramAnonymousXWalkView, ValueCallback<Uri[]> paramAnonymousValueCallback, WebChromeClient.FileChooserParams paramAnonymousFileChooserParams)
      {
        AppMethodBeat.i(207575);
        boolean bool = k.this.mhS.a(k.this.MRh, paramAnonymousValueCallback, new c.c(paramAnonymousFileChooserParams));
        AppMethodBeat.o(207575);
        return bool;
      }
      
      public final void onShowSos()
      {
        AppMethodBeat.i(154306);
        k.a(k.this).onMiscCallBack("onShowSos", new Bundle());
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
        k.this.mhS.openFileChooser(paramAnonymousValueCallback, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(154314);
      }
      
      public final boolean shouldDiscardCurrentPage()
      {
        AppMethodBeat.i(154326);
        if (k.a(k.this) != null)
        {
          bool = k.a(k.this).shouldDiscardCurrentPage();
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
    this.MUa.MTQ = this.MTQ;
    this.MTS.setUIClient(this.MTQ);
    this.MTR = new o(this.MTS)
    {
      int MUo = 0;
      
      public final void doUpdateVisitedHistory(XWalkView paramAnonymousXWalkView, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(154343);
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("data:text/html;charset=utf-8")))
        {
          AppMethodBeat.o(154343);
          return;
        }
        k.this.mhR.b(k.this.MRh, paramAnonymousString, paramAnonymousBoolean);
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
        k.this.mhR.h(k.this.MRh, paramAnonymousString);
        AppMethodBeat.o(154334);
      }
      
      public final void onProgressChanged(XWalkView paramAnonymousXWalkView, int paramAnonymousInt)
      {
        AppMethodBeat.i(154338);
        if ((Math.abs(paramAnonymousInt - this.MUo) > 5) || (paramAnonymousInt == 100))
        {
          this.MUo = paramAnonymousInt;
          Log.i("XWWebView", "onProgressChanged, progress = ".concat(String.valueOf(paramAnonymousInt)));
        }
        k.this.mhS.a(k.this.MRh, paramAnonymousInt);
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
        Log.i("XWWebView", "onReceivedHttpAuthRequest host:" + paramAnonymousString1 + ", realm:" + paramAnonymousString2);
        if (k.this.mhR != null)
        {
          k.this.mhR.a(k.this.MRh, new g.j(paramAnonymousXWalkHttpAuthHandler), paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(154344);
          return;
        }
        super.onReceivedHttpAuthRequest(paramAnonymousXWalkView, paramAnonymousXWalkHttpAuthHandler, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(154344);
      }
      
      public final void onReceivedHttpError(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest, XWalkWebResourceResponse paramAnonymousXWalkWebResourceResponse)
      {
        AppMethodBeat.i(154331);
        Log.i("XWWebView", "onReceivedHttpError code:" + paramAnonymousXWalkWebResourceResponse.getStatusCode());
        k.this.mhR.a(k.this.MRh, new g.i(paramAnonymousXWalkWebResourceRequest), g.a(paramAnonymousXWalkWebResourceResponse));
        if (paramAnonymousXWalkWebResourceRequest.isForMainFrame()) {
          if (paramAnonymousXWalkWebResourceRequest.getUrl() == null) {
            break label117;
          }
        }
        label117:
        for (paramAnonymousXWalkWebResourceRequest = paramAnonymousXWalkWebResourceRequest.getUrl().toString();; paramAnonymousXWalkWebResourceRequest = "")
        {
          if (k.this.MTQ != null) {
            k.this.MTQ.onPageLoadStopped(paramAnonymousXWalkView, paramAnonymousXWalkWebResourceRequest, XWalkUIClient.LoadStatus.FAILED);
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
        k.this.MUb = true;
        k.this.mhR.a(k.this.MRh, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        com.tencent.xweb.internal.h.ggn().ggo();
        com.tencent.xweb.util.g.c(paramAnonymousString2, paramAnonymousInt, System.currentTimeMillis() - k.this.MRn, k.c(k.this));
        if (k.this.mhR.b(k.this.MRh, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2))
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
        k.this.MTS.loadDataWithBaseURL("file:///android_asset/", paramAnonymousXWalkView, "text/html", "utf-8", null);
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
            k.this.mhR.b(k.this.MRh, str1, null);
            k.this.MTS.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(154330);
                k.this.mhR.b(k.this.MRh, str1, null);
                AppMethodBeat.o(154330);
              }
            }, 300L);
          }
        }
        while ((paramAnonymousXWalkWebResourceResponse.getStatusCode() < 400) || (k.this.supportFeature(3)))
        {
          String str2;
          super.onReceivedResponseHeaders(paramAnonymousXWalkView, paramAnonymousXWalkWebResourceRequest, paramAnonymousXWalkWebResourceResponse);
          AppMethodBeat.o(154342);
          return;
        }
        Log.i("XWWebView", "onReceivedHttpError code:" + paramAnonymousXWalkWebResourceResponse.getStatusCode());
        k.this.mhR.a(k.this.MRh, new g.i(paramAnonymousXWalkWebResourceRequest), g.a(paramAnonymousXWalkWebResourceResponse));
        if (paramAnonymousXWalkWebResourceRequest.getUrl() != null) {}
        for (final String str1 = paramAnonymousXWalkWebResourceRequest.getUrl().toString();; str1 = "")
        {
          k.this.mhR.a(k.this.MRh, paramAnonymousXWalkWebResourceResponse.getStatusCode(), "", str1);
          break;
        }
      }
      
      public final void onReceivedSslError(XWalkView paramAnonymousXWalkView, ValueCallback<Boolean> paramAnonymousValueCallback, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(154337);
        Log.i("XWWebView", "onReceivedSslError " + paramAnonymousSslError.getPrimaryError());
        k.this.mhR.a(k.this.MRh, new g.h(paramAnonymousValueCallback), paramAnonymousSslError);
        AppMethodBeat.o(154337);
      }
      
      public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView paramAnonymousXWalkView, XWalkWebResourceRequest paramAnonymousXWalkWebResourceRequest)
      {
        AppMethodBeat.i(154335);
        g.i locali = new g.i(paramAnonymousXWalkWebResourceRequest);
        if (locali.MQZ == null)
        {
          paramAnonymousXWalkView = null;
          if (paramAnonymousXWalkView == null) {
            break label174;
          }
        }
        label174:
        for (paramAnonymousXWalkView = k.this.mhR.a(k.this.MRh, locali, paramAnonymousXWalkView);; paramAnonymousXWalkView = null)
        {
          Object localObject = paramAnonymousXWalkView;
          if (paramAnonymousXWalkView == null) {
            localObject = k.this.mhR.a(k.this.MRh, locali);
          }
          if (localObject == null) {}
          for (paramAnonymousXWalkView = k.this.mhR.c(k.this.MRh, paramAnonymousXWalkWebResourceRequest.getUrl().toString());; paramAnonymousXWalkView = (XWalkView)localObject)
          {
            if (paramAnonymousXWalkView != null)
            {
              paramAnonymousXWalkView = createXWalkWebResourceResponse(paramAnonymousXWalkView.mMimeType, paramAnonymousXWalkView.mEncoding, paramAnonymousXWalkView.mInputStream, paramAnonymousXWalkView.mStatusCode, paramAnonymousXWalkView.mReasonPhrase, paramAnonymousXWalkView.mResponseHeaders);
              AppMethodBeat.o(154335);
              return paramAnonymousXWalkView;
              paramAnonymousXWalkView = locali.MQZ.getBundle();
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
        if (d.bdb(paramAnonymousString))
        {
          AppMethodBeat.o(154332);
          return true;
        }
        boolean bool = k.this.mhR.a(k.this.MRh, paramAnonymousString);
        Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + bool + " url = " + paramAnonymousString);
        AppMethodBeat.o(154332);
        return bool;
      }
      
      public final boolean shouldOverrideUrlLoading(XWalkView paramAnonymousXWalkView, String paramAnonymousString, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3)
      {
        AppMethodBeat.i(154333);
        if (d.bdb(paramAnonymousString))
        {
          AppMethodBeat.o(154333);
          return true;
        }
        paramAnonymousXWalkView = new g.i(paramAnonymousString, "GET", paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean3);
        paramAnonymousBoolean1 = k.this.mhR.d(k.this.MRh, paramAnonymousXWalkView);
        AppMethodBeat.o(154333);
        return paramAnonymousBoolean1;
      }
    };
    this.MUa.MTR = this.MTR;
    this.MTS.setResourceClient(this.MTR);
    AppMethodBeat.o(154357);
  }
  
  public static boolean ht(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(154356);
      com.tencent.xweb.xwalk.updater.e.lL(paramContext);
      boolean bool = com.tencent.xweb.xwalk.updater.e.isXWalkReady();
      AppMethodBeat.o(154356);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void a(View paramView, boolean paramBoolean, com.tencent.xweb.q paramq)
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
        new ReflectMethod(localClass, "startLongScreenShot", new Class[] { View.class, Boolean.TYPE, Object.class }).invoke(new Object[] { paramView, Boolean.valueOf(paramBoolean), XWalkCoreWrapper.getInstance().getBridgeObject(new g.d(paramq)) });
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
    this.MTS.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(154382);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(154364);
    if (this.MUb)
    {
      AppMethodBeat.o(154364);
      return false;
    }
    XWalkNavigationHistory localXWalkNavigationHistory = this.MTS.getNavigationHistory();
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
    if (this.MTS.getNavigationHistory() != null)
    {
      boolean bool = this.MTS.getNavigationHistory().canGoForward();
      AppMethodBeat.o(154405);
      return bool;
    }
    AppMethodBeat.o(154405);
    return false;
  }
  
  public final void captureBitmap(final IWebView.a parama)
  {
    AppMethodBeat.i(154402);
    final View localView = ((ViewGroup)((ViewGroup)this.MTS.getChildAt(0)).getChildAt(0)).getChildAt(0);
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
    if (this.MTS.getNavigationHistory() != null) {
      this.MTS.getNavigationHistory().clear();
    }
    AppMethodBeat.o(154404);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(154388);
    this.MTS.clearMatches();
    AppMethodBeat.o(154388);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(154373);
    this.MTS.clearSslPreferences();
    AppMethodBeat.o(154373);
  }
  
  public final void clearView() {}
  
  public final WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(207578);
    q localq = new q(this.MTS.getNavigationHistory());
    AppMethodBeat.o(207578);
    return localq;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(154368);
    this.MTS.onDestroy();
    AppMethodBeat.o(154368);
  }
  
  public final void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(154369);
    if (this.MRo != null) {
      this.MRo.zW(paramBoolean);
    }
    AppMethodBeat.o(154369);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(154371);
    this.MTS.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(154371);
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(154390);
    this.MTS.findAllAsync(paramString);
    AppMethodBeat.o(154390);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(154389);
    this.MTS.findNext(paramBoolean);
    AppMethodBeat.o(154389);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(154392);
    String str = "webviewtype = xwalk, sdkver = 200901\n apkver = " + XWalkEnvironment.getAvailableVersion();
    AppMethodBeat.o(154392);
    return str;
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(154375);
    int i = this.MTS.getContentHeight();
    AppMethodBeat.o(154375);
    return i;
  }
  
  public final x getCurWebChromeClient()
  {
    return this.mhS;
  }
  
  public final ac getCurWebviewClient()
  {
    return this.mhR;
  }
  
  public final com.tencent.xweb.internal.e getDefalutOpProvider()
  {
    return this.MUa;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(154400);
    WebView.a locala = com.tencent.xweb.a.bcb(WebView.getCurStrModule());
    AppMethodBeat.o(154400);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(154386);
    WebView.b localb = new WebView.b();
    XWalkHitTestResult localXWalkHitTestResult = this.MTS.getHitTestResult();
    localb.mType = localXWalkHitTestResult.getType().ordinal();
    localb.mExtra = localXWalkHitTestResult.getExtra();
    AppMethodBeat.o(154386);
    return localb;
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207580);
    paramString1 = ad.gfI().getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(207580);
    return paramString1;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, final i parami)
  {
    AppMethodBeat.i(154413);
    boolean bool = this.MTS.getImageBitmapToFile(paramString1, paramString2, paramString3, new XWalkGetImageBitmapToFileFinishedCallback()
    {
      public final void onFinishImageBitmapToFile(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString3)
      {
        AppMethodBeat.i(154352);
        parami.cC(paramAnonymousInt1, paramAnonymousString2);
        AppMethodBeat.o(154352);
      }
    });
    AppMethodBeat.o(154413);
    return bool;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(154376);
    float f = this.MTS.getScale();
    AppMethodBeat.o(154376);
    return f;
  }
  
  public final int getScrollHeight()
  {
    AppMethodBeat.i(154418);
    int i = this.MTS.computeVerticalScrollRange();
    AppMethodBeat.o(154418);
    return i;
  }
  
  public final z getSettings()
  {
    return this.MTY;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(154387);
    String str = this.MTS.getTitle();
    AppMethodBeat.o(154387);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.MTZ;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(154383);
    String str = this.MTS.getUrl();
    AppMethodBeat.o(154383);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(154391);
    String str = "webviewType = WV_KIND_CW,V8 type=" + JsRuntime.gfe() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 200901";
    AppMethodBeat.o(154391);
    return str;
  }
  
  public final View getView()
  {
    return this.MTS;
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
    int i = this.MTS.computeVerticalScrollOffset();
    AppMethodBeat.o(154394);
    return i;
  }
  
  public final View getWebViewUI()
  {
    return this.MTS;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(154365);
    if (this.MTS.getNavigationHistory() == null)
    {
      AppMethodBeat.o(154365);
      return;
    }
    if (this.MTS.getNavigationHistory().canGoBack())
    {
      this.MTS.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
      if ((this.MTS.getNavigationHistory() != null) && (this.MTS.getNavigationHistory().getCurrentItem() != null)) {
        this.mhS.d(this.MRh, this.MTS.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
    AppMethodBeat.o(154365);
  }
  
  public final void goForward()
  {
    AppMethodBeat.i(154406);
    if (this.MTS.getNavigationHistory().canGoForward())
    {
      this.MTS.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.FORWARD, 1);
      if ((this.MTS.getNavigationHistory() != null) && (this.MTS.getNavigationHistory().getCurrentItem() != null)) {
        this.mhS.d(this.MRh, this.MTS.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
    AppMethodBeat.o(154406);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(154366);
    boolean bool = this.MTS.hasEnteredFullscreen();
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
      this.MTS.getTranslateSampleString(0);
      AppMethodBeat.o(154411);
      return null;
    }
    if (paramString.equals("translateWebSite"))
    {
      Log.i("XWWebView", "translate: do translateWebSite");
      paramBundle.getString("url");
      this.MUg = true;
      AppMethodBeat.o(154411);
      return null;
    }
    if (paramString.equals("replaceTranslatedString"))
    {
      Log.i("XWWebView", "translate: replaceTranslatedString mIsTranslateMode =" + this.MUg);
      if (!this.MUg)
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
      this.MTS.replaceTranslatedString(paramBundle);
      bool = Boolean.valueOf(bool).booleanValue();
      if ((this.MUg) && (!this.MUh))
      {
        this.MUh = true;
        Log.i("XWWebView", "getTranslateTipsView");
        paramBundle = new FrameLayout.LayoutParams(-1, 144);
        paramBundle.gravity = 51;
        localObject = new TextView(this.MRh.getContext());
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
        ((ViewGroup)this.MRh.getParent()).addView((View)localObject, paramBundle);
        ((FrameLayout.LayoutParams)this.MRh.getLayoutParams()).topMargin = 144;
        this.MRh.requestLayout();
        Log.d("XWWebView", "translate: onTranslateFinish ");
        eQO();
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
    boolean bool = this.MUj;
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
    boolean bool = this.MTS.isSupportExtendPluginForAppbrand();
    AppMethodBeat.o(154393);
    return bool;
  }
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(154367);
    this.MTS.leaveFullscreen();
    AppMethodBeat.o(154367);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(154374);
    this.MTS.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(154374);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(154378);
    this.MTS.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(154378);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(154363);
    if ((paramString != null) && (paramString.trim().startsWith("javascript:")))
    {
      this.MTS.evaluateJavascript(paramString, null);
      AppMethodBeat.o(154363);
      return;
    }
    this.MUb = false;
    this.MTS.loadUrl(paramString);
    AppMethodBeat.o(154363);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(154381);
    this.MTS.loadUrl(paramString, paramMap);
    AppMethodBeat.o(154381);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(154417);
    this.MTS.onHide();
    AppMethodBeat.o(154417);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(154399);
    this.MTS.onPause();
    AppMethodBeat.o(154399);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(154398);
    this.MTS.onResume();
    AppMethodBeat.o(154398);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(154416);
    this.MTS.onShow();
    AppMethodBeat.o(154416);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(154377);
    int i = this.MTS.getScrollBarStyle();
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
    this.MTS.reload(0);
    AppMethodBeat.o(154372);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(154384);
    this.MTS.removeJavascriptInterface(paramString);
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
    this.MTS.setBottomHeight(paramInt);
    AppMethodBeat.o(154415);
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(154361);
    this.MTS.setDownloadListener(new g.f(this.MRh.getContext(), paramDownloadListener));
    AppMethodBeat.o(154361);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(154362);
    this.MTS.setFindListener(new g.g(paramFindListener));
    AppMethodBeat.o(154362);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154409);
    this.MTS.setHorizontalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(154409);
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207579);
    ad.gfI().setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(207579);
  }
  
  public final void setJSExceptionListener(ae paramae)
  {
    this.MUf = paramae;
  }
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154408);
    this.MTS.setVerticalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(154408);
  }
  
  public final u setVideoJsCallback(v paramv)
  {
    AppMethodBeat.i(154370);
    if ((this.MRo != null) && (this.MRo.eE(paramv)))
    {
      paramv = new u()
      {
        public final void G(double paramAnonymousDouble)
        {
          AppMethodBeat.i(154349);
          if (k.d(k.this) != null) {
            k.d(k.this).G(paramAnonymousDouble);
          }
          AppMethodBeat.o(154349);
        }
        
        public final void ewR()
        {
          AppMethodBeat.i(154348);
          if (k.d(k.this) != null) {
            k.d(k.this).ewR();
          }
          AppMethodBeat.o(154348);
        }
        
        public final void gfi()
        {
          AppMethodBeat.i(154347);
          if (k.d(k.this) != null) {
            k.d(k.this).gfi();
          }
          AppMethodBeat.o(154347);
        }
        
        public final boolean gfj()
        {
          AppMethodBeat.i(207577);
          if (k.d(k.this) != null)
          {
            boolean bool = k.d(k.this).gfj();
            AppMethodBeat.o(207577);
            return bool;
          }
          AppMethodBeat.o(207577);
          return false;
        }
      };
      AppMethodBeat.o(154370);
      return paramv;
    }
    Log.i("XWWebView", "setVideoJsCallback not support");
    AppMethodBeat.o(154370);
    return null;
  }
  
  public final void setWebChromeClient(x paramx)
  {
    AppMethodBeat.i(154360);
    if (paramx == null)
    {
      this.mhS = new x();
      AppMethodBeat.o(154360);
      return;
    }
    ghA();
    this.mhS = paramx;
    AppMethodBeat.o(154360);
  }
  
  public final void setWebViewCallbackClient(ab paramab)
  {
    this.lzJ = paramab;
  }
  
  public final void setWebViewClient(ac paramac)
  {
    AppMethodBeat.i(154359);
    if (paramac == null)
    {
      this.mhR = new ac();
      this.mhR.MMT = this.MUa;
      AppMethodBeat.o(154359);
      return;
    }
    ghA();
    this.mhR = paramac;
    AppMethodBeat.o(154359);
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(154397);
    this.MUe = parama;
    this.MTS.setProxyWebViewClientExtension(this.MUd);
    AppMethodBeat.o(154397);
  }
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(154403);
    this.MTS.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(154403);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(154385);
    this.MTS.stopLoading();
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
    boolean bool = this.MTS.zoomIn();
    AppMethodBeat.o(154380);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(154379);
    boolean bool = this.MTS.zoomOut();
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
      if (k.this.MRh != null) {
        k.this.MRh.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(154353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k
 * JD-Core Version:    0.7.0.1
 */