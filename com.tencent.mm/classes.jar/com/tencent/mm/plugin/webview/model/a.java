package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.webview.k.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.regex.Pattern;

public final class a
{
  private static Pattern Ekr = null;
  
  public static void a(final MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(198111);
    if (paramMMWebView == null)
    {
      ae.e("MicroMsg.AutoPlayLogic", "webView null");
      AppMethodBeat.o(198111);
      return;
    }
    ae.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(198111);
      return;
    }
    if (paramString.startsWith(c.getScheme()))
    {
      AppMethodBeat.o(198111);
      return;
    }
    p.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78831);
        p.x(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(78830);
            if (this.val$enable)
            {
              a.a(a.1.this.Eks, true);
              ae.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
              AppMethodBeat.o(78830);
              return;
            }
            a.a(a.1.this.Eks, false);
            ae.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
            AppMethodBeat.o(78830);
          }
        });
        AppMethodBeat.o(78831);
      }
    });
    AppMethodBeat.o(198111);
  }
  
  public static void e(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(78832);
    if (paramMMWebView == null)
    {
      ae.e("MicroMsg.AutoPlayLogic", "webView null");
      AppMethodBeat.o(78832);
      return;
    }
    String str = paramMMWebView.getUrl();
    ae.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[] { str });
    if (bu.isNullOrNil(str))
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