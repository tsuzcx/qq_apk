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
  private final kotlin.l.b.a.b.j.e.c aaYv;
  public final kotlin.l.b.a.b.j.e.c aaYw;
  private final t<kotlin.l.b.a.b.e.c.a.f> aaYx;
  private final boolean aaYy;
  final p aaYz;
  private final String cAy;
  
  public j(p paramp, a.k paramk, kotlin.l.b.a.b.e.b.c paramc, t<kotlin.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean) {}
  
  private j(kotlin.l.b.a.b.j.e.c paramc1, kotlin.l.b.a.b.j.e.c paramc2, a.k paramk, kotlin.l.b.a.b.e.b.c paramc, t<kotlin.l.b.a.b.e.c.a.f> paramt, boolean paramBoolean, p paramp)
  {
    AppMethodBeat.i(58204);
    this.aaYv = paramc1;
    this.aaYw = paramc2;
    this.aaYx = paramt;
    this.aaYy = paramBoolean;
    this.aaYz = paramp;
    paramc1 = (i.c)paramk;
    paramc2 = kotlin.l.b.a.b.e.c.a.abeI;
    kotlin.g.b.p.j(paramc2, "JvmProtoBuf.packageModuleName");
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
    this.cAy = paramc1;
    AppMethodBeat.o(58204);
  }
  
  public final kotlin.l.b.a.b.f.a iCJ()
  {
    AppMethodBeat.i(58201);
    kotlin.l.b.a.b.f.a locala = new kotlin.l.b.a.b.f.a(this.aaYv.iNs(), iIG());
    AppMethodBeat.o(58201);
    return locala;
  }
  
  public final ao iFJ()
  {
    AppMethodBeat.i(58203);
    ao localao = ao.aaKF;
    kotlin.g.b.p.j(localao, "SourceFile.NO_SOURCE_FILE");
    AppMethodBeat.o(58203);
    return localao;
  }
  
  public final String iIF()
  {
    AppMethodBeat.i(58199);
    String str = "Class '" + iCJ().iNx().qu() + '\'';
    AppMethodBeat.o(58199);
    return str;
  }
  
  public final kotlin.l.b.a.b.f.f iIG()
  {
    AppMethodBeat.i(58200);
    Object localObject = this.aaYv.iOY();
    kotlin.g.b.p.j(localObject, "className.internalName");
    localObject = kotlin.l.b.a.b.f.f.bHb(n.b((String)localObject, '/'));
    kotlin.g.b.p.j(localObject, "Name.identifier(classNam….substringAfterLast('/'))");
    AppMethodBeat.o(58200);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58202);
    String str = getClass().getSimpleName() + ": " + this.aaYv;
    AppMethodBeat.o(58202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */