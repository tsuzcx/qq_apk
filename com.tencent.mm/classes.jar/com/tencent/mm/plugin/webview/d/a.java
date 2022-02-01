package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/jsapi/DefaultJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-webview_release"})
public final class a
{
  private static final f CDG;
  public static final a IQX;
  
  static
  {
    AppMethodBeat.i(210311);
    IQX = new a();
    CDG = g.ah((kotlin.g.a.a)a.IQY);
    AppMethodBeat.o(210311);
  }
  
  public static void gaR()
  {
    AppMethodBeat.i(210310);
    p localp = p.ISk;
    p.bN((Map)CDG.getValue());
    AppMethodBeat.o(210310);
  }
  
  public static HashMap<String, com.tencent.mm.plugin.webview.d.c.a> gz(List<? extends com.tencent.mm.plugin.webview.d.c.a> paramList)
  {
    AppMethodBeat.i(210309);
    kotlin.g.b.p.h(paramList, "$this$toMap");
    HashMap localHashMap = new HashMap();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.webview.d.c.a locala = (com.tencent.mm.plugin.webview.d.c.a)paramList.next();
      ((Map)localHashMap).put(locala.ePz(), locala);
    }
    AppMethodBeat.o(210309);
    return localHashMap;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.d.c.a>>
  {
    public static final a IQY;
    
    static
    {
      AppMethodBeat.i(210308);
      IQY = new a();
      AppMethodBeat.o(210308);
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