package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public final class q
  extends ay
{
  public static final a abqk;
  private final ay abqi;
  private final ay abqj;
  
  static
  {
    AppMethodBeat.i(60647);
    abqk = new a((byte)0);
    AppMethodBeat.o(60647);
  }
  
  private q(ay paramay1, ay paramay2)
  {
    this.abqi = paramay1;
    this.abqj = paramay2;
  }
  
  public static final ay a(ay paramay1, ay paramay2)
  {
    AppMethodBeat.i(60648);
    p.k(paramay1, "first");
    p.k(paramay2, "second");
    if (paramay1.isEmpty())
    {
      AppMethodBeat.o(60648);
      return paramay2;
    }
    if (paramay2.isEmpty())
    {
      AppMethodBeat.o(60648);
      return paramay1;
    }
    paramay1 = (ay)new q(paramay1, paramay2, (byte)0);
    AppMethodBeat.o(60648);
    return paramay1;
  }
  
  public final av N(ab paramab)
  {
    AppMethodBeat.i(60642);
    p.k(paramab, "key");
    av localav2 = this.abqi.N(paramab);
    av localav1 = localav2;
    if (localav2 == null) {
      localav1 = this.abqj.N(paramab);
    }
    AppMethodBeat.o(60642);
    return localav1;
  }
  
  public final ab a(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60643);
    p.k(paramab, "topLevelType");
    p.k(parambh, "position");
    paramab = this.abqj.a(this.abqi.a(paramab, parambh), parambh);
    AppMethodBeat.o(60643);
    return paramab;
  }
  
  public final g h(g paramg)
  {
    AppMethodBeat.i(60646);
    p.k(paramg, "annotations");
    paramg = this.abqj.h(this.abqi.h(paramg));
    AppMethodBeat.o(60646);
    return paramg;
  }
  
  public final boolean iOW()
  {
    AppMethodBeat.i(60645);
    if ((this.abqi.iOW()) || (this.abqj.iOW()))
    {
      AppMethodBeat.o(60645);
      return true;
    }
    AppMethodBeat.o(60645);
    return false;
  }
  
  public final boolean iPR()
  {
    AppMethodBeat.i(60644);
    if ((this.abqi.iPR()) || (this.abqj.iPR()))
    {
      AppMethodBeat.o(60644);
      return true;
    }
    AppMethodBeat.o(60644);
    return false;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.q
 * JD-Core Version:    0.7.0.1
 */