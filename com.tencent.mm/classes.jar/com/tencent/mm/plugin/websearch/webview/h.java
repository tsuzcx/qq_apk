package com.tencent.mm.plugin.websearch.webview;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.xweb.af;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchCallbackClient;", "Lcom/tencent/xweb/WebViewCallbackClient;", "scrollListener", "Lcom/tencent/mm/ui/widget/MMWebView$MMScrollListener;", "webSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "(Lcom/tencent/mm/ui/widget/MMWebView$MMScrollListener;Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;)V", "getScrollListener", "()Lcom/tencent/mm/ui/widget/MMWebView$MMScrollListener;", "getWebSearchWebView", "()Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "computeScroll", "", "view", "Landroid/view/View;", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "varview2", "invalidate", "onContentHeightChanged", "height", "", "onInterceptTouchEvent", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "webContentView", "onScrollChanged", "var1", "var2", "var3", "var4", "var5", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements af
{
  private final MMWebView.b WrR;
  private final WebSearchWebView WrS;
  
  public h(MMWebView.b paramb, WebSearchWebView paramWebSearchWebView)
  {
    AppMethodBeat.i(315223);
    this.WrR = paramb;
    this.WrS = paramWebSearchWebView;
    AppMethodBeat.o(315223);
  }
  
  public final void Bv(int paramInt) {}
  
  public final void computeScroll(View paramView) {}
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return false;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return false;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return false;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(315232);
    paramBoolean = this.WrR.S(paramInt1, paramInt2, paramInt3, paramInt5);
    this.WrS.setHorizontalScrollPage(paramBoolean);
    AppMethodBeat.o(315232);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.h
 * JD-Core Version:    0.7.0.1
 */