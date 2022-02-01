package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.a.u.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static boolean a(u paramu)
  {
    boolean bool = true;
    AppMethodBeat.i(137010);
    if (paramu.dbH.action != 6) {
      ad.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(paramu.dbH.action) });
    }
    switch (paramu.dbH.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137010);
      return bool;
      Object localObject = f.cTC().hz(paramu.dbH.appId, paramu.dbH.cTr);
      paramu.dbH.cTr = ((String)localObject);
      continue;
      bool = f.cTC().h(paramu.dbH.dbK);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().b(paramu.dbH.cTr, paramu.dbH.dbK);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().ahQ(paramu.dbH.cTr);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().ahR(paramu.dbH.cTr);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().ahS(paramu.dbH.cTr);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().ahT(paramu.dbH.cTr);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().dU(paramu.dbH.cTr, paramu.dbH.dbJ);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().ahU(paramu.dbH.cTr);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().vC(paramu.dbH.cTr);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().fC(paramu.dbH.cTr);
      paramu.dbI.result = bool;
      continue;
      bool = f.cTC().ahV(paramu.dbH.cTr);
      paramu.dbI.result = bool;
      continue;
      localObject = f.cTC().ahW(paramu.dbH.cTr);
      paramu.dbI.dbM = ((d)localObject);
      continue;
      int i = f.cTC().ahX(paramu.dbH.appId);
      paramu.dbI.count = i;
      continue;
      f.cTC().ahZ(paramu.dbH.appId);
      continue;
      f.cTC().aia(paramu.dbH.appId);
      continue;
      f.cTC().aih(paramu.dbH.processName);
      continue;
      localObject = f.cTC().vD(paramu.dbH.cTr);
      paramu.dbH.dbK = ((b)localObject);
      continue;
      bool = f.cTC().g(paramu.dbH.dbK);
      paramu.dbI.result = bool;
      continue;
      f.cTC().dbL = paramu.dbH.dbL;
      paramu.dbI.result = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a
 * JD-Core Version:    0.7.0.1
 */