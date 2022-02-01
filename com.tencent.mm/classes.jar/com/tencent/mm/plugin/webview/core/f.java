package com.tencent.mm.plugin.webview.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.v;
import d.y;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "canDebug", "", "processCommand", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "showToast", "", "tag", "content", "Companion", "webview-sdk_release"})
public final class f
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a ALW;
  
  static
  {
    AppMethodBeat.i(189357);
    ALW = new a((byte)0);
    AppMethodBeat.o(189357);
  }
  
  public static final void Bu()
  {
    AppMethodBeat.i(189358);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new f(), new String[] { "//webview" });
    AppMethodBeat.o(189358);
  }
  
  private static boolean ejp()
  {
    AppMethodBeat.i(189354);
    if ((h.IS_FLAVOR_RED) || (h.DEBUG) || ((ad.getLogLevel() == 0) && (bu.eGT())))
    {
      AppMethodBeat.o(189354);
      return true;
    }
    AppMethodBeat.o(189354);
    return false;
  }
  
  private static void er(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189355);
    if (!ejp())
    {
      AppMethodBeat.o(189355);
      return;
    }
    c.g((d.g.a.a)new b(paramString2));
    ad.i(paramString1, paramString2);
    AppMethodBeat.o(189355);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    paramString = null;
    AppMethodBeat.i(189356);
    if (!ejp())
    {
      AppMethodBeat.o(189356);
      return false;
    }
    if (paramArrayOfString != null) {}
    for (paramContext = d.g.b.b.ab(paramArrayOfString);; paramContext = null)
    {
      if (paramContext != null) {
        paramString = (String)paramContext.next();
      }
      if (!(k.g(paramString, "//webview") ^ true)) {
        break;
      }
      AppMethodBeat.o(189356);
      return false;
    }
    paramContext = (String)paramContext.next();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(189356);
      throw paramContext;
    }
    paramContext = paramContext.toLowerCase();
    k.g(paramContext, "(this as java.lang.String).toLowerCase()");
    switch (paramContext.hashCode())
    {
    }
    do
    {
      AppMethodBeat.o(189356);
      return false;
    } while (!paramContext.equals("commit"));
    if (paramArrayOfString.length <= 2)
    {
      AppMethodBeat.o(189356);
      return false;
    }
    paramContext = paramArrayOfString[2];
    switch (paramContext.hashCode())
    {
    default: 
    case 3556498: 
      do
      {
        AppMethodBeat.o(189356);
        return false;
      } while (!paramContext.equals("test"));
      g.buO().putBoolean("webview_page_commit_mock", true);
      er("WebViewCommand", "commit mock enable");
    }
    for (;;)
    {
      AppMethodBeat.o(189356);
      return true;
      if (!paramContext.equals("reset")) {
        break;
      }
      g.buO().putBoolean("webview_page_commit_mock", false);
      er("WebViewCommand", "commit mock reset");
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand$Companion;", "", "()V", "TAG", "", "WEB_VIEW_PAGE_COMMIT_MOCK", "command", "commitTestNotCall", "", "register", "", "webview-sdk_release"})
  public static final class a
  {
    public static boolean ejq()
    {
      AppMethodBeat.i(189352);
      boolean bool = g.buO().getBoolean("webview_page_commit_mock", false);
      AppMethodBeat.o(189352);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.f
 * JD-Core Version:    0.7.0.1
 */