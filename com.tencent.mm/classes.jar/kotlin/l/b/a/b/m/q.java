package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public final class q
  extends ay
{
  public static final a TNI;
  private final ay TNG;
  private final ay TNH;
  
  static
  {
    AppMethodBeat.i(60647);
    TNI = new a((byte)0);
    AppMethodBeat.o(60647);
  }
  
  private q(ay paramay1, ay paramay2)
  {
    this.TNG = paramay1;
    this.TNH = paramay2;
  }
  
  public static final ay a(ay paramay1, ay paramay2)
  {
    AppMethodBeat.i(60648);
    p.h(paramay1, "first");
    p.h(paramay2, "second");
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
    p.h(paramab, "key");
    av localav2 = this.TNG.N(paramab);
    av localav1 = localav2;
    if (localav2 == null) {
      localav1 = this.TNH.N(paramab);
    }
    AppMethodBeat.o(60642);
    return localav1;
  }
  
  public final ab a(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60643);
    p.h(paramab, "topLevelType");
    p.h(parambh, "position");
    paramab = this.TNH.a(this.TNG.a(paramab, parambh), parambh);
    AppMethodBeat.o(60643);
    return paramab;
  }
  
  public final g h(g paramg)
  {
    AppMethodBeat.i(60646);
    p.h(paramg, "annotations");
    paramg = this.TNH.h(this.TNG.h(paramg));
    AppMethodBeat.o(60646);
    return paramg;
  }
  
  public final boolean hKG()
  {
    AppMethodBeat.i(60645);
    if ((this.TNG.hKG()) || (this.TNH.hKG()))
    {
      AppMethodBeat.o(60645);
      return true;
    }
    AppMethodBeat.o(60645);
    return false;
  }
  
  public final boolean hLy()
  {
    AppMethodBeat.i(60644);
    if ((this.TNG.hLy()) || (this.TNH.hLy()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.q
 * JD-Core Version:    0.7.0.1
 */