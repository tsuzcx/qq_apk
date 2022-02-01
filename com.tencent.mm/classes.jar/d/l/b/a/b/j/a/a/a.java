package d.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.ar;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.c.c;
import d.l.b.a.b.m.u;
import java.util.List;

public final class a
  extends aj
  implements ar, c
{
  private final av LFk;
  private final b LFl;
  private final boolean LFm;
  private final d.l.b.a.b.b.a.g Lez;
  
  private a(av paramav, b paramb, boolean paramBoolean, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60026);
    this.LFk = paramav;
    this.LFl = paramb;
    this.LFm = paramBoolean;
    this.Lez = paramg;
    AppMethodBeat.o(60026);
  }
  
  private final ab b(bh parambh, ab paramab)
  {
    AppMethodBeat.i(60014);
    if (this.LFk.gcC() == parambh) {
      paramab = this.LFk.fRV();
    }
    k.g(paramab, "if (typeProjection.proje…jection.type else default");
    AppMethodBeat.o(60014);
    return paramab;
  }
  
  private a e(d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60020);
    k.h(paramg, "newAnnotations");
    paramg = new a(this.LFk, this.LFl, this.LFm, paramg);
    AppMethodBeat.o(60020);
    return paramg;
  }
  
  private a g(i parami)
  {
    AppMethodBeat.i(60023);
    k.h(parami, "kotlinTypeRefiner");
    parami = this.LFk.m(parami);
    k.g(parami, "typeProjection.refine(kotlinTypeRefiner)");
    parami = new a(parami, this.LFl, this.LFm, this.Lez);
    AppMethodBeat.o(60023);
    return parami;
  }
  
  private a zA(boolean paramBoolean)
  {
    AppMethodBeat.i(60017);
    if (paramBoolean == this.LFm)
    {
      AppMethodBeat.o(60017);
      return this;
    }
    a locala = new a(this.LFk, this.LFl, paramBoolean, this.Lez);
    AppMethodBeat.o(60017);
    return locala;
  }
  
  public final boolean ad(ab paramab)
  {
    AppMethodBeat.i(60015);
    k.h(paramab, "type");
    if (this.LFl == paramab.gbz())
    {
      AppMethodBeat.o(60015);
      return true;
    }
    AppMethodBeat.o(60015);
    return false;
  }
  
  public final h fQN()
  {
    AppMethodBeat.i(60011);
    h localh = u.dq("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    k.g(localh, "ErrorUtils.createErrorSc…solution\", true\n        )");
    AppMethodBeat.o(60011);
    return localh;
  }
  
  public final d.l.b.a.b.b.a.g fQj()
  {
    return this.Lez;
  }
  
  public final boolean fUx()
  {
    return this.LFm;
  }
  
  public final List<av> gbw()
  {
    return (List)v.KTF;
  }
  
  public final ab gbx()
  {
    AppMethodBeat.i(60012);
    Object localObject = bh.LLX;
    aj localaj = d.l.b.a.b.m.d.a.aN(this).fPG();
    k.g(localaj, "builtIns.nullableAnyType");
    localObject = b((bh)localObject, (ab)localaj);
    AppMethodBeat.o(60012);
    return localObject;
  }
  
  public final ab gby()
  {
    AppMethodBeat.i(60013);
    Object localObject = bh.LLW;
    aj localaj = d.l.b.a.b.m.d.a.aN(this).fPE();
    k.g(localaj, "builtIns.nothingType");
    localObject = b((bh)localObject, (ab)localaj);
    AppMethodBeat.o(60013);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60016);
    StringBuilder localStringBuilder = new StringBuilder("Captured(").append(this.LFk).append(')');
    if (this.LFm) {}
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