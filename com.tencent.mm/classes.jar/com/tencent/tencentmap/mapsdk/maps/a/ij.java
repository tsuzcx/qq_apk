package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.element.b;
import com.tencent.map.lib.element.f;
import com.tencent.map.lib.element.g;
import com.tencent.map.lib.element.h;
import com.tencent.map.lib.element.i;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.element.k;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ij
{
  private CopyOnWriteArrayList<j> a;
  private CopyOnWriteArrayList<j> b;
  private CopyOnWriteArrayList<j> c;
  private hl d;
  private g e;
  private List<f> f;
  private b g;
  private i h;
  private com.tencent.map.lib.listener.a i;
  private CopyOnWriteArrayList<Integer> j;
  
  public ij(hl paramhl)
  {
    AppMethodBeat.i(148442);
    this.d = paramhl;
    this.a = new CopyOnWriteArrayList();
    this.b = new CopyOnWriteArrayList();
    this.c = new CopyOnWriteArrayList();
    this.j = new CopyOnWriteArrayList();
    AppMethodBeat.o(148442);
  }
  
  private void a()
  {
    AppMethodBeat.i(148446);
    for (;;)
    {
      int k;
      int m;
      synchronized (this.a)
      {
        ArrayList localArrayList = new ArrayList();
        int n = this.c.size();
        k = 0;
        Object localObject2;
        if (k < n)
        {
          localObject2 = (j)this.c.get(k);
          if ((localObject2 instanceof k))
          {
            localObject2 = (k)localObject2;
            int i1 = ((k)localObject2).c();
            m = 0;
            if (m >= i1) {
              break label260;
            }
            j localj = ((k)localObject2).a(m);
            if ((localj instanceof l))
            {
              int i2 = ((l)localj).f();
              if (i2 >= 0) {
                localArrayList.add(Integer.valueOf(i2));
              }
            }
          }
          else
          {
            if (!(localObject2 instanceof l)) {
              break label260;
            }
            m = ((l)localObject2).f();
            if (m < 0) {
              break label260;
            }
            localArrayList.add(Integer.valueOf(m));
            break label260;
          }
        }
        else
        {
          m = localArrayList.size();
          localObject2 = new int[m];
          k = 0;
          if (k < m)
          {
            localObject2[k] = ((Integer)localArrayList.get(k)).intValue();
            k += 1;
            continue;
          }
          this.d.f().a((int[])localObject2, m);
          this.c.clear();
          AppMethodBeat.o(148446);
          return;
        }
      }
      m += 1;
      continue;
      label260:
      k += 1;
    }
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148448);
    Object localObject = this.d.f().a(paramFloat1, paramFloat2);
    if (localObject == null)
    {
      AppMethodBeat.o(148448);
      return false;
    }
    if ((((TappedElement)localObject).type == 1) && (this.e != null))
    {
      this.e.a(new h(((TappedElement)localObject).name, d.a(((TappedElement)localObject).pixelX, ((TappedElement)localObject).pixelY)));
      AppMethodBeat.o(148448);
      return true;
    }
    if ((((TappedElement)localObject).type == 6) && (this.f != null))
    {
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = (f)((Iterator)localObject).next();
        if (localf != null) {
          localf.a();
        }
      }
      AppMethodBeat.o(148448);
      return true;
    }
    if ((((TappedElement)localObject).type == 7) && (this.g != null))
    {
      this.g.a(((TappedElement)localObject).itemType, ((TappedElement)localObject).nameLen);
      AppMethodBeat.o(148448);
      return true;
    }
    if (this.h != null) {
      this.h.a();
    }
    AppMethodBeat.o(148448);
    return false;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(j paramj)
  {
    AppMethodBeat.i(148443);
    synchronized (this.a)
    {
      if (this.a.contains(paramj))
      {
        AppMethodBeat.o(148443);
        return;
      }
      this.a.add(paramj);
      this.d.a().z();
      AppMethodBeat.o(148443);
      return;
    }
  }
  
  public void a(com.tencent.map.lib.listener.a parama)
  {
    this.i = parama;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148449);
    TappedElement localTappedElement = this.d.f().a(paramFloat1, paramFloat2);
    if (localTappedElement == null)
    {
      AppMethodBeat.o(148449);
      return false;
    }
    if (localTappedElement.type == 3)
    {
      if (this.i != null) {
        this.i.a();
      }
      AppMethodBeat.o(148449);
      return true;
    }
    AppMethodBeat.o(148449);
    return false;
  }
  
  public boolean a(hu paramhu, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148447);
    synchronized (this.a)
    {
      int k = this.a.size() - 1;
      while (k >= 0)
      {
        j localj = (j)this.a.get(k);
        if ((localj != null) && (localj.a(paramhu, paramFloat1, paramFloat2)))
        {
          AppMethodBeat.o(148447);
          return true;
        }
        k -= 1;
      }
      boolean bool = b(paramFloat1, paramFloat2);
      AppMethodBeat.o(148447);
      return bool;
    }
  }
  
  public boolean a(ih paramih, hu paramhu)
  {
    AppMethodBeat.i(148445);
    a();
    this.b.clear();
    for (;;)
    {
      j localj;
      synchronized (this.a)
      {
        this.b.addAll(this.a);
        ??? = this.b.iterator();
        if (!((Iterator)???).hasNext()) {
          break;
        }
        localj = (j)((Iterator)???).next();
        if ((localj instanceof com.tencent.map.lib.element.a)) {
          ((com.tencent.map.lib.element.a)localj).a(paramih, paramhu);
        }
      }
      localj.b(paramih, paramhu);
    }
    AppMethodBeat.o(148445);
    return true;
  }
  
  public void b(j paramj)
  {
    AppMethodBeat.i(148444);
    if (paramj == null)
    {
      AppMethodBeat.o(148444);
      return;
    }
    synchronized (this.a)
    {
      if (this.a.remove(paramj)) {
        this.d.a().z();
      }
      this.c.add(paramj);
      AppMethodBeat.o(148444);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ij
 * JD-Core Version:    0.7.0.1
 */