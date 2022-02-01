package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.l;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.c.y;
import d.l.b.a.b.b.e;
import d.l.b.a.b.d.a.e.t;
import d.l.b.a.b.d.b.p;
import d.l.b.a.b.d.b.q;
import d.l.b.a.b.j.e.c;
import d.l.b.a.b.l.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h
  extends y
{
  private final d.l.b.a.b.b.a.g Lez;
  private final d.l.b.a.b.d.a.c.h LnD;
  private final d.l.b.a.b.l.f LoI;
  private final d LoJ;
  public final d.l.b.a.b.l.f<List<d.l.b.a.b.f.b>> LoK;
  private final d.l.b.a.b.l.f LoL;
  private final t LoM;
  
  static
  {
    AppMethodBeat.i(57885);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), (d.l.k)w.a(new u(w.bn(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;")) };
    AppMethodBeat.o(57885);
  }
  
  public h(d.l.b.a.b.d.a.c.h paramh, t paramt)
  {
    super(paramh.LnL.LbH, paramt.fRH());
    AppMethodBeat.i(57890);
    this.LoM = paramt;
    this.LnD = d.l.b.a.b.d.a.c.a.a(paramh, (d.l.b.a.b.b.g)this, null, 6);
    this.LoI = this.LnD.LnL.KZf.O((d.g.a.a)new a(this));
    this.LoJ = new d(this.LnD, this.LoM, this);
    this.LoK = this.LnD.LnL.KZf.a((d.g.a.a)new c(this), (List)v.KTF);
    if (this.LnD.LnL.Lnt.Bky) {
      paramh = d.l.b.a.b.b.a.g.LeU;
    }
    for (paramh = g.a.fSm();; paramh = d.l.b.a.b.d.a.c.f.a(this.LnD, (d.l.b.a.b.d.a.e.d)this.LoM))
    {
      this.Lez = paramh;
      this.LoL = this.LnD.LnL.KZf.O((d.g.a.a)new b(this));
      AppMethodBeat.o(57890);
      return;
    }
  }
  
  public final e d(d.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57887);
    d.g.b.k.h(paramg, "jClass");
    j localj = this.LoJ.Lod;
    d.g.b.k.h(paramg, "javaClass");
    paramg = localj.a(paramg.fRf(), paramg);
    AppMethodBeat.o(57887);
    return paramg;
  }
  
  public final d.l.b.a.b.b.a.g fQj()
  {
    return this.Lez;
  }
  
  public final an fQk()
  {
    AppMethodBeat.i(57889);
    an localan = (an)new q(this);
    AppMethodBeat.o(57889);
    return localan;
  }
  
  public final Map<String, p> fUq()
  {
    AppMethodBeat.i(57886);
    Map localMap = (Map)d.l.b.a.b.l.h.a(this.LoI, $$delegatedProperties[0]);
    AppMethodBeat.o(57886);
    return localMap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57888);
    String str = "Lazy Java package fragment: " + this.LeZ;
    AppMethodBeat.o(57888);
    return str;
  }
  
  static final class a
    extends l
    implements d.g.a.a<Map<String, ? extends p>>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  static final class b
    extends l
    implements d.g.a.a<HashMap<c, c>>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  static final class c
    extends l
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