package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.n.n;
import d.y;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "webview-sdk_release"})
public final class g
  implements a
{
  public static final a CSt;
  
  static
  {
    AppMethodBeat.i(82929);
    CSt = new a((byte)0);
    AppMethodBeat.o(82929);
  }
  
  public static final void AY()
  {
    AppMethodBeat.i(82930);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new g(), new String[] { "//webcompt" });
    AppMethodBeat.o(82930);
  }
  
  public static final String aEl(String paramString)
  {
    AppMethodBeat.i(82931);
    paramString = a.aEl(paramString);
    AppMethodBeat.o(82931);
    return paramString;
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(82928);
    k.h(paramContext, "context");
    k.h(paramArrayOfString, "args");
    k.h(paramString, "username");
    if (!h.eyK())
    {
      AppMethodBeat.o(82928);
      return false;
    }
    paramContext = d.g.b.b.ad(paramArrayOfString);
    if ((k.g((String)paramContext.next(), "//webcompt") ^ true))
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
      paramArrayOfString = h.bBL();
      if ((paramContext.hasNext()) && (k.g((String)paramContext.next(), "false"))) {
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
        if ((paramContext.hasNext()) && (k.g((String)paramContext.next(), "sd")))
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
              paramContext = c.CQN;
              c.b.e(false, false, 2);
              paramContext = y.KTp;
              h.showToast("webcompt clear sdcard app files");
              continue;
              if (!paramArrayOfString.equals("debugJS")) {
                break;
              }
              h.bBL().putBoolean("debug", true).putString("debugJS", (String)paramContext.next());
              h.showToast("webcompt set debugJS");
              continue;
              if (!paramArrayOfString.equals("debugA8Key")) {
                break;
              }
              h.bBL().putBoolean("debug", true).putString("debugA8Key", (String)paramContext.next());
              h.showToast("webcompt set debugA8Key");
              continue;
              if (!paramArrayOfString.equals("mock")) {
                break;
              }
              paramArrayOfString = (String)paramContext.next();
              h.bBL().putString("mock_" + (String)paramContext.next(), paramArrayOfString);
              h.showToast("webcompt mock");
              break;
            case 101415985: 
              if (!paramContext.equals("jsapi")) {
                continue;
              }
              paramContext = c.CQN;
              c.b.e(false, false, 1);
              paramContext = y.KTp;
              h.showToast("webcompt clear sdcard jsapi files");
              break;
            }
          }
          paramContext = c.CQN;
          c.b.e(false, false, 3);
          paramContext = y.KTp;
          h.showToast("webcompt clear all sdcard files");
          continue;
        }
        h.bBL().clear();
        h.showToast("webcompt clear all commands");
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand$Companion;", "", "()V", "command", "", "debug", "", "getDebug", "()Z", "debugA8Key", "getDebugA8Key", "()Ljava/lang/String;", "debugJS", "getDebugJS", "mockHost", "url", "register", "", "webview-sdk_release"})
  public static final class a
  {
    public static String aEl(String paramString)
    {
      AppMethodBeat.i(205622);
      k.h(paramString, "url");
      Object localObject1 = a.CSu;
      if (getDebug()) {
        try
        {
          localObject1 = ((Iterable)n.a((CharSequence)n.nh(paramString, "#"), new String[] { "&" })).iterator();
          Object localObject2;
          a locala;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
            if ((((List)localObject2).size() == 2) && (k.g((String)((List)localObject2).get(0), "mock")))
            {
              localObject2 = (String)((List)localObject2).get(1);
              localObject1 = new URL(paramString);
              localObject2 = new StringBuilder().append(((URL)localObject1).getProtocol()).append("://").append((String)localObject2).append(((URL)localObject1).getFile());
              locala = a.CSu;
              localObject1 = a.d((URL)localObject1);
              AppMethodBeat.o(205622);
              return localObject1;
            }
          }
          localObject1 = new URL(paramString);
          if (h.bBL().containsKey("mock_" + ((URL)localObject1).getHost()))
          {
            localObject2 = new StringBuilder().append(((URL)localObject1).getProtocol()).append("://").append(h.bBL().getString("mock_" + ((URL)localObject1).getHost(), ((URL)localObject1).getHost())).append(((URL)localObject1).getFile());
            locala = a.CSu;
            localObject1 = a.d((URL)localObject1);
            AppMethodBeat.o(205622);
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("WebComptCommand", (Throwable)localException, "mockHost", new Object[0]);
        }
      }
      AppMethodBeat.o(205622);
      return paramString;
    }
    
    public static boolean getDebug()
    {
      AppMethodBeat.i(82927);
      if (h.bBL().containsKey("debug"))
      {
        boolean bool = h.bBL().getBoolean("debug", false);
        AppMethodBeat.o(82927);
        return bool;
      }
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
      {
        AppMethodBeat.o(82927);
        return true;
      }
      AppMethodBeat.o(82927);
      return false;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"hash", "", "Ljava/net/URL;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<URL, String>
    {
      public static final a CSu;
      
      static
      {
        AppMethodBeat.i(82926);
        CSu = new a();
        AppMethodBeat.o(82926);
      }
      
      a()
      {
        super();
      }
      
      public static String d(URL paramURL)
      {
        AppMethodBeat.i(82925);
        k.h(paramURL, "$this$hash");
        String str = paramURL.getRef();
        k.g(str, "ref");
        if (!n.aD((CharSequence)str)) {}
        for (int i = 1; i != 0; i = 0)
        {
          paramURL = "#" + paramURL.getRef();
          AppMethodBeat.o(82925);
          return paramURL;
        }
        paramURL = paramURL.getRef();
        k.g(paramURL, "ref");
        AppMethodBeat.o(82925);
        return paramURL;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.g
 * JD-Core Version:    0.7.0.1
 */