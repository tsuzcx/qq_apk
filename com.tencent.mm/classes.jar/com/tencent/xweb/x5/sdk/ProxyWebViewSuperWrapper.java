package com.tencent.xweb.x5.sdk;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.xweb.x5.X5WebFactory;
import com.tencent.xweb.x5.a.c;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper;
import com.tencent.xweb.x5.g;
import com.tencent.xweb.x5.g.b;
import com.tencent.xweb.x5.g.g;
import java.util.List;
import org.xwalk.core.WebViewExtensionListener;

public class ProxyWebViewSuperWrapper
  extends ProxyWebViewClientExtension
  implements IProxySuperWrapper
{
  com.tencent.xweb.x5.export.external.extension.proxy.a mXWebProxyImp;
  
  public ProxyWebViewSuperWrapper() {}
  
  public ProxyWebViewSuperWrapper(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(154024);
    this.mXWebProxyImp = parama;
    this.mXWebProxyImp.setSuperProvider(this);
    AppMethodBeat.o(154024);
  }
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154062);
    boolean bool = this.mXWebProxyImp.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    AppMethodBeat.o(154062);
    return bool;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(154059);
    this.mXWebProxyImp.computeScroll(paramView);
    AppMethodBeat.o(154059);
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    AppMethodBeat.i(154066);
    this.mXWebProxyImp.didFirstVisuallyNonEmptyPaint();
    AppMethodBeat.o(154066);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(154055);
    boolean bool = this.mXWebProxyImp.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(154055);
    return bool;
  }
  
  public void documentAvailableInMainFrame()
  {
    AppMethodBeat.i(154067);
    this.mXWebProxyImp.documentAvailableInMainFrame();
    AppMethodBeat.o(154067);
  }
  
  public int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(206445);
    if (X5WebFactory.getInstance().getExtensionCallback() != null)
    {
      i = X5WebFactory.getInstance().getExtensionCallback().getHostByName(paramString, paramList);
      AppMethodBeat.o(206445);
      return i;
    }
    int i = super.getHostByName(paramString, paramList);
    AppMethodBeat.o(206445);
    return i;
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(154043);
    this.mXWebProxyImp.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    AppMethodBeat.o(154043);
  }
  
  public void hasDiscardCurrentPage(boolean paramBoolean)
  {
    AppMethodBeat.i(154072);
    this.mXWebProxyImp.hasDiscardCurrentPage(paramBoolean);
    AppMethodBeat.o(154072);
  }
  
  public void hideAddressBar()
  {
    AppMethodBeat.i(154042);
    this.mXWebProxyImp.hideAddressBar();
    AppMethodBeat.o(154042);
  }
  
  public void invalidate() {}
  
  public boolean notifyAutoAudioPlay(String paramString, com.tencent.smtt.export.external.interfaces.JsResult paramJsResult)
  {
    AppMethodBeat.i(154061);
    boolean bool = this.mXWebProxyImp.notifyAutoAudioPlay(paramString, new g.g(paramJsResult));
    AppMethodBeat.o(154061);
    return bool;
  }
  
  public boolean notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(154063);
    paramBoolean = this.mXWebProxyImp.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    AppMethodBeat.o(154063);
    return paramBoolean;
  }
  
  public void onDoubleTapStart()
  {
    AppMethodBeat.i(154044);
    this.mXWebProxyImp.onDoubleTapStart();
    AppMethodBeat.o(154044);
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154035);
    this.mXWebProxyImp.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(154035);
  }
  
  public void onFlingScrollEnd()
  {
    AppMethodBeat.i(154036);
    this.mXWebProxyImp.onFlingScrollEnd();
    AppMethodBeat.o(154036);
  }
  
  public void onHideListBox()
  {
    AppMethodBeat.i(154028);
    this.mXWebProxyImp.onHideListBox();
    AppMethodBeat.o(154028);
  }
  
  public void onHistoryItemChanged()
  {
    AppMethodBeat.i(154041);
    this.mXWebProxyImp.onHistoryItemChanged();
    AppMethodBeat.o(154041);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(154053);
    boolean bool = this.mXWebProxyImp.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(154053);
    return bool;
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(154060);
    this.mXWebProxyImp.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
    AppMethodBeat.o(154060);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(154051);
    paramString = this.mXWebProxyImp.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(154051);
    return paramString;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(154052);
    paramString = this.mXWebProxyImp.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    AppMethodBeat.o(154052);
    return paramString;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(154047);
    this.mXWebProxyImp.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    AppMethodBeat.o(154047);
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    AppMethodBeat.i(154050);
    this.mXWebProxyImp.onNativeCrashReport(paramInt, paramString);
    AppMethodBeat.o(154050);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(154058);
    this.mXWebProxyImp.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(154058);
  }
  
  public void onPinchToZoomStart()
  {
    AppMethodBeat.i(154045);
    this.mXWebProxyImp.onPinchToZoomStart();
    AppMethodBeat.o(154045);
  }
  
  public void onPreReadFinished()
  {
    AppMethodBeat.i(154025);
    this.mXWebProxyImp.onPreReadFinished();
    AppMethodBeat.o(154025);
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    AppMethodBeat.i(154069);
    this.mXWebProxyImp.onPrefetchResourceHit(paramBoolean);
    AppMethodBeat.o(154069);
  }
  
  public void onPromptScaleSaved()
  {
    AppMethodBeat.i(154026);
    this.mXWebProxyImp.onPromptScaleSaved();
    AppMethodBeat.o(154026);
  }
  
  public void onReceivedSslErrorCancel()
  {
    AppMethodBeat.i(154070);
    this.mXWebProxyImp.onReceivedSslErrorCancel();
    AppMethodBeat.o(154070);
  }
  
  public void onReceivedViewSource(String paramString)
  {
    AppMethodBeat.i(154068);
    this.mXWebProxyImp.onReceivedViewSource(paramString);
    AppMethodBeat.o(154068);
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154048);
    this.mXWebProxyImp.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    AppMethodBeat.o(154048);
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(154049);
    this.mXWebProxyImp.onReportHtmlInfo(paramInt, paramString);
    AppMethodBeat.o(154049);
  }
  
  public void onResponseReceived(com.tencent.smtt.export.external.interfaces.WebResourceRequest paramWebResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    AppMethodBeat.i(154065);
    this.mXWebProxyImp.onResponseReceived(new g.b(paramWebResourceRequest), g.a(paramWebResourceResponse), paramInt);
    AppMethodBeat.o(154065);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(154037);
    this.mXWebProxyImp.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(154037);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(154057);
    this.mXWebProxyImp.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(154057);
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(154040);
    this.mXWebProxyImp.onSetButtonStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(154040);
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(154029);
    this.mXWebProxyImp.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    AppMethodBeat.o(154029);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(154064);
    boolean bool = this.mXWebProxyImp.onShowLongClickPopupMenu();
    AppMethodBeat.o(154064);
    return bool;
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(154030);
    this.mXWebProxyImp.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    AppMethodBeat.o(154030);
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154046);
    this.mXWebProxyImp.onSlidingTitleOffScreen(paramInt1, paramInt2);
    AppMethodBeat.o(154046);
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    AppMethodBeat.i(154039);
    this.mXWebProxyImp.onSoftKeyBoardHide(paramInt);
    AppMethodBeat.o(154039);
  }
  
  public void onSoftKeyBoardShow()
  {
    AppMethodBeat.i(154038);
    this.mXWebProxyImp.onSoftKeyBoardShow();
    AppMethodBeat.o(154038);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(154054);
    boolean bool = this.mXWebProxyImp.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(154054);
    return bool;
  }
  
  public void onTransitionToCommitted()
  {
    AppMethodBeat.i(154031);
    this.mXWebProxyImp.onTransitionToCommitted();
    AppMethodBeat.o(154031);
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(154034);
    this.mXWebProxyImp.onUploadProgressChange(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(154034);
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    AppMethodBeat.i(154033);
    this.mXWebProxyImp.onUploadProgressStart(paramInt);
    AppMethodBeat.o(154033);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154027);
    this.mXWebProxyImp.onUrlChange(paramString1, paramString2);
    AppMethodBeat.o(154027);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(154056);
    paramBoolean = this.mXWebProxyImp.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(154056);
    return paramBoolean;
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    AppMethodBeat.i(154071);
    boolean bool = this.mXWebProxyImp.shouldDiscardCurrentPage();
    AppMethodBeat.o(154071);
    return bool;
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(154032);
    this.mXWebProxyImp.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(154032);
  }
  
  public boolean super_allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154112);
    boolean bool = super.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    AppMethodBeat.o(154112);
    return bool;
  }
  
  public void super_computeScroll(View paramView)
  {
    AppMethodBeat.i(154109);
    super.computeScroll(paramView);
    AppMethodBeat.o(154109);
  }
  
  public void super_didFirstVisuallyNonEmptyPaint()
  {
    AppMethodBeat.i(154116);
    super.didFirstVisuallyNonEmptyPaint();
    AppMethodBeat.o(154116);
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(154105);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(154105);
    return bool;
  }
  
  public void super_documentAvailableInMainFrame()
  {
    AppMethodBeat.i(154117);
    super.documentAvailableInMainFrame();
    AppMethodBeat.o(154117);
  }
  
  public void super_handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(154092);
    super.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    AppMethodBeat.o(154092);
  }
  
  public void super_hideAddressBar()
  {
    AppMethodBeat.i(154091);
    super.hideAddressBar();
    AppMethodBeat.o(154091);
  }
  
  public boolean super_notifyAutoAudioPlay(String paramString, com.tencent.xweb.JsResult paramJsResult)
  {
    AppMethodBeat.i(154111);
    boolean bool = super.notifyAutoAudioPlay(paramString, new a.c(paramJsResult));
    AppMethodBeat.o(154111);
    return bool;
  }
  
  public boolean super_notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(154113);
    paramBoolean = super.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    AppMethodBeat.o(154113);
    return paramBoolean;
  }
  
  public void super_onDoubleTapStart()
  {
    AppMethodBeat.i(154093);
    super.onDoubleTapStart();
    AppMethodBeat.o(154093);
  }
  
  public void super_onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154084);
    super.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(154084);
  }
  
  public void super_onFlingScrollEnd()
  {
    AppMethodBeat.i(154085);
    super.onFlingScrollEnd();
    AppMethodBeat.o(154085);
  }
  
  public void super_onHideListBox()
  {
    AppMethodBeat.i(154076);
    super.onHideListBox();
    AppMethodBeat.o(154076);
  }
  
  public void super_onHistoryItemChanged()
  {
    AppMethodBeat.i(154090);
    super.onHistoryItemChanged();
    AppMethodBeat.o(154090);
  }
  
  public void super_onInputBoxTextChanged(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    AppMethodBeat.i(154079);
    super.onInputBoxTextChanged(paramIX5WebViewExtension, paramString);
    AppMethodBeat.o(154079);
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(154103);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(154103);
    return bool;
  }
  
  public void super_onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(154110);
    super.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
    AppMethodBeat.o(154110);
  }
  
  public Object super_onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(154101);
    paramString = super.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(154101);
    return paramString;
  }
  
  public Object super_onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(154102);
    paramString = super.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    AppMethodBeat.o(154102);
    return paramString;
  }
  
  public void super_onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(154097);
    super.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    AppMethodBeat.o(154097);
  }
  
  public void super_onNativeCrashReport(int paramInt, String paramString)
  {
    AppMethodBeat.i(154100);
    super.onNativeCrashReport(paramInt, paramString);
    AppMethodBeat.o(154100);
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(154108);
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(154108);
  }
  
  public void super_onPinchToZoomStart()
  {
    AppMethodBeat.i(154094);
    super.onPinchToZoomStart();
    AppMethodBeat.o(154094);
  }
  
  public void super_onPreReadFinished()
  {
    AppMethodBeat.i(154073);
    super.onPreReadFinished();
    AppMethodBeat.o(154073);
  }
  
  public void super_onPrefetchResourceHit(boolean paramBoolean)
  {
    AppMethodBeat.i(154119);
    super.onPrefetchResourceHit(paramBoolean);
    AppMethodBeat.o(154119);
  }
  
  public void super_onPromptScaleSaved()
  {
    AppMethodBeat.i(154074);
    super.onPromptScaleSaved();
    AppMethodBeat.o(154074);
  }
  
  public void super_onReceivedSslErrorCancel()
  {
    AppMethodBeat.i(154120);
    super.onReceivedSslErrorCancel();
    AppMethodBeat.o(154120);
  }
  
  public void super_onReceivedViewSource(String paramString)
  {
    AppMethodBeat.i(154118);
    super.onReceivedViewSource(paramString);
    AppMethodBeat.o(154118);
  }
  
  public void super_onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154098);
    super.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    AppMethodBeat.o(154098);
  }
  
  public void super_onReportHtmlInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(154099);
    super.onReportHtmlInfo(paramInt, paramString);
    AppMethodBeat.o(154099);
  }
  
  public void super_onResponseReceived(com.tencent.xweb.WebResourceRequest paramWebResourceRequest, com.tencent.xweb.WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    AppMethodBeat.i(154115);
    super.onResponseReceived(a.e.a(paramWebResourceRequest), com.tencent.xweb.x5.a.b(paramWebResourceResponse), paramInt);
    AppMethodBeat.o(154115);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(154086);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(154086);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(154107);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(154107);
  }
  
  public void super_onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(154089);
    super.onSetButtonStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(154089);
  }
  
  public void super_onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(154077);
    super.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    AppMethodBeat.o(154077);
  }
  
  public boolean super_onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(154114);
    boolean bool = super.onShowLongClickPopupMenu();
    AppMethodBeat.o(154114);
    return bool;
  }
  
  public void super_onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(154078);
    super.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    AppMethodBeat.o(154078);
  }
  
  public void super_onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154095);
    super.onSlidingTitleOffScreen(paramInt1, paramInt2);
    AppMethodBeat.o(154095);
  }
  
  public void super_onSoftKeyBoardHide(int paramInt)
  {
    AppMethodBeat.i(154088);
    super.onSoftKeyBoardHide(paramInt);
    AppMethodBeat.o(154088);
  }
  
  public void super_onSoftKeyBoardShow()
  {
    AppMethodBeat.i(154087);
    super.onSoftKeyBoardShow();
    AppMethodBeat.o(154087);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(154104);
    boolean bool = super.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(154104);
    return bool;
  }
  
  public void super_onTransitionToCommitted()
  {
    AppMethodBeat.i(154080);
    super.onTransitionToCommitted();
    AppMethodBeat.o(154080);
  }
  
  public void super_onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(154083);
    super.onUploadProgressChange(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(154083);
  }
  
  public void super_onUploadProgressStart(int paramInt)
  {
    AppMethodBeat.i(154082);
    super.onUploadProgressStart(paramInt);
    AppMethodBeat.o(154082);
  }
  
  public void super_onUrlChange(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154075);
    super.onUrlChange(paramString1, paramString2);
    AppMethodBeat.o(154075);
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(154106);
    paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(154106);
    return paramBoolean;
  }
  
  public boolean super_preShouldOverrideUrlLoading(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    AppMethodBeat.i(154096);
    boolean bool = super.preShouldOverrideUrlLoading(paramIX5WebViewExtension, paramString);
    AppMethodBeat.o(154096);
    return bool;
  }
  
  public void super_showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(154081);
    super.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(154081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper
 * JD-Core Version:    0.7.0.1
 */