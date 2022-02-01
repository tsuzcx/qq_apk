package com.tencent.mm.plugin.webview.core;

import android.content.Context;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "showToast", "", "tag", "content", "Companion", "webview-sdk_release"})
public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final kotlin.f PHC;
  public static final a PHD;
  
  static
  {
    AppMethodBeat.i(215836);
    PHD = new a((byte)0);
    PHC = kotlin.g.ar((kotlin.g.a.a)b.PHE);
    AppMethodBeat.o(215836);
  }
  
  public static final void OO()
  {
    AppMethodBeat.i(215837);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new g(), new String[] { "//webview" });
    AppMethodBeat.o(215837);
  }
  
  private static void fv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215833);
    if (!a.gSI())
    {
      AppMethodBeat.o(215833);
      return;
    }
    d.uiThread((kotlin.g.a.a)new c(paramString2));
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(215833);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(215835);
    if (!a.gSI())
    {
      AppMethodBeat.o(215835);
      return false;
    }
    if (paramArrayOfString != null)
    {
      paramContext = kotlin.g.b.b.aj(paramArrayOfString);
      if (paramContext == null) {
        break label64;
      }
    }
    label64:
    for (paramString = (String)paramContext.next();; paramString = null)
    {
      if (!(p.h(paramString, "//webview") ^ true)) {
        break label69;
      }
      AppMethodBeat.o(215835);
      return false;
      paramContext = null;
      break;
    }
    label69:
    paramContext = (String)paramContext.next();
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(215835);
      throw paramContext;
    }
    paramContext = paramContext.toLowerCase();
    p.j(paramContext, "(this as java.lang.String).toLowerCase()");
    switch (paramContext.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(215835);
              return false;
            } while (!paramContext.equals("prefetchpkg"));
            if (paramArrayOfString.length > 2) {
              break;
            }
            AppMethodBeat.o(215835);
            return false;
          } while (!paramContext.equals("manifestdebug"));
          if (paramArrayOfString.length > 2) {
            break label516;
          }
          AppMethodBeat.o(215835);
          return false;
        } while (!paramContext.equals("preauth"));
        if (paramArrayOfString.length > 2) {
          break;
        }
        AppMethodBeat.o(215835);
        return false;
      } while (!paramContext.equals("commit"));
      if (paramArrayOfString.length > 2) {
        break;
      }
      AppMethodBeat.o(215835);
      return false;
    } while (!paramContext.equals("upx5"));
    if (paramArrayOfString.length <= 4)
    {
      AppMethodBeat.o(215835);
      return false;
      paramContext = paramArrayOfString[2];
      switch (paramContext.hashCode())
      {
      default: 
      case 3556498: 
        do
        {
          AppMethodBeat.o(215835);
          return false;
        } while (!paramContext.equals("test"));
        h.cqu().putBoolean("webview_page_commit_mock", true);
        fv("WebViewCommand", "commit mock enable");
      }
      for (;;)
      {
        AppMethodBeat.o(215835);
        return true;
        if (!paramContext.equals("reset")) {
          break;
        }
        h.cqu().putBoolean("webview_page_commit_mock", false);
        fv("WebViewCommand", "commit mock reset");
      }
    }
    com.tencent.mm.modelstat.a.b.o(paramArrayOfString[2], paramArrayOfString[3], Util.getInt(paramArrayOfString[4], -1));
    AppMethodBeat.o(215835);
    return true;
    paramArrayOfString = paramArrayOfString[2];
    paramContext = new f.a();
    paramContext.url = paramArrayOfString;
    paramContext.svv = 998;
    paramContext.svw = 10001;
    CronetLogic.setUserCertVerify(true);
    h.cqu().putBoolean("webview_use_a8key_lite_header", true);
    paramArrayOfString = (com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class);
    paramString = new ArrayList();
    paramString.add(paramContext);
    paramArrayOfString.cq((List)paramString);
    AppMethodBeat.o(215835);
    return true;
    h.cqu().putInt("prefetchUsePkg", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(215835);
    return true;
    label516:
    h.cqu().putInt("fetchManifestDebug", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(215835);
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand$Companion;", "", "()V", "COMMAND_SCENE", "", "COMMAND_SUB_SCENE", "TAG", "", "WEB_VIEW_PAGE_COMMIT_MOCK", "WEB_VIEW_USE_A8KEY_LITE_HEADER", "command", "webViewActivityTranslucent", "", "getWebViewActivityTranslucent", "()Z", "webViewActivityTranslucent$delegate", "Lkotlin/Lazy;", "canDebug", "commitTestNotCall", "fetchManifestDebug", "isDebug", "prefetchUsePkg", "register", "", "useA8keyLiteHeader", "webview-sdk_release"})
  public static final class a
  {
    public static boolean No()
    {
      AppMethodBeat.i(206927);
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
      {
        AppMethodBeat.o(206927);
        return true;
      }
      AppMethodBeat.o(206927);
      return false;
    }
    
    public static boolean gSI()
    {
      AppMethodBeat.i(206929);
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || ((Log.getLogLevel() == 0) && (WeChatEnvironment.hasDebugger())))
      {
        AppMethodBeat.o(206929);
        return true;
      }
      AppMethodBeat.o(206929);
      return false;
    }
    
    public static boolean gSJ()
    {
      AppMethodBeat.i(206931);
      boolean bool = h.cqu().getBoolean("webview_page_commit_mock", false);
      AppMethodBeat.o(206931);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final b PHE;
    
    static
    {
      AppMethodBeat.i(206846);
      PHE = new b();
      AppMethodBeat.o(206846);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.g
 * JD-Core Version:    0.7.0.1
 */