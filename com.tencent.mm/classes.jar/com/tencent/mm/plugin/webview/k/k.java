package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewAbtestUtil;", "", "()V", "TAG", "", "useThumbPlayer", "", "getUseThumbPlayer", "()Z", "useThumbPlayer$delegate", "Lkotlin/Lazy;", "isUseThumbPlayer", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k Xtc;
  private static final j Xtd;
  
  static
  {
    AppMethodBeat.i(295733);
    Xtc = new k();
    Xtd = kotlin.k.cm((a)a.Xte);
    AppMethodBeat.o(295733);
  }
  
  private static boolean iCT()
  {
    AppMethodBeat.i(295717);
    boolean bool = ((Boolean)Xtd.getValue()).booleanValue();
    AppMethodBeat.o(295717);
    return bool;
  }
  
  public static boolean iCU()
  {
    AppMethodBeat.i(295725);
    Log.i("MicroMsg.WebViewAbtestUtil", s.X("isUseThumbPlayer: ", Boolean.valueOf(iCT())));
    boolean bool = iCT();
    AppMethodBeat.o(295725);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Boolean>
  {
    public static final a Xte;
    
    static
    {
      AppMethodBeat.i(295668);
      Xte = new a();
      AppMethodBeat.o(295668);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.k
 * JD-Core Version:    0.7.0.1
 */