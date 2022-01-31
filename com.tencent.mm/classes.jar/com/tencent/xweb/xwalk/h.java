package com.tencent.xweb.xwalk;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.a;
import com.tencent.xweb.extension.video.e;
import com.tencent.xweb.g;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.q;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkHitTestResult.type;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkNavigationItem;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class h
  implements com.tencent.xweb.c.h, com.tencent.xweb.c.i
{
  static int xmh = 0;
  o gGh;
  p gIG = new p();
  com.tencent.xweb.j gVg = new com.tencent.xweb.j();
  int mApkVersion = XWalkEnvironment.getAvailableVersion();
  private int type = 0;
  WebView xjP;
  long xjV = 0L;
  private com.tencent.xweb.extension.video.b xjW;
  j xlU;
  k xlV;
  XWalkView xlW;
  i xma;
  AbsoluteLayout xmb;
  f xmc;
  boolean xmd = false;
  private String xme = null;
  private com.tencent.xweb.x5.a.a.a.a.b xmf = new com.tencent.xweb.x5.a.a.a.a.b();
  private q xmg = null;
  private boolean xmi = false;
  
  public h(WebView paramWebView)
  {
    XWalkContextWrapper localXWalkContextWrapper = new XWalkContextWrapper(paramWebView.getContext(), this.mApkVersion);
    XWalkLibraryLoader.prepareToInit(localXWalkContextWrapper);
    try
    {
      XWalkPreferences.setValue("xweb-version", String.valueOf(this.mApkVersion));
      XWalkPreferences.setValue("xwebsdk-version", "180801");
      this.xlW = new h.a(this, localXWalkContextWrapper);
      this.xlW.setBackgroundColor(0);
      this.xmb = new AbsoluteLayout(localXWalkContextWrapper);
      this.xlW.getXWalkContentView().addView(this.xmb);
      this.xlW.setCustomOnScrollChangedListener(new h.3(this));
      this.xlW.setCustomOnOverScrolledListener(new h.4(this));
      this.xmc = new f(this.xlW);
      this.xjP = paramWebView;
      this.xma = new i(this.xlW);
      this.xlW.getSettings().SetLogCallBack(new h.5(this));
      this.xlW.getSettings().SetJSExceptionCallBack(new h.6(this));
      paramWebView = ip(paramWebView.getContext());
      Log.i("XWWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + paramWebView);
      this.xjW = e.a(paramWebView, this.xjP, this.xlW, com.tencent.xweb.extension.video.d.cSz());
      if (getFullscreenVideoKind() == WebView.a.xhl) {
        this.xjW.cv(this.xlW);
      }
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
  
  private void cTD()
  {
    if (this.xlU != null) {
      return;
    }
    this.xlU = new h.1(this, this.xlW);
    this.xmc.xlU = this.xlU;
    this.xlW.setUIClient(this.xlU);
    this.xlV = new h.2(this, this.xlW);
    this.xmc.xlV = this.xlV;
    this.xlW.setResourceClient(this.xlV);
  }
  
  public static boolean eL(Context paramContext)
  {
    try
    {
      com.tencent.xweb.xwalk.a.d.ir(paramContext);
      boolean bool = com.tencent.xweb.xwalk.a.d.isXWalkReady();
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static Activity ip(Context paramContext)
  {
    for (;;)
    {
      if ((paramContext instanceof Activity)) {
        return (Activity)paramContext;
      }
      if (!(paramContext instanceof ContextWrapper)) {
        break label39;
      }
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext == paramContext) {
        break;
      }
      paramContext = localContext;
    }
    return null;
    label39:
    return null;
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.xlW.addJavascriptInterface(paramObject, paramString);
  }
  
  public final boolean canGoBack()
  {
    return (!this.xmd) && (this.xlW.getNavigationHistory().canGoBack());
  }
  
  public final void clearMatches()
  {
    this.xlW.clearMatches();
  }
  
  public final void clearSslPreferences()
  {
    this.xlW.clearSslPreferences();
  }
  
  public final void clearView() {}
  
  public final void destroy()
  {
    this.xlW.onDestroy();
  }
  
  public final void ea(String paramString, int paramInt)
  {
    if (XWalkCoreWrapper.getInstance().hasFeature(0)) {
      try
      {
        Object localObject = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
        if (localObject == null) {
          return;
        }
        localObject = new ReflectMethod((Class)localObject, "setProfileConfig", new Class[] { Bundle.class });
        Bundle localBundle = new Bundle();
        localBundle.putString("enabledTraceCategory", paramString);
        localBundle.putInt("traceSampleRatio", paramInt);
        ((ReflectMethod)localObject).invoke(new Object[] { localBundle });
        return;
      }
      catch (Exception paramString)
      {
        Log.e("XWWebView", "setProfileConfig reflect failed");
      }
    }
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.xlW.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public final void findAllAsync(String paramString)
  {
    this.xlW.findAllAsync(paramString);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    this.xlW.findNext(paramBoolean);
  }
  
  public final String getAbstractInfo()
  {
    return "webviewtype = xwalk, sdkver = 180801\n apkver = " + XWalkEnvironment.getAvailableVersion();
  }
  
  public final int getContentHeight()
  {
    return this.xlW.getContentHeight();
  }
  
  public final com.tencent.xweb.j getCurWebChromeClient()
  {
    return this.gVg;
  }
  
  public final p getCurWebviewClient()
  {
    return this.gIG;
  }
  
  public final com.tencent.xweb.c.f getDefalutOpProvider()
  {
    return this.xmc;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    return a.agN(WebView.getCurStrModule());
  }
  
  public final WebView.b getHitTestResult()
  {
    WebView.b localb = new WebView.b();
    XWalkHitTestResult localXWalkHitTestResult = this.xlW.getHitTestResult();
    localb.mType = localXWalkHitTestResult.getType().ordinal();
    localb.mExtra = localXWalkHitTestResult.getExtra();
    return localb;
  }
  
  public final float getScale()
  {
    return this.xlW.getScale();
  }
  
  public final n getSettings()
  {
    return this.xma;
  }
  
  public final String getTitle()
  {
    return this.xlW.getTitle();
  }
  
  public final ViewGroup getTopView()
  {
    return this.xmb;
  }
  
  public final String getUrl()
  {
    return this.xlW.getUrl();
  }
  
  public final String getVersionInfo()
  {
    return "webviewType = WV_KIND_CW,V8 type=" + g.cSi() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 180801";
  }
  
  public final View getView()
  {
    return this.xlW;
  }
  
  public final int getVisibleTitleHeight()
  {
    return 0;
  }
  
  public final int getWebScrollX()
  {
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView)) {
      return ((XWalkView)localView).computeHorizontalScrollOffset();
    }
    return localView.getScrollX();
  }
  
  public final int getWebScrollY()
  {
    return this.xlW.computeVerticalScrollOffset();
  }
  
  public final View getWebViewUI()
  {
    return this.xlW;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    if (this.xlW.getNavigationHistory().canGoBack())
    {
      this.xlW.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
      if ((this.xlW.getNavigationHistory() != null) && (this.xlW.getNavigationHistory().getCurrentItem() != null)) {
        this.gVg.d(this.xjP, this.xlW.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return this.xlW.hasEnteredFullscreen();
  }
  
  public final boolean isOverScrollStart()
  {
    boolean bool = this.xmi;
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView)) {}
    for (int i = ((XWalkView)localView).computeVerticalScrollOffset(); (i == 0) && (bool); i = localView.getScrollY()) {
      return true;
    }
    return false;
  }
  
  public final boolean isSupportExtendPluginForAppbrand()
  {
    return this.xlW.isSupportExtendPluginForAppbrand();
  }
  
  public final void leaveFullscreen()
  {
    this.xlW.leaveFullscreen();
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.xlW.loadData(paramString1, paramString2, paramString3);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.xlW.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final void loadUrl(String paramString)
  {
    if ((paramString != null) && (paramString.trim().startsWith("javascript:")))
    {
      this.xlW.evaluateJavascript(paramString, null);
      return;
    }
    this.xmd = false;
    this.xlW.loadUrl(paramString);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    this.xlW.loadUrl(paramString, paramMap);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final boolean overlayHorizontalScrollbar()
  {
    int i = this.xlW.getScrollBarStyle();
    return (i == 0) || (i == 33554432);
  }
  
  public final void reload()
  {
    this.xlW.reload(0);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    this.xlW.removeJavascriptInterface(paramString);
  }
  
  public final boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView)) {
      return ((XWalkView)localView).savePage(paramString1, paramString2, paramInt);
    }
    return false;
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.xlW.setDownloadListener(new e.e(this.xjP.getContext(), paramDownloadListener));
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    this.xlW.setFindListener(new e.f(paramFindListener));
  }
  
  public final void setJSExceptionListener(q paramq)
  {
    this.xmg = paramq;
  }
  
  public final void setWebChromeClient(com.tencent.xweb.j paramj)
  {
    if (paramj == null)
    {
      this.gVg = new com.tencent.xweb.j();
      return;
    }
    cTD();
    this.gVg = paramj;
  }
  
  public final void setWebViewCallbackClient(o paramo)
  {
    this.gGh = paramo;
  }
  
  public final void setWebViewClient(p paramp)
  {
    if (paramp == null)
    {
      this.gIG = new p();
      this.gIG.xgI = this.xmc;
      return;
    }
    cTD();
    this.gIG = paramp;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b paramb)
  {
    this.xmf = paramb;
  }
  
  public final void stopLoading()
  {
    this.xlW.stopLoading();
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
  
  public final boolean zoomIn()
  {
    return this.xlW.zoomIn();
  }
  
  public final boolean zoomOut()
  {
    return this.xlW.zoomOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h
 * JD-Core Version:    0.7.0.1
 */