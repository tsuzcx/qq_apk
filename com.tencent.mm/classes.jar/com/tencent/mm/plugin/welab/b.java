package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements bz.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(80536);
    if ((parama == null) || (parama.eyJ == null) || (parama.eyJ.woR == null))
    {
      ab.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
      AppMethodBeat.o(80536);
      return;
    }
    parama = aa.a(parama.eyJ.woR);
    ab.i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(parama)));
    parama = f.aju(parama);
    if ((parama != null) && (parama.isValid()))
    {
      if (parama.field_status != 1) {
        break label124;
      }
      a.dhl().vuT.delete(parama, new String[] { "expId" });
    }
    for (;;)
    {
      d.t(parama.field_LabsAppId, 6, false);
      AppMethodBeat.o(80536);
      return;
      label124:
      a.dhl().vuT.c(parama);
      com.tencent.mm.plugin.welab.e.b.dhC().f(parama);
      parama.dhw();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(parama);
      a.dhl();
      a.ej(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b
 * JD-Core Version:    0.7.0.1
 */