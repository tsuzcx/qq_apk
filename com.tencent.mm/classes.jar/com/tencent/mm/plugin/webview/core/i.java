package com.tencent.mm.plugin.webview.core;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.c;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "showToast", "", "tag", "content", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a Wya;
  private static final kotlin.j<Boolean> Wyb;
  
  static
  {
    AppMethodBeat.i(295138);
    Wya = new a((byte)0);
    Wyb = k.cm((kotlin.g.a.a)b.Wyc);
    AppMethodBeat.o(295138);
  }
  
  public static final void aoW()
  {
    AppMethodBeat.i(295126);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new i(), new String[] { "//webview" });
    AppMethodBeat.o(295126);
  }
  
  private static void fQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(295123);
    if (!a.gTR())
    {
      AppMethodBeat.o(295123);
      return;
    }
    d.uiThread((kotlin.g.a.a)new c(paramString2));
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(295123);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(295151);
    if (!a.gTR())
    {
      AppMethodBeat.o(295151);
      return false;
    }
    if (paramArrayOfString == null)
    {
      paramContext = null;
      if (paramContext != null) {
        break label54;
      }
    }
    label54:
    for (paramString = null;; paramString = (String)paramContext.next())
    {
      if (s.p(paramString, "//webview")) {
        break label67;
      }
      AppMethodBeat.o(295151);
      return false;
      paramContext = c.ao(paramArrayOfString);
      break;
    }
    label67:
    paramContext = (String)paramContext.next();
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(295151);
      throw paramContext;
    }
    paramContext = paramContext.toLowerCase();
    s.s(paramContext, "(this as java.lang.String).toLowerCase()");
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
                        do
                        {
                          AppMethodBeat.o(295151);
                          return false;
                        } while (!paramContext.equals("prefetchpkg"));
                        if (paramArrayOfString.length > 2) {
                          break;
                        }
                        AppMethodBeat.o(295151);
                        return false;
                      } while (!paramContext.equals("debugtoast"));
                      if (paramArrayOfString.length > 2) {
                        break label717;
                      }
                      AppMethodBeat.o(295151);
                      return false;
                    } while (!paramContext.equals("debugmanifest"));
                    if (paramArrayOfString.length > 2) {
                      break label837;
                    }
                    AppMethodBeat.o(295151);
                    return false;
                  } while (!paramContext.equals("debugpatch"));
                  if (paramArrayOfString.length > 2) {
                    break label741;
                  }
                  AppMethodBeat.o(295151);
                  return false;
                } while (!paramContext.equals("preauth"));
                if (paramArrayOfString.length > 2) {
                  break;
                }
                AppMethodBeat.o(295151);
                return false;
              } while (!paramContext.equals("debugpatchinfo"));
              if (paramArrayOfString.length > 2) {
                break label789;
              }
              AppMethodBeat.o(295151);
              return false;
            } while (!paramContext.equals("opensnapoauth"));
            if (paramArrayOfString.length > 2) {
              break;
            }
            AppMethodBeat.o(295151);
            return false;
          } while (!paramContext.equals("commit"));
          if (paramArrayOfString.length > 2) {
            break;
          }
          AppMethodBeat.o(295151);
          return false;
        } while (!paramContext.equals("debugcookie"));
        if (paramArrayOfString.length > 2) {
          break label693;
        }
        AppMethodBeat.o(295151);
        return false;
      } while (!paramContext.equals("debugtransfer"));
      if (paramArrayOfString.length > 2) {
        break label765;
      }
      AppMethodBeat.o(295151);
      return false;
    } while (!paramContext.equals("upx5"));
    if (paramArrayOfString.length <= 4)
    {
      AppMethodBeat.o(295151);
      return false;
      paramContext = paramArrayOfString[2];
      if (s.p(paramContext, "test"))
      {
        j.cTb().putBoolean("webview_page_commit_mock", true);
        fQ("WebViewCommand", "commit mock enable");
      }
      for (;;)
      {
        AppMethodBeat.o(295151);
        return true;
        if (!s.p(paramContext, "reset")) {
          break;
        }
        j.cTb().putBoolean("webview_page_commit_mock", false);
        fQ("WebViewCommand", "commit mock reset");
      }
      AppMethodBeat.o(295151);
      return false;
    }
    com.tencent.mm.modelstat.a.b.r(paramArrayOfString[2], paramArrayOfString[3], Util.getInt(paramArrayOfString[4], -1));
    AppMethodBeat.o(295151);
    return true;
    j.cTb().putInt("openSnapOauth", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(295151);
    return true;
    paramArrayOfString = paramArrayOfString[2];
    paramContext = new h.a();
    paramContext.url = paramArrayOfString;
    paramContext.vAZ = 998;
    paramContext.vBa = 10001;
    CronetLogic.setUserCertVerify(true);
    j.cTb().putBoolean("webview_use_a8key_lite_header", true);
    paramArrayOfString = (com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class);
    paramString = new ArrayList();
    paramString.add(paramContext);
    paramContext = ah.aiuX;
    paramArrayOfString.ei((List)paramString);
    AppMethodBeat.o(295151);
    return true;
    j.cTb().putInt("prefetchUsePkg", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(295151);
    return true;
    label693:
    j.cTb().putInt("debugCookie", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(295151);
    return true;
    label717:
    j.cTb().putInt("showDebugToast", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(295151);
    return true;
    label741:
    j.cTb().putInt("debugPatchEnable", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(295151);
    return true;
    label765:
    j.cTb().putInt("debugTransfer", Util.getInt(paramArrayOfString[2], -1));
    AppMethodBeat.o(295151);
    return true;
    label789:
    if (s.p(paramArrayOfString[2], "null")) {
      j.cTb().putString("debugPatchInfo", "");
    }
    for (;;)
    {
      AppMethodBeat.o(295151);
      return true;
      j.cTb().putString("debugPatchInfo", paramArrayOfString[2]);
    }
    label837:
    if (s.p(paramArrayOfString[2], "null")) {
      j.cTb().remove("DebugManifest").apply();
    }
    for (;;)
    {
      AppMethodBeat.o(295151);
      return true;
      j.cTb().putString("DebugManifest", paramArrayOfString[2]).apply();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewCommand$Companion;", "", "()V", "COMMAND_SCENE", "", "COMMAND_SUB_SCENE", "TAG", "", "WEB_VIEW_PAGE_COMMIT_MOCK", "WEB_VIEW_USE_A8KEY_LITE_HEADER", "command", "webViewActivityTranslucent", "", "getWebViewActivityTranslucent", "()Z", "webViewActivityTranslucent$delegate", "Lkotlin/Lazy;", "canDebug", "commitTestNotCall", "debugCookie", "debugFetchContentByTransfer", "()Ljava/lang/Boolean;", "debugPatch", "getDebugManifest", "getDebugPatchUrl", "isDebug", "openSnapOauth", "prefetchUsePkg", "register", "", "showDebugPrefetchToast", "useA8keyLiteHeader", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean anH()
    {
      AppMethodBeat.i(294993);
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
      {
        AppMethodBeat.o(294993);
        return true;
      }
      AppMethodBeat.o(294993);
      return false;
    }
    
    public static boolean gTR()
    {
      AppMethodBeat.i(294999);
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || ((Log.getLogLevel() == 0) && (WeChatEnvironment.hasDebugger())))
      {
        AppMethodBeat.o(294999);
        return true;
      }
      AppMethodBeat.o(294999);
      return false;
    }
    
    public static boolean iso()
    {
      AppMethodBeat.i(295005);
      boolean bool = j.cTb().getBoolean("webview_page_commit_mock", false);
      AppMethodBeat.o(295005);
      return bool;
    }
    
    public static boolean isp()
    {
      AppMethodBeat.i(295011);
      if (BuildInfo.DEBUG)
      {
        AppMethodBeat.o(295011);
        return true;
      }
      if ((gTR()) && (j.cTb().getInt("debugCookie", -1) == 1))
      {
        AppMethodBeat.o(295011);
        return true;
      }
      AppMethodBeat.o(295011);
      return false;
    }
    
    public static boolean isq()
    {
      AppMethodBeat.i(295021);
      if (BuildInfo.DEBUG)
      {
        AppMethodBeat.o(295021);
        return true;
      }
      if ((BuildInfo.IS_FLAVOR_RED) && (j.cTb().getInt("showDebugToast", -1) == 1))
      {
        AppMethodBeat.o(295021);
        return true;
      }
      AppMethodBeat.o(295021);
      return false;
    }
    
    public static String isr()
    {
      AppMethodBeat.i(295028);
      if (gTR())
      {
        String str = j.cTb().getString("DebugManifest", "");
        if (str == null)
        {
          AppMethodBeat.o(295028);
          return "";
        }
        AppMethodBeat.o(295028);
        return str;
      }
      AppMethodBeat.o(295028);
      return "";
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final b Wyc;
    
    static
    {
      AppMethodBeat.i(295001);
      Wyc = new b();
      AppMethodBeat.o(295001);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.i
 * JD-Core Version:    0.7.0.1
 */