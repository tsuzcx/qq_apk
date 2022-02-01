package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static boolean a(v paramv)
  {
    boolean bool = true;
    AppMethodBeat.i(137010);
    if (paramv.dky.action != 6) {
      ad.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(paramv.dky.action) });
    }
    switch (paramv.dky.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137010);
      return bool;
      Object localObject = f.drz().id(paramv.dky.appId, paramv.dky.dce);
      paramv.dky.dce = ((String)localObject);
      continue;
      bool = f.drz().h(paramv.dky.dkB);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().b(paramv.dky.dce, paramv.dky.dkB);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().arK(paramv.dky.dce);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().arL(paramv.dky.dce);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().arM(paramv.dky.dce);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().arN(paramv.dky.dce);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().et(paramv.dky.dce, paramv.dky.dkA);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().arO(paramv.dky.dce);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().CH(paramv.dky.dce);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().gn(paramv.dky.dce);
      paramv.dkz.result = bool;
      continue;
      bool = f.drz().arP(paramv.dky.dce);
      paramv.dkz.result = bool;
      continue;
      localObject = f.drz().arQ(paramv.dky.dce);
      paramv.dkz.dkD = ((d)localObject);
      continue;
      int i = f.drz().arR(paramv.dky.appId);
      paramv.dkz.count = i;
      continue;
      f.drz().arT(paramv.dky.appId);
      continue;
      f.drz().arU(paramv.dky.appId);
      continue;
      f.drz().asb(paramv.dky.processName);
      continue;
      localObject = f.drz().CI(paramv.dky.dce);
      paramv.dky.dkB = ((b)localObject);
      continue;
      bool = f.drz().g(paramv.dky.dkB);
      paramv.dkz.result = bool;
      continue;
      f.drz().dkC = paramv.dky.dkC;
      paramv.dkz.result = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a
 * JD-Core Version:    0.7.0.1
 */