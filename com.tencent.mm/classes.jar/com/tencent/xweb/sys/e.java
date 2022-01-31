package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.a;
import com.tencent.xweb.c.i;
import com.tencent.xweb.c.i.a;
import com.tencent.xweb.g;
import com.tencent.xweb.k;
import com.tencent.xweb.p;
import com.tencent.xweb.t;
import com.tencent.xweb.v;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author=30, fComment="checked", lastDate="20171020", reviewer=30, vComment={com.jg.EType.JSEXECUTECHECK})
public final class e
  implements i
{
  com.tencent.xweb.extension.video.b BHA;
  e.b BHB;
  final String BHC;
  WebView BHt;
  e.a BHu;
  w BHv;
  p BHw;
  d BHx;
  f BHy;
  long BHz;
  private WebViewClient byv;
  private WebChromeClient byw;
  
  public e(WebView paramWebView)
  {
    AppMethodBeat.i(84701);
    this.BHz = 0L;
    this.byw = new SysWebView.1(this);
    this.byv = new e.1(this);
    this.BHC = "xwalkTempCallBack";
    this.BHt = paramWebView;
    this.BHu = new e.a(this, paramWebView.getContext());
    this.BHu.setBackgroundColor(0);
    getSettings();
    this.BHx = new d(this.BHu);
    this.BHu.setWebChromeClient(this.byw);
    this.BHu.setWebViewClient(this.byv);
    if (Build.VERSION.SDK_INT < 19)
    {
      this.BHB = new e.b();
      this.BHu.addJavascriptInterface(this.BHB, "xwalkTempCallBack");
    }
    if ((paramWebView.getContext() instanceof Activity))
    {
      aP((Activity)paramWebView.getContext());
      AppMethodBeat.o(84701);
      return;
    }
    aP(null);
    AppMethodBeat.o(84701);
  }
  
  private void aP(Activity paramActivity)
  {
    AppMethodBeat.i(84702);
    Log.i("SysWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + paramActivity);
    if (getFullscreenVideoKind() == WebView.a.BEl)
    {
      AppMethodBeat.o(84702);
      return;
    }
    this.BHA = com.tencent.xweb.extension.video.e.a(paramActivity, this.BHt, this.BHu, com.tencent.xweb.extension.video.d.dYG());
    if (getFullscreenVideoKind() == WebView.a.BEn) {
      this.BHA.da(this.BHu);
    }
    AppMethodBeat.o(84702);
  }
  
  @SuppressLint({"JavascriptInterface"})
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(84725);
    this.BHu.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(84725);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(84707);
    boolean bool = this.BHu.canGoBack();
    AppMethodBeat.o(84707);
    return bool;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(84743);
    boolean bool = this.BHu.canGoForward();
    AppMethodBeat.o(84743);
    return bool;
  }
  
  public final void captureBitmap(final i.a parama)
  {
    AppMethodBeat.i(139550);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139548);
        int i = e.this.BHu.getHeight();
        Canvas localCanvas = new Canvas(Bitmap.createBitmap(e.this.BHu.getWidth(), i, Bitmap.Config.ARGB_8888));
        e.this.BHu.draw(localCanvas);
        Log.d("SysWebView", "bitmapCaptureFinished");
        AppMethodBeat.o(139548);
      }
    }).start();
    AppMethodBeat.o(139550);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(84742);
    this.BHu.clearHistory();
    AppMethodBeat.o(84742);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(84731);
    this.BHu.clearMatches();
    AppMethodBeat.o(84731);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(84715);
    this.BHu.clearSslPreferences();
    AppMethodBeat.o(84715);
  }
  
  public final void clearView()
  {
    AppMethodBeat.i(84711);
    this.BHu.clearView();
    AppMethodBeat.o(84711);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(84712);
    this.BHu.destroy();
    AppMethodBeat.o(84712);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(84713);
    if (paramString == null)
    {
      AppMethodBeat.o(84713);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.BHu.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(84713);
      return;
    }
    if (paramValueCallback == null)
    {
      this.BHu.loadUrl(paramString);
      AppMethodBeat.o(84713);
      return;
    }
    String str = paramString;
    if (paramString.trim().startsWith("javascript:")) {
      str = paramString.replaceFirst("javascript:", "");
    }
    if (this.BHB == null)
    {
      this.BHB = new e.b();
      this.BHu.addJavascriptInterface(this.BHB, "xwalkTempCallBack");
    }
    e.b localb = this.BHB;
    if (paramValueCallback != null)
    {
      paramString = new StringBuilder();
      int i = localb.BHG;
      localb.BHG = (i + 1);
      paramString = i;
      localb.BHF.put(paramString, paramValueCallback);
    }
    for (;;)
    {
      paramString = "javascript:xwalkTempCallBack.notifyJava(" + paramString + ", " + str + ")";
      this.BHu.loadUrl(paramString);
      AppMethodBeat.o(84713);
      return;
      paramString = "";
    }
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(84733);
    this.BHu.findAllAsync(paramString);
    AppMethodBeat.o(84733);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(84732);
    this.BHu.findNext(paramBoolean);
    AppMethodBeat.o(84732);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(84735);
    String str = getVersionInfo();
    AppMethodBeat.o(84735);
    return str;
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(84717);
    int i = this.BHu.getContentHeight();
    AppMethodBeat.o(84717);
    return i;
  }
  
  public final p getCurWebChromeClient()
  {
    return this.BHw;
  }
  
  public final w getCurWebviewClient()
  {
    return this.BHv;
  }
  
  public final com.tencent.xweb.c.f getDefalutOpProvider()
  {
    return this.BHx;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(84741);
    WebView.a locala = a.axJ(WebView.getCurStrModule());
    AppMethodBeat.o(84741);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(84729);
    WebView.HitTestResult localHitTestResult = this.BHu.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.mType = localHitTestResult.getType();
    localb.mExtra = localHitTestResult.getExtra();
    AppMethodBeat.o(84729);
    return localb;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, g paramg)
  {
    return false;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(84718);
    float f = this.BHu.getScale();
    AppMethodBeat.o(84718);
    return f;
  }
  
  public final t getSettings()
  {
    AppMethodBeat.i(84703);
    if (this.BHy != null)
    {
      localf = this.BHy;
      AppMethodBeat.o(84703);
      return localf;
    }
    if (this.BHu == null)
    {
      AppMethodBeat.o(84703);
      return null;
    }
    this.BHy = new f(this.BHu);
    f localf = this.BHy;
    AppMethodBeat.o(84703);
    return localf;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(84730);
    String str = this.BHu.getTitle();
    AppMethodBeat.o(84730);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.BHu;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(84726);
    String str = this.BHu.getUrl();
    AppMethodBeat.o(84726);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(84734);
    String str = "webviewtype = WV_KIND_SYS, version = " + XWalkEnvironment.getChromiunVersion() + ", V8 type=" + k.dYk();
    AppMethodBeat.o(84734);
    return str;
  }
  
  public final View getView()
  {
    return this.BHu;
  }
  
  public final int getVisibleTitleHeight()
  {
    AppMethodBeat.i(84719);
    Object localObject = com.tencent.xweb.util.e.o(this.BHu, "getVisibleTitleHeight");
    if (localObject == null)
    {
      AppMethodBeat.o(84719);
      return 0;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(84719);
    return i;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(84737);
    int i = getWebViewUI().getScrollX();
    AppMethodBeat.o(84737);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(84736);
    int i = this.BHu.getScrollY();
    AppMethodBeat.o(84736);
    return i;
  }
  
  public final View getWebViewUI()
  {
    return this.BHu;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(84708);
    this.BHu.goBack();
    AppMethodBeat.o(84708);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(84709);
    if (this.BHA == null)
    {
      AppMethodBeat.o(84709);
      return false;
    }
    boolean bool = this.BHA.hasEnteredFullscreen();
    AppMethodBeat.o(84709);
    return bool;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(139549);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.d("SysWebView", " method string is null or empty");
      AppMethodBeat.o(139549);
      return null;
    }
    if (paramString.equals("supportTranslateWebSite"))
    {
      paramString = new Bundle();
      paramString.putBoolean("result", false);
      Log.i("SysWebView", "sys web is not supportTranslateWebSite");
      AppMethodBeat.o(139549);
      return paramString;
    }
    AppMethodBeat.o(139549);
    return null;
  }
  
  public final boolean isOverScrollStart()
  {
    AppMethodBeat.i(84738);
    if (getWebViewUI().getScrollY() == 0)
    {
      AppMethodBeat.o(84738);
      return true;
    }
    AppMethodBeat.o(84738);
    return false;
  }
  
  public final boolean isSupportExtendPluginForAppbrand()
  {
    return false;
  }
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(84710);
    if (this.byw != null) {
      this.byw.onHideCustomView();
    }
    AppMethodBeat.o(84710);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(84716);
    this.BHu.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(84716);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(84721);
    this.BHu.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(84721);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(84706);
    this.BHu.loadUrl(paramString);
    AppMethodBeat.o(84706);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(84724);
    this.BHu.loadUrl(paramString, paramMap);
    AppMethodBeat.o(84724);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(84740);
    this.BHu.onPause();
    AppMethodBeat.o(84740);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(84739);
    this.BHu.onResume();
    AppMethodBeat.o(84739);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(84720);
    boolean bool = this.BHu.overlayHorizontalScrollbar();
    AppMethodBeat.o(84720);
    return bool;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(84714);
    this.BHu.reload();
    AppMethodBeat.o(84714);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(84727);
    this.BHu.removeJavascriptInterface(paramString);
    AppMethodBeat.o(84727);
  }
  
  public final boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(84704);
    this.BHu.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(84704);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(84705);
    this.BHu.setFindListener(paramFindListener);
    AppMethodBeat.o(84705);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(84745);
    this.BHu.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(84745);
  }
  
  public final void setJSExceptionListener(x paramx) {}
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(84744);
    this.BHu.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(84744);
  }
  
  public final void setWebChromeClient(p paramp)
  {
    this.BHw = paramp;
  }
  
  public final void setWebViewCallbackClient(v paramv)
  {
    if (this.BHu != null) {
      this.BHu.igO = paramv;
    }
  }
  
  public final void setWebViewClient(w paramw)
  {
    this.BHv = paramw;
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b paramb) {}
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong) {}
  
  public final void stopLoading()
  {
    AppMethodBeat.i(84728);
    this.BHu.stopLoading();
    AppMethodBeat.o(84728);
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
    return false;
  }
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(84723);
    boolean bool = this.BHu.zoomIn();
    AppMethodBeat.o(84723);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(84722);
    boolean bool = this.BHu.zoomOut();
    AppMethodBeat.o(84722);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.sys.e
 * JD-Core Version:    0.7.0.1
 */