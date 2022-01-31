package com.tencent.mm.plugin.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class b$2
  implements bz.a
{
  b$2(b paramb) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(43728);
    parama = aa.a(parama.eyJ.woR);
    ab.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(parama)));
    b.a(this.poJ).post(new b.2.1(this, parama));
    AppMethodBeat.o(43728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.2
 * JD-Core Version:    0.7.0.1
 */