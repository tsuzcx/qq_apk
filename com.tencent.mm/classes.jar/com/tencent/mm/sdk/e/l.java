package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ak;
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
  private static final ak yrR = new ak(Looper.getMainLooper());
  public int yrO = 0;
  private final Hashtable<T, Object> yrP = new Hashtable();
  private final HashSet<E> yrQ = new HashSet();
  
  private Vector<T> duq()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.yrP.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dur()
  {
    final Object localObject1 = duq();
    if (((Vector)localObject1).size() <= 0)
    {
      this.yrQ.clear();
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      final Object localObject5;
      a locala;
      Runnable local1;
      synchronized (this.yrQ)
      {
        ArrayList localArrayList = new ArrayList(this.yrQ);
        this.yrQ.clear();
        et(localArrayList);
        localHashMap = new HashMap();
        Iterator localIterator1 = ((Vector)localObject1).iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = localIterator1.next();
        Object localObject6 = this.yrP.get(localObject5);
        Iterator localIterator2 = localArrayList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        localObject1 = localIterator2.next();
        if ((localObject1 == null) || (localObject6 == null)) {
          continue;
        }
        if (!(localObject6 instanceof a)) {
          break label271;
        }
        locala = (a)localObject6;
        local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52517);
            l.this.r(localObject5, localObject1);
            AppMethodBeat.o(52517);
          }
        };
        if (locala.yrW != null) {
          locala.yrW.b(local1, locala.yrV);
        }
      }
      Object localObject3;
      if (locala.ynU != null)
      {
        ??? = (ak)localHashMap.get(locala.ynU);
        localObject3 = ???;
        if (??? == null)
        {
          localObject3 = new ak(locala.ynU);
          localHashMap.put(locala.ynU, localObject3);
        }
        ((ak)localObject3).post(local1);
      }
      else
      {
        yrR.post(local1);
        continue;
        label271:
        r(localObject5, localObject3);
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
    //   3: getfield 46	com/tencent/mm/sdk/e/l:yrP	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 148	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/e/l:yrP	Ljava/util/Hashtable;
    //   21: aload_1
    //   22: new 9	com/tencent/mm/sdk/e/l$a
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 149	com/tencent/mm/sdk/e/l$a:<init>	(Landroid/os/Looper;)V
    //   30: invokevirtual 150	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 46	com/tencent/mm/sdk/e/l:yrP	Ljava/util/Hashtable;
    //   41: aload_1
    //   42: new 5	java/lang/Object
    //   45: dup
    //   46: invokespecial 39	java/lang/Object:<init>	()V
    //   49: invokevirtual 150	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
  public final void a(T paramT, e parame, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/mm/sdk/e/l:yrP	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 148	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +25 -> 35
    //   13: aload_2
    //   14: ifnull +24 -> 38
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/e/l:yrP	Ljava/util/Hashtable;
    //   21: aload_1
    //   22: new 9	com/tencent/mm/sdk/e/l$a
    //   25: dup
    //   26: aload_2
    //   27: aload_3
    //   28: invokespecial 155	com/tencent/mm/sdk/e/l$a:<init>	(Lcom/tencent/mm/sdk/g/a/e;Ljava/lang/String;)V
    //   31: invokevirtual 150	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: pop
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield 46	com/tencent/mm/sdk/e/l:yrP	Ljava/util/Hashtable;
    //   42: aload_1
    //   43: new 5	java/lang/Object
    //   46: dup
    //   47: invokespecial 39	java/lang/Object:<init>	()V
    //   50: invokevirtual 150	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: goto -19 -> 35
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	l
    //   0	62	1	paramT	T
    //   0	62	2	parame	e
    //   0	62	3	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	13	57	finally
    //   17	35	57	finally
    //   38	54	57	finally
  }
  
  public final boolean cy(E paramE)
  {
    synchronized (this.yrQ)
    {
      boolean bool = this.yrQ.add(paramE);
      return bool;
    }
  }
  
  public final void doNotify()
  {
    if (!isLocked()) {
      dur();
    }
  }
  
  public void et(List<E> paramList) {}
  
  public final boolean isLocked()
  {
    return this.yrO > 0;
  }
  
  public final void lock()
  {
    this.yrO += 1;
  }
  
  protected abstract void r(T paramT, E paramE);
  
  public final void remove(T paramT)
  {
    try
    {
      this.yrP.remove(paramT);
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
      this.yrP.clear();
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
    this.yrO -= 1;
    if (this.yrO <= 0)
    {
      this.yrO = 0;
      dur();
    }
  }
  
  protected static final class a
  {
    Looper ynU;
    String yrV;
    e yrW;
    
    public a() {}
    
    public a(Looper paramLooper)
    {
      this.ynU = paramLooper;
    }
    
    public a(e parame, String paramString)
    {
      this.yrV = paramString;
      this.yrW = parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.l
 * JD-Core Version:    0.7.0.1
 */