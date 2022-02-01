package com.tencent.mm.plugin.surface.b.a;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceDevMsgJsApi;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApi;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceDevMsgJsApiContext;", "context", "(Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceDevMsgJsApiContext;)V", "reportCanvasId", "", "id", "", "sendMessage", "payload", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends h<d>
{
  public c(d paramd)
  {
    super("DevtoolsMessage", (i)paramd);
    AppMethodBeat.i(265140);
    AppMethodBeat.o(265140);
  }
  
  @JavascriptInterface
  public final void reportCanvasId(String paramString)
  {
    AppMethodBeat.i(265156);
    s.u(paramString, "id");
    hBQ();
    d.reportCanvasId(paramString);
    AppMethodBeat.o(265156);
  }
  
  @JavascriptInterface
  public final void sendMessage(String paramString)
  {
    AppMethodBeat.i(265147);
    s.u(paramString, "payload");
    hBQ();
    d.sendMessage(paramString);
    AppMethodBeat.o(265147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a.c
 * JD-Core Version:    0.7.0.1
 */