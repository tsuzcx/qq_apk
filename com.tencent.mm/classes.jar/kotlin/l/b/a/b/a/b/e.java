package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.ad;
import kotlin.a.ar;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.m;
import kotlin.l.o;

public final class e
  implements kotlin.l.b.a.b.b.b.b
{
  public static final e.a aiFq;
  private static final c aiFu;
  private static final f aiFv;
  private static final kotlin.l.b.a.b.f.b aiFw;
  private final ae aiFr;
  private final kotlin.g.a.b<ae, kotlin.l.b.a.b.b.l> aiFs;
  private final kotlin.l.b.a.b.l.h aiFt;
  
  static
  {
    AppMethodBeat.i(56771);
    aYe = new o[] { (o)ai.a((af)new ag((kotlin.l.e)ai.cz(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;")) };
    aiFq = new e.a((byte)0);
    aiFu = k.aiCr;
    Object localObject = k.a.aiCA.kxT();
    s.s(localObject, "cloneable.shortName()");
    aiFv = (f)localObject;
    localObject = kotlin.l.b.a.b.f.b.s(k.a.aiCA.kxX());
    s.s(localObject, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
    aiFw = (kotlin.l.b.a.b.f.b)localObject;
    AppMethodBeat.o(56771);
  }
  
  private e(final m paramm, ae paramae, kotlin.g.a.b<? super ae, ? extends kotlin.l.b.a.b.b.l> paramb)
  {
    AppMethodBeat.i(56776);
    this.aiFr = paramae;
    this.aiFs = paramb;
    this.aiFt = paramm.cq((a)new b(this, paramm));
    AppMethodBeat.o(56776);
  }
  
  private final kotlin.l.b.a.b.b.c.h knH()
  {
    AppMethodBeat.i(56772);
    kotlin.l.b.a.b.b.c.h localh = (kotlin.l.b.a.b.b.c.h)kotlin.l.b.a.b.l.l.a(this.aiFt, aYe[0]);
    AppMethodBeat.o(56772);
    return localh;
  }
  
  public final boolean a(c paramc, f paramf)
  {
    AppMethodBeat.i(56773);
    s.u(paramc, "packageFqName");
    s.u(paramf, "name");
    if ((s.p(paramf, aiFv)) && (s.p(paramc, aiFu)))
    {
      AppMethodBeat.o(56773);
      return true;
    }
    AppMethodBeat.o(56773);
    return false;
  }
  
  public final Collection<kotlin.l.b.a.b.b.e> b(c paramc)
  {
    AppMethodBeat.i(56775);
    s.u(paramc, "packageFqName");
    if (s.p(paramc, aiFu))
    {
      paramc = (Collection)ar.setOf(knH());
      AppMethodBeat.o(56775);
      return paramc;
    }
    paramc = (Collection)ad.aivA;
    AppMethodBeat.o(56775);
    return paramc;
  }
  
  public final kotlin.l.b.a.b.b.e b(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56774);
    s.u(paramb, "classId");
    if (s.p(paramb, aiFw))
    {
      paramb = (kotlin.l.b.a.b.b.e)knH();
      AppMethodBeat.o(56774);
      return paramb;
    }
    AppMethodBeat.o(56774);
    return null;
  }
  
  static final class b
    extends u
    implements a<kotlin.l.b.a.b.b.c.h>
  {
    b(e parame, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */