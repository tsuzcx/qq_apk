package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.a.m;
import d.l.b.a.b.b.an;
import d.l.b.a.b.e.a.b.b;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.r;
import d.l.b.a.b.e.a.t;
import d.l.b.a.b.e.b.b.a;
import d.l.b.a.b.e.b.g;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.f;
import d.l.b.a.b.h.q;
import d.l.b.a.b.k.a.z;
import d.l.b.a.b.k.a.z.a;
import d.l.b.a.b.k.a.z.b;
import d.l.b.a.b.m.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a<A, C>
  implements d.l.b.a.b.k.a.c<A, C>
{
  private static final Set<d.l.b.a.b.f.a> Lrn;
  public static final a Lro = new a((byte)0);
  private final n Lnh;
  private final d.l.b.a.b.l.c<p, c<A, C>> Lrm;
  
  static
  {
    Object localObject = (Iterable)d.a.j.listOf(new d.l.b.a.b.f.b[] { d.l.b.a.b.d.a.p.Llz, d.l.b.a.b.d.a.p.LlC, d.l.b.a.b.d.a.p.LlD, new d.l.b.a.b.f.b("java.lang.annotation.Target"), new d.l.b.a.b.f.b("java.lang.annotation.Retention"), new d.l.b.a.b.f.b("java.lang.annotation.Documented") });
    Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(d.l.b.a.b.f.a.p((d.l.b.a.b.f.b)((Iterator)localObject).next()));
    }
    Lrn = d.a.j.n((Iterable)localCollection);
  }
  
  public a(d.l.b.a.b.l.i parami, n paramn)
  {
    this.Lnh = paramn;
    this.Lrm = parami.I((d.g.a.b)new f(this));
  }
  
  private static p a(z.a parama)
  {
    Object localObject1 = null;
    Object localObject2 = parama.LeC;
    parama = (z.a)localObject2;
    if (!(localObject2 instanceof r)) {
      parama = null;
    }
    localObject2 = (r)parama;
    parama = localObject1;
    if (localObject2 != null) {
      parama = ((r)localObject2).Lsg;
    }
    return parama;
  }
  
  private static p a(z paramz, p paramp)
  {
    if (paramp != null) {
      return paramp;
    }
    if ((paramz instanceof z.a)) {
      return a((z.a)paramz);
    }
    return null;
  }
  
  private final p a(z paramz, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (paramBoolean == null) {
        throw ((Throwable)new IllegalStateException(("isConst should not be null for property (container=" + paramz + ')').toString()));
      }
      if (((paramz instanceof z.a)) && (((z.a)paramz).LIz == a.b.b.Lug))
      {
        paramBoolean = this.Lnh;
        paramz = ((z.a)paramz).LbB.o(d.l.b.a.b.f.f.aWB("DefaultImpls"));
        k.g(paramz, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
        return o.a(paramBoolean, paramz);
      }
      if ((paramBoolean.booleanValue()) && ((paramz instanceof z.b)))
      {
        an localan = paramz.LeC;
        paramBoolean = localan;
        if (!(localan instanceof j)) {
          paramBoolean = null;
        }
        paramBoolean = (j)paramBoolean;
        if (paramBoolean != null) {}
        for (paramBoolean = paramBoolean.LrX; paramBoolean != null; paramBoolean = null)
        {
          paramz = this.Lnh;
          paramBoolean = paramBoolean.gbE();
          k.g(paramBoolean, "facadeClassName.internalName");
          paramBoolean = d.l.b.a.b.f.a.p(new d.l.b.a.b.f.b(d.n.n.a(paramBoolean, '/', '.')));
          k.g(paramBoolean, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
          return o.a(paramz, paramBoolean);
        }
      }
    }
    if ((paramBoolean2) && ((paramz instanceof z.a)) && (((z.a)paramz).LIz == a.b.b.Lul))
    {
      paramBoolean = ((z.a)paramz).LIA;
      if ((paramBoolean != null) && ((paramBoolean.LIz == a.b.b.Luf) || (paramBoolean.LIz == a.b.b.Luh) || ((paramBoolean3) && ((paramBoolean.LIz == a.b.b.Lug) || (paramBoolean.LIz == a.b.b.Luj))))) {
        return a(paramBoolean);
      }
    }
    if (((paramz instanceof z.b)) && ((paramz.LeC instanceof j)))
    {
      paramz = paramz.LeC;
      if (paramz == null) {
        throw new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
      }
      paramz = (j)paramz;
      paramBoolean = paramz.Lsa;
      if (paramBoolean == null) {
        return o.a(this.Lnh, paramz.fOT());
      }
    }
    else
    {
      return null;
    }
    return paramBoolean;
  }
  
  private static s a(a.m paramm, d.l.b.a.b.e.b.c paramc, h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = (i.c)paramm;
    i.f localf = d.l.b.a.b.e.c.a.Lyh;
    k.g(localf, "propertySignature");
    localObject = (d.l.b.a.b.e.c.a.c)d.l.b.a.b.e.b.f.a((i.c)localObject, localf);
    if (localObject == null) {
      return null;
    }
    if (paramBoolean1)
    {
      localObject = d.l.b.a.b.e.c.a.i.Lzg;
      paramm = d.l.b.a.b.e.c.a.i.a(paramm, paramc, paramh, paramBoolean3);
      if (paramm == null) {
        return null;
      }
      paramc = s.Lsh;
      return s.a.a((d.l.b.a.b.e.c.a.e)paramm);
    }
    if ((paramBoolean2) && (((d.l.b.a.b.e.c.a.c)localObject).fZb()))
    {
      paramm = s.Lsh;
      paramm = ((d.l.b.a.b.e.c.a.c)localObject).Lyu;
      k.g(paramm, "signature.syntheticMethod");
      return s.a.a(paramc, paramm);
    }
    return null;
  }
  
  private static s a(q paramq, d.l.b.a.b.e.b.c paramc, h paramh, d.l.b.a.b.k.a.b paramb, boolean paramBoolean)
  {
    if ((paramq instanceof d.l.b.a.b.e.a.c))
    {
      paramb = s.Lsh;
      paramb = d.l.b.a.b.e.c.a.i.Lzg;
      paramq = d.l.b.a.b.e.c.a.i.a((d.l.b.a.b.e.a.c)paramq, paramc, paramh);
      if (paramq != null) {
        return s.a.a((d.l.b.a.b.e.c.a.e)paramq);
      }
      return null;
    }
    if ((paramq instanceof a.h))
    {
      paramb = s.Lsh;
      paramb = d.l.b.a.b.e.c.a.i.Lzg;
      paramq = d.l.b.a.b.e.c.a.i.a((a.h)paramq, paramc, paramh);
      if (paramq != null) {
        return s.a.a((d.l.b.a.b.e.c.a.e)paramq);
      }
      return null;
    }
    if ((paramq instanceof a.m))
    {
      Object localObject = (i.c)paramq;
      i.f localf = d.l.b.a.b.e.c.a.Lyh;
      k.g(localf, "propertySignature");
      localObject = (d.l.b.a.b.e.c.a.c)d.l.b.a.b.e.b.f.a((i.c)localObject, localf);
      if (localObject == null) {
        return null;
      }
      switch (b.cfA[paramb.ordinal()])
      {
      default: 
        return null;
      case 1: 
        if (((d.l.b.a.b.e.c.a.c)localObject).fZc())
        {
          paramq = s.Lsh;
          paramq = ((d.l.b.a.b.e.c.a.c)localObject).Lyv;
          k.g(paramq, "signature.getter");
          return s.a.a(paramc, paramq);
        }
        return null;
      case 2: 
        if (((d.l.b.a.b.e.c.a.c)localObject).fZd())
        {
          paramq = s.Lsh;
          paramq = ((d.l.b.a.b.e.c.a.c)localObject).Lyw;
          k.g(paramq, "signature.setter");
          return s.a.a(paramc, paramq);
        }
        return null;
      }
      return a((a.m)paramq, paramc, paramh, true, true, paramBoolean);
    }
    return null;
  }
  
  private final List<A> a(z paramz, s params, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    paramz = a(paramz, a(paramz, paramBoolean1, paramBoolean2, paramBoolean, paramBoolean3));
    if (paramz == null) {
      paramz = (List)d.a.v.KTF;
    }
    do
    {
      return paramz;
      params = (List)((c)this.Lrm.ay(paramz)).Lrt.get(params);
      paramz = params;
    } while (params != null);
    return (List)d.a.v.KTF;
  }
  
  private final List<A> a(z paramz, a.m paramm, b paramb)
  {
    Boolean localBoolean = d.l.b.a.b.e.b.b.LxJ.aij(paramm.Ltw);
    k.g(localBoolean, "Flags.IS_CONST.get(proto.flags)");
    boolean bool2 = localBoolean.booleanValue();
    boolean bool3 = d.l.b.a.b.e.c.a.i.f(paramm);
    if (paramb == b.Lrp)
    {
      paramm = a(paramm, paramz.KVO, paramz.KVP, false, true, false, 40);
      if (paramm == null) {
        return (List)d.a.v.KTF;
      }
      return a(this, paramz, paramm, true, Boolean.valueOf(bool2), bool3, 8);
    }
    paramm = a(paramm, paramz.KVO, paramz.KVP, true, false, false, 48);
    if (paramm == null) {
      return (List)d.a.v.KTF;
    }
    boolean bool4 = d.n.n.a((CharSequence)paramm.signature, (CharSequence)"$delegate", false);
    if (paramb == b.Lrr) {}
    for (boolean bool1 = true; bool4 != bool1; bool1 = false) {
      return (List)d.a.v.KTF;
    }
    return a(paramz, paramm, true, true, Boolean.valueOf(bool2), bool3);
  }
  
  protected abstract p.a a(d.l.b.a.b.f.a parama, an paraman, List<A> paramList);
  
  protected abstract A a(d.l.b.a.b.e.a.a parama, d.l.b.a.b.e.b.c paramc);
  
  public final C a(z paramz, a.m paramm, ab paramab)
  {
    boolean bool2 = true;
    k.h(paramz, "container");
    k.h(paramm, "proto");
    k.h(paramab, "expectedType");
    p localp = a(paramz, a(paramz, true, true, d.l.b.a.b.e.b.b.LxJ.aij(paramm.Ltw), d.l.b.a.b.e.c.a.i.f(paramm)));
    if (localp == null) {
      paramz = null;
    }
    do
    {
      return paramz;
      d.l.b.a.b.e.c.a.f localf = localp.fSX().LsD;
      Object localObject = e.LrQ;
      localObject = (d.l.b.a.b.e.b.a)e.fUG();
      k.h(localObject, "version");
      int i = ((d.l.b.a.b.e.b.a)localObject).major;
      int j = ((d.l.b.a.b.e.b.a)localObject).minor;
      int k = ((d.l.b.a.b.e.b.a)localObject).Lxj;
      boolean bool1;
      if (localf.major > i) {
        bool1 = bool2;
      }
      for (;;)
      {
        paramz = a((q)paramm, paramz.KVO, paramz.KVP, d.l.b.a.b.k.a.b.LHt, bool1);
        if (paramz != null) {
          break;
        }
        return null;
        if (localf.major >= i)
        {
          bool1 = bool2;
          if (localf.minor > j) {
            continue;
          }
          if (localf.minor >= j)
          {
            bool1 = bool2;
            if (localf.Lxj >= k) {
              continue;
            }
          }
        }
        bool1 = false;
      }
      paramm = ((c)this.Lrm.ay(localp)).Lru.get(paramz);
      if (paramm == null) {
        return null;
      }
      paramz = m.LbG;
      paramz = paramm;
    } while (!m.F(paramab));
    return fg(paramm);
  }
  
  public final List<A> a(a.p paramp, d.l.b.a.b.e.b.c paramc)
  {
    k.h(paramp, "proto");
    k.h(paramc, "nameResolver");
    paramp = paramp.e(d.l.b.a.b.e.c.a.Lxh);
    k.g(paramp, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
    Object localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.e.a.a locala = (d.l.b.a.b.e.a.a)((Iterator)localObject).next();
      k.g(locala, "it");
      paramp.add(a(locala, paramc));
    }
    return (List)paramp;
  }
  
  public final List<A> a(a.r paramr, d.l.b.a.b.e.b.c paramc)
  {
    k.h(paramr, "proto");
    k.h(paramc, "nameResolver");
    paramr = paramr.e(d.l.b.a.b.e.c.a.Lxi);
    k.g(paramr, "proto.getExtension(JvmPr….typeParameterAnnotation)");
    Object localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.e.a.a locala = (d.l.b.a.b.e.a.a)((Iterator)localObject).next();
      k.g(locala, "it");
      paramr.add(a(locala, paramc));
    }
    return (List)paramr;
  }
  
  public final List<A> a(z paramz, d.l.b.a.b.e.a.f paramf)
  {
    k.h(paramz, "container");
    k.h(paramf, "proto");
    Object localObject = s.Lsh;
    paramf = paramz.KVO.getString(paramf.LuF);
    localObject = ((z.a)paramz).LbB.rf();
    k.g(localObject, "(container as ProtoConta…Class).classId.asString()");
    return a(this, paramz, s.a.mW(paramf, d.l.b.a.b.e.c.a.b.aWz((String)localObject)), false, null, false, 60);
  }
  
  public final List<A> a(z paramz, a.m paramm)
  {
    k.h(paramz, "container");
    k.h(paramm, "proto");
    return a(paramz, paramm, b.Lrq);
  }
  
  public final List<A> a(z paramz, q paramq, d.l.b.a.b.k.a.b paramb)
  {
    k.h(paramz, "container");
    k.h(paramq, "proto");
    k.h(paramb, "kind");
    if (paramb == d.l.b.a.b.k.a.b.LHt) {
      return a(paramz, (a.m)paramq, b.Lrp);
    }
    paramq = a(paramq, paramz.KVO, paramz.KVP, paramb);
    if (paramq == null) {
      return (List)d.a.v.KTF;
    }
    return a(this, paramz, paramq, false, null, false, 60);
  }
  
  public final List<A> a(z paramz, q paramq, d.l.b.a.b.k.a.b paramb, int paramInt, a.t paramt)
  {
    k.h(paramz, "container");
    k.h(paramq, "callableProto");
    k.h(paramb, "kind");
    k.h(paramt, "proto");
    paramb = a(paramq, paramz.KVO, paramz.KVP, paramb);
    if (paramb != null)
    {
      int i;
      if ((paramq instanceof a.h)) {
        if (g.f((a.h)paramq)) {
          i = 1;
        }
      }
      for (;;)
      {
        paramq = s.Lsh;
        return a(this, paramz, s.a.a(paramb, i + paramInt), false, null, false, 60);
        i = 0;
        continue;
        if ((paramq instanceof a.m))
        {
          if (g.e((a.m)paramq)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else
        {
          if (!(paramq instanceof d.l.b.a.b.e.a.c)) {
            break;
          }
          if (paramz == null) {
            throw new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
          }
          if (((z.a)paramz).LIz == a.b.b.Luh) {
            i = 2;
          } else if (((z.a)paramz).LdR) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      throw ((Throwable)new UnsupportedOperationException("Unsupported message: " + paramq.getClass()));
    }
    return (List)d.a.v.KTF;
  }
  
  public final List<A> b(final z.a parama)
  {
    k.h(parama, "container");
    p localp = a(parama);
    if (localp == null) {
      throw ((Throwable)new IllegalStateException(("Class for loading annotations is not found: " + parama.gcb()).toString()));
    }
    parama = new ArrayList(1);
    p.c localc = (p.c)new e(this, parama);
    k.h(localp, "kotlinClass");
    localp.a(localc);
    return (List)parama;
  }
  
  public final List<A> b(z paramz, a.m paramm)
  {
    k.h(paramz, "container");
    k.h(paramm, "proto");
    return a(paramz, paramm, b.Lrr);
  }
  
  public final List<A> b(z paramz, q paramq, d.l.b.a.b.k.a.b paramb)
  {
    k.h(paramz, "container");
    k.h(paramq, "proto");
    k.h(paramb, "kind");
    paramq = a(paramq, paramz.KVO, paramz.KVP, paramb);
    if (paramq != null)
    {
      paramb = s.Lsh;
      return a(this, paramz, s.a.a(paramq, 0), false, null, false, 60);
    }
    return (List)d.a.v.KTF;
  }
  
  protected abstract C fg(C paramC);
  
  public static final class a {}
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(58144);
      b localb1 = new b("PROPERTY", 0);
      Lrp = localb1;
      b localb2 = new b("BACKING_FIELD", 1);
      Lrq = localb2;
      b localb3 = new b("DELEGATE_FIELD", 2);
      Lrr = localb3;
      Lrs = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(58144);
    }
    
    private b() {}
  }
  
  static final class c<A, C>
  {
    final Map<s, List<A>> Lrt;
    final Map<s, C> Lru;
    
    public c(Map<s, ? extends List<? extends A>> paramMap, Map<s, ? extends C> paramMap1)
    {
      AppMethodBeat.i(58147);
      this.Lrt = paramMap;
      this.Lru = paramMap1;
      AppMethodBeat.o(58147);
    }
  }
  
  public static final class d
    implements p.d
  {
    d(HashMap paramHashMap1, HashMap paramHashMap2) {}
    
    public final p.e a(d.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58154);
      k.h(paramf, "name");
      k.h(paramString, "desc");
      s.a locala = s.Lsh;
      paramf = paramf.rf();
      k.g(paramf, "name.asString()");
      paramf = (p.e)new a(s.a.mV(paramf, paramString));
      AppMethodBeat.o(58154);
      return paramf;
    }
    
    public final p.c b(d.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58155);
      k.h(paramf, "name");
      k.h(paramString, "desc");
      s.a locala = s.Lsh;
      paramf = paramf.rf();
      k.g(paramf, "name.asString()");
      paramf = (p.c)new b(s.a.mW(paramf, paramString));
      AppMethodBeat.o(58155);
      return paramf;
    }
    
    public final class a
      extends a.d.b
      implements p.e
    {
      public a()
      {
        super(localObject);
        AppMethodBeat.i(58150);
        AppMethodBeat.o(58150);
      }
      
      public final p.a a(int paramInt, d.l.b.a.b.f.a parama, an paraman)
      {
        AppMethodBeat.i(58149);
        k.h(parama, "classId");
        k.h(paraman, "source");
        Object localObject = s.Lsh;
        s locals = s.a.a(this.LrA, paramInt);
        List localList = (List)a.d.this.Lrw.get(locals);
        localObject = localList;
        if (localList == null)
        {
          localObject = (List)new ArrayList();
          ((Map)a.d.this.Lrw).put(locals, localObject);
        }
        parama = a.a(a.d.this.Lrv, parama, paraman, (List)localObject);
        AppMethodBeat.o(58149);
        return parama;
      }
    }
    
    public class b
      implements p.c
    {
      final s LrA;
      private final ArrayList<A> Lrz;
      
      public b()
      {
        AppMethodBeat.i(58153);
        this.LrA = localObject;
        this.Lrz = new ArrayList();
        AppMethodBeat.o(58153);
      }
      
      public final void Hm()
      {
        AppMethodBeat.i(58152);
        if (!((Collection)this.Lrz).isEmpty()) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            ((Map)a.d.this.Lrw).put(this.LrA, this.Lrz);
          }
          AppMethodBeat.o(58152);
          return;
        }
      }
      
      public final p.a a(d.l.b.a.b.f.a parama, an paraman)
      {
        AppMethodBeat.i(58151);
        k.h(parama, "classId");
        k.h(paraman, "source");
        parama = a.a(a.d.this.Lrv, parama, paraman, (List)this.Lrz);
        AppMethodBeat.o(58151);
        return parama;
      }
    }
  }
  
  public static final class e
    implements p.c
  {
    e(ArrayList paramArrayList) {}
    
    public final void Hm() {}
    
    public final p.a a(d.l.b.a.b.f.a parama, an paraman)
    {
      AppMethodBeat.i(58156);
      k.h(parama, "classId");
      k.h(paraman, "source");
      parama = a.a(this.Lrv, parama, paraman, (List)parama);
      AppMethodBeat.o(58156);
      return parama;
    }
  }
  
  static final class f
    extends l
    implements d.g.a.b<p, a.c<? extends A, ? extends C>>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.a
 * JD-Core Version:    0.7.0.1
 */