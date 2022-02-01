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
  private final d.l.b.a.b.l.d<a, d.l.b.a.b.b.a.c> NBE;
  private final h NBF;
  private final d.l.b.a.b.d.a.e.d NBG;
  
  public e(h paramh, d.l.b.a.b.d.a.e.d paramd)
  {
    AppMethodBeat.i(57751);
    this.NBF = paramh;
    this.NBG = paramd;
    this.NBE = this.NBF.NBN.Nnf.M((d.g.a.b)new a(this));
    AppMethodBeat.o(57751);
  }
  
  public final d.l.b.a.b.b.a.c g(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57748);
    d.g.b.p.h(paramb, "fqName");
    Object localObject = this.NBG.l(paramb);
    if (localObject != null)
    {
      d.l.b.a.b.b.a.c localc = (d.l.b.a.b.b.a.c)((d.g.a.b)this.NBE).invoke(localObject);
      localObject = localc;
      if (localc != null) {}
    }
    else
    {
      localObject = d.l.b.a.b.d.a.a.c.NAw;
      localObject = d.l.b.a.b.d.a.a.c.a(paramb, this.NBG, this.NBF);
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
    if (this.NBG.gpn().isEmpty())
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
    Object localObject1 = i.d(d.a.j.v((Iterable)this.NBG.gpn()), (d.g.a.b)this.NBE);
    Object localObject2 = d.l.b.a.b.d.a.a.c.NAw;
    localObject2 = d.l.b.a.b.a.g.Nng.NnH;
    d.g.b.p.g(localObject2, "KotlinBuiltIns.FQ_NAMES.deprecated");
    localObject2 = d.l.b.a.b.d.a.a.c.a((d.l.b.a.b.f.b)localObject2, this.NBG, this.NBF);
    d.g.b.p.h(localObject1, "$this$plus");
    localObject2 = i.ah(new d.m.h[] { localObject1, i.ah(new Object[] { localObject2 }) });
    d.g.b.p.h(localObject2, "$this$flatten");
    localObject1 = (d.g.a.b)l.b.OdP;
    if ((localObject2 instanceof d.m.p))
    {
      localObject2 = (d.m.p)localObject2;
      d.g.b.p.h(localObject1, "iterator");
    }
    for (localObject1 = (d.m.h)new f(((d.m.p)localObject2).Odz, ((d.m.p)localObject2).OdH, (d.g.a.b)localObject1);; localObject1 = (d.m.h)new f((d.m.h)localObject2, (d.g.a.b)l.c.OdQ, (d.g.a.b)localObject1))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.e
 * JD-Core Version:    0.7.0.1
 */