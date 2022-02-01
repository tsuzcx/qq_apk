package com.tencent.mm.plugin.webview.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "canDebug", "", "processCommand", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "showToast", "", "tag", "content", "Companion", "webview-sdk_release"})
public final class f
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a Cep;
  
  static
  {
    AppMethodBeat.i(205489);
    Cep = new a((byte)0);
    AppMethodBeat.o(205489);
  }
  
  public static final void AY()
  {
    AppMethodBeat.i(205490);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new f(), new String[] { "//webview" });
    AppMethodBeat.o(205490);
  }
  
  private static void eD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205487);
    if (!eyK())
    {
      AppMethodBeat.o(205487);
      return;
    }
    c.g((d.g.a.a)new b(paramString2));
    ac.i(paramString1, paramString2);
    AppMethodBeat.o(205487);
  }
  
  private static boolean eyK()
  {
    AppMethodBeat.i(205486);
    if ((h.IS_FLAVOR_RED) || (h.DEBUG) || ((ac.getLogLevel() == 0) && (bt.eWo())))
    {
      AppMethodBeat.o(205486);
      return true;
    }
    AppMethodBeat.o(205486);
    return false;
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    paramString = null;
    AppMethodBeat.i(205488);
    if (!eyK())
    {
      AppMethodBeat.o(205488);
      return false;
    }
    if (paramArrayOfString != null) {}
    for (paramContext = d.g.b.b.ad(paramArrayOfString);; paramContext = null)
    {
      if (paramContext != null) {
        paramString = (String)paramContext.next();
      }
      if (!(k.g(paramString, "//webview") ^ true)) {
        break;
      }
      AppMethodBeat.o(205488);
      return false;
    }
    paramContext = (String)paramContext.next();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(205488);
      throw paramContext;
    }
    paramContext = paramContext.toLowerCase();
    k.g(paramContext, "(this as java.lang.String).toLowerCase()");
    switch (paramContext.hashCode())
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(205488);
        return false;
      } while (!paramContext.equals("preauth"));
      if (paramArrayOfString.length > 2) {
        break;
      }
      AppMethodBeat.o(205488);
      return false;
    } while (!paramContext.equals("commit"));
    if (paramArrayOfString.length <= 2)
    {
      AppMethodBeat.o(205488);
      return false;
    }
    paramContext = paramArrayOfString[2];
    switch (paramContext.hashCode())
    {
    default: 
    case 3556498: 
      do
      {
        AppMethodBeat.o(205488);
        return false;
      } while (!paramContext.equals("test"));
      g.bBL().putBoolean("webview_page_commit_mock", true);
      eD("WebViewCommand", "commit mock enable");
    }
    for (;;)
    {
      AppMethodBeat.o(205488);
      return true;
      if (!paramContext.equals("reset")) {
        break;
      }
      g.bBL().putBoolean("webview_page_commit_mock", false);
      eD("WebViewCommand", "commit mock reset");
    }
    paramArrayOfString = paramArrayOfString[2];
    paramContext = new d.a();
    paramContext.url = paramArrayOfString;
    paramArrayOfString = (d)com.tencent.mm.kernel.g.ab(d.class);
    paramString = new ArrayList();
    paramString.add(paramContext);
    paramArrayOfString.cc((List)paramString);
    AppMethodBeat.o(205488);
    return true;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand$Companion;", "", "()V", "TAG", "", "WEB_VIEW_PAGE_COMMIT_MOCK", "command", "commitTestNotCall", "", "register", "", "webview-sdk_release"})
  public static final class a
  {
    public static boolean eyL()
    {
      AppMethodBeat.i(205484);
      boolean bool = g.bBL().getBoolean("webview_page_commit_mock", false);
      AppMethodBeat.o(205484);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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