package com.tencent.xweb.x5.export.external.extension.proxy;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import org.xwalk.core.Log;

public class a
{
  private static final String TAG = "ProxyWebViewClientExtension";
  IProxySuperWrapper mSuperProvider;
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157127);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
      AppMethodBeat.o(157127);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157127);
    return false;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(157121);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_computeScroll(paramView);
    }
    AppMethodBeat.o(157121);
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    AppMethodBeat.i(157130);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_didFirstVisuallyNonEmptyPaint();
    }
    AppMethodBeat.o(157130);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(157117);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_dispatchTouchEvent(paramMotionEvent, paramView);
      AppMethodBeat.o(157117);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157117);
    return false;
  }
  
  public void documentAvailableInMainFrame()
  {
    AppMethodBeat.i(157129);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_documentAvailableInMainFrame();
    }
    AppMethodBeat.o(157129);
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(157102);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    }
    AppMethodBeat.o(157102);
  }
  
  public void hasDiscardCurrentPage(boolean paramBoolean) {}
  
  public void hideAddressBar()
  {
    AppMethodBeat.i(157101);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_hideAddressBar();
    }
    AppMethodBeat.o(157101);
  }
  
  public void invalidate() {}
  
  public boolean notifyAutoAudioPlay(String paramString, JsResult paramJsResult)
  {
    AppMethodBeat.i(157124);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_notifyAutoAudioPlay(paramString, paramJsResult);
      AppMethodBeat.o(157124);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157124);
    return false;
  }
  
  public boolean notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(157128);
    if (this.mSuperProvider != null)
    {
      paramBoolean = this.mSuperProvider.super_notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
      AppMethodBeat.o(157128);
      return paramBoolean;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157128);
    return false;
  }
  
  public void onDoubleTapStart()
  {
    AppMethodBeat.i(157103);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onDoubleTapStart();
    }
    AppMethodBeat.o(157103);
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(157092);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(157092);
  }
  
  public void onFlingScrollEnd()
  {
    AppMethodBeat.i(157108);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onFlingScrollEnd();
    }
    AppMethodBeat.o(157108);
  }
  
  public void onHideListBox()
  {
    AppMethodBeat.i(157089);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onHideListBox();
    }
    AppMethodBeat.o(157089);
  }
  
  public void onHistoryItemChanged()
  {
    AppMethodBeat.i(157100);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onHistoryItemChanged();
    }
    AppMethodBeat.o(157100);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(157115);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_onInterceptTouchEvent(paramMotionEvent, paramView);
      AppMethodBeat.o(157115);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157115);
    return false;
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(157122);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
      AppMethodBeat.o(157122);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157122);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(157112);
    if (this.mSuperProvider != null)
    {
      paramString = this.mSuperProvider.super_onMiscCallBack(paramString, paramBundle);
      AppMethodBeat.o(157112);
      return paramString;
    }
    AppMethodBeat.o(157112);
    return null;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(157114);
    if (this.mSuperProvider != null)
    {
      paramString = this.mSuperProvider.super_onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(157114);
      return paramString;
    }
    AppMethodBeat.o(157114);
    return null;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(157088);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    }
    AppMethodBeat.o(157088);
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    AppMethodBeat.i(157111);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onNativeCrashReport(paramInt, paramString);
    }
    AppMethodBeat.o(157111);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(157120);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
      AppMethodBeat.o(157120);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157120);
  }
  
  public void onPinchToZoomStart()
  {
    AppMethodBeat.i(157104);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onPinchToZoomStart();
    }
    AppMethodBeat.o(157104);
  }
  
  public void onPreReadFinished()
  {
    AppMethodBeat.i(157106);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onPreReadFinished();
    }
    AppMethodBeat.o(157106);
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    AppMethodBeat.i(157132);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onPrefetchResourceHit(paramBoolean);
    }
    AppMethodBeat.o(157132);
  }
  
  public void onPromptScaleSaved()
  {
    AppMethodBeat.i(157107);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onPromptScaleSaved();
    }
    AppMethodBeat.o(157107);
  }
  
  public void onReceivedSslErrorCancel()
  {
    AppMethodBeat.i(157133);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onReceivedSslErrorCancel();
    }
    AppMethodBeat.o(157133);
  }
  
  public void onReceivedViewSource(String paramString)
  {
    AppMethodBeat.i(157131);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onReceivedViewSource(paramString);
    }
    AppMethodBeat.o(157131);
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(157110);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    }
    AppMethodBeat.o(157110);
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(157113);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onReportHtmlInfo(paramInt, paramString);
    }
    AppMethodBeat.o(157113);
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    AppMethodBeat.i(157126);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_onResponseReceived(paramWebResourceRequest, paramWebResourceResponse, paramInt);
      AppMethodBeat.o(157126);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157126);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(157093);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(157093);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(157119);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
      AppMethodBeat.o(157119);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157119);
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(157099);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onSetButtonStatus(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(157099);
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(157090);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    }
    AppMethodBeat.o(157090);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(157125);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_onShowLongClickPopupMenu();
      AppMethodBeat.o(157125);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157125);
    return false;
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(157091);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    }
    AppMethodBeat.o(157091);
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157105);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onSlidingTitleOffScreen(paramInt1, paramInt2);
    }
    AppMethodBeat.o(157105);
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    AppMethodBeat.i(157098);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onSoftKeyBoardHide(paramInt);
    }
    AppMethodBeat.o(157098);
  }
  
  public void onSoftKeyBoardShow()
  {
    AppMethodBeat.i(157097);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onSoftKeyBoardShow();
    }
    AppMethodBeat.o(157097);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(157116);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_onTouchEvent(paramMotionEvent, paramView);
      AppMethodBeat.o(157116);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157116);
    return false;
  }
  
  public void onTransitionToCommitted()
  {
    AppMethodBeat.i(157094);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onTransitionToCommitted();
    }
    AppMethodBeat.o(157094);
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(157096);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onUploadProgressChange(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(157096);
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    AppMethodBeat.i(157095);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onUploadProgressStart(paramInt);
    }
    AppMethodBeat.o(157095);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157109);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onUrlChange(paramString1, paramString2);
    }
    AppMethodBeat.o(157109);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(157118);
    if (this.mSuperProvider != null)
    {
      paramBoolean = this.mSuperProvider.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
      AppMethodBeat.o(157118);
      return paramBoolean;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157118);
    return false;
  }
  
  public void setSuperProvider(IProxySuperWrapper paramIProxySuperWrapper)
  {
    this.mSuperProvider = paramIProxySuperWrapper;
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    return false;
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(157123);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
      AppMethodBeat.o(157123);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(157123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.export.external.extension.proxy.a
 * JD-Core Version:    0.7.0.1
 */