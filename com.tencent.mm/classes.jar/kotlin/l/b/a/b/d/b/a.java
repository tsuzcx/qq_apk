package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.e.a.b.b;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.a.t;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.e;
import kotlin.l.b.a.b.k.a.y;
import kotlin.l.b.a.b.k.a.y.a;
import kotlin.l.b.a.b.k.a.y.b;
import kotlin.l.b.a.b.m.ad;

public abstract class a<A, C>
  implements kotlin.l.b.a.b.k.a.c<A, C>
{
  private final m aiRL;
  private final kotlin.l.b.a.b.l.f<o, a.b<A, C>> aiWa;
  
  public a(kotlin.l.b.a.b.l.m paramm, m paramm1)
  {
    this.aiRL = paramm1;
    this.aiWa = paramm.bd((kotlin.g.a.b)new f(this));
  }
  
  private final List<A> a(y paramy, r paramr, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    paramy = a(paramy, a(paramy, paramBoolean1, paramBoolean2, paramBoolean, paramBoolean3));
    if (paramy == null) {
      paramy = (List)ab.aivy;
    }
    do
    {
      return paramy;
      paramr = (List)((a.b)this.aiWa.invoke(paramy)).aiWf.get(paramr);
      paramy = paramr;
    } while (paramr != null);
    return (List)ab.aivy;
  }
  
  private final List<A> a(y paramy, a.m paramm, a.a parama)
  {
    Boolean localBoolean = kotlin.l.b.a.b.e.b.b.ajcJ.aLV(paramm.aiYq);
    s.s(localBoolean, "IS_CONST.get(proto.flags)");
    boolean bool2 = localBoolean.booleanValue();
    boolean bool3 = kotlin.l.b.a.b.e.c.a.g.f(paramm);
    if (parama == a.a.aiWb)
    {
      paramm = a(paramm, paramy.aiyk, paramy.aiyl, false, true, false, 40);
      if (paramm == null) {
        return (List)ab.aivy;
      }
      return a(this, paramy, paramm, true, Boolean.valueOf(bool2), bool3, 8);
    }
    paramm = a(paramm, paramy.aiyk, paramy.aiyl, true, false, false, 48);
    if (paramm == null) {
      return (List)ab.aivy;
    }
    boolean bool4 = kotlin.n.n.a((CharSequence)paramm.signature, (CharSequence)"$delegate", false);
    if (parama == a.a.aiWd) {}
    for (boolean bool1 = true; bool4 != bool1; bool1 = false) {
      return (List)ab.aivy;
    }
    return a(paramy, paramm, true, true, Boolean.valueOf(bool2), bool3);
  }
  
  private static o a(y.a parama)
  {
    parama = parama.aiHP;
    if ((parama instanceof q)) {}
    for (parama = (q)parama; parama == null; parama = null) {
      return null;
    }
    return parama.aiXb;
  }
  
  private static o a(y paramy, o paramo)
  {
    if (paramo != null) {
      return paramo;
    }
    if ((paramy instanceof y.a)) {
      return a((y.a)paramy);
    }
    return null;
  }
  
  private final o a(y paramy, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (paramBoolean == null) {
        throw ((Throwable)new IllegalStateException(("isConst should not be null for property (container=" + paramy + ')').toString()));
      }
      if (((paramy instanceof y.a)) && (((y.a)paramy).ajmN == a.b.b.aiZd))
      {
        paramBoolean = this.aiRL;
        paramy = ((y.a)paramy).aiEe.p(kotlin.l.b.a.b.f.f.bJe("DefaultImpls"));
        s.s(paramy, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
        return n.a(paramBoolean, paramy);
      }
      if ((paramBoolean.booleanValue()) && ((paramy instanceof y.b)))
      {
        paramBoolean = paramy.aiHP;
        if ((paramBoolean instanceof i))
        {
          paramBoolean = (i)paramBoolean;
          if (paramBoolean != null) {
            break label211;
          }
        }
        label211:
        for (paramBoolean = null;; paramBoolean = paramBoolean.aiWH)
        {
          if (paramBoolean == null) {
            break label221;
          }
          paramy = this.aiRL;
          paramBoolean = paramBoolean.kzr();
          s.s(paramBoolean, "facadeClassName.internalName");
          paramBoolean = kotlin.l.b.a.b.f.b.s(new kotlin.l.b.a.b.f.c(kotlin.n.n.a(paramBoolean, '/', '.')));
          s.s(paramBoolean, "topLevel(FqName(facadeCl…lName.replace('/', '.')))");
          return n.a(paramy, paramBoolean);
          paramBoolean = null;
          break;
        }
      }
    }
    label221:
    if ((paramBoolean2) && ((paramy instanceof y.a)) && (((y.a)paramy).ajmN == a.b.b.aiZi))
    {
      paramBoolean = ((y.a)paramy).ajmM;
      if ((paramBoolean != null) && ((paramBoolean.ajmN == a.b.b.aiZc) || (paramBoolean.ajmN == a.b.b.aiZe) || ((paramBoolean3) && ((paramBoolean.ajmN == a.b.b.aiZd) || (paramBoolean.ajmN == a.b.b.aiZg))))) {
        return a(paramBoolean);
      }
    }
    if (((paramy instanceof y.b)) && ((paramy.aiHP instanceof i)))
    {
      paramy = paramy.aiHP;
      if (paramy == null) {
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
      }
      paramy = (i)paramy;
      paramBoolean = paramy.aiWL;
      if (paramBoolean == null) {
        return n.a(this.aiRL, paramy.kmb());
      }
      return paramBoolean;
    }
    return null;
  }
  
  private static r a(a.m paramm, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.g paramg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = (i.c)paramm;
    i.e locale = kotlin.l.b.a.b.e.c.a.ajdo;
    s.s(locale, "propertySignature");
    localObject = (kotlin.l.b.a.b.e.c.a.c)kotlin.l.b.a.b.e.b.e.a((i.c)localObject, locale);
    if (localObject == null) {
      return null;
    }
    if (paramBoolean1)
    {
      localObject = kotlin.l.b.a.b.e.c.a.g.ajem;
      paramm = kotlin.l.b.a.b.e.c.a.g.a(paramm, paramc, paramg, paramBoolean3);
      if (paramm == null) {
        return null;
      }
      paramc = r.aiXc;
      return r.a.a((kotlin.l.b.a.b.e.c.a.d)paramm);
    }
    if ((paramBoolean2) && (((kotlin.l.b.a.b.e.c.a.c)localObject).kxm()))
    {
      paramm = r.aiXc;
      paramm = ((kotlin.l.b.a.b.e.c.a.c)localObject).ajdC;
      s.s(paramm, "signature.syntheticMethod");
      return r.a.a(paramc, paramm);
    }
    return null;
  }
  
  private static r a(kotlin.l.b.a.b.h.r paramr, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.g paramg, kotlin.l.b.a.b.k.a.b paramb, boolean paramBoolean)
  {
    if ((paramr instanceof kotlin.l.b.a.b.e.a.c))
    {
      paramb = r.aiXc;
      paramb = kotlin.l.b.a.b.e.c.a.g.ajem;
      paramr = kotlin.l.b.a.b.e.c.a.g.a((kotlin.l.b.a.b.e.a.c)paramr, paramc, paramg);
      if (paramr == null) {
        return null;
      }
      return r.a.a((kotlin.l.b.a.b.e.c.a.d)paramr);
    }
    if ((paramr instanceof a.h))
    {
      paramb = r.aiXc;
      paramb = kotlin.l.b.a.b.e.c.a.g.ajem;
      paramr = kotlin.l.b.a.b.e.c.a.g.a((a.h)paramr, paramc, paramg);
      if (paramr == null) {
        return null;
      }
      return r.a.a((kotlin.l.b.a.b.e.c.a.d)paramr);
    }
    if ((paramr instanceof a.m))
    {
      Object localObject = (i.c)paramr;
      i.e locale = kotlin.l.b.a.b.e.c.a.ajdo;
      s.s(locale, "propertySignature");
      localObject = (kotlin.l.b.a.b.e.c.a.c)kotlin.l.b.a.b.e.b.e.a((i.c)localObject, locale);
      if (localObject == null) {
        return null;
      }
      switch (c.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        return null;
      case 1: 
        if (((kotlin.l.b.a.b.e.c.a.c)localObject).kxn())
        {
          paramr = r.aiXc;
          paramr = ((kotlin.l.b.a.b.e.c.a.c)localObject).ajdD;
          s.s(paramr, "signature.getter");
          return r.a.a(paramc, paramr);
        }
        return null;
      case 2: 
        if (((kotlin.l.b.a.b.e.c.a.c)localObject).kxo())
        {
          paramr = r.aiXc;
          paramr = ((kotlin.l.b.a.b.e.c.a.c)localObject).ajdE;
          s.s(paramr, "signature.setter");
          return r.a.a(paramc, paramr);
        }
        return null;
      }
      return a((a.m)paramr, paramc, paramg, true, true, paramBoolean);
    }
    return null;
  }
  
  protected abstract A a(kotlin.l.b.a.b.e.a.a parama, kotlin.l.b.a.b.e.b.c paramc);
  
  public final C a(y paramy, a.m paramm, ad paramad)
  {
    s.u(paramy, "container");
    s.u(paramm, "proto");
    s.u(paramad, "expectedType");
    o localo = a(paramy, a(paramy, true, true, kotlin.l.b.a.b.e.b.b.ajcJ.aLV(paramm.aiYq), kotlin.l.b.a.b.e.c.a.g.f(paramm)));
    if (localo == null) {
      paramy = null;
    }
    do
    {
      return paramy;
      kotlin.l.b.a.b.e.c.a.e locale = localo.kqo().aiXB;
      Object localObject = e.aiWy;
      localObject = (kotlin.l.b.a.b.e.b.a)e.ksL();
      s.u(localObject, "version");
      boolean bool = locale.bR(((kotlin.l.b.a.b.e.b.a)localObject).rid, ((kotlin.l.b.a.b.e.b.a)localObject).rie, ((kotlin.l.b.a.b.e.b.a)localObject).aaGW);
      paramy = a((kotlin.l.b.a.b.h.r)paramm, paramy.aiyk, paramy.aiyl, kotlin.l.b.a.b.k.a.b.ajlG, bool);
      if (paramy == null) {
        return null;
      }
      paramm = ((a.b)this.aiWa.invoke(localo)).aiWg.get(paramy);
      if (paramm == null) {
        return null;
      }
      paramy = paramm;
    } while (!kotlin.l.b.a.b.a.o.x(paramad));
    return hX(paramm);
  }
  
  public final List<A> a(a.p paramp, kotlin.l.b.a.b.e.b.c paramc)
  {
    s.u(paramp, "proto");
    s.u(paramc, "nameResolver");
    paramp = paramp.e(kotlin.l.b.a.b.e.c.a.ajce);
    s.s(paramp, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
    Object localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.e.a.a locala = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject).next();
      s.s(locala, "it");
      paramp.add(a(locala, paramc));
    }
    return (List)paramp;
  }
  
  public final List<A> a(a.r paramr, kotlin.l.b.a.b.e.b.c paramc)
  {
    s.u(paramr, "proto");
    s.u(paramc, "nameResolver");
    paramr = paramr.e(kotlin.l.b.a.b.e.c.a.ajcf);
    s.s(paramr, "proto.getExtension(JvmPr….typeParameterAnnotation)");
    Object localObject = (Iterable)paramr;
    paramr = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kotlin.l.b.a.b.e.a.a locala = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject).next();
      s.s(locala, "it");
      paramr.add(a(locala, paramc));
    }
    return (List)paramr;
  }
  
  public final List<A> a(y paramy, kotlin.l.b.a.b.e.a.f paramf)
  {
    s.u(paramy, "container");
    s.u(paramf, "proto");
    Object localObject = r.aiXc;
    paramf = paramy.aiyk.getString(paramf.aiZC);
    localObject = ((y.a)paramy).aiEe.PF();
    s.s(localObject, "container as ProtoContai…Class).classId.asString()");
    return a(this, paramy, r.a.rn(paramf, kotlin.l.b.a.b.e.c.a.b.bJc((String)localObject)), false, null, false, 60);
  }
  
  public final List<A> a(y paramy, a.m paramm)
  {
    s.u(paramy, "container");
    s.u(paramm, "proto");
    return a(paramy, paramm, a.a.aiWc);
  }
  
  public final List<A> a(y paramy, kotlin.l.b.a.b.h.r paramr, kotlin.l.b.a.b.k.a.b paramb)
  {
    s.u(paramy, "container");
    s.u(paramr, "proto");
    s.u(paramb, "kind");
    if (paramb == kotlin.l.b.a.b.k.a.b.ajlG) {
      return a(paramy, (a.m)paramr, a.a.aiWb);
    }
    paramr = a(paramr, paramy.aiyk, paramy.aiyl, paramb);
    if (paramr == null) {
      return (List)ab.aivy;
    }
    return a(this, paramy, paramr, false, null, false, 60);
  }
  
  public final List<A> a(y paramy, kotlin.l.b.a.b.h.r paramr, kotlin.l.b.a.b.k.a.b paramb, int paramInt, a.t paramt)
  {
    s.u(paramy, "container");
    s.u(paramr, "callableProto");
    s.u(paramb, "kind");
    s.u(paramt, "proto");
    paramb = a(paramr, paramy.aiyk, paramy.aiyl, paramb);
    if (paramb != null)
    {
      int i;
      if ((paramr instanceof a.h)) {
        if (kotlin.l.b.a.b.e.b.f.f((a.h)paramr)) {
          i = 1;
        }
      }
      for (;;)
      {
        paramr = r.aiXc;
        return a(this, paramy, r.a.a(paramb, i + paramInt), false, null, false, 60);
        i = 0;
        continue;
        if ((paramr instanceof a.m))
        {
          if (kotlin.l.b.a.b.e.b.f.e((a.m)paramr)) {
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
          if (((y.a)paramy).ajmN == a.b.b.aiZe) {
            i = 2;
          } else if (((y.a)paramy).aiHg) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      throw new UnsupportedOperationException(s.X("Unsupported message: ", paramr.getClass()));
    }
    return (List)ab.aivy;
  }
  
  protected abstract o.a a(kotlin.l.b.a.b.f.b paramb, av paramav, List<A> paramList);
  
  public final List<A> b(final y.a parama)
  {
    s.u(parama, "container");
    o localo = a(parama);
    if (localo == null) {
      throw ((Throwable)new IllegalStateException(s.X("Class for loading annotations is not found: ", parama.kzZ()).toString()));
    }
    parama = new ArrayList(1);
    o.c localc = (o.c)new e(this, parama);
    s.u(localo, "kotlinClass");
    localo.a(localc);
    return (List)parama;
  }
  
  public final List<A> b(y paramy, a.m paramm)
  {
    s.u(paramy, "container");
    s.u(paramm, "proto");
    return a(paramy, paramm, a.a.aiWd);
  }
  
  public final List<A> b(y paramy, kotlin.l.b.a.b.h.r paramr, kotlin.l.b.a.b.k.a.b paramb)
  {
    s.u(paramy, "container");
    s.u(paramr, "proto");
    s.u(paramb, "kind");
    paramr = a(paramr, paramy.aiyk, paramy.aiyl, paramb);
    if (paramr != null)
    {
      paramb = r.aiXc;
      return a(this, paramy, r.a.a(paramr, 0), false, null, false, 60);
    }
    return (List)ab.aivy;
  }
  
  protected abstract C hX(C paramC);
  
  public static final class d
    implements o.d
  {
    d(a<A, C> parama, HashMap<r, List<A>> paramHashMap, HashMap<r, C> paramHashMap1) {}
    
    public final o.e a(kotlin.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58154);
      s.u(paramf, "name");
      s.u(paramString, "desc");
      r.a locala = r.aiXc;
      paramf = paramf.PF();
      s.s(paramf, "name.asString()");
      paramf = (o.e)new a(r.a.rm(paramf, paramString));
      AppMethodBeat.o(58154);
      return paramf;
    }
    
    public final o.c b(kotlin.l.b.a.b.f.f paramf, String paramString)
    {
      AppMethodBeat.i(58155);
      s.u(paramf, "name");
      s.u(paramString, "desc");
      r.a locala = r.aiXc;
      paramf = paramf.PF();
      s.s(paramf, "name.asString()");
      paramf = (o.c)new b(r.a.rn(paramf, paramString));
      AppMethodBeat.o(58155);
      return paramf;
    }
    
    public final class a
      extends a.d.b
      implements o.e
    {
      public a()
      {
        super(localObject);
        AppMethodBeat.i(58150);
        AppMethodBeat.o(58150);
      }
      
      public final o.a a(int paramInt, kotlin.l.b.a.b.f.b paramb, av paramav)
      {
        AppMethodBeat.i(58149);
        s.u(paramb, "classId");
        s.u(paramav, "source");
        Object localObject = r.aiXc;
        r localr = r.a.a(ksI(), paramInt);
        List localList = (List)a.d.this.aiWi.get(localr);
        localObject = localList;
        if (localList == null)
        {
          localObject = (List)new ArrayList();
          ((Map)a.d.this.aiWi).put(localr, localObject);
        }
        paramb = a.a(a.d.this.aiWh, paramb, paramav, (List)localObject);
        AppMethodBeat.o(58149);
        return paramb;
      }
    }
    
    public class b
      implements o.c
    {
      private final r aiWl;
      private final ArrayList<A> hXj;
      
      public b()
      {
        AppMethodBeat.i(58153);
        this.aiWl = localObject;
        this.hXj = new ArrayList();
        AppMethodBeat.o(58153);
      }
      
      public final o.a a(kotlin.l.b.a.b.f.b paramb, av paramav)
      {
        AppMethodBeat.i(58151);
        s.u(paramb, "classId");
        s.u(paramav, "source");
        paramb = a.a(a.d.this.aiWh, paramb, paramav, (List)this.hXj);
        AppMethodBeat.o(58151);
        return paramb;
      }
      
      public final void azp()
      {
        AppMethodBeat.i(58152);
        if (!((Collection)this.hXj).isEmpty()) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            ((Map)a.d.this.aiWi).put(this.aiWl, this.hXj);
          }
          AppMethodBeat.o(58152);
          return;
        }
      }
      
      protected final r ksI()
      {
        return this.aiWl;
      }
    }
  }
  
  public static final class e
    implements o.c
  {
    e(a<A, C> parama, ArrayList<A> paramArrayList) {}
    
    public final o.a a(kotlin.l.b.a.b.f.b paramb, av paramav)
    {
      AppMethodBeat.i(58156);
      s.u(paramb, "classId");
      s.u(paramav, "source");
      paramb = a.a(this.aiWh, paramb, paramav, (List)parama);
      AppMethodBeat.o(58156);
      return paramb;
    }
    
    public final void azp() {}
  }
  
  static final class f
    extends u
    implements kotlin.g.a.b<o, a.b<? extends A, ? extends C>>
  {
    f(a<A, C> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.a
 * JD-Core Version:    0.7.0.1
 */