package com.tencent.mm.plugin.webview.e;

import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/permission/GetA8KeyReasonManager;", "", "()V", "TAG", "", "forceGetA8keyPaths", "", "getForceGetA8keyPaths", "()Ljava/util/List;", "forceGetA8keyPaths$delegate", "Lkotlin/Lazy;", "hasForceGetA8keyList", "Ljava/util/LinkedList;", "shouldForceGetA8key", "", "url", "webview-sdk_release"})
public final class b
{
  private static final LinkedList<String> EoB;
  private static final f EoC;
  public static final b EoD;
  private static final String TAG = "MicroMsg.GetA8KeyReasonManager";
  
  static
  {
    AppMethodBeat.i(214173);
    EoD = new b();
    TAG = "MicroMsg.GetA8KeyReasonManager";
    EoB = new LinkedList();
    EoC = g.O((a)a.EoE);
    AppMethodBeat.o(214173);
  }
  
  public static final boolean aJv(String paramString)
  {
    AppMethodBeat.i(214172);
    p.h(paramString, "url");
    if (EoB.contains(paramString))
    {
      AppMethodBeat.o(214172);
      return true;
    }
    Iterator localIterator = ((Iterable)EoC.getValue()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ae.i(TAG, "force geta8key path = %s", new Object[] { str });
      if (c.a(paramString, str, false))
      {
        EoB.add(paramString);
        AppMethodBeat.o(214172);
        return true;
      }
    }
    AppMethodBeat.o(214172);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements a<List<? extends String>>
  {
    public static final a EoE;
    
    static
    {
      AppMethodBeat.i(214171);
      EoE = new a();
      AppMethodBeat.o(214171);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.b
 * JD-Core Version:    0.7.0.1
 */