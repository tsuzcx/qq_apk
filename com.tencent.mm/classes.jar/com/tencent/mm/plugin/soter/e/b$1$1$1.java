package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

final class b$1$1$1
  implements g
{
  b$1$1$1(b.1.1 param1) {}
  
  public final void bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(130868);
    ae.i("MicroMsg.SoterInitManager", "init finish: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    nv localnv = new nv();
    localnv.dCM.errCode = paramInt;
    localnv.dCM.errMsg = paramString;
    a.IvT.l(localnv);
    AppMethodBeat.o(130868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b.1.1.1
 * JD-Core Version:    0.7.0.1
 */