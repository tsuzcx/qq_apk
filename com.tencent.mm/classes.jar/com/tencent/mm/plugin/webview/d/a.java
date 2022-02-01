package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/DefaultJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-webview_release"})
public final class a
{
  private static final f IIi;
  public static final a PNm;
  
  static
  {
    AppMethodBeat.i(219458);
    PNm = new a();
    IIi = g.ar((kotlin.g.a.a)a.PNn);
    AppMethodBeat.o(219458);
  }
  
  public static void gTJ()
  {
    AppMethodBeat.i(219453);
    q localq = q.POB;
    q.bS((Map)IIi.getValue());
    AppMethodBeat.o(219453);
  }
  
  public static HashMap<String, com.tencent.mm.plugin.webview.d.c.a> hf(List<? extends com.tencent.mm.plugin.webview.d.c.a> paramList)
  {
    AppMethodBeat.i(219450);
    p.k(paramList, "$this$toMap");
    HashMap localHashMap = new HashMap();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.webview.d.c.a locala = (com.tencent.mm.plugin.webview.d.c.a)paramList.next();
      ((Map)localHashMap).put(locala.fCm(), locala);
    }
    AppMethodBeat.o(219450);
    return localHashMap;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.d.c.a>>
  {
    public static final a PNn;
    
    static
    {
      AppMethodBeat.i(215295);
      PNn = new a();
      AppMethodBeat.o(215295);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.a
 * JD-Core Version:    0.7.0.1
 */