package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.j;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class b
  implements Thread.UncaughtExceptionHandler
{
  private Context context = null;
  private String stackTrace = "";
  private String threadName = "";
  private int yyr = 0;
  private long yys = 0L;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppMethodBeat.i(146673);
    this.threadName = paramThread.getName();
    paramThread = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(paramThread));
    this.stackTrace = (paramThread.toString() + "\n");
    int j = this.stackTrace.length() / 512 + 1;
    long l = System.nanoTime();
    int i = 0;
    if (i < j)
    {
      if ((i + 1) * 512 < this.stackTrace.length()) {}
      for (paramThread = this.stackTrace.substring(i * 512, (i + 1) * 512);; paramThread = this.stackTrace.substring(i * 512))
      {
        g.yxI.f(17910, new Object[] { a.hju, j.hju, this.threadName, Integer.valueOf(0), paramThread, Integer.valueOf(1), Integer.valueOf(i + 1), Integer.valueOf(j), Long.valueOf(l) });
        i += 1;
        break;
      }
    }
    this.context.stopService(new Intent(this.context, RubbishBinServiceImpl.class));
    try
    {
      for (;;)
      {
        Looper.loop();
      }
    }
    catch (Exception paramThread) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.b
 * JD-Core Version:    0.7.0.1
 */