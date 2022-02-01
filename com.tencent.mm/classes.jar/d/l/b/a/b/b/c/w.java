package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.x;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.y;
import d.l.b.a.b.b.y.a;
import d.l.b.a.b.l.c;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class w
  extends j
  implements y
{
  final d.l.b.a.b.l.j Nnf;
  private final d.l.b.a.b.a.g NsZ;
  private final Map<y.a<?>, Object> Nwd;
  u Nwe;
  d.l.b.a.b.b.ac Nwf;
  private final c<d.l.b.a.b.f.b, ad> Nwg;
  private final d.f Nwh;
  private final d.l.b.a.b.g.b Nwi;
  private final d.l.b.a.b.f.f Nwj;
  private boolean cKB;
  
  public w(d.l.b.a.b.f.f paramf, d.l.b.a.b.l.j paramj, d.l.b.a.b.a.g paramg)
  {
    this(paramf, paramj, paramg, null, 48);
  }
  
  private w(d.l.b.a.b.f.f paramf, d.l.b.a.b.l.j paramj, d.l.b.a.b.a.g paramg, Map<y.a<?>, ? extends Object> paramMap)
  {
    super(g.a.gon(), paramf);
    AppMethodBeat.i(57188);
    this.Nnf = paramj;
    this.NsZ = paramg;
    this.Nwi = null;
    this.Nwj = null;
    if (!paramf.NNv)
    {
      paramf = (Throwable)new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(paramf)));
      AppMethodBeat.o(57188);
      throw paramf;
    }
    p.h(paramMap, "$this$toMutableMap");
    this.Nwd = ((Map)new LinkedHashMap(paramMap));
    this.Nwd.put(d.l.b.a.b.m.a.j.gyI(), new d.l.b.a.b.m.a.r());
    this.cKB = true;
    this.Nwg = this.Nnf.L((d.g.a.b)new b(this));
    this.Nwh = d.g.O((a)new a(this));
    AppMethodBeat.o(57188);
  }
  
  private void a(u paramu)
  {
    AppMethodBeat.i(57179);
    p.h(paramu, "dependencies");
    if (this.Nwe == null) {}
    for (int i = 1; (d.ac.Nhs) && (i == 0); i = 0)
    {
      paramu = (Throwable)new AssertionError("Dependencies of " + getId() + " were already set");
      AppMethodBeat.o(57179);
      throw paramu;
    }
    this.Nwe = paramu;
    AppMethodBeat.o(57179);
  }
  
  private void a(List<w> paramList, Set<w> paramSet)
  {
    AppMethodBeat.i(57182);
    p.h(paramList, "descriptors");
    p.h(paramSet, "friends");
    a((u)new v(paramList, paramSet, (List)d.a.v.NhH));
    AppMethodBeat.o(57182);
  }
  
  private void goH()
  {
    AppMethodBeat.i(57174);
    if (!this.cKB)
    {
      Throwable localThrowable = (Throwable)new d.l.b.a.b.b.u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
      AppMethodBeat.o(57174);
      throw localThrowable;
    }
    AppMethodBeat.o(57174);
  }
  
  private final i goI()
  {
    AppMethodBeat.i(57178);
    i locali = (i)this.Nwh.getValue();
    AppMethodBeat.o(57178);
    return locali;
  }
  
  private void jw(List<w> paramList)
  {
    AppMethodBeat.i(57181);
    p.h(paramList, "descriptors");
    a(paramList, (Set)x.NhJ);
    AppMethodBeat.o(57181);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57190);
    p.h(paramn, "visitor");
    p.h(paramn, "visitor");
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57190);
    return paramn;
  }
  
  public final <T> T a(y.a<T> parama)
  {
    AppMethodBeat.i(57187);
    p.h(parama, "capability");
    Object localObject = this.Nwd.get(parama);
    parama = localObject;
    if (!(localObject instanceof Object)) {
      parama = null;
    }
    AppMethodBeat.o(57187);
    return parama;
  }
  
  public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramb, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb1)
  {
    AppMethodBeat.i(57177);
    p.h(paramb, "fqName");
    p.h(paramb1, "nameFilter");
    goH();
    paramb = goJ().a(paramb, paramb1);
    AppMethodBeat.o(57177);
    return paramb;
  }
  
  public final void a(d.l.b.a.b.b.ac paramac)
  {
    AppMethodBeat.i(57185);
    p.h(paramac, "providerForModuleContent");
    if (!isInitialized()) {}
    for (int i = 1; (d.ac.Nhs) && (i == 0); i = 0)
    {
      paramac = (Throwable)new AssertionError("Attempt to initialize module " + getId() + " twice");
      AppMethodBeat.o(57185);
      throw paramac;
    }
    this.Nwf = paramac;
    AppMethodBeat.o(57185);
  }
  
  public final void a(w... paramVarArgs)
  {
    AppMethodBeat.i(57180);
    p.h(paramVarArgs, "descriptors");
    jw(e.V(paramVarArgs));
    AppMethodBeat.o(57180);
  }
  
  public final boolean a(y paramy)
  {
    AppMethodBeat.i(57183);
    p.h(paramy, "targetModule");
    if (p.i((w)this, paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    u localu = this.Nwe;
    if (localu == null) {
      p.gkB();
    }
    if (d.a.j.a((Iterable)localu.goF(), paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (gnG().contains(paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (paramy.gnG().contains(this))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    AppMethodBeat.o(57183);
    return false;
  }
  
  public final ad e(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57176);
    p.h(paramb, "fqName");
    goH();
    paramb = (ad)this.Nwg.invoke(paramb);
    AppMethodBeat.o(57176);
    return paramb;
  }
  
  final String getId()
  {
    AppMethodBeat.i(57184);
    String str = gnf().toString();
    p.g(str, "name.toString()");
    AppMethodBeat.o(57184);
    return str;
  }
  
  public final l glU()
  {
    return null;
  }
  
  public final d.l.b.a.b.a.g gnF()
  {
    return this.NsZ;
  }
  
  public final List<y> gnG()
  {
    AppMethodBeat.i(57175);
    Object localObject = this.Nwe;
    if (localObject == null)
    {
      localObject = (Throwable)new AssertionError("Dependencies of module " + getId() + " were not set");
      AppMethodBeat.o(57175);
      throw ((Throwable)localObject);
    }
    localObject = ((u)localObject).goG();
    AppMethodBeat.o(57175);
    return localObject;
  }
  
  public final d.l.b.a.b.b.ac goJ()
  {
    AppMethodBeat.i(57186);
    goH();
    d.l.b.a.b.b.ac localac = (d.l.b.a.b.b.ac)goI();
    AppMethodBeat.o(57186);
    return localac;
  }
  
  final boolean isInitialized()
  {
    return this.Nwf != null;
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
    implements d.g.a.b<d.l.b.a.b.f.b, r>
  {
    b(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.w
 * JD-Core Version:    0.7.0.1
 */