package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.a.x;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.e;
import d.l.b.a.b.d.a.e.aa;
import d.l.b.a.b.d.a.e.t;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class j
  extends m
{
  private final t JBt;
  private final d.l.b.a.b.l.g<Set<String>> JBv;
  private final d.l.b.a.b.l.d<a, e> JBw;
  final h JBx;
  
  public j(final d.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    super(paramh);
    AppMethodBeat.i(57908);
    this.JBt = paramt;
    this.JBx = paramh1;
    this.JBv = paramh.JAs.JlL.I((d.g.a.a)new d(this, paramh));
    this.JBw = paramh.JAs.JlL.B((d.g.a.b)new c(this, paramh));
    AppMethodBeat.o(57908);
  }
  
  final e a(f paramf, d.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57901);
    if (!d.l.b.a.b.f.h.w(paramf))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    Set localSet = (Set)this.JBv.invoke();
    if ((paramg == null) && (localSet != null) && (!localSet.contains(paramf.qV())))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    paramf = (e)this.JBw.aA(new a(paramf, paramg));
    AppMethodBeat.o(57901);
    return paramf;
  }
  
  public final Collection<ah> a(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57902);
    k.h(paramf, "name");
    k.h(parama, "location");
    paramf = (Collection)v.Jgl;
    AppMethodBeat.o(57902);
    return paramf;
  }
  
  public final Collection<d.l.b.a.b.b.l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57907);
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    paramd = (Collection)d(paramd, paramb);
    AppMethodBeat.o(57907);
    return paramd;
  }
  
  protected final Set<f> a(d.l.b.a.b.j.f.d paramd)
  {
    AppMethodBeat.i(57906);
    k.h(paramd, "kindFilter");
    paramd = (Set)x.Jgn;
    AppMethodBeat.o(57906);
    return paramd;
  }
  
  protected final void a(Collection<am> paramCollection, f paramf)
  {
    AppMethodBeat.i(57905);
    k.h(paramCollection, "result");
    k.h(paramf, "name");
    AppMethodBeat.o(57905);
  }
  
  protected final Set<f> b(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57904);
    k.h(paramd, "kindFilter");
    paramd = (Set)x.Jgn;
    AppMethodBeat.o(57904);
    return paramd;
  }
  
  protected final Set<f> c(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57903);
    k.h(paramd, "kindFilter");
    Object localObject = d.l.b.a.b.j.f.d.JTw;
    if (!paramd.afP(d.l.b.a.b.j.f.d.fJi()))
    {
      paramd = (Set)x.Jgn;
      AppMethodBeat.o(57903);
      return paramd;
    }
    paramd = (Set)this.JBv.invoke();
    if (paramd != null)
    {
      paramb = (Iterable)paramd;
      paramd = (Collection)new HashSet();
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramd.add(f.aQC((String)paramb.next()));
      }
      paramd = (Set)paramd;
      AppMethodBeat.o(57903);
      return paramd;
    }
    localObject = this.JBt;
    paramd = paramb;
    if (paramb == null) {
      paramd = d.l.b.a.b.o.d.fKi();
    }
    paramd = (Iterable)((t)localObject).y(paramd);
    paramb = (Collection)new LinkedHashSet();
    localObject = paramd.iterator();
    label219:
    while (((Iterator)localObject).hasNext())
    {
      paramd = (d.l.b.a.b.d.a.e.g)((Iterator)localObject).next();
      if (aa.JCB == null) {}
      for (paramd = null;; paramd = paramd.fyB())
      {
        if (paramd == null) {
          break label219;
        }
        paramb.add(paramd);
        break;
      }
    }
    paramd = (Set)paramb;
    AppMethodBeat.o(57903);
    return paramd;
  }
  
  public final e e(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57899);
    k.h(paramf, "name");
    k.h(parama, "location");
    paramf = a(paramf, null);
    AppMethodBeat.o(57899);
    return paramf;
  }
  
  protected final b fBK()
  {
    return (b)b.a.JAJ;
  }
  
  static final class a
  {
    final d.l.b.a.b.d.a.e.g JBy;
    final f JsQ;
    
    public a(f paramf, d.l.b.a.b.d.a.e.g paramg)
    {
      AppMethodBeat.i(57893);
      this.JsQ = paramf;
      this.JBy = paramg;
      AppMethodBeat.o(57893);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(57891);
      if (((paramObject instanceof a)) && (k.g(this.JsQ, ((a)paramObject).JsQ)))
      {
        AppMethodBeat.o(57891);
        return true;
      }
      AppMethodBeat.o(57891);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(57892);
      int i = this.JsQ.hashCode();
      AppMethodBeat.o(57892);
      return i;
    }
  }
  
  static abstract class b
  {
    public static final class a
      extends j.b
    {
      final e Jus;
      
      public a(e parame)
      {
        super();
        AppMethodBeat.i(57894);
        this.Jus = parame;
        AppMethodBeat.o(57894);
      }
    }
    
    public static final class b
      extends j.b
    {
      public static final b JBz;
      
      static
      {
        AppMethodBeat.i(57895);
        JBz = new b();
        AppMethodBeat.o(57895);
      }
      
      private b()
      {
        super();
      }
    }
    
    public static final class c
      extends j.b
    {
      public static final c JBA;
      
      static
      {
        AppMethodBeat.i(57896);
        JBA = new c();
        AppMethodBeat.o(57896);
      }
      
      private c()
      {
        super();
      }
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.b<j.a, e>
  {
    c(j paramj, d.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.a<Set<? extends String>>
  {
    d(j paramj, d.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */