package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static boolean a(v paramv)
  {
    boolean bool = true;
    AppMethodBeat.i(137010);
    if (paramv.dlA.action != 6) {
      ae.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(paramv.dlA.action) });
    }
    switch (paramv.dlA.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137010);
      return bool;
      Object localObject = f.duL().ij(paramv.dlA.appId, paramv.dlA.ddg);
      paramv.dlA.ddg = ((String)localObject);
      continue;
      bool = f.duL().h(paramv.dlA.dlD);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().b(paramv.dlA.ddg, paramv.dlA.dlD);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().asX(paramv.dlA.ddg);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().asY(paramv.dlA.ddg);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().asZ(paramv.dlA.ddg);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().ata(paramv.dlA.ddg);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().eB(paramv.dlA.ddg, paramv.dlA.dlC);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().atb(paramv.dlA.ddg);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().Dj(paramv.dlA.ddg);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().gt(paramv.dlA.ddg);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().atc(paramv.dlA.ddg);
      paramv.dlB.result = bool;
      continue;
      localObject = f.duL().atd(paramv.dlA.ddg);
      paramv.dlB.dlF = ((d)localObject);
      continue;
      int i = f.duL().ate(paramv.dlA.appId);
      paramv.dlB.count = i;
      continue;
      f.duL().atg(paramv.dlA.appId);
      continue;
      f.duL().ath(paramv.dlA.appId);
      continue;
      f.duL().ato(paramv.dlA.processName);
      continue;
      localObject = f.duL().Dk(paramv.dlA.ddg);
      paramv.dlA.dlD = ((b)localObject);
      continue;
      bool = f.duL().g(paramv.dlA.dlD);
      paramv.dlB.result = bool;
      continue;
      bool = f.duL().a(paramv.dlA.dlE);
      paramv.dlB.result = true;
      continue;
      paramv.dlB.dlE = f.duL().dlE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a
 * JD-Core Version:    0.7.0.1
 */