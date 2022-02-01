package com.tencent.mm.plugin.webview.f;

import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/permission/GetA8KeyReasonManager;", "", "()V", "TAG", "", "forceGetA8keyPaths", "", "getForceGetA8keyPaths", "()Ljava/util/List;", "forceGetA8keyPaths$delegate", "Lkotlin/Lazy;", "hasForceGetA8keyList", "Ljava/util/LinkedList;", "shouldForceGetA8key", "", "url", "webview-sdk_release"})
public final class b
{
  private static final LinkedList<String> JbF;
  private static final f JbG;
  public static final b JbH;
  private static final String TAG = "MicroMsg.GetA8KeyReasonManager";
  
  static
  {
    AppMethodBeat.i(225127);
    JbH = new b();
    TAG = "MicroMsg.GetA8KeyReasonManager";
    JbF = new LinkedList();
    JbG = g.ah((a)a.JbI);
    AppMethodBeat.o(225127);
  }
  
  public static final boolean aZA(String paramString)
  {
    AppMethodBeat.i(225126);
    p.h(paramString, "url");
    if (JbF.contains(paramString))
    {
      AppMethodBeat.o(225126);
      return true;
    }
    Iterator localIterator = ((Iterable)JbG.getValue()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i(TAG, "force geta8key path = %s", new Object[] { str });
      if (c.a(paramString, str, false))
      {
        JbF.add(paramString);
        AppMethodBeat.o(225126);
        return true;
      }
    }
    AppMethodBeat.o(225126);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements a<List<? extends String>>
  {
    public static final a JbI;
    
    static
    {
      AppMethodBeat.i(225125);
      JbI = new a();
      AppMethodBeat.o(225125);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.b
 * JD-Core Version:    0.7.0.1
 */