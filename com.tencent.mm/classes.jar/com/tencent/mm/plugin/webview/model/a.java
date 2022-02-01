package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.webview.l.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.regex.Pattern;

public final class a
{
  private static final String IXo;
  private static Pattern IXp;
  
  static
  {
    AppMethodBeat.i(210970);
    IXo = "(http(s)?://" + WeChatHosts.domainString(2131761726) + "/(.*)|http(s)?://" + WeChatHosts.domainString(2131761707) + "/(.*)|http(s)?://([^?#&/]*.)?weishi.com/(.*)|http(s)?://([^?#&/]*.)?weishi.qq.com/(.*)|http(s)?://([^?#&/]*.)?view.inews.qq.com/(.*))";
    IXp = null;
    AppMethodBeat.o(210970);
  }
  
  public static void a(final MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(210969);
    if (paramMMWebView == null)
    {
      Log.e("MicroMsg.AutoPlayLogic", "webView null");
      AppMethodBeat.o(210969);
      return;
    }
    Log.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(210969);
      return;
    }
    if (paramString.startsWith(c.getScheme()))
    {
      AppMethodBeat.o(210969);
      return;
    }
    p.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78831);
        p.y(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(78830);
            if (this.val$enable)
            {
              a.a(a.1.this.IXq, true);
              Log.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
              AppMethodBeat.o(78830);
              return;
            }
            a.a(a.1.this.IXq, false);
            Log.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
            AppMethodBeat.o(78830);
          }
        });
        AppMethodBeat.o(78831);
      }
    });
    AppMethodBeat.o(210969);
  }
  
  public static void e(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(78832);
    if (paramMMWebView == null)
    {
      Log.e("MicroMsg.AutoPlayLogic", "webView null");
      AppMethodBeat.o(78832);
      return;
    }
    String str = paramMMWebView.getUrl();
    Log.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[] { str });
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(78832);
      return;
    }
    a(paramMMWebView, str);
    AppMethodBeat.o(78832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.a
 * JD-Core Version:    0.7.0.1
 */