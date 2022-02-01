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
  private final d.l.b.a.b.j.e.c JED;
  public final d.l.b.a.b.j.e.c JEE;
  private final t<d.l.b.a.b.e.c.a.f> JEF;
  private final boolean JEG;
  final p JEH;
  private final String chK;
  
  public j(p paramp, a.k paramk, d.l.b.a.b.e.b.c paramc, t<d.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean) {}
  
  private j(d.l.b.a.b.j.e.c paramc1, d.l.b.a.b.j.e.c paramc2, a.k paramk, d.l.b.a.b.e.b.c paramc, t<d.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean, p paramp)
  {
    AppMethodBeat.i(58204);
    this.JED = paramc1;
    this.JEE = paramc2;
    this.JEF = paramt;
    this.JEG = paramBoolean;
    this.JEH = paramp;
    paramc1 = (i.c)paramk;
    paramc2 = d.l.b.a.b.e.c.a.JKU;
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
    this.chK = paramc1;
    AppMethodBeat.o(58204);
  }
  
  public final String fCe()
  {
    AppMethodBeat.i(58199);
    String str = "Class '" + fwp().fHb().qV() + '\'';
    AppMethodBeat.o(58199);
    return str;
  }
  
  public final d.l.b.a.b.f.f fCf()
  {
    AppMethodBeat.i(58200);
    Object localObject = this.JED.fJb();
    k.g(localObject, "className.internalName");
    localObject = d.l.b.a.b.f.f.aQC(n.a((String)localObject, '/'));
    k.g(localObject, "Name.identifier(classNam….substringAfterLast('/'))");
    AppMethodBeat.o(58200);
    return localObject;
  }
  
  public final d.l.b.a.b.f.a fwp()
  {
    AppMethodBeat.i(58201);
    d.l.b.a.b.f.a locala = new d.l.b.a.b.f.a(this.JED.fGW(), fCf());
    AppMethodBeat.o(58201);
    return locala;
  }
  
  public final ao fzn()
  {
    AppMethodBeat.i(58203);
    ao localao = ao.JqK;
    k.g(localao, "SourceFile.NO_SOURCE_FILE");
    AppMethodBeat.o(58203);
    return localao;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58202);
    String str = getClass().getSimpleName() + ": " + this.JED;
    AppMethodBeat.o(58202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */