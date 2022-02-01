package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ab;
import kotlin.a.ad;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g.c.b;
import kotlin.l.b.a.b.j.g.i;
import kotlin.l.b.a.b.o.a;

public final class ag
  extends i
{
  private final ae aiFr;
  private final c aiIl;
  
  public ag(ae paramae, c paramc)
  {
    AppMethodBeat.i(57295);
    this.aiFr = paramae;
    this.aiIl = paramc;
    AppMethodBeat.o(57295);
  }
  
  public final Collection<l> a(kotlin.l.b.a.b.j.g.d paramd, b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57294);
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    Object localObject = kotlin.l.b.a.b.j.g.d.ajkC;
    if (!paramd.aMn(kotlin.l.b.a.b.j.g.d.kzD()))
    {
      paramd = (Collection)ab.aivy;
      AppMethodBeat.o(57294);
      return paramd;
    }
    if ((this.aiIl.ajex.ajeC.isEmpty()) && (paramd.ajkD.contains(c.b.ajkB)))
    {
      paramd = (Collection)ab.aivy;
      AppMethodBeat.o(57294);
      return paramd;
    }
    paramd = this.aiFr.a(this.aiIl, paramb);
    ArrayList localArrayList = new ArrayList(paramd.size());
    Iterator localIterator = paramd.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((c)localIterator.next()).kxT();
      s.s(localObject, "subFqName.shortName()");
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        Collection localCollection = (Collection)localArrayList;
        s.u(localObject, "name");
        if (((f)localObject).ajeG) {
          paramd = null;
        }
        for (;;)
        {
          a.c(localCollection, paramd);
          break;
          paramd = this.aiFr;
          localObject = this.aiIl.q((f)localObject);
          s.s(localObject, "fqName.child(name)");
          localObject = paramd.e((c)localObject);
          paramd = (kotlin.l.b.a.b.j.g.d)localObject;
          if (((al)localObject).isEmpty()) {
            paramd = null;
          }
        }
      }
    }
    paramd = (Collection)localArrayList;
    AppMethodBeat.o(57294);
    return paramd;
  }
  
  public final Set<f> kpM()
  {
    return (Set)ad.aivA;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191890);
    String str = "subpackages of " + this.aiIl + " from " + this.aiFr;
    AppMethodBeat.o(191890);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ag
 * JD-Core Version:    0.7.0.1
 */