package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements cj.a
{
  public final void a(h.a parama)
  {
    AppMethodBeat.i(146209);
    if ((parama == null) || (parama.heO == null) || (parama.heO.KHn == null))
    {
      Log.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
      AppMethodBeat.o(146209);
      return;
    }
    parama = z.a(parama.heO.KHn);
    Log.i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(parama)));
    parama = e.bbB(parama);
    if ((parama != null) && (parama.isValid()))
    {
      if (parama.field_status != 1) {
        break label124;
      }
      a.gjg().JFR.delete(parama, new String[] { "expId" });
    }
    for (;;)
    {
      d.y(parama.field_LabsAppId, 6, false);
      AppMethodBeat.o(146209);
      return;
      label124:
      a.gjg().JFR.c(parama);
      com.tencent.mm.plugin.welab.e.b.gju().f(parama);
      parama.reportIdkey();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(parama);
      a.gjg();
      a.io(localArrayList);
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b
 * JD-Core Version:    0.7.0.1
 */