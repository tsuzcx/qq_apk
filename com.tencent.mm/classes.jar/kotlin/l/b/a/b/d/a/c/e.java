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
  private final kotlin.l.b.a.b.l.d<a, kotlin.l.b.a.b.b.a.c> aaUg;
  private final h aaUh;
  private final kotlin.l.b.a.b.d.a.e.d aaUi;
  
  public e(h paramh, kotlin.l.b.a.b.d.a.e.d paramd)
  {
    AppMethodBeat.i(57751);
    this.aaUh = paramh;
    this.aaUi = paramd;
    this.aaUg = this.aaUh.aaUp.aaFH.al((kotlin.g.a.b)new a(this));
    AppMethodBeat.o(57751);
  }
  
  public final kotlin.l.b.a.b.b.a.c g(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57748);
    kotlin.g.b.p.k(paramb, "fqName");
    Object localObject = this.aaUi.l(paramb);
    if (localObject != null)
    {
      kotlin.l.b.a.b.b.a.c localc = (kotlin.l.b.a.b.b.a.c)((kotlin.g.a.b)this.aaUg).invoke(localObject);
      localObject = localc;
      if (localc != null) {}
    }
    else
    {
      localObject = kotlin.l.b.a.b.d.a.a.c.aaSY;
      localObject = kotlin.l.b.a.b.d.a.a.c.a(paramb, this.aaUi, this.aaUh);
    }
    AppMethodBeat.o(57748);
    return localObject;
  }
  
  public final boolean h(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57752);
    kotlin.g.b.p.k(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(57752);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(57750);
    if (this.aaUi.iHj().isEmpty())
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
    Object localObject1 = i.d(kotlin.a.j.z((Iterable)this.aaUi.iHj()), (kotlin.g.a.b)this.aaUg);
    Object localObject2 = kotlin.l.b.a.b.d.a.a.c.aaSY;
    localObject2 = kotlin.l.b.a.b.a.g.aaFI.aaGj;
    kotlin.g.b.p.j(localObject2, "KotlinBuiltIns.FQ_NAMES.deprecated");
    localObject2 = kotlin.l.b.a.b.d.a.a.c.a((kotlin.l.b.a.b.f.b)localObject2, this.aaUi, this.aaUh);
    kotlin.g.b.p.k(localObject1, "$this$plus");
    localObject2 = i.an(new kotlin.m.h[] { localObject1, i.an(new Object[] { localObject2 }) });
    kotlin.g.b.p.k(localObject2, "$this$flatten");
    localObject1 = (kotlin.g.a.b)l.b.abvi;
    if ((localObject2 instanceof kotlin.m.p))
    {
      localObject2 = (kotlin.m.p)localObject2;
      kotlin.g.b.p.k(localObject1, "iterator");
    }
    for (localObject1 = (kotlin.m.h)new f(((kotlin.m.p)localObject2).abuS, ((kotlin.m.p)localObject2).abva, (kotlin.g.a.b)localObject1);; localObject1 = (kotlin.m.h)new f((kotlin.m.h)localObject2, (kotlin.g.a.b)l.c.abvj, (kotlin.g.a.b)localObject1))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.e
 * JD-Core Version:    0.7.0.1
 */