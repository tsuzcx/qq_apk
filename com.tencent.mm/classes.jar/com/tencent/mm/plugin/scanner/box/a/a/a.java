package com.tencent.mm.plugin.scanner.box.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/DefaultScanJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-scan_release"})
public final class a
{
  public static final f IIi;
  public static final a IIj;
  
  static
  {
    AppMethodBeat.i(221482);
    IIj = new a();
    IIi = g.ar((kotlin.g.a.a)a.IIk);
    AppMethodBeat.o(221482);
  }
  
  public static HashMap<String, com.tencent.mm.plugin.webview.d.c.a> hf(List<? extends com.tencent.mm.plugin.webview.d.c.a> paramList)
  {
    AppMethodBeat.i(221477);
    p.k(paramList, "$this$toMap");
    HashMap localHashMap = new HashMap();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.webview.d.c.a locala = (com.tencent.mm.plugin.webview.d.c.a)paramList.next();
      ((Map)localHashMap).put(locala.fCm(), locala);
    }
    AppMethodBeat.o(221477);
    return localHashMap;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.d.c.a>>
  {
    public static final a IIk;
    
    static
    {
      AppMethodBeat.i(222275);
      IIk = new a();
      AppMethodBeat.o(222275);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.a.a
 * JD-Core Version:    0.7.0.1
 */