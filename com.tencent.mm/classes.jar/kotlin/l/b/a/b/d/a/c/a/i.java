package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.ab;
import kotlin.a.ad;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.c.c;
import kotlin.l.b.a.b.d.a.e.ac;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.m;

public final class i
  extends l
{
  private final t aiTn;
  final h aiTt;
  private final kotlin.l.b.a.b.l.i<Set<String>> aiTu;
  private final kotlin.l.b.a.b.l.g<i.a, e> aiTv;
  
  public i(final kotlin.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    super(paramh);
    AppMethodBeat.i(57908);
    this.aiTn = paramt;
    this.aiTt = paramh1;
    this.aiTu = paramh.aiSp.aiBu.cr((a)new d(paramh, this));
    this.aiTv = paramh.aiSp.aiBu.be((kotlin.g.a.b)new c(this, paramh));
    AppMethodBeat.o(57908);
  }
  
  public final Collection<ap> a(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57902);
    s.u(paramf, "name");
    s.u(paramb, "location");
    paramf = (Collection)ab.aivy;
    AppMethodBeat.o(57902);
    return paramf;
  }
  
  public final Collection<kotlin.l.b.a.b.b.l> a(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57907);
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    Object localObject1 = kotlin.l.b.a.b.j.g.d.ajkC;
    int i = kotlin.l.b.a.b.j.g.d.kzH();
    localObject1 = kotlin.l.b.a.b.j.g.d.ajkC;
    if (!paramd.aMn(i | kotlin.l.b.a.b.j.g.d.kzA()))
    {
      paramd = (Collection)ab.aivy;
      AppMethodBeat.o(57907);
      return paramd;
    }
    localObject1 = (Iterable)ksv().invoke();
    paramd = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label185:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Object localObject3 = (kotlin.l.b.a.b.b.l)localObject2;
      if ((localObject3 instanceof e))
      {
        localObject3 = ((e)localObject3).kok();
        s.s(localObject3, "it.name");
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
  
  protected final Set<f> a(kotlin.l.b.a.b.j.g.d paramd)
  {
    AppMethodBeat.i(57906);
    s.u(paramd, "kindFilter");
    paramd = (Set)ad.aivA;
    AppMethodBeat.o(57906);
    return paramd;
  }
  
  final e a(f paramf, kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57901);
    if (!kotlin.l.b.a.b.f.h.x(paramf))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    Set localSet = (Set)this.aiTu.invoke();
    if ((paramg == null) && (localSet != null) && (!localSet.contains(paramf.PF())))
    {
      AppMethodBeat.o(57901);
      return null;
    }
    paramf = (e)this.aiTv.invoke(new i.a(paramf, paramg));
    AppMethodBeat.o(57901);
    return paramf;
  }
  
  protected final void a(Collection<au> paramCollection, f paramf)
  {
    AppMethodBeat.i(57905);
    s.u(paramCollection, "result");
    s.u(paramf, "name");
    AppMethodBeat.o(57905);
  }
  
  protected final Set<f> b(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57903);
    s.u(paramd, "kindFilter");
    Object localObject = kotlin.l.b.a.b.j.g.d.ajkC;
    if (!paramd.aMn(kotlin.l.b.a.b.j.g.d.kzA()))
    {
      paramd = (Set)ad.aivA;
      AppMethodBeat.o(57903);
      return paramd;
    }
    paramd = (Set)this.aiTu.invoke();
    if (paramd != null)
    {
      paramb = (Iterable)paramd;
      paramd = (Collection)new HashSet();
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramd.add(f.bJe((String)paramb.next()));
      }
      paramd = (Set)paramd;
      AppMethodBeat.o(57903);
      return paramd;
    }
    localObject = this.aiTn;
    paramd = paramb;
    if (paramb == null) {
      paramd = kotlin.l.b.a.b.o.d.kAZ();
    }
    paramd = (Iterable)((t)localObject).bb(paramd);
    paramb = (Collection)new LinkedHashSet();
    localObject = paramd.iterator();
    label225:
    while (((Iterator)localObject).hasNext())
    {
      paramd = (kotlin.l.b.a.b.d.a.e.g)((Iterator)localObject).next();
      if (paramd.kqF() == ac.aiUC) {}
      for (paramd = null;; paramd = paramd.kok())
      {
        if (paramd == null) {
          break label225;
        }
        paramb.add(paramd);
        break;
      }
    }
    paramd = (Set)paramb;
    AppMethodBeat.o(57903);
    return paramd;
  }
  
  protected final Set<f> c(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57904);
    s.u(paramd, "kindFilter");
    paramd = (Set)ad.aivA;
    AppMethodBeat.o(57904);
    return paramd;
  }
  
  public final e e(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57899);
    s.u(paramf, "name");
    s.u(paramb, "location");
    paramf = a(paramf, null);
    AppMethodBeat.o(57899);
    return paramf;
  }
  
  protected final b kst()
  {
    return (b)b.a.aiSG;
  }
  
  static abstract class b
  {
    public static final class a
      extends i.b
    {
      final e aiLa;
      
      public a(e parame)
      {
        super();
        AppMethodBeat.i(57894);
        this.aiLa = parame;
        AppMethodBeat.o(57894);
      }
    }
    
    public static final class b
      extends i.b
    {
      public static final b aiTx;
      
      static
      {
        AppMethodBeat.i(57895);
        aiTx = new b();
        AppMethodBeat.o(57895);
      }
      
      private b()
      {
        super();
      }
    }
    
    public static final class c
      extends i.b
    {
      public static final c aiTy;
      
      static
      {
        AppMethodBeat.i(57896);
        aiTy = new c();
        AppMethodBeat.o(57896);
      }
      
      private c()
      {
        super();
      }
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.b<i.a, e>
  {
    c(i parami, kotlin.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
  
  static final class d
    extends u
    implements a<Set<? extends String>>
  {
    d(kotlin.l.b.a.b.d.a.c.h paramh, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.i
 * JD-Core Version:    0.7.0.1
 */