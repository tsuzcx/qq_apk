package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;

public final class r
  extends bc
{
  public static final r.a ajpr;
  private final bc ajps;
  private final bc ajpt;
  
  static
  {
    AppMethodBeat.i(60647);
    ajpr = new r.a((byte)0);
    AppMethodBeat.o(60647);
  }
  
  private r(bc parambc1, bc parambc2)
  {
    this.ajps = parambc1;
    this.ajpt = parambc2;
  }
  
  public static final bc a(bc parambc1, bc parambc2)
  {
    AppMethodBeat.i(60648);
    s.u(parambc1, "first");
    s.u(parambc2, "second");
    if (parambc1.isEmpty())
    {
      AppMethodBeat.o(60648);
      return parambc2;
    }
    if (parambc2.isEmpty())
    {
      AppMethodBeat.o(60648);
      return parambc1;
    }
    parambc1 = (bc)new r(parambc1, parambc2, (byte)0);
    AppMethodBeat.o(60648);
    return parambc1;
  }
  
  public final az G(ad paramad)
  {
    AppMethodBeat.i(60642);
    s.u(paramad, "key");
    az localaz = this.ajps.G(paramad);
    if (localaz == null)
    {
      paramad = this.ajpt.G(paramad);
      AppMethodBeat.o(60642);
      return paramad;
    }
    AppMethodBeat.o(60642);
    return localaz;
  }
  
  public final ad a(ad paramad, bl parambl)
  {
    AppMethodBeat.i(60643);
    s.u(paramad, "topLevelType");
    s.u(parambl, "position");
    paramad = this.ajpt.a(this.ajps.a(paramad, parambl), parambl);
    AppMethodBeat.o(60643);
    return paramad;
  }
  
  public final g h(g paramg)
  {
    AppMethodBeat.i(60646);
    s.u(paramg, "annotations");
    paramg = this.ajpt.h(this.ajps.h(paramg));
    AppMethodBeat.o(60646);
    return paramg;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final boolean kAD()
  {
    AppMethodBeat.i(60644);
    if ((this.ajps.kAD()) || (this.ajpt.kAD()))
    {
      AppMethodBeat.o(60644);
      return true;
    }
    AppMethodBeat.o(60644);
    return false;
  }
  
  public final boolean kzo()
  {
    AppMethodBeat.i(60645);
    if ((this.ajps.kzo()) || (this.ajpt.kzo()))
    {
      AppMethodBeat.o(60645);
      return true;
    }
    AppMethodBeat.o(60645);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.r
 * JD-Core Version:    0.7.0.1
 */