package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;

public final class MMWebView$a
{
  public static MMWebView iH(Context paramContext)
  {
    AppMethodBeat.i(107935);
    try
    {
      ab.i("MMWebView", "TRACE_ORDER:MMWebView.java");
      WebView.initWebviewCore(paramContext, MMWebView.ADX, "tools", null);
      MMWebView.iG(paramContext);
      paramContext = new MMWebView(paramContext, null, 0, WebView.d.BEs);
      paramContext.inited = true;
      MMWebView.b(paramContext, paramContext.getIsX5Kernel());
      AppMethodBeat.o(107935);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(107935);
    }
    return null;
  }
  
  public static MMWebView iI(Context paramContext)
  {
    AppMethodBeat.i(107936);
    ab.i("MMWebView", "TRACE_ORDER:MMWebView.java");
    WebView.initWebviewCore(paramContext, MMWebView.ADX, "tools", null);
    MMWebView.iG(paramContext);
    paramContext = new MMWebView(paramContext);
    paramContext.inited = true;
    MMWebView.c(paramContext, paramContext.getIsX5Kernel());
    AppMethodBeat.o(107936);
    return paramContext;
  }
  
  public static MMWebView p(Activity paramActivity, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(107937);
    MMWebView.iG(paramActivity);
    paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
    paramActivity.inited = true;
    if (paramActivity.getX5WebViewExtension() != null) {}
    for (;;)
    {
      MMWebView.d(paramActivity, bool);
      AppMethodBeat.o(107937);
      return paramActivity;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMWebView.a
 * JD-Core Version:    0.7.0.1
 */