package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.a.g.b;
import d.l.b.a.b.d.a.e.a;
import d.m.f;
import d.m.l.b;
import d.m.l.c;
import d.m.p;
import java.util.Collection;
import java.util.Iterator;

public final class e
  implements d.l.b.a.b.b.a.g
{
  private final d.l.b.a.b.l.d<a, d.l.b.a.b.b.a.c> LnC;
  private final h LnD;
  private final d.l.b.a.b.d.a.e.d LnE;
  
  public e(h paramh, d.l.b.a.b.d.a.e.d paramd)
  {
    AppMethodBeat.i(57751);
    this.LnD = paramh;
    this.LnE = paramd;
    this.LnC = this.LnD.LnL.KZf.J((d.g.a.b)new a(this));
    AppMethodBeat.o(57751);
  }
  
  public final d.l.b.a.b.b.a.c g(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57748);
    k.h(paramb, "fqName");
    Object localObject = this.LnE.l(paramb);
    if (localObject != null)
    {
      d.l.b.a.b.b.a.c localc = (d.l.b.a.b.b.a.c)((d.g.a.b)this.LnC).ay(localObject);
      localObject = localc;
      if (localc != null) {}
    }
    else
    {
      localObject = d.l.b.a.b.d.a.a.c.Lmu;
      localObject = d.l.b.a.b.d.a.a.c.a(paramb, this.LnE, this.LnD);
    }
    AppMethodBeat.o(57748);
    return localObject;
  }
  
  public final boolean h(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57752);
    k.h(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(57752);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(57750);
    if (this.LnE.fTm().isEmpty())
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
    Object localObject1 = d.m.i.d(j.t((Iterable)this.LnE.fTm()), (d.g.a.b)this.LnC);
    Object localObject2 = d.l.b.a.b.d.a.a.c.Lmu;
    localObject2 = d.l.b.a.b.a.g.KZg.KZH;
    k.g(localObject2, "KotlinBuiltIns.FQ_NAMES.deprecated");
    localObject2 = d.l.b.a.b.d.a.a.c.a((d.l.b.a.b.f.b)localObject2, this.LnE, this.LnD);
    k.h(localObject1, "$this$plus");
    localObject2 = d.m.i.ah(new d.m.h[] { localObject1, d.m.i.ah(new Object[] { localObject2 }) });
    k.h(localObject2, "$this$flatten");
    localObject1 = (d.g.a.b)l.b.LPO;
    if ((localObject2 instanceof p))
    {
      localObject2 = (p)localObject2;
      k.h(localObject1, "iterator");
    }
    for (localObject1 = (d.m.h)new f(((p)localObject2).LPy, ((p)localObject2).LPG, (d.g.a.b)localObject1);; localObject1 = (d.m.h)new f((d.m.h)localObject2, (d.g.a.b)l.c.LPP, (d.g.a.b)localObject1))
    {
      localObject1 = d.m.i.b((d.m.h)localObject1).iterator();
      AppMethodBeat.o(57749);
      return localObject1;
    }
  }
  
  static final class a
    extends l
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