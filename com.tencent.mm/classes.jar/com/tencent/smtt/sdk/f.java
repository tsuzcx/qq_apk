package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(54056);
    if ((paramThrowable instanceof SQLiteException))
    {
      AppMethodBeat.o(54056);
      return;
    }
    paramThread = new RuntimeException(paramThrowable);
    AppMethodBeat.o(54056);
    throw paramThread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.f
 * JD-Core Version:    0.7.0.1
 */