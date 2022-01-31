package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.plugin.u.a.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class p$3
  implements b.a
{
  p$3(p paramp) {}
  
  public final void XF(String paramString)
  {
    AppMethodBeat.i(80882);
    ab.i("MicroMsg.RecogQBarOfImageFileListener", "result(failed): %s", new Object[] { paramString });
    nx localnx = new nx();
    localnx.cEx.filePath = paramString;
    a.ymk.l(localnx);
    AppMethodBeat.o(80882);
  }
  
  public final void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(151658);
    ab.i("MicroMsg.RecogQBarOfImageFileListener", "result: %s, codeType: %s, codeVersion: %s, filePath:%s", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
    n.qux.bJP();
    paramArrayOfByte = new ny();
    paramArrayOfByte.cEy.filePath = paramString1;
    paramArrayOfByte.cEy.result = paramString2;
    paramArrayOfByte.cEy.cpE = paramInt1;
    paramArrayOfByte.cEy.cpF = paramInt2;
    a.ymk.l(paramArrayOfByte);
    AppMethodBeat.o(151658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.p.3
 * JD-Core Version:    0.7.0.1
 */