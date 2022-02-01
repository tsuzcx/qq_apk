package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class p
{
  String tTJ = null;
  long tTK = -1L;
  long tTL = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(198766);
    if ((!Util.isNullOrNil(this.tTJ)) && (Util.ticksToNow(this.tTL + 3600L) / 1000L < this.tTK))
    {
      AppMethodBeat.o(198766);
      return true;
    }
    AppMethodBeat.o(198766);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198769);
    String str = "ILinkSessionKey{sessionKey='" + this.tTJ + '\'' + ", expireTicks=" + this.tTK + ", initTicks=" + this.tTL + '}';
    AppMethodBeat.o(198769);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p
 * JD-Core Version:    0.7.0.1
 */