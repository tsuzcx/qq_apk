package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.a.g.b;
import d.l.b.a.b.d.a.e.a;
import d.m.f;
import d.m.i;
import d.m.l.b;
import d.m.l.c;
import java.util.Collection;
import java.util.Iterator;

public final class e
  implements d.l.b.a.b.b.a.g
{
  private final h NeA;
  private final d.l.b.a.b.d.a.e.d NeB;
  private final d.l.b.a.b.l.d<a, d.l.b.a.b.b.a.c> Nez;
  
  public e(h paramh, d.l.b.a.b.d.a.e.d paramd)
  {
    AppMethodBeat.i(57751);
    this.NeA = paramh;
    this.NeB = paramd;
    this.Nez = this.NeA.NeI.MQa.J((d.g.a.b)new a(this));
    AppMethodBeat.o(57751);
  }
  
  public final d.l.b.a.b.b.a.c g(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57748);
    d.g.b.p.h(paramb, "fqName");
    Object localObject = this.NeB.l(paramb);
    if (localObject != null)
    {
      d.l.b.a.b.b.a.c localc = (d.l.b.a.b.b.a.c)((d.g.a.b)this.Nez).invoke(localObject);
      localObject = localc;
      if (localc != null) {}
    }
    else
    {
      localObject = d.l.b.a.b.d.a.a.c.Ndr;
      localObject = d.l.b.a.b.d.a.a.c.a(paramb, this.NeB, this.NeA);
    }
    AppMethodBeat.o(57748);
    return localObject;
  }
  
  public final boolean h(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57752);
    d.g.b.p.h(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(57752);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(57750);
    if (this.NeB.gkL().isEmpty())
    {
      AppMethodBeat.o(57750);
      return true;
    }
    AppMethodBeat.o(57750);
    return false;
  }
  
  public final Iterator<d.l.b.a.b.b.a.c> iterator()
  {
    AppMethodBeat.i(57749);
    Object localObject1 = i.d(d.a.j.v((Iterable)this.NeB.gkL()), (d.g.a.b)this.Nez);
    Object localObject2 = d.l.b.a.b.d.a.a.c.Ndr;
    localObject2 = d.l.b.a.b.a.g.MQb.MQC;
    d.g.b.p.g(localObject2, "KotlinBuiltIns.FQ_NAMES.deprecated");
    localObject2 = d.l.b.a.b.d.a.a.c.a((d.l.b.a.b.f.b)localObject2, this.NeB, this.NeA);
    d.g.b.p.h(localObject1, "$this$plus");
    localObject2 = i.ai(new d.m.h[] { localObject1, i.ai(new Object[] { localObject2 }) });
    d.g.b.p.h(localObject2, "$this$flatten");
    localObject1 = (d.g.a.b)l.b.NGJ;
    if ((localObject2 instanceof d.m.p))
    {
      localObject2 = (d.m.p)localObject2;
      d.g.b.p.h(localObject1, "iterator");
    }
    for (localObject1 = (d.m.h)new f(((d.m.p)localObject2).NGt, ((d.m.p)localObject2).NGB, (d.g.a.b)localObject1);; localObject1 = (d.m.h)new f((d.m.h)localObject2, (d.g.a.b)l.c.NGK, (d.g.a.b)localObject1))
    {
      localObject1 = i.b((d.m.h)localObject1).iterator();
      AppMethodBeat.o(57749);
      return localObject1;
    }
  }
  
  static final class a
    extends q
    implements d.g.a.b<a, d.l.b.a.b.b.a.c>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.e
 * JD-Core Version:    0.7.0.1
 */