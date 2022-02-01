package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.soter.core.d.e;

final class b$1
  implements e
{
  public final void dFb()
  {
    AppMethodBeat.i(130870);
    h.vKh.idkeyStat(1104L, 5L, 1L, false);
    AppMethodBeat.o(130870);
  }
  
  public final void dFc()
  {
    AppMethodBeat.i(130872);
    h.vKh.idkeyStat(1104L, 7L, 1L, false);
    AppMethodBeat.o(130872);
  }
  
  public final void dFd()
  {
    AppMethodBeat.i(130873);
    h.vKh.idkeyStat(1104L, 8L, 1L, false);
    AppMethodBeat.o(130873);
  }
  
  public final void dFe()
  {
    AppMethodBeat.i(130874);
    ad.i("MicroMsg.SoterInitManager", "no service when calling");
    h.vKh.idkeyStat(1104L, 9L, 1L, false);
    AppMethodBeat.o(130874);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(130871);
    h.vKh.idkeyStat(1104L, 6L, 1L, false);
    if (!com.tencent.soter.a.a.fnk()) {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(130869);
          if (!com.tencent.soter.a.a.fnk())
          {
            ad.i("MicroMsg.SoterInitManager", "bind service timeout, reinit");
            b.a(false, new g()
            {
              public final void aU(int paramAnonymous2Int, String paramAnonymous2String)
              {
                AppMethodBeat.i(130868);
                ad.i("MicroMsg.SoterInitManager", "init finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
                nd localnd = new nd();
                localnd.dsj.errCode = paramAnonymous2Int;
                localnd.dsj.errMsg = paramAnonymous2String;
                com.tencent.mm.sdk.b.a.ESL.l(localnd);
                AppMethodBeat.o(130868);
              }
            });
          }
          AppMethodBeat.o(130869);
        }
      }, 5000L);
    }
    AppMethodBeat.o(130871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b.1
 * JD-Core Version:    0.7.0.1
 */