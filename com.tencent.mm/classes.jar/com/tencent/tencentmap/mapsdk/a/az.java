package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class az
  implements nr
{
  Map<Integer, List<bg>> a = new HashMap();
  Map<Integer, List<bg>> b = new HashMap();
  List<bg> c = new ArrayList();
  List<bg> d = new ArrayList();
  List<bg> e = new ArrayList();
  List<bg> f = new ArrayList();
  ReentrantReadWriteLock g = new ReentrantReadWriteLock();
  ReentrantReadWriteLock.ReadLock h = this.g.readLock();
  ReentrantReadWriteLock.WriteLock i = this.g.writeLock();
  String j;
  private HashSet<String> k = new HashSet();
  
  public az(String paramString)
  {
    this.j = paramString;
  }
  
  private ArrayList<bg> a(ArrayList<fq> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int m = 0;
    while (m < paramArrayList.size())
    {
      bg localbg = new bg(this.j, (fq)paramArrayList.get(m));
      localbg.b(paramBoolean);
      localArrayList.add(localbg);
      m += 1;
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public bg a(int paramInt1, int paramInt2)
  {
    try
    {
      this.h.lock();
      Object localObject1 = (List)this.b.get(Integer.valueOf(paramInt1));
      if (localObject1 != null)
      {
        paramInt1 = ((List)localObject1).size();
        if (paramInt1 != 0) {}
      }
      else
      {
        return null;
      }
      localObject1 = (bg)((List)localObject1).get(Math.abs(paramInt2) % ((List)localObject1).size());
      return localObject1;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  public List<bg> a()
  {
    try
    {
      this.h.lock();
      List localList = this.d;
      return localList;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  public void a(bk parambk)
  {
    try
    {
      this.i.lock();
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        bg localbg = (bg)localIterator.next();
        if (localbg.equals(parambk.d()))
        {
          localbg.a(true);
          this.d.remove(localbg);
          this.k.remove(localbg.a());
          if (!this.e.contains(localbg)) {
            this.e.add(localbg);
          }
          if (this.b.get(Integer.valueOf(localbg.e())) != null) {
            ((List)this.b.get(Integer.valueOf(localbg.e()))).remove(localbg);
          }
        }
      }
    }
    finally
    {
      this.i.unlock();
    }
    bc.c(this.j + " " + parambk.d() + " setServiceFail activeServices:" + this.d + " inactiveServices:" + this.e);
  }
  
  public void a(ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2)
  {
    b(a(paramArrayList1, true), a(paramArrayList2, false));
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/tencent/tencentmap/mapsdk/a/az:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   4: invokevirtual 115	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   7: aload_0
    //   8: getfield 37	com/tencent/tencentmap/mapsdk/a/az:a	Ljava/util/Map;
    //   11: iload_1
    //   12: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: invokeinterface 126 2 0
    //   20: checkcast 128	java/util/List
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +25 -> 50
    //   28: aload_3
    //   29: invokeinterface 216 1 0
    //   34: istore_2
    //   35: iload_2
    //   36: ifne +14 -> 50
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 66	com/tencent/tencentmap/mapsdk/a/az:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   45: invokevirtual 132	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   48: iload_2
    //   49: ireturn
    //   50: iconst_0
    //   51: istore_2
    //   52: goto -11 -> 41
    //   55: astore_3
    //   56: aload_0
    //   57: getfield 66	com/tencent/tencentmap/mapsdk/a/az:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   60: invokevirtual 132	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   63: aload_3
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	az
    //   0	65	1	paramInt	int
    //   34	18	2	bool	boolean
    //   23	6	3	localList	List
    //   55	9	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	24	55	finally
    //   28	35	55	finally
  }
  
  public List<bg> b()
  {
    try
    {
      this.h.lock();
      List localList = this.e;
      return localList;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  public void b(bk parambk)
  {
    try
    {
      this.i.lock();
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        bg localbg = (bg)localIterator.next();
        if (localbg.equals(parambk.d()))
        {
          localbg.a(false);
          if (!this.d.contains(localbg))
          {
            this.d.add(localbg);
            this.k.add(localbg.a());
          }
          if (this.b.get(Integer.valueOf(localbg.e())) == null) {
            this.b.put(Integer.valueOf(localbg.e()), new ArrayList());
          }
          if (!((List)this.b.get(Integer.valueOf(localbg.e()))).contains(localbg)) {
            ((List)this.b.get(Integer.valueOf(localbg.e()))).add(localbg);
          }
          this.e.remove(localbg);
        }
      }
    }
    finally
    {
      this.i.unlock();
    }
    bc.c(this.j + " " + parambk.d() + " setServiceActive activeServices:" + this.d + " inactiveServices:" + this.e);
  }
  
  void b(ArrayList<bg> paramArrayList1, ArrayList<bg> paramArrayList2)
  {
    Object localObject = new HashMap();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      bg localbg = (bg)paramArrayList1.next();
      if (!((Map)localObject).containsKey(Integer.valueOf(localbg.e()))) {
        ((Map)localObject).put(Integer.valueOf(localbg.e()), new ArrayList());
      }
      if (!localHashMap.containsKey(Integer.valueOf(localbg.e()))) {
        localHashMap.put(Integer.valueOf(localbg.e()), new ArrayList());
      }
      ((List)((Map)localObject).get(Integer.valueOf(localbg.e()))).add(localbg);
      ((List)localHashMap.get(Integer.valueOf(localbg.e()))).add(localbg);
      localArrayList1.add(localbg);
      localHashSet.add(localbg.a());
      localArrayList3.add(localbg);
      localArrayList4.add(localbg);
    }
    paramArrayList1 = paramArrayList2.iterator();
    while (paramArrayList1.hasNext())
    {
      paramArrayList2 = (bg)paramArrayList1.next();
      if (!((Map)localObject).containsKey(Integer.valueOf(paramArrayList2.e()))) {
        ((Map)localObject).put(Integer.valueOf(paramArrayList2.e()), new ArrayList());
      }
      ((List)((Map)localObject).get(Integer.valueOf(paramArrayList2.e()))).add(paramArrayList2);
      localArrayList2.add(paramArrayList2);
      localArrayList3.add(paramArrayList2);
    }
    try
    {
      this.i.lock();
      this.c = localArrayList4;
      this.a = ((Map)localObject);
      this.b = localHashMap;
      this.d = localArrayList1;
      this.k = localHashSet;
      this.e = localArrayList2;
      this.f = localArrayList3;
      this.i.unlock();
      paramArrayList1 = new StringBuffer();
      paramArrayList1.append(this.j + " setServices gridServices:" + this.a + " gridActiveServices:" + this.b);
      paramArrayList1.append(" allServices: ");
      paramArrayList2 = this.f.iterator();
      if (paramArrayList2.hasNext())
      {
        localObject = (bg)paramArrayList2.next();
        paramArrayList1.append(localObject + ";");
      }
      return;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  public List<bg> c()
  {
    try
    {
      this.h.lock();
      List localList = this.f;
      return localList;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  public boolean c(bk parambk)
  {
    return this.k.contains(parambk.e());
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 66	com/tencent/tencentmap/mapsdk/a/az:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 115	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: aload_0
    //   10: getfield 37	com/tencent/tencentmap/mapsdk/a/az:a	Ljava/util/Map;
    //   13: invokeinterface 248 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: iconst_1
    //   21: if_icmpne +12 -> 33
    //   24: aload_0
    //   25: getfield 66	com/tencent/tencentmap/mapsdk/a/az:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   28: invokevirtual 132	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -11 -> 24
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 66	com/tencent/tencentmap/mapsdk/a/az:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   43: invokevirtual 132	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	az
    //   18	4	1	m	int
    //   1	34	2	bool	boolean
    //   38	9	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	38	finally
  }
  
  public String e()
  {
    return this.j;
  }
  
  public List<bg> f()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.j);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      bg localbg = (bg)localIterator.next();
      localStringBuffer.append(";" + localbg.d());
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.az
 * JD-Core Version:    0.7.0.1
 */