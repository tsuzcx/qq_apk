package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class hx
  implements ir, is
{
  private ArrayList<hv> a;
  private final byte[] b;
  private ArrayList<hv> c;
  private ArrayList<hv> d;
  private LinkedList<Object> e;
  private hx.b f;
  private int g;
  private a h;
  private long i;
  private boolean j;
  private ht k;
  
  public hx(a parama)
  {
    AppMethodBeat.i(148123);
    this.a = new ArrayList();
    this.b = new byte[0];
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.g = 60;
    this.h = parama;
    this.e = new LinkedList();
    hh.a(h());
    AppMethodBeat.o(148123);
  }
  
  public void a()
  {
    AppMethodBeat.i(148124);
    if (this.f != null) {
      this.f.destroy();
    }
    this.f = new hx.b(this, null);
    this.f.start();
    AppMethodBeat.o(148124);
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.g = paramInt;
  }
  
  public void a(ht paramht)
  {
    this.k = paramht;
  }
  
  public void a(hv paramhv)
  {
    AppMethodBeat.i(148126);
    synchronized (this.b)
    {
      if (this.a.size() > 200) {
        this.a.clear();
      }
      this.a.add(paramhv);
      i();
      AppMethodBeat.o(148126);
      return;
    }
  }
  
  public void a(iq paramiq)
  {
    AppMethodBeat.i(148129);
    this.j = true;
    this.i = System.currentTimeMillis();
    AppMethodBeat.o(148129);
  }
  
  public void b()
  {
    AppMethodBeat.i(99660);
    if (this.f != null) {
      this.f.destroy();
    }
    AppMethodBeat.o(99660);
  }
  
  public void c()
  {
    AppMethodBeat.i(148125);
    if (this.f != null) {
      this.f.a();
    }
    j();
    AppMethodBeat.o(148125);
  }
  
  public void d()
  {
    AppMethodBeat.i(99661);
    if (this.f != null) {
      this.f.b();
    }
    AppMethodBeat.o(99661);
  }
  
  public void e()
  {
    this.g = 60;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public void g()
  {
    if (this.f == null) {}
  }
  
  public long h()
  {
    long l2 = 1000L / this.g;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    return l1;
  }
  
  public void i()
  {
    AppMethodBeat.i(99655);
    synchronized (this.e)
    {
      this.e.add(hv.h);
      AppMethodBeat.o(99655);
      return;
    }
  }
  
  public void j()
  {
    AppMethodBeat.i(148127);
    int m;
    for (;;)
    {
      hv localhv;
      synchronized (this.b)
      {
        this.d.clear();
        this.c.clear();
        Iterator localIterator = this.a.iterator();
        m = 0;
        if (!localIterator.hasNext()) {
          break;
        }
        localhv = (hv)localIterator.next();
        if (localhv.e)
        {
          m = 1;
          this.c.add(localhv);
        }
      }
      this.d.add(localhv);
    }
    this.a.clear();
    Object localObject2;
    if (m != 0)
    {
      localObject2 = this.a;
      this.a = this.c;
      this.c = ((ArrayList)localObject2);
    }
    if (this.d.size() > 0)
    {
      localObject2 = this.d.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((hv)((Iterator)localObject2).next()).b();
      }
    }
    AppMethodBeat.o(148127);
  }
  
  public boolean k()
  {
    AppMethodBeat.i(148128);
    synchronized (this.b)
    {
      if (this.a.isEmpty())
      {
        AppMethodBeat.o(148128);
        return false;
      }
      hv localhv = (hv)this.a.get(0);
      if ((localhv != null) && (localhv.a(this.h)))
      {
        localhv.c();
        synchronized (this.b)
        {
          this.a.remove(localhv);
        }
      }
    }
    synchronized (this.b)
    {
      boolean bool = this.a.isEmpty();
      if (!bool)
      {
        AppMethodBeat.o(148128);
        return true;
        localObject1 = finally;
        AppMethodBeat.o(148128);
        throw localObject1;
        localObject2 = finally;
        AppMethodBeat.o(148128);
        throw localObject2;
      }
    }
    AppMethodBeat.o(148128);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(hv paramhv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hx
 * JD-Core Version:    0.7.0.1
 */