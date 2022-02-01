package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.ak;
import kotlin.a.x;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.c.h;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.k;

public final class d
  implements kotlin.l.b.a.b.b.b.b
{
  private static final kotlin.l.b.a.b.f.b Tgg;
  private static final kotlin.l.b.a.b.f.f Tgh;
  private static final kotlin.l.b.a.b.f.a Tgi;
  public static final a Tgj;
  private final kotlin.l.b.a.b.l.f Tgd;
  private final kotlin.l.b.a.b.b.y Tge;
  private final kotlin.g.a.b<kotlin.l.b.a.b.b.y, l> Tgf;
  
  static
  {
    AppMethodBeat.i(56771);
    cLI = new k[] { (k)aa.a(new kotlin.g.b.y(aa.bp(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;")) };
    Tgj = new a((byte)0);
    Tgg = g.TcD;
    Object localObject = g.TcO.TcU.hJg();
    p.g(localObject, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
    Tgh = (kotlin.l.b.a.b.f.f)localObject;
    localObject = kotlin.l.b.a.b.f.a.p(g.TcO.TcU.hJj());
    p.g(localObject, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
    Tgi = (kotlin.l.b.a.b.f.a)localObject;
    AppMethodBeat.o(56771);
  }
  
  private d(final j paramj, kotlin.l.b.a.b.b.y paramy, kotlin.g.a.b<? super kotlin.l.b.a.b.b.y, ? extends l> paramb)
  {
    AppMethodBeat.i(56776);
    this.Tge = paramy;
    this.Tgf = paramb;
    this.Tgd = paramj.al((kotlin.g.a.a)new b(this, paramj));
    AppMethodBeat.o(56776);
  }
  
  private final h hAc()
  {
    AppMethodBeat.i(56772);
    h localh = (h)i.a(this.Tgd, cLI[0]);
    AppMethodBeat.o(56772);
    return localh;
  }
  
  public final boolean a(kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56773);
    p.h(paramb, "packageFqName");
    p.h(paramf, "name");
    if ((p.j(paramf, Tgh)) && (p.j(paramb, Tgg)))
    {
      AppMethodBeat.o(56773);
      return true;
    }
    AppMethodBeat.o(56773);
    return false;
  }
  
  public final Collection<e> b(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56775);
    p.h(paramb, "packageFqName");
    if (p.j(paramb, Tgg))
    {
      paramb = (Collection)ak.setOf(hAc());
      AppMethodBeat.o(56775);
      return paramb;
    }
    paramb = (Collection)x.SXt;
    AppMethodBeat.o(56775);
    return paramb;
  }
  
  public final e b(kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56774);
    p.h(parama, "classId");
    if (p.j(parama, Tgi))
    {
      parama = (e)hAc();
      AppMethodBeat.o(56774);
      return parama;
    }
    AppMethodBeat.o(56774);
    return null;
  }
  
  public static final class a {}
  
  static final class b
    extends q
    implements kotlin.g.a.a<h>
  {
    b(d paramd, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */