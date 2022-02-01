package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class d<T extends a>
{
  private final a a;
  private final int b;
  private List<T> c;
  private List<d<T>> d = null;
  
  public d(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this(new a(paramDouble1, paramDouble2, paramDouble3, paramDouble4));
    AppMethodBeat.i(199646);
    AppMethodBeat.o(199646);
  }
  
  private d(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    this(new a(paramDouble1, paramDouble2, paramDouble3, paramDouble4), paramInt);
    AppMethodBeat.i(199647);
    AppMethodBeat.o(199647);
  }
  
  public d(a parama)
  {
    this(parama, 0);
  }
  
  private d(a parama, int paramInt)
  {
    this.a = parama;
    this.b = paramInt;
  }
  
  private void a(double paramDouble1, double paramDouble2, T paramT)
  {
    AppMethodBeat.i(199649);
    d locald = this;
    while (locald.d != null) {
      if (paramDouble2 < locald.a.f)
      {
        if (paramDouble1 < locald.a.e) {
          locald = (d)locald.d.get(0);
        } else {
          locald = (d)locald.d.get(1);
        }
      }
      else if (paramDouble1 < locald.a.e) {
        locald = (d)locald.d.get(2);
      } else {
        locald = (d)locald.d.get(3);
      }
    }
    if (locald.c == null) {
      locald.c = new ArrayList();
    }
    locald.c.add(paramT);
    if ((locald.c.size() > 50) && (locald.b < 40)) {
      locald.b();
    }
    AppMethodBeat.o(199649);
  }
  
  private void a(a parama, Collection<T> paramCollection)
  {
    AppMethodBeat.i(199655);
    if (!this.a.a(parama))
    {
      AppMethodBeat.o(199655);
      return;
    }
    Iterator localIterator;
    if (this.d != null)
    {
      localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(parama, paramCollection);
      }
      AppMethodBeat.o(199655);
      return;
    }
    if (this.c != null)
    {
      if (parama.b(this.a))
      {
        paramCollection.addAll(this.c);
        AppMethodBeat.o(199655);
        return;
      }
      localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (parama.a(locala.getPoint())) {
          paramCollection.add(locala);
        }
      }
    }
    AppMethodBeat.o(199655);
  }
  
  private void b()
  {
    AppMethodBeat.i(199650);
    this.d = new ArrayList(4);
    this.d.add(new d(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
    this.d.add(new d(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
    this.d.add(new d(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
    this.d.add(new d(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
    Object localObject = this.c;
    this.c = null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      a(locala.getPoint().a, locala.getPoint().b, locala);
    }
    AppMethodBeat.o(199650);
  }
  
  private boolean b(double paramDouble1, double paramDouble2, T paramT)
  {
    AppMethodBeat.i(199652);
    d locald = this;
    while (locald.d != null) {
      if (paramDouble2 < locald.a.f)
      {
        if (paramDouble1 < locald.a.e) {
          locald = (d)locald.d.get(0);
        } else {
          locald = (d)locald.d.get(1);
        }
      }
      else if (paramDouble1 < locald.a.e) {
        locald = (d)locald.d.get(2);
      } else {
        locald = (d)locald.d.get(3);
      }
    }
    boolean bool = locald.c.remove(paramT);
    AppMethodBeat.o(199652);
    return bool;
  }
  
  public Collection<T> a(a parama)
  {
    AppMethodBeat.i(199654);
    ArrayList localArrayList = new ArrayList();
    a(parama, localArrayList);
    AppMethodBeat.o(199654);
    return localArrayList;
  }
  
  public void a()
  {
    AppMethodBeat.i(199653);
    this.d = null;
    if (this.c != null) {
      this.c.clear();
    }
    AppMethodBeat.o(199653);
  }
  
  public void a(T paramT)
  {
    AppMethodBeat.i(199648);
    b localb = paramT.getPoint();
    if (this.a.a(localb.a, localb.b)) {
      a(localb.a, localb.b, paramT);
    }
    AppMethodBeat.o(199648);
  }
  
  public boolean b(T paramT)
  {
    AppMethodBeat.i(199651);
    b localb = paramT.getPoint();
    if (this.a.a(localb.a, localb.b))
    {
      boolean bool = b(localb.a, localb.b, paramT);
      AppMethodBeat.o(199651);
      return bool;
    }
    AppMethodBeat.o(199651);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract b getPoint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.a.d
 * JD-Core Version:    0.7.0.1
 */