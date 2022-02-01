package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchJSApi;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "setPreGetParams", "", "params", "", "Companion", "plugin-webview_release"})
public final class a
{
  public static final a QmT;
  private Context context;
  
  static
  {
    AppMethodBeat.i(216565);
    QmT = new a((byte)0);
    AppMethodBeat.o(216565);
  }
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  @JavascriptInterface
  public final void setPreGetParams(String paramString)
  {
    AppMethodBeat.i(216562);
    h.ZvG.d((Runnable)new b(paramString), "MicroMsg.WebSearch.WebSearchJSApi");
    AppMethodBeat.o(216562);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchJSApi$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(215719);
      j.setPreGetParams(this.QmU);
      AppMethodBeat.o(215719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.a
 * JD-Core Version:    0.7.0.1
 */