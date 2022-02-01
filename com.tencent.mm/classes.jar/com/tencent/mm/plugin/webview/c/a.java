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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/jsapi/DefaultJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-webview_release"})
public final class a
{
  private static final f Eeq;
  public static final a Eer;
  
  static
  {
    AppMethodBeat.i(199337);
    Eer = new a();
    Eeq = g.O((d.g.a.a)a.Ees);
    AppMethodBeat.o(199337);
  }
  
  public static void eSf()
  {
    AppMethodBeat.i(199336);
    m localm = m.EfD;
    m.bI((Map)Eeq.getValue());
    AppMethodBeat.o(199336);
  }
  
  public static HashMap<String, com.tencent.mm.plugin.webview.c.c.a> hc(List<? extends com.tencent.mm.plugin.webview.c.c.a> paramList)
  {
    AppMethodBeat.i(199335);
    p.h(paramList, "$this$toMap");
    HashMap localHashMap = new HashMap();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.webview.c.c.a locala = (com.tencent.mm.plugin.webview.c.c.a)paramList.next();
      ((Map)localHashMap).put(locala.eSx(), locala);
    }
    AppMethodBeat.o(199335);
    return localHashMap;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.c.c.a>>
  {
    public static final a Ees;
    
    static
    {
      AppMethodBeat.i(199334);
      Ees = new a();
      AppMethodBeat.o(199334);
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