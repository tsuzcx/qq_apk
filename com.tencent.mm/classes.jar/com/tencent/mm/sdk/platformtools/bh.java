package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class bh<K, V>
{
  public final LinkedHashMap<K, b<K, V>> IzJ;
  private final c<K, V> IzK;
  public final aw IzL;
  private final long IzM;
  private boolean IzN;
  public final aw cYd;
  public volatile boolean cYg;
  public final ah<K, a<V>> gkX;
  private final long threshold;
  private final long timeoutMillis;
  
  public bh(c<K, V> paramc, Looper paramLooper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157802);
    this.IzJ = new LinkedHashMap();
    this.IzN = true;
    this.cYg = false;
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
    this.IzK = paramc;
    this.gkX = new ah(paramInt1);
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
      this.IzM = l1;
      l1 = l2;
      if (1000L > 0L) {
        l1 = 1000L;
      }
      this.timeoutMillis = l1;
      this.cYd = new aw(paramLooper, new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(157800);
          long l = System.currentTimeMillis();
          bh.this.wR(false);
          ae.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - l) + " ms");
          AppMethodBeat.o(157800);
          return false;
        }
      }, false);
      this.IzL = new aw("RWCache_timeoutChecker", new aw.a()
      {
        public final boolean onTimerExpired()
        {
          bh.this.cYg = true;
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
    //   8: getfield 56	com/tencent/mm/sdk/platformtools/bh:IzJ	Ljava/util/LinkedHashMap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 119	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 58	com/tencent/mm/sdk/platformtools/bh:IzN	Z
    //   21: ifeq +41 -> 62
    //   24: aload_0
    //   25: getfield 56	com/tencent/mm/sdk/platformtools/bh:IzJ	Ljava/util/LinkedHashMap;
    //   28: invokevirtual 123	java/util/LinkedHashMap:size	()I
    //   31: i2l
    //   32: aload_0
    //   33: getfield 82	com/tencent/mm/sdk/platformtools/bh:threshold	J
    //   36: lcmp
    //   37: ifle +25 -> 62
    //   40: aload_0
    //   41: getfield 100	com/tencent/mm/sdk/platformtools/bh:cYd	Lcom/tencent/mm/sdk/platformtools/aw;
    //   44: lconst_0
    //   45: lconst_0
    //   46: invokevirtual 127	com/tencent/mm/sdk/platformtools/aw:ay	(JJ)V
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 58	com/tencent/mm/sdk/platformtools/bh:IzN	Z
    //   54: aload_0
    //   55: monitorexit
    //   56: ldc 115
    //   58: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 100	com/tencent/mm/sdk/platformtools/bh:cYd	Lcom/tencent/mm/sdk/platformtools/aw;
    //   66: invokevirtual 131	com/tencent/mm/sdk/platformtools/aw:foU	()Z
    //   69: ifeq -15 -> 54
    //   72: aload_0
    //   73: getfield 100	com/tencent/mm/sdk/platformtools/bh:cYd	Lcom/tencent/mm/sdk/platformtools/aw;
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 86	com/tencent/mm/sdk/platformtools/bh:IzM	J
    //   81: lstore_3
    //   82: aload_1
    //   83: lload_3
    //   84: lload_3
    //   85: invokevirtual 127	com/tencent/mm/sdk/platformtools/aw:ay	(JJ)V
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
    //   0	101	0	this	bh
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
    Object localObject = (a)this.gkX.get(paramK);
    a locala = new a(paramV);
    if (locala.equals(localObject))
    {
      AppMethodBeat.o(157804);
      return false;
    }
    this.gkX.put(paramK, locala);
    localObject = new b();
    ((b)localObject).aIw = paramK;
    ((b)localObject).values = paramV;
    if (paramV == null) {}
    for (int i = 2;; i = 1)
    {
      ((b)localObject).IzP = i;
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
    a locala = (a)this.gkX.get(paramK);
    if (locala != null)
    {
      paramK = locala.cfK;
      AppMethodBeat.o(157803);
      return paramK;
    }
    this.gkX.put(paramK, new a(null));
    AppMethodBeat.o(157803);
    return null;
  }
  
  public final void wR(boolean paramBoolean)
  {
    AppMethodBeat.i(157805);
    ae.i("MicroMsg.RWCache", "summer appendAll force: " + paramBoolean + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.IzJ.size());
    try
    {
      this.IzN = true;
      if (this.IzJ.isEmpty()) {
        return;
      }
      if (!this.IzK.aMh()) {
        return;
      }
      Iterator localIterator = this.IzJ.entrySet().iterator();
      if (paramBoolean) {
        while (localIterator.hasNext())
        {
          this.IzK.a((b)((Map.Entry)localIterator.next()).getValue());
          localIterator.remove();
        }
      }
      this.cYg = false;
    }
    finally
    {
      AppMethodBeat.o(157805);
    }
    aw localaw = this.IzL;
    long l = this.timeoutMillis;
    localaw.ay(l, l);
    while ((!this.cYg) && (localObject.hasNext()))
    {
      this.IzK.a((b)((Map.Entry)localObject.next()).getValue());
      localObject.remove();
    }
    if (this.cYg) {
      ae.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", new Object[] { Integer.valueOf(this.IzJ.size()), Boolean.valueOf(localObject.hasNext()) });
    }
    this.IzL.stopTimer();
    this.IzK.aMi();
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
    public int IzP;
    public K aIw;
    public V values;
  }
  
  public static abstract interface c<K, V>
  {
    public abstract void a(bh.b<K, V> paramb);
    
    public abstract boolean aMh();
    
    public abstract void aMi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bh
 * JD-Core Version:    0.7.0.1
 */