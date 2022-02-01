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
  private final t LoM;
  private final d.l.b.a.b.l.g<Set<String>> LoO;
  private final d.l.b.a.b.l.d<a, e> LoP;
  final h LoQ;
  
  public j(final d.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    super(paramh);
    AppMethodBeat.i(57908);
    this.LoM = paramt;
    this.LoQ = paramh1;
    this.LoO = paramh.LnL.KZf.P((d.g.a.a)new d(this, paramh));
    this.LoP = paramh.LnL.KZf.J((d.g.a.b)new c(this, paramh));
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
    Set localSet = (Set)this.LoO.invoke();
    if ((paramg == null) && (localSet != null) && (!localSet.contains(paramf.rf())))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    paramf = (e)this.LoP.ay(new a(paramf, paramg));
    AppMethodBeat.o(57901);
    return paramf;
  }
  
  public final Collection<ah> a(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57902);
    k.h(paramf, "name");
    k.h(parama, "location");
    paramf = (Collection)v.KTF;
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
    paramd = (Set)x.KTH;
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
    paramd = (Set)x.KTH;
    AppMethodBeat.o(57904);
    return paramd;
  }
  
  protected final Set<f> c(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57903);
    k.h(paramd, "kindFilter");
    Object localObject = d.l.b.a.b.j.f.d.LGP;
    if (!paramd.aiL(d.l.b.a.b.j.f.d.gbL()))
    {
      paramd = (Set)x.KTH;
      AppMethodBeat.o(57903);
      return paramd;
    }
    paramd = (Set)this.LoO.invoke();
    if (paramd != null)
    {
      paramb = (Iterable)paramd;
      paramd = (Collection)new HashSet();
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramd.add(f.aWB((String)paramb.next()));
      }
      paramd = (Set)paramd;
      AppMethodBeat.o(57903);
      return paramd;
    }
    localObject = this.LoM;
    paramd = paramb;
    if (paramb == null) {
      paramd = d.l.b.a.b.o.d.gcL();
    }
    paramd = (Iterable)((t)localObject).G(paramd);
    paramb = (Collection)new LinkedHashSet();
    localObject = paramd.iterator();
    label219:
    while (((Iterator)localObject).hasNext())
    {
      paramd = (d.l.b.a.b.d.a.e.g)((Iterator)localObject).next();
      if (aa.LpU == null) {}
      for (paramd = null;; paramd = paramd.fRf())
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
  
  protected final b fUo()
  {
    return (b)b.a.Loc;
  }
  
  static final class a
  {
    final f Lgj;
    final d.l.b.a.b.d.a.e.g LoR;
    
    public a(f paramf, d.l.b.a.b.d.a.e.g paramg)
    {
      AppMethodBeat.i(57893);
      this.Lgj = paramf;
      this.LoR = paramg;
      AppMethodBeat.o(57893);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(57891);
      if (((paramObject instanceof a)) && (k.g(this.Lgj, ((a)paramObject).Lgj)))
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
      int i = this.Lgj.hashCode();
      AppMethodBeat.o(57892);
      return i;
    }
  }
  
  static abstract class b
  {
    public static final class a
      extends j.b
    {
      final e LhL;
      
      public a(e parame)
      {
        super();
        AppMethodBeat.i(57894);
        this.LhL = parame;
        AppMethodBeat.o(57894);
      }
    }
    
    public static final class b
      extends j.b
    {
      public static final b LoS;
      
      static
      {
        AppMethodBeat.i(57895);
        LoS = new b();
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
      public static final c LoT;
      
      static
      {
        AppMethodBeat.i(57896);
        LoT = new c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */