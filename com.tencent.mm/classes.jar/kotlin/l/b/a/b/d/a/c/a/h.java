package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.b.ab;
import kotlin.g.b.z;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.c.y;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.j.e.c;
import kotlin.l.b.a.b.l.i;
import kotlin.l.n;

public final class h
  extends y
{
  private final kotlin.l.b.a.b.b.a.g aaLb;
  private final kotlin.l.b.a.b.d.a.c.h aaUh;
  private final kotlin.l.b.a.b.l.f aaVl;
  private final d aaVm;
  public final kotlin.l.b.a.b.l.f<List<kotlin.l.b.a.b.f.b>> aaVn;
  private final kotlin.l.b.a.b.l.f aaVo;
  private final t aaVp;
  
  static
  {
    AppMethodBeat.i(57885);
    cMt = new n[] { (n)ab.a(new z(ab.bO(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), (n)ab.a(new z(ab.bO(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;")) };
    AppMethodBeat.o(57885);
  }
  
  public h(kotlin.l.b.a.b.d.a.c.h paramh, t paramt)
  {
    super(paramh.aaUp.aaIj, paramt.iFy());
    AppMethodBeat.i(57890);
    this.aaVp = paramt;
    this.aaUh = kotlin.l.b.a.b.d.a.c.a.a(paramh, (kotlin.l.b.a.b.b.g)this, null, 6);
    this.aaVl = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new a(this));
    this.aaVm = new d(this.aaUh, this.aaVp, this);
    this.aaVn = this.aaUh.aaUp.aaFH.a((kotlin.g.a.a)new c(this), (List)v.aaAd);
    if (this.aaUh.aaUp.aaTX.Dlq) {
      paramh = kotlin.l.b.a.b.b.a.g.aaLw;
    }
    for (paramh = g.a.iGe();; paramh = kotlin.l.b.a.b.d.a.c.f.a(this.aaUh, (kotlin.l.b.a.b.d.a.e.d)this.aaVp))
    {
      this.aaLb = paramh;
      this.aaVo = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(57890);
      return;
    }
  }
  
  public final e d(kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57887);
    kotlin.g.b.p.k(paramg, "jClass");
    j localj = this.aaVm.aaUG;
    kotlin.g.b.p.k(paramg, "javaClass");
    paramg = localj.a(paramg.iEU(), paramg);
    AppMethodBeat.o(57887);
    return paramg;
  }
  
  public final kotlin.l.b.a.b.b.a.g iDY()
  {
    return this.aaLb;
  }
  
  public final an iDZ()
  {
    AppMethodBeat.i(57889);
    an localan = (an)new kotlin.l.b.a.b.d.b.q(this);
    AppMethodBeat.o(57889);
    return localan;
  }
  
  public final Map<String, kotlin.l.b.a.b.d.b.p> iIm()
  {
    AppMethodBeat.i(57886);
    Map localMap = (Map)i.a(this.aaVl, cMt[0]);
    AppMethodBeat.o(57886);
    return localMap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57888);
    String str = "Lazy Java package fragment: " + this.aaLC;
    AppMethodBeat.o(57888);
    return str;
  }
  
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Map<String, ? extends kotlin.l.b.a.b.d.b.p>>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<HashMap<c, c>>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.f.b>>
  {
    c(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */