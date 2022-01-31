package com.tencent.xweb.c;

import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class j
{
  static j.a xjA;
  static j.a xjy;
  static j.a xjz;
  
  public static h a(WebView.d paramd, WebView paramWebView)
  {
    Object localObject2 = null;
    c localc = c.b("CREATE_WEBVIEW", paramd);
    localc.cSG();
    Object localObject1 = localObject2;
    try
    {
      if (c(paramd) == null)
      {
        localObject1 = localObject2;
        Log.e("WebViewWrapperFactory", "the kind of " + paramd + " this provider does not exist!");
        return null;
      }
      localObject1 = localObject2;
      paramWebView = c(paramd).createWebView(paramWebView);
      if (paramWebView != null)
      {
        localObject1 = paramWebView;
        localc.cSH();
        return paramWebView;
      }
    }
    catch (Exception paramWebView)
    {
      XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview with exception  type = " + paramd + ", error msg:" + paramWebView.getMessage());
      e.g(paramd);
      return localObject1;
    }
    localObject1 = paramWebView;
    XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview failed type = " + paramd);
    return paramWebView;
  }
  
  public static j.a c(WebView.d paramd)
  {
    if (paramd == WebView.d.xho)
    {
      if (xjy == null)
      {
        paramd = d.gS("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
        if ((paramd == null) || (!(paramd instanceof j.a)))
        {
          Log.e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
          return null;
        }
        xjy = (j.a)paramd;
      }
      return xjy;
    }
    if (paramd == WebView.d.xhp)
    {
      if (xjz == null)
      {
        paramd = d.gS("com.tencent.xweb.x5.X5WebFactory", "getInstance");
        if ((paramd == null) || (!(paramd instanceof j.a)))
        {
          Log.e("WebViewWrapperFactory", "find X5WebFactory failed");
          return null;
        }
        xjz = (j.a)paramd;
      }
      return xjz;
    }
    if (paramd == WebView.d.xhq)
    {
      if (xjA == null)
      {
        paramd = d.gS("com.tencent.xweb.sys.SysWebFactory", "getInstance");
        if ((paramd == null) || (!(paramd instanceof j.a)))
        {
          Log.e("WebViewWrapperFactory", "find SysWebFactory failed");
          return null;
        }
        xjA = (j.a)paramd;
      }
      return xjA;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.c.j
 * JD-Core Version:    0.7.0.1
 */