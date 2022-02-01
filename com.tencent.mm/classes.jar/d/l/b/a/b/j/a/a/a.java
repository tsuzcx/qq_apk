package d.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.p;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.ar;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.c.d;
import d.l.b.a.b.m.u;
import java.util.List;

public final class a
  extends aj
  implements ar, d
{
  private final av NTo;
  private final b NTp;
  private final boolean NTq;
  private final d.l.b.a.b.b.a.g Nsz;
  
  private a(av paramav, b paramb, boolean paramBoolean, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60026);
    this.NTo = paramav;
    this.NTp = paramb;
    this.NTq = paramBoolean;
    this.Nsz = paramg;
    AppMethodBeat.o(60026);
  }
  
  private a AB(boolean paramBoolean)
  {
    AppMethodBeat.i(60017);
    if (paramBoolean == this.NTq)
    {
      AppMethodBeat.o(60017);
      return this;
    }
    a locala = new a(this.NTo, this.NTp, paramBoolean, this.Nsz);
    AppMethodBeat.o(60017);
    return locala;
  }
  
  private final ab b(bh parambh, ab paramab)
  {
    AppMethodBeat.i(60014);
    if (this.NTo.gyF() == parambh) {
      paramab = this.NTo.gnW();
    }
    p.g(paramab, "if (typeProjection.proje…jection.type else default");
    AppMethodBeat.o(60014);
    return paramab;
  }
  
  private a e(d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60020);
    p.h(paramg, "newAnnotations");
    paramg = new a(this.NTo, this.NTp, this.NTq, paramg);
    AppMethodBeat.o(60020);
    return paramg;
  }
  
  private a g(i parami)
  {
    AppMethodBeat.i(60023);
    p.h(parami, "kotlinTypeRefiner");
    parami = this.NTo.m(parami);
    p.g(parami, "typeProjection.refine(kotlinTypeRefiner)");
    parami = new a(parami, this.NTp, this.NTq, this.Nsz);
    AppMethodBeat.o(60023);
    return parami;
  }
  
  public final boolean ad(ab paramab)
  {
    AppMethodBeat.i(60015);
    p.h(paramab, "type");
    if (this.NTp == paramab.gxB())
    {
      AppMethodBeat.o(60015);
      return true;
    }
    AppMethodBeat.o(60015);
    return false;
  }
  
  public final h gmN()
  {
    AppMethodBeat.i(60011);
    h localh = u.dy("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    p.g(localh, "ErrorUtils.createErrorSc…solution\", true\n        )");
    AppMethodBeat.o(60011);
    return localh;
  }
  
  public final d.l.b.a.b.b.a.g gmj()
  {
    return this.Nsz;
  }
  
  public final boolean gqy()
  {
    return this.NTq;
  }
  
  public final ab gxA()
  {
    AppMethodBeat.i(60013);
    Object localObject = bh.NZX;
    aj localaj = d.l.b.a.b.m.d.a.aN(this).glE();
    p.g(localaj, "builtIns.nothingType");
    localObject = b((bh)localObject, (ab)localaj);
    AppMethodBeat.o(60013);
    return localObject;
  }
  
  public final List<av> gxy()
  {
    return (List)v.NhH;
  }
  
  public final ab gxz()
  {
    AppMethodBeat.i(60012);
    Object localObject = bh.NZY;
    aj localaj = d.l.b.a.b.m.d.a.aN(this).glG();
    p.g(localaj, "builtIns.nullableAnyType");
    localObject = b((bh)localObject, (ab)localaj);
    AppMethodBeat.o(60012);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60016);
    StringBuilder localStringBuilder = new StringBuilder("Captured(").append(this.NTo).append(')');
    if (this.NTq) {}
    for (String str = "?";; str = "")
    {
      str = str;
      AppMethodBeat.o(60016);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */