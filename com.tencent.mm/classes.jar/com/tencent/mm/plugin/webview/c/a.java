package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/jsapi/DefaultJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-webview_release"})
public final class a
{
  private static final f DMs;
  public static final a DMt;
  
  static
  {
    AppMethodBeat.i(207581);
    DMt = new a();
    DMs = g.O((d.g.a.a)a.DMu);
    AppMethodBeat.o(207581);
  }
  
  public static void eOu()
  {
    AppMethodBeat.i(207580);
    m localm = m.DNE;
    m.bC((Map)DMs.getValue());
    AppMethodBeat.o(207580);
  }
  
  public static HashMap<String, com.tencent.mm.plugin.webview.c.c.a> gS(List<? extends com.tencent.mm.plugin.webview.c.c.a> paramList)
  {
    AppMethodBeat.i(207579);
    p.h(paramList, "$this$toMap");
    HashMap localHashMap = new HashMap();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.webview.c.c.a locala = (com.tencent.mm.plugin.webview.c.c.a)paramList.next();
      ((Map)localHashMap).put(locala.eOM(), locala);
    }
    AppMethodBeat.o(207579);
    return localHashMap;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.c.c.a>>
  {
    public static final a DMu;
    
    static
    {
      AppMethodBeat.i(207578);
      DMu = new a();
      AppMethodBeat.o(207578);
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