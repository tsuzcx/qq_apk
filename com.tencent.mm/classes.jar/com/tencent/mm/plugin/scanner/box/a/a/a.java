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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/DefaultScanJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-scan_release"})
public final class a
{
  public static final f CDG;
  public static final a CDH;
  
  static
  {
    AppMethodBeat.i(240358);
    CDH = new a();
    CDG = g.ah((kotlin.g.a.a)a.CDI);
    AppMethodBeat.o(240358);
  }
  
  public static HashMap<String, com.tencent.mm.plugin.webview.d.c.a> gz(List<? extends com.tencent.mm.plugin.webview.d.c.a> paramList)
  {
    AppMethodBeat.i(240357);
    p.h(paramList, "$this$toMap");
    HashMap localHashMap = new HashMap();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.webview.d.c.a locala = (com.tencent.mm.plugin.webview.d.c.a)paramList.next();
      ((Map)localHashMap).put(locala.ePz(), locala);
    }
    AppMethodBeat.o(240357);
    return localHashMap;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.d.c.a>>
  {
    public static final a CDI;
    
    static
    {
      AppMethodBeat.i(240356);
      CDI = new a();
      AppMethodBeat.o(240356);
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