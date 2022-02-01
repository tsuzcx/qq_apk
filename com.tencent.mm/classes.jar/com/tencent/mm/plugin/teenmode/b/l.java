package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/WeAppAuthorizationTimeout;", "Lcom/tencent/mm/plugin/teenmode/api/BaseAuthorizationTimeout;", "()V", "isAuthorizationExpired", "", "authorizationTime", "", "svrTime", "isRequestExpired", "requestTime", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements b
{
  public final boolean aD(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(278843);
    if (!Util.isSameDay(paramLong1, paramLong2))
    {
      AppMethodBeat.o(278843);
      return true;
    }
    AppMethodBeat.o(278843);
    return false;
  }
  
  public final boolean aE(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(278848);
    if (!Util.isSameDay(paramLong1, paramLong2))
    {
      AppMethodBeat.o(278848);
      return true;
    }
    AppMethodBeat.o(278848);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.l
 * JD-Core Version:    0.7.0.1
 */