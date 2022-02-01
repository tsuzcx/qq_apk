package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.p;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.c;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.f.c.b;
import d.l.b.a.b.j.f.d;
import d.l.b.a.b.j.f.i;
import d.l.b.a.b.o.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class af
  extends i
{
  private final y MTr;
  private final d.l.b.a.b.f.b MVU;
  
  public af(y paramy, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57295);
    this.MTr = paramy;
    this.MVU = paramb;
    AppMethodBeat.o(57295);
  }
  
  public final Collection<l> a(d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57294);
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    Object localObject = d.NxN;
    if (!paramd.alm(d.gtn()))
    {
      paramd = (Collection)v.MKE;
      AppMethodBeat.o(57294);
      return paramd;
    }
    if ((this.MVU.Nqg.Nql.isEmpty()) && (paramd.Nxp.contains(c.b.Nxn)))
    {
      paramd = (Collection)v.MKE;
      AppMethodBeat.o(57294);
      return paramd;
    }
    paramd = this.MTr.a(this.MVU, paramb);
    ArrayList localArrayList = new ArrayList(paramd.size());
    Iterator localIterator = paramd.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((d.l.b.a.b.f.b)localIterator.next()).grh();
      p.g(localObject, "subFqName.shortName()");
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        Collection localCollection = (Collection)localArrayList;
        p.h(localObject, "name");
        if (((f)localObject).Nqp) {
          paramd = null;
        }
        for (;;)
        {
          a.c(localCollection, paramd);
          break;
          paramd = this.MTr;
          localObject = this.MVU.p((f)localObject);
          p.g(localObject, "fqName.child(name)");
          localObject = paramd.e((d.l.b.a.b.f.b)localObject);
          paramd = (d)localObject;
          if (((ad)localObject).isEmpty()) {
            paramd = null;
          }
        }
      }
    }
    paramd = (Collection)localArrayList;
    AppMethodBeat.o(57294);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.af
 * JD-Core Version:    0.7.0.1
 */