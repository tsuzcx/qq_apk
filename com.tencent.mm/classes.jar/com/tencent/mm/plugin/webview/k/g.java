package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.z;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "webview-sdk_release"})
public final class g
  implements a
{
  public static final a EOR;
  
  static
  {
    AppMethodBeat.i(82929);
    EOR = new a((byte)0);
    AppMethodBeat.o(82929);
  }
  
  public static final void CA()
  {
    AppMethodBeat.i(82930);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new g(), new String[] { "//webcompt" });
    AppMethodBeat.o(82930);
  }
  
  public static final String aLh(String paramString)
  {
    AppMethodBeat.i(82931);
    paramString = a.aLh(paramString);
    AppMethodBeat.o(82931);
    return paramString;
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(82928);
    p.h(paramContext, "context");
    p.h(paramArrayOfString, "args");
    p.h(paramString, "username");
    if (!h.eRk())
    {
      AppMethodBeat.o(82928);
      return false;
    }
    paramContext = d.g.b.b.ad(paramArrayOfString);
    if ((p.i((String)paramContext.next(), "//webcompt") ^ true))
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
      paramArrayOfString = h.bGK();
      if ((paramContext.hasNext()) && (p.i((String)paramContext.next(), "false"))) {
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
        if ((paramContext.hasNext()) && (p.i((String)paramContext.next(), "sd")))
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
              paramContext = c.ENl;
              c.b.f(false, false, 2);
              paramContext = z.Nhr;
              h.showToast("webcompt clear sdcard app files");
              continue;
              if (!paramArrayOfString.equals("debugJS")) {
                break;
              }
              h.bGK().putBoolean("debug", true).putString("debugJS", (String)paramContext.next());
              h.showToast("webcompt set debugJS");
              continue;
              if (!paramArrayOfString.equals("debugA8Key")) {
                break;
              }
              h.bGK().putBoolean("debug", true).putString("debugA8Key", (String)paramContext.next());
              h.showToast("webcompt set debugA8Key");
              continue;
              if (!paramArrayOfString.equals("mock")) {
                break;
              }
              paramArrayOfString = (String)paramContext.next();
              h.bGK().putString("mock_" + (String)paramContext.next(), paramArrayOfString);
              h.showToast("webcompt mock");
              break;
            case 101415985: 
              if (!paramContext.equals("jsapi")) {
                continue;
              }
              paramContext = c.ENl;
              c.b.f(false, false, 1);
              paramContext = z.Nhr;
              h.showToast("webcompt clear sdcard jsapi files");
              break;
            }
          }
          paramContext = c.ENl;
          c.b.f(false, false, 3);
          paramContext = z.Nhr;
          h.showToast("webcompt clear all sdcard files");
          continue;
        }
        h.bGK().clear();
        h.showToast("webcompt clear all commands");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand$Companion;", "", "()V", "command", "", "debug", "", "getDebug", "()Z", "debugA8Key", "getDebugA8Key", "()Ljava/lang/String;", "debugJS", "getDebugJS", "mockHost", "url", "register", "", "webview-sdk_release"})
  public static final class a
  {
    public static String aLh(String paramString)
    {
      AppMethodBeat.i(214257);
      p.h(paramString, "url");
      Object localObject1 = a.EOS;
      if (getDebug()) {
        try
        {
          localObject1 = ((Iterable)n.a((CharSequence)n.nL(paramString, "#"), new String[] { "&" })).iterator();
          Object localObject2;
          a locala;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
            if ((((List)localObject2).size() == 2) && (p.i((String)((List)localObject2).get(0), "mock")))
            {
              localObject2 = (String)((List)localObject2).get(1);
              localObject1 = new URL(paramString);
              localObject2 = new StringBuilder().append(((URL)localObject1).getProtocol()).append("://").append((String)localObject2).append(((URL)localObject1).getFile());
              locala = a.EOS;
              localObject1 = a.d((URL)localObject1);
              AppMethodBeat.o(214257);
              return localObject1;
            }
          }
          localObject1 = new URL(paramString);
          if (h.bGK().containsKey("mock_" + ((URL)localObject1).getHost()))
          {
            localObject2 = new StringBuilder().append(((URL)localObject1).getProtocol()).append("://").append(h.bGK().getString("mock_" + ((URL)localObject1).getHost(), ((URL)localObject1).getHost())).append(((URL)localObject1).getFile());
            locala = a.EOS;
            localObject1 = a.d((URL)localObject1);
            AppMethodBeat.o(214257);
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("WebComptCommand", (Throwable)localException, "mockHost", new Object[0]);
        }
      }
      AppMethodBeat.o(214257);
      return paramString;
    }
    
    public static boolean getDebug()
    {
      AppMethodBeat.i(82927);
      if (h.bGK().containsKey("debug"))
      {
        boolean bool = h.bGK().getBoolean("debug", false);
        AppMethodBeat.o(82927);
        return bool;
      }
      if ((j.IS_FLAVOR_RED) || (j.DEBUG))
      {
        AppMethodBeat.o(82927);
        return true;
      }
      AppMethodBeat.o(82927);
      return false;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"hash", "", "Ljava/net/URL;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<URL, String>
    {
      public static final a EOS;
      
      static
      {
        AppMethodBeat.i(82926);
        EOS = new a();
        AppMethodBeat.o(82926);
      }
      
      a()
      {
        super();
      }
      
      public static String d(URL paramURL)
      {
        AppMethodBeat.i(82925);
        p.h(paramURL, "$this$hash");
        String str = paramURL.getRef();
        p.g(str, "ref");
        if (!n.aD((CharSequence)str)) {}
        for (int i = 1; i != 0; i = 0)
        {
          paramURL = "#" + paramURL.getRef();
          AppMethodBeat.o(82925);
          return paramURL;
        }
        paramURL = paramURL.getRef();
        p.g(paramURL, "ref");
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