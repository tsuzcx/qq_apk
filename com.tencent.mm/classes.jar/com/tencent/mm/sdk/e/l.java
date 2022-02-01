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
  private static final ap IhH = new ap(Looper.getMainLooper());
  public int IhE = 0;
  private final Hashtable<T, Object> IhF = new Hashtable();
  private final HashSet<E> IhG = new HashSet();
  
  private Vector<T> fmm()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.IhF.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void fmn()
  {
    final Object localObject1 = fmm();
    if (((Vector)localObject1).size() <= 0)
    {
      this.IhG.clear();
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      final Object localObject5;
      a locala;
      Runnable local1;
      synchronized (this.IhG)
      {
        ArrayList localArrayList = new ArrayList(this.IhG);
        this.IhG.clear();
        hk(localArrayList);
        localHashMap = new HashMap();
        Iterator localIterator1 = ((Vector)localObject1).iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = localIterator1.next();
        Object localObject6 = this.IhF.get(localObject5);
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
        if (locala.IhL != null)
        {
          ??? = (ap)localHashMap.get(locala.IhL);
          localObject1 = ???;
          if (??? == null)
          {
            localObject1 = new ap(locala.IhL);
            localHashMap.put(locala.IhL, localObject1);
          }
          ((ap)localObject1).post(local1);
        }
      }
      Object localObject3;
      if (locala.cJU != null)
      {
        ??? = (ap)localHashMap.get(locala.cJU);
        localObject3 = ???;
        if (??? == null)
        {
          localObject3 = new ap(locala.cJU);
          localHashMap.put(locala.cJU, localObject3);
        }
        ((ap)localObject3).post(local1);
      }
      else
      {
        IhH.post(local1);
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
    //   3: getfield 46	com/tencent/mm/sdk/e/l:IhF	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 141	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/e/l:IhF	Ljava/util/Hashtable;
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
    //   38: getfield 46	com/tencent/mm/sdk/e/l:IhF	Ljava/util/Hashtable;
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
    //   3: getfield 46	com/tencent/mm/sdk/e/l:IhF	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 141	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/e/l:IhF	Ljava/util/Hashtable;
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
    //   38: getfield 46	com/tencent/mm/sdk/e/l:IhF	Ljava/util/Hashtable;
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
  
  public final boolean dV(E paramE)
  {
    synchronized (this.IhG)
    {
      boolean bool = this.IhG.add(paramE);
      return bool;
    }
  }
  
  public final void doNotify()
  {
    if (!isLocked()) {
      fmn();
    }
  }
  
  public void hk(List<E> paramList) {}
  
  public final boolean isLocked()
  {
    return this.IhE > 0;
  }
  
  public final void lock()
  {
    this.IhE += 1;
  }
  
  public final void remove(T paramT)
  {
    try
    {
      this.IhF.remove(paramT);
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
      this.IhF.clear();
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
    this.IhE -= 1;
    if (this.IhE <= 0)
    {
      this.IhE = 0;
      fmn();
    }
  }
  
  protected static final class a
  {
    a IhL;
    Looper cJU;
    
    public a() {}
    
    public a(Looper paramLooper)
    {
      this.cJU = paramLooper;
    }
    
    public a(a parama)
    {
      this.IhL = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.l
 * JD-Core Version:    0.7.0.1
 */