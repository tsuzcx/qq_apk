package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class i$1
  implements ap.a
{
  i$1(i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25292);
    String str = i.a(this.sXA);
    g localg;
    if (str != null)
    {
      localg = d.cGT().adV(str);
      if (localg != null) {
        break label85;
      }
      ab.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
    }
    for (;;)
    {
      d.cGU().run();
      ab.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.a(this.sXA));
      AppMethodBeat.o(25292);
      return false;
      label85:
      if (localg.field_status == 1)
      {
        localg.field_status = 2;
        localg.bsY = 64;
        h.a(localg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i.1
 * JD-Core Version:    0.7.0.1
 */