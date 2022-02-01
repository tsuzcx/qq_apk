package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.a.x;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.d.a.e.aa;
import d.l.b.a.b.d.a.e.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class j
  extends m
{
  private final t NCO;
  private final d.l.b.a.b.l.g<Set<String>> NCQ;
  private final d.l.b.a.b.l.d<a, e> NCR;
  final h NCS;
  
  public j(final d.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    super(paramh);
    AppMethodBeat.i(57908);
    this.NCO = paramt;
    this.NCS = paramh1;
    this.NCQ = paramh.NBN.Nnf.T((d.g.a.a)new d(this, paramh));
    this.NCR = paramh.NBN.Nnf.M((d.g.a.b)new c(this, paramh));
    AppMethodBeat.o(57908);
  }
  
  final e a(d.l.b.a.b.f.f paramf, d.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57901);
    if (!d.l.b.a.b.f.h.w(paramf))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    Set localSet = (Set)this.NCQ.invoke();
    if ((paramg == null) && (localSet != null) && (!localSet.contains(paramf.sD())))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    paramf = (e)this.NCR.invoke(new a(paramf, paramg));
    AppMethodBeat.o(57901);
    return paramf;
  }
  
  public final Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57902);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = (Collection)v.NhH;
    AppMethodBeat.o(57902);
    return paramf;
  }
  
  public final Collection<l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57907);
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    Object localObject1 = d.l.b.a.b.j.f.d.NUU;
    int i = d.l.b.a.b.j.f.d.gxT();
    localObject1 = d.l.b.a.b.j.f.d.NUU;
    if (!paramd.alW(i | d.l.b.a.b.j.f.d.gxM()))
    {
      paramd = (Collection)v.NhH;
      AppMethodBeat.o(57907);
      return paramd;
    }
    localObject1 = (Iterable)this.NuT.invoke();
    paramd = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label186:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Object localObject3 = (l)localObject2;
      if ((localObject3 instanceof e))
      {
        localObject3 = ((e)localObject3).gnf();
        p.g(localObject3, "it.name");
        if (!((Boolean)paramb.invoke(localObject3)).booleanValue()) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label186;
        }
        paramd.add(localObject2);
        break;
      }
    }
    paramd = (Collection)paramd;
    AppMethodBeat.o(57907);
    return paramd;
  }
  
  protected final Set<d.l.b.a.b.f.f> a(d.l.b.a.b.j.f.d paramd)
  {
    AppMethodBeat.i(57906);
    p.h(paramd, "kindFilter");
    paramd = (Set)x.NhJ;
    AppMethodBeat.o(57906);
    return paramd;
  }
  
  protected final void a(Collection<am> paramCollection, d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57905);
    p.h(paramCollection, "result");
    p.h(paramf, "name");
    AppMethodBeat.o(57905);
  }
  
  protected final Set<d.l.b.a.b.f.f> b(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57904);
    p.h(paramd, "kindFilter");
    paramd = (Set)x.NhJ;
    AppMethodBeat.o(57904);
    return paramd;
  }
  
  protected final Set<d.l.b.a.b.f.f> c(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57903);
    p.h(paramd, "kindFilter");
    Object localObject = d.l.b.a.b.j.f.d.NUU;
    if (!paramd.alW(d.l.b.a.b.j.f.d.gxM()))
    {
      paramd = (Set)x.NhJ;
      AppMethodBeat.o(57903);
      return paramd;
    }
    paramd = (Set)this.NCQ.invoke();
    if (paramd != null)
    {
      paramb = (Iterable)paramd;
      paramd = (Collection)new HashSet();
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramd.add(d.l.b.a.b.f.f.bei((String)paramb.next()));
      }
      paramd = (Set)paramd;
      AppMethodBeat.o(57903);
      return paramd;
    }
    localObject = this.NCO;
    paramd = paramb;
    if (paramb == null) {
      paramd = d.l.b.a.b.o.d.gyO();
    }
    paramd = (Iterable)((t)localObject).J(paramd);
    paramb = (Collection)new LinkedHashSet();
    localObject = paramd.iterator();
    label219:
    while (((Iterator)localObject).hasNext())
    {
      paramd = (d.l.b.a.b.d.a.e.g)((Iterator)localObject).next();
      if (aa.NDW == null) {}
      for (paramd = null;; paramd = paramd.gnf())
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
  
  public final e e(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57899);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = a(paramf, null);
    AppMethodBeat.o(57899);
    return paramf;
  }
  
  protected final b gqp()
  {
    return (b)b.a.NCe;
  }
  
  static final class a
  {
    final d.l.b.a.b.d.a.e.g NCT;
    final d.l.b.a.b.f.f Nul;
    
    public a(d.l.b.a.b.f.f paramf, d.l.b.a.b.d.a.e.g paramg)
    {
      AppMethodBeat.i(57893);
      this.Nul = paramf;
      this.NCT = paramg;
      AppMethodBeat.o(57893);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(57891);
      if (((paramObject instanceof a)) && (p.i(this.Nul, ((a)paramObject).Nul)))
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
      int i = this.Nul.hashCode();
      AppMethodBeat.o(57892);
      return i;
    }
  }
  
  static abstract class b
  {
    public static final class a
      extends j.b
    {
      final e NvN;
      
      public a(e parame)
      {
        super();
        AppMethodBeat.i(57894);
        this.NvN = parame;
        AppMethodBeat.o(57894);
      }
    }
    
    public static final class b
      extends j.b
    {
      public static final b NCU;
      
      static
      {
        AppMethodBeat.i(57895);
        NCU = new b();
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
      public static final c NCV;
      
      static
      {
        AppMethodBeat.i(57896);
        NCV = new c();
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
    implements d.g.a.b<j.a, e>
  {
    c(j paramj, d.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements d.g.a.a<Set<? extends String>>
  {
    d(j paramj, d.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */