package com.tencent.mm.plugin.surface.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceDevMsgJsApiContext;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApiContext;", "()V", "reportCanvasId", "", "id", "", "sendMessage", "payload", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements i
{
  public static final a SLa;
  
  static
  {
    AppMethodBeat.i(265164);
    SLa = new a((byte)0);
    AppMethodBeat.o(265164);
  }
  
  public static void reportCanvasId(String paramString)
  {
    AppMethodBeat.i(265158);
    kotlin.g.b.s.u(paramString, "id");
    Log.i("MicroMsg.SurfaceApp.JSAPI.SurfaceDevMsgJsApi", kotlin.g.b.s.X("receive CanvasId ", paramString));
    AppMethodBeat.o(265158);
  }
  
  public static void sendMessage(String paramString)
  {
    AppMethodBeat.i(265148);
    kotlin.g.b.s.u(paramString, "payload");
    Log.i("MicroMsg.SurfaceApp.JSAPI.SurfaceDevMsgJsApi", kotlin.g.b.s.X("receive ", paramString));
    h.ax(com.tencent.mm.api.s.class);
    AppMethodBeat.o(265148);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceDevMsgJsApiContext$Companion;", "", "()V", "TAG", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a.d
 * JD-Core Version:    0.7.0.1
 */