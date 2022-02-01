package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d;
import com.tencent.mm.autogen.a.ab;
import com.tencent.mm.autogen.a.ab.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static boolean a(ab paramab)
  {
    boolean bool = true;
    AppMethodBeat.i(137010);
    if (paramab.hzS.action != 6) {
      Log.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(paramab.hzS.action) });
    }
    switch (paramab.hzS.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137010);
      return bool;
      Object localObject = i.glV().bo(paramab.hzS.appId, paramab.hzS.hqQ);
      paramab.hzS.hqQ = ((String)localObject);
      continue;
      bool = i.glV().l(paramab.hzS.hzU);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().b(paramab.hzS.hqQ, paramab.hzS.hzU);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().aOb(paramab.hzS.hqQ);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().Lo(paramab.hzS.hqQ);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().aOc(paramab.hzS.hqQ);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().Lp(paramab.hzS.hqQ);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().gk(paramab.hzS.hqQ, paramab.hzS.currentTime);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().aOd(paramab.hzS.hqQ);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().Lq(paramab.hzS.hqQ);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().jw(paramab.hzS.hqQ);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().aOe(paramab.hzS.hqQ);
      paramab.hzT.result = bool;
      continue;
      localObject = i.glV().aOf(paramab.hzS.hqQ);
      paramab.hzT.hzW = ((d)localObject);
      continue;
      int i = i.glV().aOg(paramab.hzS.appId);
      paramab.hzT.count = i;
      continue;
      i.glV().aOi(paramab.hzS.appId);
      continue;
      i.glV().aOj(paramab.hzS.appId);
      continue;
      i.glV().aOq(paramab.hzS.processName);
      continue;
      localObject = i.glV().Lr(paramab.hzS.hqQ);
      paramab.hzS.hzU = ((com.tencent.mm.al.b)localObject);
      continue;
      bool = i.glV().m(paramab.hzS.hzU);
      paramab.hzT.result = bool;
      continue;
      bool = i.glV().a(paramab.hzS.hzV);
      paramab.hzT.result = bool;
      continue;
      paramab.hzT.hzV = i.glV().hzV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b
 * JD-Core Version:    0.7.0.1
 */