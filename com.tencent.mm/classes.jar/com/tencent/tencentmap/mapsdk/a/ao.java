package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ao
{
  public static final List<Integer> a;
  private ConcurrentHashMap<lu, as> b = new ConcurrentHashMap();
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add(Integer.valueOf(5));
    a.add(Integer.valueOf(10));
    a.add(Integer.valueOf(50));
    a.add(Integer.valueOf(100));
    a.add(Integer.valueOf(200));
    a.add(Integer.valueOf(500));
    a.add(Integer.valueOf(1000));
    a.add(Integer.valueOf(2000));
    a.add(Integer.valueOf(3000));
  }
  
  public as a(lu paramlu)
  {
    as localas2 = (as)this.b.get(paramlu);
    as localas1 = localas2;
    if (localas2 == null)
    {
      localas1 = new as(a);
      this.b.putIfAbsent(paramlu, localas1);
    }
    return localas1;
  }
  
  public ConcurrentHashMap<lu, as> a()
  {
    return this.b;
  }
  
  public void a(lu paramlu, int paramInt)
  {
    a(paramlu).a(paramInt, 2);
  }
  
  public void a(lu paramlu, long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      a(paramlu).a(paramLong, 0);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        a(paramlu).a(paramLong, 1);
        return;
      }
    } while (paramInt != 2);
    a(paramlu).a(paramLong, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ao
 * JD-Core Version:    0.7.0.1
 */