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
    AppMethodBeat.i(192342);
    AppMethodBeat.o(192342);
  }
  
  private d(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    this(new a(paramDouble1, paramDouble2, paramDouble3, paramDouble4), paramInt);
    AppMethodBeat.i(192343);
    AppMethodBeat.o(192343);
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
    AppMethodBeat.i(192345);
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
    AppMethodBeat.o(192345);
  }
  
  private void a(a parama, Collection<T> paramCollection)
  {
    AppMethodBeat.i(192351);
    if (!this.a.a(parama))
    {
      AppMethodBeat.o(192351);
      return;
    }
    Iterator localIterator;
    if (this.d != null)
    {
      localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(parama, paramCollection);
      }
      AppMethodBeat.o(192351);
      return;
    }
    if (this.c != null)
    {
      if (parama.b(this.a))
      {
        paramCollection.addAll(this.c);
        AppMethodBeat.o(192351);
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
    AppMethodBeat.o(192351);
  }
  
  private void b()
  {
    AppMethodBeat.i(192346);
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
    AppMethodBeat.o(192346);
  }
  
  private boolean b(double paramDouble1, double paramDouble2, T paramT)
  {
    AppMethodBeat.i(192348);
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
    AppMethodBeat.o(192348);
    return bool;
  }
  
  public Collection<T> a(a parama)
  {
    AppMethodBeat.i(192350);
    ArrayList localArrayList = new ArrayList();
    a(parama, localArrayList);
    AppMethodBeat.o(192350);
    return localArrayList;
  }
  
  public void a()
  {
    AppMethodBeat.i(192349);
    this.d = null;
    if (this.c != null) {
      this.c.clear();
    }
    AppMethodBeat.o(192349);
  }
  
  public void a(T paramT)
  {
    AppMethodBeat.i(192344);
    b localb = paramT.getPoint();
    if (this.a.a(localb.a, localb.b)) {
      a(localb.a, localb.b, paramT);
    }
    AppMethodBeat.o(192344);
  }
  
  public boolean b(T paramT)
  {
    AppMethodBeat.i(192347);
    b localb = paramT.getPoint();
    if (this.a.a(localb.a, localb.b))
    {
      boolean bool = b(localb.a, localb.b, paramT);
      AppMethodBeat.o(192347);
      return bool;
    }
    AppMethodBeat.o(192347);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract b getPoint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.a.d
 * JD-Core Version:    0.7.0.1
 */