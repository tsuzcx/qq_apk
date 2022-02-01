package com.tencent.mm.plugin.webview.e;

import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/permission/GetA8KeyReasonManager;", "", "()V", "TAG", "", "forceGetA8keyPaths", "", "getForceGetA8keyPaths", "()Ljava/util/List;", "forceGetA8keyPaths$delegate", "Lkotlin/Lazy;", "hasForceGetA8keyList", "Ljava/util/LinkedList;", "shouldForceGetA8key", "", "url", "webview-sdk_release"})
public final class b
{
  private static final LinkedList<String> BaK;
  private static final f BaL;
  public static final b BaM;
  private static final String TAG = "MicroMsg.GetA8KeyReasonManager";
  
  static
  {
    AppMethodBeat.i(189410);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(b.class), "forceGetA8keyPaths", "getForceGetA8keyPaths()Ljava/util/List;")) };
    BaM = new b();
    TAG = "MicroMsg.GetA8KeyReasonManager";
    BaK = new LinkedList();
    BaL = g.E((a)a.BaN);
    AppMethodBeat.o(189410);
  }
  
  public static final boolean axi(String paramString)
  {
    AppMethodBeat.i(189411);
    d.g.b.k.h(paramString, "url");
    if (BaK.contains(paramString))
    {
      AppMethodBeat.o(189411);
      return true;
    }
    Iterator localIterator = ((Iterable)BaL.getValue()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad.i(TAG, "force geta8key path = %s", new Object[] { str });
      if (c.a(paramString, str, false))
      {
        BaK.add(paramString);
        AppMethodBeat.o(189411);
        return true;
      }
    }
    AppMethodBeat.o(189411);
    return false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<List<? extends String>>
  {
    public static final a BaN;
    
    static
    {
      AppMethodBeat.i(189409);
      BaN = new a();
      AppMethodBeat.o(189409);
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