package com.tencent.mm.plugin.welab;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements bx.a
{
  public final void a(e.a parama)
  {
    if ((parama == null) || (parama.dBs == null) || (parama.dBs.svH == null)) {
      y.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
    }
    do
    {
      return;
      parama = aa.a(parama.dBs.svH);
      y.i("MicroMsg.WelabNewMsgLsn", "recv addMsg " + parama);
      parama = g.Uh(parama);
    } while ((parama == null) || (!parama.isValid()));
    if (parama.field_status == 1) {
      b.chc().rEr.a(parama, new String[] { "expId" });
    }
    for (;;)
    {
      e.q(parama.field_LabsAppId, 6, false);
      return;
      b.chc().rEr.c(parama);
      com.tencent.mm.plugin.welab.d.b.chq().f(parama);
      h.nFQ.a(parama.field_idkey, parama.field_idkeyValue, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c
 * JD-Core Version:    0.7.0.1
 */