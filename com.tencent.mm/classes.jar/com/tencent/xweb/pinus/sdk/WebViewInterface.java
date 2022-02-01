package com.tencent.xweb.pinus.sdk;

import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import java.util.Map;

public abstract interface WebViewInterface
{
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract boolean canGoBack();
  
  public abstract boolean canGoBackOrForward(int paramInt);
  
  public abstract boolean canGoForward();
  
  public abstract void clearCache(boolean paramBoolean);
  
  public abstract void clearFormData();
  
  public abstract void clearHistory();
  
  public abstract void clearMatches();
  
  public abstract void clearSslPreferences();
  
  public abstract void clearView();
  
  public abstract WebBackForwardList copyBackForwardList();
  
  public abstract PrintDocumentAdapter createPrintDocumentAdapter(String paramString);
  
  public abstract void destroy();
  
  public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void documentHasImages(Message paramMessage);
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void findAllAsync(String paramString);
  
  public abstract void findNext(boolean paramBoolean);
  
  public abstract void flingScroll(int paramInt1, int paramInt2);
  
  public abstract AccessibilityNodeProvider getAccessibilityNodeProvider();
  
  public abstract SslCertificate getCertificate();
  
  public abstract int getContentHeight();
  
  public abstract ViewGroup getContentView();
  
  public abstract Bitmap getFavicon();
  
  public abstract Object getHitTestResultInner();
  
  public abstract boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, Object paramObject);
  
  public abstract String getOriginalUrl();
  
  public abstract int getProgress();
  
  public abstract float getScale();
  
  public abstract Object getSettingsInner();
  
  public abstract String getTitle();
  
  public abstract void getTranslateSampleString(int paramInt);
  
  public abstract String getUrl();
  
  public abstract void goBack();
  
  public abstract void goBackOrForward(int paramInt);
  
  public abstract void goForward();
  
  public abstract void invokeZoomPicker();
  
  public abstract boolean isPrivateBrowsingEnabled();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void loadUrl(String paramString, Map<String, String> paramMap);
  
  public abstract boolean onCheckIsTextEditor();
  
  public abstract void onExtendTextAreaKeyboardHeightChanged(boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract void onHide();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onShow();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean pageDown(boolean paramBoolean);
  
  public abstract boolean pageUp(boolean paramBoolean);
  
  public abstract void pauseTimers();
  
  public abstract void postUrl(String paramString, byte[] paramArrayOfByte);
  
  public abstract void reload();
  
  public abstract void removeJavascriptInterface(String paramString);
  
  public abstract void replaceTranslatedString(Map<String, String> paramMap);
  
  public abstract void requestFocusNodeHref(Message paramMessage);
  
  public abstract void requestImageRef(Message paramMessage);
  
  public abstract WebBackForwardList restoreState(Bundle paramBundle);
  
  public abstract void resumeTimers();
  
  public abstract boolean savePage(String paramString1, String paramString2, int paramInt);
  
  public abstract WebBackForwardList saveState(Bundle paramBundle);
  
  public abstract void saveWebArchive(String paramString);
  
  public abstract void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setBottomHeight(int paramInt);
  
  public abstract void setDownloadListener(DownloadListener paramDownloadListener);
  
  public abstract void setExtendPluginClient(Object paramObject);
  
  public abstract void setExtendTextAreaClient(Object paramObject);
  
  public abstract void setFindListener(WebView.FindListener paramFindListener);
  
  public abstract void setHorizontalScrollBarEnable(boolean paramBoolean);
  
  public abstract void setInitialScale(int paramInt);
  
  public abstract void setNetworkAvailable(boolean paramBoolean);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2);
  
  public abstract void setProxyWebViewClientExtension(Object paramObject);
  
  public abstract void setTranslateMode(boolean paramBoolean);
  
  public abstract void setVerticalScrollBarEnable(boolean paramBoolean);
  
  public abstract void setWebChromeClient(Object paramObject);
  
  public abstract void setWebContentsDebuggingEnabled(boolean paramBoolean);
  
  public abstract void setWebContentsSize(int paramInt1, int paramInt2);
  
  public abstract void setWebViewClient(Object paramObject);
  
  public abstract void smoothScroll(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void stopLoading();
  
  public abstract void takePluginScreenshot(String paramString, int paramInt);
  
  public abstract int view_computeHorizontalScrollOffset();
  
  public abstract int view_computeHorizontalScrollRange();
  
  public abstract int view_computeVerticalScrollExtent();
  
  public abstract int view_computeVerticalScrollOffset();
  
  public abstract int view_computeVerticalScrollRange();
  
  public abstract void view_scrollBy(int paramInt1, int paramInt2);
  
  public abstract void view_scrollTo(int paramInt1, int paramInt2);
  
  public abstract void zoomBy(float paramFloat);
  
  public abstract boolean zoomIn();
  
  public abstract boolean zoomOut();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebViewInterface
 * JD-Core Version:    0.7.0.1
 */