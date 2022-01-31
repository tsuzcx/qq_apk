package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class gc
{
  private AtomicInteger a;
  private final Set<gb<?>> b;
  private final PriorityBlockingQueue<gb<?>> c;
  private final fw d;
  private final ge e;
  private fx[] f;
  private List<gc.a> g;
  
  public gc(fw paramfw)
  {
    this(paramfw, 4);
  }
  
  public gc(fw paramfw, int paramInt)
  {
    this(paramfw, paramInt, new fv(new Handler(Looper.getMainLooper())));
    AppMethodBeat.i(147979);
    AppMethodBeat.o(147979);
  }
  
  public gc(fw paramfw, int paramInt, ge paramge)
  {
    AppMethodBeat.i(147978);
    this.a = new AtomicInteger();
    this.b = new HashSet();
    this.c = new PriorityBlockingQueue();
    this.g = new ArrayList();
    this.d = paramfw;
    this.f = new fx[paramInt];
    this.e = paramge;
    AppMethodBeat.o(147978);
  }
  
  public <T> gb<T> a(gb<T> paramgb)
  {
    AppMethodBeat.i(147983);
    paramgb.a(this);
    synchronized (this.b)
    {
      this.b.add(paramgb);
      paramgb.a(c());
      paramgb.a("add-to-queue");
      this.c.add(paramgb);
      AppMethodBeat.o(147983);
      return paramgb;
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(147980);
    b();
    int i = 0;
    while (i < this.f.length)
    {
      fx localfx = new fx(this.c, this.d, this.e);
      this.f[i] = localfx;
      localfx.start();
      i += 1;
    }
    AppMethodBeat.o(147980);
  }
  
  public void b()
  {
    AppMethodBeat.i(147981);
    int i = 0;
    while (i < this.f.length)
    {
      if (this.f[i] != null) {
        this.f[i].a();
      }
      i += 1;
    }
    AppMethodBeat.o(147981);
  }
  
  <T> void b(gb<T> paramgb)
  {
    AppMethodBeat.i(147984);
    synchronized (this.b)
    {
      this.b.remove(paramgb);
      synchronized (this.g)
      {
        Iterator localIterator = this.g.iterator();
        if (localIterator.hasNext()) {
          ((gc.a)localIterator.next()).a(paramgb);
        }
      }
    }
    AppMethodBeat.o(147984);
  }
  
  public int c()
  {
    AppMethodBeat.i(147982);
    int i = this.a.incrementAndGet();
    AppMethodBeat.o(147982);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gc
 * JD-Core Version:    0.7.0.1
 */