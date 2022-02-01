package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.x;
import d.aa;
import d.g.a.a;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ac;
import d.l.b.a.b.b.ad;
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
  private final d.l.b.a.b.l.i KZf;
  private final d.l.b.a.b.a.g LeY;
  private final Map<y.a<?>, Object> Lib;
  private u Lic;
  private ac Lid;
  private final c<d.l.b.a.b.f.b, ad> Lie;
  private final d.f Lif;
  private final d.l.b.a.b.g.b Lig;
  private final d.l.b.a.b.f.f Lih;
  private boolean cyW;
  
  static
  {
    AppMethodBeat.i(57173);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(w.class), "packageFragmentProviderForWholeModuleWithDependencies", "getPackageFragmentProviderForWholeModuleWithDependencies()Lorg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider;")) };
    AppMethodBeat.o(57173);
  }
  
  public w(d.l.b.a.b.f.f paramf, d.l.b.a.b.l.i parami, d.l.b.a.b.a.g paramg)
  {
    this(paramf, parami, paramg, null, 48);
  }
  
  private w(d.l.b.a.b.f.f paramf, d.l.b.a.b.l.i parami, d.l.b.a.b.a.g paramg, Map<y.a<?>, ? extends Object> paramMap)
  {
    super(g.a.fSm(), paramf);
    AppMethodBeat.i(57188);
    this.KZf = parami;
    this.LeY = paramg;
    this.Lig = null;
    this.Lih = null;
    if (!paramf.Lzs)
    {
      paramf = (Throwable)new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(paramf)));
      AppMethodBeat.o(57188);
      throw paramf;
    }
    d.g.b.k.h(paramMap, "$this$toMutableMap");
    this.Lib = ((Map)new LinkedHashMap(paramMap));
    this.Lib.put(d.l.b.a.b.m.a.j.gcF(), new d.l.b.a.b.m.a.r());
    this.cyW = true;
    this.Lie = this.KZf.I((d.g.a.b)new b(this));
    this.Lif = d.g.K((a)new a(this));
    AppMethodBeat.o(57188);
  }
  
  private void a(u paramu)
  {
    AppMethodBeat.i(57179);
    d.g.b.k.h(paramu, "dependencies");
    if (this.Lic == null) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      paramu = (Throwable)new AssertionError("Dependencies of " + getId() + " were already set");
      AppMethodBeat.o(57179);
      throw paramu;
    }
    this.Lic = paramu;
    AppMethodBeat.o(57179);
  }
  
  private void a(List<w> paramList, Set<w> paramSet)
  {
    AppMethodBeat.i(57182);
    d.g.b.k.h(paramList, "descriptors");
    d.g.b.k.h(paramSet, "friends");
    a((u)new v(paramList, paramSet, (List)d.a.v.KTF));
    AppMethodBeat.o(57182);
  }
  
  private void fSG()
  {
    AppMethodBeat.i(57174);
    if (!this.cyW)
    {
      Throwable localThrowable = (Throwable)new d.l.b.a.b.b.u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
      AppMethodBeat.o(57174);
      throw localThrowable;
    }
    AppMethodBeat.o(57174);
  }
  
  private final i fSH()
  {
    AppMethodBeat.i(57178);
    i locali = (i)this.Lif.getValue();
    AppMethodBeat.o(57178);
    return locali;
  }
  
  private final String getId()
  {
    AppMethodBeat.i(57184);
    String str = fRf().toString();
    d.g.b.k.g(str, "name.toString()");
    AppMethodBeat.o(57184);
    return str;
  }
  
  private void iZ(List<w> paramList)
  {
    AppMethodBeat.i(57181);
    d.g.b.k.h(paramList, "descriptors");
    a(paramList, (Set)x.KTH);
    AppMethodBeat.o(57181);
  }
  
  private final boolean isInitialized()
  {
    return this.Lid != null;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57190);
    d.g.b.k.h(paramn, "visitor");
    d.g.b.k.h(paramn, "visitor");
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57190);
    return paramn;
  }
  
  public final <T> T a(y.a<T> parama)
  {
    AppMethodBeat.i(57187);
    d.g.b.k.h(parama, "capability");
    Object localObject = this.Lib.get(parama);
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
    d.g.b.k.h(paramb, "fqName");
    d.g.b.k.h(paramb1, "nameFilter");
    fSG();
    paramb = fSI().a(paramb, paramb1);
    AppMethodBeat.o(57177);
    return paramb;
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(57185);
    d.g.b.k.h(paramac, "providerForModuleContent");
    if (!isInitialized()) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      paramac = (Throwable)new AssertionError("Attempt to initialize module " + getId() + " twice");
      AppMethodBeat.o(57185);
      throw paramac;
    }
    this.Lid = paramac;
    AppMethodBeat.o(57185);
  }
  
  public final void a(w... paramVarArgs)
  {
    AppMethodBeat.i(57180);
    d.g.b.k.h(paramVarArgs, "descriptors");
    iZ(e.V(paramVarArgs));
    AppMethodBeat.o(57180);
  }
  
  public final boolean a(y paramy)
  {
    AppMethodBeat.i(57183);
    d.g.b.k.h(paramy, "targetModule");
    if (d.g.b.k.g((w)this, paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    u localu = this.Lic;
    if (localu == null) {
      d.g.b.k.fOy();
    }
    if (d.a.j.a((Iterable)localu.fSE(), paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (fRF().contains(paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (paramy.fRF().contains(this))
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
    d.g.b.k.h(paramb, "fqName");
    fSG();
    paramb = (ad)this.Lie.ay(paramb);
    AppMethodBeat.o(57176);
    return paramb;
  }
  
  public final d.l.b.a.b.b.l fPU()
  {
    return null;
  }
  
  public final d.l.b.a.b.a.g fRE()
  {
    return this.LeY;
  }
  
  public final List<y> fRF()
  {
    AppMethodBeat.i(57175);
    Object localObject = this.Lic;
    if (localObject == null)
    {
      localObject = (Throwable)new AssertionError("Dependencies of module " + getId() + " were not set");
      AppMethodBeat.o(57175);
      throw ((Throwable)localObject);
    }
    localObject = ((u)localObject).fSF();
    AppMethodBeat.o(57175);
    return localObject;
  }
  
  public final ac fSI()
  {
    AppMethodBeat.i(57186);
    fSG();
    ac localac = (ac)fSH();
    AppMethodBeat.o(57186);
    return localac;
  }
  
  static final class a
    extends d.g.b.l
    implements a<i>
  {
    a(w paramw)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
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