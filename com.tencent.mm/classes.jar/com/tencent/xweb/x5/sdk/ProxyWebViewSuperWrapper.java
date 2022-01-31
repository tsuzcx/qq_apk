package com.tencent.xweb.x5.sdk;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.f;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.x5.a.c;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.a.a.a.a.b;
import com.tencent.xweb.x5.g;
import com.tencent.xweb.x5.g.b;
import com.tencent.xweb.x5.g.f;
import org.xwalk.core.Log;

public class ProxyWebViewSuperWrapper
  extends ProxyWebViewClientExtension
  implements com.tencent.xweb.x5.a.a.a.a.a
{
  b mXWebProxyImp;
  
  public ProxyWebViewSuperWrapper() {}
  
  public ProxyWebViewSuperWrapper(b paramb)
  {
    this.mXWebProxyImp = paramb;
    this.mXWebProxyImp.xkQ = this;
  }
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      return localb.xkQ.super_allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void computeScroll(View paramView)
  {
    this.mXWebProxyImp.computeScroll(paramView);
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_didFirstVisuallyNonEmptyPaint();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.mXWebProxyImp.dispatchTouchEvent(paramMotionEvent, paramView);
  }
  
  public void documentAvailableInMainFrame()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_documentAvailableInMainFrame();
    }
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    }
  }
  
  public void hasDiscardCurrentPage(boolean paramBoolean)
  {
    this.mXWebProxyImp.hasDiscardCurrentPage(paramBoolean);
  }
  
  public void hideAddressBar()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_hideAddressBar();
    }
  }
  
  public void invalidate() {}
  
  public boolean notifyAutoAudioPlay(String paramString, JsResult paramJsResult)
  {
    b localb = this.mXWebProxyImp;
    paramJsResult = new g.f(paramJsResult);
    if (localb.xkQ != null) {
      return localb.xkQ.super_notifyAutoAudioPlay(paramString, paramJsResult);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public boolean notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      return localb.xkQ.super_notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void onDoubleTapStart()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onDoubleTapStart();
    }
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onFlingScrollEnd()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onFlingScrollEnd();
    }
  }
  
  public void onHideListBox()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onHideListBox();
    }
  }
  
  public void onHistoryItemChanged()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onHistoryItemChanged();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.mXWebProxyImp.onInterceptTouchEvent(paramMotionEvent, paramView);
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null)
    {
      localb.xkQ.super_onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    return this.mXWebProxyImp.onMiscCallBack(paramString, paramBundle);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      return localb.xkQ.super_onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return null;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onNativeCrashReport(paramInt, paramString);
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    this.mXWebProxyImp.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
  }
  
  public void onPinchToZoomStart()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onPinchToZoomStart();
    }
  }
  
  public void onPreReadFinished()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onPreReadFinished();
    }
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onPrefetchResourceHit(paramBoolean);
    }
  }
  
  public void onPromptScaleSaved()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onPromptScaleSaved();
    }
  }
  
  public void onReceivedSslErrorCancel()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onReceivedSslErrorCancel();
    }
  }
  
  public void onReceivedViewSource(String paramString)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onReceivedViewSource(paramString);
    }
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    }
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onReportHtmlInfo(paramInt, paramString);
    }
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    b localb = this.mXWebProxyImp;
    paramWebResourceRequest = new g.b(paramWebResourceRequest);
    paramWebResourceResponse = g.a(paramWebResourceResponse);
    if (localb.xkQ != null)
    {
      localb.xkQ.super_onResponseReceived(paramWebResourceRequest, paramWebResourceResponse, paramInt);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.mXWebProxyImp.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onSetButtonStatus(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    }
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    return this.mXWebProxyImp.onShowLongClickPopupMenu();
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    }
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onSlidingTitleOffScreen(paramInt1, paramInt2);
    }
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onSoftKeyBoardHide(paramInt);
    }
  }
  
  public void onSoftKeyBoardShow()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onSoftKeyBoardShow();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.mXWebProxyImp.onTouchEvent(paramMotionEvent, paramView);
  }
  
  public void onTransitionToCommitted()
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onTransitionToCommitted();
    }
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onUploadProgressChange(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onUploadProgressStart(paramInt);
    }
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null) {
      localb.xkQ.super_onUrlChange(paramString1, paramString2);
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return this.mXWebProxyImp.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    return this.mXWebProxyImp.shouldDiscardCurrentPage();
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    b localb = this.mXWebProxyImp;
    if (localb.xkQ != null)
    {
      localb.xkQ.super_showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
  }
  
  public boolean super_allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    return super.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
  }
  
  public void super_computeScroll(View paramView)
  {
    super.computeScroll(paramView);
  }
  
  public void super_didFirstVisuallyNonEmptyPaint()
  {
    super.didFirstVisuallyNonEmptyPaint();
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return super.dispatchTouchEvent(paramMotionEvent, paramView);
  }
  
  public void super_documentAvailableInMainFrame()
  {
    super.documentAvailableInMainFrame();
  }
  
  public void super_handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    super.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
  }
  
  public void super_hideAddressBar()
  {
    super.hideAddressBar();
  }
  
  public boolean super_notifyAutoAudioPlay(String paramString, f paramf)
  {
    return super.notifyAutoAudioPlay(paramString, new a.c(paramf));
  }
  
  public boolean super_notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    return super.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
  }
  
  public void super_onDoubleTapStart()
  {
    super.onDoubleTapStart();
  }
  
  public void super_onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    super.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
  }
  
  public void super_onFlingScrollEnd()
  {
    super.onFlingScrollEnd();
  }
  
  public void super_onHideListBox()
  {
    super.onHideListBox();
  }
  
  public void super_onHistoryItemChanged()
  {
    super.onHistoryItemChanged();
  }
  
  public void super_onInputBoxTextChanged(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    super.onInputBoxTextChanged(paramIX5WebViewExtension, paramString);
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return super.onInterceptTouchEvent(paramMotionEvent, paramView);
  }
  
  public void super_onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    super.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
  }
  
  public Object super_onMiscCallBack(String paramString, Bundle paramBundle)
  {
    return super.onMiscCallBack(paramString, paramBundle);
  }
  
  public Object super_onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return super.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public void super_onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
  }
  
  public void super_onNativeCrashReport(int paramInt, String paramString)
  {
    super.onNativeCrashReport(paramInt, paramString);
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
  }
  
  public void super_onPinchToZoomStart()
  {
    super.onPinchToZoomStart();
  }
  
  public void super_onPreReadFinished()
  {
    super.onPreReadFinished();
  }
  
  public void super_onPrefetchResourceHit(boolean paramBoolean)
  {
    super.onPrefetchResourceHit(paramBoolean);
  }
  
  public void super_onPromptScaleSaved()
  {
    super.onPromptScaleSaved();
  }
  
  public void super_onReceivedSslErrorCancel()
  {
    super.onReceivedSslErrorCancel();
  }
  
  public void super_onReceivedViewSource(String paramString)
  {
    super.onReceivedViewSource(paramString);
  }
  
  public void super_onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    super.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
  }
  
  public void super_onReportHtmlInfo(int paramInt, String paramString)
  {
    super.onReportHtmlInfo(paramInt, paramString);
  }
  
  public void super_onResponseReceived(l paraml, m paramm, int paramInt)
  {
    super.onResponseReceived(a.e.a(paraml), com.tencent.xweb.x5.a.b(paramm), paramInt);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public void super_onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onSetButtonStatus(paramBoolean1, paramBoolean2);
  }
  
  public void super_onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    super.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
  }
  
  public boolean super_onShowLongClickPopupMenu()
  {
    return super.onShowLongClickPopupMenu();
  }
  
  public void super_onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    super.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
  }
  
  public void super_onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    super.onSlidingTitleOffScreen(paramInt1, paramInt2);
  }
  
  public void super_onSoftKeyBoardHide(int paramInt)
  {
    super.onSoftKeyBoardHide(paramInt);
  }
  
  public void super_onSoftKeyBoardShow()
  {
    super.onSoftKeyBoardShow();
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return super.onTouchEvent(paramMotionEvent, paramView);
  }
  
  public void super_onTransitionToCommitted()
  {
    super.onTransitionToCommitted();
  }
  
  public void super_onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    super.onUploadProgressChange(paramInt1, paramInt2, paramString);
  }
  
  public void super_onUploadProgressStart(int paramInt)
  {
    super.onUploadProgressStart(paramInt);
  }
  
  public void super_onUrlChange(String paramString1, String paramString2)
  {
    super.onUrlChange(paramString1, paramString2);
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
  }
  
  public boolean super_preShouldOverrideUrlLoading(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    return super.preShouldOverrideUrlLoading(paramIX5WebViewExtension, paramString);
  }
  
  public void super_showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    super.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper
 * JD-Core Version:    0.7.0.1
 */