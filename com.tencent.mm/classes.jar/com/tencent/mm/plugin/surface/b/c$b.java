package com.tencent.mm.plugin.surface.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class c$b
  extends u
  implements a<ah>
{
  c$b(c paramc)
  {
    super(0);
  }
  
  private static final int g(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(265105);
    paramc = c.c.b(paramc.otC);
    if (paramc == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JSOperateWxDataResponse");
      AppMethodBeat.o(265105);
      throw paramString;
    }
    paramc = ((deh)paramc).aaJx;
    Log.d("MicroMsg.SurfaceApp.JsApiOperateWXData", paramInt1 + ", " + paramString + ", " + paramInt2 + ", " + paramc.hGE + ", " + paramc.errmsg);
    AppMethodBeat.o(265105);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.c.b
 * JD-Core Version:    0.7.0.1
 */