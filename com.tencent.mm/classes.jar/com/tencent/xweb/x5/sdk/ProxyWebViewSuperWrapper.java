package com.tencent.xweb.x5.sdk;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.j;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.x5.a.c;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.a.a.a.a.b;
import com.tencent.xweb.x5.g;
import com.tencent.xweb.x5.g.b;
import com.tencent.xweb.x5.g.f;

public class ProxyWebViewSuperWrapper
  extends ProxyWebViewClientExtension
  implements com.tencent.xweb.x5.a.a.a.a.a
{
  b mXWebProxyImp;
  
  public ProxyWebViewSuperWrapper() {}
  
  public ProxyWebViewSuperWrapper(b paramb)
  {
    AppMethodBeat.i(84994);
    this.mXWebProxyImp = paramb;
    this.mXWebProxyImp.setSuperProvider(this);
    AppMethodBeat.o(84994);
  }
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85032);
    boolean bool = this.mXWebProxyImp.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    AppMethodBeat.o(85032);
    return bool;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(85029);
    this.mXWebProxyImp.computeScroll(paramView);
    AppMethodBeat.o(85029);
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    AppMethodBeat.i(85036);
    this.mXWebProxyImp.didFirstVisuallyNonEmptyPaint();
    AppMethodBeat.o(85036);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(85025);
    boolean bool = this.mXWebProxyImp.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(85025);
    return bool;
  }
  
  public void documentAvailableInMainFrame()
  {
    AppMethodBeat.i(85037);
    this.mXWebProxyImp.documentAvailableInMainFrame();
    AppMethodBeat.o(85037);
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(85013);
    this.mXWebProxyImp.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    AppMethodBeat.o(85013);
  }
  
  public void hasDiscardCurrentPage(boolean paramBoolean)
  {
    AppMethodBeat.i(85042);
    this.mXWebProxyImp.hasDiscardCurrentPage(paramBoolean);
    AppMethodBeat.o(85042);
  }
  
  public void hideAddressBar()
  {
    AppMethodBeat.i(85012);
    this.mXWebProxyImp.hideAddressBar();
    AppMethodBeat.o(85012);
  }
  
  public void invalidate() {}
  
  public boolean notifyAutoAudioPlay(String paramString, JsResult paramJsResult)
  {
    AppMethodBeat.i(85031);
    boolean bool = this.mXWebProxyImp.notifyAutoAudioPlay(paramString, new g.f(paramJsResult));
    AppMethodBeat.o(85031);
    return bool;
  }
  
  public boolean notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(85033);
    paramBoolean = this.mXWebProxyImp.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    AppMethodBeat.o(85033);
    return paramBoolean;
  }
  
  public void onDoubleTapStart()
  {
    AppMethodBeat.i(85014);
    this.mXWebProxyImp.onDoubleTapStart();
    AppMethodBeat.o(85014);
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(85005);
    this.mXWebProxyImp.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(85005);
  }
  
  public void onFlingScrollEnd()
  {
    AppMethodBeat.i(85006);
    this.mXWebProxyImp.onFlingScrollEnd();
    AppMethodBeat.o(85006);
  }
  
  public void onHideListBox()
  {
    AppMethodBeat.i(84998);
    this.mXWebProxyImp.onHideListBox();
    AppMethodBeat.o(84998);
  }
  
  public void onHistoryItemChanged()
  {
    AppMethodBeat.i(85011);
    this.mXWebProxyImp.onHistoryItemChanged();
    AppMethodBeat.o(85011);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(85023);
    boolean bool = this.mXWebProxyImp.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(85023);
    return bool;
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(85030);
    this.mXWebProxyImp.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
    AppMethodBeat.o(85030);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(85021);
    paramString = this.mXWebProxyImp.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(85021);
    return paramString;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(85022);
    paramString = this.mXWebProxyImp.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    AppMethodBeat.o(85022);
    return paramString;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(85017);
    this.mXWebProxyImp.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    AppMethodBeat.o(85017);
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    AppMethodBeat.i(85020);
    this.mXWebProxyImp.onNativeCrashReport(paramInt, paramString);
    AppMethodBeat.o(85020);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(85028);
    this.mXWebProxyImp.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(85028);
  }
  
  public void onPinchToZoomStart()
  {
    AppMethodBeat.i(85015);
    this.mXWebProxyImp.onPinchToZoomStart();
    AppMethodBeat.o(85015);
  }
  
  public void onPreReadFinished()
  {
    AppMethodBeat.i(84995);
    this.mXWebProxyImp.onPreReadFinished();
    AppMethodBeat.o(84995);
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    AppMethodBeat.i(85039);
    this.mXWebProxyImp.onPrefetchResourceHit(paramBoolean);
    AppMethodBeat.o(85039);
  }
  
  public void onPromptScaleSaved()
  {
    AppMethodBeat.i(84996);
    this.mXWebProxyImp.onPromptScaleSaved();
    AppMethodBeat.o(84996);
  }
  
  public void onReceivedSslErrorCancel()
  {
    AppMethodBeat.i(85040);
    this.mXWebProxyImp.onReceivedSslErrorCancel();
    AppMethodBeat.o(85040);
  }
  
  public void onReceivedViewSource(String paramString)
  {
    AppMethodBeat.i(85038);
    this.mXWebProxyImp.onReceivedViewSource(paramString);
    AppMethodBeat.o(85038);
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(85018);
    this.mXWebProxyImp.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    AppMethodBeat.o(85018);
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(85019);
    this.mXWebProxyImp.onReportHtmlInfo(paramInt, paramString);
    AppMethodBeat.o(85019);
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    AppMethodBeat.i(85035);
    this.mXWebProxyImp.onResponseReceived(new g.b(paramWebResourceRequest), g.a(paramWebResourceResponse), paramInt);
    AppMethodBeat.o(85035);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(85007);
    this.mXWebProxyImp.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(85007);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(85027);
    this.mXWebProxyImp.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(85027);
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(85010);
    this.mXWebProxyImp.onSetButtonStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(85010);
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(84999);
    this.mXWebProxyImp.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    AppMethodBeat.o(84999);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(85034);
    boolean bool = this.mXWebProxyImp.onShowLongClickPopupMenu();
    AppMethodBeat.o(85034);
    return bool;
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(85000);
    this.mXWebProxyImp.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    AppMethodBeat.o(85000);
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(85016);
    this.mXWebProxyImp.onSlidingTitleOffScreen(paramInt1, paramInt2);
    AppMethodBeat.o(85016);
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    AppMethodBeat.i(85009);
    this.mXWebProxyImp.onSoftKeyBoardHide(paramInt);
    AppMethodBeat.o(85009);
  }
  
  public void onSoftKeyBoardShow()
  {
    AppMethodBeat.i(85008);
    this.mXWebProxyImp.onSoftKeyBoardShow();
    AppMethodBeat.o(85008);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(85024);
    boolean bool = this.mXWebProxyImp.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(85024);
    return bool;
  }
  
  public void onTransitionToCommitted()
  {
    AppMethodBeat.i(85001);
    this.mXWebProxyImp.onTransitionToCommitted();
    AppMethodBeat.o(85001);
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(85004);
    this.mXWebProxyImp.onUploadProgressChange(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(85004);
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    AppMethodBeat.i(85003);
    this.mXWebProxyImp.onUploadProgressStart(paramInt);
    AppMethodBeat.o(85003);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84997);
    this.mXWebProxyImp.onUrlChange(paramString1, paramString2);
    AppMethodBeat.o(84997);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(85026);
    paramBoolean = this.mXWebProxyImp.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(85026);
    return paramBoolean;
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    AppMethodBeat.i(85041);
    boolean bool = this.mXWebProxyImp.shouldDiscardCurrentPage();
    AppMethodBeat.o(85041);
    return bool;
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(85002);
    this.mXWebProxyImp.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(85002);
  }
  
  public boolean super_allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85082);
    boolean bool = super.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    AppMethodBeat.o(85082);
    return bool;
  }
  
  public void super_computeScroll(View paramView)
  {
    AppMethodBeat.i(85079);
    super.computeScroll(paramView);
    AppMethodBeat.o(85079);
  }
  
  public void super_didFirstVisuallyNonEmptyPaint()
  {
    AppMethodBeat.i(85086);
    super.didFirstVisuallyNonEmptyPaint();
    AppMethodBeat.o(85086);
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(85075);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(85075);
    return bool;
  }
  
  public void super_documentAvailableInMainFrame()
  {
    AppMethodBeat.i(85087);
    super.documentAvailableInMainFrame();
    AppMethodBeat.o(85087);
  }
  
  public void super_handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(85062);
    super.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    AppMethodBeat.o(85062);
  }
  
  public void super_hideAddressBar()
  {
    AppMethodBeat.i(85061);
    super.hideAddressBar();
    AppMethodBeat.o(85061);
  }
  
  public boolean super_notifyAutoAudioPlay(String paramString, j paramj)
  {
    AppMethodBeat.i(85081);
    boolean bool = super.notifyAutoAudioPlay(paramString, new a.c(paramj));
    AppMethodBeat.o(85081);
    return bool;
  }
  
  public boolean super_notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(85083);
    paramBoolean = super.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    AppMethodBeat.o(85083);
    return paramBoolean;
  }
  
  public void super_onDoubleTapStart()
  {
    AppMethodBeat.i(85063);
    super.onDoubleTapStart();
    AppMethodBeat.o(85063);
  }
  
  public void super_onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(85054);
    super.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(85054);
  }
  
  public void super_onFlingScrollEnd()
  {
    AppMethodBeat.i(85055);
    super.onFlingScrollEnd();
    AppMethodBeat.o(85055);
  }
  
  public void super_onHideListBox()
  {
    AppMethodBeat.i(85046);
    super.onHideListBox();
    AppMethodBeat.o(85046);
  }
  
  public void super_onHistoryItemChanged()
  {
    AppMethodBeat.i(85060);
    super.onHistoryItemChanged();
    AppMethodBeat.o(85060);
  }
  
  public void super_onInputBoxTextChanged(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    AppMethodBeat.i(85049);
    super.onInputBoxTextChanged(paramIX5WebViewExtension, paramString);
    AppMethodBeat.o(85049);
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(85073);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(85073);
    return bool;
  }
  
  public void super_onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(85080);
    super.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
    AppMethodBeat.o(85080);
  }
  
  public Object super_onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(85071);
    paramString = super.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(85071);
    return paramString;
  }
  
  public Object super_onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(85072);
    paramString = super.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    AppMethodBeat.o(85072);
    return paramString;
  }
  
  public void super_onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(85067);
    super.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    AppMethodBeat.o(85067);
  }
  
  public void super_onNativeCrashReport(int paramInt, String paramString)
  {
    AppMethodBeat.i(85070);
    super.onNativeCrashReport(paramInt, paramString);
    AppMethodBeat.o(85070);
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(85078);
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(85078);
  }
  
  public void super_onPinchToZoomStart()
  {
    AppMethodBeat.i(85064);
    super.onPinchToZoomStart();
    AppMethodBeat.o(85064);
  }
  
  public void super_onPreReadFinished()
  {
    AppMethodBeat.i(85043);
    super.onPreReadFinished();
    AppMethodBeat.o(85043);
  }
  
  public void super_onPrefetchResourceHit(boolean paramBoolean)
  {
    AppMethodBeat.i(85089);
    super.onPrefetchResourceHit(paramBoolean);
    AppMethodBeat.o(85089);
  }
  
  public void super_onPromptScaleSaved()
  {
    AppMethodBeat.i(85044);
    super.onPromptScaleSaved();
    AppMethodBeat.o(85044);
  }
  
  public void super_onReceivedSslErrorCancel()
  {
    AppMethodBeat.i(85090);
    super.onReceivedSslErrorCancel();
    AppMethodBeat.o(85090);
  }
  
  public void super_onReceivedViewSource(String paramString)
  {
    AppMethodBeat.i(85088);
    super.onReceivedViewSource(paramString);
    AppMethodBeat.o(85088);
  }
  
  public void super_onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(85068);
    super.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    AppMethodBeat.o(85068);
  }
  
  public void super_onReportHtmlInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(85069);
    super.onReportHtmlInfo(paramInt, paramString);
    AppMethodBeat.o(85069);
  }
  
  public void super_onResponseReceived(r paramr, s params, int paramInt)
  {
    AppMethodBeat.i(85085);
    super.onResponseReceived(a.e.a(paramr), com.tencent.xweb.x5.a.b(params), paramInt);
    AppMethodBeat.o(85085);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(85056);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(85056);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(85077);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(85077);
  }
  
  public void super_onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(85059);
    super.onSetButtonStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(85059);
  }
  
  public void super_onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(85047);
    super.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    AppMethodBeat.o(85047);
  }
  
  public boolean super_onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(85084);
    boolean bool = super.onShowLongClickPopupMenu();
    AppMethodBeat.o(85084);
    return bool;
  }
  
  public void super_onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(85048);
    super.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    AppMethodBeat.o(85048);
  }
  
  public void super_onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(85065);
    super.onSlidingTitleOffScreen(paramInt1, paramInt2);
    AppMethodBeat.o(85065);
  }
  
  public void super_onSoftKeyBoardHide(int paramInt)
  {
    AppMethodBeat.i(85058);
    super.onSoftKeyBoardHide(paramInt);
    AppMethodBeat.o(85058);
  }
  
  public void super_onSoftKeyBoardShow()
  {
    AppMethodBeat.i(85057);
    super.onSoftKeyBoardShow();
    AppMethodBeat.o(85057);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(85074);
    boolean bool = super.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(85074);
    return bool;
  }
  
  public void super_onTransitionToCommitted()
  {
    AppMethodBeat.i(85050);
    super.onTransitionToCommitted();
    AppMethodBeat.o(85050);
  }
  
  public void super_onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(85053);
    super.onUploadProgressChange(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(85053);
  }
  
  public void super_onUploadProgressStart(int paramInt)
  {
    AppMethodBeat.i(85052);
    super.onUploadProgressStart(paramInt);
    AppMethodBeat.o(85052);
  }
  
  public void super_onUrlChange(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85045);
    super.onUrlChange(paramString1, paramString2);
    AppMethodBeat.o(85045);
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(85076);
    paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(85076);
    return paramBoolean;
  }
  
  public boolean super_preShouldOverrideUrlLoading(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    AppMethodBeat.i(85066);
    boolean bool = super.preShouldOverrideUrlLoading(paramIX5WebViewExtension, paramString);
    AppMethodBeat.o(85066);
    return bool;
  }
  
  public void super_showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(85051);
    super.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(85051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper
 * JD-Core Version:    0.7.0.1
 */