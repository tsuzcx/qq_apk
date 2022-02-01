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

public final class PeriodRecorder
{
  private static final String TAG = "MicroMsg.PeriodRecorder";
  private volatile boolean mIsPreloaded;
  private final Map<String, Long> mLastTimeCache;
  private long mPeriod;
  private byte[] mPreloadLock;
  private final String mScene;
  private SharedPreferences mStorage;
  private final String mStorageName;
  private final boolean mTriggerOnNewlyInit;
  private final boolean mUseCalenderTime;
  
  public PeriodRecorder(String paramString, long paramLong, boolean paramBoolean)
  {
    this(paramString, paramLong, paramBoolean, false);
  }
  
  public PeriodRecorder(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(263243);
    this.mPeriod = 0L;
    this.mPreloadLock = new byte[0];
    this.mIsPreloaded = false;
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("scene is null.");
      AppMethodBeat.o(263243);
      throw paramString;
    }
    this.mScene = paramString;
    this.mUseCalenderTime = paramBoolean1;
    StringBuilder localStringBuilder = new StringBuilder("prm_").append(this.mScene).append("_").append(paramLong);
    if (paramBoolean1) {}
    for (paramString = "_c";; paramString = "")
    {
      this.mStorageName = paramString;
      this.mLastTimeCache = new ConcurrentHashMap(20);
      this.mPeriod = paramLong;
      this.mTriggerOnNewlyInit = paramBoolean2;
      AppMethodBeat.o(263243);
      return;
    }
  }
  
  /* Error */
  private void ensureInitialized()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 95
    //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 97	com/tencent/mm/sdk/platformtools/PeriodRecorder:mStorage	Landroid/content/SharedPreferences;
    //   11: ifnull +11 -> 22
    //   14: ldc 95
    //   16: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 81	com/tencent/mm/sdk/platformtools/PeriodRecorder:mStorageName	Ljava/lang/String;
    //   27: invokestatic 103	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKVWithTransportByName	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   30: putfield 97	com/tencent/mm/sdk/platformtools/PeriodRecorder:mStorage	Landroid/content/SharedPreferences;
    //   33: ldc 95
    //   35: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: goto -19 -> 19
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: ldc 8
    //   49: aload_1
    //   50: ldc 105
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: invokestatic 117	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   63: aload_0
    //   64: getfield 81	com/tencent/mm/sdk/platformtools/PeriodRecorder:mStorageName	Ljava/lang/String;
    //   67: iconst_4
    //   68: invokevirtual 123	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   71: putfield 97	com/tencent/mm/sdk/platformtools/PeriodRecorder:mStorage	Landroid/content/SharedPreferences;
    //   74: ldc 95
    //   76: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -60 -> 19
    //   82: astore_1
    //   83: ldc 8
    //   85: aload_1
    //   86: ldc 125
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 97	com/tencent/mm/sdk/platformtools/PeriodRecorder:mStorage	Landroid/content/SharedPreferences;
    //   100: ldc 95
    //   102: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: goto -86 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	PeriodRecorder
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
  
  private long getNowTime()
  {
    AppMethodBeat.i(263248);
    if (this.mUseCalenderTime)
    {
      l = System.currentTimeMillis();
      AppMethodBeat.o(263248);
      return l;
    }
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(263248);
    return l;
  }
  
  private void preloadOnDemand()
  {
    int i = 0;
    AppMethodBeat.i(263251);
    for (;;)
    {
      synchronized (this.mPreloadLock)
      {
        if ((this.mIsPreloaded) || (this.mStorage == null))
        {
          AppMethodBeat.o(263251);
          return;
        }
        if ((this.mStorage instanceof MultiProcessMMKV))
        {
          String[] arrayOfString = ((MultiProcessMMKV)this.mStorage).allKeys();
          if (arrayOfString == null)
          {
            AppMethodBeat.o(263251);
            return;
          }
          int j = arrayOfString.length;
          if (i >= j) {
            break label265;
          }
          String str = arrayOfString[i];
          try
          {
            long l = this.mStorage.getLong(str, 0L);
            if (l == 0L) {
              break label279;
            }
            this.mLastTimeCache.put(str, Long.valueOf(l));
          }
          catch (Throwable localThrowable)
          {
            Log.printErrStackTrace("MicroMsg.PeriodRecorder", localThrowable, "exception occurred.", new Object[0]);
          }
        }
      }
      Object localObject2 = this.mStorage.getAll();
      if (localObject2 == null)
      {
        AppMethodBeat.o(263251);
        return;
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = localEntry.getValue();
        if ((localObject3 instanceof Long)) {
          this.mLastTimeCache.put(localEntry.getKey(), (Long)localObject3);
        }
      }
      label265:
      this.mIsPreloaded = true;
      AppMethodBeat.o(263251);
      return;
      label279:
      i += 1;
    }
  }
  
  public final boolean isExpired(String paramString)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(185217);
        ensureInitialized();
        if (this.mStorage == null)
        {
          Log.w("MicroMsg.PeriodRecorder", "PeriodRecorder is disabled.");
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
      preloadOnDemand();
      long l = getNowTime();
      if (!this.mLastTimeCache.containsKey(paramString))
      {
        this.mLastTimeCache.put(paramString, Long.valueOf(l));
        this.mStorage.edit().putLong(paramString, l).apply();
        bool = this.mTriggerOnNewlyInit;
        AppMethodBeat.o(185217);
      }
      else if (l - ((Long)this.mLastTimeCache.get(paramString)).longValue() > this.mPeriod)
      {
        this.mLastTimeCache.put(paramString, Long.valueOf(l));
        this.mStorage.edit().putLong(paramString, l).apply();
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PeriodRecorder
 * JD-Core Version:    0.7.0.1
 */