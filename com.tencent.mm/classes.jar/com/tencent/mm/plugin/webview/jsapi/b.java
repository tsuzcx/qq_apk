package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/DefaultJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final j OOh;
  public static final b WDu;
  
  static
  {
    AppMethodBeat.i(295275);
    WDu = new b();
    OOh = k.cm((kotlin.g.a.a)a.WDv);
    AppMethodBeat.o(295275);
  }
  
  public static void its()
  {
    AppMethodBeat.i(295264);
    s locals = s.WEN;
    s.cl((Map)OOh.getValue());
    AppMethodBeat.o(295264);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.jsapi.c.a>>
  {
    public static final a WDv;
    
    static
    {
      AppMethodBeat.i(295333);
      WDv = new a();
      AppMethodBeat.o(295333);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.b
 * JD-Core Version:    0.7.0.1
 */