package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.aw;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.j.e.d;
import kotlin.l.b.a.b.k.a.b.g;
import kotlin.n.n;

public final class i
  implements g
{
  private final d aiWG;
  public final d aiWH;
  private final kotlin.l.b.a.b.k.a.s<kotlin.l.b.a.b.e.c.a.e> aiWI;
  private final boolean aiWJ;
  private final kotlin.l.b.a.b.k.a.b.f aiWK;
  public final o aiWL;
  private final String esT;
  
  public i(o paramo, a.k paramk, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.k.a.s<kotlin.l.b.a.b.e.c.a.e> params, boolean paramBoolean, kotlin.l.b.a.b.k.a.b.f paramf) {}
  
  private i(d paramd1, d paramd2, a.k paramk, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.k.a.s<kotlin.l.b.a.b.e.c.a.e> params, boolean paramBoolean, kotlin.l.b.a.b.k.a.b.f paramf, o paramo)
  {
    AppMethodBeat.i(191933);
    this.aiWG = paramd1;
    this.aiWH = paramd2;
    this.aiWI = params;
    this.aiWJ = paramBoolean;
    this.aiWK = paramf;
    this.aiWL = paramo;
    paramd1 = (i.c)paramk;
    paramd2 = a.ajdv;
    kotlin.g.b.s.s(paramd2, "packageModuleName");
    paramd1 = (Integer)kotlin.l.b.a.b.e.b.e.a(paramd1, paramd2);
    if (paramd1 == null) {
      paramd1 = "main";
    }
    for (;;)
    {
      this.esT = paramd1;
      AppMethodBeat.o(191933);
      return;
      paramd2 = paramc.getString(((Number)paramd1).intValue());
      paramd1 = paramd2;
      if (paramd2 == null) {
        paramd1 = "main";
      }
    }
  }
  
  public final b kmb()
  {
    AppMethodBeat.i(58201);
    b localb = new b(this.aiWG.kxL(), ksN());
    AppMethodBeat.o(58201);
    return localb;
  }
  
  public final aw kpk()
  {
    AppMethodBeat.i(58203);
    aw localaw = aw.aiHv;
    kotlin.g.b.s.s(localaw, "NO_SOURCE_FILE");
    AppMethodBeat.o(58203);
    return localaw;
  }
  
  public final String ksM()
  {
    AppMethodBeat.i(58199);
    String str = "Class '" + kmb().kxQ().PF() + '\'';
    AppMethodBeat.o(58199);
    return str;
  }
  
  public final kotlin.l.b.a.b.f.f ksN()
  {
    AppMethodBeat.i(58200);
    Object localObject = this.aiWG.kzr();
    kotlin.g.b.s.s(localObject, "className.internalName");
    localObject = kotlin.l.b.a.b.f.f.bJe(n.c((String)localObject, '/'));
    kotlin.g.b.s.s(localObject, "identifier(className.int….substringAfterLast('/'))");
    AppMethodBeat.o(58200);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58202);
    String str = getClass().getSimpleName() + ": " + this.aiWG;
    AppMethodBeat.o(58202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */