package com.tencent.mm.sdk.platformtools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class au
{
  private final String uln;
  private final boolean ypb;
  private final String ypc;
  private SharedPreferences ypd;
  private final Map<String, Long> ype;
  private long ypf;
  private byte[] ypg;
  private volatile boolean yph;
  
  public au(String paramString, long paramLong)
  {
    AppMethodBeat.i(93585);
    this.ypf = 0L;
    this.ypg = new byte[0];
    this.yph = false;
    this.uln = paramString;
    this.ypb = false;
    this.ypc = ("prm_" + this.uln + "_" + paramLong);
    this.ype = new ConcurrentHashMap(20);
    this.ypf = paramLong;
    AppMethodBeat.o(93585);
  }
  
  private void dtu()
  {
    int i = 0;
    AppMethodBeat.i(93586);
    for (;;)
    {
      synchronized (this.ypg)
      {
        if ((this.yph) || (this.ypd == null))
        {
          AppMethodBeat.o(93586);
          return;
        }
        if ((this.ypd instanceof as))
        {
          String[] arrayOfString = ((as)this.ypd).allKeys();
          if (arrayOfString == null)
          {
            AppMethodBeat.o(93586);
            return;
          }
          int j = arrayOfString.length;
          if (i >= j) {
            break label265;
          }
          String str = arrayOfString[i];
          try
          {
            long l = this.ypd.getLong(str, 0L);
            if (l == 0L) {
              break label279;
            }
            this.ype.put(str, Long.valueOf(l));
          }
          catch (Throwable localThrowable)
          {
            ab.printErrStackTrace("MicroMsg.PeriodRecorder", localThrowable, "exception occurred.", new Object[0]);
          }
        }
      }
      Object localObject2 = this.ypd.getAll();
      if (localObject2 == null)
      {
        AppMethodBeat.o(93586);
        return;
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = localEntry.getValue();
        if ((localObject3 instanceof Long)) {
          this.ype.put(localEntry.getKey(), (Long)localObject3);
        }
      }
      label265:
      this.yph = true;
      AppMethodBeat.o(93586);
      return;
      label279:
      i += 1;
    }
  }
  
  /* Error */
  private void ensureInitialized()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 79	com/tencent/mm/sdk/platformtools/au:ypd	Landroid/content/SharedPreferences;
    //   11: ifnull +11 -> 22
    //   14: ldc 147
    //   16: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 63	com/tencent/mm/sdk/platformtools/au:ypc	Ljava/lang/String;
    //   27: invokestatic 151	com/tencent/mm/sdk/platformtools/as:apr	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/as;
    //   30: putfield 79	com/tencent/mm/sdk/platformtools/au:ypd	Landroid/content/SharedPreferences;
    //   33: ldc 147
    //   35: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: goto -19 -> 19
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: ldc 105
    //   49: aload_1
    //   50: ldc 153
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 113	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: invokestatic 159	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   63: aload_0
    //   64: getfield 63	com/tencent/mm/sdk/platformtools/au:ypc	Ljava/lang/String;
    //   67: iconst_4
    //   68: invokevirtual 165	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   71: putfield 79	com/tencent/mm/sdk/platformtools/au:ypd	Landroid/content/SharedPreferences;
    //   74: ldc 147
    //   76: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -60 -> 19
    //   82: astore_1
    //   83: ldc 105
    //   85: aload_1
    //   86: ldc 167
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 113	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 79	com/tencent/mm/sdk/platformtools/au:ypd	Landroid/content/SharedPreferences;
    //   100: ldc 147
    //   102: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: goto -86 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	au
    //   41	4	1	localObject	Object
    //   46	4	1	localThrowable1	Throwable
    //   82	4	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	19	41	finally
    //   22	33	41	finally
    //   33	38	41	finally
    //   47	59	41	finally
    //   59	74	41	finally
    //   74	79	41	finally
    //   83	105	41	finally
    //   22	33	46	java/lang/Throwable
    //   59	74	82	java/lang/Throwable
  }
  
  public final boolean apw(String paramString)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(139733);
        ensureInitialized();
        if (this.ypd == null)
        {
          ab.w("MicroMsg.PeriodRecorder", "PeriodRecorder is disabled.");
          AppMethodBeat.o(139733);
          bool = false;
          return bool;
        }
        if (paramString == null)
        {
          paramString = new IllegalArgumentException("key is null.");
          AppMethodBeat.o(139733);
          throw paramString;
        }
      }
      finally {}
      dtu();
      if (this.ypb) {}
      for (long l = System.currentTimeMillis();; l = SystemClock.elapsedRealtime())
      {
        if (this.ype.containsKey(paramString)) {
          break label143;
        }
        this.ype.put(paramString, Long.valueOf(l));
        this.ypd.edit().putLong(paramString, l).apply();
        AppMethodBeat.o(139733);
        bool = false;
        break;
      }
      label143:
      if (l - ((Long)this.ype.get(paramString)).longValue() > this.ypf)
      {
        this.ype.put(paramString, Long.valueOf(l));
        this.ypd.edit().putLong(paramString, l).apply();
        bool = true;
        AppMethodBeat.o(139733);
      }
      else
      {
        AppMethodBeat.o(139733);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.au
 * JD-Core Version:    0.7.0.1
 */