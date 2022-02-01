package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.regex.Pattern;

public final class a
{
  private static final String WKq;
  private static String WKr;
  private static Pattern WKs;
  
  static
  {
    AppMethodBeat.i(298389);
    WKq = "(http(s)?://" + WeChatHosts.domainString(c.i.host_mp_weixin_qq_com) + "/(.*)|http(s)?://" + WeChatHosts.domainString(c.i.host_game_weixin_qq_com) + "/(.*)|http(s)?://([^?#&/]*.)?weishi.com/(.*)|http(s)?://([^?#&/]*.)?weishi.qq.com/(.*)|http(s)?://([^?#&/]*.)?view.inews.qq.com/(.*))";
    WKr = "";
    WKs = null;
    AppMethodBeat.o(298389);
  }
  
  public static void c(final MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(298380);
    if (paramMMWebView == null)
    {
      Log.e("MicroMsg.AutoPlayLogic", "webView null");
      AppMethodBeat.o(298380);
      return;
    }
    Log.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(298380);
      return;
    }
    if (paramString.startsWith("webcompt://"))
    {
      AppMethodBeat.o(298380);
      return;
    }
    s.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78831);
        s.D(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(78830);
            if (this.val$enable)
            {
              a.a(a.1.this.WKt, true);
              Log.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
              AppMethodBeat.o(78830);
              return;
            }
            a.a(a.1.this.WKt, false);
            Log.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
            AppMethodBeat.o(78830);
          }
        });
        AppMethodBeat.o(78831);
      }
    });
    AppMethodBeat.o(298380);
  }
  
  public static void h(MMWebView paramMMWebView)
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
    c(paramMMWebView, str);
    AppMethodBeat.o(78832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.a
 * JD-Core Version:    0.7.0.1
 */