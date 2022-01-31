package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class j$3
  implements ap.a
{
  j$3(j paramj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25309);
    ab.d("MicroMsg.VoiceRemindService", "onTimerExpired");
    try
    {
      j.h(this.sXD);
      AppMethodBeat.o(25309);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.VoiceRemindService", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.j.3
 * JD-Core Version:    0.7.0.1
 */