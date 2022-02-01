package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.y;
import d.l.b.a.b.d.a.c.b.c;
import d.l.b.a.b.d.a.c.e;
import d.l.b.a.b.d.a.c.h;
import d.l.b.a.b.d.a.e.v;
import d.l.b.a.b.d.a.e.w;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class n
  extends d.l.b.a.b.b.c.b
{
  private final h JAk;
  private final e JBX;
  private final w JBY;
  
  public n(h paramh, w paramw, int paramInt, d.l.b.a.b.b.l paraml)
  {
    super(paramh.JAs.JlL, paraml, paramw.fyB(), bh.JYC, false, paramInt, an.JqJ, paramh.JAs.Jtj);
    AppMethodBeat.i(57947);
    this.JAk = paramh;
    this.JBY = paramw;
    this.JBX = new e(this.JAk, (d.l.b.a.b.d.a.e.d)this.JBY);
    AppMethodBeat.o(57947);
  }
  
  public final void I(ab paramab)
  {
    AppMethodBeat.i(57946);
    k.h(paramab, "type");
    AppMethodBeat.o(57946);
  }
  
  public final List<ab> fzQ()
  {
    AppMethodBeat.i(57945);
    Object localObject1 = this.JBY.fBb();
    if (((Collection)localObject1).isEmpty())
    {
      localObject1 = this.JAk.JAs.Jon.fza().fxb();
      k.g(localObject1, "c.module.builtIns.anyType");
      localObject2 = this.JAk.JAs.Jon.fza().fxc();
      k.g(localObject2, "c.module.builtIns.nullableAnyType");
      localObject1 = d.a.j.listOf(ac.a((aj)localObject1, (aj)localObject2));
      AppMethodBeat.o(57945);
      return localObject1;
    }
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      d.l.b.a.b.d.a.e.j localj = (d.l.b.a.b.d.a.e.j)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.JAk.JAr.a((v)localj, d.l.b.a.b.d.a.c.b.d.a(d.l.b.a.b.d.a.a.l.Jzs, false, (as)this, 1)));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(57945);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.n
 * JD-Core Version:    0.7.0.1
 */