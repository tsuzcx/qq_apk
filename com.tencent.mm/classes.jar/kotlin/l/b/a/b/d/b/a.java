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
import kotlin.g.b.q;
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
import kotlin.l.b.a.b.h.i.e;
import kotlin.l.b.a.b.k.a.z;
import kotlin.l.b.a.b.k.a.z.a;
import kotlin.l.b.a.b.k.a.z.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.t;

public abstract class a<A, C>
  implements kotlin.l.b.a.b.k.a.c<A, C>
{
  private static final Set<kotlin.l.b.a.b.f.a> aaXQ;
  public static final a aaXR = new a((byte)0);
  private final n aaTL;
  private final kotlin.l.b.a.b.l.c<p, c<A, C>> aaXP;
  
  static
  {
    Object localObject = (Iterable)kotlin.a.j.listOf(new kotlin.l.b.a.b.f.b[] { kotlin.l.b.a.b.d.a.p.aaSd, kotlin.l.b.a.b.d.a.p.aaSg, kotlin.l.b.a.b.d.a.p.aaSh, new kotlin.l.b.a.b.f.b("java.lang.annotation.Target"), new kotlin.l.b.a.b.f.b("java.lang.annotation.Retention"), new kotlin.l.b.a.b.f.b("java.lang.annotation.Documented") });
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(kotlin.l.b.a.b.f.a.p((kotlin.l.b.a.b.f.b)((Iterator)localObject).next()));
    }
    aaXQ = kotlin.a.j.r((Iterable)localCollection);
  }
  
  public a(kotlin.l.b.a.b.l.j paramj, n paramn)
  {
    this.aaTL = paramn;
    this.aaXP = paramj.ak((kotlin.g.a.b)new f(this));
  }
  
  private final List<A> a(z paramz, s params, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    paramz = a(paramz, a(paramz, paramBoolean1, paramBoolean2, paramBoolean, paramBoolean3));
    if (paramz == null) {
      paramz = (List)v.aaAd;
    }
    do
    {
      return paramz;
      params = (List)((c)this.aaXP.invoke(paramz)).aaXW.get(params);
      paramz = params;
    } while (params != null);
    return (List)v.aaAd;
  }
  
  private final List<A> a(z paramz, a.m paramm, a.b paramb)
  {
    Boolean localBoolean = kotlin.l.b.a.b.e.b.b.abee.aFe(paramm.aaZS);
    kotlin.g.b.p.j(localBoolean, "Flags.IS_CONST.get(proto.flags)");
    boolean bool2 = localBoolean.booleanValue();
    boolean bool3 = i.f(paramm);
    if (paramb == a.b.aaXS)
    {
      paramm = a(paramm, paramz.aaCB, paramz.aaCC, false, true, false, 40);
      if (paramm == null) {
        return (List)v.aaAd;
      }
      return a(this, paramz, paramm, true, Boolean.valueOf(bool2), bool3, 8);
    }
    paramm = a(paramm, paramz.aaCB, paramz.aaCC, true, false, false, 48);
    if (paramm == null) {
      return (List)v.aaAd;
    }
    boolean bool4 = kotlin.n.n.a((CharSequence)paramm.signature, (CharSequence)"$delegate", false);
    if (paramb == a.b.aaXU) {}
    for (boolean bool1 = true; bool4 != bool1; bool1 = false) {
      return (List)v.aaAd;
    }
    return a(paramz, paramm, true, true, Boolean.valueOf(bool2), bool3);
  }
  
  private static p a(z.a parama)
  {
    Object localObject1 = null;
    Object localObject2 = parama.aaLe;
    parama = (z.a)localObject2;
    if (!(localObject2 instanceof r)) {
      parama = null;
    }
    localObject2 = (r)parama;
    parama = localObject1;
    if (localObject2 != null) {
      parama = ((r)localObject2).aaYF;
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
      if (((paramz instanceof z.a)) && (((z.a)paramz).abod == a.b.b.abaC))
      {
        paramBoolean = this.aaTL;
        paramz = ((z.a)paramz).aaId.o(kotlin.l.b.a.b.f.f.bHb("DefaultImpls"));
        kotlin.g.b.p.j(paramz, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
        return o.a(paramBoolean, paramz);
      }
      if ((paramBoolean.booleanValue()) && ((paramz instanceof z.b)))
      {
        an localan = paramz.aaLe;
        paramBoolean = localan;
        if (!(localan instanceof j)) {
          paramBoolean = null;
        }
        paramBoolean = (j)paramBoolean;
        if (paramBoolean != null) {}
        for (paramBoolean = paramBoolean.aaYw; paramBoolean != null; paramBoolean = null)
        {
          paramz = this.aaTL;
          paramBoolean = paramBoolean.iOY();
          kotlin.g.b.p.j(paramBoolean, "facadeClassName.internalName");
          paramBoolean = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(kotlin.n.n.a(paramBoolean, '/', '.')));
          kotlin.g.b.p.j(paramBoolean, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
          return o.a(paramz, paramBoolean);
        }
      }
    }
    if ((paramBoolean2) && ((paramz instanceof z.a)) && (((z.a)paramz).abod == a.b.b.abaH))
    {
      paramBoolean = ((z.a)paramz).aboe;
      if ((paramBoolean != null) && ((paramBoolean.abod == a.b.b.abaB) || (paramBoolean.abod == a.b.b.abaD) || ((paramBoolean3) && ((paramBoolean.abod == a.b.b.abaC) || (paramBoolean.abod == a.b.b.abaF))))) {
        return a(paramBoolean);
      }
    }
    if (((paramz instanceof z.b)) && ((paramz.aaLe instanceof j)))
    {
      paramz = paramz.aaLe;
      if (paramz == null) {
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
      }
      paramz = (j)paramz;
      paramBoolean = paramz.aaYz;
      if (paramBoolean == null) {
        return o.a(this.aaTL, paramz.iCJ());
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
    i.e locale = kotlin.l.b.a.b.e.c.a.abeC;
    kotlin.g.b.p.j(locale, "propertySignature");
    localObject = (kotlin.l.b.a.b.e.c.a.c)kotlin.l.b.a.b.e.b.f.a((i.c)localObject, locale);
    if (localObject == null) {
      return null;
    }
    if (paramBoolean1)
    {
      localObject = i.abfB;
      paramm = i.a(paramm, paramc, paramh, paramBoolean3);
      if (paramm == null) {
        return null;
      }
      paramc = s.aaYG;
      return s.a.a((kotlin.l.b.a.b.e.c.a.e)paramm);
    }
    if ((paramBoolean2) && (((kotlin.l.b.a.b.e.c.a.c)localObject).iMT()))
    {
      paramm = s.aaYG;
      paramm = ((kotlin.l.b.a.b.e.c.a.c)localObject).abeP;
      kotlin.g.b.p.j(paramm, "signature.syntheticMethod");
      return s.a.a(paramc, paramm);
    }
    return null;
  }
  
  private static s a(kotlin.l.b.a.b.h.r paramr, kotlin.l.b.a.b.e.b.c paramc, h paramh, kotlin.l.b.a.b.k.a.b paramb, boolean paramBoolean)
  {
    if ((paramr instanceof kotlin.l.b.a.b.e.a.c))
    {
      paramb = s.aaYG;
      paramb = i.abfB;
      paramr = i.a((kotlin.l.b.a.b.e.a.c)paramr, paramc, paramh);
      if (paramr != null) {
        return s.a.a((kotlin.l.b.a.b.e.c.a.e)paramr);
      }
      return null;
    }
    if ((paramr instanceof a.h))
    {
      paramb = s.aaYG;
      paramb = i.abfB;
      paramr = i.a((a.h)paramr, paramc, paramh);
      if (paramr != null) {
        return s.a.a((kotlin.l.b.a.b.e.c.a.e)paramr);
      }
      return null;
    }
    if ((paramr instanceof a.m))
    {
      Object localObject = (i.c)paramr;
      i.e locale = kotlin.l.b.a.b.e.c.a.abeC;
      kotlin.g.b.p.j(locale, "propertySignature");
      localObject = (kotlin.l.b.a.b.e.c.a.c)kotlin.l.b.a.b.e.b.f.a((i.c)localObject, locale);
      if (localObject == null) {
        return null;
      }
      switch (b.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        return null;
      case 1: 
        if (((kotlin.l.b.a.b.e.c.a.c)localObject).iMU())
        {
          paramr = s.aaYG;
          paramr = ((kotlin.l.b.a.b.e.c.a.c)localObject).abeQ;
          kotlin.g.b.p.j(paramr, "signature.getter");
          return s.a.a(paramc, paramr);
        }
        return null;
      case 2: 
        if (((kotlin.l.b.a.b.e.c.a.c)localObject).iMV())
        {
          paramr = s.aaYG;
          paramr = ((kotlin.l.b.a.b.e.c.a.c)localObject).abeR;
          kotlin.g.b.p.j(paramr, "signature.setter");
          return s.a.a(paramc, paramr);
        }
        return null;
      }
      return a((a.m)paramr, paramc, paramh, true, true, paramBoolean);
    }
    return null;
  }
  
  protected abstract A a(kotlin.l.b.a.b.e.a.a parama, kotlin.l.b.a.b.e.b.c paramc);
  
  public final C a(z paramz, a.m paramm, ab paramab)
  {
    boolean bool2 = true;
    kotlin.g.b.p.k(paramz, "container");
    kotlin.g.b.p.k(paramm, "proto");
    kotlin.g.b.p.k(paramab, "expectedType");
    p localp = a(paramz, a(paramz, true, true, kotlin.l.b.a.b.e.b.b.abee.aFe(paramm.aaZS), i.f(paramm)));
    if (localp == null) {
      paramz = null;
    }
    do
    {
      return paramz;
      kotlin.l.b.a.b.e.c.a.f localf = localp.iGR().aaZc;
      Object localObject = e.aaYs;
      localObject = (kotlin.l.b.a.b.e.b.a)e.iIE();
      kotlin.g.b.p.k(localObject, "version");
      int i = ((kotlin.l.b.a.b.e.b.a)localObject).oey;
      int j = ((kotlin.l.b.a.b.e.b.a)localObject).oez;
      int k = ((kotlin.l.b.a.b.e.b.a)localObject).TsL;
      boolean bool1;
      if (localf.oey > i) {
        bool1 = bool2;
      }
      for (;;)
      {
        paramz = a((kotlin.l.b.a.b.h.r)paramm, paramz.aaCB, paramz.aaCC, kotlin.l.b.a.b.k.a.b.abmX, bool1);
        if (paramz != null) {
          break;
        }
        return null;
        if (localf.oey >= i)
        {
          bool1 = bool2;
          if (localf.oez > j) {
            continue;
          }
          if (localf.oez >= j)
          {
            bool1 = bool2;
            if (localf.TsL >= k) {
              continue;
            }
          }
        }
        bool1 = false;
      }
      paramm = ((c)this.aaXP.invoke(localp)).aaXX.get(paramz);
      if (paramm == null) {
        return null;
      }
      paramz = m.aaIi;
      paramz = paramm;
    } while (!m.E(paramab));
    return fx(paramm);
  }
  
  public final List<A> a(a.p paramp, kotlin.l.b.a.b.e.b.c paramc)
  {
    kotlin.g.b.p.k(paramp, "proto");
    kotlin.g.b.p.k(paramc, "nameResolver");
    paramp = paramp.d(kotlin.l.b.a.b.e.c.a.abdD);
    kotlin.g.b.p.j(paramp, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
    Object localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.e.a.a locala = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject).next();
      kotlin.g.b.p.j(locala, "it");
      paramp.add(a(locala, paramc));
    }
    return (List)paramp;
  }
  
  public final List<A> a(a.r paramr, kotlin.l.b.a.b.e.b.c paramc)
  {
    kotlin.g.b.p.k(paramr, "proto");
    kotlin.g.b.p.k(paramc, "nameResolver");
    paramr = paramr.d(kotlin.l.b.a.b.e.c.a.abdE);
    kotlin.g.b.p.j(paramr, "proto.getExtension(JvmPr….typeParameterAnnotation)");
    Object localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.e.a.a locala = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject).next();
      kotlin.g.b.p.j(locala, "it");
      paramr.add(a(locala, paramc));
    }
    return (List)paramr;
  }
  
  public final List<A> a(z paramz, kotlin.l.b.a.b.e.a.f paramf)
  {
    kotlin.g.b.p.k(paramz, "container");
    kotlin.g.b.p.k(paramf, "proto");
    Object localObject = s.aaYG;
    paramf = paramz.aaCB.getString(paramf.abbb);
    localObject = ((z.a)paramz).aaId.qu();
    kotlin.g.b.p.j(localObject, "(container as ProtoConta…Class).classId.asString()");
    return a(this, paramz, s.a.pp(paramf, kotlin.l.b.a.b.e.c.a.b.bGZ((String)localObject)), false, null, false, 60);
  }
  
  public final List<A> a(z paramz, a.m paramm)
  {
    kotlin.g.b.p.k(paramz, "container");
    kotlin.g.b.p.k(paramm, "proto");
    return a(paramz, paramm, a.b.aaXT);
  }
  
  public final List<A> a(z paramz, kotlin.l.b.a.b.h.r paramr, kotlin.l.b.a.b.k.a.b paramb)
  {
    kotlin.g.b.p.k(paramz, "container");
    kotlin.g.b.p.k(paramr, "proto");
    kotlin.g.b.p.k(paramb, "kind");
    if (paramb == kotlin.l.b.a.b.k.a.b.abmX) {
      return a(paramz, (a.m)paramr, a.b.aaXS);
    }
    paramr = a(paramr, paramz.aaCB, paramz.aaCC, paramb);
    if (paramr == null) {
      return (List)v.aaAd;
    }
    return a(this, paramz, paramr, false, null, false, 60);
  }
  
  public final List<A> a(z paramz, kotlin.l.b.a.b.h.r paramr, kotlin.l.b.a.b.k.a.b paramb, int paramInt, a.t paramt)
  {
    kotlin.g.b.p.k(paramz, "container");
    kotlin.g.b.p.k(paramr, "callableProto");
    kotlin.g.b.p.k(paramb, "kind");
    kotlin.g.b.p.k(paramt, "proto");
    paramb = a(paramr, paramz.aaCB, paramz.aaCC, paramb);
    if (paramb != null)
    {
      int i;
      if ((paramr instanceof a.h)) {
        if (g.f((a.h)paramr)) {
          i = 1;
        }
      }
      for (;;)
      {
        paramr = s.aaYG;
        return a(this, paramz, s.a.a(paramb, i + paramInt), false, null, false, 60);
        i = 0;
        continue;
        if ((paramr instanceof a.m))
        {
          if (g.e((a.m)paramr)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else
        {
          if (!(paramr instanceof kotlin.l.b.a.b.e.a.c)) {
            break;
          }
          if (paramz == null) {
            throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
          }
          if (((z.a)paramz).abod == a.b.b.abaD) {
            i = 2;
          } else if (((z.a)paramz).aaKt) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      throw ((Throwable)new UnsupportedOperationException("Unsupported message: " + paramr.getClass()));
    }
    return (List)v.aaAd;
  }
  
  protected abstract p.a a(kotlin.l.b.a.b.f.a parama, an paraman, List<A> paramList);
  
  public final List<A> b(final z.a parama)
  {
    kotlin.g.b.p.k(parama, "container");
    p localp = a(parama);
    if (localp == null) {
      throw ((Throwable)new IllegalStateException(("Class for loading annotations is not found: " + parama.iPx()).toString()));
    }
    parama = new ArrayList(1);
    p.c localc = (p.c)new e(this, parama);
    kotlin.g.b.p.k(localp, "kotlinClass");
    localp.a(localc);
    return (List)parama;
  }
  
  public final List<A> b(z paramz, a.m paramm)
  {
    kotlin.g.b.p.k(paramz, "container");
    kotlin.g.b.p.k(paramm, "proto");
    return a(paramz, paramm, a.b.aaXU);
  }
  
  public final List<A> b(z paramz, kotlin.l.b.a.b.h.r paramr, kotlin.l.b.a.b.k.a.b paramb)
  {
    kotlin.g.b.p.k(paramz, "container");
    kotlin.g.b.p.k(paramr, "proto");
    kotlin.g.b.p.k(paramb, "kind");
    paramr = a(paramr, paramz.aaCB, paramz.aaCC, paramb);
    if (paramr != null)
    {
      paramb = s.aaYG;
      return a(this, paramz, s.a.a(paramr, 0), false, null, false, 60);
    }
    return (List)v.aaAd;
  }
  
  protected abstract C fx(C paramC);
  
  public static final class a {}
  
  static final class c<A, C>
  {
    final Map<s, List<A>> aaXW;
    final Map<s, C> aaXX;
    
    public c(Map<s, ? extends List<? extends A>> paramMap, Map<s, ? extends C> paramMap1)
    {
      AppMethodBeat.i(58147);
      this.aaXW = paramMap;
      this.aaXX = paramMap1;
      AppMethodBeat.o(58147);
    }
  }
  
  public static final class d
    implements p.d
  {
    d(HashMap paramHashMap1, HashMap paramHashMap2) {}
    
    public final p.e a(kotlin.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58154);
      kotlin.g.b.p.k(paramf, "name");
      kotlin.g.b.p.k(paramString, "desc");
      s.a locala = s.aaYG;
      paramf = paramf.qu();
      kotlin.g.b.p.j(paramf, "name.asString()");
      paramf = (p.e)new a(s.a.po(paramf, paramString));
      AppMethodBeat.o(58154);
      return paramf;
    }
    
    public final p.c b(kotlin.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58155);
      kotlin.g.b.p.k(paramf, "name");
      kotlin.g.b.p.k(paramString, "desc");
      s.a locala = s.aaYG;
      paramf = paramf.qu();
      kotlin.g.b.p.j(paramf, "name.asString()");
      paramf = (p.c)new b(s.a.pp(paramf, paramString));
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
        kotlin.g.b.p.k(parama, "classId");
        kotlin.g.b.p.k(paraman, "source");
        Object localObject = s.aaYG;
        s locals = s.a.a(iIB(), paramInt);
        List localList = (List)a.d.this.aaXZ.get(locals);
        localObject = localList;
        if (localList == null)
        {
          localObject = (List)new ArrayList();
          ((Map)a.d.this.aaXZ).put(locals, localObject);
        }
        parama = a.a(a.d.this.aaXY, parama, paraman, (List)localObject);
        AppMethodBeat.o(58149);
        return parama;
      }
    }
    
    public class b
      implements p.c
    {
      private final s aaYc;
      private final ArrayList<A> fRm;
      
      public b()
      {
        AppMethodBeat.i(58153);
        this.aaYc = localObject;
        this.fRm = new ArrayList();
        AppMethodBeat.o(58153);
      }
      
      public final void XJ()
      {
        AppMethodBeat.i(58152);
        if (!((Collection)this.fRm).isEmpty()) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            ((Map)a.d.this.aaXZ).put(this.aaYc, this.fRm);
          }
          AppMethodBeat.o(58152);
          return;
        }
      }
      
      public final p.a a(kotlin.l.b.a.b.f.a parama, an paraman)
      {
        AppMethodBeat.i(58151);
        kotlin.g.b.p.k(parama, "classId");
        kotlin.g.b.p.k(paraman, "source");
        parama = a.a(a.d.this.aaXY, parama, paraman, (List)this.fRm);
        AppMethodBeat.o(58151);
        return parama;
      }
      
      protected final s iIB()
      {
        return this.aaYc;
      }
    }
  }
  
  public static final class e
    implements p.c
  {
    e(ArrayList paramArrayList) {}
    
    public final void XJ() {}
    
    public final p.a a(kotlin.l.b.a.b.f.a parama, an paraman)
    {
      AppMethodBeat.i(58156);
      kotlin.g.b.p.k(parama, "classId");
      kotlin.g.b.p.k(paraman, "source");
      parama = a.a(this.aaXY, parama, paraman, (List)parama);
      AppMethodBeat.o(58156);
      return parama;
    }
  }
  
  static final class f
    extends q
    implements kotlin.g.a.b<p, a.c<? extends A, ? extends C>>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.a
 * JD-Core Version:    0.7.0.1
 */