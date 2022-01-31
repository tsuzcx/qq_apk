package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class j$3
  implements am.a
{
  j$3(j paramj) {}
  
  public final boolean tC()
  {
    y.d("MicroMsg.VoiceRemindService", "onTimerExpired");
    try
    {
      j.h(this.pvX);
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.VoiceRemindService", localException, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.j.3
 * JD-Core Version:    0.7.0.1
 */