package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
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
  private final y Jpd;
  private final d.l.b.a.b.f.b JrG;
  
  public af(y paramy, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57295);
    this.Jpd = paramy;
    this.JrG = paramb;
    AppMethodBeat.o(57295);
  }
  
  public final Collection<l> a(d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57294);
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    Object localObject = d.JTw;
    if (!paramd.afP(d.fJl()))
    {
      paramd = (Collection)v.Jgl;
      AppMethodBeat.o(57294);
      return paramd;
    }
    if ((this.JrG.JLQ.JLV.isEmpty()) && (paramd.JSY.contains(c.b.JSW)))
    {
      paramd = (Collection)v.Jgl;
      AppMethodBeat.o(57294);
      return paramd;
    }
    paramd = this.Jpd.a(this.JrG, paramb);
    ArrayList localArrayList = new ArrayList(paramd.size());
    Iterator localIterator = paramd.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((d.l.b.a.b.f.b)localIterator.next()).fHe();
      k.g(localObject, "subFqName.shortName()");
      if (((Boolean)paramb.aA(localObject)).booleanValue())
      {
        Collection localCollection = (Collection)localArrayList;
        k.h(localObject, "name");
        if (((f)localObject).JLZ) {
          paramd = null;
        }
        for (;;)
        {
          a.c(localCollection, paramd);
          break;
          paramd = this.Jpd;
          localObject = this.JrG.p((f)localObject);
          k.g(localObject, "fqName.child(name)");
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