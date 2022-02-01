package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.m;

final class ReadMailProxy$1
  implements m
{
  ReadMailProxy$1(ReadMailProxy paramReadMailProxy) {}
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(122808);
    this.vVS.CLIENT_CALL("onTaskFailed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(122808);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(122807);
    this.vVS.CLIENT_CALL("onTaskFinished", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(122807);
  }
  
  public final void j(long paramLong, String paramString) {}
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(122809);
    this.vVS.CLIENT_CALL("onTaskPaused", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(122809);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(122806);
    this.vVS.CLIENT_CALL("onTaskRemoved", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(122806);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(122805);
    this.vVS.CLIENT_CALL("onTaskStarted", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(122805);
  }
  
  public final void qN(long paramLong) {}
  
  public final void qO(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.1
 * JD-Core Version:    0.7.0.1
 */