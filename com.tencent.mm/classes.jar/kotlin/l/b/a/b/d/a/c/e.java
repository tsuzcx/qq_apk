package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.a.g.b;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.d;
import kotlin.l.b.a.b.l.m;
import kotlin.m.f;
import kotlin.m.k;
import kotlin.m.n.b;
import kotlin.m.n.c;
import kotlin.m.r;

public final class e
  implements kotlin.l.b.a.b.b.a.g
{
  private final h aiSh;
  private final d aiSi;
  private final boolean aiSj;
  private final kotlin.l.b.a.b.l.g<a, kotlin.l.b.a.b.b.a.c> aiSk;
  
  public e(h paramh, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(192124);
    this.aiSh = paramh;
    this.aiSi = paramd;
    this.aiSj = paramBoolean;
    this.aiSk = this.aiSh.aiSp.aiBu.be((b)new a(this));
    AppMethodBeat.o(192124);
  }
  
  public final kotlin.l.b.a.b.b.a.c h(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(57748);
    s.u(paramc, "fqName");
    Object localObject = this.aiSi.m(paramc);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = (kotlin.l.b.a.b.b.a.c)((b)this.aiSk).invoke(localObject))
    {
      localObject = kotlin.l.b.a.b.d.a.a.c.aiQU;
      paramc = kotlin.l.b.a.b.d.a.a.c.a(paramc, this.aiSi, this.aiSh);
      AppMethodBeat.o(57748);
      return paramc;
    }
    AppMethodBeat.o(57748);
    return localObject;
  }
  
  public final boolean i(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(57752);
    boolean bool = g.b.b(this, paramc);
    AppMethodBeat.o(57752);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(57750);
    if ((this.aiSi.kqz().isEmpty()) && (!this.aiSi.kqA()))
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
    Object localObject1 = k.d(p.A((Iterable)this.aiSi.kqz()), (b)this.aiSk);
    Object localObject2 = kotlin.l.b.a.b.d.a.a.c.aiQU;
    localObject2 = kotlin.l.b.a.b.d.a.a.c.a(k.a.aiCV, this.aiSi, this.aiSh);
    s.u(localObject1, "$this$plus");
    localObject2 = k.as(new kotlin.m.h[] { localObject1, k.as(new Object[] { localObject2 }) });
    s.u(localObject2, "$this$flatten");
    localObject1 = (b)n.b.ajuq;
    if ((localObject2 instanceof r))
    {
      localObject2 = (r)localObject2;
      s.u(localObject1, "iterator");
    }
    for (localObject1 = (kotlin.m.h)new f(((r)localObject2).ajtX, ((r)localObject2).ajuf, (b)localObject1);; localObject1 = (kotlin.m.h)new f((kotlin.m.h)localObject2, (b)n.c.ajur, (b)localObject1))
    {
      localObject1 = k.c((kotlin.m.h)localObject1).iterator();
      AppMethodBeat.o(57749);
      return localObject1;
    }
  }
  
  static final class a
    extends u
    implements b<a, kotlin.l.b.a.b.b.a.c>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.e
 * JD-Core Version:    0.7.0.1
 */