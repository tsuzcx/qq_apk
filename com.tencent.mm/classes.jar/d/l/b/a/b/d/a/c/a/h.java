package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.c.y;
import d.l.b.a.b.b.e;
import d.l.b.a.b.d.a.e.t;
import d.l.b.a.b.j.e.c;
import d.l.b.a.b.l.i;
import d.l.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h
  extends y
{
  private final d.l.b.a.b.d.a.c.h NBF;
  private final d.l.b.a.b.l.f NCK;
  private final d NCL;
  public final d.l.b.a.b.l.f<List<d.l.b.a.b.f.b>> NCM;
  private final d.l.b.a.b.l.f NCN;
  private final t NCO;
  private final d.l.b.a.b.b.a.g Nsz;
  
  static
  {
    AppMethodBeat.i(57885);
    cxA = new k[] { (k)z.a(new x(z.bp(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), (k)z.a(new x(z.bp(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;")) };
    AppMethodBeat.o(57885);
  }
  
  public h(d.l.b.a.b.d.a.c.h paramh, t paramt)
  {
    super(paramh.NBN.NpH, paramt.gnI());
    AppMethodBeat.i(57890);
    this.NCO = paramt;
    this.NBF = d.l.b.a.b.d.a.c.a.a(paramh, (d.l.b.a.b.b.g)this, null, 6);
    this.NCK = this.NBF.NBN.Nnf.S((d.g.a.a)new a(this));
    this.NCL = new d(this.NBF, this.NCO, this);
    this.NCM = this.NBF.NBN.Nnf.a((d.g.a.a)new c(this), (List)v.NhH);
    if (this.NBF.NBN.NBv.Dcs) {
      paramh = d.l.b.a.b.b.a.g.NsU;
    }
    for (paramh = g.a.gon();; paramh = d.l.b.a.b.d.a.c.f.a(this.NBF, (d.l.b.a.b.d.a.e.d)this.NCO))
    {
      this.Nsz = paramh;
      this.NCN = this.NBF.NBN.Nnf.S((d.g.a.a)new b(this));
      AppMethodBeat.o(57890);
      return;
    }
  }
  
  public final e d(d.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57887);
    d.g.b.p.h(paramg, "jClass");
    j localj = this.NCL.NCf;
    d.g.b.p.h(paramg, "javaClass");
    paramg = localj.a(paramg.gnf(), paramg);
    AppMethodBeat.o(57887);
    return paramg;
  }
  
  public final d.l.b.a.b.b.a.g gmj()
  {
    return this.Nsz;
  }
  
  public final an gmk()
  {
    AppMethodBeat.i(57889);
    an localan = (an)new d.l.b.a.b.d.b.q(this);
    AppMethodBeat.o(57889);
    return localan;
  }
  
  public final Map<String, d.l.b.a.b.d.b.p> gqr()
  {
    AppMethodBeat.i(57886);
    Map localMap = (Map)i.a(this.NCK, cxA[0]);
    AppMethodBeat.o(57886);
    return localMap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57888);
    String str = "Lazy Java package fragment: " + this.Nta;
    AppMethodBeat.o(57888);
    return str;
  }
  
  static final class a
    extends d.g.b.q
    implements d.g.a.a<Map<String, ? extends d.l.b.a.b.d.b.p>>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.q
    implements d.g.a.a<HashMap<c, c>>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.q
    implements d.g.a.a<List<? extends d.l.b.a.b.f.b>>
  {
    c(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */