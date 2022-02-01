package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;", "T", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "getWebSearchData", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryData;", "getWebSearchJSApi", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryJSApi;", "onSearchInputChange", "", "query", "", "inputChange", "", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e<T>
  extends d<T>
{
  public abstract void cd(String paramString, boolean paramBoolean);
  
  public abstract n<T> fyE();
  
  public abstract o<T> fyP();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T> void a(e<T> parame)
    {
      AppMethodBeat.i(315186);
      s.u(parame, "this");
      d.a.a((d)parame);
      AppMethodBeat.o(315186);
    }
    
    public static <T> void b(e<T> parame)
    {
      AppMethodBeat.i(315189);
      s.u(parame, "this");
      d.a.b((d)parame);
      AppMethodBeat.o(315189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.e
 * JD-Core Version:    0.7.0.1
 */