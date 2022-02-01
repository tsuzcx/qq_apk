package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.v;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.e.aa;
import kotlin.l.b.a.b.d.a.e.t;

public final class j
  extends m
{
  private final t Tsv;
  private final kotlin.l.b.a.b.l.g<Set<String>> Tsx;
  private final kotlin.l.b.a.b.l.d<j.a, e> Tsy;
  final h Tsz;
  
  public j(final kotlin.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    super(paramh);
    AppMethodBeat.i(57908);
    this.Tsv = paramt;
    this.Tsz = paramh1;
    this.Tsx = paramh.Trv.TcN.am((kotlin.g.a.a)new d(this, paramh));
    this.Tsy = paramh.Trv.TcN.V((kotlin.g.a.b)new c(this, paramh));
    AppMethodBeat.o(57908);
  }
  
  public final Collection<ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57902);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = (Collection)v.SXr;
    AppMethodBeat.o(57902);
    return paramf;
  }
  
  public final Collection<l> a(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57907);
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    Object localObject1 = kotlin.l.b.a.b.j.f.d.TJQ;
    int i = kotlin.l.b.a.b.j.f.d.hKW();
    localObject1 = kotlin.l.b.a.b.j.f.d.TJQ;
    if (!paramd.avF(i | kotlin.l.b.a.b.j.f.d.hKP()))
    {
      paramd = (Collection)v.SXr;
      AppMethodBeat.o(57907);
      return paramd;
    }
    localObject1 = (Iterable)this.TkB.invoke();
    paramd = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label185:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Object localObject3 = (l)localObject2;
      if ((localObject3 instanceof e))
      {
        localObject3 = ((e)localObject3).hAH();
        p.g(localObject3, "it.name");
        if (!((Boolean)paramb.invoke(localObject3)).booleanValue()) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label185;
        }
        paramd.add(localObject2);
        break;
      }
    }
    paramd = (Collection)paramd;
    AppMethodBeat.o(57907);
    return paramd;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> a(kotlin.l.b.a.b.j.f.d paramd)
  {
    AppMethodBeat.i(57906);
    p.h(paramd, "kindFilter");
    paramd = (Set)x.SXt;
    AppMethodBeat.o(57906);
    return paramd;
  }
  
  final e a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57901);
    if (!kotlin.l.b.a.b.f.h.w(paramf))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    Set localSet = (Set)this.Tsx.invoke();
    if ((paramg == null) && (localSet != null) && (!localSet.contains(paramf.sG())))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    paramf = (e)this.Tsy.invoke(new j.a(paramf, paramg));
    AppMethodBeat.o(57901);
    return paramf;
  }
  
  protected final void a(Collection<am> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57905);
    p.h(paramCollection, "result");
    p.h(paramf, "name");
    AppMethodBeat.o(57905);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> b(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57904);
    p.h(paramd, "kindFilter");
    paramd = (Set)x.SXt;
    AppMethodBeat.o(57904);
    return paramd;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> c(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57903);
    p.h(paramd, "kindFilter");
    Object localObject = kotlin.l.b.a.b.j.f.d.TJQ;
    if (!paramd.avF(kotlin.l.b.a.b.j.f.d.hKP()))
    {
      paramd = (Set)x.SXt;
      AppMethodBeat.o(57903);
      return paramd;
    }
    paramd = (Set)this.Tsx.invoke();
    if (paramd != null)
    {
      paramb = (Iterable)paramd;
      paramd = (Collection)new HashSet();
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramd.add(kotlin.l.b.a.b.f.f.btY((String)paramb.next()));
      }
      paramd = (Set)paramd;
      AppMethodBeat.o(57903);
      return paramd;
    }
    localObject = this.Tsv;
    paramd = paramb;
    if (paramb == null) {
      paramd = kotlin.l.b.a.b.o.d.hLR();
    }
    paramd = (Iterable)((t)localObject).S(paramd);
    paramb = (Collection)new LinkedHashSet();
    localObject = paramd.iterator();
    label219:
    while (((Iterator)localObject).hasNext())
    {
      paramd = (kotlin.l.b.a.b.d.a.e.g)((Iterator)localObject).next();
      if (aa.TtD == null) {}
      for (paramd = null;; paramd = paramd.hAH())
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
  
  public final e e(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57899);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = a(paramf, null);
    AppMethodBeat.o(57899);
    return paramf;
  }
  
  protected final b hDR()
  {
    return (b)b.a.TrL;
  }
  
  static abstract class b
  {
    public static final class a
      extends j.b
    {
      final e Tlv;
      
      public a(e parame)
      {
        super();
        AppMethodBeat.i(57894);
        this.Tlv = parame;
        AppMethodBeat.o(57894);
      }
    }
    
    public static final class b
      extends j.b
    {
      public static final b TsB;
      
      static
      {
        AppMethodBeat.i(57895);
        TsB = new b();
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
      public static final c TsC;
      
      static
      {
        AppMethodBeat.i(57896);
        TsC = new c();
        AppMethodBeat.o(57896);
      }
      
      private c()
      {
        super();
      }
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.b<j.a, e>
  {
    c(j paramj, kotlin.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements kotlin.g.a.a<Set<? extends String>>
  {
    d(j paramj, kotlin.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */