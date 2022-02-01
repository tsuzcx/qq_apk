package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ar;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.u;

public final class a
  extends aj
  implements ar, d
{
  private final kotlin.l.b.a.b.b.a.g aaLb;
  private final av abkO;
  private final b abkP;
  private final boolean abkQ;
  
  private a(av paramav, b paramb, boolean paramBoolean, kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60026);
    this.abkO = paramav;
    this.abkP = paramb;
    this.abkQ = paramBoolean;
    this.aaLb = paramg;
    AppMethodBeat.o(60026);
  }
  
  private a Jy(boolean paramBoolean)
  {
    AppMethodBeat.i(60017);
    if (paramBoolean == this.abkQ)
    {
      AppMethodBeat.o(60017);
      return this;
    }
    a locala = new a(this.abkO, this.abkP, paramBoolean, this.aaLb);
    AppMethodBeat.o(60017);
    return locala;
  }
  
  private final ab b(bh parambh, ab paramab)
  {
    AppMethodBeat.i(60014);
    if (this.abkO.iQa() == parambh) {
      paramab = this.abkO.iFN();
    }
    p.j(paramab, "if (typeProjection.proje…jection.type else default");
    AppMethodBeat.o(60014);
    return paramab;
  }
  
  private a e(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60020);
    p.k(paramg, "newAnnotations");
    paramg = new a(this.abkO, this.abkP, this.abkQ, paramg);
    AppMethodBeat.o(60020);
    return paramg;
  }
  
  private a g(i parami)
  {
    AppMethodBeat.i(60023);
    p.k(parami, "kotlinTypeRefiner");
    parami = this.abkO.m(parami);
    p.j(parami, "typeProjection.refine(kotlinTypeRefiner)");
    parami = new a(parami, this.abkP, this.abkQ, this.aaLb);
    AppMethodBeat.o(60023);
    return parami;
  }
  
  public final boolean ac(ab paramab)
  {
    AppMethodBeat.i(60015);
    p.k(paramab, "type");
    if (this.abkP == paramab.iOU())
    {
      AppMethodBeat.o(60015);
      return true;
    }
    AppMethodBeat.o(60015);
    return false;
  }
  
  public final kotlin.l.b.a.b.b.a.g iDY()
  {
    return this.aaLb;
  }
  
  public final h iEC()
  {
    AppMethodBeat.i(60011);
    h localh = u.eh("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    p.j(localh, "ErrorUtils.createErrorSc…solution\", true\n        )");
    AppMethodBeat.o(60011);
    return localh;
  }
  
  public final boolean iIu()
  {
    return this.abkQ;
  }
  
  public final List<av> iOR()
  {
    return (List)v.aaAd;
  }
  
  public final ab iOS()
  {
    AppMethodBeat.i(60012);
    Object localObject = bh.abrr;
    aj localaj = kotlin.l.b.a.b.m.d.a.aM(this).iDv();
    p.j(localaj, "builtIns.nullableAnyType");
    localObject = b((bh)localObject, (ab)localaj);
    AppMethodBeat.o(60012);
    return localObject;
  }
  
  public final ab iOT()
  {
    AppMethodBeat.i(60013);
    Object localObject = bh.abrq;
    aj localaj = kotlin.l.b.a.b.m.d.a.aM(this).iDt();
    p.j(localaj, "builtIns.nothingType");
    localObject = b((bh)localObject, (ab)localaj);
    AppMethodBeat.o(60013);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60016);
    StringBuilder localStringBuilder = new StringBuilder("Captured(").append(this.abkO).append(')');
    if (this.abkQ) {}
    for (String str = "?";; str = "")
    {
      str = str;
      AppMethodBeat.o(60016);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */