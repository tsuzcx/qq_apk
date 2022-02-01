package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class bf<K, V>
{
  public final LinkedHashMap<K, b<K, V>> GtJ;
  private final c<K, V> GtK;
  public final au GtL;
  private final long GtM;
  private boolean GtN;
  public final au cLS;
  public volatile boolean cLV;
  public final af<K, a<V>> fPf;
  private final long threshold;
  private final long timeoutMillis;
  
  public bf(c<K, V> paramc, Looper paramLooper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157802);
    this.GtJ = new LinkedHashMap();
    this.GtN = true;
    this.cLV = false;
    if (paramLooper == null)
    {
      paramc = new IllegalArgumentException("arg looper can not be null!");
      AppMethodBeat.o(157802);
      throw paramc;
    }
    if (paramInt1 <= 0)
    {
      paramc = new IllegalArgumentException("arg size can not be <= 0!");
      AppMethodBeat.o(157802);
      throw paramc;
    }
    this.GtK = paramc;
    this.fPf = new af(paramInt1);
    if (paramInt2 > 0)
    {
      l1 = paramInt2;
      this.threshold = l1;
      if (300000L <= 0L) {
        break label209;
      }
    }
    label209:
    for (long l1 = 300000L;; l1 = 60000L)
    {
      this.GtM = l1;
      l1 = l2;
      if (1000L > 0L) {
        l1 = 1000L;
      }
      this.timeoutMillis = l1;
      this.cLS = new au(paramLooper, new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(157800);
          long l = System.currentTimeMillis();
          bf.this.vX(false);
          ac.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - l) + " ms");
          AppMethodBeat.o(157800);
          return false;
        }
      }, false);
      this.GtL = new au("RWCache_timeoutChecker", new au.a()
      {
        public final boolean onTimerExpired()
        {
          bf.this.cLV = true;
          return false;
        }
      }, false);
      AppMethodBeat.o(157802);
      return;
      l1 = 40L;
      break;
    }
  }
  
  /* Error */
  private void a(K paramK, b<K, V> paramb)
  {
    // Byte code:
    //   0: ldc 115
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 56	com/tencent/mm/sdk/platformtools/bf:GtJ	Ljava/util/LinkedHashMap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 119	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 58	com/tencent/mm/sdk/platformtools/bf:GtN	Z
    //   21: ifeq +41 -> 62
    //   24: aload_0
    //   25: getfield 56	com/tencent/mm/sdk/platformtools/bf:GtJ	Ljava/util/LinkedHashMap;
    //   28: invokevirtual 123	java/util/LinkedHashMap:size	()I
    //   31: i2l
    //   32: aload_0
    //   33: getfield 82	com/tencent/mm/sdk/platformtools/bf:threshold	J
    //   36: lcmp
    //   37: ifle +25 -> 62
    //   40: aload_0
    //   41: getfield 100	com/tencent/mm/sdk/platformtools/bf:cLS	Lcom/tencent/mm/sdk/platformtools/au;
    //   44: lconst_0
    //   45: lconst_0
    //   46: invokevirtual 127	com/tencent/mm/sdk/platformtools/au:au	(JJ)V
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 58	com/tencent/mm/sdk/platformtools/bf:GtN	Z
    //   54: aload_0
    //   55: monitorexit
    //   56: ldc 115
    //   58: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 100	com/tencent/mm/sdk/platformtools/bf:cLS	Lcom/tencent/mm/sdk/platformtools/au;
    //   66: invokevirtual 131	com/tencent/mm/sdk/platformtools/au:eVs	()Z
    //   69: ifeq -15 -> 54
    //   72: aload_0
    //   73: getfield 100	com/tencent/mm/sdk/platformtools/bf:cLS	Lcom/tencent/mm/sdk/platformtools/au;
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 86	com/tencent/mm/sdk/platformtools/bf:GtM	J
    //   81: lstore_3
    //   82: aload_1
    //   83: lload_3
    //   84: lload_3
    //   85: invokevirtual 127	com/tencent/mm/sdk/platformtools/au:au	(JJ)V
    //   88: goto -34 -> 54
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: ldc 115
    //   96: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	bf
    //   0	101	1	paramK	K
    //   0	101	2	paramb	b<K, V>
    //   81	4	3	l	long
    // Exception table:
    //   from	to	target	type
    //   7	54	91	finally
    //   54	56	91	finally
    //   62	88	91	finally
    //   92	94	91	finally
  }
  
  public final boolean G(K paramK, V paramV)
  {
    AppMethodBeat.i(157804);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(157804);
      throw paramK;
    }
    Object localObject = (a)this.fPf.get(paramK);
    a locala = new a(paramV);
    if (locala.equals(localObject))
    {
      AppMethodBeat.o(157804);
      return false;
    }
    this.fPf.put(paramK, locala);
    localObject = new b();
    ((b)localObject).aGF = paramK;
    ((b)localObject).values = paramV;
    if (paramV == null) {}
    for (int i = 2;; i = 1)
    {
      ((b)localObject).GtP = i;
      a(paramK, (b)localObject);
      AppMethodBeat.o(157804);
      return true;
    }
  }
  
  public final V get(K paramK)
  {
    AppMethodBeat.i(157803);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(157803);
      throw paramK;
    }
    a locala = (a)this.fPf.get(paramK);
    if (locala != null)
    {
      paramK = locala.bVw;
      AppMethodBeat.o(157803);
      return paramK;
    }
    this.fPf.put(paramK, new a(null));
    AppMethodBeat.o(157803);
    return null;
  }
  
  public final void vX(boolean paramBoolean)
  {
    AppMethodBeat.i(157805);
    ac.i("MicroMsg.RWCache", "summer appendAll force: " + paramBoolean + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.GtJ.size());
    try
    {
      this.GtN = true;
      if (this.GtJ.isEmpty()) {
        return;
      }
      if (!this.GtK.aIA()) {
        return;
      }
      Iterator localIterator = this.GtJ.entrySet().iterator();
      if (paramBoolean) {
        while (localIterator.hasNext())
        {
          this.GtK.a((b)((Map.Entry)localIterator.next()).getValue());
          localIterator.remove();
        }
      }
      this.cLV = false;
    }
    finally
    {
      AppMethodBeat.o(157805);
    }
    au localau = this.GtL;
    long l = this.timeoutMillis;
    localau.au(l, l);
    while ((!this.cLV) && (localObject.hasNext()))
    {
      this.GtK.a((b)((Map.Entry)localObject.next()).getValue());
      localObject.remove();
    }
    if (this.cLV) {
      ac.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", new Object[] { Integer.valueOf(this.GtJ.size()), Boolean.valueOf(localObject.hasNext()) });
    }
    this.GtL.stopTimer();
    this.GtK.aIB();
    AppMethodBeat.o(157805);
  }
  
  static final class a<V>
  {
    final V bVw;
    
    a(V paramV)
    {
      this.bVw = paramV;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(157801);
      if (paramObject == null)
      {
        AppMethodBeat.o(157801);
        return false;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(157801);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.bVw == null)
      {
        if (paramObject.bVw == null)
        {
          AppMethodBeat.o(157801);
          return true;
        }
        AppMethodBeat.o(157801);
        return false;
      }
      boolean bool = this.bVw.equals(paramObject.bVw);
      AppMethodBeat.o(157801);
      return bool;
    }
  }
  
  public static final class b<K, V>
  {
    public int GtP;
    public K aGF;
    public V values;
  }
  
  public static abstract interface c<K, V>
  {
    public abstract void a(bf.b<K, V> paramb);
    
    public abstract boolean aIA();
    
    public abstract void aIB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bf
 * JD-Core Version:    0.7.0.1
 */