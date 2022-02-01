package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.soter.a.a;
import com.tencent.soter.core.d.e;

final class b$1
  implements e
{
  public final void cZf()
  {
    AppMethodBeat.i(130871);
    h.IzE.idkeyStat(1104L, 6L, 1L, false);
    if (!a.ipb()) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(130869);
          if (!a.ipb())
          {
            Log.i("MicroMsg.SoterInitManager", "bind service timeout, reinit");
            b.a(false, new g()
            {
              public final void bh(int paramAnonymous2Int, String paramAnonymous2String)
              {
                AppMethodBeat.i(130868);
                Log.i("MicroMsg.SoterInitManager", "init finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
                pk localpk = new pk();
                localpk.fOe.errCode = paramAnonymous2Int;
                localpk.fOe.errMsg = paramAnonymous2String;
                EventCenter.instance.publish(localpk);
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
  
  public final void gau()
  {
    AppMethodBeat.i(130870);
    h.IzE.idkeyStat(1104L, 5L, 1L, false);
    AppMethodBeat.o(130870);
  }
  
  public final void gav()
  {
    AppMethodBeat.i(130872);
    h.IzE.idkeyStat(1104L, 7L, 1L, false);
    AppMethodBeat.o(130872);
  }
  
  public final void gaw()
  {
    AppMethodBeat.i(130873);
    h.IzE.idkeyStat(1104L, 8L, 1L, false);
    AppMethodBeat.o(130873);
  }
  
  public final void gax()
  {
    AppMethodBeat.i(130874);
    Log.i("MicroMsg.SoterInitManager", "no service when calling");
    h.IzE.idkeyStat(1104L, 9L, 1L, false);
    AppMethodBeat.o(130874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b.1
 * JD-Core Version:    0.7.0.1
 */