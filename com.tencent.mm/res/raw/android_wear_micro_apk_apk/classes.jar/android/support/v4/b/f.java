package android.support.v4.b;

import java.util.LinkedHashMap;
import java.util.Locale;

public class f<K, V>
{
  private final LinkedHashMap<K, V> lc;
  private int ld;
  private int le;
  private int lf;
  private int lg;
  private int lh;
  private int li;
  private int size;
  
  public f(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.ld = paramInt;
    this.lc = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int d(K paramK, V paramV)
  {
    int i = s(paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  /* Error */
  private void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	android/support/v4/b/f:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	android/support/v4/b/f:lc	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 75	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 71	android/support/v4/b/f:size	I
    //   23: ifeq +41 -> 64
    //   26: new 47	java/lang/IllegalStateException
    //   29: dup
    //   30: new 49	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 85	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 87
    //   49: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 66	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 71	android/support/v4/b/f:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	android/support/v4/b/f:lc	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 75	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 38	android/support/v4/b/f:lc	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 91	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 97 1 0
    //   97: invokeinterface 103 1 0
    //   102: checkcast 105	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 108 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 111 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 38	android/support/v4/b/f:lc	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 115	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 71	android/support/v4/b/f:size	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 117	android/support/v4/b/f:d	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 71	android/support/v4/b/f:size	I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 119	android/support/v4/b/f:lg	I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield 119	android/support/v4/b/f:lg	I
    //   154: aload_0
    //   155: monitorexit
    //   156: goto -156 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	f
    //   0	159	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   112	24	2	localObject2	Object
    //   105	32	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	156	59	finally
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.lc.get(paramK);
      if (localObject1 != null)
      {
        this.lh += 1;
        return localObject1;
      }
      this.li += 1;
      localObject1 = create(paramK);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      this.lf += 1;
      Object localObject2 = this.lc.put(paramK, localObject1);
      if (localObject2 != null) {
        this.lc.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 != null) {
          break;
        }
        trimToSize(this.ld);
        return localObject1;
        this.size += d(paramK, localObject1);
      }
      return localObject2;
    }
    finally {}
  }
  
  public final V put(K paramK, V paramV)
  {
    if (paramV == null) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.le += 1;
      this.size += d(paramK, paramV);
      paramV = this.lc.put(paramK, paramV);
      if (paramV != null) {
        this.size -= d(paramK, paramV);
      }
      trimToSize(this.ld);
      return paramV;
    }
    finally {}
  }
  
  protected int s(V paramV)
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
      String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.ld), Integer.valueOf(this.lh), Integer.valueOf(this.li), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.f
 * JD-Core Version:    0.7.0.1
 */