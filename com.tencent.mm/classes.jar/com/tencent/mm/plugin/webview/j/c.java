package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ad;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/snapshot/WebViewSnapshotUtil;", "", "()V", "BUFFER_PADDING", "", "createSnapShotWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "createWebViewController", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "webView", "setupSnapShotWebViewWithScrollView", "", "snapShotPageWebView", "snapShotPageScrollView", "Landroid/widget/ScrollView;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c WRk;
  
  static
  {
    AppMethodBeat.i(294738);
    WRk = new c();
    AppMethodBeat.o(294738);
  }
  
  private static final void a(ScrollView paramScrollView, MMWebView paramMMWebView, float paramFloat)
  {
    AppMethodBeat.i(294734);
    s.u(paramScrollView, "$snapShotPageScrollView");
    int i = paramScrollView.getScrollY() + 2;
    int j = paramScrollView.getScrollX();
    if (paramMMWebView.isXWalkKernel())
    {
      paramMMWebView.evaluateJavascript(Util.safeFormatString("window.document.scrollingElement.scrollTop = %d;", new Object[] { Integer.valueOf((int)(i / paramFloat)) }), null);
      AppMethodBeat.o(294734);
      return;
    }
    paramMMWebView.getView().scrollTo(j, i);
    AppMethodBeat.o(294734);
  }
  
  public static final void a(MMWebView paramMMWebView, ScrollView paramScrollView)
  {
    AppMethodBeat.i(294726);
    s.u(paramScrollView, "snapShotPageScrollView");
    if (paramMMWebView == null)
    {
      AppMethodBeat.o(294726);
      return;
    }
    float f = paramMMWebView.getScale();
    paramScrollView.getViewTreeObserver().addOnScrollChangedListener(new c..ExternalSyntheticLambda0(paramScrollView, paramMMWebView, f));
    AppMethodBeat.o(294726);
  }
  
  public static final k i(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(294719);
    s.u(paramMMWebView, "webView");
    paramMMWebView = new k(paramMMWebView, null, new BaseWebViewController.d(null, false, false, false, false, true, 63), (Set)ad.aivA, null, 18);
    AppMethodBeat.o(294719);
    return paramMMWebView;
  }
  
  public static final MMWebView kR(Context paramContext)
  {
    AppMethodBeat.i(294712);
    s.u(paramContext, "context");
    paramContext = MMWebView.a.nK(paramContext);
    s.s(paramContext, "snapshotWebView");
    AppMethodBeat.o(294712);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.c
 * JD-Core Version:    0.7.0.1
 */