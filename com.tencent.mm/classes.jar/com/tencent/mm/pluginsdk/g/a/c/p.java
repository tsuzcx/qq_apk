package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

final class p
{
  public static void dmy()
  {
    AppMethodBeat.i(79611);
    if (g.RJ().QU())
    {
      g.RJ();
      if (!a.QP()) {}
    }
    else
    {
      AppMethodBeat.o(79611);
      return;
    }
    if (getNetworkType() == 0)
    {
      AppMethodBeat.o(79611);
      return;
    }
    long l = bo.aox();
    if (bo.a((Long)g.RL().Ru().get(ac.a.yAT, null), 0L) < l)
    {
      g.RL().Ru().set(ac.a.yAT, Long.valueOf(7200L + l));
      ab.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
      q.a.dmz().aNS().ac(new p.1());
    }
    AppMethodBeat.o(79611);
  }
  
  static int getNetworkType()
  {
    AppMethodBeat.i(79612);
    switch (com.tencent.mm.compatible.e.z.LZ())
    {
    default: 
      AppMethodBeat.o(79612);
      return 2;
    case 0: 
      AppMethodBeat.o(79612);
      return 0;
    }
    AppMethodBeat.o(79612);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.p
 * JD-Core Version:    0.7.0.1
 */