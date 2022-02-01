package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d;
import com.tencent.mm.f.a.y;
import com.tencent.mm.f.a.y.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static boolean a(y paramy)
  {
    boolean bool = true;
    AppMethodBeat.i(137010);
    if (paramy.fvx.action != 6) {
      Log.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(paramy.fvx.action) });
    }
    switch (paramy.fvx.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137010);
      return bool;
      Object localObject = i.fcS().be(paramy.fvx.appId, paramy.fvx.fmF);
      paramy.fvx.fmF = ((String)localObject);
      continue;
      bool = i.fcS().l(paramy.fvx.fvz);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().b(paramy.fvx.fmF, paramy.fvx.fvz);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().aRj(paramy.fvx.fmF);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().Tm(paramy.fvx.fmF);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().aRk(paramy.fvx.fmF);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().Tn(paramy.fvx.fmF);
      paramy.fvy.result = true;
      continue;
      bool = i.fcS().fr(paramy.fvx.fmF, paramy.fvx.currentTime);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().aRl(paramy.fvx.fmF);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().To(paramy.fvx.fmF);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().hV(paramy.fvx.fmF);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().aRm(paramy.fvx.fmF);
      paramy.fvy.result = bool;
      continue;
      localObject = i.fcS().aRn(paramy.fvx.fmF);
      paramy.fvy.fvB = ((d)localObject);
      continue;
      int i = i.fcS().aRo(paramy.fvx.appId);
      paramy.fvy.count = i;
      continue;
      i.fcS().aRq(paramy.fvx.appId);
      continue;
      i.fcS().aRr(paramy.fvx.appId);
      continue;
      i.fcS().aRy(paramy.fvx.processName);
      continue;
      localObject = i.fcS().Tp(paramy.fvx.fmF);
      paramy.fvx.fvz = ((com.tencent.mm.al.b)localObject);
      continue;
      bool = i.fcS().m(paramy.fvx.fvz);
      paramy.fvy.result = bool;
      continue;
      bool = i.fcS().a(paramy.fvx.fvA);
      paramy.fvy.result = true;
      continue;
      paramy.fvy.fvA = i.fcS().fvA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b
 * JD-Core Version:    0.7.0.1
 */