package com.tencent.xweb.x5.a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.xweb.x5.X5WebFactory;
import com.tencent.xweb.x5.a.c;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.d.b;
import com.tencent.xweb.x5.d.g;
import com.tencent.xweb.x5.export.external.extension.proxy.IWebViewClientExtensionSuperWrapper;
import java.util.List;
import org.xwalk.core.WebViewExtensionListener;

public class d
  extends ProxyWebViewClientExtension
  implements IWebViewClientExtensionSuperWrapper
{
  private com.tencent.xweb.x5.export.external.extension.proxy.a sLm;
  
  public d(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(213132);
    this.sLm = parama;
    this.sLm.setSuperWrapper(this);
    AppMethodBeat.o(213132);
  }
  
  public final Object B(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(213524);
    paramString = super.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(213524);
    return paramString;
  }
  
  public final void Pa(boolean paramBoolean)
  {
    AppMethodBeat.i(213666);
    super.onPrefetchResourceHit(paramBoolean);
    AppMethodBeat.o(213666);
  }
  
  public final Object a(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(213531);
    paramString = super.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    AppMethodBeat.o(213531);
    return paramString;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(213568);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(213568);
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(213574);
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(213574);
  }
  
  public final void a(com.tencent.xweb.WebResourceRequest paramWebResourceRequest, com.tencent.xweb.WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    AppMethodBeat.i(213637);
    super.onResponseReceived(a.e.a(paramWebResourceRequest), com.tencent.xweb.x5.a.b(paramWebResourceResponse), paramInt);
    AppMethodBeat.o(213637);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(213484);
    super.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    AppMethodBeat.o(213484);
  }
  
  public final void a(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(213590);
    super.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
    AppMethodBeat.o(213590);
  }
  
  public final void a(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(213389);
    super.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    AppMethodBeat.o(213389);
  }
  
  public final void a(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(213398);
    super.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    AppMethodBeat.o(213398);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(213561);
    paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(213561);
    return paramBoolean;
  }
  
  public final boolean a(String paramString, com.tencent.xweb.JsResult paramJsResult)
  {
    AppMethodBeat.i(213601);
    boolean bool = super.notifyAutoAudioPlay(paramString, new a.c(paramJsResult));
    AppMethodBeat.o(213601);
    return bool;
  }
  
  public final boolean a(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(213618);
    paramBoolean = super.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    AppMethodBeat.o(213618);
    return paramBoolean;
  }
  
  public final void aJI(int paramInt)
  {
    AppMethodBeat.i(213420);
    super.onUploadProgressStart(paramInt);
    AppMethodBeat.o(213420);
  }
  
  public final void aJJ(int paramInt)
  {
    AppMethodBeat.i(213451);
    super.onSoftKeyBoardHide(paramInt);
    AppMethodBeat.o(213451);
  }
  
  public final void af(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(213425);
    super.onUploadProgressChange(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(213425);
  }
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213276);
    boolean bool = this.sLm.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    AppMethodBeat.o(213276);
    return bool;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213504);
    super.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    AppMethodBeat.o(213504);
  }
  
  public final boolean b(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(213538);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(213538);
    return bool;
  }
  
  public final void bIl(String paramString)
  {
    AppMethodBeat.i(213659);
    super.onReceivedViewSource(paramString);
    AppMethodBeat.o(213659);
  }
  
  public final void bK(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(213430);
    super.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(213430);
  }
  
  public final void bX(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213459);
    super.onSetButtonStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(213459);
  }
  
  public final boolean c(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(213546);
    boolean bool = super.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(213546);
    return bool;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(213256);
    this.sLm.computeScroll(paramView);
    AppMethodBeat.o(213256);
  }
  
  public final boolean d(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(213553);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(213553);
    return bool;
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    AppMethodBeat.i(213305);
    this.sLm.didFirstVisuallyNonEmptyPaint();
    AppMethodBeat.o(213305);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(213240);
    boolean bool = this.sLm.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(213240);
    return bool;
  }
  
  public void documentAvailableInMainFrame()
  {
    AppMethodBeat.i(213311);
    this.sLm.documentAvailableInMainFrame();
    AppMethodBeat.o(213311);
  }
  
  public final void ew(int paramInt, String paramString)
  {
    AppMethodBeat.i(213511);
    super.onReportHtmlInfo(paramInt, paramString);
    AppMethodBeat.o(213511);
  }
  
  public final void ex(int paramInt, String paramString)
  {
    AppMethodBeat.i(213516);
    super.onNativeCrashReport(paramInt, paramString);
    AppMethodBeat.o(213516);
  }
  
  public int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(213135);
    if (X5WebFactory.getInstance().getExtensionCallback() != null)
    {
      i = X5WebFactory.getInstance().getExtensionCallback().getHostByName(paramString, paramList);
      AppMethodBeat.o(213135);
      return i;
    }
    int i = super.getHostByName(paramString, paramList);
    AppMethodBeat.o(213135);
    return i;
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(213199);
    this.sLm.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    AppMethodBeat.o(213199);
  }
  
  public void hasDiscardCurrentPage(boolean paramBoolean)
  {
    AppMethodBeat.i(213345);
    this.sLm.hasDiscardCurrentPage(paramBoolean);
    AppMethodBeat.o(213345);
  }
  
  public void hideAddressBar()
  {
    AppMethodBeat.i(213193);
    this.sLm.hideAddressBar();
    AppMethodBeat.o(213193);
  }
  
  public final void i(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(213411);
    super.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(213411);
  }
  
  public void invalidate() {}
  
  public final void kiL()
  {
    AppMethodBeat.i(213353);
    super.onPreReadFinished();
    AppMethodBeat.o(213353);
  }
  
  public final void kiM()
  {
    AppMethodBeat.i(213362);
    super.onPromptScaleSaved();
    AppMethodBeat.o(213362);
  }
  
  public final void kiN()
  {
    AppMethodBeat.i(213381);
    super.onHideListBox();
    AppMethodBeat.o(213381);
  }
  
  public final void kiO()
  {
    AppMethodBeat.i(213406);
    super.onTransitionToCommitted();
    AppMethodBeat.o(213406);
  }
  
  public final void kiP()
  {
    AppMethodBeat.i(213433);
    super.onFlingScrollEnd();
    AppMethodBeat.o(213433);
  }
  
  public final void kiQ()
  {
    AppMethodBeat.i(213445);
    super.onSoftKeyBoardShow();
    AppMethodBeat.o(213445);
  }
  
  public final void kiR()
  {
    AppMethodBeat.i(213466);
    super.onHistoryItemChanged();
    AppMethodBeat.o(213466);
  }
  
  public final void kiS()
  {
    AppMethodBeat.i(213475);
    super.hideAddressBar();
    AppMethodBeat.o(213475);
  }
  
  public final void kiT()
  {
    AppMethodBeat.i(213487);
    super.onDoubleTapStart();
    AppMethodBeat.o(213487);
  }
  
  public final void kiU()
  {
    AppMethodBeat.i(213492);
    super.onPinchToZoomStart();
    AppMethodBeat.o(213492);
  }
  
  public final boolean kiV()
  {
    AppMethodBeat.i(213627);
    boolean bool = super.onShowLongClickPopupMenu();
    AppMethodBeat.o(213627);
    return bool;
  }
  
  public final void kiW()
  {
    AppMethodBeat.i(213645);
    super.didFirstVisuallyNonEmptyPaint();
    AppMethodBeat.o(213645);
  }
  
  public final void kiX()
  {
    AppMethodBeat.i(213652);
    super.documentAvailableInMainFrame();
    AppMethodBeat.o(213652);
  }
  
  public final void kiY()
  {
    AppMethodBeat.i(213675);
    super.onReceivedSslErrorCancel();
    AppMethodBeat.o(213675);
  }
  
  public final void m(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(213500);
    super.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    AppMethodBeat.o(213500);
  }
  
  public final void mP(View paramView)
  {
    AppMethodBeat.i(213583);
    super.computeScroll(paramView);
    AppMethodBeat.o(213583);
  }
  
  public boolean notifyAutoAudioPlay(String paramString, com.tencent.smtt.export.external.interfaces.JsResult paramJsResult)
  {
    AppMethodBeat.i(213268);
    boolean bool = this.sLm.notifyAutoAudioPlay(paramString, new d.g(paramJsResult));
    AppMethodBeat.o(213268);
    return bool;
  }
  
  public boolean notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(213285);
    paramBoolean = this.sLm.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    AppMethodBeat.o(213285);
    return paramBoolean;
  }
  
  public void onDoubleTapStart()
  {
    AppMethodBeat.i(213202);
    this.sLm.onDoubleTapStart();
    AppMethodBeat.o(213202);
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(213167);
    this.sLm.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(213167);
  }
  
  public void onFlingScrollEnd()
  {
    AppMethodBeat.i(213170);
    this.sLm.onFlingScrollEnd();
    AppMethodBeat.o(213170);
  }
  
  public void onHideListBox()
  {
    AppMethodBeat.i(213146);
    this.sLm.onHideListBox();
    AppMethodBeat.o(213146);
  }
  
  public void onHistoryItemChanged()
  {
    AppMethodBeat.i(213189);
    this.sLm.onHistoryItemChanged();
    AppMethodBeat.o(213189);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(213232);
    boolean bool = this.sLm.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(213232);
    return bool;
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(213262);
    this.sLm.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
    AppMethodBeat.o(213262);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(213224);
    paramString = this.sLm.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(213224);
    return paramString;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(213227);
    paramString = this.sLm.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    AppMethodBeat.o(213227);
    return paramString;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(213217);
    this.sLm.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    AppMethodBeat.o(213217);
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    AppMethodBeat.i(213222);
    this.sLm.onNativeCrashReport(paramInt, paramString);
    AppMethodBeat.o(213222);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(213250);
    this.sLm.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(213250);
  }
  
  public void onPinchToZoomStart()
  {
    AppMethodBeat.i(213208);
    this.sLm.onPinchToZoomStart();
    AppMethodBeat.o(213208);
  }
  
  public void onPreReadFinished()
  {
    AppMethodBeat.i(213138);
    this.sLm.onPreReadFinished();
    AppMethodBeat.o(213138);
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    AppMethodBeat.i(213326);
    this.sLm.onPrefetchResourceHit(paramBoolean);
    AppMethodBeat.o(213326);
  }
  
  public void onPromptScaleSaved()
  {
    AppMethodBeat.i(213140);
    this.sLm.onPromptScaleSaved();
    AppMethodBeat.o(213140);
  }
  
  public void onReceivedSslErrorCancel()
  {
    AppMethodBeat.i(213331);
    this.sLm.onReceivedSslErrorCancel();
    AppMethodBeat.o(213331);
  }
  
  public void onReceivedViewSource(String paramString)
  {
    AppMethodBeat.i(213319);
    this.sLm.onReceivedViewSource(paramString);
    AppMethodBeat.o(213319);
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213218);
    this.sLm.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    AppMethodBeat.o(213218);
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(213219);
    this.sLm.onReportHtmlInfo(paramInt, paramString);
    AppMethodBeat.o(213219);
  }
  
  public void onResponseReceived(com.tencent.smtt.export.external.interfaces.WebResourceRequest paramWebResourceRequest, com.tencent.smtt.export.external.interfaces.WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    AppMethodBeat.i(213298);
    this.sLm.onResponseReceived(new d.b(paramWebResourceRequest), com.tencent.xweb.x5.d.a(paramWebResourceResponse), paramInt);
    AppMethodBeat.o(213298);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(213172);
    this.sLm.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(213172);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(213245);
    this.sLm.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(213245);
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213185);
    this.sLm.onSetButtonStatus(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(213185);
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(213148);
    this.sLm.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    AppMethodBeat.o(213148);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(213292);
    boolean bool = this.sLm.onShowLongClickPopupMenu();
    AppMethodBeat.o(213292);
    return bool;
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(213151);
    this.sLm.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    AppMethodBeat.o(213151);
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213213);
    this.sLm.onSlidingTitleOffScreen(paramInt1, paramInt2);
    AppMethodBeat.o(213213);
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    AppMethodBeat.i(213181);
    this.sLm.onSoftKeyBoardHide(paramInt);
    AppMethodBeat.o(213181);
  }
  
  public void onSoftKeyBoardShow()
  {
    AppMethodBeat.i(213176);
    this.sLm.onSoftKeyBoardShow();
    AppMethodBeat.o(213176);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(213235);
    boolean bool = this.sLm.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(213235);
    return bool;
  }
  
  public void onTransitionToCommitted()
  {
    AppMethodBeat.i(213152);
    this.sLm.onTransitionToCommitted();
    AppMethodBeat.o(213152);
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(213163);
    this.sLm.onUploadProgressChange(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(213163);
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    AppMethodBeat.i(213160);
    this.sLm.onUploadProgressStart(paramInt);
    AppMethodBeat.o(213160);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213142);
    this.sLm.onUrlChange(paramString1, paramString2);
    AppMethodBeat.o(213142);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(213242);
    paramBoolean = this.sLm.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(213242);
    return paramBoolean;
  }
  
  public final void qg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213495);
    super.onSlidingTitleOffScreen(paramInt1, paramInt2);
    AppMethodBeat.o(213495);
  }
  
  public final void re(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213372);
    super.onUrlChange(paramString1, paramString2);
    AppMethodBeat.o(213372);
  }
  
  public final boolean rf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213609);
    boolean bool = super.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    AppMethodBeat.o(213609);
    return bool;
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    AppMethodBeat.i(213340);
    boolean bool = this.sLm.shouldDiscardCurrentPage();
    AppMethodBeat.o(213340);
    return bool;
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(213156);
    this.sLm.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(213156);
  }
  
  public final void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(213441);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(213441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.xweb.x5.a.d
 * JD-Core Version:    0.7.0.1
 */