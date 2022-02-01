package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static boolean a(x paramx)
  {
    boolean bool = true;
    AppMethodBeat.i(137010);
    if (paramx.dCQ.action != 6) {
      Log.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(paramx.dCQ.action) });
    }
    switch (paramx.dCQ.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137010);
      return bool;
      Object localObject = h.esI().iS(paramx.dCQ.appId, paramx.dCQ.dtX);
      paramx.dCQ.dtX = ((String)localObject);
      continue;
      bool = h.esI().m(paramx.dCQ.dCT);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().b(paramx.dCQ.dtX, paramx.dCQ.dCT);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().aGT(paramx.dCQ.dtX);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().aGU(paramx.dCQ.dtX);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().aGV(paramx.dCQ.dtX);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().aGW(paramx.dCQ.dtX);
      paramx.dCR.result = true;
      continue;
      bool = h.esI().eQ(paramx.dCQ.dtX, paramx.dCQ.dCS);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().aGX(paramx.dCQ.dtX);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().LT(paramx.dCQ.dtX);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().hi(paramx.dCQ.dtX);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().aGY(paramx.dCQ.dtX);
      paramx.dCR.result = bool;
      continue;
      localObject = h.esI().aGZ(paramx.dCQ.dtX);
      paramx.dCR.dCV = ((d)localObject);
      continue;
      int i = h.esI().aHa(paramx.dCQ.appId);
      paramx.dCR.count = i;
      continue;
      h.esI().aHc(paramx.dCQ.appId);
      continue;
      h.esI().aHd(paramx.dCQ.appId);
      continue;
      h.esI().aHk(paramx.dCQ.processName);
      continue;
      localObject = h.esI().LU(paramx.dCQ.dtX);
      paramx.dCQ.dCT = ((b)localObject);
      continue;
      bool = h.esI().l(paramx.dCQ.dCT);
      paramx.dCR.result = bool;
      continue;
      bool = h.esI().a(paramx.dCQ.dCU);
      paramx.dCR.result = true;
      continue;
      paramx.dCR.dCU = h.esI().dCU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a
 * JD-Core Version:    0.7.0.1
 */