package com.tencent.xweb.x5.a.a.a.a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import org.xwalk.core.Log;

public class b
{
  private static final String TAG = "ProxyWebViewClientExtension";
  a mSuperProvider;
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4128);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
      AppMethodBeat.o(4128);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4128);
    return false;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(4122);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_computeScroll(paramView);
    }
    AppMethodBeat.o(4122);
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    AppMethodBeat.i(4131);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_didFirstVisuallyNonEmptyPaint();
    }
    AppMethodBeat.o(4131);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(4118);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_dispatchTouchEvent(paramMotionEvent, paramView);
      AppMethodBeat.o(4118);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4118);
    return false;
  }
  
  public void documentAvailableInMainFrame()
  {
    AppMethodBeat.i(4130);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_documentAvailableInMainFrame();
    }
    AppMethodBeat.o(4130);
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(4103);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    }
    AppMethodBeat.o(4103);
  }
  
  public void hasDiscardCurrentPage(boolean paramBoolean) {}
  
  public void hideAddressBar()
  {
    AppMethodBeat.i(4102);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_hideAddressBar();
    }
    AppMethodBeat.o(4102);
  }
  
  public void invalidate() {}
  
  public boolean notifyAutoAudioPlay(String paramString, j paramj)
  {
    AppMethodBeat.i(4125);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_notifyAutoAudioPlay(paramString, paramj);
      AppMethodBeat.o(4125);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4125);
    return false;
  }
  
  public boolean notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(4129);
    if (this.mSuperProvider != null)
    {
      paramBoolean = this.mSuperProvider.super_notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
      AppMethodBeat.o(4129);
      return paramBoolean;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4129);
    return false;
  }
  
  public void onDoubleTapStart()
  {
    AppMethodBeat.i(4104);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onDoubleTapStart();
    }
    AppMethodBeat.o(4104);
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(4093);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(4093);
  }
  
  public void onFlingScrollEnd()
  {
    AppMethodBeat.i(4109);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onFlingScrollEnd();
    }
    AppMethodBeat.o(4109);
  }
  
  public void onHideListBox()
  {
    AppMethodBeat.i(4090);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onHideListBox();
    }
    AppMethodBeat.o(4090);
  }
  
  public void onHistoryItemChanged()
  {
    AppMethodBeat.i(4101);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onHistoryItemChanged();
    }
    AppMethodBeat.o(4101);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(4116);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_onInterceptTouchEvent(paramMotionEvent, paramView);
      AppMethodBeat.o(4116);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4116);
    return false;
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(4123);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
      AppMethodBeat.o(4123);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4123);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(4113);
    if (this.mSuperProvider != null)
    {
      paramString = this.mSuperProvider.super_onMiscCallBack(paramString, paramBundle);
      AppMethodBeat.o(4113);
      return paramString;
    }
    AppMethodBeat.o(4113);
    return null;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(4115);
    if (this.mSuperProvider != null)
    {
      paramString = this.mSuperProvider.super_onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(4115);
      return paramString;
    }
    AppMethodBeat.o(4115);
    return null;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(4089);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    }
    AppMethodBeat.o(4089);
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    AppMethodBeat.i(4112);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onNativeCrashReport(paramInt, paramString);
    }
    AppMethodBeat.o(4112);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(4121);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
      AppMethodBeat.o(4121);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4121);
  }
  
  public void onPinchToZoomStart()
  {
    AppMethodBeat.i(4105);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onPinchToZoomStart();
    }
    AppMethodBeat.o(4105);
  }
  
  public void onPreReadFinished()
  {
    AppMethodBeat.i(4107);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onPreReadFinished();
    }
    AppMethodBeat.o(4107);
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    AppMethodBeat.i(4133);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onPrefetchResourceHit(paramBoolean);
    }
    AppMethodBeat.o(4133);
  }
  
  public void onPromptScaleSaved()
  {
    AppMethodBeat.i(4108);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onPromptScaleSaved();
    }
    AppMethodBeat.o(4108);
  }
  
  public void onReceivedSslErrorCancel()
  {
    AppMethodBeat.i(4134);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onReceivedSslErrorCancel();
    }
    AppMethodBeat.o(4134);
  }
  
  public void onReceivedViewSource(String paramString)
  {
    AppMethodBeat.i(4132);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onReceivedViewSource(paramString);
    }
    AppMethodBeat.o(4132);
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(4111);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    }
    AppMethodBeat.o(4111);
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(4114);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onReportHtmlInfo(paramInt, paramString);
    }
    AppMethodBeat.o(4114);
  }
  
  public void onResponseReceived(r paramr, s params, int paramInt)
  {
    AppMethodBeat.i(4127);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_onResponseReceived(paramr, params, paramInt);
      AppMethodBeat.o(4127);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4127);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(4094);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(4094);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(4120);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
      AppMethodBeat.o(4120);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4120);
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(4100);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onSetButtonStatus(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(4100);
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(4091);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    }
    AppMethodBeat.o(4091);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(4126);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_onShowLongClickPopupMenu();
      AppMethodBeat.o(4126);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4126);
    return false;
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(4092);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    }
    AppMethodBeat.o(4092);
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4106);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onSlidingTitleOffScreen(paramInt1, paramInt2);
    }
    AppMethodBeat.o(4106);
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    AppMethodBeat.i(4099);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onSoftKeyBoardHide(paramInt);
    }
    AppMethodBeat.o(4099);
  }
  
  public void onSoftKeyBoardShow()
  {
    AppMethodBeat.i(4098);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onSoftKeyBoardShow();
    }
    AppMethodBeat.o(4098);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(4117);
    if (this.mSuperProvider != null)
    {
      boolean bool = this.mSuperProvider.super_onTouchEvent(paramMotionEvent, paramView);
      AppMethodBeat.o(4117);
      return bool;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4117);
    return false;
  }
  
  public void onTransitionToCommitted()
  {
    AppMethodBeat.i(4095);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onTransitionToCommitted();
    }
    AppMethodBeat.o(4095);
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(4097);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onUploadProgressChange(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(4097);
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    AppMethodBeat.i(4096);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onUploadProgressStart(paramInt);
    }
    AppMethodBeat.o(4096);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4110);
    if (this.mSuperProvider != null) {
      this.mSuperProvider.super_onUrlChange(paramString1, paramString2);
    }
    AppMethodBeat.o(4110);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(4119);
    if (this.mSuperProvider != null)
    {
      paramBoolean = this.mSuperProvider.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
      AppMethodBeat.o(4119);
      return paramBoolean;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4119);
    return false;
  }
  
  public void setSuperProvider(a parama)
  {
    this.mSuperProvider = parama;
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    return false;
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(4124);
    if (this.mSuperProvider != null)
    {
      this.mSuperProvider.super_showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
      AppMethodBeat.o(4124);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    AppMethodBeat.o(4124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.x5.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */