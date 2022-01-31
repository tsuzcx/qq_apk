package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ba
  implements Runnable
{
  public static final ba a = new ba();
  private static int d = 60000;
  private ConcurrentHashMap<av, az> b = new ConcurrentHashMap(128);
  private ConcurrentHashMap<av, Object> c = new ConcurrentHashMap(128);
  
  public static int a()
  {
    return d;
  }
  
  private int a(boolean paramBoolean, String paramString1, hs paramhs, String paramString2, mn parammn1, mn parammn2)
  {
    if (paramBoolean) {
      return paramhs.a(paramString2, paramString1, parammn1, parammn2);
    }
    return paramhs.a(paramString2, parammn1, parammn2);
  }
  
  private az a(az paramaz)
  {
    az localaz = new az(paramaz.j);
    localaz.b((ArrayList)paramaz.a(), (ArrayList)paramaz.b());
    return localaz;
  }
  
  private az a(String paramString, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2)
  {
    if (paramArrayList1.size() > 0)
    {
      az localaz = new az(paramString);
      localaz.a(paramArrayList1, paramArrayList2);
      bc.c(paramString + " cacheServerData get config from " + localaz);
      return localaz;
    }
    bc.b(paramString + " callback_findObjectById4All get config from register active size = 0");
    return null;
  }
  
  private void a(av paramav, hs paramhs, String paramString)
  {
    try
    {
      bc.c(paramString + " asyncRefreshConfig, " + paramav.b.k + ", " + paramav.b.m + " " + paramav.b.hashCode());
      ba.a locala = new ba.a(this, paramav, paramString);
      a(paramav.b.k, paramav.b.m, paramhs, locala, paramString);
      return;
    }
    catch (Exception paramav)
    {
      bc.b(paramString + " asyncRefreshConfig error", paramav);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, hs paramhs, ba.a parama, String paramString2)
  {
    if (paramBoolean)
    {
      paramhs.a(parama, paramString2, paramString1);
      return;
    }
    paramhs.a(parama, paramString2);
  }
  
  private az b(av paramav, hs paramhs, String paramString)
  {
    for (;;)
    {
      try
      {
        bc.c(paramString + " refreshConfig, " + paramav.b.k + ", " + paramav.b.m);
        localObject = new mn();
        mn localmn = new mn();
        i = a(paramav.b.k, paramav.b.m, paramhs, paramString, (mn)localObject, localmn);
        if (i != 0) {
          continue;
        }
        paramhs = a(paramString, ((mn)localObject).a(), localmn.a());
        i = 1;
      }
      catch (Exception paramhs)
      {
        Object localObject;
        bc.b(paramString + " findObjectByQuery error " + paramhs, paramhs);
        paramhs = null;
        int i = 0;
        continue;
      }
      localObject = paramhs;
      if (i == 0)
      {
        paramav = paramav.b;
        paramav = cb.a(paramav.c(), paramav.d, paramav.c, paramav.g);
        localObject = paramhs;
        if (paramav != null) {
          localObject = b(paramString, (ArrayList)paramav.a, (ArrayList)paramav.b);
        }
      }
      return localObject;
      bc.b(paramString + " findObjectByQuery error , return " + i);
      paramhs = null;
      i = 0;
    }
  }
  
  private az b(String paramString, ArrayList<bg> paramArrayList1, ArrayList<bg> paramArrayList2)
  {
    if (paramArrayList1.size() > 0)
    {
      az localaz = new az(paramString);
      localaz.b(paramArrayList1, paramArrayList2);
      bc.c(paramString + " cacheServerData get config from " + localaz);
      return localaz;
    }
    bc.b(paramString + " callback_findObjectById4All get config from register active size = 0");
    return null;
  }
  
  public void a(av paramav)
  {
    if (!this.c.contains(paramav)) {
      this.c.putIfAbsent(paramav, new Object());
    }
    if ((!this.b.contains(paramav)) && (paramav.d == null))
    {
      az localaz = new az(paramav.b.a);
      localaz.b((ArrayList)paramav.b.h.a(), (ArrayList)paramav.b.h.b());
      this.b.putIfAbsent(paramav, localaz);
    }
  }
  
  public void b(av paramav)
  {
    if (paramav.c())
    {
      a(paramav, paramav.d, paramav.b.a);
      paramav.b();
      return;
    }
    bc.a(paramav.b.a + " can not async refresh config for refreshing in 2s or queryPrx is null");
  }
  
  public az c(av paramav)
  {
    az localaz1 = (az)this.b.get(paramav);
    if (localaz1 != null) {
      return a(localaz1);
    }
    synchronized (this.c.get(paramav))
    {
      localaz1 = (az)this.b.get(paramav);
      az localaz2 = localaz1;
      if (localaz1 == null)
      {
        if (!(paramav instanceof hs)) {
          localaz1 = b(paramav, paramav.d, paramav.b.a);
        }
        if (localaz1 != null)
        {
          this.b.putIfAbsent(paramav, localaz1);
          localaz2 = localaz1;
        }
      }
      else
      {
        if (localaz2 == null) {
          break label145;
        }
        return a(localaz2);
      }
      bc.b(paramav.e.j + " sync get config is null");
      localaz2 = localaz1;
    }
    label145:
    return new az(paramav.e.j);
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      av localav = (av)localIterator.next();
      if (localav.d != null) {
        a(localav, localav.d, localav.b.a);
      } else {
        bc.a(localav.b.a + " proxy.queryFPrx is null, can not refresh serviceInfo");
      }
    }
    bc.a("ServiceInfosRefresher run(), use: " + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ba
 * JD-Core Version:    0.7.0.1
 */