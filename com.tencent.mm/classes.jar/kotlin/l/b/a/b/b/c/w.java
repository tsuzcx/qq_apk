package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.e;
import kotlin.a.x;
import kotlin.aa;
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

public final class w
  extends j
  implements y
{
  final kotlin.l.b.a.b.l.j TcN;
  private final kotlin.l.b.a.b.a.g TiH;
  private final Map<y.a<?>, Object> TlL;
  u TlM;
  ac TlN;
  private final c<kotlin.l.b.a.b.f.b, ad> TlO;
  private final kotlin.f TlP;
  private final kotlin.l.b.a.b.g.b TlQ;
  private final kotlin.l.b.a.b.f.f TlR;
  private boolean daZ;
  
  public w(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.l.j paramj, kotlin.l.b.a.b.a.g paramg)
  {
    this(paramf, paramj, paramg, null, 48);
  }
  
  private w(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.l.j paramj, kotlin.l.b.a.b.a.g paramg, kotlin.l.b.a.b.g.b paramb, Map<y.a<?>, ? extends Object> paramMap)
  {
    super(g.a.hBP(), paramf);
    AppMethodBeat.i(186245);
    this.TcN = paramj;
    this.TiH = paramg;
    this.TlQ = null;
    this.TlR = null;
    if (!paramf.TDa)
    {
      paramf = (Throwable)new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(paramf)));
      AppMethodBeat.o(186245);
      throw paramf;
    }
    p.h(paramMap, "$this$toMutableMap");
    this.TlL = ((Map)new LinkedHashMap(paramMap));
    this.TlL.put(kotlin.l.b.a.b.m.a.j.hLL(), new kotlin.l.b.a.b.m.a.r());
    this.daZ = true;
    this.TlO = this.TcN.U((kotlin.g.a.b)new b(this));
    this.TlP = kotlin.g.ah((a)new a(this));
    AppMethodBeat.o(186245);
  }
  
  private void a(List<w> paramList, Set<w> paramSet)
  {
    AppMethodBeat.i(57182);
    p.h(paramList, "descriptors");
    p.h(paramSet, "friends");
    a((u)new v(paramList, paramSet, (List)kotlin.a.v.SXr));
    AppMethodBeat.o(57182);
  }
  
  private void a(u paramu)
  {
    AppMethodBeat.i(57179);
    p.h(paramu, "dependencies");
    if (this.TlM == null) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramu = (Throwable)new AssertionError("Dependencies of " + getId() + " were already set");
      AppMethodBeat.o(57179);
      throw paramu;
    }
    this.TlM = paramu;
    AppMethodBeat.o(57179);
  }
  
  private void hCj()
  {
    AppMethodBeat.i(57174);
    if (!this.daZ)
    {
      Throwable localThrowable = (Throwable)new kotlin.l.b.a.b.b.u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
      AppMethodBeat.o(57174);
      throw localThrowable;
    }
    AppMethodBeat.o(57174);
  }
  
  private final i hCk()
  {
    AppMethodBeat.i(57178);
    i locali = (i)this.TlP.getValue();
    AppMethodBeat.o(57178);
    return locali;
  }
  
  private void kC(List<w> paramList)
  {
    AppMethodBeat.i(57181);
    p.h(paramList, "descriptors");
    a(paramList, (Set)x.SXt);
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
    Object localObject = this.TlL.get(parama);
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
    p.h(paramb, "fqName");
    p.h(paramb1, "nameFilter");
    hCj();
    paramb = hCl().a(paramb, paramb1);
    AppMethodBeat.o(57177);
    return paramb;
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(57185);
    p.h(paramac, "providerForModuleContent");
    if (!isInitialized()) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramac = (Throwable)new AssertionError("Attempt to initialize module " + getId() + " twice");
      AppMethodBeat.o(57185);
      throw paramac;
    }
    this.TlN = paramac;
    AppMethodBeat.o(57185);
  }
  
  public final void a(w... paramVarArgs)
  {
    AppMethodBeat.i(57180);
    p.h(paramVarArgs, "descriptors");
    kC(e.W(paramVarArgs));
    AppMethodBeat.o(57180);
  }
  
  public final boolean a(y paramy)
  {
    AppMethodBeat.i(57183);
    p.h(paramy, "targetModule");
    if (p.j((w)this, paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    u localu = this.TlM;
    if (localu == null) {
      p.hyc();
    }
    if (kotlin.a.j.a((Iterable)localu.hCh(), paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (hBi().contains(paramy))
    {
      AppMethodBeat.o(57183);
      return true;
    }
    if (paramy.hBi().contains(this))
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
    p.h(paramb, "fqName");
    hCj();
    paramb = (ad)this.TlO.invoke(paramb);
    AppMethodBeat.o(57176);
    return paramb;
  }
  
  final String getId()
  {
    AppMethodBeat.i(57184);
    String str = hAH().toString();
    p.g(str, "name.toString()");
    AppMethodBeat.o(57184);
    return str;
  }
  
  public final kotlin.l.b.a.b.a.g hBh()
  {
    return this.TiH;
  }
  
  public final List<y> hBi()
  {
    AppMethodBeat.i(57175);
    Object localObject = this.TlM;
    if (localObject == null)
    {
      localObject = (Throwable)new AssertionError("Dependencies of module " + getId() + " were not set");
      AppMethodBeat.o(57175);
      throw ((Throwable)localObject);
    }
    localObject = ((u)localObject).hCi();
    AppMethodBeat.o(57175);
    return localObject;
  }
  
  public final ac hCl()
  {
    AppMethodBeat.i(57186);
    hCj();
    ac localac = (ac)hCk();
    AppMethodBeat.o(57186);
    return localac;
  }
  
  public final l hzx()
  {
    return null;
  }
  
  final boolean isInitialized()
  {
    return this.TlN != null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.w
 * JD-Core Version:    0.7.0.1
 */