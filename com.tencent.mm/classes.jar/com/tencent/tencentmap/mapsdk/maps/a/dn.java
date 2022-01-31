package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dn
  extends dq
  implements Iterable<dq>
{
  private final List<dq> a;
  
  public dn()
  {
    AppMethodBeat.i(98724);
    this.a = new ArrayList();
    AppMethodBeat.o(98724);
  }
  
  public final int a()
  {
    AppMethodBeat.i(147488);
    int i = this.a.size();
    AppMethodBeat.o(147488);
    return i;
  }
  
  public final dq a(int paramInt)
  {
    AppMethodBeat.i(147490);
    dq localdq = (dq)this.a.get(paramInt);
    AppMethodBeat.o(147490);
    return localdq;
  }
  
  public final void a(dq paramdq)
  {
    AppMethodBeat.i(147487);
    Object localObject = paramdq;
    if (paramdq == null) {
      localObject = ds.a;
    }
    this.a.add(localObject);
    AppMethodBeat.o(147487);
  }
  
  public final Number b()
  {
    AppMethodBeat.i(147491);
    if (this.a.size() == 1)
    {
      localObject = ((dq)this.a.get(0)).b();
      AppMethodBeat.o(147491);
      return localObject;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(147491);
    throw ((Throwable)localObject);
  }
  
  public final String c()
  {
    AppMethodBeat.i(147492);
    if (this.a.size() == 1)
    {
      localObject = ((dq)this.a.get(0)).c();
      AppMethodBeat.o(147492);
      return localObject;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(147492);
    throw ((Throwable)localObject);
  }
  
  public final double d()
  {
    AppMethodBeat.i(147493);
    if (this.a.size() == 1)
    {
      double d = ((dq)this.a.get(0)).d();
      AppMethodBeat.o(147493);
      return d;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(147493);
    throw localIllegalStateException;
  }
  
  public final float e()
  {
    AppMethodBeat.i(147494);
    if (this.a.size() == 1)
    {
      float f = ((dq)this.a.get(0)).e();
      AppMethodBeat.o(147494);
      return f;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(147494);
    throw localIllegalStateException;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147498);
    if ((paramObject == this) || (((paramObject instanceof dn)) && (((dn)paramObject).a.equals(this.a))))
    {
      AppMethodBeat.o(147498);
      return true;
    }
    AppMethodBeat.o(147498);
    return false;
  }
  
  public final long f()
  {
    AppMethodBeat.i(147495);
    if (this.a.size() == 1)
    {
      long l = ((dq)this.a.get(0)).f();
      AppMethodBeat.o(147495);
      return l;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(147495);
    throw localIllegalStateException;
  }
  
  public final int g()
  {
    AppMethodBeat.i(147496);
    if (this.a.size() == 1)
    {
      int i = ((dq)this.a.get(0)).g();
      AppMethodBeat.o(147496);
      return i;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(147496);
    throw localIllegalStateException;
  }
  
  public final boolean h()
  {
    AppMethodBeat.i(147497);
    if (this.a.size() == 1)
    {
      boolean bool = ((dq)this.a.get(0)).h();
      AppMethodBeat.o(147497);
      return bool;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(147497);
    throw localIllegalStateException;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(147499);
    int i = this.a.hashCode();
    AppMethodBeat.o(147499);
    return i;
  }
  
  public final Iterator<dq> iterator()
  {
    AppMethodBeat.i(147489);
    Iterator localIterator = this.a.iterator();
    AppMethodBeat.o(147489);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dn
 * JD-Core Version:    0.7.0.1
 */