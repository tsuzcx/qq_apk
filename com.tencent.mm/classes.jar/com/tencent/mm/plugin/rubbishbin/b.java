package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class b
  implements Thread.UncaughtExceptionHandler
{
  private int IAo = 0;
  private long IAp = 0L;
  private String cCg = "";
  private Context context = null;
  private String threadName = "";
  
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
    this.cCg = (paramThread.toString() + "\n");
    int j = this.cCg.length() / 512 + 1;
    long l = System.nanoTime();
    int i = 0;
    if (i < j)
    {
      if ((i + 1) * 512 < this.cCg.length()) {}
      for (paramThread = this.cCg.substring(i * 512, (i + 1) * 512);; paramThread = this.cCg.substring(i * 512))
      {
        h.IzE.a(17910, new Object[] { a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION, this.threadName, Integer.valueOf(0), paramThread, Integer.valueOf(1), Integer.valueOf(i + 1), Integer.valueOf(j), Long.valueOf(l) });
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