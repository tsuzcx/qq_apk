package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class ev
  extends ff
{
  private static final Reader a;
  private static final Object b;
  private final List<Object> c;
  
  static
  {
    AppMethodBeat.i(147683);
    a = new ev.1();
    b = new Object();
    AppMethodBeat.o(147683);
  }
  
  public ev(dq paramdq)
  {
    super(a);
    AppMethodBeat.i(147662);
    this.c = new ArrayList();
    this.c.add(paramdq);
    AppMethodBeat.o(147662);
  }
  
  private void a(fg paramfg)
  {
    AppMethodBeat.i(147671);
    if (f() != paramfg)
    {
      paramfg = new IllegalStateException("Expected " + paramfg + " but was " + f());
      AppMethodBeat.o(147671);
      throw paramfg;
    }
    AppMethodBeat.o(147671);
  }
  
  private Object q()
  {
    AppMethodBeat.i(147669);
    Object localObject = this.c.get(this.c.size() - 1);
    AppMethodBeat.o(147669);
    return localObject;
  }
  
  private Object r()
  {
    AppMethodBeat.i(147670);
    Object localObject = this.c.remove(this.c.size() - 1);
    AppMethodBeat.o(147670);
    return localObject;
  }
  
  public final void a()
  {
    AppMethodBeat.i(147663);
    a(fg.a);
    dn localdn = (dn)q();
    this.c.add(localdn.iterator());
    AppMethodBeat.o(147663);
  }
  
  public final void b()
  {
    AppMethodBeat.i(147664);
    a(fg.b);
    r();
    r();
    AppMethodBeat.o(147664);
  }
  
  public final void c()
  {
    AppMethodBeat.i(147665);
    a(fg.c);
    dt localdt = (dt)q();
    this.c.add(localdt.a().iterator());
    AppMethodBeat.o(147665);
  }
  
  public final void close()
  {
    AppMethodBeat.i(147679);
    this.c.clear();
    this.c.add(b);
    AppMethodBeat.o(147679);
  }
  
  public final void d()
  {
    AppMethodBeat.i(147666);
    a(fg.d);
    r();
    r();
    AppMethodBeat.o(147666);
  }
  
  public final boolean e()
  {
    AppMethodBeat.i(147667);
    fg localfg = f();
    if ((localfg != fg.d) && (localfg != fg.b))
    {
      AppMethodBeat.o(147667);
      return true;
    }
    AppMethodBeat.o(147667);
    return false;
  }
  
  public final fg f()
  {
    AppMethodBeat.i(147668);
    boolean bool;
    for (;;)
    {
      if (this.c.isEmpty())
      {
        localObject = fg.j;
        AppMethodBeat.o(147668);
        return localObject;
      }
      localObject = q();
      if (!(localObject instanceof Iterator)) {
        break label138;
      }
      bool = this.c.get(this.c.size() - 2) instanceof dt;
      localObject = (Iterator)localObject;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      if (bool)
      {
        localObject = fg.e;
        AppMethodBeat.o(147668);
        return localObject;
      }
      this.c.add(((Iterator)localObject).next());
    }
    if (bool)
    {
      localObject = fg.d;
      AppMethodBeat.o(147668);
      return localObject;
    }
    Object localObject = fg.b;
    AppMethodBeat.o(147668);
    return localObject;
    label138:
    if ((localObject instanceof dt))
    {
      localObject = fg.c;
      AppMethodBeat.o(147668);
      return localObject;
    }
    if ((localObject instanceof dn))
    {
      localObject = fg.a;
      AppMethodBeat.o(147668);
      return localObject;
    }
    if ((localObject instanceof dv))
    {
      localObject = (dv)localObject;
      if (((dv)localObject).r())
      {
        localObject = fg.f;
        AppMethodBeat.o(147668);
        return localObject;
      }
      if (((dv)localObject).a())
      {
        localObject = fg.h;
        AppMethodBeat.o(147668);
        return localObject;
      }
      if (((dv)localObject).q())
      {
        localObject = fg.g;
        AppMethodBeat.o(147668);
        return localObject;
      }
      localObject = new AssertionError();
      AppMethodBeat.o(147668);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof ds))
    {
      localObject = fg.i;
      AppMethodBeat.o(147668);
      return localObject;
    }
    if (localObject == b)
    {
      localObject = new IllegalStateException("JsonReader is closed");
      AppMethodBeat.o(147668);
      throw ((Throwable)localObject);
    }
    localObject = new AssertionError();
    AppMethodBeat.o(147668);
    throw ((Throwable)localObject);
  }
  
  public final String g()
  {
    AppMethodBeat.i(147672);
    a(fg.e);
    Object localObject = (Map.Entry)((Iterator)q()).next();
    this.c.add(((Map.Entry)localObject).getValue());
    localObject = (String)((Map.Entry)localObject).getKey();
    AppMethodBeat.o(147672);
    return localObject;
  }
  
  public final String h()
  {
    AppMethodBeat.i(147673);
    Object localObject = f();
    if ((localObject != fg.f) && (localObject != fg.g))
    {
      localObject = new IllegalStateException("Expected " + fg.f + " but was " + localObject);
      AppMethodBeat.o(147673);
      throw ((Throwable)localObject);
    }
    localObject = ((dv)r()).c();
    AppMethodBeat.o(147673);
    return localObject;
  }
  
  public final boolean i()
  {
    AppMethodBeat.i(147674);
    a(fg.h);
    boolean bool = ((dv)r()).h();
    AppMethodBeat.o(147674);
    return bool;
  }
  
  public final void j()
  {
    AppMethodBeat.i(147675);
    a(fg.i);
    r();
    AppMethodBeat.o(147675);
  }
  
  public final double k()
  {
    AppMethodBeat.i(147676);
    Object localObject = f();
    if ((localObject != fg.g) && (localObject != fg.f))
    {
      localObject = new IllegalStateException("Expected " + fg.g + " but was " + localObject);
      AppMethodBeat.o(147676);
      throw ((Throwable)localObject);
    }
    double d = ((dv)q()).d();
    if ((!p()) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
    {
      localObject = new NumberFormatException("JSON forbids NaN and infinities: ".concat(String.valueOf(d)));
      AppMethodBeat.o(147676);
      throw ((Throwable)localObject);
    }
    r();
    AppMethodBeat.o(147676);
    return d;
  }
  
  public final long l()
  {
    AppMethodBeat.i(147677);
    Object localObject = f();
    if ((localObject != fg.g) && (localObject != fg.f))
    {
      localObject = new IllegalStateException("Expected " + fg.g + " but was " + localObject);
      AppMethodBeat.o(147677);
      throw ((Throwable)localObject);
    }
    long l = ((dv)q()).f();
    r();
    AppMethodBeat.o(147677);
    return l;
  }
  
  public final int m()
  {
    AppMethodBeat.i(147678);
    Object localObject = f();
    if ((localObject != fg.g) && (localObject != fg.f))
    {
      localObject = new IllegalStateException("Expected " + fg.g + " but was " + localObject);
      AppMethodBeat.o(147678);
      throw ((Throwable)localObject);
    }
    int i = ((dv)q()).g();
    r();
    AppMethodBeat.o(147678);
    return i;
  }
  
  public final void n()
  {
    AppMethodBeat.i(147680);
    if (f() == fg.e)
    {
      g();
      AppMethodBeat.o(147680);
      return;
    }
    r();
    AppMethodBeat.o(147680);
  }
  
  public final void o()
  {
    AppMethodBeat.i(147682);
    a(fg.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)q()).next();
    this.c.add(localEntry.getValue());
    this.c.add(new dv((String)localEntry.getKey()));
    AppMethodBeat.o(147682);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147681);
    String str = getClass().getSimpleName();
    AppMethodBeat.o(147681);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ev
 * JD-Core Version:    0.7.0.1
 */