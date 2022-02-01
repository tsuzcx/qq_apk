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
  private final av TIk;
  private final b TIl;
  private final boolean TIm;
  private final kotlin.l.b.a.b.b.a.g Tih;
  
  private a(av paramav, b paramb, boolean paramBoolean, kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60026);
    this.TIk = paramav;
    this.TIl = paramb;
    this.TIm = paramBoolean;
    this.Tih = paramg;
    AppMethodBeat.o(60026);
  }
  
  private a ER(boolean paramBoolean)
  {
    AppMethodBeat.i(60017);
    if (paramBoolean == this.TIm)
    {
      AppMethodBeat.o(60017);
      return this;
    }
    a locala = new a(this.TIk, this.TIl, paramBoolean, this.Tih);
    AppMethodBeat.o(60017);
    return locala;
  }
  
  private final ab b(bh parambh, ab paramab)
  {
    AppMethodBeat.i(60014);
    if (this.TIk.hLI() == parambh) {
      paramab = this.TIk.hBy();
    }
    p.g(paramab, "if (typeProjection.proje…jection.type else default");
    AppMethodBeat.o(60014);
    return paramab;
  }
  
  private a e(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60020);
    p.h(paramg, "newAnnotations");
    paramg = new a(this.TIk, this.TIl, this.TIm, paramg);
    AppMethodBeat.o(60020);
    return paramg;
  }
  
  private a g(i parami)
  {
    AppMethodBeat.i(60023);
    p.h(parami, "kotlinTypeRefiner");
    parami = this.TIk.m(parami);
    p.g(parami, "typeProjection.refine(kotlinTypeRefiner)");
    parami = new a(parami, this.TIl, this.TIm, this.Tih);
    AppMethodBeat.o(60023);
    return parami;
  }
  
  public final boolean ac(ab paramab)
  {
    AppMethodBeat.i(60015);
    p.h(paramab, "type");
    if (this.TIl == paramab.hKE())
    {
      AppMethodBeat.o(60015);
      return true;
    }
    AppMethodBeat.o(60015);
    return false;
  }
  
  public final h hAp()
  {
    AppMethodBeat.i(60011);
    h localh = u.dU("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    p.g(localh, "ErrorUtils.createErrorSc…solution\", true\n        )");
    AppMethodBeat.o(60011);
    return localh;
  }
  
  public final boolean hEa()
  {
    return this.TIm;
  }
  
  public final List<av> hKB()
  {
    return (List)v.SXr;
  }
  
  public final ab hKC()
  {
    AppMethodBeat.i(60012);
    Object localObject = bh.TOS;
    aj localaj = kotlin.l.b.a.b.m.d.a.aM(this).hzj();
    p.g(localaj, "builtIns.nullableAnyType");
    localObject = b((bh)localObject, (ab)localaj);
    AppMethodBeat.o(60012);
    return localObject;
  }
  
  public final ab hKD()
  {
    AppMethodBeat.i(60013);
    Object localObject = bh.TOR;
    aj localaj = kotlin.l.b.a.b.m.d.a.aM(this).hzh();
    p.g(localaj, "builtIns.nothingType");
    localObject = b((bh)localObject, (ab)localaj);
    AppMethodBeat.o(60013);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.b.a.g hzL()
  {
    return this.Tih;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60016);
    StringBuilder localStringBuilder = new StringBuilder("Captured(").append(this.TIk).append(')');
    if (this.TIm) {}
    for (String str = "?";; str = "")
    {
      str = str;
      AppMethodBeat.o(60016);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */