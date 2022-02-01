package com.tencent.threadpool.g.a;

import com.tencent.threadpool.g.g;
import com.tencent.threadpool.g.g.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements b
{
  private static final HashMap<String, g.a> ahBT = new HashMap();
  
  public void a(g paramg)
  {
    paramg = paramg.ahBH.ahBJ;
    int i;
    do
    {
      i = paramg.get();
    } while (!paramg.compareAndSet(i, i - 1));
  }
  
  public void b(g paramg) {}
  
  public final g bFU(String paramString)
  {
    synchronized (ahBT)
    {
      g.a locala2 = (g.a)ahBT.get(paramString);
      g.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new g.a(paramString, new AtomicInteger());
        ahBT.put(paramString, locala1);
      }
      return new g(locala1);
    }
  }
  
  public final void d(g paramg)
  {
    paramg = paramg.ahBH.ahBJ;
    int i;
    do
    {
      i = paramg.get();
    } while (!paramg.compareAndSet(i, i + 1));
  }
  
  public final Map<String, Integer> jZq()
  {
    HashMap localHashMap2 = new HashMap();
    synchronized (ahBT)
    {
      Iterator localIterator = ahBT.values().iterator();
      while (localIterator.hasNext())
      {
        g.a locala = (g.a)localIterator.next();
        int i = locala.ahBJ.get();
        if (i > 0) {
          localHashMap2.put(locala.key, Integer.valueOf(i));
        }
      }
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.g.a.a
 * JD-Core Version:    0.7.0.1
 */