package com.tencent.tav.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;
import java.util.Map;

public class TimePrinter
{
  private static Map<String, TimePrinter> constMap;
  private static Map<String, TimePrinter> printerMap;
  private String TAG;
  private CMTime currentSyncTime;
  private long currentTimeUs;
  
  static
  {
    AppMethodBeat.i(218729);
    printerMap = new HashMap();
    constMap = new HashMap();
    AppMethodBeat.o(218729);
  }
  
  public TimePrinter(String paramString)
  {
    AppMethodBeat.i(218725);
    this.TAG = "TimeDebug";
    this.TAG = (this.TAG + "-" + paramString);
    AppMethodBeat.o(218725);
  }
  
  public TimePrinter(String paramString, long paramLong)
  {
    AppMethodBeat.i(218726);
    this.TAG = "TimeDebug";
    this.TAG = (this.TAG + "-" + paramString);
    this.currentTimeUs = paramLong;
    AppMethodBeat.o(218726);
  }
  
  public static void print(String paramString, CMTime paramCMTime)
  {
    try
    {
      AppMethodBeat.i(218723);
      TimePrinter localTimePrinter2 = (TimePrinter)printerMap.get(paramString);
      TimePrinter localTimePrinter1 = localTimePrinter2;
      if (localTimePrinter2 == null)
      {
        localTimePrinter1 = new TimePrinter(paramString);
        printerMap.put(paramString, localTimePrinter1);
      }
      localTimePrinter1.print(paramCMTime);
      AppMethodBeat.o(218723);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void printCons(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 80
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 32	com/tencent/tav/report/TimePrinter:constMap	Ljava/util/Map;
    //   11: aload_0
    //   12: invokeinterface 69 2 0
    //   17: checkcast 2	com/tencent/tav/report/TimePrinter
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +37 -> 59
    //   25: getstatic 32	com/tencent/tav/report/TimePrinter:constMap	Ljava/util/Map;
    //   28: aload_0
    //   29: new 2	com/tencent/tav/report/TimePrinter
    //   32: dup
    //   33: aload_0
    //   34: invokestatic 86	java/lang/System:nanoTime	()J
    //   37: ldc2_w 87
    //   40: ldiv
    //   41: invokespecial 90	com/tencent/tav/report/TimePrinter:<init>	(Ljava/lang/String;J)V
    //   44: invokeinterface 75 3 0
    //   49: pop
    //   50: ldc 80
    //   52: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: ldc 2
    //   57: monitorexit
    //   58: return
    //   59: aload_1
    //   60: invokevirtual 92	com/tencent/tav/report/TimePrinter:printCons	()V
    //   63: getstatic 32	com/tencent/tav/report/TimePrinter:constMap	Ljava/util/Map;
    //   66: aload_0
    //   67: invokeinterface 95 2 0
    //   72: pop
    //   73: ldc 80
    //   75: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: goto -23 -> 55
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramString	String
    //   20	40	1	localTimePrinter	TimePrinter
    // Exception table:
    //   from	to	target	type
    //   3	21	81	finally
    //   25	55	81	finally
    //   59	78	81	finally
  }
  
  public void print(CMTime paramCMTime)
  {
    AppMethodBeat.i(218727);
    if (this.currentSyncTime == null)
    {
      this.currentSyncTime = paramCMTime;
      AppMethodBeat.o(218727);
      return;
    }
    new StringBuilder("print: timeSub = ").append(paramCMTime.sub(this.currentSyncTime).getTimeUs());
    this.currentSyncTime = paramCMTime;
    AppMethodBeat.o(218727);
  }
  
  public void printCons()
  {
    AppMethodBeat.i(218728);
    long l = System.nanoTime() / 1000L;
    new StringBuilder("printConst: const = ").append(l - this.currentTimeUs);
    AppMethodBeat.o(218728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tav.report.TimePrinter
 * JD-Core Version:    0.7.0.1
 */