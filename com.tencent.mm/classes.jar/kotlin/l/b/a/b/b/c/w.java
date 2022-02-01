package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ab;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.l.m;

public final class w
  extends j
  implements ae
{
  final m aiBu;
  private final kotlin.l.b.a.b.a.h aiIk;
  private final kotlin.l.b.a.b.g.b aiLr;
  private final kotlin.l.b.a.b.f.f aiLs;
  private final Map<kotlin.l.b.a.b.b.ad<?>, Object> aiLt;
  final z aiLu;
  u aiLv;
  ai aiLw;
  private final kotlin.l.b.a.b.l.f<c, al> aiLx;
  private final kotlin.j aiLy;
  private boolean clZ;
  
  public w(kotlin.l.b.a.b.f.f paramf, m paramm, kotlin.l.b.a.b.a.h paramh)
  {
    this(paramf, paramm, paramh, null, 48);
    AppMethodBeat.i(191914);
    AppMethodBeat.o(191914);
  }
  
  private w(kotlin.l.b.a.b.f.f paramf, m paramm, kotlin.l.b.a.b.a.h paramh, kotlin.l.b.a.b.g.b paramb, Map<kotlin.l.b.a.b.b.ad<?>, ? extends Object> paramMap)
  {
    super(g.a.kpB(), paramf);
    AppMethodBeat.i(191902);
    this.aiBu = paramm;
    this.aiIk = paramh;
    this.aiLr = null;
    this.aiLs = null;
    if (!paramf.ajeG)
    {
      paramf = new IllegalArgumentException(s.X("Module name must be special: ", paramf));
      AppMethodBeat.o(191902);
      throw paramf;
    }
    this.aiLt = kotlin.a.ak.dw(paramMap);
    this.aiLt.put(kotlin.l.b.a.b.m.a.h.kAS(), new kotlin.l.b.a.b.m.a.p());
    paramf = z.aiLC;
    paramm = (z)a(z.a.kqa());
    paramf = paramm;
    if (paramm == null) {
      paramf = (z)z.b.aiLF;
    }
    this.aiLu = paramf;
    this.clZ = true;
    this.aiLx = this.aiBu.bd((kotlin.g.a.b)new b(this));
    this.aiLy = kotlin.k.cm((a)new a(this));
    AppMethodBeat.o(191902);
  }
  
  private void a(List<w> paramList, Set<w> paramSet)
  {
    AppMethodBeat.i(57182);
    s.u(paramList, "descriptors");
    s.u(paramSet, "friends");
    a((u)new v(paramList, paramSet, (List)ab.aivy, (Set)kotlin.a.ad.aivA));
    AppMethodBeat.o(57182);
  }
  
  private void a(u paramu)
  {
    AppMethodBeat.i(57179);
    s.u(paramu, "dependencies");
    if (this.aiLv == null) {}
    for (int i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0)
    {
      paramu = (Throwable)new AssertionError("Dependencies of " + getId() + " were already set");
      AppMethodBeat.o(57179);
      throw paramu;
    }
    this.aiLv = paramu;
    AppMethodBeat.o(57179);
  }
  
  private void kpV()
  {
    AppMethodBeat.i(57174);
    if (!this.clZ)
    {
      kotlin.l.b.a.b.b.z localz = new kotlin.l.b.a.b.b.z(s.X("Accessing invalid module descriptor ", this));
      AppMethodBeat.o(57174);
      throw localz;
    }
    AppMethodBeat.o(57174);
  }
  
  private final i kpW()
  {
    AppMethodBeat.i(57178);
    i locali = (i)this.aiLy.getValue();
    AppMethodBeat.o(57178);
    return locali;
  }
  
  private void oX(List<w> paramList)
  {
    AppMethodBeat.i(57181);
    s.u(paramList, "descriptors");
    a(paramList, (Set)kotlin.a.ad.aivA);
    AppMethodBeat.o(57181);
  }
  
  public final <T> T a(kotlin.l.b.a.b.b.ad<T> paramad)
  {
    AppMethodBeat.i(191926);
    s.u(paramad, "capability");
    paramad = this.aiLt.get(paramad);
    AppMethodBeat.o(191926);
    return paramad;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57190);
    s.u(this, "this");
    s.u(paramn, "visitor");
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57190);
    return paramn;
  }
  
  public final Collection<c> a(c paramc, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57177);
    s.u(paramc, "fqName");
    s.u(paramb, "nameFilter");
    kpV();
    paramc = kpX().a(paramc, paramb);
    AppMethodBeat.o(57177);
    return paramc;
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(57185);
    s.u(paramai, "providerForModuleContent");
    if (!isInitialized()) {}
    for (int i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0)
    {
      paramai = (Throwable)new AssertionError("Attempt to initialize module " + getId() + " twice");
      AppMethodBeat.o(57185);
      throw paramai;
    }
    this.aiLw = paramai;
    AppMethodBeat.o(57185);
  }
  
  public final void a(w... paramVarArgs)
  {
    AppMethodBeat.i(57180);
    s.u(paramVarArgs, "descriptors");
    oX(kotlin.a.k.ae(paramVarArgs));
    AppMethodBeat.o(57180);
  }
  
  public final boolean a(ae paramae)
  {
    AppMethodBeat.i(57183);
    s.u(paramae, "targetModule");
    if (s.p(this, paramae))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    u localu = this.aiLv;
    s.checkNotNull(localu);
    if (kotlin.a.p.a((Iterable)localu.kpT(), paramae))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (koW().contains(paramae))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (paramae.koW().contains(this))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    AppMethodBeat.o(57183);
    return false;
  }
  
  public final al e(c paramc)
  {
    AppMethodBeat.i(57176);
    s.u(paramc, "fqName");
    kpV();
    paramc = (al)this.aiLx.invoke(paramc);
    AppMethodBeat.o(57176);
    return paramc;
  }
  
  final String getId()
  {
    AppMethodBeat.i(57184);
    String str = kok().toString();
    s.s(str, "name.toString()");
    AppMethodBeat.o(57184);
    return str;
  }
  
  final boolean isInitialized()
  {
    return this.aiLw != null;
  }
  
  public final l knp()
  {
    AppMethodBeat.i(191928);
    s.u((ae)this, "this");
    AppMethodBeat.o(191928);
    return null;
  }
  
  public final kotlin.l.b.a.b.a.h koV()
  {
    return this.aiIk;
  }
  
  public final List<ae> koW()
  {
    AppMethodBeat.i(57175);
    Object localObject = this.aiLv;
    if (localObject == null)
    {
      localObject = new AssertionError("Dependencies of module " + getId() + " were not set");
      AppMethodBeat.o(57175);
      throw ((Throwable)localObject);
    }
    localObject = ((u)localObject).kpU();
    AppMethodBeat.o(57175);
    return localObject;
  }
  
  public final ai kpX()
  {
    AppMethodBeat.i(57186);
    kpV();
    ai localai = (ai)kpW();
    AppMethodBeat.o(57186);
    return localai;
  }
  
  static final class a
    extends kotlin.g.b.u
    implements a<i>
  {
    a(w paramw)
    {
      super();
    }
  }
  
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<c, al>
  {
    b(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.w
 * JD-Core Version:    0.7.0.1
 */