package com.tencent.mm.plugin.webview.e;

import com.tencent.luggage.l.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/permission/GetA8KeyReasonManager;", "", "()V", "TAG", "", "defaultForceGetA8keyPaths", "forceGetA8keyPaths", "", "getForceGetA8keyPaths", "()Ljava/util/List;", "forceGetA8keyPaths$delegate", "Lkotlin/Lazy;", "hasForceGetA8keyList", "Ljava/util/LinkedList;", "shouldForceGetA8key", "", "url", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b WOL;
  private static final LinkedList<String> WOM;
  private static final j WON;
  
  static
  {
    AppMethodBeat.i(294863);
    WOL = new b();
    TAG = "MicroMsg.GetA8KeyReasonManager";
    WOM = new LinkedList();
    WON = k.cm((a)a.WOO);
    AppMethodBeat.o(294863);
  }
  
  public static final boolean bla(String paramString)
  {
    AppMethodBeat.i(294852);
    s.u(paramString, "url");
    if (WOM.contains(paramString))
    {
      AppMethodBeat.o(294852);
      return true;
    }
    Iterator localIterator = ((Iterable)WON.getValue()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i(TAG, "force geta8key path = %s", new Object[] { str });
      if (c.a(paramString, str, false))
      {
        WOM.add(paramString);
        AppMethodBeat.o(294852);
        return true;
      }
    }
    AppMethodBeat.o(294852);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<List<? extends String>>
  {
    public static final a WOO;
    
    static
    {
      AppMethodBeat.i(294821);
      WOO = new a();
      AppMethodBeat.o(294821);
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