package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.ao;
import d.l.b.a.b.e.a.k;
import d.l.b.a.b.f.b;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.k.a.t;
import d.n.n;

public final class j
  implements d.l.b.a.b.k.a.b.f
{
  private final d.l.b.a.b.j.e.c LrW;
  public final d.l.b.a.b.j.e.c LrX;
  private final t<d.l.b.a.b.e.c.a.f> LrY;
  private final boolean LrZ;
  final p Lsa;
  private final String ceF;
  
  public j(p paramp, a.k paramk, d.l.b.a.b.e.b.c paramc, t<d.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean) {}
  
  private j(d.l.b.a.b.j.e.c paramc1, d.l.b.a.b.j.e.c paramc2, a.k paramk, d.l.b.a.b.e.b.c paramc, t<d.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean, p paramp)
  {
    AppMethodBeat.i(58204);
    this.LrW = paramc1;
    this.LrX = paramc2;
    this.LrY = paramt;
    this.LrZ = paramBoolean;
    this.Lsa = paramp;
    paramc1 = (i.c)paramk;
    paramc2 = d.l.b.a.b.e.c.a.Lyn;
    k.g(paramc2, "JvmProtoBuf.packageModuleName");
    paramc1 = (Integer)d.l.b.a.b.e.b.f.a(paramc1, paramc2);
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
    this.ceF = paramc1;
    AppMethodBeat.o(58204);
  }
  
  public final d.l.b.a.b.f.a fOT()
  {
    AppMethodBeat.i(58201);
    d.l.b.a.b.f.a locala = new d.l.b.a.b.f.a(this.LrW.fZA(), fUJ());
    AppMethodBeat.o(58201);
    return locala;
  }
  
  public final ao fRR()
  {
    AppMethodBeat.i(58203);
    ao localao = ao.Led;
    k.g(localao, "SourceFile.NO_SOURCE_FILE");
    AppMethodBeat.o(58203);
    return localao;
  }
  
  public final String fUI()
  {
    AppMethodBeat.i(58199);
    String str = "Class '" + fOT().fZF().rf() + '\'';
    AppMethodBeat.o(58199);
    return str;
  }
  
  public final d.l.b.a.b.f.f fUJ()
  {
    AppMethodBeat.i(58200);
    Object localObject = this.LrW.gbE();
    k.g(localObject, "className.internalName");
    localObject = d.l.b.a.b.f.f.aWB(n.b((String)localObject, '/'));
    k.g(localObject, "Name.identifier(classNam….substringAfterLast('/'))");
    AppMethodBeat.o(58200);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58202);
    String str = getClass().getSimpleName() + ": " + this.LrW;
    AppMethodBeat.o(58202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */