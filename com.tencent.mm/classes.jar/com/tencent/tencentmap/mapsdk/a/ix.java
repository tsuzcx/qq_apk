package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ix
  implements jp, jq
{
  private ArrayList<iv> a = new ArrayList();
  private ArrayList<iv> b = new ArrayList();
  private ArrayList<iv> c = new ArrayList();
  private LinkedList<Object> d;
  private ix.b e;
  private int f = 60;
  private ix.a g;
  private long h;
  private boolean i;
  private is j;
  
  public ix(ix.a parama)
  {
    this.g = parama;
    this.d = new LinkedList();
    ig.a(h());
  }
  
  public void a()
  {
    if (this.e != null) {
      this.e.destroy();
    }
    this.e = new ix.b(this, null);
    this.e.start();
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.f = paramInt;
  }
  
  public void a(is paramis)
  {
    this.j = paramis;
  }
  
  public void a(iv paramiv)
  {
    synchronized (this.a)
    {
      if (this.a.size() > 200) {
        this.a.clear();
      }
      this.a.add(paramiv);
      i();
      return;
    }
  }
  
  public void a(jo paramjo)
  {
    this.i = true;
    this.h = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (this.e != null) {
      this.e.destroy();
    }
  }
  
  public void c()
  {
    if (this.e != null) {
      this.e.a();
    }
    j();
  }
  
  public void d()
  {
    if (this.e != null) {
      this.e.b();
    }
  }
  
  public void e()
  {
    this.f = 60;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public void g()
  {
    if (this.e == null) {}
  }
  
  public long h()
  {
    long l2 = 1000L / this.f;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    return l1;
  }
  
  public void i()
  {
    synchronized (this.d)
    {
      this.d.add(iv.h);
      return;
    }
  }
  
  public void j()
  {
    int k;
    for (;;)
    {
      iv localiv;
      synchronized (this.a)
      {
        this.c.clear();
        this.b.clear();
        Iterator localIterator = this.a.iterator();
        k = 0;
        if (!localIterator.hasNext()) {
          break;
        }
        localiv = (iv)localIterator.next();
        if (localiv.e)
        {
          k = 1;
          this.b.add(localiv);
        }
      }
      this.c.add(localiv);
    }
    this.a.clear();
    Object localObject2;
    if (k != 0)
    {
      localObject2 = this.a;
      this.a = this.b;
      this.b = ((ArrayList)localObject2);
    }
    if (this.c.size() > 0)
    {
      localObject2 = this.c.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((iv)((Iterator)localObject2).next()).b();
      }
    }
  }
  
  public boolean k()
  {
    synchronized (this.a)
    {
      if (this.a.isEmpty()) {
        return false;
      }
      iv localiv = (iv)this.a.get(0);
      if ((localiv != null) && (localiv.a(this.g)))
      {
        localiv.c();
        synchronized (this.a)
        {
          this.a.remove(localiv);
        }
      }
    }
    synchronized (this.a)
    {
      boolean bool = this.a.isEmpty();
      if (!bool)
      {
        return true;
        localObject1 = finally;
        throw localObject1;
        localObject2 = finally;
        throw localObject2;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ix
 * JD-Core Version:    0.7.0.1
 */