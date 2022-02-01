package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/fts/PreGetController$ReqStatus;", "kotlin.jvm.PlatformType", "handleCallback"})
final class a$b
  implements h.a
{
  public static final b INQ;
  
  static
  {
    AppMethodBeat.i(210298);
    INQ = new b();
    AppMethodBeat.o(210298);
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(210297);
    if (((paramb.IOM instanceof v)) && ((paramb.ION instanceof String)))
    {
      Object localObject = paramb.IOM;
      if (localObject == null)
      {
        paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.websearch.api.NetSceneRequestModel");
        AppMethodBeat.o(210297);
        throw paramb;
      }
      localObject = (v)localObject;
      f localf = g.ahd(((v)localObject).dVL);
      paramb = paramb.ION;
      if (paramb == null)
      {
        paramb = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210297);
        throw paramb;
      }
      localf.mg((String)paramb, ((v)localObject).dPI);
    }
    AppMethodBeat.o(210297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.b
 * JD-Core Version:    0.7.0.1
 */