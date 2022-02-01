package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.a.x;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.c;
import d.l.b.a.b.l.i;
import java.util.Collection;

public final class d
  implements d.l.b.a.b.b.b.b
{
  private static final d.l.b.a.b.f.a LcA;
  public static final a LcB;
  private static final d.l.b.a.b.f.b Lcy;
  private static final d.l.b.a.b.f.f Lcz;
  private final d.l.b.a.b.l.f Lcv;
  private final y Lcw;
  private final d.g.a.b<y, d.l.b.a.b.b.l> Lcx;
  
  static
  {
    AppMethodBeat.i(56771);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;")) };
    LcB = new a((byte)0);
    Lcy = g.KYV;
    Object localObject = g.KZg.KZm.fZI();
    d.g.b.k.g(localObject, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
    Lcz = (d.l.b.a.b.f.f)localObject;
    localObject = d.l.b.a.b.f.a.p(g.KZg.KZm.fZL());
    d.g.b.k.g(localObject, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
    LcA = (d.l.b.a.b.f.a)localObject;
    AppMethodBeat.o(56771);
  }
  
  private d(final i parami, y paramy, d.g.a.b<? super y, ? extends d.l.b.a.b.b.l> paramb)
  {
    AppMethodBeat.i(56776);
    this.Lcw = paramy;
    this.Lcx = paramb;
    this.Lcv = parami.O((d.g.a.a)new b(this, parami));
    AppMethodBeat.o(56776);
  }
  
  private final d.l.b.a.b.b.c.h fQA()
  {
    AppMethodBeat.i(56772);
    d.l.b.a.b.b.c.h localh = (d.l.b.a.b.b.c.h)d.l.b.a.b.l.h.a(this.Lcv, $$delegatedProperties[0]);
    AppMethodBeat.o(56772);
    return localh;
  }
  
  public final boolean a(d.l.b.a.b.f.b paramb, d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56773);
    d.g.b.k.h(paramb, "packageFqName");
    d.g.b.k.h(paramf, "name");
    if ((d.g.b.k.g(paramf, Lcz)) && (d.g.b.k.g(paramb, Lcy)))
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
    d.g.b.k.h(parama, "classId");
    if (d.g.b.k.g(parama, LcA))
    {
      parama = (e)fQA();
      AppMethodBeat.o(56774);
      return parama;
    }
    AppMethodBeat.o(56774);
    return null;
  }
  
  public final Collection<e> b(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56775);
    d.g.b.k.h(paramb, "packageFqName");
    if (d.g.b.k.g(paramb, Lcy))
    {
      paramb = (Collection)ak.setOf(fQA());
      AppMethodBeat.o(56775);
      return paramb;
    }
    paramb = (Collection)x.KTH;
    AppMethodBeat.o(56775);
    return paramb;
  }
  
  public static final class a {}
  
  static final class b
    extends d.g.b.l
    implements d.g.a.a<d.l.b.a.b.b.c.h>
  {
    b(d paramd, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */