package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.d.a.c.b.c;
import kotlin.l.b.a.b.d.a.c.e;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bh;

public final class n
  extends kotlin.l.b.a.b.b.c.b
{
  private final h aaUh;
  private final e aaVT;
  private final w aaVU;
  
  public n(h paramh, w paramw, int paramInt, kotlin.l.b.a.b.b.l paraml)
  {
    super(paramh.aaUp.aaFH, paraml, paramw.iEU(), bh.abrp, false, paramInt, an.aaKE, paramh.aaUp.aaNg);
    AppMethodBeat.i(57947);
    this.aaUh = paramh;
    this.aaVU = paramw;
    this.aaVT = new e(this.aaUh, (kotlin.l.b.a.b.d.a.e.d)this.aaVU);
    AppMethodBeat.o(57947);
  }
  
  public final void H(ab paramab)
  {
    AppMethodBeat.i(57946);
    p.k(paramab, "type");
    AppMethodBeat.o(57946);
  }
  
  public final List<ab> iGl()
  {
    AppMethodBeat.i(57945);
    Object localObject1 = this.aaVU.iHC();
    if (((Collection)localObject1).isEmpty())
    {
      localObject1 = this.aaUh.aaUp.aaIj.iFv().iDu();
      p.j(localObject1, "c.module.builtIns.anyType");
      localObject2 = this.aaUh.aaUp.aaIj.iFv().iDv();
      p.j(localObject2, "c.module.builtIns.nullableAnyType");
      localObject1 = kotlin.a.j.listOf(ac.a((aj)localObject1, (aj)localObject2));
      AppMethodBeat.o(57945);
      return localObject1;
    }
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      kotlin.l.b.a.b.d.a.e.j localj = (kotlin.l.b.a.b.d.a.e.j)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.aaUh.aaUo.a((v)localj, kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, false, (as)this, 1)));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(57945);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.n
 * JD-Core Version:    0.7.0.1
 */