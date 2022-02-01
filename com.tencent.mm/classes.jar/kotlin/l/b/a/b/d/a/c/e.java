package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.a.g.b;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.m.f;
import kotlin.m.i;
import kotlin.m.l.b;
import kotlin.m.l.c;

public final class e
  implements kotlin.l.b.a.b.b.a.g
{
  private final kotlin.l.b.a.b.l.d<a, kotlin.l.b.a.b.b.a.c> Trm;
  private final h Trn;
  private final kotlin.l.b.a.b.d.a.e.d Tro;
  
  public e(h paramh, kotlin.l.b.a.b.d.a.e.d paramd)
  {
    AppMethodBeat.i(57751);
    this.Trn = paramh;
    this.Tro = paramd;
    this.Trm = this.Trn.Trv.TcN.V((kotlin.g.a.b)new a(this));
    AppMethodBeat.o(57751);
  }
  
  public final kotlin.l.b.a.b.b.a.c g(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57748);
    kotlin.g.b.p.h(paramb, "fqName");
    Object localObject = this.Tro.l(paramb);
    if (localObject != null)
    {
      kotlin.l.b.a.b.b.a.c localc = (kotlin.l.b.a.b.b.a.c)((kotlin.g.a.b)this.Trm).invoke(localObject);
      localObject = localc;
      if (localc != null) {}
    }
    else
    {
      localObject = kotlin.l.b.a.b.d.a.a.c.Tqe;
      localObject = kotlin.l.b.a.b.d.a.a.c.a(paramb, this.Tro, this.Trn);
    }
    AppMethodBeat.o(57748);
    return localObject;
  }
  
  public final boolean h(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57752);
    kotlin.g.b.p.h(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(57752);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(57750);
    if (this.Tro.hCP().isEmpty())
    {
      AppMethodBeat.o(57750);
      return true;
    }
    AppMethodBeat.o(57750);
    return false;
  }
  
  public final Iterator<kotlin.l.b.a.b.b.a.c> iterator()
  {
    AppMethodBeat.i(57749);
    Object localObject1 = i.d(kotlin.a.j.z((Iterable)this.Tro.hCP()), (kotlin.g.a.b)this.Trm);
    Object localObject2 = kotlin.l.b.a.b.d.a.a.c.Tqe;
    localObject2 = kotlin.l.b.a.b.a.g.TcO.Tdp;
    kotlin.g.b.p.g(localObject2, "KotlinBuiltIns.FQ_NAMES.deprecated");
    localObject2 = kotlin.l.b.a.b.d.a.a.c.a((kotlin.l.b.a.b.f.b)localObject2, this.Tro, this.Trn);
    kotlin.g.b.p.h(localObject1, "$this$plus");
    localObject2 = i.aj(new kotlin.m.h[] { localObject1, i.aj(new Object[] { localObject2 }) });
    kotlin.g.b.p.h(localObject2, "$this$flatten");
    localObject1 = (kotlin.g.a.b)l.b.TSJ;
    if ((localObject2 instanceof kotlin.m.p))
    {
      localObject2 = (kotlin.m.p)localObject2;
      kotlin.g.b.p.h(localObject1, "iterator");
    }
    for (localObject1 = (kotlin.m.h)new f(((kotlin.m.p)localObject2).TSt, ((kotlin.m.p)localObject2).TSB, (kotlin.g.a.b)localObject1);; localObject1 = (kotlin.m.h)new f((kotlin.m.h)localObject2, (kotlin.g.a.b)l.c.TSK, (kotlin.g.a.b)localObject1))
    {
      localObject1 = i.b((kotlin.m.h)localObject1).iterator();
      AppMethodBeat.o(57749);
      return localObject1;
    }
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<a, kotlin.l.b.a.b.b.a.c>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.e
 * JD-Core Version:    0.7.0.1
 */