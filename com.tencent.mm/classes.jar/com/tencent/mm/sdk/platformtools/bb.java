package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class bb<K, V>
{
  public final ap caS;
  public volatile boolean caV;
  public final ae<K, bb.a<V>> evq;
  private final long threshold;
  private final long timeoutMillis;
  public final LinkedHashMap<K, b<K, V>> ypJ;
  private final bb.c<K, V> ypK;
  public final ap ypL;
  private final long ypM;
  private boolean ypN;
  
  public bb(bb.c<K, V> paramc, Looper paramLooper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52242);
    this.ypJ = new LinkedHashMap();
    this.ypN = true;
    this.caV = false;
    if (paramLooper == null)
    {
      paramc = new IllegalArgumentException("arg looper can not be null!");
      AppMethodBeat.o(52242);
      throw paramc;
    }
    if (paramInt1 <= 0)
    {
      paramc = new IllegalArgumentException("arg size can not be <= 0!");
      AppMethodBeat.o(52242);
      throw paramc;
    }
    this.ypK = paramc;
    this.evq = new ae(paramInt1);
    if (paramInt2 > 0)
    {
      l1 = paramInt2;
      this.threshold = l1;
      if (300000L <= 0L) {
        break label222;
      }
    }
    label222:
    for (long l1 = 300000L;; l1 = 60000L)
    {
      this.ypM = l1;
      l1 = l2;
      if (1000L > 0L) {
        l1 = 1000L;
      }
      this.timeoutMillis = l1;
      this.caS = new ap(paramLooper, new bb.1(this), false);
      this.ypL = new ap(new al("RWCache_timeoutChecker").oNc.getLooper(), new bb.2(this), false);
      AppMethodBeat.o(52242);
      return;
      l1 = 40L;
      break;
    }
  }
  
  /* Error */
  private void a(K paramK, b<K, V> paramb)
  {
    // Byte code:
    //   0: ldc 124
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 50	com/tencent/mm/sdk/platformtools/bb:ypJ	Ljava/util/LinkedHashMap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 128	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 52	com/tencent/mm/sdk/platformtools/bb:ypN	Z
    //   21: ifeq +41 -> 62
    //   24: aload_0
    //   25: getfield 50	com/tencent/mm/sdk/platformtools/bb:ypJ	Ljava/util/LinkedHashMap;
    //   28: invokevirtual 132	java/util/LinkedHashMap:size	()I
    //   31: i2l
    //   32: aload_0
    //   33: getfield 76	com/tencent/mm/sdk/platformtools/bb:threshold	J
    //   36: lcmp
    //   37: ifle +25 -> 62
    //   40: aload_0
    //   41: getfield 96	com/tencent/mm/sdk/platformtools/bb:caS	Lcom/tencent/mm/sdk/platformtools/ap;
    //   44: lconst_0
    //   45: lconst_0
    //   46: invokevirtual 136	com/tencent/mm/sdk/platformtools/ap:ag	(JJ)V
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 52	com/tencent/mm/sdk/platformtools/bb:ypN	Z
    //   54: aload_0
    //   55: monitorexit
    //   56: ldc 124
    //   58: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 96	com/tencent/mm/sdk/platformtools/bb:caS	Lcom/tencent/mm/sdk/platformtools/ap;
    //   66: invokevirtual 140	com/tencent/mm/sdk/platformtools/ap:dtj	()Z
    //   69: ifeq -15 -> 54
    //   72: aload_0
    //   73: getfield 96	com/tencent/mm/sdk/platformtools/bb:caS	Lcom/tencent/mm/sdk/platformtools/ap;
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 80	com/tencent/mm/sdk/platformtools/bb:ypM	J
    //   81: lstore_3
    //   82: aload_1
    //   83: lload_3
    //   84: lload_3
    //   85: invokevirtual 136	com/tencent/mm/sdk/platformtools/ap:ag	(JJ)V
    //   88: goto -34 -> 54
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: ldc 124
    //   96: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	bb
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
  
  public final V get(K paramK)
  {
    AppMethodBeat.i(52243);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(52243);
      throw paramK;
    }
    bb.a locala = (bb.a)this.evq.get(paramK);
    if (locala != null)
    {
      paramK = locala.ypP;
      AppMethodBeat.o(52243);
      return paramK;
    }
    this.evq.put(paramK, new bb.a(null));
    AppMethodBeat.o(52243);
    return null;
  }
  
  public final void pM(boolean paramBoolean)
  {
    AppMethodBeat.i(52245);
    ab.i("MicroMsg.RWCache", "summer appendAll force: " + paramBoolean + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.ypJ.size());
    try
    {
      this.ypN = true;
      if (this.ypJ.isEmpty()) {
        return;
      }
      if (!this.ypK.akF()) {
        return;
      }
      Iterator localIterator = this.ypJ.entrySet().iterator();
      if (paramBoolean) {
        while (localIterator.hasNext())
        {
          this.ypK.a((b)((Map.Entry)localIterator.next()).getValue());
          localIterator.remove();
        }
      }
      this.caV = false;
    }
    finally
    {
      AppMethodBeat.o(52245);
    }
    ap localap = this.ypL;
    long l = this.timeoutMillis;
    localap.ag(l, l);
    while ((!this.caV) && (localObject.hasNext()))
    {
      this.ypK.a((b)((Map.Entry)localObject.next()).getValue());
      localObject.remove();
    }
    if (this.caV) {
      ab.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", new Object[] { Integer.valueOf(this.ypJ.size()), Boolean.valueOf(localObject.hasNext()) });
    }
    this.ypL.stopTimer();
    this.ypK.akG();
    AppMethodBeat.o(52245);
  }
  
  public final boolean x(K paramK, V paramV)
  {
    AppMethodBeat.i(52244);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(52244);
      throw paramK;
    }
    Object localObject = (bb.a)this.evq.get(paramK);
    bb.a locala = new bb.a(paramV);
    if (locala.equals(localObject))
    {
      AppMethodBeat.o(52244);
      return false;
    }
    this.evq.put(paramK, locala);
    localObject = new b();
    ((b)localObject).ypR = paramK;
    ((b)localObject).values = paramV;
    if (paramV == null) {}
    for (int i = 2;; i = 1)
    {
      ((b)localObject).ypQ = i;
      a(paramK, (b)localObject);
      AppMethodBeat.o(52244);
      return true;
    }
  }
  
  public static final class b<K, V>
  {
    public V values;
    public int ypQ;
    public K ypR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bb
 * JD-Core Version:    0.7.0.1
 */