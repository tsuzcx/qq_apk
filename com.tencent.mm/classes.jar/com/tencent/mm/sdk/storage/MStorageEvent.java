package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class MStorageEvent<T, E>
{
  private static final MMHandler sMainHandler = new MMHandler(Looper.getMainLooper());
  private final HashSet<E> events = new HashSet();
  private final Hashtable<T, Object> listeners = new Hashtable();
  private int locks = 0;
  
  private Vector<T> cloneAll()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.listeners.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void handleListeners()
  {
    final Object localObject1 = cloneAll();
    if ((localObject1 == null) || (((Vector)localObject1).size() <= 0))
    {
      this.events.clear();
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      final Object localObject5;
      EventHandler localEventHandler;
      Runnable local1;
      synchronized (this.events)
      {
        ArrayList localArrayList = new ArrayList(this.events);
        this.events.clear();
        handleNotify(localArrayList);
        localHashMap = new HashMap();
        Iterator localIterator1 = ((Vector)localObject1).iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = localIterator1.next();
        Object localObject6 = this.listeners.get(localObject5);
        Iterator localIterator2 = localArrayList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        localObject1 = localIterator2.next();
        if ((localObject1 == null) || (localObject6 == null)) {
          continue;
        }
        if (!(localObject6 instanceof EventHandler)) {
          break label314;
        }
        localEventHandler = (EventHandler)localObject6;
        local1 = new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(158085);
            MStorageEvent.this.processEvent(localObject5, localObject1);
            AppMethodBeat.o(158085);
          }
        };
        if (localEventHandler.serial != null)
        {
          ??? = (MMHandler)localHashMap.get(localEventHandler.serial);
          localObject1 = ???;
          if (??? == null)
          {
            localObject1 = new MMHandler(localEventHandler.serial);
            localHashMap.put(localEventHandler.serial, localObject1);
          }
          ((MMHandler)localObject1).post(local1);
        }
      }
      ??? = (MMHandler)localHashMap.get(localEventHandler.looper);
      Object localObject3 = ???;
      if (??? == null)
      {
        localObject3 = new MMHandler(localEventHandler.looper);
        localHashMap.put(localEventHandler.looper, localObject3);
      }
      ((MMHandler)localObject3).post(local1);
      continue;
      sMainHandler.post(local1);
      continue;
      label314:
      processEvent(localObject5, localObject3);
    }
  }
  
  /* Error */
  public void add(T paramT, Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/mm/sdk/storage/MStorageEvent:listeners	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 142	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/storage/MStorageEvent:listeners	Ljava/util/Hashtable;
    //   21: aload_1
    //   22: new 9	com/tencent/mm/sdk/storage/MStorageEvent$EventHandler
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 143	com/tencent/mm/sdk/storage/MStorageEvent$EventHandler:<init>	(Landroid/os/Looper;)V
    //   30: invokevirtual 144	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 46	com/tencent/mm/sdk/storage/MStorageEvent:listeners	Ljava/util/Hashtable;
    //   41: aload_1
    //   42: new 5	java/lang/Object
    //   45: dup
    //   46: invokespecial 39	java/lang/Object:<init>	()V
    //   49: invokevirtual 144	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: goto -19 -> 34
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	MStorageEvent
    //   0	61	1	paramT	T
    //   0	61	2	paramLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   2	13	56	finally
    //   17	34	56	finally
    //   37	53	56	finally
  }
  
  /* Error */
  public void add(T paramT, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/mm/sdk/storage/MStorageEvent:listeners	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 142	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +24 -> 34
    //   13: aload_2
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/sdk/storage/MStorageEvent:listeners	Ljava/util/Hashtable;
    //   21: aload_1
    //   22: new 9	com/tencent/mm/sdk/storage/MStorageEvent$EventHandler
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 147	com/tencent/mm/sdk/storage/MStorageEvent$EventHandler:<init>	(Lcom/tencent/e/j/a;)V
    //   30: invokevirtual 144	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 46	com/tencent/mm/sdk/storage/MStorageEvent:listeners	Ljava/util/Hashtable;
    //   41: aload_1
    //   42: new 5	java/lang/Object
    //   45: dup
    //   46: invokespecial 39	java/lang/Object:<init>	()V
    //   49: invokevirtual 144	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: goto -19 -> 34
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	MStorageEvent
    //   0	61	1	paramT	T
    //   0	61	2	parama	a
    // Exception table:
    //   from	to	target	type
    //   2	13	56	finally
    //   17	34	56	finally
    //   37	53	56	finally
  }
  
  public void doNotify()
  {
    if (!isLocked()) {
      handleListeners();
    }
  }
  
  public boolean event(E paramE)
  {
    synchronized (this.events)
    {
      boolean bool = this.events.add(paramE);
      return bool;
    }
  }
  
  public void handleNotify(List<E> paramList) {}
  
  public boolean isLocked()
  {
    return this.locks > 0;
  }
  
  public void lock()
  {
    this.locks += 1;
  }
  
  public int lockCount()
  {
    return this.locks;
  }
  
  protected abstract void processEvent(T paramT, E paramE);
  
  public void remove(T paramT)
  {
    try
    {
      this.listeners.remove(paramT);
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public void removeAll()
  {
    try
    {
      this.listeners.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void unlock()
  {
    this.locks -= 1;
    if (this.locks <= 0)
    {
      this.locks = 0;
      handleListeners();
    }
  }
  
  protected static class EventHandler
  {
    Looper looper;
    a serial;
    
    public EventHandler() {}
    
    public EventHandler(Looper paramLooper)
    {
      this.looper = paramLooper;
    }
    
    public EventHandler(a parama)
    {
      this.serial = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorageEvent
 * JD-Core Version:    0.7.0.1
 */