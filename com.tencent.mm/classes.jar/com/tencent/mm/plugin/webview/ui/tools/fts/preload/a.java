package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchJSApi;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "setPreGetParams", "", "params", "", "Companion", "plugin-webview_release"})
public final class a
{
  public static final a Jpy;
  private Context context;
  
  static
  {
    AppMethodBeat.i(210525);
    Jpy = new a((byte)0);
    AppMethodBeat.o(210525);
  }
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  @JavascriptInterface
  public final void setPreGetParams(String paramString)
  {
    AppMethodBeat.i(210524);
    h.RTc.b((Runnable)new b(paramString), "MicroMsg.WebSearch.WebSearchJSApi");
    AppMethodBeat.o(210524);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchJSApi$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(210523);
      j.setPreGetParams(this.Jpz);
      AppMethodBeat.o(210523);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.a
 * JD-Core Version:    0.7.0.1
 */