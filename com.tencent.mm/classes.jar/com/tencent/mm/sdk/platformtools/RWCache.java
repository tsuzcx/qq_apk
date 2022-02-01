package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class RWCache<K, V>
{
  private static final int DEFAULT_MAX_HOLDER_THRESHOLD = 40;
  private static final long DEFAULT_MAX_SYNC_TIME = 60000L;
  private static final long DEFAULT_MAX_TIME_OUT = 60000L;
  private static final String TAG = "MicroMsg.RWCache";
  private final IRWCacheAppender<K, V> appender;
  private final LruCache<K, CacheItem<V>> cache;
  private final LinkedHashMap<K, Holder<K, V>> holderMap;
  private volatile boolean isTimeout;
  private final long maxSyncTime;
  protected Object tag;
  private final long threshold;
  private final MTimerHandler timeoutChecker;
  private final long timeoutMillis;
  private final MTimerHandler timer;
  private boolean trigger;
  
  public RWCache(IRWCacheAppender<K, V> paramIRWCacheAppender, Looper paramLooper, int paramInt)
  {
    this(paramIRWCacheAppender, paramLooper, paramInt, 40, 60000L, 60000L);
  }
  
  public RWCache(IRWCacheAppender<K, V> paramIRWCacheAppender, Looper paramLooper, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(230377);
    this.holderMap = new LinkedHashMap();
    this.trigger = true;
    this.isTimeout = false;
    if (paramIRWCacheAppender == null)
    {
      paramIRWCacheAppender = new IllegalArgumentException("arg appender can not be null!");
      AppMethodBeat.o(230377);
      throw paramIRWCacheAppender;
    }
    if (paramLooper == null)
    {
      paramIRWCacheAppender = new IllegalArgumentException("arg looper can not be null!");
      AppMethodBeat.o(230377);
      throw paramIRWCacheAppender;
    }
    if (paramInt1 <= 0)
    {
      paramIRWCacheAppender = new IllegalArgumentException("arg size can not be <= 0!");
      AppMethodBeat.o(230377);
      throw paramIRWCacheAppender;
    }
    this.appender = paramIRWCacheAppender;
    this.cache = new LruCache(paramInt1);
    long l;
    if (paramInt2 > 0)
    {
      l = paramInt2;
      this.threshold = l;
      if (paramLong1 <= 0L) {
        break label209;
      }
      label133:
      this.maxSyncTime = paramLong1;
      if (paramLong2 <= 0L) {
        break label217;
      }
    }
    for (;;)
    {
      this.timeoutMillis = paramLong2;
      this.timer = new MTimerHandler(paramLooper, new MTimerHandler.CallBack()
      {
        public boolean onTimerExpired()
        {
          AppMethodBeat.i(157800);
          long l = System.currentTimeMillis();
          RWCache.this.appendAll(false);
          Log.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - l) + " ms");
          AppMethodBeat.o(157800);
          return false;
        }
      }, false);
      this.timeoutChecker = new MTimerHandler("RWCache_timeoutChecker", new MTimerHandler.CallBack()
      {
        public boolean onTimerExpired()
        {
          AppMethodBeat.i(230376);
          RWCache.access$002(RWCache.this, true);
          AppMethodBeat.o(230376);
          return false;
        }
      }, false);
      AppMethodBeat.o(230377);
      return;
      l = 40L;
      break;
      label209:
      paramLong1 = 60000L;
      break label133;
      label217:
      paramLong2 = 60000L;
    }
  }
  
  /* Error */
  private void put(K paramK, Holder<K, V> paramHolder)
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 73	com/tencent/mm/sdk/platformtools/RWCache:holderMap	Ljava/util/LinkedHashMap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 134	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 75	com/tencent/mm/sdk/platformtools/RWCache:trigger	Z
    //   21: ifeq +40 -> 61
    //   24: aload_0
    //   25: getfield 73	com/tencent/mm/sdk/platformtools/RWCache:holderMap	Ljava/util/LinkedHashMap;
    //   28: invokevirtual 138	java/util/LinkedHashMap:size	()I
    //   31: i2l
    //   32: aload_0
    //   33: getfield 101	com/tencent/mm/sdk/platformtools/RWCache:threshold	J
    //   36: lcmp
    //   37: ifle +24 -> 61
    //   40: aload_0
    //   41: getfield 115	com/tencent/mm/sdk/platformtools/RWCache:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   44: lconst_0
    //   45: invokevirtual 142	com/tencent/mm/sdk/platformtools/MTimerHandler:startTimer	(J)V
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 75	com/tencent/mm/sdk/platformtools/RWCache:trigger	Z
    //   53: aload_0
    //   54: monitorexit
    //   55: ldc 131
    //   57: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: aload_0
    //   62: getfield 115	com/tencent/mm/sdk/platformtools/RWCache:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   65: invokevirtual 146	com/tencent/mm/sdk/platformtools/MTimerHandler:stopped	()Z
    //   68: ifeq -15 -> 53
    //   71: aload_0
    //   72: getfield 115	com/tencent/mm/sdk/platformtools/RWCache:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   75: aload_0
    //   76: getfield 103	com/tencent/mm/sdk/platformtools/RWCache:maxSyncTime	J
    //   79: invokevirtual 142	com/tencent/mm/sdk/platformtools/MTimerHandler:startTimer	(J)V
    //   82: goto -29 -> 53
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: ldc 131
    //   90: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	RWCache
    //   0	95	1	paramK	K
    //   0	95	2	paramHolder	Holder<K, V>
    // Exception table:
    //   from	to	target	type
    //   7	53	85	finally
    //   53	55	85	finally
    //   61	82	85	finally
    //   86	88	85	finally
  }
  
  public void appendAll(boolean paramBoolean)
  {
    AppMethodBeat.i(157805);
    Log.i("MicroMsg.RWCache", "summer appendAll force: " + paramBoolean + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.holderMap.size());
    try
    {
      this.trigger = true;
      if (this.holderMap.isEmpty()) {
        return;
      }
      if (!this.appender.preAppend()) {
        return;
      }
      Iterator localIterator = this.holderMap.entrySet().iterator();
      if (paramBoolean) {
        while (localIterator.hasNext())
        {
          this.appender.append(this, (Holder)((Map.Entry)localIterator.next()).getValue());
          localIterator.remove();
        }
      }
      this.isTimeout = false;
    }
    finally
    {
      AppMethodBeat.o(157805);
    }
    this.timeoutChecker.startTimer(this.timeoutMillis);
    while ((!this.isTimeout) && (localObject.hasNext()))
    {
      this.appender.append(this, (Holder)((Map.Entry)localObject.next()).getValue());
      localObject.remove();
    }
    if (this.isTimeout) {
      Log.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", new Object[] { Integer.valueOf(this.holderMap.size()), Boolean.valueOf(localObject.hasNext()) });
    }
    this.timeoutChecker.stopTimer();
    this.appender.postAppend();
    AppMethodBeat.o(157805);
  }
  
  public void clear()
  {
    AppMethodBeat.i(230379);
    try
    {
      this.cache.evictAll();
      this.holderMap.clear();
      this.timer.stopTimer();
      this.timeoutChecker.stopTimer();
      this.isTimeout = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(230379);
    }
  }
  
  public V get(K paramK)
  {
    AppMethodBeat.i(157803);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(157803);
      throw paramK;
    }
    CacheItem localCacheItem = (CacheItem)this.cache.get(paramK);
    if (localCacheItem != null)
    {
      paramK = localCacheItem.val;
      AppMethodBeat.o(157803);
      return paramK;
    }
    this.cache.put(paramK, new CacheItem(null));
    AppMethodBeat.o(157803);
    return null;
  }
  
  public Object getTag()
  {
    return this.tag;
  }
  
  public boolean remove(K paramK)
  {
    AppMethodBeat.i(230378);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(230378);
      throw paramK;
    }
    if (get(paramK) != null)
    {
      boolean bool = set(paramK, null);
      AppMethodBeat.o(230378);
      return bool;
    }
    AppMethodBeat.o(230378);
    return false;
  }
  
  public boolean set(K paramK, V paramV)
  {
    AppMethodBeat.i(157804);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(157804);
      throw paramK;
    }
    Object localObject = (CacheItem)this.cache.get(paramK);
    CacheItem localCacheItem = new CacheItem(paramV);
    if (localCacheItem.equals(localObject))
    {
      AppMethodBeat.o(157804);
      return false;
    }
    this.cache.put(paramK, localCacheItem);
    localObject = new Holder();
    ((Holder)localObject).key = paramK;
    ((Holder)localObject).values = paramV;
    if (paramV == null) {}
    for (int i = 2;; i = 1)
    {
      ((Holder)localObject).funcType = i;
      put(paramK, (Holder)localObject);
      AppMethodBeat.o(157804);
      return true;
    }
  }
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  static class CacheItem<V>
  {
    final V val;
    
    CacheItem(V paramV)
    {
      this.val = paramV;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(157801);
      if (paramObject == null)
      {
        AppMethodBeat.o(157801);
        return false;
      }
      if (!(paramObject instanceof CacheItem))
      {
        AppMethodBeat.o(157801);
        return false;
      }
      paramObject = (CacheItem)paramObject;
      if (this.val == null)
      {
        if (paramObject.val == null)
        {
          AppMethodBeat.o(157801);
          return true;
        }
        AppMethodBeat.o(157801);
        return false;
      }
      boolean bool = this.val.equals(paramObject.val);
      AppMethodBeat.o(157801);
      return bool;
    }
  }
  
  public static class Holder<K, V>
  {
    public static final int FUNC_DELETE = 2;
    public static final int FUNC_UPDATE = 1;
    public int funcType;
    public K key;
    public V values;
  }
  
  public static abstract interface IRWCacheAppender<K, V>
  {
    public abstract void append(RWCache<K, V> paramRWCache, RWCache.Holder<K, V> paramHolder);
    
    public abstract void postAppend();
    
    public abstract boolean preAppend();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.RWCache
 * JD-Core Version:    0.7.0.1
 */