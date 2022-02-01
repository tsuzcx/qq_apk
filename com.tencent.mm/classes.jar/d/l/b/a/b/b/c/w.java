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
  final d.l.b.a.b.l.j MQa;
  private final d.l.b.a.b.a.g MVT;
  private final Map<y.a<?>, Object> MYX;
  u MYY;
  d.l.b.a.b.b.ac MYZ;
  private final c<d.l.b.a.b.f.b, ad> MZa;
  private final d.f MZb;
  private final d.l.b.a.b.g.b MZc;
  private final d.l.b.a.b.f.f MZd;
  private boolean cJS;
  
  public w(d.l.b.a.b.f.f paramf, d.l.b.a.b.l.j paramj, d.l.b.a.b.a.g paramg)
  {
    this(paramf, paramj, paramg, null, 48);
  }
  
  private w(d.l.b.a.b.f.f paramf, d.l.b.a.b.l.j paramj, d.l.b.a.b.a.g paramg, Map<y.a<?>, ? extends Object> paramMap)
  {
    super(g.a.gjL(), paramf);
    AppMethodBeat.i(57188);
    this.MQa = paramj;
    this.MVT = paramg;
    this.MZc = null;
    this.MZd = null;
    if (!paramf.Nqp)
    {
      paramf = (Throwable)new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(paramf)));
      AppMethodBeat.o(57188);
      throw paramf;
    }
    p.h(paramMap, "$this$toMutableMap");
    this.MYX = ((Map)new LinkedHashMap(paramMap));
    this.MYX.put(d.l.b.a.b.m.a.j.gug(), new d.l.b.a.b.m.a.r());
    this.cJS = true;
    this.MZa = this.MQa.I((d.g.a.b)new b(this));
    this.MZb = d.g.O((a)new a(this));
    AppMethodBeat.o(57188);
  }
  
  private void a(u paramu)
  {
    AppMethodBeat.i(57179);
    p.h(paramu, "dependencies");
    if (this.MYY == null) {}
    for (int i = 1; (d.ac.MKp) && (i == 0); i = 0)
    {
      paramu = (Throwable)new AssertionError("Dependencies of " + getId() + " were already set");
      AppMethodBeat.o(57179);
      throw paramu;
    }
    this.MYY = paramu;
    AppMethodBeat.o(57179);
  }
  
  private void a(List<w> paramList, Set<w> paramSet)
  {
    AppMethodBeat.i(57182);
    p.h(paramList, "descriptors");
    p.h(paramSet, "friends");
    a((u)new v(paramList, paramSet, (List)d.a.v.MKE));
    AppMethodBeat.o(57182);
  }
  
  private void gkf()
  {
    AppMethodBeat.i(57174);
    if (!this.cJS)
    {
      Throwable localThrowable = (Throwable)new d.l.b.a.b.b.u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
      AppMethodBeat.o(57174);
      throw localThrowable;
    }
    AppMethodBeat.o(57174);
  }
  
  private final i gkg()
  {
    AppMethodBeat.i(57178);
    i locali = (i)this.MZb.getValue();
    AppMethodBeat.o(57178);
    return locali;
  }
  
  private void jn(List<w> paramList)
  {
    AppMethodBeat.i(57181);
    p.h(paramList, "descriptors");
    a(paramList, (Set)x.MKG);
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
    Object localObject = this.MYX.get(parama);
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
    gkf();
    paramb = gkh().a(paramb, paramb1);
    AppMethodBeat.o(57177);
    return paramb;
  }
  
  public final void a(d.l.b.a.b.b.ac paramac)
  {
    AppMethodBeat.i(57185);
    p.h(paramac, "providerForModuleContent");
    if (!isInitialized()) {}
    for (int i = 1; (d.ac.MKp) && (i == 0); i = 0)
    {
      paramac = (Throwable)new AssertionError("Attempt to initialize module " + getId() + " twice");
      AppMethodBeat.o(57185);
      throw paramac;
    }
    this.MYZ = paramac;
    AppMethodBeat.o(57185);
  }
  
  public final void a(w... paramVarArgs)
  {
    AppMethodBeat.i(57180);
    p.h(paramVarArgs, "descriptors");
    jn(e.W(paramVarArgs));
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
    u localu = this.MYY;
    if (localu == null) {
      p.gfZ();
    }
    if (d.a.j.a((Iterable)localu.gkd(), paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (gje().contains(paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (paramy.gje().contains(this))
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
    gkf();
    paramb = (ad)this.MZa.invoke(paramb);
    AppMethodBeat.o(57176);
    return paramb;
  }
  
  final String getId()
  {
    AppMethodBeat.i(57184);
    String str = giD().toString();
    p.g(str, "name.toString()");
    AppMethodBeat.o(57184);
    return str;
  }
  
  public final l ghs()
  {
    return null;
  }
  
  public final d.l.b.a.b.a.g gjd()
  {
    return this.MVT;
  }
  
  public final List<y> gje()
  {
    AppMethodBeat.i(57175);
    Object localObject = this.MYY;
    if (localObject == null)
    {
      localObject = (Throwable)new AssertionError("Dependencies of module " + getId() + " were not set");
      AppMethodBeat.o(57175);
      throw ((Throwable)localObject);
    }
    localObject = ((u)localObject).gke();
    AppMethodBeat.o(57175);
    return localObject;
  }
  
  public final d.l.b.a.b.b.ac gkh()
  {
    AppMethodBeat.i(57186);
    gkf();
    d.l.b.a.b.b.ac localac = (d.l.b.a.b.b.ac)gkg();
    AppMethodBeat.o(57186);
    return localac;
  }
  
  final boolean isInitialized()
  {
    return this.MYZ != null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.w
 * JD-Core Version:    0.7.0.1
 */