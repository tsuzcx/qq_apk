package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class l<T, E>
{
  private static final aq IBS = new aq(Looper.getMainLooper());
  public int IBP = 0;
  private final Hashtable<T, Object> IBQ = new Hashtable();
  private final HashSet<E> IBR = new HashSet();
  
  private Vector<T> fqh()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.IBQ.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void fqi()
  {
    final Object localObject1 = fqh();
    if (((Vector)localObject1).size() <= 0)
    {
      this.IBR.clear();
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      final Object localObject5;
      a locala;
      Runnable local1;
      synchronized (this.IBR)
      {
        ArrayList localArrayList = new ArrayList(this.IBR);
        this.IBR.clear();
        hu(localArrayList);
        localHashMap = new HashMap();
        Iterator localIterator1 = ((Vector)localObject1).iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = localIterator1.next();
        Object localObject6 = this.IBQ.get(localObject5);
        Iterator localIterator2 = localArrayList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        localObject1 = localIterator2.next();
        if ((localObject1 == null) || (localObject6 == null)) {
          continue;
        }
        if (!(localObject6 instanceof a)) {
          break label310;
        }
        locala = (a)localObject6;
        local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(158085);
            l.this.B(localObject5, localObject1);
            AppMethodBeat.o(158085);
          }
        };
        if (locala.IBW != null)
        {
          ??? = (aq)localHashMap.get(locala.IBW);
          localObject1 = ???;
          if (??? == null)
          {
            localObject1 = new aq(locala.IBW);
            localHashMap.put(locala.IBW, localObject1);
          }
          ((aq)localObject1).post(local1);
        }
      }
      Object localObject3;
      if (locala.cKD != null)
      {
        ??? = (aq)localHashMap.get(locala.cKD);
        localObject3 = ???;
        if (??? == null)
        {
          localObject3 = new aq(locala.cKD);
          localHashMap.put(locala.cKD, localObject3);
        }
        ((aq)localObject3).post(local1);
      }
      else
      {
        IBS.post(local1);
        continue;
        label310:
        B(localObject5, localObject3);
      }
    }
  }
  
  protected abstract void B(T paramT, E paramE);
  
  /* Error */
  public void a(T paramT, Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/mm/sdk/e/l:IBQ	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 141	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/e/l:IBQ	Ljava/util/Hashtable;
    //   21: aload_1
    //   22: new 9	com/tencent/mm/sdk/e/l$a
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 142	com/tencent/mm/sdk/e/l$a:<init>	(Landroid/os/Looper;)V
    //   30: invokevirtual 143	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 46	com/tencent/mm/sdk/e/l:IBQ	Ljava/util/Hashtable;
    //   41: aload_1
    //   42: new 5	java/lang/Object
    //   45: dup
    //   46: invokespecial 39	java/lang/Object:<init>	()V
    //   49: invokevirtual 143	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: goto -19 -> 34
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	l
    //   0	61	1	paramT	T
    //   0	61	2	paramLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   2	13	56	finally
    //   17	34	56	finally
    //   37	53	56	finally
  }
  
  /* Error */
  public final void a(T paramT, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/mm/sdk/e/l:IBQ	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 141	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/e/l:IBQ	Ljava/util/Hashtable;
    //   21: aload_1
    //   22: new 9	com/tencent/mm/sdk/e/l$a
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 146	com/tencent/mm/sdk/e/l$a:<init>	(Lcom/tencent/e/j/a;)V
    //   30: invokevirtual 143	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 46	com/tencent/mm/sdk/e/l:IBQ	Ljava/util/Hashtable;
    //   41: aload_1
    //   42: new 5	java/lang/Object
    //   45: dup
    //   46: invokespecial 39	java/lang/Object:<init>	()V
    //   49: invokevirtual 143	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: goto -19 -> 34
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	l
    //   0	61	1	paramT	T
    //   0	61	2	parama	a
    // Exception table:
    //   from	to	target	type
    //   2	13	56	finally
    //   17	34	56	finally
    //   37	53	56	finally
  }
  
  public final boolean dW(E paramE)
  {
    synchronized (this.IBR)
    {
      boolean bool = this.IBR.add(paramE);
      return bool;
    }
  }
  
  public final void doNotify()
  {
    if (!isLocked()) {
      fqi();
    }
  }
  
  public void hu(List<E> paramList) {}
  
  public final boolean isLocked()
  {
    return this.IBP > 0;
  }
  
  public final void lock()
  {
    this.IBP += 1;
  }
  
  public final void remove(T paramT)
  {
    try
    {
      this.IBQ.remove(paramT);
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public final void removeAll()
  {
    try
    {
      this.IBQ.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void unlock()
  {
    this.IBP -= 1;
    if (this.IBP <= 0)
    {
      this.IBP = 0;
      fqi();
    }
  }
  
  protected static final class a
  {
    a IBW;
    Looper cKD;
    
    public a() {}
    
    public a(Looper paramLooper)
    {
      this.cKD = paramLooper;
    }
    
    public a(a parama)
    {
      this.IBW = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.l
 * JD-Core Version:    0.7.0.1
 */