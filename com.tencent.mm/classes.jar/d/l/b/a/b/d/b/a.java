package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
import d.l.b.a.b.e.c.a.i;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.f;
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
  private static final Set<d.l.b.a.b.f.a> Nik;
  public static final a Nil = new a((byte)0);
  private final n Nee;
  private final d.l.b.a.b.l.c<p, a.c<A, C>> Nij;
  
  static
  {
    Object localObject = (Iterable)d.a.j.listOf(new d.l.b.a.b.f.b[] { d.l.b.a.b.d.a.p.Ncw, d.l.b.a.b.d.a.p.Ncz, d.l.b.a.b.d.a.p.NcA, new d.l.b.a.b.f.b("java.lang.annotation.Target"), new d.l.b.a.b.f.b("java.lang.annotation.Retention"), new d.l.b.a.b.f.b("java.lang.annotation.Documented") });
    Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(d.l.b.a.b.f.a.p((d.l.b.a.b.f.b)((Iterator)localObject).next()));
    }
    Nik = d.a.j.n((Iterable)localCollection);
  }
  
  public a(d.l.b.a.b.l.j paramj, n paramn)
  {
    this.Nee = paramn;
    this.Nij = paramj.I((d.g.a.b)new f(this));
  }
  
  private static p a(z.a parama)
  {
    Object localObject1 = null;
    Object localObject2 = parama.MVx;
    parama = (z.a)localObject2;
    if (!(localObject2 instanceof r)) {
      parama = null;
    }
    localObject2 = (r)parama;
    parama = localObject1;
    if (localObject2 != null) {
      parama = ((r)localObject2).Njd;
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
      if (((paramz instanceof z.a)) && (((z.a)paramz).Nzx == a.b.b.Nld))
      {
        paramBoolean = this.Nee;
        paramz = ((z.a)paramz).MSw.o(d.l.b.a.b.f.f.bcE("DefaultImpls"));
        d.g.b.p.g(paramz, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
        return o.a(paramBoolean, paramz);
      }
      if ((paramBoolean.booleanValue()) && ((paramz instanceof z.b)))
      {
        an localan = paramz.MVx;
        paramBoolean = localan;
        if (!(localan instanceof j)) {
          paramBoolean = null;
        }
        paramBoolean = (j)paramBoolean;
        if (paramBoolean != null) {}
        for (paramBoolean = paramBoolean.NiU; paramBoolean != null; paramBoolean = null)
        {
          paramz = this.Nee;
          paramBoolean = paramBoolean.gtd();
          d.g.b.p.g(paramBoolean, "facadeClassName.internalName");
          paramBoolean = d.l.b.a.b.f.a.p(new d.l.b.a.b.f.b(d.n.n.a(paramBoolean, '/', '.')));
          d.g.b.p.g(paramBoolean, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
          return o.a(paramz, paramBoolean);
        }
      }
    }
    if ((paramBoolean2) && ((paramz instanceof z.a)) && (((z.a)paramz).Nzx == a.b.b.Nli))
    {
      paramBoolean = ((z.a)paramz).Nzy;
      if ((paramBoolean != null) && ((paramBoolean.Nzx == a.b.b.Nlc) || (paramBoolean.Nzx == a.b.b.Nle) || ((paramBoolean3) && ((paramBoolean.Nzx == a.b.b.Nld) || (paramBoolean.Nzx == a.b.b.Nlg))))) {
        return a(paramBoolean);
      }
    }
    if (((paramz instanceof z.b)) && ((paramz.MVx instanceof j)))
    {
      paramz = paramz.MVx;
      if (paramz == null) {
        throw new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
      }
      paramz = (j)paramz;
      paramBoolean = paramz.NiX;
      if (paramBoolean == null) {
        return o.a(this.Nee, paramz.ggt());
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
    i.f localf = d.l.b.a.b.e.c.a.Npe;
    d.g.b.p.g(localf, "propertySignature");
    localObject = (d.l.b.a.b.e.c.a.c)d.l.b.a.b.e.b.f.a((i.c)localObject, localf);
    if (localObject == null) {
      return null;
    }
    if (paramBoolean1)
    {
      localObject = i.Nqd;
      paramm = i.a(paramm, paramc, paramh, paramBoolean3);
      if (paramm == null) {
        return null;
      }
      paramc = s.Nje;
      return s.a.a((d.l.b.a.b.e.c.a.e)paramm);
    }
    if ((paramBoolean2) && (((d.l.b.a.b.e.c.a.c)localObject).gqA()))
    {
      paramm = s.Nje;
      paramm = ((d.l.b.a.b.e.c.a.c)localObject).Npr;
      d.g.b.p.g(paramm, "signature.syntheticMethod");
      return s.a.a(paramc, paramm);
    }
    return null;
  }
  
  private static s a(d.l.b.a.b.h.q paramq, d.l.b.a.b.e.b.c paramc, h paramh, d.l.b.a.b.k.a.b paramb, boolean paramBoolean)
  {
    if ((paramq instanceof d.l.b.a.b.e.a.c))
    {
      paramb = s.Nje;
      paramb = i.Nqd;
      paramq = i.a((d.l.b.a.b.e.a.c)paramq, paramc, paramh);
      if (paramq != null) {
        return s.a.a((d.l.b.a.b.e.c.a.e)paramq);
      }
      return null;
    }
    if ((paramq instanceof a.h))
    {
      paramb = s.Nje;
      paramb = i.Nqd;
      paramq = i.a((a.h)paramq, paramc, paramh);
      if (paramq != null) {
        return s.a.a((d.l.b.a.b.e.c.a.e)paramq);
      }
      return null;
    }
    if ((paramq instanceof a.m))
    {
      Object localObject = (i.c)paramq;
      i.f localf = d.l.b.a.b.e.c.a.Npe;
      d.g.b.p.g(localf, "propertySignature");
      localObject = (d.l.b.a.b.e.c.a.c)d.l.b.a.b.e.b.f.a((i.c)localObject, localf);
      if (localObject == null) {
        return null;
      }
      switch (b.cpQ[paramb.ordinal()])
      {
      default: 
        return null;
      case 1: 
        if (((d.l.b.a.b.e.c.a.c)localObject).gqB())
        {
          paramq = s.Nje;
          paramq = ((d.l.b.a.b.e.c.a.c)localObject).Nps;
          d.g.b.p.g(paramq, "signature.getter");
          return s.a.a(paramc, paramq);
        }
        return null;
      case 2: 
        if (((d.l.b.a.b.e.c.a.c)localObject).gqC())
        {
          paramq = s.Nje;
          paramq = ((d.l.b.a.b.e.c.a.c)localObject).Npt;
          d.g.b.p.g(paramq, "signature.setter");
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
      paramz = (List)d.a.v.MKE;
    }
    do
    {
      return paramz;
      params = (List)((a.c)this.Nij.invoke(paramz)).Niq.get(params);
      paramz = params;
    } while (params != null);
    return (List)d.a.v.MKE;
  }
  
  private final List<A> a(z paramz, a.m paramm, a.b paramb)
  {
    Boolean localBoolean = d.l.b.a.b.e.b.b.NoG.akK(paramm.Nkt);
    d.g.b.p.g(localBoolean, "Flags.IS_CONST.get(proto.flags)");
    boolean bool2 = localBoolean.booleanValue();
    boolean bool3 = i.f(paramm);
    if (paramb == a.b.Nim)
    {
      paramm = a(paramm, paramz.MMU, paramz.MMV, false, true, false, 40);
      if (paramm == null) {
        return (List)d.a.v.MKE;
      }
      return a(this, paramz, paramm, true, Boolean.valueOf(bool2), bool3, 8);
    }
    paramm = a(paramm, paramz.MMU, paramz.MMV, true, false, false, 48);
    if (paramm == null) {
      return (List)d.a.v.MKE;
    }
    boolean bool4 = d.n.n.a((CharSequence)paramm.signature, (CharSequence)"$delegate", false);
    if (paramb == a.b.Nio) {}
    for (boolean bool1 = true; bool4 != bool1; bool1 = false) {
      return (List)d.a.v.MKE;
    }
    return a(paramz, paramm, true, true, Boolean.valueOf(bool2), bool3);
  }
  
  protected abstract p.a a(d.l.b.a.b.f.a parama, an paraman, List<A> paramList);
  
  protected abstract A a(d.l.b.a.b.e.a.a parama, d.l.b.a.b.e.b.c paramc);
  
  public final C a(z paramz, a.m paramm, ab paramab)
  {
    boolean bool2 = true;
    d.g.b.p.h(paramz, "container");
    d.g.b.p.h(paramm, "proto");
    d.g.b.p.h(paramab, "expectedType");
    p localp = a(paramz, a(paramz, true, true, d.l.b.a.b.e.b.b.NoG.akK(paramm.Nkt), i.f(paramm)));
    if (localp == null) {
      paramz = null;
    }
    do
    {
      return paramz;
      d.l.b.a.b.e.c.a.f localf = localp.gkw().NjA;
      Object localObject = e.NiN;
      localObject = (d.l.b.a.b.e.b.a)e.gmf();
      d.g.b.p.h(localObject, "version");
      int i = ((d.l.b.a.b.e.b.a)localObject).major;
      int j = ((d.l.b.a.b.e.b.a)localObject).minor;
      int k = ((d.l.b.a.b.e.b.a)localObject).Nog;
      boolean bool1;
      if (localf.major > i) {
        bool1 = bool2;
      }
      for (;;)
      {
        paramz = a((d.l.b.a.b.h.q)paramm, paramz.MMU, paramz.MMV, d.l.b.a.b.k.a.b.Nyr, bool1);
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
            if (localf.Nog >= k) {
              continue;
            }
          }
        }
        bool1 = false;
      }
      paramm = ((a.c)this.Nij.invoke(localp)).Nir.get(paramz);
      if (paramm == null) {
        return null;
      }
      paramz = m.MSB;
      paramz = paramm;
    } while (!m.F(paramab));
    return fi(paramm);
  }
  
  public final List<A> a(a.p paramp, d.l.b.a.b.e.b.c paramc)
  {
    d.g.b.p.h(paramp, "proto");
    d.g.b.p.h(paramc, "nameResolver");
    paramp = paramp.e(d.l.b.a.b.e.c.a.Noe);
    d.g.b.p.g(paramp, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
    Object localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.e.a.a locala = (d.l.b.a.b.e.a.a)((Iterator)localObject).next();
      d.g.b.p.g(locala, "it");
      paramp.add(a(locala, paramc));
    }
    return (List)paramp;
  }
  
  public final List<A> a(a.r paramr, d.l.b.a.b.e.b.c paramc)
  {
    d.g.b.p.h(paramr, "proto");
    d.g.b.p.h(paramc, "nameResolver");
    paramr = paramr.e(d.l.b.a.b.e.c.a.Nof);
    d.g.b.p.g(paramr, "proto.getExtension(JvmPr….typeParameterAnnotation)");
    Object localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.l.b.a.b.e.a.a locala = (d.l.b.a.b.e.a.a)((Iterator)localObject).next();
      d.g.b.p.g(locala, "it");
      paramr.add(a(locala, paramc));
    }
    return (List)paramr;
  }
  
  public final List<A> a(z paramz, d.l.b.a.b.e.a.f paramf)
  {
    d.g.b.p.h(paramz, "container");
    d.g.b.p.h(paramf, "proto");
    Object localObject = s.Nje;
    paramf = paramz.MMU.getString(paramf.NlC);
    localObject = ((z.a)paramz).MSw.sD();
    d.g.b.p.g(localObject, "(container as ProtoConta…Class).classId.asString()");
    return a(this, paramz, s.a.nu(paramf, d.l.b.a.b.e.c.a.b.bcC((String)localObject)), false, null, false, 60);
  }
  
  public final List<A> a(z paramz, a.m paramm)
  {
    d.g.b.p.h(paramz, "container");
    d.g.b.p.h(paramm, "proto");
    return a(paramz, paramm, a.b.Nin);
  }
  
  public final List<A> a(z paramz, d.l.b.a.b.h.q paramq, d.l.b.a.b.k.a.b paramb)
  {
    d.g.b.p.h(paramz, "container");
    d.g.b.p.h(paramq, "proto");
    d.g.b.p.h(paramb, "kind");
    if (paramb == d.l.b.a.b.k.a.b.Nyr) {
      return a(paramz, (a.m)paramq, a.b.Nim);
    }
    paramq = a(paramq, paramz.MMU, paramz.MMV, paramb);
    if (paramq == null) {
      return (List)d.a.v.MKE;
    }
    return a(this, paramz, paramq, false, null, false, 60);
  }
  
  public final List<A> a(z paramz, d.l.b.a.b.h.q paramq, d.l.b.a.b.k.a.b paramb, int paramInt, a.t paramt)
  {
    d.g.b.p.h(paramz, "container");
    d.g.b.p.h(paramq, "callableProto");
    d.g.b.p.h(paramb, "kind");
    d.g.b.p.h(paramt, "proto");
    paramb = a(paramq, paramz.MMU, paramz.MMV, paramb);
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
        paramq = s.Nje;
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
          if (((z.a)paramz).Nzx == a.b.b.Nle) {
            i = 2;
          } else if (((z.a)paramz).MUM) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      throw ((Throwable)new UnsupportedOperationException("Unsupported message: " + paramq.getClass()));
    }
    return (List)d.a.v.MKE;
  }
  
  public final List<A> b(final z.a parama)
  {
    d.g.b.p.h(parama, "container");
    p localp = a(parama);
    if (localp == null) {
      throw ((Throwable)new IllegalStateException(("Class for loading annotations is not found: " + parama.gtA()).toString()));
    }
    parama = new ArrayList(1);
    p.c localc = (p.c)new e(this, parama);
    d.g.b.p.h(localp, "kotlinClass");
    localp.a(localc);
    return (List)parama;
  }
  
  public final List<A> b(z paramz, a.m paramm)
  {
    d.g.b.p.h(paramz, "container");
    d.g.b.p.h(paramm, "proto");
    return a(paramz, paramm, a.b.Nio);
  }
  
  public final List<A> b(z paramz, d.l.b.a.b.h.q paramq, d.l.b.a.b.k.a.b paramb)
  {
    d.g.b.p.h(paramz, "container");
    d.g.b.p.h(paramq, "proto");
    d.g.b.p.h(paramb, "kind");
    paramq = a(paramq, paramz.MMU, paramz.MMV, paramb);
    if (paramq != null)
    {
      paramb = s.Nje;
      return a(this, paramz, s.a.a(paramq, 0), false, null, false, 60);
    }
    return (List)d.a.v.MKE;
  }
  
  protected abstract C fi(C paramC);
  
  public static final class a {}
  
  public static final class d
    implements p.d
  {
    d(HashMap paramHashMap1, HashMap paramHashMap2) {}
    
    public final p.e a(d.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58154);
      d.g.b.p.h(paramf, "name");
      d.g.b.p.h(paramString, "desc");
      s.a locala = s.Nje;
      paramf = paramf.sD();
      d.g.b.p.g(paramf, "name.asString()");
      paramf = (p.e)new a(s.a.nt(paramf, paramString));
      AppMethodBeat.o(58154);
      return paramf;
    }
    
    public final p.c b(d.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58155);
      d.g.b.p.h(paramf, "name");
      d.g.b.p.h(paramString, "desc");
      s.a locala = s.Nje;
      paramf = paramf.sD();
      d.g.b.p.g(paramf, "name.asString()");
      paramf = (p.c)new b(s.a.nu(paramf, paramString));
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
        d.g.b.p.h(parama, "classId");
        d.g.b.p.h(paraman, "source");
        Object localObject = s.Nje;
        s locals = s.a.a(this.Nix, paramInt);
        List localList = (List)a.d.this.Nit.get(locals);
        localObject = localList;
        if (localList == null)
        {
          localObject = (List)new ArrayList();
          ((Map)a.d.this.Nit).put(locals, localObject);
        }
        parama = a.a(a.d.this.Nis, parama, paraman, (List)localObject);
        AppMethodBeat.o(58149);
        return parama;
      }
    }
    
    public class b
      implements p.c
    {
      private final ArrayList<A> Niw;
      final s Nix;
      
      public b()
      {
        AppMethodBeat.i(58153);
        this.Nix = localObject;
        this.Niw = new ArrayList();
        AppMethodBeat.o(58153);
      }
      
      public final void IH()
      {
        AppMethodBeat.i(58152);
        if (!((Collection)this.Niw).isEmpty()) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            ((Map)a.d.this.Nit).put(this.Nix, this.Niw);
          }
          AppMethodBeat.o(58152);
          return;
        }
      }
      
      public final p.a a(d.l.b.a.b.f.a parama, an paraman)
      {
        AppMethodBeat.i(58151);
        d.g.b.p.h(parama, "classId");
        d.g.b.p.h(paraman, "source");
        parama = a.a(a.d.this.Nis, parama, paraman, (List)this.Niw);
        AppMethodBeat.o(58151);
        return parama;
      }
    }
  }
  
  public static final class e
    implements p.c
  {
    e(ArrayList paramArrayList) {}
    
    public final void IH() {}
    
    public final p.a a(d.l.b.a.b.f.a parama, an paraman)
    {
      AppMethodBeat.i(58156);
      d.g.b.p.h(parama, "classId");
      d.g.b.p.h(paraman, "source");
      parama = a.a(this.Nis, parama, paraman, (List)parama);
      AppMethodBeat.o(58156);
      return parama;
    }
  }
  
  static final class f
    extends d.g.b.q
    implements d.g.a.b<p, a.c<? extends A, ? extends C>>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.a
 * JD-Core Version:    0.7.0.1
 */