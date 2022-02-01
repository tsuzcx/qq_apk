package com.tencent.mm.plugin.webview.l;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements a
{
  public static final a Xwq;
  
  static
  {
    AppMethodBeat.i(82929);
    Xwq = new a((byte)0);
    AppMethodBeat.o(82929);
  }
  
  public static final void aoW()
  {
    AppMethodBeat.i(82930);
    b.a((a)new f(), new String[] { "//webcompt" });
    AppMethodBeat.o(82930);
  }
  
  public static final String bnj(String paramString)
  {
    AppMethodBeat.i(82931);
    paramString = a.bnj(paramString);
    AppMethodBeat.o(82931);
    return paramString;
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(82928);
    s.u(paramContext, "context");
    s.u(paramArrayOfString, "args");
    s.u(paramString, "username");
    if (!g.gTR())
    {
      AppMethodBeat.o(82928);
      return false;
    }
    paramContext = kotlin.g.b.c.ao(paramArrayOfString);
    if (!s.p(paramContext.next(), "//webcompt"))
    {
      AppMethodBeat.o(82928);
      return false;
    }
    paramArrayOfString = (String)paramContext.next();
    switch (paramArrayOfString.hashCode())
    {
    default: 
    case 95458899: 
      do
      {
        AppMethodBeat.o(82928);
        return false;
      } while (!paramArrayOfString.equals("debug"));
      paramArrayOfString = g.cTb();
      if ((paramContext.hasNext()) && (s.p(paramContext.next(), "false"))) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfString.putBoolean("debug", bool);
      g.bnl(s.X("webcompt set debug:", Boolean.valueOf(a.getDebug())));
      for (;;)
      {
        AppMethodBeat.o(82928);
        return true;
        if (!paramArrayOfString.equals("clear")) {
          break;
        }
        if ((paramContext.hasNext()) && (s.p(paramContext.next(), "sd")))
        {
          if (paramContext.hasNext())
          {
            paramContext = (String)paramContext.next();
            if (s.p(paramContext, "jsapi"))
            {
              paramContext = c.XuL;
              c.b.f(false, false, 1);
              paramContext = ah.aiuX;
              g.bnl("webcompt clear sdcard jsapi files");
              continue;
              if (!paramArrayOfString.equals("debugJS")) {
                break;
              }
              g.cTb().putBoolean("debug", true).putString("debugJS", (String)paramContext.next());
              g.bnl("webcompt set debugJS");
              continue;
              if (!paramArrayOfString.equals("debugA8Key")) {
                break;
              }
              g.cTb().putBoolean("debug", true).putString("debugA8Key", (String)paramContext.next());
              g.bnl("webcompt set debugA8Key");
              continue;
              if (!paramArrayOfString.equals("mock")) {
                break;
              }
              paramArrayOfString = (String)paramContext.next();
              g.cTb().putString(s.X("mock_", paramContext.next()), paramArrayOfString);
              g.bnl("webcompt mock");
              continue;
            }
            if (!s.p(paramContext, "app")) {
              continue;
            }
            paramContext = c.XuL;
            c.b.f(false, false, 2);
            paramContext = ah.aiuX;
            g.bnl("webcompt clear sdcard app files");
            continue;
          }
          paramContext = c.XuL;
          c.b.f(false, false, 3);
          paramContext = ah.aiuX;
          g.bnl("webcompt clear all sdcard files");
          continue;
        }
        g.cTb().clear();
        g.bnl("webcompt clear all commands");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand$Companion;", "", "()V", "command", "", "debug", "", "getDebug", "()Z", "debugA8Key", "getDebugA8Key", "()Ljava/lang/String;", "debugJS", "getDebugJS", "mockHost", "url", "register", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String bnj(String paramString)
    {
      AppMethodBeat.i(295465);
      s.u(paramString, "url");
      if (getDebug()) {
        try
        {
          Object localObject1 = ((Iterable)n.a((CharSequence)n.rw(paramString, "#"), new String[] { "&" })).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
            if ((((List)localObject2).size() == 2) && (s.p(((List)localObject2).get(0), "mock")))
            {
              localObject1 = (String)((List)localObject2).get(1);
              localObject2 = new URL(paramString);
              localObject1 = ((URL)localObject2).getProtocol() + "://" + (String)localObject1 + ((URL)localObject2).getFile() + d((URL)localObject2);
              AppMethodBeat.o(295465);
              return localObject1;
            }
          }
          localObject1 = new URL(paramString);
          if (g.cTb().containsKey(s.X("mock_", ((URL)localObject1).getHost())))
          {
            localObject1 = ((URL)localObject1).getProtocol() + "://" + g.cTb().getString(s.X("mock_", ((URL)localObject1).getHost()), ((URL)localObject1).getHost()) + ((URL)localObject1).getFile() + d((URL)localObject1);
            AppMethodBeat.o(295465);
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("WebComptCommand", (Throwable)localException, "mockHost", new Object[0]);
        }
      }
      AppMethodBeat.o(295465);
      return paramString;
    }
    
    private static final String d(URL paramURL)
    {
      AppMethodBeat.i(295467);
      String str = paramURL.getRef();
      s.s(str, "ref");
      if (!n.bp((CharSequence)str)) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramURL = s.X("#", paramURL.getRef());
        AppMethodBeat.o(295467);
        return paramURL;
      }
      paramURL = paramURL.getRef();
      s.s(paramURL, "ref");
      AppMethodBeat.o(295467);
      return paramURL;
    }
    
    public static boolean getDebug()
    {
      AppMethodBeat.i(82927);
      if (g.cTb().containsKey("debug"))
      {
        boolean bool = g.cTb().getBoolean("debug", false);
        AppMethodBeat.o(82927);
        return bool;
      }
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(82927);
        return true;
      }
      AppMethodBeat.o(82927);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.f
 * JD-Core Version:    0.7.0.1
 */