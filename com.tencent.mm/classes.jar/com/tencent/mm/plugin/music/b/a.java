package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.s.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static boolean a(s params)
  {
    boolean bool = true;
    AppMethodBeat.i(137260);
    if (params.cmS.action != 6) {
      ab.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(params.cmS.action) });
    }
    switch (params.cmS.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137260);
      return bool;
      Object localObject = f.bTZ().ft(params.cmS.appId, params.cmS.ceu);
      params.cmS.ceu = ((String)localObject);
      continue;
      bool = f.bTZ().h(params.cmS.cmV);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().b(params.cmS.ceu, params.cmS.cmV);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().UG(params.cmS.ceu);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().UH(params.cmS.ceu);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().UI(params.cmS.ceu);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().UJ(params.cmS.ceu);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().cP(params.cmS.ceu, params.cmS.cmU);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().UK(params.cmS.ceu);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().qI(params.cmS.ceu);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().ev(params.cmS.ceu);
      params.cmT.cmX = bool;
      continue;
      bool = f.bTZ().UL(params.cmS.ceu);
      params.cmT.cmX = bool;
      continue;
      localObject = f.bTZ().UM(params.cmS.ceu);
      params.cmT.cmY = ((d)localObject);
      continue;
      int i = f.bTZ().UN(params.cmS.appId);
      params.cmT.count = i;
      continue;
      f.bTZ().UP(params.cmS.appId);
      continue;
      f.bTZ().UQ(params.cmS.appId);
      continue;
      f.bTZ().UX(params.cmS.processName);
      continue;
      localObject = f.bTZ().qJ(params.cmS.ceu);
      params.cmS.cmV = ((b)localObject);
      continue;
      bool = f.bTZ().g(params.cmS.cmV);
      params.cmT.cmX = bool;
      continue;
      f.bTZ().cmW = params.cmS.cmW;
      params.cmT.cmX = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a
 * JD-Core Version:    0.7.0.1
 */