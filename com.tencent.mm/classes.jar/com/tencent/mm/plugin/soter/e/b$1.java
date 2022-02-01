package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.soter.core.d.e;

final class b$1
  implements e
{
  public final void dTC()
  {
    AppMethodBeat.i(130870);
    h.wUl.idkeyStat(1104L, 5L, 1L, false);
    AppMethodBeat.o(130870);
  }
  
  public final void dTD()
  {
    AppMethodBeat.i(130872);
    h.wUl.idkeyStat(1104L, 7L, 1L, false);
    AppMethodBeat.o(130872);
  }
  
  public final void dTE()
  {
    AppMethodBeat.i(130873);
    h.wUl.idkeyStat(1104L, 8L, 1L, false);
    AppMethodBeat.o(130873);
  }
  
  public final void dTF()
  {
    AppMethodBeat.i(130874);
    ac.i("MicroMsg.SoterInitManager", "no service when calling");
    h.wUl.idkeyStat(1104L, 9L, 1L, false);
    AppMethodBeat.o(130874);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(130871);
    h.wUl.idkeyStat(1104L, 6L, 1L, false);
    if (!com.tencent.soter.a.a.fDA()) {
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(130869);
          if (!com.tencent.soter.a.a.fDA())
          {
            ac.i("MicroMsg.SoterInitManager", "bind service timeout, reinit");
            b.a(false, new g()
            {
              public final void aZ(int paramAnonymous2Int, String paramAnonymous2String)
              {
                AppMethodBeat.i(130868);
                ac.i("MicroMsg.SoterInitManager", "init finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
                nm localnm = new nm();
                localnm.dpU.errCode = paramAnonymous2Int;
                localnm.dpU.errMsg = paramAnonymous2String;
                com.tencent.mm.sdk.b.a.GpY.l(localnm);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b.1
 * JD-Core Version:    0.7.0.1
 */