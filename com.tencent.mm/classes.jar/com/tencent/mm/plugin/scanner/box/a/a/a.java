package com.tencent.mm.plugin.scanner.box.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/DefaultScanJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a OOg;
  private static final j OOh;
  
  static
  {
    AppMethodBeat.i(313835);
    OOg = new a();
    OOh = k.cm((kotlin.g.a.a)a.OOi);
    AppMethodBeat.o(313835);
  }
  
  public static Map<String, com.tencent.mm.plugin.webview.jsapi.c.a> gPY()
  {
    AppMethodBeat.i(313826);
    Map localMap = (Map)OOh.getValue();
    AppMethodBeat.o(313826);
    return localMap;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.jsapi.c.a>>
  {
    public static final a OOi;
    
    static
    {
      AppMethodBeat.i(313818);
      OOi = new a();
      AppMethodBeat.o(313818);
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