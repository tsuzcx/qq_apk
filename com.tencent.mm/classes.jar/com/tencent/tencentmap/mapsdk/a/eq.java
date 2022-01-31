package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class eq
{
  public static String a;
  private static String b = "AccessIpMgr";
  private static Map<Integer, eq.a> c = new ConcurrentHashMap();
  private static Map<String, eq.a> d = new ConcurrentHashMap();
  private static ey.a e = new ey.a();
  
  public static ew a(String paramString)
  {
    Object localObject = (eq.a)d.get(paramString);
    if (localObject != null)
    {
      paramString = new ew(((eq.a)localObject).b, ((eq.a)localObject).d);
      paramString.c = ((eq.a)localObject).a();
      return paramString;
    }
    localObject = new en(paramString, -1);
    ((en)localObject).a((byte)3);
    paramString = new ew(paramString, "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    paramString.c = localArrayList;
    return paramString;
  }
  
  public static void a()
  {
    em.j().post(new eu());
  }
  
  public static void a(String paramString, en paramen, int paramInt)
  {
    paramString = (eq.a)d.get(paramString);
    if ((paramString != null) && (paramInt != 0)) {
      paramString.b(paramen);
    }
  }
  
  public static void b()
  {
    hj.d().f();
  }
  
  public static void c()
  {
    Object localObject1 = hj.d().f().a();
    if (localObject1 != null)
    {
      d.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ew localew = (ew)((Iterator)localObject1).next();
        eq.a locala = new eq.a(a);
        locala.b = localew.a;
        locala.d = localew.b;
        Object localObject2 = localew.c.iterator();
        while (((Iterator)localObject2).hasNext()) {
          locala.a((en)((Iterator)localObject2).next());
        }
        localObject2 = new en(localew.a, -1);
        ((en)localObject2).a((byte)3);
        locala.a((en)localObject2);
        d.put(localew.a, locala);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.eq
 * JD-Core Version:    0.7.0.1
 */