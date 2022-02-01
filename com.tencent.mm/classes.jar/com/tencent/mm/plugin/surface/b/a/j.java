package com.tencent.mm.plugin.surface.b.a;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceWorkerJsApi;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApi;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceWorkerJsApiContext;", "context", "(Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceWorkerJsApiContext;)V", "create", "", "path", "", "postMsgToWorker", "", "id", "message", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends h<k>
{
  public j(k paramk)
  {
    super("WeixinWorker", (i)paramk);
    AppMethodBeat.i(265137);
    AppMethodBeat.o(265137);
  }
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    AppMethodBeat.i(265149);
    s.u(paramString, "path");
    int i = ((k)hBQ()).create(paramString);
    AppMethodBeat.o(265149);
    return i;
  }
  
  @JavascriptInterface
  public final void postMsgToWorker(int paramInt, String paramString)
  {
    AppMethodBeat.i(265141);
    s.u(paramString, "message");
    ((k)hBQ()).postMsgToWorker(paramInt, paramString);
    AppMethodBeat.o(265141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a.j
 * JD-Core Version:    0.7.0.1
 */