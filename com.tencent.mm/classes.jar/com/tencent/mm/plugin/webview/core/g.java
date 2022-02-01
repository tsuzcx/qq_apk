package com.tencent.mm.plugin.webview.core;

import android.content.Context;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "showToast", "", "tag", "content", "Companion", "webview-sdk_release"})
public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a ILB;
  private static final f UtD;
  
  static
  {
    AppMethodBeat.i(225049);
    ILB = new a((byte)0);
    UtD = kotlin.g.ah((kotlin.g.a.a)g.c.UtE);
    AppMethodBeat.o(225049);
  }
  
  public static final void LW()
  {
    AppMethodBeat.i(225050);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new g(), new String[] { "//webview" });
    AppMethodBeat.o(225050);
  }
  
  private static void fh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225047);
    if (!a.fZP())
    {
      AppMethodBeat.o(225047);
      return;
    }
    d.h((kotlin.g.a.a)new b(paramString2));
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(225047);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    paramString = null;
    AppMethodBeat.i(225048);
    if (!a.fZP())
    {
      AppMethodBeat.o(225048);
      return false;
    }
    if (paramArrayOfString != null) {}
    for (paramContext = kotlin.g.b.b.af(paramArrayOfString);; paramContext = null)
    {
      if (paramContext != null) {
        paramString = (String)paramContext.next();
      }
      if (!(p.j(paramString, "//webview") ^ true)) {
        break;
      }
      AppMethodBeat.o(225048);
      return false;
    }
    paramContext = (String)paramContext.next();
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(225048);
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
        do
        {
          AppMethodBeat.o(225048);
          return false;
        } while (!paramContext.equals("prefetchpkg"));
        if (paramArrayOfString.length > 2) {
          break;
        }
        AppMethodBeat.o(225048);
        return false;
      } while (!paramContext.equals("preauth"));
      if (paramArrayOfString.length > 2) {
        break;
      }
      AppMethodBeat.o(225048);
      return false;
    } while (!paramContext.equals("commit"));
    if (paramArrayOfString.length <= 2)
    {
      AppMethodBeat.o(225048);
      return false;
    }
    paramContext = paramArrayOfString[2];
    switch (paramContext.hashCode())
    {
    default: 
    case 3556498: 
      do
      {
        AppMethodBeat.o(225048);
        return false;
      } while (!paramContext.equals("test"));
      h.cdi().putBoolean("webview_page_commit_mock", true);
      fh("WebViewCommand", "commit mock enable");
    }
    for (;;)
    {
      AppMethodBeat.o(225048);
      return true;
      if (!paramContext.equals("reset")) {
        break;
      }
      h.cdi().putBoolean("webview_page_commit_mock", false);
      fh("WebViewCommand", "commit mock reset");
    }
    paramArrayOfString = paramArrayOfString[2];
    paramContext = new e.a();
    paramContext.url = paramArrayOfString;
    paramContext.pmM = 998;
    paramContext.pmN = 10001;
    CronetLogic.setUserCertVerify(true);
    h.cdi().putBoolean("webview_use_a8key_lite_header", true);
    paramArrayOfString = (e)com.tencent.mm.kernel.g.af(e.class);
    paramString = new ArrayList();
    paramString.add(paramContext);
    paramArrayOfString.cu((List)paramString);
    AppMethodBeat.o(225048);
    return true;
    h.cdi().putInt("prefetchUsePkg", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(225048);
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand$Companion;", "", "()V", "COMMAND_SCENE", "", "COMMAND_SUB_SCENE", "TAG", "", "WEB_VIEW_PAGE_COMMIT_MOCK", "WEB_VIEW_USE_A8KEY_LITE_HEADER", "command", "webViewActivityTranslucent", "", "getWebViewActivityTranslucent", "()Z", "webViewActivityTranslucent$delegate", "Lkotlin/Lazy;", "canDebug", "commitTestNotCall", "isDebug", "prefetchUsePkg", "register", "", "useA8keyLiteHeader", "webview-sdk_release"})
  public static final class a
  {
    public static boolean KB()
    {
      AppMethodBeat.i(225043);
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
      {
        AppMethodBeat.o(225043);
        return true;
      }
      AppMethodBeat.o(225043);
      return false;
    }
    
    public static boolean fZP()
    {
      AppMethodBeat.i(225044);
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || ((Log.getLogLevel() == 0) && (WeChatEnvironment.hasDebugger())))
      {
        AppMethodBeat.o(225044);
        return true;
      }
      AppMethodBeat.o(225044);
      return false;
    }
    
    public static boolean fZQ()
    {
      AppMethodBeat.i(225045);
      boolean bool = h.cdi().getBoolean("webview_page_commit_mock", false);
      AppMethodBeat.o(225045);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.g
 * JD-Core Version:    0.7.0.1
 */