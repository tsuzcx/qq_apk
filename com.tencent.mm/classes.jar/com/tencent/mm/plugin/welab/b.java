package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements cc.a
{
  public final void a(f.a parama)
  {
    AppMethodBeat.i(146209);
    if ((parama == null) || (parama.fXi == null) || (parama.fXi.DPV == null))
    {
      ac.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
      AppMethodBeat.o(146209);
      return;
    }
    parama = z.a(parama.fXi.DPV);
    ac.i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(parama)));
    parama = f.aEp(parama);
    if ((parama != null) && (parama.isValid()))
    {
      if (parama.field_status != 1) {
        break label124;
      }
      a.eHv().CTI.delete(parama, new String[] { "expId" });
    }
    for (;;)
    {
      d.v(parama.field_LabsAppId, 6, false);
      AppMethodBeat.o(146209);
      return;
      label124:
      a.eHv().CTI.c(parama);
      com.tencent.mm.plugin.welab.e.b.eHK().f(parama);
      parama.reportIdkey();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(parama);
      a.eHv();
      a.gM(localArrayList);
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b
 * JD-Core Version:    0.7.0.1
 */