package com.tencent.mm.plugin.webview.l;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "webview-sdk_release"})
public final class g
  implements a
{
  public static final a QDw;
  
  static
  {
    AppMethodBeat.i(82929);
    QDw = new a((byte)0);
    AppMethodBeat.o(82929);
  }
  
  public static final void OO()
  {
    AppMethodBeat.i(82930);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new g(), new String[] { "//webcompt" });
    AppMethodBeat.o(82930);
  }
  
  public static final String bnx(String paramString)
  {
    AppMethodBeat.i(82931);
    paramString = a.bnx(paramString);
    AppMethodBeat.o(82931);
    return paramString;
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(82928);
    p.k(paramContext, "context");
    p.k(paramArrayOfString, "args");
    p.k(paramString, "username");
    if (!h.gSI())
    {
      AppMethodBeat.o(82928);
      return false;
    }
    paramContext = kotlin.g.b.b.aj(paramArrayOfString);
    if ((p.h((String)paramContext.next(), "//webcompt") ^ true))
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
      paramArrayOfString = h.cqu();
      if ((paramContext.hasNext()) && (p.h((String)paramContext.next(), "false"))) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfString.putBoolean("debug", bool);
      h.showToast("webcompt set debug:" + a.getDebug());
      for (;;)
      {
        AppMethodBeat.o(82928);
        return true;
        if (!paramArrayOfString.equals("clear")) {
          break;
        }
        if ((paramContext.hasNext()) && (p.h((String)paramContext.next(), "sd")))
        {
          if (paramContext.hasNext())
          {
            paramContext = (String)paramContext.next();
            switch (paramContext.hashCode())
            {
            default: 
              break;
            case 96801: 
              if (!paramContext.equals("app")) {
                continue;
              }
              paramContext = c.QBP;
              c.b.e(false, false, 2);
              paramContext = x.aazN;
              h.showToast("webcompt clear sdcard app files");
              continue;
              if (!paramArrayOfString.equals("debugJS")) {
                break;
              }
              h.cqu().putBoolean("debug", true).putString("debugJS", (String)paramContext.next());
              h.showToast("webcompt set debugJS");
              continue;
              if (!paramArrayOfString.equals("debugA8Key")) {
                break;
              }
              h.cqu().putBoolean("debug", true).putString("debugA8Key", (String)paramContext.next());
              h.showToast("webcompt set debugA8Key");
              continue;
              if (!paramArrayOfString.equals("mock")) {
                break;
              }
              paramArrayOfString = (String)paramContext.next();
              h.cqu().putString("mock_" + (String)paramContext.next(), paramArrayOfString);
              h.showToast("webcompt mock");
              break;
            case 101415985: 
              if (!paramContext.equals("jsapi")) {
                continue;
              }
              paramContext = c.QBP;
              c.b.e(false, false, 1);
              paramContext = x.aazN;
              h.showToast("webcompt clear sdcard jsapi files");
              break;
            }
          }
          paramContext = c.QBP;
          c.b.e(false, false, 3);
          paramContext = x.aazN;
          h.showToast("webcompt clear all sdcard files");
          continue;
        }
        h.cqu().clear();
        h.showToast("webcompt clear all commands");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand$Companion;", "", "()V", "command", "", "debug", "", "getDebug", "()Z", "debugA8Key", "getDebugA8Key", "()Ljava/lang/String;", "debugJS", "getDebugJS", "mockHost", "url", "register", "", "webview-sdk_release"})
  public static final class a
  {
    public static String bnx(String paramString)
    {
      AppMethodBeat.i(205455);
      p.k(paramString, "url");
      Object localObject1 = a.QDx;
      if (getDebug()) {
        try
        {
          localObject1 = ((Iterable)n.a((CharSequence)n.pz(paramString, "#"), new String[] { "&" })).iterator();
          Object localObject2;
          a locala;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
            if ((((List)localObject2).size() == 2) && (p.h((String)((List)localObject2).get(0), "mock")))
            {
              localObject2 = (String)((List)localObject2).get(1);
              localObject1 = new URL(paramString);
              localObject2 = new StringBuilder().append(((URL)localObject1).getProtocol()).append("://").append((String)localObject2).append(((URL)localObject1).getFile());
              locala = a.QDx;
              localObject1 = a.d((URL)localObject1);
              AppMethodBeat.o(205455);
              return localObject1;
            }
          }
          localObject1 = new URL(paramString);
          if (h.cqu().containsKey("mock_" + ((URL)localObject1).getHost()))
          {
            localObject2 = new StringBuilder().append(((URL)localObject1).getProtocol()).append("://").append(h.cqu().getString("mock_" + ((URL)localObject1).getHost(), ((URL)localObject1).getHost())).append(((URL)localObject1).getFile());
            locala = a.QDx;
            localObject1 = a.d((URL)localObject1);
            AppMethodBeat.o(205455);
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("WebComptCommand", (Throwable)localException, "mockHost", new Object[0]);
        }
      }
      AppMethodBeat.o(205455);
      return paramString;
    }
    
    public static boolean getDebug()
    {
      AppMethodBeat.i(82927);
      if (h.cqu().containsKey("debug"))
      {
        boolean bool = h.cqu().getBoolean("debug", false);
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"hash", "", "Ljava/net/URL;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<URL, String>
    {
      public static final a QDx;
      
      static
      {
        AppMethodBeat.i(82926);
        QDx = new a();
        AppMethodBeat.o(82926);
      }
      
      a()
      {
        super();
      }
      
      public static String d(URL paramURL)
      {
        AppMethodBeat.i(82925);
        p.k(paramURL, "$this$hash");
        String str = paramURL.getRef();
        p.j(str, "ref");
        if (!n.ba((CharSequence)str)) {}
        for (int i = 1; i != 0; i = 0)
        {
          paramURL = "#" + paramURL.getRef();
          AppMethodBeat.o(82925);
          return paramURL;
        }
        paramURL = paramURL.getRef();
        p.j(paramURL, "ref");
        AppMethodBeat.o(82925);
        return paramURL;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.g
 * JD-Core Version:    0.7.0.1
 */