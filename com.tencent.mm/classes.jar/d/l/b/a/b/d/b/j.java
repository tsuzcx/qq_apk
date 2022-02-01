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
  private final d.l.b.a.b.j.e.c NFZ;
  public final d.l.b.a.b.j.e.c NGa;
  private final t<d.l.b.a.b.e.c.a.f> NGb;
  private final boolean NGc;
  final p NGd;
  private final String coY;
  
  public j(p paramp, a.k paramk, d.l.b.a.b.e.b.c paramc, t<d.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean) {}
  
  private j(d.l.b.a.b.j.e.c paramc1, d.l.b.a.b.j.e.c paramc2, a.k paramk, d.l.b.a.b.e.b.c paramc, t<d.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean, p paramp)
  {
    AppMethodBeat.i(58204);
    this.NFZ = paramc1;
    this.NGa = paramc2;
    this.NGb = paramt;
    this.NGc = paramBoolean;
    this.NGd = paramp;
    paramc1 = (i.c)paramk;
    paramc2 = d.l.b.a.b.e.c.a.NMq;
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
    this.coY = paramc1;
    AppMethodBeat.o(58204);
  }
  
  public final d.l.b.a.b.f.a gkV()
  {
    AppMethodBeat.i(58201);
    d.l.b.a.b.f.a locala = new d.l.b.a.b.f.a(this.NFZ.gvB(), gqK());
    AppMethodBeat.o(58201);
    return locala;
  }
  
  public final ao gnS()
  {
    AppMethodBeat.i(58203);
    ao localao = ao.Nsd;
    d.g.b.p.g(localao, "SourceFile.NO_SOURCE_FILE");
    AppMethodBeat.o(58203);
    return localao;
  }
  
  public final String gqJ()
  {
    AppMethodBeat.i(58199);
    String str = "Class '" + gkV().gvG().sD() + '\'';
    AppMethodBeat.o(58199);
    return str;
  }
  
  public final d.l.b.a.b.f.f gqK()
  {
    AppMethodBeat.i(58200);
    Object localObject = this.NFZ.gxF();
    d.g.b.p.g(localObject, "className.internalName");
    localObject = d.l.b.a.b.f.f.bei(n.b((String)localObject, '/'));
    d.g.b.p.g(localObject, "Name.identifier(classNam….substringAfterLast('/'))");
    AppMethodBeat.o(58200);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58202);
    String str = getClass().getSimpleName() + ": " + this.NFZ;
    AppMethodBeat.o(58202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */