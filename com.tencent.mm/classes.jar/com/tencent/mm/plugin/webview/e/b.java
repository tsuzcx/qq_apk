package com.tencent.mm.plugin.webview.e;

import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/permission/GetA8KeyReasonManager;", "", "()V", "TAG", "", "forceGetA8keyPaths", "", "getForceGetA8keyPaths", "()Ljava/util/List;", "forceGetA8keyPaths$delegate", "Lkotlin/Lazy;", "hasForceGetA8keyList", "Ljava/util/LinkedList;", "shouldForceGetA8key", "", "url", "webview-sdk_release"})
public final class b
{
  private static final LinkedList<String> CsX;
  private static final f CsY;
  public static final b CsZ;
  private static final String TAG = "MicroMsg.GetA8KeyReasonManager";
  
  static
  {
    AppMethodBeat.i(205542);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(b.class), "forceGetA8keyPaths", "getForceGetA8keyPaths()Ljava/util/List;")) };
    CsZ = new b();
    TAG = "MicroMsg.GetA8KeyReasonManager";
    CsX = new LinkedList();
    CsY = g.K((a)a.Cta);
    AppMethodBeat.o(205542);
  }
  
  public static final boolean aCA(String paramString)
  {
    AppMethodBeat.i(205543);
    d.g.b.k.h(paramString, "url");
    if (CsX.contains(paramString))
    {
      AppMethodBeat.o(205543);
      return true;
    }
    Iterator localIterator = ((Iterable)CsY.getValue()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ac.i(TAG, "force geta8key path = %s", new Object[] { str });
      if (c.a(paramString, str, false))
      {
        CsX.add(paramString);
        AppMethodBeat.o(205543);
        return true;
      }
    }
    AppMethodBeat.o(205543);
    return false;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<List<? extends String>>
  {
    public static final a Cta;
    
    static
    {
      AppMethodBeat.i(205541);
      Cta = new a();
      AppMethodBeat.o(205541);
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