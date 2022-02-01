package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.k.a.t;
import kotlin.n.n;

public final class j
  implements kotlin.l.b.a.b.k.a.b.f
{
  private final kotlin.l.b.a.b.j.e.c TvF;
  public final kotlin.l.b.a.b.j.e.c TvG;
  private final t<kotlin.l.b.a.b.e.c.a.f> TvH;
  private final boolean TvI;
  final p TvJ;
  private final String cBp;
  
  public j(p paramp, a.k paramk, kotlin.l.b.a.b.e.b.c paramc, t<kotlin.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean) {}
  
  private j(kotlin.l.b.a.b.j.e.c paramc1, kotlin.l.b.a.b.j.e.c paramc2, a.k paramk, kotlin.l.b.a.b.e.b.c paramc, t<kotlin.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean, p paramp)
  {
    AppMethodBeat.i(58204);
    this.TvF = paramc1;
    this.TvG = paramc2;
    this.TvH = paramt;
    this.TvI = paramBoolean;
    this.TvJ = paramp;
    paramc1 = (i.c)paramk;
    paramc2 = kotlin.l.b.a.b.e.c.a.TBU;
    kotlin.g.b.p.g(paramc2, "JvmProtoBuf.packageModuleName");
    paramc1 = (Integer)kotlin.l.b.a.b.e.b.f.a(paramc1, paramc2);
    if (paramc1 != null)
    {
      paramc2 = paramc.getString(((Number)paramc1).intValue());
      paramc1 = paramc2;
      if (paramc2 != null) {}
    }
    else
    {
      paramc1 = "main";
    }
    this.cBp = paramc1;
    AppMethodBeat.o(58204);
  }
  
  public final ao hBu()
  {
    AppMethodBeat.i(58203);
    ao localao = ao.ThL;
    kotlin.g.b.p.g(localao, "SourceFile.NO_SOURCE_FILE");
    AppMethodBeat.o(58203);
    return localao;
  }
  
  public final String hEl()
  {
    AppMethodBeat.i(58199);
    String str = "Class '" + hyy().hJd().sG() + '\'';
    AppMethodBeat.o(58199);
    return str;
  }
  
  public final kotlin.l.b.a.b.f.f hEm()
  {
    AppMethodBeat.i(58200);
    Object localObject = this.TvF.hKI();
    kotlin.g.b.p.g(localObject, "className.internalName");
    localObject = kotlin.l.b.a.b.f.f.btY(n.b((String)localObject, '/'));
    kotlin.g.b.p.g(localObject, "Name.identifier(classNam….substringAfterLast('/'))");
    AppMethodBeat.o(58200);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.f.a hyy()
  {
    AppMethodBeat.i(58201);
    kotlin.l.b.a.b.f.a locala = new kotlin.l.b.a.b.f.a(this.TvF.hIY(), hEm());
    AppMethodBeat.o(58201);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58202);
    String str = getClass().getSimpleName() + ": " + this.TvF;
    AppMethodBeat.o(58202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */