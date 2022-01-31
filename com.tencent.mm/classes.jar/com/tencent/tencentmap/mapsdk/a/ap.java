package com.tencent.tencentmap.mapsdk.a;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ap
{
  private static ap e = new ap();
  private ao a = new ao();
  private ConcurrentHashMap<av, ao> b = new ConcurrentHashMap();
  private ConcurrentHashMap<av, ConcurrentLinkedQueue<mm>> c = new ConcurrentHashMap();
  private CopyOnWriteArrayList<Integer> d = new CopyOnWriteArrayList();
  
  private ap()
  {
    this.d.addAll(ao.a);
  }
  
  public static ap a()
  {
    return e;
  }
  
  public ao a(av paramav)
  {
    ao localao2 = (ao)this.b.get(paramav);
    ao localao1 = localao2;
    if (localao2 == null)
    {
      localao1 = new ao();
      this.b.putIfAbsent(paramav, localao1);
    }
    return localao1;
  }
  
  public void a(av paramav, String paramString1, String paramString2, ar paramar)
  {
    if (paramar.a(8))
    {
      paramar = paramar.m;
      if (paramar != null)
      {
        paramar.f = paramString1;
        paramar.b = paramString2;
        this.c.putIfAbsent(paramav, new ConcurrentLinkedQueue());
        if (((ConcurrentLinkedQueue)this.c.get(paramav)).size() <= 1000) {
          break label98;
        }
        bc.b("can not add sample for" + paramav.taf_proxyName() + ", queue size>1000");
      }
    }
    return;
    label98:
    ((ConcurrentLinkedQueue)this.c.get(paramav)).add(paramar);
  }
  
  public ao b(av paramav)
  {
    ao localao2 = (ao)this.b.get(paramav);
    ao localao1 = localao2;
    if (localao2 == null) {
      localao1 = a(paramav);
    }
    return localao1;
  }
  
  public void c(av paramav)
  {
    paramav = b(paramav).a().entrySet().iterator();
    while (paramav.hasNext()) {
      ((as)((Map.Entry)paramav.next()).getValue()).a(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ap
 * JD-Core Version:    0.7.0.1
 */