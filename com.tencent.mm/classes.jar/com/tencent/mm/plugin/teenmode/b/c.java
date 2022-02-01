package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/DefaultAuthorizationTimeout;", "Lcom/tencent/mm/plugin/teenmode/api/BaseAuthorizationTimeout;", "()V", "isAuthorizationExpired", "", "authorizationTime", "", "svrTime", "isRequestExpired", "requestTime", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements b
{
  public static final c SYG;
  
  static
  {
    AppMethodBeat.i(278897);
    SYG = new c();
    AppMethodBeat.o(278897);
  }
  
  public final boolean aD(long paramLong1, long paramLong2)
  {
    return paramLong2 / 86400000L != paramLong1 / 86400000L;
  }
  
  public final boolean aE(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 > 3600000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.c
 * JD-Core Version:    0.7.0.1
 */