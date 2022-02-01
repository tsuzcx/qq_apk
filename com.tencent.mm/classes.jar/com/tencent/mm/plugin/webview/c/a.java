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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/jsapi/DefaultJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-webview_release"})
public final class a
{
  private static final f AQZ;
  public static final a ARa;
  
  static
  {
    AppMethodBeat.i(188878);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "jsApis", "getJsApis()Ljava/util/Map;")) };
    ARa = new a();
    AQZ = g.E((d.g.a.a)a.ARb);
    AppMethodBeat.o(188878);
  }
  
  public static void ekk()
  {
    AppMethodBeat.i(188880);
    m localm = m.ASm;
    m.bu((Map)AQZ.getValue());
    AppMethodBeat.o(188880);
  }
  
  public static HashMap<String, com.tencent.mm.plugin.webview.c.c.a> gv(List<? extends com.tencent.mm.plugin.webview.c.c.a> paramList)
  {
    AppMethodBeat.i(188879);
    d.g.b.k.h(paramList, "$this$toMap");
    HashMap localHashMap = new HashMap();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.webview.c.c.a locala = (com.tencent.mm.plugin.webview.c.c.a)paramList.next();
      ((Map)localHashMap).put(locala.ekC(), locala);
    }
    AppMethodBeat.o(188879);
    return localHashMap;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.c.c.a>>
  {
    public static final a ARb;
    
    static
    {
      AppMethodBeat.i(188877);
      ARb = new a();
      AppMethodBeat.o(188877);
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