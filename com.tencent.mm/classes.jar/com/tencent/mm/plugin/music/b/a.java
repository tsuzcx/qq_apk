package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public static boolean a(v paramv)
  {
    boolean bool = true;
    AppMethodBeat.i(137010);
    if (paramv.cZg.action != 6) {
      ac.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(paramv.cZg.action) });
    }
    switch (paramv.cZg.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137010);
      return bool;
      Object localObject = f.dhm().hS(paramv.cZg.appId, paramv.cZg.cQO);
      paramv.cZg.cQO = ((String)localObject);
      continue;
      bool = f.dhm().h(paramv.cZg.cZj);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().b(paramv.cZg.cQO, paramv.cZg.cZj);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().amL(paramv.cZg.cQO);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().amM(paramv.cZg.cQO);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().amN(paramv.cZg.cQO);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().amO(paramv.cZg.cQO);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().eb(paramv.cZg.cQO, paramv.cZg.cZi);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().amP(paramv.cZg.cQO);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().zI(paramv.cZg.cQO);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().fs(paramv.cZg.cQO);
      paramv.cZh.result = bool;
      continue;
      bool = f.dhm().amQ(paramv.cZg.cQO);
      paramv.cZh.result = bool;
      continue;
      localObject = f.dhm().amR(paramv.cZg.cQO);
      paramv.cZh.cZl = ((d)localObject);
      continue;
      int i = f.dhm().amS(paramv.cZg.appId);
      paramv.cZh.count = i;
      continue;
      f.dhm().amU(paramv.cZg.appId);
      continue;
      f.dhm().amV(paramv.cZg.appId);
      continue;
      f.dhm().anc(paramv.cZg.processName);
      continue;
      localObject = f.dhm().zJ(paramv.cZg.cQO);
      paramv.cZg.cZj = ((b)localObject);
      continue;
      bool = f.dhm().g(paramv.cZg.cZj);
      paramv.cZh.result = bool;
      continue;
      f.dhm().cZk = paramv.cZg.cZk;
      paramv.cZh.result = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a
 * JD-Core Version:    0.7.0.1
 */