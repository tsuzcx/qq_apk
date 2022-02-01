package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class bg<K, V>
{
  public final av IfA;
  private final long IfB;
  private boolean IfC;
  public final LinkedHashMap<K, b<K, V>> Ify;
  private final c<K, V> Ifz;
  public final av cXg;
  public volatile boolean cXj;
  public final ag<K, a<V>> giF;
  private final long threshold;
  private final long timeoutMillis;
  
  public bg(c<K, V> paramc, Looper paramLooper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157802);
    this.Ify = new LinkedHashMap();
    this.IfC = true;
    this.cXj = false;
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
    this.Ifz = paramc;
    this.giF = new ag(paramInt1);
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
      this.IfB = l1;
      l1 = l2;
      if (1000L > 0L) {
        l1 = 1000L;
      }
      this.timeoutMillis = l1;
      this.cXg = new av(paramLooper, new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(157800);
          long l = System.currentTimeMillis();
          bg.this.wJ(false);
          ad.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - l) + " ms");
          AppMethodBeat.o(157800);
          return false;
        }
      }, false);
      this.IfA = new av("RWCache_timeoutChecker", new av.a()
      {
        public final boolean onTimerExpired()
        {
          bg.this.cXj = true;
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
    //   8: getfield 56	com/tencent/mm/sdk/platformtools/bg:Ify	Ljava/util/LinkedHashMap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 119	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 58	com/tencent/mm/sdk/platformtools/bg:IfC	Z
    //   21: ifeq +41 -> 62
    //   24: aload_0
    //   25: getfield 56	com/tencent/mm/sdk/platformtools/bg:Ify	Ljava/util/LinkedHashMap;
    //   28: invokevirtual 123	java/util/LinkedHashMap:size	()I
    //   31: i2l
    //   32: aload_0
    //   33: getfield 82	com/tencent/mm/sdk/platformtools/bg:threshold	J
    //   36: lcmp
    //   37: ifle +25 -> 62
    //   40: aload_0
    //   41: getfield 100	com/tencent/mm/sdk/platformtools/bg:cXg	Lcom/tencent/mm/sdk/platformtools/av;
    //   44: lconst_0
    //   45: lconst_0
    //   46: invokevirtual 127	com/tencent/mm/sdk/platformtools/av:az	(JJ)V
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 58	com/tencent/mm/sdk/platformtools/bg:IfC	Z
    //   54: aload_0
    //   55: monitorexit
    //   56: ldc 115
    //   58: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 100	com/tencent/mm/sdk/platformtools/bg:cXg	Lcom/tencent/mm/sdk/platformtools/av;
    //   66: invokevirtual 131	com/tencent/mm/sdk/platformtools/av:fkZ	()Z
    //   69: ifeq -15 -> 54
    //   72: aload_0
    //   73: getfield 100	com/tencent/mm/sdk/platformtools/bg:cXg	Lcom/tencent/mm/sdk/platformtools/av;
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 86	com/tencent/mm/sdk/platformtools/bg:IfB	J
    //   81: lstore_3
    //   82: aload_1
    //   83: lload_3
    //   84: lload_3
    //   85: invokevirtual 127	com/tencent/mm/sdk/platformtools/av:az	(JJ)V
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
    //   0	101	0	this	bg
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
  
  public final boolean I(K paramK, V paramV)
  {
    AppMethodBeat.i(157804);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(157804);
      throw paramK;
    }
    Object localObject = (a)this.giF.get(paramK);
    a locala = new a(paramV);
    if (locala.equals(localObject))
    {
      AppMethodBeat.o(157804);
      return false;
    }
    this.giF.put(paramK, locala);
    localObject = new b();
    ((b)localObject).aIw = paramK;
    ((b)localObject).values = paramV;
    if (paramV == null) {}
    for (int i = 2;; i = 1)
    {
      ((b)localObject).IfE = i;
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
    a locala = (a)this.giF.get(paramK);
    if (locala != null)
    {
      paramK = locala.cfK;
      AppMethodBeat.o(157803);
      return paramK;
    }
    this.giF.put(paramK, new a(null));
    AppMethodBeat.o(157803);
    return null;
  }
  
  public final void wJ(boolean paramBoolean)
  {
    AppMethodBeat.i(157805);
    ad.i("MicroMsg.RWCache", "summer appendAll force: " + paramBoolean + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.Ify.size());
    try
    {
      this.IfC = true;
      if (this.Ify.isEmpty()) {
        return;
      }
      if (!this.Ifz.aLK()) {
        return;
      }
      Iterator localIterator = this.Ify.entrySet().iterator();
      if (paramBoolean) {
        while (localIterator.hasNext())
        {
          this.Ifz.a((b)((Map.Entry)localIterator.next()).getValue());
          localIterator.remove();
        }
      }
      this.cXj = false;
    }
    finally
    {
      AppMethodBeat.o(157805);
    }
    av localav = this.IfA;
    long l = this.timeoutMillis;
    localav.az(l, l);
    while ((!this.cXj) && (localObject.hasNext()))
    {
      this.Ifz.a((b)((Map.Entry)localObject.next()).getValue());
      localObject.remove();
    }
    if (this.cXj) {
      ad.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", new Object[] { Integer.valueOf(this.Ify.size()), Boolean.valueOf(localObject.hasNext()) });
    }
    this.IfA.stopTimer();
    this.Ifz.aLL();
    AppMethodBeat.o(157805);
  }
  
  static final class a<V>
  {
    final V cfK;
    
    a(V paramV)
    {
      this.cfK = paramV;
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
      if (this.cfK == null)
      {
        if (paramObject.cfK == null)
        {
          AppMethodBeat.o(157801);
          return true;
        }
        AppMethodBeat.o(157801);
        return false;
      }
      boolean bool = this.cfK.equals(paramObject.cfK);
      AppMethodBeat.o(157801);
      return bool;
    }
  }
  
  public static final class b<K, V>
  {
    public int IfE;
    public K aIw;
    public V values;
  }
  
  public static abstract interface c<K, V>
  {
    public abstract void a(bg.b<K, V> paramb);
    
    public abstract boolean aLK();
    
    public abstract void aLL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bg
 * JD-Core Version:    0.7.0.1
 */