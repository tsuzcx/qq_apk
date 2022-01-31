package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView.FindListener;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.jg.JgClassChecked;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.a;
import com.tencent.xweb.c.h;
import com.tencent.xweb.g;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.q;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

@JgClassChecked(author=30, fComment="checked", lastDate="20171020", reviewer=30, vComment={com.jg.EType.JSEXECUTECHECK})
public final class e
  implements h
{
  private WebViewClient bhV = new e.1(this);
  private WebChromeClient bhW = new SysWebView.1(this);
  WebView xjP;
  e.a xjQ;
  p xjR;
  j xjS;
  d xjT;
  f xjU;
  long xjV = 0L;
  com.tencent.xweb.extension.video.b xjW;
  e.b xjX;
  final String xjY = "xwalkTempCallBack";
  
  public e(WebView paramWebView)
  {
    this.xjP = paramWebView;
    this.xjQ = new e.a(this, paramWebView.getContext());
    this.xjQ.setBackgroundColor(0);
    getSettings();
    this.xjT = new d(this.xjQ);
    this.xjQ.setWebChromeClient(this.bhW);
    this.xjQ.setWebViewClient(this.bhV);
    if (Build.VERSION.SDK_INT < 19)
    {
      this.xjX = new e.b();
      this.xjQ.addJavascriptInterface(this.xjX, "xwalkTempCallBack");
    }
    if ((paramWebView.getContext() instanceof Activity))
    {
      al((Activity)paramWebView.getContext());
      return;
    }
    al(null);
  }
  
  private void al(Activity paramActivity)
  {
    Log.i("SysWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + paramActivity);
    if (getFullscreenVideoKind() == WebView.a.xhj) {}
    do
    {
      return;
      this.xjW = com.tencent.xweb.extension.video.e.a(paramActivity, this.xjP, this.xjQ, com.tencent.xweb.extension.video.d.cSz());
    } while (getFullscreenVideoKind() != WebView.a.xhl);
    this.xjW.cv(this.xjQ);
  }
  
  @SuppressLint({"JavascriptInterface"})
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.xjQ.addJavascriptInterface(paramObject, paramString);
  }
  
  public final boolean canGoBack()
  {
    return this.xjQ.canGoBack();
  }
  
  public final void clearMatches()
  {
    this.xjQ.clearMatches();
  }
  
  public final void clearSslPreferences()
  {
    this.xjQ.clearSslPreferences();
  }
  
  public final void clearView()
  {
    this.xjQ.clearView();
  }
  
  public final void destroy()
  {
    this.xjQ.destroy();
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramString == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.xjQ.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    if (paramValueCallback == null)
    {
      this.xjQ.loadUrl(paramString);
      return;
    }
    String str = paramString;
    if (paramString.trim().startsWith("javascript:")) {
      str = paramString.replaceFirst("javascript:", "");
    }
    if (this.xjX == null)
    {
      this.xjX = new e.b();
      this.xjQ.addJavascriptInterface(this.xjX, "xwalkTempCallBack");
    }
    e.b localb = this.xjX;
    if (paramValueCallback != null)
    {
      paramString = new StringBuilder();
      int i = localb.xkb;
      localb.xkb = (i + 1);
      paramString = i;
      localb.xka.put(paramString, paramValueCallback);
    }
    for (;;)
    {
      paramString = "javascript:xwalkTempCallBack.notifyJava(" + paramString + ", " + str + ")";
      this.xjQ.loadUrl(paramString);
      return;
      paramString = "";
    }
  }
  
  public final void findAllAsync(String paramString)
  {
    this.xjQ.findAllAsync(paramString);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    this.xjQ.findNext(paramBoolean);
  }
  
  public final String getAbstractInfo()
  {
    return getVersionInfo();
  }
  
  public final int getContentHeight()
  {
    return this.xjQ.getContentHeight();
  }
  
  public final j getCurWebChromeClient()
  {
    return this.xjS;
  }
  
  public final p getCurWebviewClient()
  {
    return this.xjR;
  }
  
  public final com.tencent.xweb.c.f getDefalutOpProvider()
  {
    return this.xjT;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    return a.agN(WebView.getCurStrModule());
  }
  
  public final WebView.b getHitTestResult()
  {
    WebView.HitTestResult localHitTestResult = this.xjQ.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.mType = localHitTestResult.getType();
    localb.mExtra = localHitTestResult.getExtra();
    return localb;
  }
  
  public final float getScale()
  {
    return this.xjQ.getScale();
  }
  
  public final n getSettings()
  {
    if (this.xjU != null) {
      return this.xjU;
    }
    if (this.xjQ == null) {
      return null;
    }
    this.xjU = new f(this.xjQ);
    return this.xjU;
  }
  
  public final String getTitle()
  {
    return this.xjQ.getTitle();
  }
  
  public final ViewGroup getTopView()
  {
    return this.xjQ;
  }
  
  public final String getUrl()
  {
    return this.xjQ.getUrl();
  }
  
  public final String getVersionInfo()
  {
    return "webviewtype = WV_KIND_SYS, V8 type=" + g.cSi();
  }
  
  public final View getView()
  {
    return this.xjQ;
  }
  
  public final int getVisibleTitleHeight()
  {
    Object localObject = com.tencent.xweb.util.d.c(this.xjQ, "getVisibleTitleHeight", null, new Object[0]);
    if (localObject == null) {
      return 0;
    }
    return ((Integer)localObject).intValue();
  }
  
  public final int getWebScrollX()
  {
    return getWebViewUI().getScrollX();
  }
  
  public final int getWebScrollY()
  {
    return this.xjQ.getScrollY();
  }
  
  public final View getWebViewUI()
  {
    return this.xjQ;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    this.xjQ.goBack();
  }
  
  public final boolean hasEnteredFullscreen()
  {
    if (this.xjW == null) {
      return false;
    }
    return this.xjW.hasEnteredFullscreen();
  }
  
  public final boolean isOverScrollStart()
  {
    return getWebViewUI().getScrollY() == 0;
  }
  
  public final boolean isSupportExtendPluginForAppbrand()
  {
    return false;
  }
  
  public final void leaveFullscreen()
  {
    if (this.bhW != null) {
      this.bhW.onHideCustomView();
    }
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.xjQ.loadData(paramString1, paramString2, paramString3);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.xjQ.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final void loadUrl(String paramString)
  {
    this.xjQ.loadUrl(paramString);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    this.xjQ.loadUrl(paramString, paramMap);
  }
  
  public final void onPause()
  {
    this.xjQ.onPause();
  }
  
  public final void onResume()
  {
    this.xjQ.onResume();
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    return this.xjQ.overlayHorizontalScrollbar();
  }
  
  public final void reload()
  {
    this.xjQ.reload();
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    this.xjQ.removeJavascriptInterface(paramString);
  }
  
  public final boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.xjQ.setDownloadListener(paramDownloadListener);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    this.xjQ.setFindListener(paramFindListener);
  }
  
  public final void setJSExceptionListener(q paramq) {}
  
  public final void setWebChromeClient(j paramj)
  {
    this.xjS = paramj;
  }
  
  public final void setWebViewCallbackClient(o paramo)
  {
    if (this.xjQ != null) {
      this.xjQ.gGh = paramo;
    }
  }
  
  public final void setWebViewClient(p paramp)
  {
    this.xjR = paramp;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b paramb) {}
  
  public final void stopLoading()
  {
    this.xjQ.stopLoading();
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
    return this.xjQ.zoomIn();
  }
  
  public final boolean zoomOut()
  {
    return this.xjQ.zoomOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.sys.e
 * JD-Core Version:    0.7.0.1
 */