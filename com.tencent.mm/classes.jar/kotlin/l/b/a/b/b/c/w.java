package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.a.x;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.b.y.a;
import kotlin.l.b.a.b.l.c;
import kotlin.z;

public final class w
  extends j
  implements y
{
  final kotlin.l.b.a.b.l.j aaFH;
  private final kotlin.l.b.a.b.a.g aaLB;
  private final Map<y.a<?>, Object> aaOF;
  u aaOG;
  ac aaOH;
  private final c<kotlin.l.b.a.b.f.b, ad> aaOI;
  private final kotlin.f aaOJ;
  private final kotlin.l.b.a.b.g.b aaOK;
  private final kotlin.l.b.a.b.f.f aaOL;
  private boolean cSY;
  
  public w(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.l.j paramj, kotlin.l.b.a.b.a.g paramg)
  {
    this(paramf, paramj, paramg, null, 48);
  }
  
  private w(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.l.j paramj, kotlin.l.b.a.b.a.g paramg, kotlin.l.b.a.b.g.b paramb, Map<y.a<?>, ? extends Object> paramMap)
  {
    super(g.a.iGe(), paramf);
    AppMethodBeat.i(258706);
    this.aaFH = paramj;
    this.aaLB = paramg;
    this.aaOK = null;
    this.aaOL = null;
    if (!paramf.abfN)
    {
      paramf = (Throwable)new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(paramf)));
      AppMethodBeat.o(258706);
      throw paramf;
    }
    this.aaOF = ae.cA(paramMap);
    this.aaOF.put(kotlin.l.b.a.b.m.a.j.iQd(), new kotlin.l.b.a.b.m.a.r());
    this.cSY = true;
    this.aaOI = this.aaFH.ak((kotlin.g.a.b)new b(this));
    this.aaOJ = kotlin.g.ar((a)new a(this));
    AppMethodBeat.o(258706);
  }
  
  private void a(List<w> paramList, Set<w> paramSet)
  {
    AppMethodBeat.i(57182);
    p.k(paramList, "descriptors");
    p.k(paramSet, "friends");
    a((u)new v(paramList, paramSet, (List)kotlin.a.v.aaAd));
    AppMethodBeat.o(57182);
  }
  
  private void a(u paramu)
  {
    AppMethodBeat.i(57179);
    p.k(paramu, "dependencies");
    if (this.aaOG == null) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramu = (Throwable)new AssertionError("Dependencies of " + getId() + " were already set");
      AppMethodBeat.o(57179);
      throw paramu;
    }
    this.aaOG = paramu;
    AppMethodBeat.o(57179);
  }
  
  private void iGy()
  {
    AppMethodBeat.i(57174);
    if (!this.cSY)
    {
      Throwable localThrowable = (Throwable)new kotlin.l.b.a.b.b.u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
      AppMethodBeat.o(57174);
      throw localThrowable;
    }
    AppMethodBeat.o(57174);
  }
  
  private final i iGz()
  {
    AppMethodBeat.i(57178);
    i locali = (i)this.aaOJ.getValue();
    AppMethodBeat.o(57178);
    return locali;
  }
  
  private void lz(List<w> paramList)
  {
    AppMethodBeat.i(57181);
    p.k(paramList, "descriptors");
    a(paramList, (Set)x.aaAf);
    AppMethodBeat.o(57181);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57190);
    p.k(paramn, "visitor");
    p.k(paramn, "visitor");
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57190);
    return paramn;
  }
  
  public final <T> T a(y.a<T> parama)
  {
    AppMethodBeat.i(57187);
    p.k(parama, "capability");
    Object localObject = this.aaOF.get(parama);
    parama = localObject;
    if (!(localObject instanceof Object)) {
      parama = null;
    }
    AppMethodBeat.o(57187);
    return parama;
  }
  
  public final Collection<kotlin.l.b.a.b.f.b> a(kotlin.l.b.a.b.f.b paramb, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb1)
  {
    AppMethodBeat.i(57177);
    p.k(paramb, "fqName");
    p.k(paramb1, "nameFilter");
    iGy();
    paramb = iGA().a(paramb, paramb1);
    AppMethodBeat.o(57177);
    return paramb;
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(57185);
    p.k(paramac, "providerForModuleContent");
    if (!isInitialized()) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramac = (Throwable)new AssertionError("Attempt to initialize module " + getId() + " twice");
      AppMethodBeat.o(57185);
      throw paramac;
    }
    this.aaOH = paramac;
    AppMethodBeat.o(57185);
  }
  
  public final void a(w... paramVarArgs)
  {
    AppMethodBeat.i(57180);
    p.k(paramVarArgs, "descriptors");
    lz(e.aa(paramVarArgs));
    AppMethodBeat.o(57180);
  }
  
  public final boolean a(y paramy)
  {
    AppMethodBeat.i(57183);
    p.k(paramy, "targetModule");
    if (p.h((w)this, paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    u localu = this.aaOG;
    if (localu == null) {
      p.iCn();
    }
    if (kotlin.a.j.a((Iterable)localu.iGw(), paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (iFw().contains(paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (paramy.iFw().contains(this))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    AppMethodBeat.o(57183);
    return false;
  }
  
  public final ad e(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57176);
    p.k(paramb, "fqName");
    iGy();
    paramb = (ad)this.aaOI.invoke(paramb);
    AppMethodBeat.o(57176);
    return paramb;
  }
  
  final String getId()
  {
    AppMethodBeat.i(57184);
    String str = iEU().toString();
    p.j(str, "name.toString()");
    AppMethodBeat.o(57184);
    return str;
  }
  
  public final l iDJ()
  {
    return null;
  }
  
  public final kotlin.l.b.a.b.a.g iFv()
  {
    return this.aaLB;
  }
  
  public final List<y> iFw()
  {
    AppMethodBeat.i(57175);
    Object localObject = this.aaOG;
    if (localObject == null)
    {
      localObject = (Throwable)new AssertionError("Dependencies of module " + getId() + " were not set");
      AppMethodBeat.o(57175);
      throw ((Throwable)localObject);
    }
    localObject = ((u)localObject).iGx();
    AppMethodBeat.o(57175);
    return localObject;
  }
  
  public final ac iGA()
  {
    AppMethodBeat.i(57186);
    iGy();
    ac localac = (ac)iGz();
    AppMethodBeat.o(57186);
    return localac;
  }
  
  final boolean isInitialized()
  {
    return this.aaOH != null;
  }
  
  static final class a
    extends q
    implements a<i>
  {
    a(w paramw)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.b, r>
  {
    b(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.w
 * JD-Core Version:    0.7.0.1
 */