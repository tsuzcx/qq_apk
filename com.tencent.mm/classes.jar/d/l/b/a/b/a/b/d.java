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
  private static final d.l.b.a.b.f.b MTt;
  private static final d.l.b.a.b.f.f MTu;
  private static final d.l.b.a.b.f.a MTv;
  public static final a MTw;
  private final d.l.b.a.b.l.f MTq;
  private final y MTr;
  private final d.g.a.b<y, l> MTs;
  
  static
  {
    AppMethodBeat.i(56771);
    cwV = new k[] { (k)z.a(new d.g.b.x(z.bp(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;")) };
    MTw = new a((byte)0);
    MTt = g.MPQ;
    Object localObject = g.MQb.MQh.grh();
    p.g(localObject, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
    MTu = (d.l.b.a.b.f.f)localObject;
    localObject = d.l.b.a.b.f.a.p(g.MQb.MQh.grk());
    p.g(localObject, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
    MTv = (d.l.b.a.b.f.a)localObject;
    AppMethodBeat.o(56771);
  }
  
  private d(final j paramj, y paramy, d.g.a.b<? super y, ? extends l> paramb)
  {
    AppMethodBeat.i(56776);
    this.MTr = paramy;
    this.MTs = paramb;
    this.MTq = paramj.S((d.g.a.a)new b(this, paramj));
    AppMethodBeat.o(56776);
  }
  
  private final h ghY()
  {
    AppMethodBeat.i(56772);
    h localh = (h)i.a(this.MTq, cwV[0]);
    AppMethodBeat.o(56772);
    return localh;
  }
  
  public final boolean a(d.l.b.a.b.f.b paramb, d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56773);
    p.h(paramb, "packageFqName");
    p.h(paramf, "name");
    if ((p.i(paramf, MTu)) && (p.i(paramb, MTt)))
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
    if (p.i(parama, MTv))
    {
      parama = (e)ghY();
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
    if (p.i(paramb, MTt))
    {
      paramb = (Collection)ak.setOf(ghY());
      AppMethodBeat.o(56775);
      return paramb;
    }
    paramb = (Collection)d.a.x.MKG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */