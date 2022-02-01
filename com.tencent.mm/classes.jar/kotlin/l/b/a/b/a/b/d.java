package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.ak;
import kotlin.a.x;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.c.h;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.n;

public final class d
  implements kotlin.l.b.a.b.b.b.b
{
  private static final kotlin.l.b.a.b.f.b aaJa;
  private static final kotlin.l.b.a.b.f.f aaJb;
  private static final kotlin.l.b.a.b.f.a aaJc;
  public static final a aaJd;
  private final kotlin.l.b.a.b.l.f aaIX;
  private final y aaIY;
  private final kotlin.g.a.b<y, l> aaIZ;
  
  static
  {
    AppMethodBeat.i(56771);
    cMt = new n[] { (n)ab.a(new z(ab.bO(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;")) };
    aaJd = new a((byte)0);
    aaJa = g.aaFx;
    Object localObject = g.aaFI.aaFO.iNA();
    p.j(localObject, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
    aaJb = (kotlin.l.b.a.b.f.f)localObject;
    localObject = kotlin.l.b.a.b.f.a.p(g.aaFI.aaFO.iND());
    p.j(localObject, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
    aaJc = (kotlin.l.b.a.b.f.a)localObject;
    AppMethodBeat.o(56771);
  }
  
  private d(final j paramj, y paramy, kotlin.g.a.b<? super y, ? extends l> paramb)
  {
    AppMethodBeat.i(56776);
    this.aaIY = paramy;
    this.aaIZ = paramb;
    this.aaIX = paramj.av((kotlin.g.a.a)new b(this, paramj));
    AppMethodBeat.o(56776);
  }
  
  private final h iEp()
  {
    AppMethodBeat.i(56772);
    h localh = (h)i.a(this.aaIX, cMt[0]);
    AppMethodBeat.o(56772);
    return localh;
  }
  
  public final boolean a(kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56773);
    p.k(paramb, "packageFqName");
    p.k(paramf, "name");
    if ((p.h(paramf, aaJb)) && (p.h(paramb, aaJa)))
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
    p.k(paramb, "packageFqName");
    if (p.h(paramb, aaJa))
    {
      paramb = (Collection)ak.setOf(iEp());
      AppMethodBeat.o(56775);
      return paramb;
    }
    paramb = (Collection)x.aaAf;
    AppMethodBeat.o(56775);
    return paramb;
  }
  
  public final e b(kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56774);
    p.k(parama, "classId");
    if (p.h(parama, aaJc))
    {
      parama = (e)iEp();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */