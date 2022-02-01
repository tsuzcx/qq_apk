package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.a.g;

public final class q
  extends ay
{
  public static final a JXv;
  private final ay JXt;
  private final ay JXu;
  
  static
  {
    AppMethodBeat.i(60647);
    JXv = new a((byte)0);
    AppMethodBeat.o(60647);
  }
  
  private q(ay paramay1, ay paramay2)
  {
    this.JXt = paramay1;
    this.JXu = paramay2;
  }
  
  public static final ay a(ay paramay1, ay paramay2)
  {
    AppMethodBeat.i(60648);
    k.h(paramay1, "first");
    k.h(paramay2, "second");
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
    k.h(paramab, "key");
    av localav2 = this.JXt.O(paramab);
    av localav1 = localav2;
    if (localav2 == null) {
      localav1 = this.JXu.O(paramab);
    }
    AppMethodBeat.o(60642);
    return localav1;
  }
  
  public final ab a(ab paramab, bh parambh)
  {
    AppMethodBeat.i(60643);
    k.h(paramab, "topLevelType");
    k.h(parambh, "position");
    paramab = this.JXu.a(this.JXt.a(paramab, parambh), parambh);
    AppMethodBeat.o(60643);
    return paramab;
  }
  
  public final boolean fIY()
  {
    AppMethodBeat.i(60645);
    if ((this.JXt.fIY()) || (this.JXu.fIY()))
    {
      AppMethodBeat.o(60645);
      return true;
    }
    AppMethodBeat.o(60645);
    return false;
  }
  
  public final boolean fJQ()
  {
    AppMethodBeat.i(60644);
    if ((this.JXt.fJQ()) || (this.JXu.fJQ()))
    {
      AppMethodBeat.o(60644);
      return true;
    }
    AppMethodBeat.o(60644);
    return false;
  }
  
  public final g h(g paramg)
  {
    AppMethodBeat.i(60646);
    k.h(paramg, "annotations");
    paramg = this.JXu.h(this.JXt.h(paramg));
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