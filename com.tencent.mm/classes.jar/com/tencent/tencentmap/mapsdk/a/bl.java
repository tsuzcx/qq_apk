package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class bl
{
  private static Map<bg, bi> a = new ConcurrentHashMap();
  
  public static bi a(bg parambg)
  {
    bi localbi2 = (bi)a.get(parambg);
    bi localbi1 = localbi2;
    if (localbi2 == null)
    {
      localbi1 = new bi();
      a.put(parambg, localbi1);
    }
    return localbi1;
  }
  
  public static void a(bj parambj, bg parambg, int paramInt)
  {
    a(parambg).a(parambj, parambg, paramInt);
  }
  
  public static boolean a(bg parambg, bj parambj)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    parambg = a(parambg);
    if (!parambg.a())
    {
      if (parambg.b() + parambj.c().taf_try_time_interval() * 1000 >= Millis100TimeProvider.INSTANCE.currentTimeMillis()) {
        break label62;
      }
      parambg.a(Millis100TimeProvider.INSTANCE.currentTimeMillis());
    }
    label62:
    for (bool1 = bool2;; bool1 = false)
    {
      parambj.c();
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bl
 * JD-Core Version:    0.7.0.1
 */