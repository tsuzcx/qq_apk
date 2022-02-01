package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ListenerInstanceMonitor$ListenerLeakedException
  extends RuntimeException
{
  ListenerInstanceMonitor$ListenerLeakedException(String paramString, Throwable paramThrowable)
  {
    super(paramString + "\n See stacktrace to find where is the holder(listener) being added.");
    AppMethodBeat.i(125246);
    setStackTrace(paramThrowable.getStackTrace());
    AppMethodBeat.o(125246);
  }
  
  public final Throwable fillInStackTrace()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.ListenerLeakedException
 * JD-Core Version:    0.7.0.1
 */