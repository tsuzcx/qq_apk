package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.m;

final class ReadMailProxy$1
  implements m
{
  ReadMailProxy$1(ReadMailProxy paramReadMailProxy) {}
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(68082);
    this.pKO.CLIENT_CALL("onTaskFailed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(68082);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68081);
    this.pKO.CLIENT_CALL("onTaskFinished", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(68081);
  }
  
  public final void hx(long paramLong) {}
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString) {}
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(68083);
    this.pKO.CLIENT_CALL("onTaskPaused", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(68083);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(68080);
    this.pKO.CLIENT_CALL("onTaskRemoved", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(68080);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(68079);
    this.pKO.CLIENT_CALL("onTaskStarted", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(68079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.1
 * JD-Core Version:    0.7.0.1
 */