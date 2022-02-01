package com.tencent.mm.plugin.webview.e;

import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/permission/GetA8KeyReasonManager;", "", "()V", "TAG", "", "forceGetA8keyPaths", "", "getForceGetA8keyPaths", "()Ljava/util/List;", "forceGetA8keyPaths$delegate", "Lkotlin/Lazy;", "hasForceGetA8keyList", "Ljava/util/LinkedList;", "shouldForceGetA8key", "", "url", "webview-sdk_release"})
public final class b
{
  private static final LinkedList<String> DWC;
  private static final f DWD;
  public static final b DWE;
  private static final String TAG = "MicroMsg.GetA8KeyReasonManager";
  
  static
  {
    AppMethodBeat.i(214332);
    DWE = new b();
    TAG = "MicroMsg.GetA8KeyReasonManager";
    DWC = new LinkedList();
    DWD = g.O((a)a.DWF);
    AppMethodBeat.o(214332);
  }
  
  public static final boolean aIc(String paramString)
  {
    AppMethodBeat.i(214331);
    p.h(paramString, "url");
    if (DWC.contains(paramString))
    {
      AppMethodBeat.o(214331);
      return true;
    }
    Iterator localIterator = ((Iterable)DWD.getValue()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad.i(TAG, "force geta8key path = %s", new Object[] { str });
      if (c.a(paramString, str, false))
      {
        DWC.add(paramString);
        AppMethodBeat.o(214331);
        return true;
      }
    }
    AppMethodBeat.o(214331);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements a<List<? extends String>>
  {
    public static final a DWF;
    
    static
    {
      AppMethodBeat.i(214330);
      DWF = new a();
      AppMethodBeat.o(214330);
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