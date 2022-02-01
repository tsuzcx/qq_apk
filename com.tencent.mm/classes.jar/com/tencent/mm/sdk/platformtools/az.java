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

public final class az
{
  private final String Dar;
  private final boolean IeP;
  private final boolean IeQ;
  private final String IeR;
  private SharedPreferences IeS;
  private final Map<String, Long> IeT;
  private long IeU;
  private byte[] IeV;
  private volatile boolean IeW;
  
  public az(String paramString, long paramLong)
  {
    AppMethodBeat.i(185215);
    this.IeU = 0L;
    this.IeV = new byte[0];
    this.IeW = false;
    this.Dar = paramString;
    this.IeP = true;
    this.IeR = ("prm_" + this.Dar + "_" + paramLong + "_c");
    this.IeT = new ConcurrentHashMap(20);
    this.IeU = paramLong;
    this.IeQ = true;
    AppMethodBeat.o(185215);
  }
  
  /* Error */
  private void ensureInitialized()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 82
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 84	com/tencent/mm/sdk/platformtools/az:IeS	Landroid/content/SharedPreferences;
    //   11: ifnull +11 -> 22
    //   14: ldc 82
    //   16: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 66	com/tencent/mm/sdk/platformtools/az:IeR	Ljava/lang/String;
    //   27: invokestatic 90	com/tencent/mm/sdk/platformtools/ax:aQB	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   30: putfield 84	com/tencent/mm/sdk/platformtools/az:IeS	Landroid/content/SharedPreferences;
    //   33: ldc 82
    //   35: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: goto -19 -> 19
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: ldc 92
    //   49: aload_1
    //   50: ldc 94
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 100	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: invokestatic 106	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   63: aload_0
    //   64: getfield 66	com/tencent/mm/sdk/platformtools/az:IeR	Ljava/lang/String;
    //   67: iconst_4
    //   68: invokevirtual 112	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   71: putfield 84	com/tencent/mm/sdk/platformtools/az:IeS	Landroid/content/SharedPreferences;
    //   74: ldc 82
    //   76: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -60 -> 19
    //   82: astore_1
    //   83: ldc 92
    //   85: aload_1
    //   86: ldc 114
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 100	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 84	com/tencent/mm/sdk/platformtools/az:IeS	Landroid/content/SharedPreferences;
    //   100: ldc 82
    //   102: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: goto -86 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	az
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
  
  private void flm()
  {
    int i = 0;
    AppMethodBeat.i(195176);
    for (;;)
    {
      synchronized (this.IeV)
      {
        if ((this.IeW) || (this.IeS == null))
        {
          AppMethodBeat.o(195176);
          return;
        }
        if ((this.IeS instanceof ax))
        {
          String[] arrayOfString = ((ax)this.IeS).allKeys();
          if (arrayOfString == null)
          {
            AppMethodBeat.o(195176);
            return;
          }
          int j = arrayOfString.length;
          if (i >= j) {
            break label265;
          }
          String str = arrayOfString[i];
          try
          {
            long l = this.IeS.getLong(str, 0L);
            if (l == 0L) {
              break label279;
            }
            this.IeT.put(str, Long.valueOf(l));
          }
          catch (Throwable localThrowable)
          {
            ad.printErrStackTrace("MicroMsg.PeriodRecorder", localThrowable, "exception occurred.", new Object[0]);
          }
        }
      }
      Object localObject2 = this.IeS.getAll();
      if (localObject2 == null)
      {
        AppMethodBeat.o(195176);
        return;
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = localEntry.getValue();
        if ((localObject3 instanceof Long)) {
          this.IeT.put(localEntry.getKey(), (Long)localObject3);
        }
      }
      label265:
      this.IeW = true;
      AppMethodBeat.o(195176);
      return;
      label279:
      i += 1;
    }
  }
  
  public final boolean aQG(String paramString)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(185217);
        ensureInitialized();
        if (this.IeS == null)
        {
          ad.w("MicroMsg.PeriodRecorder", "PeriodRecorder is disabled.");
          AppMethodBeat.o(185217);
          bool = false;
          return bool;
        }
        if (paramString == null)
        {
          paramString = new IllegalArgumentException("key is null.");
          AppMethodBeat.o(185217);
          throw paramString;
        }
      }
      finally {}
      flm();
      if (this.IeP) {}
      for (long l = System.currentTimeMillis();; l = SystemClock.elapsedRealtime())
      {
        if (this.IeT.containsKey(paramString)) {
          break label146;
        }
        this.IeT.put(paramString, Long.valueOf(l));
        this.IeS.edit().putLong(paramString, l).apply();
        bool = this.IeQ;
        AppMethodBeat.o(185217);
        break;
      }
      label146:
      if (l - ((Long)this.IeT.get(paramString)).longValue() > this.IeU)
      {
        this.IeT.put(paramString, Long.valueOf(l));
        this.IeS.edit().putLong(paramString, l).apply();
        bool = true;
        AppMethodBeat.o(185217);
      }
      else
      {
        AppMethodBeat.o(185217);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.az
 * JD-Core Version:    0.7.0.1
 */