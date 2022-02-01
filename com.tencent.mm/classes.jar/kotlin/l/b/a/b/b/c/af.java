package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.c.b;
import kotlin.l.b.a.b.j.f.d;
import kotlin.l.b.a.b.j.f.i;
import kotlin.l.b.a.b.o.a;

public final class af
  extends i
{
  private final y aaIY;
  private final kotlin.l.b.a.b.f.b aaLC;
  
  public af(y paramy, kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57295);
    this.aaIY = paramy;
    this.aaLC = paramb;
    AppMethodBeat.o(57295);
  }
  
  public final Collection<l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57294);
    p.k(paramd, "kindFilter");
    p.k(paramb, "nameFilter");
    Object localObject = d.abms;
    if (!paramd.aFz(d.iPi()))
    {
      paramd = (Collection)v.aaAd;
      AppMethodBeat.o(57294);
      return paramd;
    }
    if ((this.aaLC.abfE.abfJ.isEmpty()) && (paramd.ablU.contains(c.b.ablS)))
    {
      paramd = (Collection)v.aaAd;
      AppMethodBeat.o(57294);
      return paramd;
    }
    paramd = this.aaIY.a(this.aaLC, paramb);
    ArrayList localArrayList = new ArrayList(paramd.size());
    Iterator localIterator = paramd.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((kotlin.l.b.a.b.f.b)localIterator.next()).iNA();
      p.j(localObject, "subFqName.shortName()");
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        Collection localCollection = (Collection)localArrayList;
        p.k(localObject, "name");
        if (((f)localObject).abfN) {
          paramd = null;
        }
        for (;;)
        {
          a.c(localCollection, paramd);
          break;
          paramd = this.aaIY;
          localObject = this.aaLC.p((f)localObject);
          p.j(localObject, "fqName.child(name)");
          localObject = paramd.e((kotlin.l.b.a.b.f.b)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.af
 * JD-Core Version:    0.7.0.1
 */