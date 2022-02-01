package com.tencent.mm.wexnet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/SessionKeeper;", "Ljava/lang/AutoCloseable;", "sessionPtr", "", "(J)V", "getSessionPtr", "()J", "close", "", "finalize", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SessionKeeper
  implements AutoCloseable
{
  private final long sessionPtr;
  
  public SessionKeeper(long paramLong)
  {
    this.sessionPtr = paramLong;
  }
  
  public final void close()
  {
    AppMethodBeat.i(231576);
    try
    {
      WeXNet.a locala = WeXNet.Companion;
      long l = this.sessionPtr;
      WeXNet.a.jPH();
      WeXNet.a.releaseSession(l);
      AppMethodBeat.o(231576);
      return;
    }
    catch (WeXNet.a.a locala1)
    {
      AppMethodBeat.o(231576);
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(231585);
    close();
    AppMethodBeat.o(231585);
  }
  
  public final long getSessionPtr()
  {
    return this.sessionPtr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wexnet.SessionKeeper
 * JD-Core Version:    0.7.0.1
 */