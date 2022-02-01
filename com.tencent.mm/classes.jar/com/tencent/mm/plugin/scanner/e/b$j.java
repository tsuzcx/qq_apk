package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
final class b$j
  implements g
{
  b$j(b paramb, e parame) {}
  
  public final void a(long paramLong, f paramf)
  {
    AppMethodBeat.i(240504);
    p.h(paramf, "result");
    Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo dealWithImageOcr onCallback session: %s, success: %b, errType: %s, errCode: %s, errMsg: %s, result: %s, reqKey: %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramf.success), Integer.valueOf(paramf.errType), Integer.valueOf(paramf.errCode), paramf.errMsg, paramf.dZL, paramf.dDL });
    b.a(this.CIF);
    c localc = b.b(this.CIF);
    if (localc != null) {
      localc.a(paramf);
    }
    if (paramf.success)
    {
      b.a(this.CIF, this.CFc, paramf);
      AppMethodBeat.o(240504);
      return;
    }
    b.a(this.CIF, paramf.errType, paramf.errCode);
    AppMethodBeat.o(240504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.b.j
 * JD-Core Version:    0.7.0.1
 */