package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
{
  public String wXa = null;
  long wXb = -1L;
  long wXc = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(285181);
    if ((!Util.isNullOrNil(this.wXa)) && (Util.ticksToNow(this.wXc + 3600L) / 1000L < this.wXb))
    {
      AppMethodBeat.o(285181);
      return true;
    }
    AppMethodBeat.o(285181);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(285188);
    String str = "ILinkSessionKey{sessionKey='" + this.wXa + '\'' + ", expireTicks=" + this.wXb + ", initTicks=" + this.wXc + '}';
    AppMethodBeat.o(285188);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.p
 * JD-Core Version:    0.7.0.1
 */