package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class hj
  implements ge, gl
{
  private static hj a = new hj();
  private Map<String, gf> b = new ConcurrentHashMap();
  private hg c;
  private Runnable d = new hl(this);
  private Runnable e = new hm(this);
  
  private hj()
  {
    Object localObject = new gk();
    this.b.put(((gf)localObject).b(), localObject);
    localObject = new gi();
    this.b.put(((gf)localObject).b(), localObject);
    localObject = new gg();
    this.b.put(((gf)localObject).b(), localObject);
    localObject = this.d;
    if ((!em.g()) && (em.f))
    {
      fg.a().a((Runnable)localObject);
      fg.a().b((Runnable)localObject, 30000L);
    }
    localObject = this.e;
    if ((!em.g()) && (em.f))
    {
      fg.a().a((Runnable)localObject);
      fg.a().b((Runnable)localObject, 30000L);
    }
  }
  
  public static hj d()
  {
    return a;
  }
  
  public final void a()
  {
    this.c.a();
  }
  
  public final void a(int paramInt)
  {
    em.j().post(new hk(this, paramInt));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = this.d;
    long l = ey.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!em.g()) && (em.f))
    {
      fg.a().a((Runnable)localObject);
      fg.a().b((Runnable)localObject, l);
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((gf)((Iterator)localObject).next()).a(paramString1, paramString2);
    }
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject = this.e;
    long l = ey.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!em.g()) && (em.f))
    {
      fg.a().a((Runnable)localObject);
      fg.a().b((Runnable)localObject, l);
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((gf)((Iterator)localObject).next()).a(paramString1, paramArrayOfByte, paramString2);
    }
  }
  
  public final void b()
  {
    this.c.b();
  }
  
  public final void c()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((gf)localIterator.next()).c();
    }
  }
  
  public final hh e()
  {
    return (hh)this.b.get("settings");
  }
  
  public final ex f()
  {
    return (ex)this.b.get("accessscheduler");
  }
  
  public final void g()
  {
    if (em.g()) {
      this.c = hi.d();
    }
    this.c.a(this);
    this.c.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.hj
 * JD-Core Version:    0.7.0.1
 */