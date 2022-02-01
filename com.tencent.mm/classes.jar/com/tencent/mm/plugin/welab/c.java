package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements cl.a
{
  public final void a(g.a parama)
  {
    AppMethodBeat.i(146209);
    if ((parama == null) || (parama.mpN == null) || (parama.mpN.YFG == null))
    {
      Log.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
      AppMethodBeat.o(146209);
      return;
    }
    parama = w.a(parama.mpN.YFG);
    Log.i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(parama)));
    parama = f.bnp(parama);
    if ((parama != null) && (parama.isValid()))
    {
      if (parama.field_status != 1) {
        break label124;
      }
      b.iDA().XyB.delete(parama, new String[] { "expId" });
    }
    for (;;)
    {
      e.E(parama.field_LabsAppId, 6, false);
      AppMethodBeat.o(146209);
      return;
      label124:
      b.iDA().XyB.c(parama);
      com.tencent.mm.plugin.welab.e.b.iDO().f(parama);
      parama.reportIdkey();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(parama);
      b.iDA();
      b.mo(localArrayList);
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c
 * JD-Core Version:    0.7.0.1
 */