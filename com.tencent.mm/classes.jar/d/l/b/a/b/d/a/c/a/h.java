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
  private final d.l.b.a.b.d.a.c.h JAk;
  private final d.l.b.a.b.l.f JBp;
  private final d JBq;
  public final d.l.b.a.b.l.f<List<d.l.b.a.b.f.b>> JBr;
  private final d.l.b.a.b.l.f JBs;
  private final t JBt;
  private final d.l.b.a.b.b.a.g Jrg;
  
  static
  {
    AppMethodBeat.i(57885);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), (d.l.k)w.a(new u(w.bk(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;")) };
    AppMethodBeat.o(57885);
  }
  
  public h(d.l.b.a.b.d.a.c.h paramh, t paramt)
  {
    super(paramh.JAs.Jon, paramt.fzd());
    AppMethodBeat.i(57890);
    this.JBt = paramt;
    this.JAk = d.l.b.a.b.d.a.c.a.a(paramh, (d.l.b.a.b.b.g)this, null, 6);
    this.JBp = this.JAk.JAs.JlL.H((d.g.a.a)new a(this));
    this.JBq = new d(this.JAk, this.JBt, this);
    this.JBr = this.JAk.JAs.JlL.a((d.g.a.a)new c(this), (List)v.Jgl);
    if (this.JAk.JAs.JAa.zSe) {
      paramh = d.l.b.a.b.b.a.g.JrB;
    }
    for (paramh = g.a.fzI();; paramh = d.l.b.a.b.d.a.c.f.a(this.JAk, (d.l.b.a.b.d.a.e.d)this.JBt))
    {
      this.Jrg = paramh;
      this.JBs = this.JAk.JAs.JlL.H((d.g.a.a)new b(this));
      AppMethodBeat.o(57890);
      return;
    }
  }
  
  public final e d(d.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57887);
    d.g.b.k.h(paramg, "jClass");
    j localj = this.JBq.JAK;
    d.g.b.k.h(paramg, "javaClass");
    paramg = localj.a(paramg.fyB(), paramg);
    AppMethodBeat.o(57887);
    return paramg;
  }
  
  public final Map<String, p> fBM()
  {
    AppMethodBeat.i(57886);
    Map localMap = (Map)d.l.b.a.b.l.h.a(this.JBp, $$delegatedProperties[0]);
    AppMethodBeat.o(57886);
    return localMap;
  }
  
  public final d.l.b.a.b.b.a.g fxF()
  {
    return this.Jrg;
  }
  
  public final an fxG()
  {
    AppMethodBeat.i(57889);
    an localan = (an)new q(this);
    AppMethodBeat.o(57889);
    return localan;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57888);
    String str = "Lazy Java package fragment: " + this.JrG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */