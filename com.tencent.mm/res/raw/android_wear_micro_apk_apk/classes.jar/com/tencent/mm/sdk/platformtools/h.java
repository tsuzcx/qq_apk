package com.tencent.mm.sdk.platformtools;

import java.util.LinkedHashMap;

public class h<K, V>
{
  private final LinkedHashMap<K, V> lc;
  private int ld;
  private int le;
  private int lf;
  private int lg;
  private int lh;
  private int li;
  private int size;
  
  public h(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.ld = paramInt;
    this.lc = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int d(K paramK, V paramV)
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
  
  /* Error */
  public final V get(K paramK)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +25 -> 26
    //   4: ldc 76
    //   6: ldc 78
    //   8: iconst_1
    //   9: anewarray 5	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 84	com/tencent/mm/sdk/platformtools/q:lC	()Lcom/tencent/mm/sdk/platformtools/m;
    //   17: invokevirtual 87	com/tencent/mm/sdk/platformtools/m:toString	()Ljava/lang/String;
    //   20: aastore
    //   21: invokestatic 93	com/tencent/mm/sdk/platformtools/f:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 38	com/tencent/mm/sdk/platformtools/h:lc	Ljava/util/LinkedHashMap;
    //   32: aload_1
    //   33: invokevirtual 95	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +17 -> 55
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 97	com/tencent/mm/sdk/platformtools/h:lh	I
    //   46: iconst_1
    //   47: iadd
    //   48: putfield 97	com/tencent/mm/sdk/platformtools/h:lh	I
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: areturn
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 99	com/tencent/mm/sdk/platformtools/h:li	I
    //   60: iconst_1
    //   61: iadd
    //   62: putfield 99	com/tencent/mm/sdk/platformtools/h:li	I
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 101	com/tencent/mm/sdk/platformtools/h:create	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: astore_2
    //   73: aload_2
    //   74: ifnull -50 -> 24
    //   77: aload_0
    //   78: monitorenter
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 103	com/tencent/mm/sdk/platformtools/h:lf	I
    //   84: iconst_1
    //   85: iadd
    //   86: putfield 103	com/tencent/mm/sdk/platformtools/h:lf	I
    //   89: aload_0
    //   90: getfield 38	com/tencent/mm/sdk/platformtools/h:lc	Ljava/util/LinkedHashMap;
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual 107	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull +34 -> 134
    //   103: aload_0
    //   104: getfield 38	com/tencent/mm/sdk/platformtools/h:lc	Ljava/util/LinkedHashMap;
    //   107: aload_1
    //   108: aload_3
    //   109: invokevirtual 107	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_3
    //   116: ifnull +41 -> 157
    //   119: aload_0
    //   120: iconst_0
    //   121: aload_1
    //   122: aload_2
    //   123: aload_3
    //   124: invokevirtual 109	com/tencent/mm/sdk/platformtools/h:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   127: aload_3
    //   128: areturn
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 111	com/tencent/mm/sdk/platformtools/h:size	I
    //   139: aload_0
    //   140: aload_1
    //   141: aload_2
    //   142: invokespecial 113	com/tencent/mm/sdk/platformtools/h:d	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   145: iadd
    //   146: putfield 111	com/tencent/mm/sdk/platformtools/h:size	I
    //   149: goto -36 -> 113
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 30	com/tencent/mm/sdk/platformtools/h:ld	I
    //   162: invokevirtual 116	com/tencent/mm/sdk/platformtools/h:trimToSize	(I)V
    //   165: aload_2
    //   166: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	h
    //   0	167	1	paramK	K
    //   36	130	2	localObject1	Object
    //   98	30	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	129	finally
    //   41	53	129	finally
    //   55	67	129	finally
    //   130	132	129	finally
    //   79	99	152	finally
    //   103	113	152	finally
    //   113	115	152	finally
    //   134	149	152	finally
    //   153	155	152	finally
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      f.a("MicroMsg.LruMap", "put key == null or value == null [%s, %s], %s", new Object[] { paramK, paramV, q.lC().toString() });
    }
    try
    {
      this.le += 1;
      this.size += d(paramK, paramV);
      Object localObject = this.lc.put(paramK, paramV);
      if (localObject != null) {
        this.size -= d(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, paramV);
      }
      trimToSize(this.ld);
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
      int j = this.lh + this.li;
      if (j != 0) {
        i = this.lh * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.ld), Integer.valueOf(this.lh), Integer.valueOf(this.li), Integer.valueOf(i) });
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
    //   3: getfield 111	com/tencent/mm/sdk/platformtools/h:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	com/tencent/mm/sdk/platformtools/h:lc	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 139	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 111	com/tencent/mm/sdk/platformtools/h:size	I
    //   23: ifeq +41 -> 64
    //   26: new 46	java/lang/IllegalStateException
    //   29: dup
    //   30: new 48	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 144	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 149	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 151
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
    //   65: getfield 111	com/tencent/mm/sdk/platformtools/h:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	com/tencent/mm/sdk/platformtools/h:lc	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 139	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 38	com/tencent/mm/sdk/platformtools/h:lc	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 155	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 161 1 0
    //   97: invokeinterface 167 1 0
    //   102: checkcast 169	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 172 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 175 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 38	com/tencent/mm/sdk/platformtools/h:lc	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 178	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 111	com/tencent/mm/sdk/platformtools/h:size	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 113	com/tencent/mm/sdk/platformtools/h:d	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 111	com/tencent/mm/sdk/platformtools/h:size	I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 180	com/tencent/mm/sdk/platformtools/h:lg	I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield 180	com/tencent/mm/sdk/platformtools/h:lg	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual 109	com/tencent/mm/sdk/platformtools/h:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
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