package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;

public final class q
  extends ay
{
  public static final a NBI;
  private final ay NBG;
  private final ay NBH;
  
  static
  {
    AppMethodBeat.i(60647);
    NBI = new a((byte)0);
    AppMethodBeat.o(60647);
  }
  
  private q(ay paramay1, ay paramay2)
  {
    this.NBG = paramay1;
    this.NBH = paramay2;
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
  
  public final av O(ab paramab)
  {
    AppMethodBeat.i(60642);
    p.h(paramab, "key");
    av localav2 = this.NBG.O(paramab);
    av localav1 = localav2;
    if (localav2 == null) {
      localav1 = this.NBH.O(paramab);
    }
    AppMethodBeat.o(60642);
    return localav1;
  }
  
  public final ab a(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60643);
    p.h(paramab, "topLevelType");
    p.h(parambh, "position");
    paramab = this.NBH.a(this.NBG.a(paramab, parambh), parambh);
    AppMethodBeat.o(60643);
    return paramab;
  }
  
  public final boolean gtT()
  {
    AppMethodBeat.i(60644);
    if ((this.NBG.gtT()) || (this.NBH.gtT()))
    {
      AppMethodBeat.o(60644);
      return true;
    }
    AppMethodBeat.o(60644);
    return false;
  }
  
  public final boolean gtb()
  {
    AppMethodBeat.i(60645);
    if ((this.NBG.gtb()) || (this.NBH.gtb()))
    {
      AppMethodBeat.o(60645);
      return true;
    }
    AppMethodBeat.o(60645);
    return false;
  }
  
  public final g h(g paramg)
  {
    AppMethodBeat.i(60646);
    p.h(paramg, "annotations");
    paramg = this.NBH.h(this.NBG.h(paramg));
    AppMethodBeat.o(60646);
    return paramg;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.q
 * JD-Core Version:    0.7.0.1
 */