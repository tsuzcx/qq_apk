package com.tencent.xweb.internal;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.i;
import com.tencent.xweb.t;
import com.tencent.xweb.u;
import com.tencent.xweb.w;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import com.tencent.xweb.y;
import java.util.Map;

public abstract interface IWebView
{
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract boolean canGoBack();
  
  public abstract boolean canGoForward();
  
  public abstract void captureBitmap(a parama);
  
  public abstract void clearHistory();
  
  public abstract void clearMatches();
  
  public abstract void clearSslPreferences();
  
  public abstract void clearView();
  
  public abstract WebBackForwardList copyBackForwardList();
  
  public abstract void destroy();
  
  public abstract void disableVideoJsCallback(boolean paramBoolean);
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void findAllAsync(String paramString);
  
  public abstract void findNext(boolean paramBoolean);
  
  public abstract String getAbstractInfo();
  
  public abstract int getContentHeight();
  
  public abstract w getCurWebChromeClient();
  
  public abstract ab getCurWebviewClient();
  
  public abstract e getDefalutOpProvider();
  
  public abstract WebView.a getFullscreenVideoKind();
  
  public abstract WebView.b getHitTestResult();
  
  public abstract boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, i parami);
  
  public abstract float getScale();
  
  public abstract int getScrollHeight();
  
  public abstract y getSettings();
  
  public abstract String getTitle();
  
  public abstract ViewGroup getTopView();
  
  public abstract String getUrl();
  
  public abstract String getVersionInfo();
  
  public abstract View getView();
  
  public abstract int getVisibleTitleHeight();
  
  public abstract int getWebScrollX();
  
  public abstract int getWebScrollY();
  
  public abstract View getWebViewUI();
  
  public abstract Object getX5WebViewExtension();
  
  public abstract void goBack();
  
  public abstract void goForward();
  
  public abstract boolean hasEnteredFullscreen();
  
  public abstract Bundle invokeMiscMethod(String paramString, Bundle paramBundle);
  
  public abstract boolean isOverScrollStart();
  
  public abstract boolean isSupportExtendPluginForAppbrand();
  
  public abstract void leaveFullscreen();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  @TargetApi(8)
  public abstract void loadUrl(String paramString, Map<String, String> paramMap);
  
  public abstract void onHide();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onShow();
  
  public abstract boolean overlayHorizontalScrollbar();
  
  public abstract void reload();
  
  public abstract void removeJavascriptInterface(String paramString);
  
  public abstract boolean savePage(String paramString1, String paramString2, int paramInt);
  
  public abstract void setBottomHeight(int paramInt);
  
  public abstract void setDownloadListener(DownloadListener paramDownloadListener);
  
  public abstract void setFindListener(WebView.FindListener paramFindListener);
  
  public abstract void setHorizontalScrollBarEnabled(boolean paramBoolean);
  
  public abstract void setJSExceptionListener(ac paramac);
  
  public abstract void setVerticalScrollBarEnabled(boolean paramBoolean);
  
  public abstract t setVideoJsCallback(u paramu);
  
  public abstract void setWebChromeClient(w paramw);
  
  public abstract void setWebViewCallbackClient(aa paramaa);
  
  public abstract void setWebViewClient(ab paramab);
  
  public abstract void setWebViewClientExtension(a parama);
  
  public abstract void smoothScroll(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void stopLoading();
  
  public abstract void super_computeScroll();
  
  public abstract boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean super_onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean);
  
  public abstract boolean supportFeature(int paramInt);
  
  public abstract boolean zoomIn();
  
  public abstract boolean zoomOut();
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.IWebView
 * JD-Core Version:    0.7.0.1
 */