package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(64079);
    if ((paramThrowable instanceof SQLiteException))
    {
      AppMethodBeat.o(64079);
      return;
    }
    paramThread = new RuntimeException(paramThrowable);
    AppMethodBeat.o(64079);
    throw paramThread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.p
 * JD-Core Version:    0.7.0.1
 */