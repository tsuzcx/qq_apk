package com.tencent.mm.wexnet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/SessionCreateResult;", "Lcom/tencent/mm/wexnet/Result;", "success", "", "codes", "", "desc", "", "", "sessionKeeper", "Lcom/tencent/mm/wexnet/SessionKeeper;", "(Z[J[Ljava/lang/String;Lcom/tencent/mm/wexnet/SessionKeeper;)V", "getSessionKeeper", "()Lcom/tencent/mm/wexnet/SessionKeeper;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SessionCreateResult
  extends Result
{
  private final SessionKeeper sessionKeeper;
  
  public SessionCreateResult(boolean paramBoolean, long[] paramArrayOfLong, String[] paramArrayOfString, SessionKeeper paramSessionKeeper)
  {
    super(paramBoolean, paramArrayOfLong, paramArrayOfString);
    AppMethodBeat.i(231530);
    this.sessionKeeper = paramSessionKeeper;
    AppMethodBeat.o(231530);
  }
  
  public final SessionKeeper getSessionKeeper()
  {
    return this.sessionKeeper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wexnet.SessionCreateResult
 * JD-Core Version:    0.7.0.1
 */