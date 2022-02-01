package com.tencent.mm.plugin.webview.core;

import android.content.Context;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "showToast", "", "tag", "content", "Companion", "webview-sdk_release"})
public final class f
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a DHt;
  
  static
  {
    AppMethodBeat.i(214278);
    DHt = new a((byte)0);
    AppMethodBeat.o(214278);
  }
  
  public static final void Cx()
  {
    AppMethodBeat.i(214279);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new f(), new String[] { "//webview" });
    AppMethodBeat.o(214279);
  }
  
  private static void eN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214276);
    if (!a.eNz())
    {
      AppMethodBeat.o(214276);
      return;
    }
    c.g((d.g.a.a)new b(paramString2));
    ad.i(paramString1, paramString2);
    AppMethodBeat.o(214276);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    paramString = null;
    AppMethodBeat.i(214277);
    if (!a.eNz())
    {
      AppMethodBeat.o(214277);
      return false;
    }
    if (paramArrayOfString != null) {}
    for (paramContext = d.g.b.b.ae(paramArrayOfString);; paramContext = null)
    {
      if (paramContext != null) {
        paramString = (String)paramContext.next();
      }
      if (!(p.i(paramString, "//webview") ^ true)) {
        break;
      }
      AppMethodBeat.o(214277);
      return false;
    }
    paramContext = (String)paramContext.next();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(214277);
      throw paramContext;
    }
    paramContext = paramContext.toLowerCase();
    p.g(paramContext, "(this as java.lang.String).toLowerCase()");
    switch (paramContext.hashCode())
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(214277);
        return false;
      } while (!paramContext.equals("preauth"));
      if (paramArrayOfString.length > 2) {
        break;
      }
      AppMethodBeat.o(214277);
      return false;
    } while (!paramContext.equals("commit"));
    if (paramArrayOfString.length <= 2)
    {
      AppMethodBeat.o(214277);
      return false;
    }
    paramContext = paramArrayOfString[2];
    switch (paramContext.hashCode())
    {
    default: 
    case 3556498: 
      do
      {
        AppMethodBeat.o(214277);
        return false;
      } while (!paramContext.equals("test"));
      g.bFO().putBoolean("webview_page_commit_mock", true);
      eN("WebViewCommand", "commit mock enable");
    }
    for (;;)
    {
      AppMethodBeat.o(214277);
      return true;
      if (!paramContext.equals("reset")) {
        break;
      }
      g.bFO().putBoolean("webview_page_commit_mock", false);
      eN("WebViewCommand", "commit mock reset");
    }
    paramArrayOfString = paramArrayOfString[2];
    paramContext = new d.a();
    paramContext.url = paramArrayOfString;
    paramContext.nWh = 998;
    CronetLogic.setUserCertVerify(true);
    g.bFO().putBoolean("webview_use_a8key_lite_header", true);
    paramArrayOfString = (d)com.tencent.mm.kernel.g.ab(d.class);
    paramString = new ArrayList();
    paramString.add(paramContext);
    paramArrayOfString.cd((List)paramString);
    AppMethodBeat.o(214277);
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand$Companion;", "", "()V", "COMMAND_SCENE", "", "TAG", "", "WEB_VIEW_PAGE_COMMIT_MOCK", "WEB_VIEW_USE_A8KEY_LITE_HEADER", "command", "canDebug", "", "commitTestNotCall", "register", "", "useA8keyLiteHeader", "webview-sdk_release"})
  public static final class a
  {
    public static boolean eNA()
    {
      AppMethodBeat.i(214274);
      boolean bool = g.bFO().getBoolean("webview_page_commit_mock", false);
      AppMethodBeat.o(214274);
      return bool;
    }
    
    public static boolean eNz()
    {
      AppMethodBeat.i(214273);
      if ((i.IS_FLAVOR_RED) || (i.DEBUG) || ((ad.getLogLevel() == 0) && (bu.flY())))
      {
        AppMethodBeat.o(214273);
        return true;
      }
      AppMethodBeat.o(214273);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
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