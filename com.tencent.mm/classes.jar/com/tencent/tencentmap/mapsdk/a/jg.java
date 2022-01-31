package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.listener.a;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jg
{
  private ArrayList<kj> a;
  private ArrayList<kj> b;
  private ArrayList<kj> c;
  private ik d;
  private kg e;
  private List<kf> f;
  private kb g;
  private ki h;
  private a i;
  private ArrayList<Integer> j;
  
  public jg(ik paramik)
  {
    this.d = paramik;
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.j = new ArrayList();
  }
  
  private void a()
  {
    for (;;)
    {
      int k;
      int m;
      synchronized (this.a)
      {
        ArrayList localArrayList2 = new ArrayList();
        int n = this.c.size();
        k = 0;
        Object localObject2;
        if (k < n)
        {
          localObject2 = (kj)this.c.get(k);
          if ((localObject2 instanceof kk))
          {
            localObject2 = (kk)localObject2;
            int i1 = ((kk)localObject2).c();
            m = 0;
            if (m >= i1) {
              break label245;
            }
            kj localkj = ((kk)localObject2).a(m);
            if ((localkj instanceof kl))
            {
              int i2 = ((kl)localkj).f();
              if (i2 >= 0) {
                localArrayList2.add(Integer.valueOf(i2));
              }
            }
          }
          else
          {
            if (!(localObject2 instanceof kl)) {
              break label245;
            }
            m = ((kl)localObject2).f();
            if (m < 0) {
              break label245;
            }
            localArrayList2.add(Integer.valueOf(m));
            break label245;
          }
        }
        else
        {
          m = localArrayList2.size();
          localObject2 = new int[m];
          k = 0;
          if (k < m)
          {
            localObject2[k] = ((Integer)localArrayList2.get(k)).intValue();
            k += 1;
            continue;
          }
          this.d.f().a((int[])localObject2, m);
          this.c.clear();
          return;
        }
      }
      m += 1;
      continue;
      label245:
      k += 1;
    }
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.d.f().a(paramFloat1, paramFloat2);
    if (localObject == null) {}
    do
    {
      return false;
      if ((((TappedElement)localObject).type == 1) && (this.e != null))
      {
        this.e.a(new kh(((TappedElement)localObject).name, d.a(((TappedElement)localObject).pixelX, ((TappedElement)localObject).pixelY)));
        return true;
      }
      if ((((TappedElement)localObject).type == 6) && (this.f != null))
      {
        localObject = this.f.iterator();
        while (((Iterator)localObject).hasNext())
        {
          kf localkf = (kf)((Iterator)localObject).next();
          if (localkf != null) {
            localkf.a();
          }
        }
        return true;
      }
      if ((((TappedElement)localObject).type == 7) && (this.g != null))
      {
        this.g.a(((TappedElement)localObject).itemType, ((TappedElement)localObject).nameLen);
        return true;
      }
    } while (this.h == null);
    this.h.a();
    return false;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(a parama)
  {
    this.i = parama;
  }
  
  public void a(kj paramkj)
  {
    synchronized (this.a)
    {
      if (this.a.contains(paramkj)) {
        return;
      }
      this.a.add(paramkj);
      this.d.a().z();
      return;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    TappedElement localTappedElement = this.d.f().a(paramFloat1, paramFloat2);
    if (localTappedElement == null) {}
    while (localTappedElement.type != 3) {
      return false;
    }
    if (this.i != null) {
      this.i.e();
    }
    return true;
  }
  
  public boolean a(iu paramiu, float paramFloat1, float paramFloat2)
  {
    for (;;)
    {
      int k;
      synchronized (this.a)
      {
        k = this.a.size() - 1;
        if (k >= 0)
        {
          kj localkj = (kj)this.a.get(k);
          if ((localkj != null) && (localkj.a(paramiu, paramFloat1, paramFloat2))) {
            return true;
          }
        }
        else
        {
          return b(paramFloat1, paramFloat2);
        }
      }
      k -= 1;
    }
  }
  
  public boolean a(je paramje, iu paramiu)
  {
    a();
    this.b.clear();
    for (;;)
    {
      kj localkj;
      synchronized (this.a)
      {
        this.b.addAll(this.a);
        ??? = this.b.iterator();
        if (!((Iterator)???).hasNext()) {
          break;
        }
        localkj = (kj)((Iterator)???).next();
        if ((localkj instanceof ka)) {
          ((ka)localkj).a(paramje, paramiu);
        }
      }
      localkj.b(paramje, paramiu);
    }
    return true;
  }
  
  public void b(kj paramkj)
  {
    if (paramkj == null) {
      return;
    }
    synchronized (this.a)
    {
      if (this.a.remove(paramkj)) {
        this.d.a().z();
      }
      this.c.add(paramkj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jg
 * JD-Core Version:    0.7.0.1
 */