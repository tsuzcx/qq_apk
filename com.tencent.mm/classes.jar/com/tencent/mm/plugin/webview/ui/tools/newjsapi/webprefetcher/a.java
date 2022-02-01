package com.tencent.mm.plugin.webview.ui.tools.newjsapi.webprefetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/webprefetcher/DefaultWebPrefetcherJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final j OOh;
  public static final a Xoe;
  
  static
  {
    AppMethodBeat.i(297682);
    Xoe = new a();
    OOh = k.cm((kotlin.g.a.a)a.Xof);
    AppMethodBeat.o(297682);
  }
  
  public static final void its()
  {
    AppMethodBeat.i(297678);
    d locald = d.WPX;
    d.ck((Map)OOh.getValue());
    AppMethodBeat.o(297678);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.jsapi.c.a>>
  {
    public static final a Xof;
    
    static
    {
      AppMethodBeat.i(297676);
      Xof = new a();
      AppMethodBeat.o(297676);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.webprefetcher.a
 * JD-Core Version:    0.7.0.1
 */