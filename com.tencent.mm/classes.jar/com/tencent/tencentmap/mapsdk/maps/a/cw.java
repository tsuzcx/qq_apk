package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class cw
  implements bs, bz
{
  private static cw a;
  private Map<String, bt> b;
  private ct c;
  private Runnable d;
  private Runnable e;
  
  static
  {
    AppMethodBeat.i(147392);
    a = new cw();
    AppMethodBeat.o(147392);
  }
  
  private cw()
  {
    AppMethodBeat.i(147384);
    this.b = new ConcurrentHashMap();
    this.d = new cy(this);
    this.e = new cz(this);
    Object localObject = new by();
    this.b.put(((bt)localObject).b(), localObject);
    localObject = new bw();
    this.b.put(((bt)localObject).b(), localObject);
    localObject = new bu();
    this.b.put(((bt)localObject).b(), localObject);
    localObject = this.d;
    if ((!ac.g()) && (ac.f))
    {
      av.a().a((Runnable)localObject);
      av.a().b((Runnable)localObject, 30000L);
    }
    localObject = this.e;
    if ((!ac.g()) && (ac.f))
    {
      av.a().a((Runnable)localObject);
      av.a().b((Runnable)localObject, 30000L);
    }
    AppMethodBeat.o(147384);
  }
  
  public static cw d()
  {
    return a;
  }
  
  public final void a()
  {
    AppMethodBeat.i(147388);
    this.c.a();
    AppMethodBeat.o(147388);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(98679);
    ac.j().post(new cx(this, paramInt));
    AppMethodBeat.o(98679);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147391);
    Object localObject = this.d;
    long l = an.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!ac.g()) && (ac.f))
    {
      av.a().a((Runnable)localObject);
      av.a().b((Runnable)localObject, l);
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bt)((Iterator)localObject).next()).a(paramString1, paramString2);
    }
    AppMethodBeat.o(147391);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(147390);
    Object localObject = this.e;
    long l = an.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!ac.g()) && (ac.f))
    {
      av.a().a((Runnable)localObject);
      av.a().b((Runnable)localObject, l);
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bt)((Iterator)localObject).next()).a(paramString1, paramArrayOfByte, paramString2);
    }
    AppMethodBeat.o(147390);
  }
  
  public final void b()
  {
    AppMethodBeat.i(98677);
    this.c.b();
    AppMethodBeat.o(98677);
  }
  
  public final void c()
  {
    AppMethodBeat.i(147389);
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((bt)localIterator.next()).c();
    }
    AppMethodBeat.o(147389);
  }
  
  public final cu e()
  {
    AppMethodBeat.i(147385);
    cu localcu = (cu)this.b.get("settings");
    AppMethodBeat.o(147385);
    return localcu;
  }
  
  public final am f()
  {
    AppMethodBeat.i(147386);
    am localam = (am)this.b.get("accessscheduler");
    AppMethodBeat.o(147386);
    return localam;
  }
  
  public final void g()
  {
    AppMethodBeat.i(147387);
    if (ac.g()) {
      this.c = cv.d();
    }
    this.c.a(this);
    this.c.e();
    AppMethodBeat.o(147387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cw
 * JD-Core Version:    0.7.0.1
 */