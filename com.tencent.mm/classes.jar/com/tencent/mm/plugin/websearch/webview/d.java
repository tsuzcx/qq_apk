package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "T", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "getWebSearchData", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "getWebSearchJSApi", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d<T>
  extends f<T>
{
  public abstract k<T> fyR();
  
  public abstract l<T> fyT();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T> void a(d<T> paramd)
    {
      AppMethodBeat.i(315296);
      s.u(paramd, "this");
      s.u((f)paramd, "this");
      AppMethodBeat.o(315296);
    }
    
    public static <T> void b(d<T> paramd)
    {
      AppMethodBeat.i(315299);
      s.u(paramd, "this");
      s.u((f)paramd, "this");
      AppMethodBeat.o(315299);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.d
 * JD-Core Version:    0.7.0.1
 */