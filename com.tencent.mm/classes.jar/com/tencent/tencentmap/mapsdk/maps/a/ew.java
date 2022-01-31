package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class ew
  extends fh
{
  private static final Writer a;
  private static final dv b;
  private final List<dq> c;
  private String d;
  private dq e;
  
  static
  {
    AppMethodBeat.i(147702);
    a = new ew.1();
    b = new dv("closed");
    AppMethodBeat.o(147702);
  }
  
  public ew()
  {
    super(a);
    AppMethodBeat.i(147687);
    this.c = new ArrayList();
    this.e = ds.a;
    AppMethodBeat.o(147687);
  }
  
  private void a(dq paramdq)
  {
    AppMethodBeat.i(147690);
    if (this.d != null)
    {
      if ((!paramdq.l()) || (h())) {
        ((dt)i()).a(this.d, paramdq);
      }
      this.d = null;
      AppMethodBeat.o(147690);
      return;
    }
    if (this.c.isEmpty())
    {
      this.e = paramdq;
      AppMethodBeat.o(147690);
      return;
    }
    dq localdq = i();
    if ((localdq instanceof dn))
    {
      ((dn)localdq).a(paramdq);
      AppMethodBeat.o(147690);
      return;
    }
    paramdq = new IllegalStateException();
    AppMethodBeat.o(147690);
    throw paramdq;
  }
  
  private dq i()
  {
    AppMethodBeat.i(147689);
    dq localdq = (dq)this.c.get(this.c.size() - 1);
    AppMethodBeat.o(147689);
    return localdq;
  }
  
  public final dq a()
  {
    AppMethodBeat.i(147688);
    if (!this.c.isEmpty())
    {
      localObject = new IllegalStateException("Expected one JSON element but was " + this.c);
      AppMethodBeat.o(147688);
      throw ((Throwable)localObject);
    }
    Object localObject = this.e;
    AppMethodBeat.o(147688);
    return localObject;
  }
  
  public final fh a(long paramLong)
  {
    AppMethodBeat.i(147699);
    a(new dv(Long.valueOf(paramLong)));
    AppMethodBeat.o(147699);
    return this;
  }
  
  public final fh a(Number paramNumber)
  {
    AppMethodBeat.i(147700);
    if (paramNumber == null)
    {
      paramNumber = f();
      AppMethodBeat.o(147700);
      return paramNumber;
    }
    if (!g())
    {
      double d1 = paramNumber.doubleValue();
      if ((Double.isNaN(d1)) || (Double.isInfinite(d1)))
      {
        paramNumber = new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(paramNumber)));
        AppMethodBeat.o(147700);
        throw paramNumber;
      }
    }
    a(new dv(paramNumber));
    AppMethodBeat.o(147700);
    return this;
  }
  
  public final fh a(String paramString)
  {
    AppMethodBeat.i(147695);
    if ((this.c.isEmpty()) || (this.d != null))
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(147695);
      throw paramString;
    }
    if ((i() instanceof dt))
    {
      this.d = paramString;
      AppMethodBeat.o(147695);
      return this;
    }
    paramString = new IllegalStateException();
    AppMethodBeat.o(147695);
    throw paramString;
  }
  
  public final fh a(boolean paramBoolean)
  {
    AppMethodBeat.i(147698);
    a(new dv(Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(147698);
    return this;
  }
  
  public final fh b()
  {
    AppMethodBeat.i(147691);
    dn localdn = new dn();
    a(localdn);
    this.c.add(localdn);
    AppMethodBeat.o(147691);
    return this;
  }
  
  public final fh b(String paramString)
  {
    AppMethodBeat.i(147696);
    if (paramString == null)
    {
      paramString = f();
      AppMethodBeat.o(147696);
      return paramString;
    }
    a(new dv(paramString));
    AppMethodBeat.o(147696);
    return this;
  }
  
  public final fh c()
  {
    AppMethodBeat.i(147692);
    if ((this.c.isEmpty()) || (this.d != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(147692);
      throw localIllegalStateException;
    }
    if ((i() instanceof dn))
    {
      this.c.remove(this.c.size() - 1);
      AppMethodBeat.o(147692);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(147692);
    throw localIllegalStateException;
  }
  
  public final void close()
  {
    AppMethodBeat.i(147701);
    if (!this.c.isEmpty())
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(147701);
      throw localIOException;
    }
    this.c.add(b);
    AppMethodBeat.o(147701);
  }
  
  public final fh d()
  {
    AppMethodBeat.i(147693);
    dt localdt = new dt();
    a(localdt);
    this.c.add(localdt);
    AppMethodBeat.o(147693);
    return this;
  }
  
  public final fh e()
  {
    AppMethodBeat.i(147694);
    if ((this.c.isEmpty()) || (this.d != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(147694);
      throw localIllegalStateException;
    }
    if ((i() instanceof dt))
    {
      this.c.remove(this.c.size() - 1);
      AppMethodBeat.o(147694);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(147694);
    throw localIllegalStateException;
  }
  
  public final fh f()
  {
    AppMethodBeat.i(147697);
    a(ds.a);
    AppMethodBeat.o(147697);
    return this;
  }
  
  public final void flush() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ew
 * JD-Core Version:    0.7.0.1
 */