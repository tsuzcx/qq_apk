package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.c.aa;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.w;
import d.l.b.a.b.b.y;
import d.l.b.a.b.b.y.a;
import d.l.b.a.b.m.a.i;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class u
{
  private static final ab JXA;
  private static final ah JXB;
  private static final Set<ah> JXC;
  private static final y JXx;
  private static final a JXy;
  public static final aj JXz;
  
  static
  {
    AppMethodBeat.i(60726);
    JXx = new y()
    {
      public final <R, D> R a(n<R, D> paramAnonymousn, D paramAnonymousD)
      {
        AppMethodBeat.i(60672);
        if (paramAnonymousn == null) {
          adP(10);
        }
        AppMethodBeat.o(60672);
        return null;
      }
      
      public final <T> T a(y.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(60666);
        if (paramAnonymousa == null) {
          adP(0);
        }
        AppMethodBeat.o(60666);
        return null;
      }
      
      public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramAnonymousb, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramAnonymousb1)
      {
        AppMethodBeat.i(60668);
        if (paramAnonymousb == null) {
          adP(2);
        }
        if (paramAnonymousb1 == null) {
          adP(3);
        }
        paramAnonymousb = (List)v.Jgl;
        if (paramAnonymousb == null) {
          adP(4);
        }
        AppMethodBeat.o(60668);
        return paramAnonymousb;
      }
      
      public final boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(60673);
        if (paramAnonymousy == null) {
          adP(11);
        }
        AppMethodBeat.o(60673);
        return false;
      }
      
      public final ad e(d.l.b.a.b.f.b paramAnonymousb)
      {
        AppMethodBeat.i(60670);
        if (paramAnonymousb == null) {
          adP(7);
        }
        paramAnonymousb = new IllegalStateException("Should not be called!");
        AppMethodBeat.o(60670);
        throw paramAnonymousb;
      }
      
      public final d.l.b.a.b.b.a.g fxF()
      {
        AppMethodBeat.i(60667);
        Object localObject = d.l.b.a.b.b.a.g.JrB;
        localObject = g.a.fzI();
        if (localObject == null) {
          adP(1);
        }
        AppMethodBeat.o(60667);
        return localObject;
      }
      
      public final l fxq()
      {
        return null;
      }
      
      public final d.l.b.a.b.f.f fyB()
      {
        AppMethodBeat.i(60669);
        d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.aQE("<ERROR MODULE>");
        AppMethodBeat.o(60669);
        return localf;
      }
      
      public final l fyy()
      {
        AppMethodBeat.i(60674);
        if (this == null) {
          adP(12);
        }
        AppMethodBeat.o(60674);
        return this;
      }
      
      public final d.l.b.a.b.a.g fza()
      {
        AppMethodBeat.i(60675);
        d.l.b.a.b.a.d locald = d.l.b.a.b.a.d.fwU();
        if (locald == null) {
          adP(13);
        }
        AppMethodBeat.o(60675);
        return locald;
      }
      
      public final List<y> fzb()
      {
        AppMethodBeat.i(60671);
        List localList = (List)v.Jgl;
        if (localList == null) {
          adP(9);
        }
        AppMethodBeat.o(60671);
        return localList;
      }
    };
    JXy = new a(d.l.b.a.b.f.f.aQE("<ERROR CLASS>"));
    JXz = aQS("<LOOP IN SUPERTYPES>");
    JXA = aQS("<ERROR PROPERTY TYPE>");
    Object localObject = JXy;
    g.a locala = d.l.b.a.b.b.a.g.JrB;
    localObject = aa.a((l)localObject, g.a.fzI(), w.Jqp, az.JqT, d.l.b.a.b.f.f.aQE("<ERROR PROPERTY>"), b.a.JpV, an.JqJ);
    ((aa)localObject).a(JXA, Collections.emptyList(), null, null);
    JXB = (ah)localObject;
    JXC = Collections.singleton(localObject);
    AppMethodBeat.o(60726);
  }
  
  public static boolean L(l paraml)
  {
    AppMethodBeat.i(60721);
    if (paraml == null)
    {
      AppMethodBeat.o(60721);
      return false;
    }
    if (((paraml instanceof a)) || ((paraml.fxq() instanceof a)) || (paraml == JXx))
    {
      AppMethodBeat.o(60721);
      return true;
    }
    AppMethodBeat.o(60721);
    return false;
  }
  
  public static aj M(String paramString, List<av> paramList)
  {
    AppMethodBeat.i(60718);
    if (paramString == null) {
      adP(11);
    }
    if (paramList == null) {
      adP(12);
    }
    paramString = new t(aQU(paramString), aQR(paramString), paramList, false);
    AppMethodBeat.o(60718);
    return paramString;
  }
  
  public static aj a(String paramString, at paramat)
  {
    AppMethodBeat.i(60717);
    if (paramString == null) {
      adP(9);
    }
    if (paramat == null) {
      adP(10);
    }
    paramString = new t(paramat, aQR(paramString), (byte)0);
    AppMethodBeat.o(60717);
    return paramString;
  }
  
  private static at a(final String paramString, a parama)
  {
    AppMethodBeat.i(60720);
    if (paramString == null) {
      adP(17);
    }
    if (parama == null) {
      adP(18);
    }
    paramString = new at()
    {
      public final d.l.b.a.b.b.h fxM()
      {
        return this.JXD;
      }
      
      public final boolean fxO()
      {
        return false;
      }
      
      public final Collection<ab> fzP()
      {
        AppMethodBeat.i(60678);
        List localList = (List)v.Jgl;
        if (localList == null) {
          adP(1);
        }
        AppMethodBeat.o(60678);
        return localList;
      }
      
      public final d.l.b.a.b.a.g fza()
      {
        AppMethodBeat.i(60679);
        d.l.b.a.b.a.d locald = d.l.b.a.b.a.d.fwU();
        if (locald == null) {
          adP(2);
        }
        AppMethodBeat.o(60679);
        return locald;
      }
      
      public final List<as> getParameters()
      {
        AppMethodBeat.i(60677);
        List localList = (List)v.Jgl;
        if (localList == null) {
          adP(0);
        }
        AppMethodBeat.o(60677);
        return localList;
      }
      
      public final String toString()
      {
        return paramString;
      }
    };
    AppMethodBeat.o(60720);
    return paramString;
  }
  
  public static e aQQ(String paramString)
  {
    AppMethodBeat.i(60712);
    if (paramString == null) {
      adP(1);
    }
    paramString = new a(d.l.b.a.b.f.f.aQE("<ERROR CLASS: " + paramString + ">"));
    AppMethodBeat.o(60712);
    return paramString;
  }
  
  public static d.l.b.a.b.j.f.h aQR(String paramString)
  {
    AppMethodBeat.i(60713);
    if (paramString == null) {
      adP(2);
    }
    paramString = dl(paramString, false);
    AppMethodBeat.o(60713);
    return paramString;
  }
  
  public static aj aQS(String paramString)
  {
    AppMethodBeat.i(60715);
    if (paramString == null) {
      adP(7);
    }
    paramString = M(paramString, Collections.emptyList());
    AppMethodBeat.o(60715);
    return paramString;
  }
  
  public static aj aQT(String paramString)
  {
    AppMethodBeat.i(60716);
    paramString = a(paramString, a(paramString, JXy));
    AppMethodBeat.o(60716);
    return paramString;
  }
  
  public static at aQU(String paramString)
  {
    AppMethodBeat.i(60719);
    if (paramString == null) {
      adP(15);
    }
    paramString = a("[ERROR : " + paramString + "]", JXy);
    AppMethodBeat.o(60719);
    return paramString;
  }
  
  public static boolean al(ab paramab)
  {
    AppMethodBeat.i(60723);
    if ((paramab != null) && ((paramab.fIW() instanceof d)))
    {
      AppMethodBeat.o(60723);
      return true;
    }
    AppMethodBeat.o(60723);
    return false;
  }
  
  public static d.l.b.a.b.j.f.h dl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(60714);
    if (paramString == null) {
      adP(3);
    }
    if (paramBoolean)
    {
      paramString = new u.c(paramString, (byte)0);
      AppMethodBeat.o(60714);
      return paramString;
    }
    paramString = new b(paramString, (byte)0);
    AppMethodBeat.o(60714);
    return paramString;
  }
  
  public static y fJR()
  {
    AppMethodBeat.i(60722);
    y localy = JXx;
    if (localy == null) {
      adP(19);
    }
    AppMethodBeat.o(60722);
    return localy;
  }
  
  static final class a
    extends d.l.b.a.b.b.c.h
  {
    public a(d.l.b.a.b.f.f paramf)
    {
      super(paramf, w.Jqp, d.l.b.a.b.b.f.Jqd, Collections.emptyList(), an.JqJ, d.l.b.a.b.l.b.JWw);
      AppMethodBeat.i(60681);
      paramf = d.l.b.a.b.b.a.g.JrB;
      paramf = d.l.b.a.b.b.c.f.a(this, g.a.fzI(), an.JqJ);
      paramf.a(Collections.emptyList(), az.JqS);
      d.l.b.a.b.j.f.h localh = u.aQR(fyB().qV());
      paramf.J(new t(u.b("<ERROR>", this), localh, (byte)0));
      a(localh, Collections.singleton(paramf), paramf);
      AppMethodBeat.o(60681);
    }
    
    public final d.l.b.a.b.j.f.h a(ay paramay, i parami)
    {
      AppMethodBeat.i(60684);
      if (paramay == null) {
        adP(6);
      }
      if (parami == null) {
        adP(7);
      }
      paramay = u.aQR("Error scope for class " + fyB() + " with arguments: " + paramay);
      if (paramay == null) {
        adP(8);
      }
      AppMethodBeat.o(60684);
      return paramay;
    }
    
    public final e g(ba paramba)
    {
      AppMethodBeat.i(60682);
      if (paramba == null) {
        adP(1);
      }
      AppMethodBeat.o(60682);
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60683);
      String str = fyB().qV();
      AppMethodBeat.o(60683);
      return str;
    }
  }
  
  public static final class b
    implements d.l.b.a.b.j.f.h
  {
    private final String JRK;
    
    private b(String paramString)
    {
      AppMethodBeat.i(60687);
      this.JRK = paramString;
      AppMethodBeat.o(60687);
    }
    
    public final Collection<l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
    {
      AppMethodBeat.i(60691);
      if (paramd == null) {
        adP(16);
      }
      if (paramb == null) {
        adP(17);
      }
      paramd = Collections.emptyList();
      if (paramd == null) {
        adP(18);
      }
      AppMethodBeat.o(60691);
      return paramd;
    }
    
    public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60688);
      if (paramf == null) {
        adP(1);
      }
      if (parama == null) {
        adP(2);
      }
      paramf = u.aQQ(paramf.qV());
      AppMethodBeat.o(60688);
      return paramf;
    }
    
    public final Set<d.l.b.a.b.f.f> fzU()
    {
      AppMethodBeat.i(60689);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        adP(11);
      }
      AppMethodBeat.o(60689);
      return localSet;
    }
    
    public final Set<d.l.b.a.b.f.f> fzV()
    {
      AppMethodBeat.i(60690);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        adP(12);
      }
      AppMethodBeat.o(60690);
      return localSet;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60692);
      String str = "ErrorScope{" + this.JRK + '}';
      AppMethodBeat.o(60692);
      return str;
    }
  }
  
  public static final class d
    implements at
  {
    private final as JXF;
    private final at JXG;
    
    public final as fJS()
    {
      AppMethodBeat.i(60705);
      as localas = this.JXF;
      if (localas == null) {
        adP(1);
      }
      AppMethodBeat.o(60705);
      return localas;
    }
    
    public final d.l.b.a.b.b.h fxM()
    {
      AppMethodBeat.i(60709);
      d.l.b.a.b.b.h localh = this.JXG.fxM();
      AppMethodBeat.o(60709);
      return localh;
    }
    
    public final boolean fxO()
    {
      AppMethodBeat.i(60708);
      boolean bool = this.JXG.fxO();
      AppMethodBeat.o(60708);
      return bool;
    }
    
    public final Collection<ab> fzP()
    {
      AppMethodBeat.i(60707);
      Collection localCollection = this.JXG.fzP();
      if (localCollection == null) {
        adP(3);
      }
      AppMethodBeat.o(60707);
      return localCollection;
    }
    
    public final d.l.b.a.b.a.g fza()
    {
      AppMethodBeat.i(60710);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G(this.JXF);
      if (localg == null) {
        adP(4);
      }
      AppMethodBeat.o(60710);
      return localg;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(60706);
      List localList = this.JXG.getParameters();
      if (localList == null) {
        adP(2);
      }
      AppMethodBeat.o(60706);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.u
 * JD-Core Version:    0.7.0.1
 */