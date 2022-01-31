package com.tencent.mm.plugin.offline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class k$4
  implements bz.a
{
  k$4(k paramk) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(43357);
    String str = aa.a(parama.eyJ.woR);
    ab.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(str)));
    k.a(this.pkU).post(new k.4.1(this, str, parama));
    AppMethodBeat.o(43357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k.4
 * JD-Core Version:    0.7.0.1
 */