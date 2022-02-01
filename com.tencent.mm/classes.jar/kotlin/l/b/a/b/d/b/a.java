package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.v;
import kotlin.l.b.a.b.a.m;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.e.a.b.b;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.a.t;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.e.b.g;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.c.a.i;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.f;
import kotlin.l.b.a.b.k.a.z;
import kotlin.l.b.a.b.k.a.z.a;
import kotlin.l.b.a.b.k.a.z.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.t;

public abstract class a<A, C>
  implements kotlin.l.b.a.b.k.a.c<A, C>
{
  private static final Set<kotlin.l.b.a.b.f.a> TuW;
  public static final a TuX = new a((byte)0);
  private final n TqR;
  private final kotlin.l.b.a.b.l.c<p, a.c<A, C>> TuV;
  
  static
  {
    Object localObject = (Iterable)kotlin.a.j.listOf(new kotlin.l.b.a.b.f.b[] { kotlin.l.b.a.b.d.a.p.Tpj, kotlin.l.b.a.b.d.a.p.Tpm, kotlin.l.b.a.b.d.a.p.Tpn, new kotlin.l.b.a.b.f.b("java.lang.annotation.Target"), new kotlin.l.b.a.b.f.b("java.lang.annotation.Retention"), new kotlin.l.b.a.b.f.b("java.lang.annotation.Documented") });
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(kotlin.l.b.a.b.f.a.p((kotlin.l.b.a.b.f.b)((Iterator)localObject).next()));
    }
    TuW = kotlin.a.j.r((Iterable)localCollection);
  }
  
  public a(kotlin.l.b.a.b.l.j paramj, n paramn)
  {
    this.TqR = paramn;
    this.TuV = paramj.U((kotlin.g.a.b)new f(this));
  }
  
  private final List<A> a(z paramz, s params, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    paramz = a(paramz, a(paramz, paramBoolean1, paramBoolean2, paramBoolean, paramBoolean3));
    if (paramz == null) {
      paramz = (List)v.SXr;
    }
    do
    {
      return paramz;
      params = (List)((a.c)this.TuV.invoke(paramz)).Tvc.get(params);
      paramz = params;
    } while (params != null);
    return (List)v.SXr;
  }
  
  private final List<A> a(z paramz, a.m paramm, a.b paramb)
  {
    Boolean localBoolean = kotlin.l.b.a.b.e.b.b.TBq.avk(paramm.Txb);
    kotlin.g.b.p.g(localBoolean, "Flags.IS_CONST.get(proto.flags)");
    boolean bool2 = localBoolean.booleanValue();
    boolean bool3 = i.f(paramm);
    if (paramb == a.b.TuY)
    {
      paramm = a(paramm, paramz.SZH, paramz.SZI, false, true, false, 40);
      if (paramm == null) {
        return (List)v.SXr;
      }
      return a(this, paramz, paramm, true, Boolean.valueOf(bool2), bool3, 8);
    }
    paramm = a(paramm, paramz.SZH, paramz.SZI, true, false, false, 48);
    if (paramm == null) {
      return (List)v.SXr;
    }
    boolean bool4 = kotlin.n.n.a((CharSequence)paramm.signature, (CharSequence)"$delegate", false);
    if (paramb == a.b.Tva) {}
    for (boolean bool1 = true; bool4 != bool1; bool1 = false) {
      return (List)v.SXr;
    }
    return a(paramz, paramm, true, true, Boolean.valueOf(bool2), bool3);
  }
  
  private static p a(z.a parama)
  {
    Object localObject1 = null;
    Object localObject2 = parama.Tik;
    parama = (z.a)localObject2;
    if (!(localObject2 instanceof r)) {
      parama = null;
    }
    localObject2 = (r)parama;
    parama = localObject1;
    if (localObject2 != null) {
      parama = ((r)localObject2).TvP;
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
      if (((paramz instanceof z.a)) && (((z.a)paramz).TLA == a.b.b.TxL))
      {
        paramBoolean = this.TqR;
        paramz = ((z.a)paramz).Tfj.o(kotlin.l.b.a.b.f.f.btY("DefaultImpls"));
        kotlin.g.b.p.g(paramz, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
        return o.a(paramBoolean, paramz);
      }
      if ((paramBoolean.booleanValue()) && ((paramz instanceof z.b)))
      {
        an localan = paramz.Tik;
        paramBoolean = localan;
        if (!(localan instanceof j)) {
          paramBoolean = null;
        }
        paramBoolean = (j)paramBoolean;
        if (paramBoolean != null) {}
        for (paramBoolean = paramBoolean.TvG; paramBoolean != null; paramBoolean = null)
        {
          paramz = this.TqR;
          paramBoolean = paramBoolean.hKI();
          kotlin.g.b.p.g(paramBoolean, "facadeClassName.internalName");
          paramBoolean = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(kotlin.n.n.a(paramBoolean, '/', '.')));
          kotlin.g.b.p.g(paramBoolean, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
          return o.a(paramz, paramBoolean);
        }
      }
    }
    if ((paramBoolean2) && ((paramz instanceof z.a)) && (((z.a)paramz).TLA == a.b.b.TxQ))
    {
      paramBoolean = ((z.a)paramz).TLB;
      if ((paramBoolean != null) && ((paramBoolean.TLA == a.b.b.TxK) || (paramBoolean.TLA == a.b.b.TxM) || ((paramBoolean3) && ((paramBoolean.TLA == a.b.b.TxL) || (paramBoolean.TLA == a.b.b.TxO))))) {
        return a(paramBoolean);
      }
    }
    if (((paramz instanceof z.b)) && ((paramz.Tik instanceof j)))
    {
      paramz = paramz.Tik;
      if (paramz == null) {
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
      }
      paramz = (j)paramz;
      paramBoolean = paramz.TvJ;
      if (paramBoolean == null) {
        return o.a(this.TqR, paramz.hyy());
      }
    }
    else
    {
      return null;
    }
    return paramBoolean;
  }
  
  private static s a(a.m paramm, kotlin.l.b.a.b.e.b.c paramc, h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = (i.c)paramm;
    i.f localf = kotlin.l.b.a.b.e.c.a.TBO;
    kotlin.g.b.p.g(localf, "propertySignature");
    localObject = (kotlin.l.b.a.b.e.c.a.c)kotlin.l.b.a.b.e.b.f.a((i.c)localObject, localf);
    if (localObject == null) {
      return null;
    }
    if (paramBoolean1)
    {
      localObject = i.TCN;
      paramm = i.a(paramm, paramc, paramh, paramBoolean3);
      if (paramm == null) {
        return null;
      }
      paramc = s.TvQ;
      return s.a.a((kotlin.l.b.a.b.e.c.a.e)paramm);
    }
    if ((paramBoolean2) && (((kotlin.l.b.a.b.e.c.a.c)localObject).hIz()))
    {
      paramm = s.TvQ;
      paramm = ((kotlin.l.b.a.b.e.c.a.c)localObject).TCb;
      kotlin.g.b.p.g(paramm, "signature.syntheticMethod");
      return s.a.a(paramc, paramm);
    }
    return null;
  }
  
  private static s a(kotlin.l.b.a.b.h.q paramq, kotlin.l.b.a.b.e.b.c paramc, h paramh, kotlin.l.b.a.b.k.a.b paramb, boolean paramBoolean)
  {
    if ((paramq instanceof kotlin.l.b.a.b.e.a.c))
    {
      paramb = s.TvQ;
      paramb = i.TCN;
      paramq = i.a((kotlin.l.b.a.b.e.a.c)paramq, paramc, paramh);
      if (paramq != null) {
        return s.a.a((kotlin.l.b.a.b.e.c.a.e)paramq);
      }
      return null;
    }
    if ((paramq instanceof a.h))
    {
      paramb = s.TvQ;
      paramb = i.TCN;
      paramq = i.a((a.h)paramq, paramc, paramh);
      if (paramq != null) {
        return s.a.a((kotlin.l.b.a.b.e.c.a.e)paramq);
      }
      return null;
    }
    if ((paramq instanceof a.m))
    {
      Object localObject = (i.c)paramq;
      i.f localf = kotlin.l.b.a.b.e.c.a.TBO;
      kotlin.g.b.p.g(localf, "propertySignature");
      localObject = (kotlin.l.b.a.b.e.c.a.c)kotlin.l.b.a.b.e.b.f.a((i.c)localObject, localf);
      if (localObject == null) {
        return null;
      }
      switch (b.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        return null;
      case 1: 
        if (((kotlin.l.b.a.b.e.c.a.c)localObject).hIA())
        {
          paramq = s.TvQ;
          paramq = ((kotlin.l.b.a.b.e.c.a.c)localObject).TCc;
          kotlin.g.b.p.g(paramq, "signature.getter");
          return s.a.a(paramc, paramq);
        }
        return null;
      case 2: 
        if (((kotlin.l.b.a.b.e.c.a.c)localObject).hIB())
        {
          paramq = s.TvQ;
          paramq = ((kotlin.l.b.a.b.e.c.a.c)localObject).TCd;
          kotlin.g.b.p.g(paramq, "signature.setter");
          return s.a.a(paramc, paramq);
        }
        return null;
      }
      return a((a.m)paramq, paramc, paramh, true, true, paramBoolean);
    }
    return null;
  }
  
  protected abstract A a(kotlin.l.b.a.b.e.a.a parama, kotlin.l.b.a.b.e.b.c paramc);
  
  public final C a(z paramz, a.m paramm, ab paramab)
  {
    boolean bool2 = true;
    kotlin.g.b.p.h(paramz, "container");
    kotlin.g.b.p.h(paramm, "proto");
    kotlin.g.b.p.h(paramab, "expectedType");
    p localp = a(paramz, a(paramz, true, true, kotlin.l.b.a.b.e.b.b.TBq.avk(paramm.Txb), i.f(paramm)));
    if (localp == null) {
      paramz = null;
    }
    do
    {
      return paramz;
      kotlin.l.b.a.b.e.c.a.f localf = localp.hCA().Twm;
      Object localObject = e.Tvz;
      localObject = (kotlin.l.b.a.b.e.b.a)e.hEj();
      kotlin.g.b.p.h(localObject, "version");
      int i = ((kotlin.l.b.a.b.e.b.a)localObject).major;
      int j = ((kotlin.l.b.a.b.e.b.a)localObject).minor;
      int k = ((kotlin.l.b.a.b.e.b.a)localObject).TAP;
      boolean bool1;
      if (localf.major > i) {
        bool1 = bool2;
      }
      for (;;)
      {
        paramz = a((kotlin.l.b.a.b.h.q)paramm, paramz.SZH, paramz.SZI, kotlin.l.b.a.b.k.a.b.TKu, bool1);
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
            if (localf.TAP >= k) {
              continue;
            }
          }
        }
        bool1 = false;
      }
      paramm = ((a.c)this.TuV.invoke(localp)).Tvd.get(paramz);
      if (paramm == null) {
        return null;
      }
      paramz = m.Tfo;
      paramz = paramm;
    } while (!m.E(paramab));
    return fq(paramm);
  }
  
  public final List<A> a(a.p paramp, kotlin.l.b.a.b.e.b.c paramc)
  {
    kotlin.g.b.p.h(paramp, "proto");
    kotlin.g.b.p.h(paramc, "nameResolver");
    paramp = paramp.e(kotlin.l.b.a.b.e.c.a.TAN);
    kotlin.g.b.p.g(paramp, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
    Object localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.e.a.a locala = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject).next();
      kotlin.g.b.p.g(locala, "it");
      paramp.add(a(locala, paramc));
    }
    return (List)paramp;
  }
  
  public final List<A> a(a.r paramr, kotlin.l.b.a.b.e.b.c paramc)
  {
    kotlin.g.b.p.h(paramr, "proto");
    kotlin.g.b.p.h(paramc, "nameResolver");
    paramr = paramr.e(kotlin.l.b.a.b.e.c.a.TAO);
    kotlin.g.b.p.g(paramr, "proto.getExtension(JvmPr….typeParameterAnnotation)");
    Object localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.e.a.a locala = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject).next();
      kotlin.g.b.p.g(locala, "it");
      paramr.add(a(locala, paramc));
    }
    return (List)paramr;
  }
  
  public final List<A> a(z paramz, kotlin.l.b.a.b.e.a.f paramf)
  {
    kotlin.g.b.p.h(paramz, "container");
    kotlin.g.b.p.h(paramf, "proto");
    Object localObject = s.TvQ;
    paramf = paramz.SZH.getString(paramf.Tyk);
    localObject = ((z.a)paramz).Tfj.sG();
    kotlin.g.b.p.g(localObject, "(container as ProtoConta…Class).classId.asString()");
    return a(this, paramz, s.a.ou(paramf, kotlin.l.b.a.b.e.c.a.b.btW((String)localObject)), false, null, false, 60);
  }
  
  public final List<A> a(z paramz, a.m paramm)
  {
    kotlin.g.b.p.h(paramz, "container");
    kotlin.g.b.p.h(paramm, "proto");
    return a(paramz, paramm, a.b.TuZ);
  }
  
  public final List<A> a(z paramz, kotlin.l.b.a.b.h.q paramq, kotlin.l.b.a.b.k.a.b paramb)
  {
    kotlin.g.b.p.h(paramz, "container");
    kotlin.g.b.p.h(paramq, "proto");
    kotlin.g.b.p.h(paramb, "kind");
    if (paramb == kotlin.l.b.a.b.k.a.b.TKu) {
      return a(paramz, (a.m)paramq, a.b.TuY);
    }
    paramq = a(paramq, paramz.SZH, paramz.SZI, paramb);
    if (paramq == null) {
      return (List)v.SXr;
    }
    return a(this, paramz, paramq, false, null, false, 60);
  }
  
  public final List<A> a(z paramz, kotlin.l.b.a.b.h.q paramq, kotlin.l.b.a.b.k.a.b paramb, int paramInt, a.t paramt)
  {
    kotlin.g.b.p.h(paramz, "container");
    kotlin.g.b.p.h(paramq, "callableProto");
    kotlin.g.b.p.h(paramb, "kind");
    kotlin.g.b.p.h(paramt, "proto");
    paramb = a(paramq, paramz.SZH, paramz.SZI, paramb);
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
        paramq = s.TvQ;
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
          if (!(paramq instanceof kotlin.l.b.a.b.e.a.c)) {
            break;
          }
          if (paramz == null) {
            throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
          }
          if (((z.a)paramz).TLA == a.b.b.TxM) {
            i = 2;
          } else if (((z.a)paramz).Thz) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      throw ((Throwable)new UnsupportedOperationException("Unsupported message: " + paramq.getClass()));
    }
    return (List)v.SXr;
  }
  
  protected abstract p.a a(kotlin.l.b.a.b.f.a parama, an paraman, List<A> paramList);
  
  public final List<A> b(final z.a parama)
  {
    kotlin.g.b.p.h(parama, "container");
    p localp = a(parama);
    if (localp == null) {
      throw ((Throwable)new IllegalStateException(("Class for loading annotations is not found: " + parama.hLf()).toString()));
    }
    parama = new ArrayList(1);
    p.c localc = (p.c)new e(this, parama);
    kotlin.g.b.p.h(localp, "kotlinClass");
    localp.a(localc);
    return (List)parama;
  }
  
  public final List<A> b(z paramz, a.m paramm)
  {
    kotlin.g.b.p.h(paramz, "container");
    kotlin.g.b.p.h(paramm, "proto");
    return a(paramz, paramm, a.b.Tva);
  }
  
  public final List<A> b(z paramz, kotlin.l.b.a.b.h.q paramq, kotlin.l.b.a.b.k.a.b paramb)
  {
    kotlin.g.b.p.h(paramz, "container");
    kotlin.g.b.p.h(paramq, "proto");
    kotlin.g.b.p.h(paramb, "kind");
    paramq = a(paramq, paramz.SZH, paramz.SZI, paramb);
    if (paramq != null)
    {
      paramb = s.TvQ;
      return a(this, paramz, s.a.a(paramq, 0), false, null, false, 60);
    }
    return (List)v.SXr;
  }
  
  protected abstract C fq(C paramC);
  
  public static final class a {}
  
  public static final class d
    implements p.d
  {
    d(HashMap paramHashMap1, HashMap paramHashMap2) {}
    
    public final p.e a(kotlin.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58154);
      kotlin.g.b.p.h(paramf, "name");
      kotlin.g.b.p.h(paramString, "desc");
      s.a locala = s.TvQ;
      paramf = paramf.sG();
      kotlin.g.b.p.g(paramf, "name.asString()");
      paramf = (p.e)new a(s.a.ot(paramf, paramString));
      AppMethodBeat.o(58154);
      return paramf;
    }
    
    public final p.c b(kotlin.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58155);
      kotlin.g.b.p.h(paramf, "name");
      kotlin.g.b.p.h(paramString, "desc");
      s.a locala = s.TvQ;
      paramf = paramf.sG();
      kotlin.g.b.p.g(paramf, "name.asString()");
      paramf = (p.c)new b(s.a.ou(paramf, paramString));
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
      
      public final p.a a(int paramInt, kotlin.l.b.a.b.f.a parama, an paraman)
      {
        AppMethodBeat.i(58149);
        kotlin.g.b.p.h(parama, "classId");
        kotlin.g.b.p.h(paraman, "source");
        Object localObject = s.TvQ;
        s locals = s.a.a(this.Tvj, paramInt);
        List localList = (List)a.d.this.Tvf.get(locals);
        localObject = localList;
        if (localList == null)
        {
          localObject = (List)new ArrayList();
          ((Map)a.d.this.Tvf).put(locals, localObject);
        }
        parama = a.a(a.d.this.Tve, parama, paraman, (List)localObject);
        AppMethodBeat.o(58149);
        return parama;
      }
    }
    
    public class b
      implements p.c
    {
      private final ArrayList<A> Tvi;
      final s Tvj;
      
      public b()
      {
        AppMethodBeat.i(58153);
        this.Tvj = localObject;
        this.Tvi = new ArrayList();
        AppMethodBeat.o(58153);
      }
      
      public final void Td()
      {
        AppMethodBeat.i(58152);
        if (!((Collection)this.Tvi).isEmpty()) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            ((Map)a.d.this.Tvf).put(this.Tvj, this.Tvi);
          }
          AppMethodBeat.o(58152);
          return;
        }
      }
      
      public final p.a a(kotlin.l.b.a.b.f.a parama, an paraman)
      {
        AppMethodBeat.i(58151);
        kotlin.g.b.p.h(parama, "classId");
        kotlin.g.b.p.h(paraman, "source");
        parama = a.a(a.d.this.Tve, parama, paraman, (List)this.Tvi);
        AppMethodBeat.o(58151);
        return parama;
      }
    }
  }
  
  public static final class e
    implements p.c
  {
    e(ArrayList paramArrayList) {}
    
    public final void Td() {}
    
    public final p.a a(kotlin.l.b.a.b.f.a parama, an paraman)
    {
      AppMethodBeat.i(58156);
      kotlin.g.b.p.h(parama, "classId");
      kotlin.g.b.p.h(paraman, "source");
      parama = a.a(this.Tve, parama, paraman, (List)parama);
      AppMethodBeat.o(58156);
      return parama;
    }
  }
  
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<p, a.c<? extends A, ? extends C>>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.a
 * JD-Core Version:    0.7.0.1
 */