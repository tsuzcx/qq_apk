package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class q
{
  String quX = null;
  long quY = -1L;
  long quZ = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(239299);
    if ((!Util.isNullOrNil(this.quX)) && (Util.ticksToNow(this.quZ + 3600L) / 1000L < this.quY))
    {
      AppMethodBeat.o(239299);
      return true;
    }
    AppMethodBeat.o(239299);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239300);
    String str = "ILinkSessionKey{sessionKey='" + this.quX + '\'' + ", expireTicks=" + this.quY + ", initTicks=" + this.quZ + '}';
    AppMethodBeat.o(239300);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.q
 * JD-Core Version:    0.7.0.1
 */