package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
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
  private static final ap EYA = new ap(Looper.getMainLooper());
  public int EYx = 0;
  private final Hashtable<T, Object> EYy = new Hashtable();
  private final HashSet<E> EYz = new HashSet();
  
  private Vector<T> eHh()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.EYy.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void eHi()
  {
    final Object localObject1 = eHh();
    if (((Vector)localObject1).size() <= 0)
    {
      this.EYz.clear();
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      final Object localObject5;
      a locala;
      Runnable local1;
      synchronized (this.EYz)
      {
        ArrayList localArrayList = new ArrayList(this.EYz);
        this.EYz.clear();
        gM(localArrayList);
        localHashMap = new HashMap();
        Iterator localIterator1 = ((Vector)localObject1).iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = localIterator1.next();
        Object localObject6 = this.EYy.get(localObject5);
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
            l.this.z(localObject5, localObject1);
            AppMethodBeat.o(158085);
          }
        };
        if (locala.EYE != null)
        {
          ??? = (ap)localHashMap.get(locala.EYE);
          localObject1 = ???;
          if (??? == null)
          {
            localObject1 = new ap(locala.EYE);
            localHashMap.put(locala.EYE, localObject1);
          }
          ((ap)localObject1).post(local1);
        }
      }
      Object localObject3;
      if (locala.cBP != null)
      {
        ??? = (ap)localHashMap.get(locala.cBP);
        localObject3 = ???;
        if (??? == null)
        {
          localObject3 = new ap(locala.cBP);
          localHashMap.put(locala.cBP, localObject3);
        }
        ((ap)localObject3).post(local1);
      }
      else
      {
        EYA.post(local1);
        continue;
        label310:
        z(localObject5, localObject3);
      }
    }
  }
  
  /* Error */
  public void a(T paramT, Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/mm/sdk/e/l:EYy	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 141	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/e/l:EYy	Ljava/util/Hashtable;
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
    //   38: getfield 46	com/tencent/mm/sdk/e/l:EYy	Ljava/util/Hashtable;
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
    //   3: getfield 46	com/tencent/mm/sdk/e/l:EYy	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 141	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/e/l:EYy	Ljava/util/Hashtable;
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
    //   38: getfield 46	com/tencent/mm/sdk/e/l:EYy	Ljava/util/Hashtable;
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
  
  public final boolean dR(E paramE)
  {
    synchronized (this.EYz)
    {
      boolean bool = this.EYz.add(paramE);
      return bool;
    }
  }
  
  public final void doNotify()
  {
    if (!isLocked()) {
      eHi();
    }
  }
  
  public void gM(List<E> paramList) {}
  
  public final boolean isLocked()
  {
    return this.EYx > 0;
  }
  
  public final void lock()
  {
    this.EYx += 1;
  }
  
  public final void remove(T paramT)
  {
    try
    {
      this.EYy.remove(paramT);
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
      this.EYy.clear();
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
    this.EYx -= 1;
    if (this.EYx <= 0)
    {
      this.EYx = 0;
      eHi();
    }
  }
  
  protected abstract void z(T paramT, E paramE);
  
  protected static final class a
  {
    a EYE;
    Looper cBP;
    
    public a() {}
    
    public a(Looper paramLooper)
    {
      this.cBP = paramLooper;
    }
    
    public a(a parama)
    {
      this.EYE = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.l
 * JD-Core Version:    0.7.0.1
 */