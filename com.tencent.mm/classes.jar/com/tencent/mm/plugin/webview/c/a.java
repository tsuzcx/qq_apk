package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/jsapi/DefaultJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-webview_release"})
public final class a
{
  private static final f Cjm;
  public static final a Cjn;
  
  static
  {
    AppMethodBeat.i(189447);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "jsApis", "getJsApis()Ljava/util/Map;")) };
    Cjn = new a();
    Cjm = g.K((d.g.a.a)a.Cjo);
    AppMethodBeat.o(189447);
  }
  
  public static void ezF()
  {
    AppMethodBeat.i(189449);
    m localm = m.Ckz;
    m.bz((Map)Cjm.getValue());
    AppMethodBeat.o(189449);
  }
  
  public static HashMap<String, com.tencent.mm.plugin.webview.c.c.a> gG(List<? extends com.tencent.mm.plugin.webview.c.c.a> paramList)
  {
    AppMethodBeat.i(189448);
    d.g.b.k.h(paramList, "$this$toMap");
    HashMap localHashMap = new HashMap();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.webview.c.c.a locala = (com.tencent.mm.plugin.webview.c.c.a)paramList.next();
      ((Map)localHashMap).put(locala.ezY(), locala);
    }
    AppMethodBeat.o(189448);
    return localHashMap;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.c.c.a>>
  {
    public static final a Cjo;
    
    static
    {
      AppMethodBeat.i(189446);
      Cjo = new a();
      AppMethodBeat.o(189446);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a
 * JD-Core Version:    0.7.0.1
 */