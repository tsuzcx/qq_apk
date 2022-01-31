package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  implements am.a
{
  i$1(i parami) {}
  
  public final boolean tC()
  {
    String str = i.a(this.pvU);
    g localg;
    if (str != null)
    {
      localg = h.PB(str);
      if (localg != null) {
        break label77;
      }
      y.d("MicroMsg.VoiceRemindLogic", "startSend null record : " + str);
    }
    for (;;)
    {
      d.bLY().run();
      y.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.a(this.pvU));
      return false;
      label77:
      if (localg.field_status == 1)
      {
        localg.field_status = 2;
        localg.bcw = 64;
        h.a(localg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i.1
 * JD-Core Version:    0.7.0.1
 */