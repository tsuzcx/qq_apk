package com.tencent.mm.plugin.webview.f;

import com.tencent.luggage.k.c;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/permission/GetA8KeyReasonManager;", "", "()V", "TAG", "", "forceGetA8keyPaths", "", "getForceGetA8keyPaths", "()Ljava/util/List;", "forceGetA8keyPaths$delegate", "Lkotlin/Lazy;", "hasForceGetA8keyList", "Ljava/util/LinkedList;", "shouldForceGetA8key", "", "url", "webview-sdk_release"})
public final class b
{
  private static final LinkedList<String> PYl;
  private static final f PYm;
  public static final b PYn;
  private static final String TAG = "MicroMsg.GetA8KeyReasonManager";
  
  static
  {
    AppMethodBeat.i(206987);
    PYn = new b();
    TAG = "MicroMsg.GetA8KeyReasonManager";
    PYl = new LinkedList();
    PYm = g.ar((a)a.PYo);
    AppMethodBeat.o(206987);
  }
  
  public static final boolean blt(String paramString)
  {
    AppMethodBeat.i(206986);
    p.k(paramString, "url");
    if (PYl.contains(paramString))
    {
      AppMethodBeat.o(206986);
      return true;
    }
    Iterator localIterator = ((Iterable)PYm.getValue()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i(TAG, "force geta8key path = %s", new Object[] { str });
      if (c.a(paramString, str, false))
      {
        PYl.add(paramString);
        AppMethodBeat.o(206986);
        return true;
      }
    }
    AppMethodBeat.o(206986);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements a<List<? extends String>>
  {
    public static final a PYo;
    
    static
    {
      AppMethodBeat.i(205657);
      PYo = new a();
      AppMethodBeat.o(205657);
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