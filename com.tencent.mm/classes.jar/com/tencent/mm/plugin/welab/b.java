package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements cd.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(146209);
    if ((parama == null) || (parama.gqE == null) || (parama.gqE.Fvk == null))
    {
      ad.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
      AppMethodBeat.o(146209);
      return;
    }
    parama = z.a(parama.gqE.Fvk);
    ad.i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(parama)));
    parama = f.aJP(parama);
    if ((parama != null) && (parama.isValid()))
    {
      if (parama.field_status != 1) {
        break label124;
      }
      a.eWo().ExI.delete(parama, new String[] { "expId" });
    }
    for (;;)
    {
      d.v(parama.field_LabsAppId, 6, false);
      AppMethodBeat.o(146209);
      return;
      label124:
      a.eWo().ExI.c(parama);
      com.tencent.mm.plugin.welab.e.b.eWD().f(parama);
      parama.reportIdkey();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(parama);
      a.eWo();
      a.gY(localArrayList);
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b
 * JD-Core Version:    0.7.0.1
 */