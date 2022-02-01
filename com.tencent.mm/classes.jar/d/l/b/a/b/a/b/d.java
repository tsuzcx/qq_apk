package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.g.b.p;
import d.g.b.q;
import d.g.b.z;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.c.h;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.c;
import d.l.b.a.b.l.i;
import d.l.b.a.b.l.j;
import d.l.k;
import java.util.Collection;

public final class d
  implements d.l.b.a.b.b.b.b
{
  private static final d.l.b.a.b.f.a NqA;
  public static final a NqB;
  private static final d.l.b.a.b.f.b Nqy;
  private static final d.l.b.a.b.f.f Nqz;
  private final d.l.b.a.b.l.f Nqv;
  private final y Nqw;
  private final d.g.a.b<y, l> Nqx;
  
  static
  {
    AppMethodBeat.i(56771);
    cxA = new k[] { (k)z.a(new d.g.b.x(z.bp(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;")) };
    NqB = new a((byte)0);
    Nqy = g.NmV;
    Object localObject = g.Nng.Nnm.gvJ();
    p.g(localObject, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
    Nqz = (d.l.b.a.b.f.f)localObject;
    localObject = d.l.b.a.b.f.a.p(g.Nng.Nnm.gvM());
    p.g(localObject, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
    NqA = (d.l.b.a.b.f.a)localObject;
    AppMethodBeat.o(56771);
  }
  
  private d(final j paramj, y paramy, d.g.a.b<? super y, ? extends l> paramb)
  {
    AppMethodBeat.i(56776);
    this.Nqw = paramy;
    this.Nqx = paramb;
    this.Nqv = paramj.S((d.g.a.a)new b(this, paramj));
    AppMethodBeat.o(56776);
  }
  
  private final h gmA()
  {
    AppMethodBeat.i(56772);
    h localh = (h)i.a(this.Nqv, cxA[0]);
    AppMethodBeat.o(56772);
    return localh;
  }
  
  public final boolean a(d.l.b.a.b.f.b paramb, d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56773);
    p.h(paramb, "packageFqName");
    p.h(paramf, "name");
    if ((p.i(paramf, Nqz)) && (p.i(paramb, Nqy)))
    {
      AppMethodBeat.o(56773);
      return true;
    }
    AppMethodBeat.o(56773);
    return false;
  }
  
  public final e b(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56774);
    p.h(parama, "classId");
    if (p.i(parama, NqA))
    {
      parama = (e)gmA();
      AppMethodBeat.o(56774);
      return parama;
    }
    AppMethodBeat.o(56774);
    return null;
  }
  
  public final Collection<e> b(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56775);
    p.h(paramb, "packageFqName");
    if (p.i(paramb, Nqy))
    {
      paramb = (Collection)ak.setOf(gmA());
      AppMethodBeat.o(56775);
      return paramb;
    }
    paramb = (Collection)d.a.x.NhJ;
    AppMethodBeat.o(56775);
    return paramb;
  }
  
  public static final class a {}
  
  static final class b
    extends q
    implements d.g.a.a<h>
  {
    b(d paramd, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */