package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(219415);
    if ((paramThrowable instanceof SQLiteException))
    {
      AppMethodBeat.o(219415);
      return;
    }
    paramThread = new RuntimeException(paramThrowable);
    AppMethodBeat.o(219415);
    throw paramThread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.h
 * JD-Core Version:    0.7.0.1
 */