package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class k<T, E>
{
  public int ujS = 0;
  private final Hashtable<T, Object> ujT = new Hashtable();
  private final HashSet<E> ujU = new HashSet();
  
  private Vector<T> css()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.ujT.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void cst()
  {
    Object localObject1 = css();
    if (((Vector)localObject1).size() <= 0)
    {
      this.ujU.clear();
      return;
    }
    for (;;)
    {
      final Object localObject4;
      final Object localObject6;
      synchronized (this.ujU)
      {
        ArrayList localArrayList = new ArrayList(this.ujU);
        this.ujU.clear();
        dl(localArrayList);
        HashMap localHashMap = new HashMap();
        Iterator localIterator1 = ((Vector)localObject1).iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject4 = localIterator1.next();
        Object localObject5 = this.ujT.get(localObject4);
        Iterator localIterator2 = localArrayList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        localObject6 = localIterator2.next();
        if ((localObject6 == null) || (localObject5 == null)) {
          continue;
        }
        if ((localObject5 instanceof Looper))
        {
          Looper localLooper = (Looper)localObject5;
          ??? = (ah)localHashMap.get(localLooper);
          localObject1 = ???;
          if (??? == null)
          {
            localObject1 = new ah(localLooper);
            localHashMap.put(localLooper, localObject1);
          }
          ((ah)localObject1).post(new Runnable()
          {
            public final void run()
            {
              k.this.j(localObject4, localObject6);
            }
          });
        }
      }
      j(localObject4, localObject6);
    }
  }
  
  /* Error */
  public void a(T paramT, Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/tencent/mm/sdk/e/k:ujT	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 119	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +17 -> 27
    //   13: aload_2
    //   14: ifnull +16 -> 30
    //   17: aload_0
    //   18: getfield 26	com/tencent/mm/sdk/e/k:ujT	Ljava/util/Hashtable;
    //   21: aload_1
    //   22: aload_2
    //   23: invokevirtual 120	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: pop
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 26	com/tencent/mm/sdk/e/k:ujT	Ljava/util/Hashtable;
    //   34: aload_1
    //   35: new 5	java/lang/Object
    //   38: dup
    //   39: invokespecial 19	java/lang/Object:<init>	()V
    //   42: invokevirtual 120	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: pop
    //   46: goto -19 -> 27
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	k
    //   0	54	1	paramT	T
    //   0	54	2	paramLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   2	13	49	finally
    //   17	27	49	finally
    //   30	46	49	finally
  }
  
  public final boolean bV(E paramE)
  {
    synchronized (this.ujU)
    {
      boolean bool = this.ujU.add(paramE);
      return bool;
    }
  }
  
  public void dl(List<E> paramList) {}
  
  public final void doNotify()
  {
    if (!isLocked()) {
      cst();
    }
  }
  
  public final boolean isLocked()
  {
    return this.ujS > 0;
  }
  
  public abstract void j(T paramT, E paramE);
  
  public final void lock()
  {
    this.ujS += 1;
  }
  
  public final void remove(T paramT)
  {
    try
    {
      this.ujT.remove(paramT);
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
      this.ujT.clear();
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
    this.ujS -= 1;
    if (this.ujS <= 0)
    {
      this.ujS = 0;
      cst();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.k
 * JD-Core Version:    0.7.0.1
 */