package com.tencent.xweb.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.f;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class l
{
  static l.a BHd;
  static l.a BHe;
  static l.a BHf;
  
  public static i a(WebView.d paramd, WebView paramWebView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(3994);
    Log.i("WebViewWrapperFactory", "try to create webview  = ".concat(String.valueOf(paramd)));
    c localc = c.c("CREATE_WEBVIEW", paramd);
    localc.dYN();
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (e(paramd) == null)
        {
          localObject1 = localObject2;
          Log.e("WebViewWrapperFactory", "the kind of " + paramd + " this provider does not exist!");
          AppMethodBeat.o(3994);
          return null;
        }
        localObject1 = localObject2;
        paramWebView = e(paramd).createWebView(paramWebView);
        if (paramWebView == null) {
          continue;
        }
        localObject1 = paramWebView;
        localc.dYO();
      }
      catch (Exception paramWebView)
      {
        XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview with exception  type = " + paramd + ", error msg:" + paramWebView.getMessage());
        f.j(paramd);
        paramWebView = (WebView)localObject1;
        continue;
      }
      AppMethodBeat.o(3994);
      return paramWebView;
      localObject1 = paramWebView;
      XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview failed type = ".concat(String.valueOf(paramd)));
    }
  }
  
  public static l.a e(WebView.d paramd)
  {
    AppMethodBeat.i(3993);
    if (paramd == WebView.d.BEq)
    {
      if (BHd == null)
      {
        paramd = e.je("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
        if ((paramd == null) || (!(paramd instanceof l.a)))
        {
          Log.e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
          AppMethodBeat.o(3993);
          return null;
        }
        BHd = (l.a)paramd;
      }
      paramd = BHd;
      AppMethodBeat.o(3993);
      return paramd;
    }
    if (paramd == WebView.d.BEr)
    {
      if (BHe == null)
      {
        paramd = e.je("com.tencent.xweb.x5.X5WebFactory", "getInstance");
        if ((paramd == null) || (!(paramd instanceof l.a)))
        {
          Log.e("WebViewWrapperFactory", "find X5WebFactory failed");
          AppMethodBeat.o(3993);
          return null;
        }
        BHe = (l.a)paramd;
      }
      paramd = BHe;
      AppMethodBeat.o(3993);
      return paramd;
    }
    if (paramd == WebView.d.BEs)
    {
      if (BHf == null)
      {
        paramd = e.je("com.tencent.xweb.sys.SysWebFactory", "getInstance");
        if ((paramd == null) || (!(paramd instanceof l.a)))
        {
          Log.e("WebViewWrapperFactory", "find SysWebFactory failed");
          AppMethodBeat.o(3993);
          return null;
        }
        BHf = (l.a)paramd;
      }
      paramd = BHf;
      AppMethodBeat.o(3993);
      return paramd;
    }
    AppMethodBeat.o(3993);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.c.l
 * JD-Core Version:    0.7.0.1
 */