package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements cf.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(146209);
    if ((parama == null) || (parama.gte == null) || (parama.gte.FNI == null))
    {
      ae.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
      AppMethodBeat.o(146209);
      return;
    }
    parama = z.a(parama.gte.FNI);
    ae.i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(parama)));
    parama = f.aLl(parama);
    if ((parama != null) && (parama.isValid()))
    {
      if (parama.field_status != 1) {
        break label124;
      }
      a.faa().EQe.delete(parama, new String[] { "expId" });
    }
    for (;;)
    {
      d.v(parama.field_LabsAppId, 6, false);
      AppMethodBeat.o(146209);
      return;
      label124:
      a.faa().EQe.c(parama);
      com.tencent.mm.plugin.welab.e.b.fap().f(parama);
      parama.reportIdkey();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(parama);
      a.faa();
      a.hi(localArrayList);
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b
 * JD-Core Version:    0.7.0.1
 */