package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
final class b$g
  implements g
{
  b$g(b paramb, e parame) {}
  
  public final void a(long paramLong, f paramf)
  {
    AppMethodBeat.i(219932);
    p.k(paramf, "result");
    Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo dealWithImageOcr onCallback session: %s, success: %b, errType: %s, errCode: %s, errMsg: %s, result: %s, reqKey: %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramf.success), Integer.valueOf(paramf.errType), Integer.valueOf(paramf.errCode), paramf.errMsg, paramf.fTF, paramf.fwv });
    b.a(this.INw);
    c localc = b.b(this.INw);
    if (localc != null) {
      localc.a(paramf);
    }
    if (paramf.success)
    {
      b.a(this.INw, this.IJv, paramf);
      AppMethodBeat.o(219932);
      return;
    }
    b.a(this.INw, paramf.errType, paramf.errCode);
    AppMethodBeat.o(219932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.b.g
 * JD-Core Version:    0.7.0.1
 */