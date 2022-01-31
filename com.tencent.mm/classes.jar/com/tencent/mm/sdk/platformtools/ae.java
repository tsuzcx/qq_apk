package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ae<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  public final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public ae(int paramInt)
  {
    AppMethodBeat.i(52033);
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("maxSize <= 0");
      AppMethodBeat.o(52033);
      throw localIllegalArgumentException;
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
    AppMethodBeat.o(52033);
  }
  
  private int safeSizeOf(K paramK, V paramV)
  {
    AppMethodBeat.i(52040);
    int i = sizeOf(paramK, paramV);
    if (i < 0)
    {
      paramK = new IllegalStateException("Negative size: " + paramK + "=" + paramV);
      AppMethodBeat.o(52040);
      throw paramK;
    }
    AppMethodBeat.o(52040);
    return i;
  }
  
  public final boolean Z(K paramK)
  {
    try
    {
      AppMethodBeat.i(52034);
      boolean bool = this.map.containsKey(paramK);
      AppMethodBeat.o(52034);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  /* Error */
  public final boolean aa(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 86
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 90	com/tencent/mm/sdk/platformtools/ae:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: ifnull +14 -> 26
    //   15: iconst_1
    //   16: istore_2
    //   17: ldc 86
    //   19: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_2
    //   28: ldc 86
    //   30: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: goto -11 -> 22
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	ae
    //   0	41	1	paramK	K
    //   16	12	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	36	finally
    //   17	22	36	finally
    //   28	33	36	finally
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  public final int createCount()
  {
    try
    {
      int i = this.createCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final int evictionCount()
  {
    try
    {
      int i = this.evictionCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V get(K paramK)
  {
    AppMethodBeat.i(52036);
    if (paramK == null)
    {
      ab.e("MicroMsg.LruMap", "key == null %s", new Object[] { bo.dtY().toString() });
      AppMethodBeat.o(52036);
      return null;
    }
    Object localObject1;
    try
    {
      localObject1 = this.map.get(paramK);
      if (localObject1 != null)
      {
        this.hitCount += 1;
        return localObject1;
      }
      this.missCount += 1;
      localObject1 = create(paramK);
      if (localObject1 == null)
      {
        AppMethodBeat.o(52036);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(52036);
    }
    try
    {
      this.createCount += 1;
      Object localObject2 = this.map.put(paramK, localObject1);
      if (localObject2 != null) {
        this.map.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject1, localObject2);
        AppMethodBeat.o(52036);
        return localObject2;
        this.size += safeSizeOf(paramK, localObject1);
      }
      trimToSize(this.maxSize);
    }
    finally
    {
      AppMethodBeat.o(52036);
    }
    AppMethodBeat.o(52036);
    return localObject1;
  }
  
  public final int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Set<K> keySet()
  {
    AppMethodBeat.i(156807);
    Set localSet = this.map.keySet();
    AppMethodBeat.o(156807);
    return localSet;
  }
  
  public final int maxSize()
  {
    try
    {
      int i = this.maxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int missCount()
  {
    try
    {
      int i = this.missCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(52037);
    if ((paramK == null) || (paramV == null)) {
      ab.e("MicroMsg.LruMap", "put key == null or value == null [%s, %s], %s", new Object[] { paramK, paramV, bo.dtY().toString() });
    }
    try
    {
      this.putCount += 1;
      this.size += safeSizeOf(paramK, paramV);
      Object localObject = this.map.put(paramK, paramV);
      if (localObject != null) {
        this.size -= safeSizeOf(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, paramV);
      }
      trimToSize(this.maxSize);
      AppMethodBeat.o(52037);
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(52037);
    }
  }
  
  public final int putCount()
  {
    try
    {
      int i = this.putCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V remove(K paramK)
  {
    AppMethodBeat.i(52039);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(52039);
      throw paramK;
    }
    try
    {
      Object localObject = this.map.remove(paramK);
      if (localObject != null) {
        this.size -= safeSizeOf(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, null);
      }
      AppMethodBeat.o(52039);
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(52039);
    }
  }
  
  public final int size()
  {
    try
    {
      int i = this.size;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public final Map<K, V> snapshot()
  {
    try
    {
      AppMethodBeat.i(52041);
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.map);
      AppMethodBeat.o(52041);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(52042);
      int j = this.hitCount + this.missCount;
      if (j != 0) {
        i = this.hitCount * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i) });
      AppMethodBeat.o(52042);
      return str;
    }
    finally {}
  }
  
  public void trimToSize(int paramInt)
  {
    AppMethodBeat.i(52038);
    for (;;)
    {
      try
      {
        if ((this.size < 0) || ((this.map.isEmpty()) && (this.size != 0)))
        {
          IllegalStateException localIllegalStateException = new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
          AppMethodBeat.o(52038);
          throw localIllegalStateException;
        }
      }
      finally
      {
        AppMethodBeat.o(52038);
      }
      if ((this.size <= paramInt) || (this.map.isEmpty()))
      {
        AppMethodBeat.o(52038);
        return;
      }
      Object localObject3 = (Map.Entry)this.map.entrySet().iterator().next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      this.map.remove(localObject2);
      this.size -= safeSizeOf(localObject2, localObject3);
      this.evictionCount += 1;
      entryRemoved(true, localObject2, localObject3, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ae
 * JD-Core Version:    0.7.0.1
 */