package com.tencent.mm.sdk.platformtools;

import java.util.LinkedHashMap;

public class h<K, V>
{
  private final LinkedHashMap<K, V> jf;
  private int jg;
  private int jh;
  private int ji;
  private int jj;
  private int jk;
  private int jl;
  private int size;
  
  public h(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.jg = paramInt;
    this.jf = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int c(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.jf.get(paramK);
      if (localObject1 != null)
      {
        this.jk += 1;
        return localObject1;
      }
      this.jl += 1;
      localObject1 = create(paramK);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      this.ji += 1;
      Object localObject2 = this.jf.put(paramK, localObject1);
      if (localObject2 != null) {
        this.jf.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject1, localObject2);
        return localObject2;
        this.size += c(paramK, localObject1);
      }
      trimToSize(this.jg);
    }
    finally {}
    return localObject1;
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.jh += 1;
      this.size += c(paramK, paramV);
      Object localObject = this.jf.put(paramK, paramV);
      if (localObject != null) {
        this.size -= c(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, paramV);
      }
      trimToSize(this.jg);
      return localObject;
    }
    finally {}
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.jk + this.jl;
      if (j != 0) {
        i = this.jk * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.jg), Integer.valueOf(this.jk), Integer.valueOf(this.jl), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
  
  /* Error */
  public void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	com/tencent/mm/sdk/platformtools/h:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	com/tencent/mm/sdk/platformtools/h:jf	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 125	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 97	com/tencent/mm/sdk/platformtools/h:size	I
    //   23: ifeq +41 -> 64
    //   26: new 46	java/lang/IllegalStateException
    //   29: dup
    //   30: new 48	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 130	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 135	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 137
    //   49: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 65	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 97	com/tencent/mm/sdk/platformtools/h:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	com/tencent/mm/sdk/platformtools/h:jf	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 125	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 38	com/tencent/mm/sdk/platformtools/h:jf	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 141	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 147 1 0
    //   97: invokeinterface 153 1 0
    //   102: checkcast 155	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 158 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 161 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 38	com/tencent/mm/sdk/platformtools/h:jf	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 164	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 97	com/tencent/mm/sdk/platformtools/h:size	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 99	com/tencent/mm/sdk/platformtools/h:c	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 97	com/tencent/mm/sdk/platformtools/h:size	I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 166	com/tencent/mm/sdk/platformtools/h:jj	I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield 166	com/tencent/mm/sdk/platformtools/h:jj	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual 95	com/tencent/mm/sdk/platformtools/h:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: goto -164 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	h
    //   0	167	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   112	47	2	localObject2	Object
    //   105	55	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	156	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.h
 * JD-Core Version:    0.7.0.1
 */