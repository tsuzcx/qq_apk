package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;

public final class MMWebView$a
{
  public static MMWebView cO(Context paramContext)
  {
    y.i("MMWebView", "TRACE_ORDER:MMWebView.java");
    WebView.initWebviewCore(paramContext, MMWebView.wkp, "tools", null);
    MMWebView.hi(paramContext);
    paramContext = new MMWebView(paramContext);
    paramContext.dyX = true;
    MMWebView.c(paramContext, paramContext.getIsX5Kernel());
    return paramContext;
  }
  
  public static MMWebView hj(Context paramContext)
  {
    try
    {
      y.i("MMWebView", "TRACE_ORDER:MMWebView.java");
      WebView.initWebviewCore(paramContext, MMWebView.wkp, "tools", null);
      MMWebView.hi(paramContext);
      paramContext = new MMWebView(paramContext, null, 0, WebView.d.xhq);
      paramContext.dyX = true;
      MMWebView.b(paramContext, paramContext.getIsX5Kernel());
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static MMWebView m(Activity paramActivity, int paramInt)
  {
    boolean bool = true;
    MMWebView.hi(paramActivity);
    paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
    paramActivity.dyX = true;
    if (paramActivity.getX5WebViewExtension() != null) {}
    for (;;)
    {
      MMWebView.d(paramActivity, bool);
      return paramActivity;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMWebView.a
 * JD-Core Version:    0.7.0.1
 */