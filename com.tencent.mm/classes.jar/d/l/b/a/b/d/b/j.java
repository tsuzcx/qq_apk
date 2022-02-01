package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.ao;
import d.l.b.a.b.e.a.k;
import d.l.b.a.b.f.b;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.k.a.t;
import d.n.n;

public final class j
  implements d.l.b.a.b.k.a.b.f
{
  private final d.l.b.a.b.j.e.c NiT;
  public final d.l.b.a.b.j.e.c NiU;
  private final t<d.l.b.a.b.e.c.a.f> NiV;
  private final boolean NiW;
  final p NiX;
  private final String coW;
  
  public j(p paramp, a.k paramk, d.l.b.a.b.e.b.c paramc, t<d.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean) {}
  
  private j(d.l.b.a.b.j.e.c paramc1, d.l.b.a.b.j.e.c paramc2, a.k paramk, d.l.b.a.b.e.b.c paramc, t<d.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean, p paramp)
  {
    AppMethodBeat.i(58204);
    this.NiT = paramc1;
    this.NiU = paramc2;
    this.NiV = paramt;
    this.NiW = paramBoolean;
    this.NiX = paramp;
    paramc1 = (i.c)paramk;
    paramc2 = d.l.b.a.b.e.c.a.Npk;
    d.g.b.p.g(paramc2, "JvmProtoBuf.packageModuleName");
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
    this.coW = paramc1;
    AppMethodBeat.o(58204);
  }
  
  public final d.l.b.a.b.f.a ggt()
  {
    AppMethodBeat.i(58201);
    d.l.b.a.b.f.a locala = new d.l.b.a.b.f.a(this.NiT.gqZ(), gmi());
    AppMethodBeat.o(58201);
    return locala;
  }
  
  public final ao gjq()
  {
    AppMethodBeat.i(58203);
    ao localao = ao.MUY;
    d.g.b.p.g(localao, "SourceFile.NO_SOURCE_FILE");
    AppMethodBeat.o(58203);
    return localao;
  }
  
  public final String gmh()
  {
    AppMethodBeat.i(58199);
    String str = "Class '" + ggt().gre().sD() + '\'';
    AppMethodBeat.o(58199);
    return str;
  }
  
  public final d.l.b.a.b.f.f gmi()
  {
    AppMethodBeat.i(58200);
    Object localObject = this.NiT.gtd();
    d.g.b.p.g(localObject, "className.internalName");
    localObject = d.l.b.a.b.f.f.bcE(n.b((String)localObject, '/'));
    d.g.b.p.g(localObject, "Name.identifier(classNam….substringAfterLast('/'))");
    AppMethodBeat.o(58200);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58202);
    String str = getClass().getSimpleName() + ": " + this.NiT;
    AppMethodBeat.o(58202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */