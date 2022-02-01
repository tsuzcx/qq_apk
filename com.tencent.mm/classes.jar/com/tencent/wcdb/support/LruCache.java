package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LruCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public LruCache(int paramInt)
  {
    AppMethodBeat.i(3411);
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("maxSize <= 0");
      AppMethodBeat.o(3411);
      throw localIllegalArgumentException;
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
    AppMethodBeat.o(3411);
  }
  
  private int safeSizeOf(K paramK, V paramV)
  {
    AppMethodBeat.i(3417);
    int i = sizeOf(paramK, paramV);
    if (i < 0)
    {
      paramK = new IllegalStateException("Negative size: " + paramK + "=" + paramV);
      AppMethodBeat.o(3417);
      throw paramK;
    }
    AppMethodBeat.o(3417);
    return i;
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
  
  public final void evictAll()
  {
    AppMethodBeat.i(3418);
    trimToSize(-1);
    AppMethodBeat.o(3418);
  }
  
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
    AppMethodBeat.i(3413);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(3413);
      throw paramK;
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
        AppMethodBeat.o(3413);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(3413);
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
        AppMethodBeat.o(3413);
        return localObject2;
        this.size += safeSizeOf(paramK, localObject1);
      }
      trimToSize(this.maxSize);
    }
    finally
    {
      AppMethodBeat.o(3413);
    }
    AppMethodBeat.o(3413);
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
    AppMethodBeat.i(3414);
    if ((paramK == null) || (paramV == null))
    {
      paramK = new NullPointerException("key == null || value == null");
      AppMethodBeat.o(3414);
      throw paramK;
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
      AppMethodBeat.o(3414);
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(3414);
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
    AppMethodBeat.i(3416);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(3416);
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
      AppMethodBeat.o(3416);
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(3416);
    }
  }
  
  public void resize(int paramInt)
  {
    AppMethodBeat.i(3412);
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("maxSize <= 0");
      AppMethodBeat.o(3412);
      throw localIllegalArgumentException;
    }
    try
    {
      this.maxSize = paramInt;
      trimToSize(paramInt);
      AppMethodBeat.o(3412);
      return;
    }
    finally
    {
      AppMethodBeat.o(3412);
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
      AppMethodBeat.i(3419);
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.map);
      AppMethodBeat.o(3419);
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
      AppMethodBeat.i(3420);
      int j = this.hitCount + this.missCount;
      if (j != 0) {
        i = this.hitCount * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i) });
      AppMethodBeat.o(3420);
      return str;
    }
    finally {}
  }
  
  public void trimToSize(int paramInt)
  {
    AppMethodBeat.i(3415);
    try
    {
      if ((this.size < 0) || ((this.map.isEmpty()) && (this.size != 0)))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
        AppMethodBeat.o(3415);
        throw localIllegalStateException;
      }
    }
    finally
    {
      AppMethodBeat.o(3415);
    }
    if ((this.size <= paramInt) || (this.map.isEmpty()))
    {
      AppMethodBeat.o(3415);
      return;
    }
    if (this.map.entrySet().iterator().hasNext()) {}
    for (Object localObject2 = (Map.Entry)this.map.entrySet().iterator().next();; localObject2 = null)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(3415);
        return;
      }
      Object localObject3 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      this.map.remove(localObject3);
      this.size -= safeSizeOf(localObject3, localObject2);
      this.evictionCount += 1;
      entryRemoved(true, localObject3, localObject2, null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wcdb.support.LruCache
 * JD-Core Version:    0.7.0.1
 */