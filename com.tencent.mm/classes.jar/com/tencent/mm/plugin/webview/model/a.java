package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.regex.Pattern;

public final class a
{
  private static Pattern CoT = null;
  
  public static void a(final MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(188313);
    if (paramMMWebView == null)
    {
      ac.e("MicroMsg.AutoPlayLogic", "webView null");
      AppMethodBeat.o(188313);
      return;
    }
    ac.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188313);
      return;
    }
    p.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78831);
        p.z(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(78830);
            if (this.val$enable)
            {
              a.a(a.1.this.CoU, true);
              ac.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
              AppMethodBeat.o(78830);
              return;
            }
            a.a(a.1.this.CoU, false);
            ac.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
            AppMethodBeat.o(78830);
          }
        });
        AppMethodBeat.o(78831);
      }
    });
    AppMethodBeat.o(188313);
  }
  
  public static void d(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(78832);
    if (paramMMWebView == null)
    {
      ac.e("MicroMsg.AutoPlayLogic", "webView null");
      AppMethodBeat.o(78832);
      return;
    }
    String str = paramMMWebView.getUrl();
    ac.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[] { str });
    if (bs.isNullOrNil(str))
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