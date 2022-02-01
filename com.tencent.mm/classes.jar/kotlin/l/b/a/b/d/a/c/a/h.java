package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.j.e.c;
import kotlin.l.b.a.b.l.i;
import kotlin.l.k;

public final class h
  extends kotlin.l.b.a.b.b.c.y
{
  private final kotlin.l.b.a.b.b.a.g Tih;
  private final kotlin.l.b.a.b.d.a.c.h Trn;
  private final kotlin.l.b.a.b.l.f Tsr;
  private final d Tss;
  public final kotlin.l.b.a.b.l.f<List<kotlin.l.b.a.b.f.b>> Tst;
  private final kotlin.l.b.a.b.l.f Tsu;
  private final t Tsv;
  
  static
  {
    AppMethodBeat.i(57885);
    cLI = new k[] { (k)aa.a(new kotlin.g.b.y(aa.bp(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), (k)aa.a(new kotlin.g.b.y(aa.bp(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;")) };
    AppMethodBeat.o(57885);
  }
  
  public h(kotlin.l.b.a.b.d.a.c.h paramh, t paramt)
  {
    super(paramh.Trv.Tfp, paramt.hBk());
    AppMethodBeat.i(57890);
    this.Tsv = paramt;
    this.Trn = kotlin.l.b.a.b.d.a.c.a.a(paramh, (kotlin.l.b.a.b.b.g)this, null, 6);
    this.Tsr = this.Trn.Trv.TcN.al((kotlin.g.a.a)new a(this));
    this.Tss = new d(this.Trn, this.Tsv, this);
    this.Tst = this.Trn.Trv.TcN.a((kotlin.g.a.a)new c(this), (List)v.SXr);
    if (this.Trn.Trv.Trd.HIg) {
      paramh = kotlin.l.b.a.b.b.a.g.TiC;
    }
    for (paramh = g.a.hBP();; paramh = kotlin.l.b.a.b.d.a.c.f.a(this.Trn, (kotlin.l.b.a.b.d.a.e.d)this.Tsv))
    {
      this.Tih = paramh;
      this.Tsu = this.Trn.Trv.TcN.al((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(57890);
      return;
    }
  }
  
  public final e d(kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57887);
    kotlin.g.b.p.h(paramg, "jClass");
    j localj = this.Tss.TrM;
    kotlin.g.b.p.h(paramg, "javaClass");
    paramg = localj.a(paramg.hAH(), paramg);
    AppMethodBeat.o(57887);
    return paramg;
  }
  
  public final Map<String, kotlin.l.b.a.b.d.b.p> hDT()
  {
    AppMethodBeat.i(57886);
    Map localMap = (Map)i.a(this.Tsr, cLI[0]);
    AppMethodBeat.o(57886);
    return localMap;
  }
  
  public final kotlin.l.b.a.b.b.a.g hzL()
  {
    return this.Tih;
  }
  
  public final an hzM()
  {
    AppMethodBeat.i(57889);
    an localan = (an)new kotlin.l.b.a.b.d.b.q(this);
    AppMethodBeat.o(57889);
    return localan;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57888);
    String str = "Lazy Java package fragment: " + this.TiI;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */